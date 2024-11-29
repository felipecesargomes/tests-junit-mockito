package br.com.felipecesar.tests_junit_mockito.exceptions;

import org.springframework.http.HttpStatusCode;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;
    private String error;
    private String message;
    private Date timestamp;

    public ExceptionResponse(int status, String error, String message, Date timestamp) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

}
