package com.thor.agent.domain.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LLMDTO {

  private String id;
  private LocalDateTime timestampCreatedDate;
  private String request;
  private String response;
  private Long requestTokens;
  private Long totalTokens;

}
