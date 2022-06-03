package br.com.macedo.scheduleapi.api.config;

import br.com.macedo.scheduleapi.domain.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.LocalDateTime;

@Provider
public class ExceptionHandle implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception throwable) {

        var message = ExceptionResponse.builder()
                .message(throwable.getMessage())
                .code(HttpStatus.BAD_REQUEST.value())
                .date(LocalDateTime.now())
                .build();

        return Response.status(message.getCode()).entity(message).type(MediaType.APPLICATION_JSON).build();
    }


}
