package com.thor.agent.adapters.inbound.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.thor.agent.application.service.QuestService;
import com.thor.agent.domain.dto.LLMDTO;
import com.thor.agent.domain.request.QuestCreationRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class QuestionControllerTest {

  @Mock private QuestService service;
  @InjectMocks private QuestionController controller;

  @Test
  void sendsQuestionAndMapsServiceResponse() {
    when(service.create("question")).thenReturn(LLMDTO.builder().response("answer").build());

    var response = controller.sendQuestion(new QuestCreationRequest("question"));

    assertEquals("answer", response.getData());
    verify(service).create("question");
  }
}
