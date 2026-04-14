package com.jdev.dspagamentokafka.exceptions.handler;

import com.jdev.dspagamentokafka.exceptions.RegraValidacaoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(RegraValidacaoException.class)
    public ResponseEntity<ApiError> regraValidacao(RegraValidacaoException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiError error = new ApiError(Instant.now(), httpStatus.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(httpStatus).body(error);
    }
}
