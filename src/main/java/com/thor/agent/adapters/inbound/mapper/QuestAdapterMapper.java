package com.thor.agent.adapters.inbound.mapper;

import com.thor.agent.domain.dto.LLMDTO;
import com.thor.agent.domain.response.QuestCreationResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestAdapterMapper {

  public static QuestCreationResponse toResponse(LLMDTO dto) {
    return QuestCreationResponse.builder()
        .data(dto.getResponse())
        .build();
  }
}
