package br.com.macedo.scheduleapi.api.controller;

import br.com.macedo.scheduleapi.api.dto.commons.CandidateDTO;
import br.com.macedo.scheduleapi.api.dto.request.CandidateRequestDTO;
import br.com.macedo.scheduleapi.api.mapper.MapperApi;
import br.com.macedo.scheduleapi.application.service.CandidateService;
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
            @ApiResponse(code = 204, message = "Not Content")})
    public Response insert(@RequestBody CandidateRequestDTO candidate) {

        var candidateVO = candidateService.insert(mapperApi.toCandidateVO(candidate));
        return Response.ok().entity(mapperApi.toCandidateDTO(candidateVO)).build();

    }

}
