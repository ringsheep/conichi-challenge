package org.ziniakov.conichichallenge.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class Amount (
        @get:JsonProperty var value: Double,
        @get:JsonProperty var currencyCode: String
)
