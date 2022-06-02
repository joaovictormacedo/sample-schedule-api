package br.com.macedo.scheduleapi.api.mapper;


import br.com.macedo.scheduleapi.api.dto.commons.RoomDTO;
import br.com.macedo.scheduleapi.api.dto.request.room.RoomInsertDTO;
import br.com.macedo.scheduleapi.domain.vo.RoomVO;
import org.mapstruct.Mapper;

@Mapper
public interface MapperApi {

    /* Rooms */
    RoomVO toRoomVO(RoomInsertDTO r);
    RoomDTO toRoomDTO(RoomVO r);


    /* Exam */


    /* Candidate */


    /* Availability */

}
