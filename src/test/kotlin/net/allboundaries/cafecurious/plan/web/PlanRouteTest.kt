package net.allboundaries.cafecurious.plan.web

import net.allboundaries.cafecurious.infra.CollectionResponse
import net.allboundaries.cafecurious.plan.web.PlanHandler
import net.allboundaries.cafecurious.plan.web.PlanResponse
import net.allboundaries.cafecurious.plan.web.PlanRoute
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest(PlanRoute::class)
@Import(PlanHandler::class)
class PlanRouteTest {
    @Autowired
    lateinit var webClient: WebTestClient;

    @Test
    fun `returns hard-coded list of plans`() {
        webClient
            .get()
            .uri("/plans")
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .exchange()
            .expectStatus().isOk
            .expectBody(object : ParameterizedTypeReference<CollectionResponse<PlanResponse>>() {})
            .value {
                assertThat(it.data).containsExactlyInAnyOrder(
                    PlanResponse("pln-cGLxc6", "Explorer"),
                    PlanResponse("pln-M61GdE", "Curious"),
                )
            }
    }
}