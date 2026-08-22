package com.thor.agent.application.service.impl;

import static com.thor.agent.domain.constants.QuestConstants.QUEST_CREATION_NOT_RESPONSE_EXCEPTION;

import com.thor.agent.application.service.QuestService;
import com.thor.agent.domain.dto.LLMDTO;
import com.thor.agent.domain.exception.BusinessException;
import com.thor.agent.domain.exception.GenericProjectException;
import com.thor.agent.domain.mapper.LLMMapper;
import com.thor.agent.domain.repository.LLMRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestServiceImpl implements QuestService {

  private final ChatClient chatClient;
  private final LLMRepository llmRepository;

  @Override
  public LLMDTO create(String request) {
    try {
      var response = chatClient.prompt()
          .user(request)
          .call()
          .chatResponse();

      if (Objects.nonNull(response)) {
        var llm = LLMMapper.toCreate(request, response);
        return llmRepository.save(llm);
      }

      throw new BusinessException(QUEST_CREATION_NOT_RESPONSE_EXCEPTION);
    } catch (Exception e) {
      throw new GenericProjectException(e);
    }
  }
}
