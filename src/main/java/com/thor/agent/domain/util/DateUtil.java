package com.thor.agent.domain.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

  public static LocalDateTime toDateTime(String dateTime) {
    if (StringUtils.isBlank(dateTime)) {
      return null;
    }
    return LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
  }
}
