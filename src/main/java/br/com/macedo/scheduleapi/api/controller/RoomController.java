package br.com.macedo.scheduleapi.api.controller;


import br.com.macedo.scheduleapi.api.dto.commons.RoomDTO;
import br.com.macedo.scheduleapi.api.dto.request.RoomRequestDTO;
import br.com.macedo.scheduleapi.api.mapper.MapperApi;
import br.com.macedo.scheduleapi.application.service.RoomService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/room")
@ApplicationPath("/api")
@Api(value = "Room", authorizations = {@Authorization(value = "basicAuth")})
@ApiOperation("")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private MapperApi mapperApi;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = RoomDTO.class),
            @ApiResponse(code = 204, message = "Not Content")})
    public Response insert(@RequestBody RoomRequestDTO room) {

        var roomVO = roomService.insert(mapperApi.toRoomVO(room));
        return Response.ok().entity(mapperApi.toRoomDTO(roomVO)).build();

    }

}
