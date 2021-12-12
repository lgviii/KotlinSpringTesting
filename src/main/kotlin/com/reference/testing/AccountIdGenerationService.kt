package com.reference.testing

import org.springframework.stereotype.Service

@Service
class AccountIdGenerationService {
    fun newAccountId(): Long {
        return System.nanoTime()
    }
}