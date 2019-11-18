package org.ziniakov.conichichallenge.dto.externalApi

import com.fasterxml.jackson.annotation.JsonProperty

data class VatValidationRequest (
        @get:JsonProperty("VatCode") var vatCode: String
)