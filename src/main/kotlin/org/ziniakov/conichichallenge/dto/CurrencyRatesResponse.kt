package org.ziniakov.conichichallenge.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CurrencyRatesResponse (
        @get:JsonProperty("quotes") var rates: Map<String, Double>
)