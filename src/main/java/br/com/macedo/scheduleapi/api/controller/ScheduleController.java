package br.com.macedo.scheduleapi.api.controller;

import br.com.macedo.scheduleapi.api.dto.commons.AvailabilityDTO;
import br.com.macedo.scheduleapi.api.dto.commons.ExamDTO;
import br.com.macedo.scheduleapi.api.dto.commons.RoomDTO;
import br.com.macedo.scheduleapi.api.dto.request.room.RoomInsertDTO;
import br.com.macedo.scheduleapi.api.mapper.MapperApi;
import br.com.macedo.scheduleapi.application.service.RoomService;
import br.com.macedo.scheduleapi.application.service.ScheduleService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;

@Path("/schedule")
@ApplicationPath("/api")
@Api(value = "/api/schedule", authorizations = {@Authorization(value="basicAuth")})
@ApiOperation("Operações para agendamento de exame")
public class ScheduleController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private MapperApi mapperApi;


    /** Room **/

    @POST
    @Path("/room")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertRoom(@RequestBody RoomInsertDTO room){

        var roomVO = roomService.insert(mapperApi.toRoomVO(room));
        return Response.ok().entity(mapperApi.toRoomDTO(roomVO)).build();

    }



}
