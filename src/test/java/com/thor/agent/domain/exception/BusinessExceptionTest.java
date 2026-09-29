package com.thor.agent.domain.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class BusinessExceptionTest {

  @Test
  void configuresBusinessExceptionStatus() {
    var exception = new BusinessException("business error");

    assertEquals("business error", exception.getMessage());
    assertEquals(HttpStatus.UNPROCESSABLE_CONTENT, exception.getStatus());
    assertNull(exception.getE());
  }
}
