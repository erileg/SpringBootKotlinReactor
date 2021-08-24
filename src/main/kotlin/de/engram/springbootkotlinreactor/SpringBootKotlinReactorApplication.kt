package de.engram.springbootkotlinreactor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.coRouter

@SpringBootApplication
class SpringBootKotlinReactorApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinReactorApplication>(*args)
}

@Configuration
class RouterConfiguration {
    @Bean
    fun routes(requestHandler: RequestHandler) = coRouter {
		accept(APPLICATION_JSON).nest {
			GET("/", requestHandler::root)
			GET("/hello", requestHandler::hello)
			GET("/things", requestHandler::allThings)
			GET("/things/{key}", requestHandler::findByKey)
		}
    }
}
