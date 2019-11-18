package org.ziniakov.conichichallenge.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.ziniakov.conichichallenge.dto.Amount
import org.ziniakov.conichichallenge.service.CurrencyService

@RestController
@RequestMapping("/api/currency")
class CurrencyController(
        private val currencyService: CurrencyService
) {
    @GetMapping(value = ["/convert"])
    fun convert(sourceAmount: Double, sourceCurrencyCode: String, targetCurrencyCode: String): Amount =
            currencyService.convert(Amount(value = sourceAmount, currencyCode = sourceCurrencyCode), targetCurrencyCode)
}