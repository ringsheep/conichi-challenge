package org.ziniakov.conichichallenge.service

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.ziniakov.conichichallenge.dto.Amount
import org.ziniakov.conichichallenge.dto.externalApi.CurrencyRatesResponse
import org.ziniakov.conichichallenge.gateway.CurrencyGateway
import org.ziniakov.conichichallenge.properties.CurrencyApiProperties

internal class CurrencyServiceTest {
    private val gateway = mock<CurrencyGateway> {
        on { getUsdRates(apiKey = "apiKey", currencies = "RUB,EUR") } doReturn CurrencyRatesResponse(
                rates = mapOf(
                        "USDRUB" to 63.748038,
                        "USDEUR" to 0.904871
                )
        )
        on { getUsdRates(apiKey = "apiKey", currencies = "ABC,DEF") } doReturn CurrencyRatesResponse(rates = emptyMap())
    }

    private val properties = CurrencyApiProperties().apply {
        apiKey = "apiKey"
        url = "https://example.com"
    }

    private val service = CurrencyService(gateway, properties)

    @Test
    fun should_convert_correct_source_and_target_currency() {
        val result = service.convert(sourceAmount = Amount(value = 100.00, currencyCode = "RUB"), targetCurrencyCode = "EUR")

        assertThat(result).isEqualTo(Amount(value = 1.42, currencyCode = "EUR"))
    }

    @Test
    fun should_not_convert_incorrect_source_and_target_currency() {
        assertThrows<Exception> {
            service.convert(sourceAmount = Amount(value = 100.00, currencyCode = "ABC"), targetCurrencyCode = "DEF")
        }
    }
}