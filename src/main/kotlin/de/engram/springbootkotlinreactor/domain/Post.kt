package de.engram.springbootkotlinreactor.domain

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import javax.validation.constraints.NotNull

@Table
data class Post(
	@Id  val id: Long? = null,
	@Version val version: Long? = null,

	@get: NotNull(message ="must not be null")
	val content: String,

	@get: NotNull(message = "must not be null")
	val userName: String,

	val timestamp: LocalDateTime = LocalDateTime.now()
)
