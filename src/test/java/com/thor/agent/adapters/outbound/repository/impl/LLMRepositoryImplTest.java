package com.thor.agent.adapters.outbound.repository.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.thor.agent.adapters.outbound.repository.MongoLLMRepository;
import com.thor.agent.domain.document.LLMDocument;
import com.thor.agent.domain.dto.LLMDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LLMRepositoryImplTest {

  @Mock private MongoLLMRepository repository;
  @InjectMocks private LLMRepositoryImpl repositoryImpl;

  @Test
  void mapsAndSavesDtoThenReturnsSameDto() {
    var dto = LLMDTO.builder().request("question").response("answer").build();
    when(repository.save(any(LLMDocument.class))).thenAnswer(invocation -> invocation.getArgument(0));

    assertSame(dto, repositoryImpl.save(dto));

    verify(repository).save(any(LLMDocument.class));
  }
}
