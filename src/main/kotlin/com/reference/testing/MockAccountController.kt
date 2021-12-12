package com.reference.testing

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = ["/mockaccount"])
class MockAccountController(private val dummyAccountGenerateService: MockAccountGenerateService) {
    @GetMapping("/generatetestdata")
    fun generateDummyAccounts() {
        dummyAccountGenerateService.generateAccounts()
    }
}