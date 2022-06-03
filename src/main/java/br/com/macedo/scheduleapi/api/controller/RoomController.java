package br.com.macedo.scheduleapi.api.controller;


import br.com.macedo.scheduleapi.api.dto.commons.RoomDTO;
import br.com.macedo.scheduleapi.api.dto.request.RoomRequestDTO;
import br.com.macedo.scheduleapi.api.mapper.MapperApi;
import br.com.macedo.scheduleapi.application.service.RoomService;
import br.com.macedo.scheduleapi.domain.exception.ExceptionResponse;
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
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response insert(@RequestBody RoomRequestDTO room) {

        var roomVO = roomService.insert(mapperApi.toRoomVO(room));
        return Response.ok().entity(mapperApi.toRoomDTO(roomVO)).build();

    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = String.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response delete(@PathParam("id") Integer id) {

        roomService.delete(id);
        return Response.ok().entity("room successfully deleted").build();

    }




    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = RoomDTO.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response get(@PathParam("id") Integer id) {

        var roomVo = roomService.getById(id);
        return Response.ok().entity(mapperApi.toRoomDTO(roomVo)).build();

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = RoomDTO.class,
            responseContainer = "List"),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response getAll() {

        var lstRoom = roomService.get();
        return Response.ok().entity(mapperApi.toListRoomDTO(lstRoom)).build();
     
    }

}
