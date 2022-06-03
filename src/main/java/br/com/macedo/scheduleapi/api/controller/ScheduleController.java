package br.com.macedo.scheduleapi.api.controller;


import br.com.macedo.scheduleapi.api.dto.commons.ScheduleDTO;
import br.com.macedo.scheduleapi.api.dto.request.ScheduleRequestDTO;
import br.com.macedo.scheduleapi.api.mapper.MapperApi;
import br.com.macedo.scheduleapi.application.service.ScheduleService;
import br.com.macedo.scheduleapi.domain.exception.ClientException;
import br.com.macedo.scheduleapi.domain.exception.ExceptionResponse;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/schedule")
@ApplicationPath("/api")
@Api(value = "Schedule", authorizations = {@Authorization(value = "basicAuth")})
@ApiOperation("")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private MapperApi mapperApi;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ScheduleDTO.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response insert(@RequestBody ScheduleRequestDTO schedule) throws ClientException {

        try {
            var availabilityVO = scheduleService.insert(mapperApi.toScheduleVO(schedule));
            return Response.ok().entity(mapperApi.toScheduleDTO(availabilityVO)).build();
        } catch (ClientException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity(e.getMessage()).build();
        }

    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = String.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class)})
    public Response delete(@PathParam("id") Long id) {

        try {
            scheduleService.delete(id);
            return Response.ok().entity("schedule successfully deleted").build();
        } catch (ClientException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity(e.getMessage()).build();
        }

    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ScheduleDTO.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class)})
    public Response get(@PathParam("id") Long id) {
        try {
            var scheduleVO = scheduleService.getById(id);
            return Response.ok().entity(mapperApi.toScheduleDTO(scheduleVO)).build();
        } catch (ClientException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity(e.getMessage()).build();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ScheduleDTO.class,
            responseContainer = "List"),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class)})
    public Response getAll() {
        try {
            var lstSchedule = scheduleService.get();
            return Response.ok().entity(mapperApi.toListscheduleDTO(lstSchedule)).build();
        } catch (ClientException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity(e.getMessage()).build();
        }
    }

}
