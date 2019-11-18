package org.ziniakov.conichichallenge.mock

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.ziniakov.conichichallenge.dto.externalApi.VatValidationRequest
import org.ziniakov.conichichallenge.dto.externalApi.VatValidationResponse
import org.ziniakov.conichichallenge.gateway.VatGateway
import org.ziniakov.conichichallenge.properties.VatApiProperties

val vatGateway = mock<VatGateway> {
    on { validate(apiKey = apiKey, request = VatValidationRequest("DE 260543043")) } doReturn
            VatValidationResponse(
                    countryCode = "DE",
                    isValid = true
            )
    on { validate(apiKey = apiKey, request = VatValidationRequest("NN 111111111")) } doReturn
            VatValidationResponse(
                    countryCode = "NN",
                    isValid = false
            )
}

val vatProperties = VatApiProperties().apply {
    apiKey = apiKey
    url = "https://example.com"
}