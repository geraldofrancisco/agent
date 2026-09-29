package com.thor.agent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

@SpringBootTest
class AgentApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void mainStartsSpringApplication() {
		var args = new String[] {"--spring.main.web-application-type=none"};
		var context = mock(ConfigurableApplicationContext.class);

		try (var springApplication = mockStatic(SpringApplication.class)) {
			springApplication.when(() -> SpringApplication.run(AgentApplication.class, args))
					.thenReturn(context);

			AgentApplication.main(args);

			springApplication.verify(() -> SpringApplication.run(AgentApplication.class, args));
		}
	}

}
