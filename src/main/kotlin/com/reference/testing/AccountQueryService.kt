package com.reference.testing

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class AccountQueryService {
    @Autowired
    private val accountRepository: AccountRepository? = null

    fun getAccountById(accountId: Long): Optional<Account> {
        return accountRepository!!.findById(accountId)
    }

    fun accounts(): List<Account?> {
        return accountRepository!!.findAll()
    }
}