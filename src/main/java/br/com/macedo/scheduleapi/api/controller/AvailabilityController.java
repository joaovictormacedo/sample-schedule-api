package br.com.macedo.scheduleapi.api.controller;

import br.com.macedo.scheduleapi.api.dto.commons.AvailabilityDTO;
import br.com.macedo.scheduleapi.api.dto.request.AvailabilityRequestDTO;
import br.com.macedo.scheduleapi.api.mapper.MapperApi;
import br.com.macedo.scheduleapi.application.service.AvailabilityService;
import br.com.macedo.scheduleapi.domain.exception.ClientException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/availability")
@ApplicationPath("/api")
@Api(value = "Availability", authorizations = {@Authorization(value = "basicAuth")})
@ApiOperation("")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private MapperApi mapperApi;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = AvailabilityDTO.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class)})
    public Response insert(@RequestBody AvailabilityRequestDTO availability) {

        try {
            var availabilityVO = availabilityService.insert(mapperApi.toAvailabilityVO(availability));
            return Response.ok().entity(mapperApi.toAvailabilityDTO(availabilityVO)).build();
        } catch (ClientException e) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).entity(e.getMessage()).build();
        }

    }

}
