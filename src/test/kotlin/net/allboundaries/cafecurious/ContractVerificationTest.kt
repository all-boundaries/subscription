package net.allboundaries.cafecurious

import au.com.dius.pact.provider.junit5.PactVerificationContext
import au.com.dius.pact.provider.junitsupport.Provider
import au.com.dius.pact.provider.junitsupport.State
import au.com.dius.pact.provider.junitsupport.loader.PactFolder
import au.com.dius.pact.provider.spring.spring6.PactVerificationSpring6Provider
import au.com.dius.pact.provider.spring.spring6.WebFluxSpring6Target
import net.allboundaries.cafecurious.plan.web.PlanHandler
import net.allboundaries.cafecurious.plan.web.PlanRoute
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestTemplate
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import

@WebFluxTest
@Import(PlanRoute::class, PlanHandler::class)
@Provider("subscription-kotlin")
@PactFolder("../subscription-web-react/build/pacts")
class ContractVerificationTest {
    @Autowired
    lateinit var planRoute: PlanRoute

    @Autowired
    lateinit var planHandler: PlanHandler

    @TestTemplate
    @ExtendWith(PactVerificationSpring6Provider::class)
    fun pactVerificationTestTemplate(context: PactVerificationContext) {
        context.verifyInteraction()
    }

    @BeforeEach
    fun setup(context: PactVerificationContext) {
        context.target = WebFluxSpring6Target(planRoute.planRoutes(planHandler))
    }

    @State("there are plans")
    fun thereArePlans() {

    }
}