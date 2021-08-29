package de.engram.springbootkotlinreactor

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouterConfiguration {
	@Bean
	fun routes(requestHandler: RequestHandler) = coRouter {
		accept(MediaType.TEXT_PLAIN).nest {
			GET("/", requestHandler::root)
		}
		accept(MediaType.APPLICATION_JSON).nest {
			GET("/hello", requestHandler::hello)
			GET("/things", queryParam("needle") { true }, requestHandler::search)
			GET("/things", requestHandler::allThings)
			GET("/things/{key}", requestHandler::findByKey)
		}
	}
}
