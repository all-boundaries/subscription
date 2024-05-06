package net.allboundaries.subscription

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest
class SubscriptionApplicationTests {
	@Test
	fun contextLoads() {
	}

	companion object {
		@Container
		@ServiceConnection
		var database = PostgreSQLContainer("postgres:13.14-bullseye")
	}
}
