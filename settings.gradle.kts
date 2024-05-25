rootProject.name = "subscription"

pluginManagement {
	repositories {
		maven { url = uri("https://repo.spring.io/milestone") }
		gradlePluginPortal()
	}
}

dependencyResolutionManagement {
	versionCatalogs {
		create("libs") {
			plugin("pact", "au.com.dius.pact").version("4.3.10")

			library("pact-junit", "au.com.dius.pact.provider", "junit5").version("4.6.9")
			library("pact-spring", "au.com.dius.pact.provider", "spring6").version("4.6.9")
			bundle("pact", listOf(
				"pact-junit",
				"pact-spring"
			))

			library("testcontainers-junit", "org.testcontainers", "junit-jupiter").version("1.19.7")
			library("testcontainers-postgres", "org.testcontainers", "postgresql").version("1.19.7")
			library("testcontainers-spring", "org.springframework.boot", "spring-boot-testcontainers").withoutVersion()
			bundle("testcontainers", listOf(
				"testcontainers-junit",
				"testcontainers-postgres",
				"testcontainers-spring"
			))
		}
	}
}