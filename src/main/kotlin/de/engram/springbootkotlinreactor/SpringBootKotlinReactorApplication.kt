package de.engram.springbootkotlinreactor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
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
        GET("/", requestHandler::root)
        GET("/hello", requestHandler::hello)
    }
}