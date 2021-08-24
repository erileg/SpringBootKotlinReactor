package de.engram.springbootkotlinreactor

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ThingRepository: CoroutineCrudRepository<Thing, String> {
	suspend fun searchByValueContaining(needle: String): List<Thing>
}
