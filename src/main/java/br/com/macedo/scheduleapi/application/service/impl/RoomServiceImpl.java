package br.com.macedo.scheduleapi.application.service.impl;

import br.com.macedo.scheduleapi.application.service.RoomService;
import br.com.macedo.scheduleapi.domain.vo.RoomVO;
import br.com.macedo.scheduleapi.mapper.EntitiesMapper;
import br.com.macedo.scheduleapi.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    private EntitiesMapper entitiesMapper;

    @Override
    public RoomVO insert(RoomVO room) {
        return entitiesMapper.toRoomVo(
                roomRepository.save(entitiesMapper.toRoom(room))
        );
    }
}
