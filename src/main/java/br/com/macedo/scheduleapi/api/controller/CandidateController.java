package br.com.macedo.scheduleapi.api.controller;

import br.com.macedo.scheduleapi.api.dto.commons.CandidateDTO;
import br.com.macedo.scheduleapi.api.dto.request.CandidateRequestDTO;
import br.com.macedo.scheduleapi.api.mapper.MapperApi;
import br.com.macedo.scheduleapi.application.service.CandidateService;
import br.com.macedo.scheduleapi.domain.exception.ExceptionResponse;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/candidate")
@ApplicationPath("/api")
@Api(value = "Candidate", authorizations = {@Authorization(value = "basicAuth")})
@ApiOperation("")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private MapperApi mapperApi;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = CandidateDTO.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response insert(@RequestBody CandidateRequestDTO candidate) {

        var candidateVO = candidateService.insert(mapperApi.toCandidateVO(candidate));
        return Response.ok().entity(mapperApi.toCandidateDTO(candidateVO)).build();

    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = String.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response delete(@PathParam("id") Long id) {

        candidateService.delete(id);
        return Response.ok().entity("Candidate successfully deleted").build();

    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = CandidateDTO.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response update(@RequestBody CandidateDTO candidate) {

        var candidateVO = candidateService.update(mapperApi.toCandidateVO(candidate));
        return Response.ok().entity(mapperApi.toCandidateDTO(candidateVO)).build();

    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = CandidateDTO.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response get(@PathParam("id") Long id) {

        var candidateVO = candidateService.getById(id);
        return Response.ok().entity(mapperApi.toCandidateDTO(candidateVO)).build();

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = CandidateDTO.class,
            responseContainer = "List"),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response getAll() {

        var lstCandidate = candidateService.get();
        return Response.ok().entity(mapperApi.toListCandidateDTO(lstCandidate)).build();

    }


}
