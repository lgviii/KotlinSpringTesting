package com.reference.testing

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class ListControllerIntegrationTest {

	// Application context started without the server
	@Autowired
	private val mvc: MockMvc? = null

	@Test
	fun getHello() {
		mvc!!.perform(MockMvcRequestBuilders.get("/ToDoListItem/ByUser").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk)
			.andExpect(content().json("{}"));
	}
}