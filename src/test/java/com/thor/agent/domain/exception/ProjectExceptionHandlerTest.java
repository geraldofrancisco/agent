package com.thor.agent.domain.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.thor.agent.domain.response.exception.ExceptionResponse;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

class ProjectExceptionHandlerTest {

  private final MessageSource messageSource = mock(MessageSource.class);
  private final ProjectExceptionHandler handler = new ProjectExceptionHandler(messageSource);

  @Test
  void handlesUnexpectedException() {
    when(messageSource.getMessage("PROJECT_GENERIC_EXCEPTION", null, Locale.getDefault()))
        .thenReturn("unexpected");

    var response = handler.handlerException(new IllegalStateException("failure"));

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    assertEquals("unexpected", response.getBody().getErrorDescription());
  }

  @Test
  void handlesProjectExceptionAndUsesCauseWhenPresent() {
    var cause = new IllegalArgumentException("cause");
    var exception = new GenericProjectException(cause);
    when(messageSource.getMessage(exception.getMessage(), null, Locale.getDefault()))
        .thenReturn("translated");

    var response = handler.handlerProjectException(exception);

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    assertEquals("translated", response.getBody().getErrorDescription());
    assertSame(cause, exception.getE());
  }

  @Test
  void handlesValidationErrors() {
    var exception = mock(MethodArgumentNotValidException.class);
    var bindingResult = mock(BindingResult.class);
    var fieldError = new FieldError("request", "question", "QUEST_CREATION_REQUEST_QUESTION_NOT_BLANK_ERROR");
    when(exception.getBindingResult()).thenReturn(bindingResult);
    when(bindingResult.getFieldErrors()).thenReturn(List.of(fieldError));
    when(messageSource.getMessage(fieldError.getDefaultMessage(), null, Locale.getDefault()))
        .thenReturn("required");

    var response = handler.handlerMethodArgumentNotValidException(exception);

    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    assertEquals("question", response.getBody().getFields().getFirst().getName());
    assertEquals("required", response.getBody().getFields().getFirst().getMessage());
  }
}
