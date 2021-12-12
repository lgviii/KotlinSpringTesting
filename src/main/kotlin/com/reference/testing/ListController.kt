package com.reference.testing

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ListController {
	@GetMapping("/")
	fun index(): String {
		return "Greetings from Spring Boot!"
	}
}