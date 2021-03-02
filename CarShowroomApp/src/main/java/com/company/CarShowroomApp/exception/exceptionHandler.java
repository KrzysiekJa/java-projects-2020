package com.company.CarShowroomApp.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@ControllerAdvice
public class exceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoResultException.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleJsonMappingException(JsonMappingException ex) {
        return "error 400";
    }
}
