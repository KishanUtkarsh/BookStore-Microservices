package com.appitude.users;

import com.appitude.users.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import static org.junit.Assert.assertTrue;


@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class UserServiceApplicationTests {

//	private final UserService userService;
//
//	private final ObjectMapper objectMapper;
//	private final MockMvc mockMvc;


	@Container
	@ServiceConnection
	static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:13.2");



	@BeforeAll
	@DisplayName("Start container")
    static void startContainer() {
		postgreSQLContainer.start();
	}

	@AfterAll
	@DisplayName("Stop container")
	static void stopContainer() {
		postgreSQLContainer.stop();
	}

	@Test
	@DisplayName("Demo test")
	void contextLoads() {
		Assertions.assertTrue(true);
	}

}
