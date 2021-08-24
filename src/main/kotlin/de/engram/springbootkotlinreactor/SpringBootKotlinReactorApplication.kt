package de.engram.springbootkotlinreactor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinReactorApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinReactorApplication>(*args)
}
