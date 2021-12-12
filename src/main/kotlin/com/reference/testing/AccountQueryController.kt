package com.reference.testing

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping(value = ["/account"])
class AccountQueryController(private val accountQueryService: AccountQueryService) {
    @GetMapping("/{accountId}")
    fun getAccountById(@PathVariable(value = "accountId") accountId: Long?): Optional<Account> {
        return accountQueryService.getAccountById(accountId!!)
    }

    @GetMapping("/list")
    fun accounts(): List<Account?> {
        return accountQueryService.accounts()
    }

}