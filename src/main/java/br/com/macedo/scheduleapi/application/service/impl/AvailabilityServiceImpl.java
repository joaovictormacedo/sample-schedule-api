package br.com.macedo.scheduleapi.application.service.impl;

import br.com.macedo.scheduleapi.application.service.AvailabilityService;
import br.com.macedo.scheduleapi.domain.exception.ClientException;
import br.com.macedo.scheduleapi.domain.vo.AvailabilityVO;
import br.com.macedo.scheduleapi.mapper.EntitiesMapper;
import br.com.macedo.scheduleapi.repository.AvailabilityRepository;
import br.com.macedo.scheduleapi.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class AvailabilityServiceImpl implements AvailabilityService {

    private AvailabilityRepository availabilityRepository;

    private RoomRepository roomRepository;

    private EntitiesMapper entitiesMapper;

    @Override
    @Transactional
    public AvailabilityVO insert(AvailabilityVO a) {

        a.setCandidate(null);
        a.setExam(null);

        var room = roomRepository.findById(a.getRoom().getNumber()).orElseThrow(() ->
                new ClientException(new Exception("Room not found")));

        a.setRoom(entitiesMapper.toRoomVo(room));

        var check = availabilityRepository.findByRoomAndDate(room, a.getDate());

        if (!check.isEmpty()) {
            throw new ClientException(new Exception("Schedule exists"));
        }

        return entitiesMapper.toAvailabilityVO(availabilityRepository.save(entitiesMapper.toAvailability(a)));

    }
}
