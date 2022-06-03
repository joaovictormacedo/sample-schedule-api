package br.com.macedo.scheduleapi.application.service.impl;

import br.com.macedo.scheduleapi.application.service.ScheduleService;
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

        var candidate = candidateRepository.findById(s.getCandidate().getId()).orElseThrow(
                () -> new ClientException(new Exception("Candidate not found"))
        );

        var room = roomRepository.findById(s.getRoom().getNumber()).orElseThrow(
                () -> new ClientException(new Exception("Room not found"))
        );

        var exam = examRepository.findById(s.getExam().getId()).orElseThrow(
                () -> new ClientException(new Exception("Exam not found"))
        );

        //find availability by date
        var lstAvailability = availabilityRepository.findByRoomAndDate(room, s.getDate());

        if (lstAvailability.isEmpty()) {
            throw new ClientException(new Exception("Availability not available"));
        }

        var availability = lstAvailability.stream().findFirst().get();

        if (availability.getCandidate() != null) {
            throw new ClientException(new Exception("Availability not available"));
        }

        availability.setExam(exam);
        availability.setCandidate(candidate);

        return entitiesMapper.toScheduleVO(availabilityRepository.save(availability));

    }

    @Override
    @Transactional
    public void delete(Long id) {

        var availability = availabilityRepository.findById(id).orElseThrow(() ->
                new ClientException(new Exception("Schedule not found")));

        availability.setCandidate(null);
        availability.setExam(null);

        availabilityRepository.save(availability);
    }

    @Override
    public ScheduleVO getById(Long id) {
        var availability = availabilityRepository.findById(id).orElseThrow(() ->
                new ClientException(new Exception("Schedule not found")));

        return entitiesMapper.toScheduleVO(availability);
    }

    @Override
    public List<ScheduleVO> get() {
        return entitiesMapper.toListScheduleVO(availabilityRepository.findAll());
    }
}
