package com.reference.testing

import org.springframework.web.bind.annotation.*
import java.beans.BeanDescriptor
import java.util.*


@RestController
@RequestMapping(value = ["/ToDoListItem"])
class ToDoListItemController(private val toDoListItemQueryService: ToDoListItemQueryService) {

    @PostMapping("/{userId}")
    fun postToDoListItem(@PathVariable(value = "userId") userId: Int, @RequestBody description: String) {
        return toDoListItemQueryService.addToDoListItem(description, userId)
    }

    @GetMapping("/ByUser")
    fun getAccountById(): Map<Int, List<ToDoListItem>> {
        return toDoListItemQueryService.getAllToDoLists()
    }
}