package com.reference.testing

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class ToDoListItemQueryService {

    // add this via constructor

    @Autowired
    private val toDoListItemRepository: ToDoListItemRepository? = null

    fun addToDoListItem(description: String, userId: Int) {

        val newToDoListItem = ToDoListItem(description = description, userId = userId)

        toDoListItemRepository!!.save(newToDoListItem)
    }

    fun getAllToDoLists(): Map<Int, List<ToDoListItem>> {

        val allToDoListItems = toDoListItemRepository!!.findAll()

        return allToDoListItems.groupBy { it.userId }
    }


//    fun getAccountById(accountId: Long): Optional<Account> {
//        return accountRepository!!.findById(accountId)
//    }
//
//    fun accounts(): List<Account?> {
//        return accountRepository!!.findAll()
//    }
}