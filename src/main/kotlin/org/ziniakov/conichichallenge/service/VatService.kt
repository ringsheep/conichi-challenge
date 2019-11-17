package org.ziniakov.conichichallenge.service

import org.springframework.stereotype.Service
import org.ziniakov.conichichallenge.dto.VatResponse
import org.ziniakov.conichichallenge.gateway.VatGateway
import org.ziniakov.conichichallenge.properties.VatApiProperties

@Service
class VatService(
        private val vatGateway: VatGateway,
        private val vatApiProperties: VatApiProperties
) {
    fun validate(vatCode: String): VatResponse {
        val validationResponse = vatGateway.validate(vatApiProperties.apiKey, vatCode)

        if (validationResponse.isValid) {
            return VatResponse(countryCode = validationResponse.countryCode)
        } else {
            throw Exception("$vatCode is not valid")
        }
    }
}