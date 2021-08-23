package de.engram.springbootkotlinreactor

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class Thing(
	@Id
	val key: String,
	val value: String
)
