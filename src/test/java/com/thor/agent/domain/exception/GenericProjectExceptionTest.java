package com.thor.agent.domain.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class GenericProjectExceptionTest {

  @Test
  void retainsCauseAndUsesGenericErrorDetails() {
    var cause = new IllegalStateException("failure");
    var exception = new GenericProjectException(cause);

    assertEquals("PROJECT_GENERIC_EXCEPTION", exception.getMessage());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatus());
    assertSame(cause, exception.getE());
  }
}
