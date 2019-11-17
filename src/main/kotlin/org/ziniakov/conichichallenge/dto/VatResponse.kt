package org.ziniakov.conichichallenge.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class VatResponse (
        @get:JsonProperty var countryCode: String
)