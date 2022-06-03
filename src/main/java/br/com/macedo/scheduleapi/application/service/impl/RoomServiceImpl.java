package br.com.macedo.scheduleapi.application.service.impl;

import br.com.macedo.scheduleapi.application.service.RoomService;
import br.com.macedo.scheduleapi.domain.exception.ClientException;
import br.com.macedo.scheduleapi.domain.vo.RoomVO;
import br.com.macedo.scheduleapi.mapper.EntitiesMapper;
import br.com.macedo.scheduleapi.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void delete(Integer id) {
        try {
            roomRepository.deleteById(id);
        }catch (Exception e){
            throw new ClientException(new Exception("Fail to delete room "+id));
        }
    }

    @Override
    public RoomVO getById(Integer id) {

        var room = roomRepository.findById(id).orElseThrow(()->
            new ClientException(new Exception("Room not found"))
        );

        return entitiesMapper.toRoomVo(room);
    }

    @Override
    public List<RoomVO> get() {
        return entitiesMapper.toListRoomVO(roomRepository.findAll());
    }
}
