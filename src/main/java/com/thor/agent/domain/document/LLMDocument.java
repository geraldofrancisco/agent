package com.thor.agent.domain.document;

import static com.thor.agent.domain.constants.LLMConstants.LLM_FIELD_CREATION_DATETIME;
import static com.thor.agent.domain.constants.LLMConstants.LLM_FIELD_REQUEST;
import static com.thor.agent.domain.constants.LLMConstants.LLM_FIELD_REQUEST_TOKENS;
import static com.thor.agent.domain.constants.LLMConstants.LLM_FIELD_RESPONSE;
import static com.thor.agent.domain.constants.LLMConstants.LLM_FIELD_RESPONSE_TOKENS;
import static com.thor.agent.domain.constants.LLMConstants.LLM_FIELD_TOTAL_TOKENS;
import static com.thor.agent.domain.constants.LLMConstants.LLM_TABLE_NAME;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = LLM_TABLE_NAME)
public class LLMDocument {

  @Id
  private ObjectId id;

  @Field(name = LLM_FIELD_CREATION_DATETIME)
  @Builder.Default
  private LocalDateTime timestampCreatedDate = LocalDateTime.now();

  @Field(name = LLM_FIELD_REQUEST)
  private String request;

  @Field(name = LLM_FIELD_RESPONSE)
  private String response;

  @Field(name = LLM_FIELD_REQUEST_TOKENS)
  private Long requestTokens;

  @Field(name = LLM_FIELD_RESPONSE_TOKENS)
  private Long responseTokens;

  @Field(name = LLM_FIELD_TOTAL_TOKENS)
  private Long totalTokens;
}
