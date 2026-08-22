package com.thor.agent.domain.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LLMResponse {

  private String id;
  private LocalDateTime timestampCreatedDate;
  private String request;
  private String response;
  private Long requestTokens;
  private Long totalTokens;

}
