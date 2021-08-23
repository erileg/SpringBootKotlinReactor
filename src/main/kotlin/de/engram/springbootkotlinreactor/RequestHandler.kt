package de.engram.springbootkotlinreactor

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import reactor.core.publisher.Mono

@Component
@Suppress("UNUSED_PARAMETER")
class RequestHandler(
	val thingRepository: ThingRepository
)
{
    suspend fun root(request: ServerRequest): ServerResponse {
        return ok().bodyValueAndAwait("Up and running...")
    }

    suspend fun hello(request: ServerRequest): ServerResponse {
        val payload = setOf(
            Thing("name1", "value1"),
            Thing("name2", "value2")
        )

        return ok().bodyValueAndAwait(payload)
    }

    suspend fun all(request: ServerRequest): ServerResponse {
        return ok().bodyAndAwait(thingRepository.findAll())
	}
}
