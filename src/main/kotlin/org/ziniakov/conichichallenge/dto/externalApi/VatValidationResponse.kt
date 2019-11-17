package org.ziniakov.conichichallenge.dto.externalApi

import com.fasterxml.jackson.annotation.JsonProperty

data class VatValidationResponse (
        @get:JsonProperty("CountryCode") var countryCode: String,
        @get:JsonProperty("IsValid") var isValid: Boolean
)