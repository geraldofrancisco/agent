package com.thor.agent.adapters.inbound.rest;

import com.thor.agent.adapters.inbound.mapper.QuestAdapterMapper;
import com.thor.agent.adapters.inbound.rest.swagger.QuestSwagger;
import com.thor.agent.application.service.QuestService;
import com.thor.agent.domain.request.QuestCreationRequest;
import com.thor.agent.domain.response.QuestCreationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/question")
@RequiredArgsConstructor
public class QuestionController implements QuestSwagger {

  private final QuestService service;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  @Override
  public QuestCreationResponse sendQuestion(
      @RequestBody @Valid final QuestCreationRequest request) {
    var llm = service.create(request.getQuestion());
    return QuestAdapterMapper.toResponse(llm);
  }
}
