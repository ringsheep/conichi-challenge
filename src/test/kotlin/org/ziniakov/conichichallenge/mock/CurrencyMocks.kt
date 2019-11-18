package org.ziniakov.conichichallenge.mock

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.ziniakov.conichichallenge.dto.externalApi.CurrencyRatesResponse
import org.ziniakov.conichichallenge.gateway.CurrencyGateway
import org.ziniakov.conichichallenge.properties.CurrencyApiProperties

val currencyGateway = mock<CurrencyGateway> {
    on { getUsdRates(apiKey = apiKey, currencies = "RUB,EUR") } doReturn CurrencyRatesResponse(
            rates = mapOf(
                    "USDRUB" to 63.748038,
                    "USDEUR" to 0.904871
            )
    )
    on { getUsdRates(apiKey = apiKey, currencies = "ABC,DEF") } doReturn CurrencyRatesResponse(rates = emptyMap())
}

val currencyProperties = CurrencyApiProperties().apply {
    apiKey = apiKey
    url = "https://example.com"
}