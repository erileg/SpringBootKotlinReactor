package de.engram.springbootkotlinreactor

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.notFound
import org.springframework.web.reactive.function.server.ServerResponse.ok

@RestController
@Suppress("UNUSED_PARAMETER")
class RequestHandler(
	val thingRepository: ThingRepository
) {
	suspend fun root(request: ServerRequest) =
		ok().bodyValueAndAwait("Up and running...")

	suspend fun hello(request: ServerRequest) =
		ok().bodyValueAndAwait(
			setOf(
				Thing("key1", "value1 🐷"),
				Thing("key2", "value2 🤡"),
				Thing("key2", "value2 👁")
			)
		)

	suspend fun allThings(request: ServerRequest) =
		ok().bodyAndAwait(thingRepository.findAll())

	suspend fun findByKey(request: ServerRequest): ServerResponse {
		val thing = thingRepository.findById(request.pathVariable("key"))
		return thing?.let { ok().bodyValueAndAwait(it) } ?: notFound().buildAndAwait()
	}

	@GetMapping("/search")
	suspend fun search(@RequestParam(value="needle") needle:String) =
		thingRepository.searchByValueContaining(needle)
}
