package br.com.macedo.scheduleapi.domain.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ClientException extends RuntimeException {

    protected final String message;

    public ClientException(Throwable cause) {
        super(cause);
        this.message = cause.getMessage();
    }

}
