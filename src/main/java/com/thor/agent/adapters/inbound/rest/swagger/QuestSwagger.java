package com.thor.agent.adapters.inbound.rest.swagger;

import static com.thor.agent.domain.constants.ProjectConstants.PROJECT_SWAGGER_STATUS_OK;
import static com.thor.agent.domain.constants.QuestConstants.QUEST_CONTROLLER_DESCRIPTION;
import static com.thor.agent.domain.constants.QuestConstants.QUEST_CONTROLLER_RESPONSE_DESCRIPTION;
import static com.thor.agent.domain.constants.QuestConstants.QUEST_CONTROLLER_SUMMARY;
import static com.thor.agent.domain.constants.QuestConstants.QUEST_CONTROLLER_TAG_DESCRIPTION;
import static com.thor.agent.domain.constants.QuestConstants.QUEST_CONTROLLER_TAG_NAME;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.thor.agent.domain.request.QuestCreationRequest;
import com.thor.agent.domain.response.QuestCreationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = QUEST_CONTROLLER_TAG_NAME, description = QUEST_CONTROLLER_TAG_DESCRIPTION)
public interface QuestSwagger {


  @Operation(
      summary = QUEST_CONTROLLER_SUMMARY,
      description = QUEST_CONTROLLER_DESCRIPTION,
      responses =
      @ApiResponse(
          responseCode = PROJECT_SWAGGER_STATUS_OK,
          description = QUEST_CONTROLLER_RESPONSE_DESCRIPTION,
          content =
          @Content(
              mediaType = APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = QuestCreationResponse.class))))
  QuestCreationResponse sendQuestion(@RequestBody @Valid final QuestCreationRequest request);
}
