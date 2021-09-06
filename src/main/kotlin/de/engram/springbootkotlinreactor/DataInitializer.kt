package de.engram.springbootkotlinreactor

import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(val postRepository: PostRepository) : ApplicationRunner {
	private val logger = KotlinLogging.logger {}

	override fun run(args: ApplicationArguments?) {
		logger.info("Initializing data...")

		runBlocking {
			if (postRepository.count() > 0) {
				logger.info("Found posts, skipping data creation...")
			}else {
				postRepository.save(Post(content = "hello 🐷", userName = "user1"))
				postRepository.save(Post(content = "hello 🤡", userName = "user2"))
				postRepository.save(Post(content = "hello 👁", userName = "user3"))
//				postRepository.saveAll(
//					listOf(
//						Post(content = "hello 🐷", userName = "user1"),
//						Post(content = "hello 🤡", userName = "user2"),
//						Post(content = "hello 👁", userName = "user3")
//					)
//				)
			}
		}
	}
}
