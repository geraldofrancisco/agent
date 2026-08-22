package com.thor.agent.domain.exception;

import com.thor.agent.domain.response.exception.ExceptionResponse;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Hidden
@RestControllerAdvice
@RequiredArgsConstructor
public class ProjectExceptionHandler {

  private final MessageSource messageSource;

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResponse> handlerException(Exception ex) {

  }

  private String getMessage(String error) {
    return messageSource.getMessage(error, null, Locale.getDefault());
  }
}
