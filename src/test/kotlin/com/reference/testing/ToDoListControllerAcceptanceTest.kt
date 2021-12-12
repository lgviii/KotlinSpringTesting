package com.reference.testing

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoListControllerAcceptanceTest {
    @Autowired
    private val template: TestRestTemplate? = null

    val testToDoListItem1User1 = ToDoListItem(id = 1, description = "To do item 1 for user 1", 1)
    val testToDoListItem2User1 = ToDoListItem(id = 2, description = "To do item 2 for user 1", 1)
    val testToDoListItem1User2 = ToDoListItem(id = 3, description = "To do item 1 for user 2", 2)

    val testToDoListMap = mapOf(
        testToDoListItem1User1.userId to listOf(
            testToDoListItem1User1,
            testToDoListItem2User1
        ), testToDoListItem1User2.userId to listOf(testToDoListItem1User2)
    )

    @Test
    fun givenNoToDoListsExist_WhenItemsAreAdded_thenListsAreAvailable() {
        // Given
        var toDoListMapBeforeAdditions = getAllToDoLists()
        Assertions.assertThat(toDoListMapBeforeAdditions).isEqualTo(emptyMap<Int, List<ToDoListItem>>())

        addToDoItem(testToDoListItem1User1.description, testToDoListItem1User1.userId)
        addToDoItem(testToDoListItem2User1.description, testToDoListItem2User1.userId)
        addToDoItem(testToDoListItem1User2.description, testToDoListItem1User2.userId)

        // When
        var toDoListMapAfterAdditions = getAllToDoLists()

        // Then
        Assertions.assertThat(toDoListMapAfterAdditions).isEqualTo(testToDoListMap)
    }

    private fun getAllToDoLists(): Map<Int, List<ToDoListItem>>? {
        val response = template!!.getForEntity("/ToDoListItem/ByUser", String::class.java)
        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.OK)

        val mapper = ObjectMapper()
        val typeRef = object : TypeReference<Map<Int, List<ToDoListItem>>>() {}

        return mapper.readValue(response.body.toString(), typeRef)
    }

    private fun addToDoItem(description: String, userId: Int) {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        val requestEntity: HttpEntity<String> = HttpEntity<String>(description, headers)
        val response = template!!.postForEntity("/ToDoListItem/${userId}", requestEntity, String::class.java)

        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
    }



    // next step is integration tests that verify the controller works by checking or populating the database

    // then add unit tests for services

    // then add a user service

    // then add remove action for items

}