package com.thor.agent.domain.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestConstants {

  public static final String QUEST_CONTROLLER_TAG_NAME = "Quest Controller";
  public static final String QUEST_CONTROLLER_TAG_DESCRIPTION = "Quest operations";
  public static final String QUEST_CONTROLLER_SUMMARY = "Ask the LLM a question";
  public static final String QUEST_CONTROLLER_DESCRIPTION = "This endpoint queries the LLM.";
  public static final String QUEST_CONTROLLER_RESPONSE_DESCRIPTION = "Quest completed";

  public static final String QUEST_CREATION_REQUEST_QUESTION_DESCRIPTION = "Prompt that makes the request to the LLM";
  public static final String QUEST_CREATION_REQUEST_QUESTION_NOT_BLANK_ERROR = "QUEST_CREATION_REQUEST_QUESTION_NOT_BLANK_ERROR";

  public static final String QUEST_CREATION_RESPONSE_DATA_DESCRIPTION = "LLM response generated from the prompt";
  public static final String QUEST_CREATION_NOT_RESPONSE_EXCEPTION = "QUEST_CREATION_NOT_RESPONSE_EXCEPTION";
}
