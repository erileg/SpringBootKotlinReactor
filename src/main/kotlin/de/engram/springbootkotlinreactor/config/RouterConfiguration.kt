package de.engram.springbootkotlinreactor.config

import de.engram.springbootkotlinreactor.handler.RequestHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouterConfiguration {
	@Bean
	fun routes(requestHandler: RequestHandler): RouterFunction<ServerResponse> {
		val baseUrl = "/posts"
		return coRouter {
			accept(MediaType.TEXT_PLAIN).nest {
				GET("/", requestHandler::root)
			}
			accept(MediaType.APPLICATION_JSON).nest {
				GET("/hello", requestHandler::hello)
				GET(baseUrl, queryParam("needle") { true }, requestHandler::search)
				GET(baseUrl, requestHandler::allPosts)
				GET("$baseUrl/{id}", requestHandler::findById)
				POST(baseUrl, requestHandler::create)
			}
		}
	}
}
