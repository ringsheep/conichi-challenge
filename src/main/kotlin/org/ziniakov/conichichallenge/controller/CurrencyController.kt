package org.ziniakov.conichichallenge.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.ziniakov.conichichallenge.dto.Amount
import org.ziniakov.conichichallenge.service.CurrencyService

@RestController("/api/currency")
class CurrencyController(
        private val currencyService: CurrencyService
) {
    @RequestMapping(value = ["/convert"],method = [RequestMethod.GET])
    fun convert(sourceAmount: Amount, targetCurrencyCode: String): Amount =
            currencyService.convert(sourceAmount, targetCurrencyCode)
}