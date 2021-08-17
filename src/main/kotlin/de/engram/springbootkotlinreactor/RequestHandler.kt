package de.engram.springbootkotlinreactor

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
@Suppress("UNUSED_PARAMETER")
class RequestHandler {
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
}