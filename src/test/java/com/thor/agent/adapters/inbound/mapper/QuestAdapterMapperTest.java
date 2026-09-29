package com.thor.agent.adapters.inbound.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thor.agent.domain.dto.LLMDTO;
import org.junit.jupiter.api.Test;

class QuestAdapterMapperTest {

  @Test
  void mapsResponseText() {
    var response = QuestAdapterMapper.toResponse(LLMDTO.builder().response("answer").build());

    assertEquals("answer", response.getData());
  }
}
