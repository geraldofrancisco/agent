package com.thor.agent.domain.exception;

import static com.thor.agent.domain.constants.ProjectConstants.PROJECT_GENERIC_EXCEPTION;

import org.springframework.http.HttpStatus;

public class GenericProjectException extends ProjectException {

  public GenericProjectException(Exception exception) {
    super(PROJECT_GENERIC_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR, exception);
  }
}
