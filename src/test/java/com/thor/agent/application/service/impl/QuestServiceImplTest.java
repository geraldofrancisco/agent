package com.thor.agent.application.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.thor.agent.domain.dto.LLMDTO;
import com.thor.agent.domain.exception.GenericProjectException;
import com.thor.agent.domain.repository.LLMRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;

class QuestServiceImplTest {

  private final ChatClient chatClient = mock(ChatClient.class, RETURNS_DEEP_STUBS);
  private final LLMRepository repository = mock(LLMRepository.class);
  private final QuestServiceImpl service = new QuestServiceImpl(chatClient, repository);

  @BeforeEach
  void resetMocks() {
    org.mockito.Mockito.reset(chatClient, repository);
  }

  @Test
  void createsAndSavesResponse() {
    var response = mock(ChatResponse.class, RETURNS_DEEP_STUBS);
    var expected = LLMDTO.builder().request("question").response("answer").build();
    when(chatClient.prompt().user("question").call().chatResponse()).thenReturn(response);
    when(response.getMetadata().getUsage().getPromptTokens()).thenReturn(2);
    when(response.getMetadata().getUsage().getCompletionTokens()).thenReturn(3);
    when(response.getMetadata().getUsage().getTotalTokens()).thenReturn(5);
    when(response.getResult().getOutput().getText()).thenReturn("answer");
    when(repository.save(org.mockito.ArgumentMatchers.any(LLMDTO.class))).thenReturn(expected);

    var result = service.create("question");

    assertSame(expected, result);
    assertEquals("question", result.getRequest());
  }

  @Test
  void wrapsMissingChatResponseAsGenericException() {
    when(chatClient.prompt().user("question").call().chatResponse()).thenReturn(null);

    var exception = assertThrows(GenericProjectException.class, () -> service.create("question"));

    assertNotNull(exception.getE());
    assertEquals("QUEST_CREATION_NOT_RESPONSE_EXCEPTION", exception.getE().getMessage());
  }

  @Test
  void wrapsChatClientFailuresAsGenericException() {
    var cause = new IllegalStateException("chat unavailable");
    when(chatClient.prompt().user("question").call().chatResponse()).thenThrow(cause);

    var exception = assertThrows(GenericProjectException.class, () -> service.create("question"));

    assertSame(cause, exception.getE());
  }
}
