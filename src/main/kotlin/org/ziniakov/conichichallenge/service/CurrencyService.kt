package org.ziniakov.conichichallenge.service

import org.springframework.stereotype.Service
import org.ziniakov.conichichallenge.dto.Amount
import org.ziniakov.conichichallenge.gateway.CurrencyGateway
import org.ziniakov.conichichallenge.properties.CurrencyApiProperties
import kotlin.math.round

private const val DEFAULT_MINORY_UNITS = 100

@Service
class CurrencyService(
        private val currencyGateway: CurrencyGateway,
        private val currencyApiProperties: CurrencyApiProperties
) {

    fun convert(sourceAmount: Amount, targetCurrencyCode: String): Amount {
        val rates = currencyGateway.getUsdRates(
                currencyApiProperties.apiKey,
                createCurrenciesString(sourceAmount.currencyCode, targetCurrencyCode)
        ).rates

        val sourceUsdRate = getCurrencyUsdRateMinoryUnits(rates, sourceAmount.currencyCode)
        val targetUsdRate = getCurrencyUsdRateMinoryUnits(rates, targetCurrencyCode)
        val targetAmountValue = sourceAmount.value / sourceUsdRate * targetUsdRate

        return Amount(value = targetAmountValue.roundToCurrencyFormat(), currencyCode = targetCurrencyCode)
    }

    private fun createCurrenciesString(vararg currencyCodes: String): String =
            currencyCodes.joinToString (separator = ",")

    private fun getCurrencyUsdRateMinoryUnits(rates: Map<String, Double>, currencyCode: String): Double =
            rates.getOrElse("USD$currencyCode") { throw Exception("Could not get rate from USD to $currencyCode") }
}

private fun Double.roundToCurrencyFormat(): Double = (round(this * DEFAULT_MINORY_UNITS) / DEFAULT_MINORY_UNITS)