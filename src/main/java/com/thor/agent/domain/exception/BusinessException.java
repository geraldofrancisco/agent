package com.thor.agent.domain.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends ProjectException {

  public BusinessException(String message) {
    super(message, HttpStatus.UNPROCESSABLE_CONTENT, null);
  }
}
