package org.ziniakov.conichichallenge.gateway

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.ziniakov.conichichallenge.dto.CurrencyRatesResponse

@FeignClient(name = "currency-api", url = "{currency-api.url}")
interface CurrencyGateway {
    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["live"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getUsdRates(@RequestParam("access_key") apiKey: String,
                    @RequestParam("currencies") currencies: String): CurrencyRatesResponse
}