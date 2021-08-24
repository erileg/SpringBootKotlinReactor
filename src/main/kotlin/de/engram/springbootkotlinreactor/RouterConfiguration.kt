package de.engram.springbootkotlinreactor

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouterConfiguration {
    @Bean
    fun routes(requestHandler: RequestHandler) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/", requestHandler::root)
            GET("/hello", requestHandler::hello)
            GET("/things", requestHandler::allThings)
            GET("/things/{key}", requestHandler::findByKey)
        }
    }
}
