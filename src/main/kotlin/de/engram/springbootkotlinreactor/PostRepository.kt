package de.engram.springbootkotlinreactor

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: CoroutineCrudRepository<Post, String> {
	suspend fun searchByContentContaining(needle: String): List<Post>
}
