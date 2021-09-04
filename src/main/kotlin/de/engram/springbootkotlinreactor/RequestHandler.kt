package de.engram.springbootkotlinreactor

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.*
import java.net.URI

@RestController
@Suppress("UNUSED_PARAMETER")
class RequestHandler(val postRepository: PostRepository) {

	suspend fun root(request: ServerRequest) =
		ok().bodyValueAndAwait("Up and running...")

	suspend fun hello(request: ServerRequest): ServerResponse {
		return ok().bodyValueAndAwait(
			setOf(
				Post(content = "hello 🐷", userName = "user1"),
				Post(content = "hello 🤡", userName = "user2"),
				Post(content = "hello 👁", userName = "user3")
			)
		)
	}

	suspend fun allPosts(request: ServerRequest) =
		ok().bodyAndAwait(postRepository.findAll())

	suspend fun findById(request: ServerRequest): ServerResponse {
		val thing = postRepository.findById(request.pathVariable("id"))
		return thing?.let { ok().bodyValueAndAwait(it) } ?: notFound().buildAndAwait()
	}

	suspend fun search(request: ServerRequest): ServerResponse {
		val thing = request.queryParamOrNull("needle")?.let { postRepository.searchByContentContaining(it) }
		return thing?.let { ok().bodyValueAndAwait(it) } ?: notFound().buildAndAwait()
	}

	suspend fun create(request: ServerRequest): ServerResponse {
		val createdPost = postRepository.save(request.awaitBody())
		return created(URI.create("/posts/${createdPost.id}")).buildAndAwait()
	}

}
