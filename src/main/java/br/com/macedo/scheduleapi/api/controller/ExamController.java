package br.com.macedo.scheduleapi.api.controller;

import br.com.macedo.scheduleapi.api.dto.commons.ExamDTO;
import br.com.macedo.scheduleapi.api.dto.request.ExamRequestDTO;
import br.com.macedo.scheduleapi.api.mapper.MapperApi;
import br.com.macedo.scheduleapi.application.service.ExamService;
import br.com.macedo.scheduleapi.domain.exception.ExceptionResponse;
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
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response insert(@RequestBody ExamRequestDTO exam) {

        var examVO = examService.insert(mapperApi.toExamVO(exam));
        return Response.ok().entity(mapperApi.toExamDTO(examVO)).build();

    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = String.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response delete(@PathParam("id") Long id) {

        examService.delete(id);
        return Response.ok().entity("Exam successfully deleted").build();

    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ExamDTO.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response update(@RequestBody ExamDTO exam) {

        var examVo = examService.update(mapperApi.toExamVO(exam));
        return Response.ok().entity(mapperApi.toExamDTO(examVo)).build();

    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ExamDTO.class),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response get(@PathParam("id") Long id) {

        var examVO = examService.getById(id);
        return Response.ok().entity(mapperApi.toExamDTO(examVO)).build();

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ExamDTO.class,
            responseContainer = "List"),
            @ApiResponse(code = 204, message = "Not Content"),
            @ApiResponse(code = 400, message = "Bad Request", response = ExceptionResponse.class)})
    public Response getAll() {

        var lstExam = examService.get();
        return Response.ok().entity(mapperApi.toListExamDTO(lstExam)).build();

    }


}
