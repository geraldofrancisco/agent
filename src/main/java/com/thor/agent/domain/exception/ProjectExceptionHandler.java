package com.thor.agent.domain.exception;

import static com.thor.agent.domain.constants.ProjectConstants.PROJECT_GENERIC_EXCEPTION;

import com.thor.agent.domain.mapper.ExceptionMapper;
import com.thor.agent.domain.response.exception.ExceptionResponse;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.Locale;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
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
    var message = getMessage(PROJECT_GENERIC_EXCEPTION);
    log.error(message, ex);
    return ExceptionMapper.toResponse(HttpStatus.INTERNAL_SERVER_ERROR, message);
  }

  @ExceptionHandler(ProjectException.class)
  public ResponseEntity<ExceptionResponse> handlerProjectException(ProjectException ex) {
    var message = getMessage(ex.getMessage());
    log.info(message, Objects.requireNonNullElse(ex.getE(), ex));
    return ExceptionMapper.toResponse(ex.getStatus(), message);
  }

  private String getMessage(String error) {
    return messageSource.getMessage(error, null, Locale.getDefault());
  }
}
