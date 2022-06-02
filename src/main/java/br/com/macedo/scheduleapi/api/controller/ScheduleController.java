package br.com.macedo.scheduleapi.api.controller;


import br.com.macedo.scheduleapi.api.dto.commons.ScheduleDTO;
import br.com.macedo.scheduleapi.api.dto.request.ScheduleRequestDTO;
import br.com.macedo.scheduleapi.api.mapper.MapperApi;
import br.com.macedo.scheduleapi.application.service.ScheduleService;
import br.com.macedo.scheduleapi.domain.exception.ClientException;
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
            @ApiResponse(code = 400, message = "Bad Request", response = String.class)})
    public Response insert(@RequestBody ScheduleRequestDTO schedule) {

        try {
            var availabilityVO = scheduleService.insert(mapperApi.toScheduleVO(schedule));
            return Response.ok().entity(mapperApi.toScheduleDTO(availabilityVO)).build();
        } catch (ClientException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity(e.getMessage()).build();
        }

    }

}
