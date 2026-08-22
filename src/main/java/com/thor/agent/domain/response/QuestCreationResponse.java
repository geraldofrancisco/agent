package com.thor.agent.domain.response;

import static com.thor.agent.domain.constants.QuestConstants.QUEST_CREATION_RESPONSE_DATA_DESCRIPTION;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestCreationResponse {

  @Schema(description = QUEST_CREATION_RESPONSE_DATA_DESCRIPTION)
  private String data;
}
