package br.com.macedo.scheduleapi.api.controller;

import br.com.macedo.scheduleapi.api.dto.commons.AvailabilityDTO;
import br.com.macedo.scheduleapi.api.dto.request.AvailabilityRequestDTO;
import br.com.macedo.scheduleapi.api.mapper.MapperApi;
import br.com.macedo.scheduleapi.application.service.AvailabilityService;
import br.com.macedo.scheduleapi.domain.exception.ExceptionResponse;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
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
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response insert(@RequestBody AvailabilityRequestDTO availability) {

        var availabilityVO = availabilityService.insert(mapperApi.toAvailabilityVO(availability));
        return Response.ok().entity(mapperApi.toAvailabilityDTO(availabilityVO)).build();

    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = String.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response delete(@PathParam("id") Long id) {

        availabilityService.delete(id);
        return Response.ok().entity("Availability successfully deleted").build();

    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = AvailabilityDTO.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response update(@RequestBody AvailabilityDTO availability) {

        var availabilityVO = availabilityService.update(mapperApi.toAvailabilityVO(availability));
        return Response.ok().entity(mapperApi.toAvailabilityDTO(availabilityVO)).build();

    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = AvailabilityDTO.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response get(@PathParam("id") Long id) {

        var availabilityVO = availabilityService.getById(id);
        return Response.ok().entity(mapperApi.toAvailabilityDTO(availabilityVO)).build();

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = AvailabilityDTO.class,
            responseContainer = "List"),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response getAll() {

        var lstAvailabilityVO = availabilityService.getAll();
        return Response.ok().entity(mapperApi.toListAvailabilityDTO(lstAvailabilityVO)).build();

    }


}
