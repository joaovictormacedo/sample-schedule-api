package br.com.macedo.scheduleapi.domain.exception;

import lombok.Getter;
import lombok.ToString;

import javax.ws.rs.WebApplicationException;

@Getter
@ToString
public class ClientException extends WebApplicationException {

    protected final String message;

    public ClientException(Throwable cause) {
        super(cause);
        this.message = cause.getMessage();
    }

}
