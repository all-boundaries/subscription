package net.allboundaries.cafecurious.plan.web

import net.allboundaries.cafecurious.infra.CollectionResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

data class PlanResponse(val id:String, val name: String)

@Component
class PlanHandler {
    fun allPlans(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .bodyValue(
                CollectionResponse(listOf(
                PlanResponse("pln-cGLxc6", "Explorer"),
                PlanResponse("pln-M61GdE", "Curious"),
            ))
            )
    }
}