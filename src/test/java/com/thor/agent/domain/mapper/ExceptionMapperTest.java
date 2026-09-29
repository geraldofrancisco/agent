package com.thor.agent.domain.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.thor.agent.domain.response.exception.ExceptionFieldResponse;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ExceptionMapperTest {

  @Test
  void mapsStatusAndMessage() {
    var response = ExceptionMapper.toResponse(HttpStatus.BAD_REQUEST, "invalid");

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertEquals("invalid", response.getBody().getErrorDescription());
    assertNull(response.getBody().getFields());
    assertEquals(HttpStatus.BAD_REQUEST.value(), response.getBody().getStatus());
  }

  @Test
  void mapsStatusAndFieldErrors() {
    var fields = List.of(ExceptionFieldResponse.builder().name("question").message("required").build());

    var response = ExceptionMapper.toResponse(HttpStatus.UNPROCESSABLE_CONTENT, fields);

    assertEquals(HttpStatus.UNPROCESSABLE_CONTENT, response.getStatusCode());
    assertNull(response.getBody().getErrorDescription());
    assertEquals(fields, response.getBody().getFields());
  }
}
