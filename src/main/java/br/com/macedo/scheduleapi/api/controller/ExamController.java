package br.com.macedo.scheduleapi.api.controller;

import br.com.macedo.scheduleapi.api.dto.commons.ExamDTO;
import br.com.macedo.scheduleapi.api.dto.request.ExamRequestDTO;
import br.com.macedo.scheduleapi.api.mapper.MapperApi;
import br.com.macedo.scheduleapi.application.service.ExamService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/exam")
@ApplicationPath("/api")
@Api(value = "Exam", authorizations = {@Authorization(value = "basicAuth")})
@ApiOperation("")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private MapperApi mapperApi;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ExamDTO.class),
            @ApiResponse(code = 204, message = "Not Content")})
    public Response insert(@RequestBody ExamRequestDTO exam) {

        var examVO = examService.insert(mapperApi.toExamVO(exam));
        return Response.ok().entity(mapperApi.toExamDTO(examVO)).build();

    }

}
