package org.ziniakov.conichichallenge.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.ziniakov.conichichallenge.dto.Amount
import org.ziniakov.conichichallenge.mock.currencyGateway
import org.ziniakov.conichichallenge.mock.currencyProperties

internal class CurrencyServiceTest {
    private val service = CurrencyService(currencyGateway, currencyProperties)

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