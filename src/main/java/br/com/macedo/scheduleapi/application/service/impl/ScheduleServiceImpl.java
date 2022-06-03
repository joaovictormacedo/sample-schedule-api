package br.com.macedo.scheduleapi.application.service.impl;

import br.com.macedo.scheduleapi.application.service.ScheduleService;
import br.com.macedo.scheduleapi.domain.entities.Candidate;
import br.com.macedo.scheduleapi.domain.entities.Exam;
import br.com.macedo.scheduleapi.domain.entities.Room;
import br.com.macedo.scheduleapi.domain.exception.ClientException;
import br.com.macedo.scheduleapi.domain.vo.ScheduleVO;
import br.com.macedo.scheduleapi.mapper.EntitiesMapper;
import br.com.macedo.scheduleapi.repository.AvailabilityRepository;
import br.com.macedo.scheduleapi.repository.CandidateRepository;
import br.com.macedo.scheduleapi.repository.ExamRepository;
import br.com.macedo.scheduleapi.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {


    private CandidateRepository candidateRepository;

    private RoomRepository roomRepository;

    private ExamRepository examRepository;

    private AvailabilityRepository availabilityRepository;

    private EntitiesMapper entitiesMapper;

    @Override
    @Transactional
    public ScheduleVO insert(ScheduleVO s) {

        var availability = availabilityRepository.findByRoomAndDate(findRoom(s), s.getDate()).orElseThrow(
                () -> new ClientException("Availability not available")
        );

        if (availability.getCandidate() != null) {
            throw new ClientException("Availability not available");
        }

        availability.setExam(findExam(s));
        availability.setCandidate(findCandidate(s));

        return entitiesMapper.toScheduleVO(availabilityRepository.save(availability));

    }

    private Exam findExam(ScheduleVO s) {

        var exam = Optional.ofNullable(s.getExam()).orElseThrow(() ->
                new ClientException("Exam is null"));

        return examRepository.findById(exam.getId()).orElseThrow(
                () -> new ClientException("Exam not found")
        );
    }

    private Room findRoom(ScheduleVO s) {

        var room = Optional.ofNullable(s.getRoom()).orElseThrow(() ->
                new ClientException("Room is null"));

        return roomRepository.findById(room.getNumber()).orElseThrow(
                () -> new ClientException("Room not found")
        );

    }

    private Candidate findCandidate(ScheduleVO s) {

        var candidate = Optional.ofNullable(s.getCandidate()).orElseThrow(() ->
                new ClientException("Candidate is null"));

        return candidateRepository.findById(candidate.getId()).orElseThrow(
                () -> new ClientException("Candidate not found")
        );

    }


    @Override
    @Transactional
    public void delete(Long id) {

        var availability = availabilityRepository.findById(id).orElseThrow(() ->
                new ClientException("Schedule not found"));

        availability.setCandidate(null);
        availability.setExam(null);

        availabilityRepository.save(availability);
    }

    @Override
    public ScheduleVO getById(Long id) {
        var availability = availabilityRepository.findById(id).orElseThrow(() ->
                new ClientException("Schedule not found"));

        return entitiesMapper.toScheduleVO(availability);
    }

    @Override
    public List<ScheduleVO> get() {
        return entitiesMapper.toListScheduleVO(availabilityRepository.findAll());
    }
}
