package com.thor.agent.domain.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.thor.agent.domain.document.LLMDocument;
import com.thor.agent.domain.dto.LLMDTO;
import java.time.LocalDateTime;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.ChatResponse;

class LLMMapperTest {

  @Test
  void mapsDtoToDocumentAndBack() {
    var id = new ObjectId();
    var created = LocalDateTime.of(2025, 1, 2, 3, 4);
    var dto = LLMDTO.builder()
        .id(id)
        .timestampCreatedDate(created)
        .request("question")
        .response("answer")
        .requestTokens(2)
        .responseTokens(3)
        .totalTokens(5)
        .build();

    LLMDocument document = LLMMapper.toDocument(dto);
    LLMDTO mapped = LLMMapper.toDTO(document);

    assertEquals(id, document.getId());
    assertEquals(created, document.getTimestampCreatedDate());
    assertEquals("question", document.getRequest());
    assertEquals("answer", document.getResponse());
    assertEquals(2, document.getRequestTokens());
    assertEquals(3, document.getResponseTokens());
    assertEquals(5, document.getTotalTokens());
    assertEquals(dto, mapped);
  }

  @Test
  void mapsChatResponseUsageAndTextToDto() {
    ChatResponse response = mock(ChatResponse.class, RETURNS_DEEP_STUBS);
    when(response.getMetadata().getUsage().getPromptTokens()).thenReturn(2);
    when(response.getMetadata().getUsage().getCompletionTokens()).thenReturn(3);
    when(response.getMetadata().getUsage().getTotalTokens()).thenReturn(5);
    when(response.getResult().getOutput().getText()).thenReturn("answer");

    LLMDTO dto = LLMMapper.toCreate("question", response);

    assertEquals("question", dto.getRequest());
    assertEquals("answer", dto.getResponse());
    assertEquals(2, dto.getRequestTokens());
    assertEquals(3, dto.getResponseTokens());
    assertEquals(5, dto.getTotalTokens());
    org.junit.jupiter.api.Assertions.assertNotNull(dto.getId());
    org.junit.jupiter.api.Assertions.assertNotNull(dto.getTimestampCreatedDate());
  }
}
