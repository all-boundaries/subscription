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