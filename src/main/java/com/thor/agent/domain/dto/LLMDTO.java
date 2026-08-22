package com.thor.agent.domain.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LLMDTO {

  @Builder.Default
  private ObjectId id = new ObjectId();
  @Builder.Default
  private LocalDateTime timestampCreatedDate = LocalDateTime.now();
  private String request;
  private String response;
  private Integer requestTokens;
  private Integer responseTokens;
  private Integer totalTokens;

}
