package com.thor.agent.domain.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class DateUtilTest {

  @Test
  void parsesIsoDateTime() {
    assertEquals(LocalDateTime.of(2025, 1, 2, 3, 4, 5),
        DateUtil.toDateTime("2025-01-02T03:04:05"));
  }

  @Test
  void returnsNullForBlankInput() {
    assertNull(DateUtil.toDateTime(null));
    assertNull(DateUtil.toDateTime("  "));
  }

  @Test
  void rejectsInvalidDateTime() {
    assertThrows(java.time.format.DateTimeParseException.class,
        () -> DateUtil.toDateTime("not-a-date"));
  }
}
