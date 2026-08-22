package com.thor.agent.domain.mapper;

import com.thor.agent.domain.document.LLMDocument;
import com.thor.agent.domain.dto.LLMDTO;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.model.ChatResponse;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LLMMapper {

  public static LLMDocument toDocument(LLMDTO dto) {
    return LLMDocument.builder()
        .id(dto.getId())
        .timestampCreatedDate(dto.getTimestampCreatedDate())
        .request(dto.getRequest())
        .requestTokens(dto.getRequestTokens())
        .response(dto.getResponse())
        .responseTokens(dto.getResponseTokens())
        .totalTokens(dto.getTotalTokens())
        .build();
  }

  public static LLMDTO toDTO(LLMDocument document) {
    return LLMDTO.builder()
        .id(document.getId())
        .timestampCreatedDate(document.getTimestampCreatedDate())
        .request(document.getRequest())
        .requestTokens(document.getRequestTokens())
        .response(document.getResponse())
        .responseTokens(document.getResponseTokens())
        .totalTokens(document.getTotalTokens())
        .build();
  }

  public static LLMDTO toCreate(String request, ChatResponse response) {
    var usage = response.getMetadata().getUsage();
    return LLMDTO.builder()
        .request(request)
        .requestTokens(usage.getPromptTokens())
        .response(Objects.requireNonNull(response.getResult()).getOutput().getText())
        .responseTokens(usage.getCompletionTokens())
        .totalTokens(usage.getTotalTokens())
        .build();
  }
}
