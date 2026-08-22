package com.thor.agent.adapters.outbound.repository.impl;

import com.thor.agent.adapters.outbound.repository.MongoLLMRepository;
import com.thor.agent.domain.dto.LLMDTO;
import com.thor.agent.domain.mapper.LLMMapper;
import com.thor.agent.domain.repository.LLMRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LLMRepositoryImpl implements LLMRepository {

  private final MongoLLMRepository repository;

  @Override
  public LLMDTO save(LLMDTO dto) {
    var document = LLMMapper.toDocument(dto);
    repository.save(document);
    return dto;
  }
}
