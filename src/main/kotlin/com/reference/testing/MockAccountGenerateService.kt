package com.reference.testing

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class MockAccountGenerateService {
    @Autowired
    private val accountRepository: AccountRepository? = null

    @Autowired
    private val accountIdGenerationService: AccountIdGenerationService? = null
    fun generateAccounts() {

        val account1: Account = Account(1,"First account", BigDecimal(100))
        accountRepository!!.save(account1)

        val account2: Account = Account(1,"Second account", BigDecimal(200))
        accountRepository!!.save(account1)

        accountRepository.save(account2)
    }
}