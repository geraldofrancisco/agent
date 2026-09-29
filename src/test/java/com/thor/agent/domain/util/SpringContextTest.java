package com.thor.agent.domain.util;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

class SpringContextTest {

  @Test
  void exposesMongoTemplateFromApplicationContext() {
    var context = mock(ApplicationContext.class);
    var mongoTemplate = mock(MongoTemplate.class);
    when(context.getBean(MongoTemplate.class)).thenReturn(mongoTemplate);
    new SpringContext().setApplicationContext(context);

    assertSame(mongoTemplate, SpringContext.getBean());
  }
}
