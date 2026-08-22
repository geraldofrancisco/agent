package com.thor.agent.domain.request;

import static com.thor.agent.domain.constants.QuestConstants.QUEST_CREATION_REQUEST_QUESTION_DESCRIPTION;
import static com.thor.agent.domain.constants.QuestConstants.QUEST_CREATION_REQUEST_QUESTION_NOT_BLANK_ERROR;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestCreationRequest {

  @Schema(description = QUEST_CREATION_REQUEST_QUESTION_DESCRIPTION)
  @NotBlank(message = QUEST_CREATION_REQUEST_QUESTION_NOT_BLANK_ERROR)
  private String question;
}
