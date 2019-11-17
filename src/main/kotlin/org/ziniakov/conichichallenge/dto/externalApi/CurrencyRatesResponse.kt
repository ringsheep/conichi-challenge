package org.ziniakov.conichichallenge.dto.externalApi

import com.fasterxml.jackson.annotation.JsonProperty

data class CurrencyRatesResponse (
        @get:JsonProperty("quotes") var rates: Map<String, Double>
)