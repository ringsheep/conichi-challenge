package org.ziniakov.conichichallenge.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class Amount (
        @get:JsonProperty("value") var value: Double,
        @get:JsonProperty("currencyCode") var currencyCode: String
)
