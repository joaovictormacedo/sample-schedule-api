package br.com.macedo.scheduleapi.mapper;

import br.com.macedo.scheduleapi.domain.entities.Room;
import br.com.macedo.scheduleapi.domain.vo.RoomVO;
import org.mapstruct.Mapper;

@Mapper
public interface EntitiesMapper {

    Room toRoom(RoomVO r);
    RoomVO toRoomVo(Room r);

}
