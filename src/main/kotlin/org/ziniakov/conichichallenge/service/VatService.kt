package org.ziniakov.conichichallenge.service

import org.springframework.stereotype.Service
import org.ziniakov.conichichallenge.dto.VatResponse
import org.ziniakov.conichichallenge.dto.externalApi.VatValidationRequest
import org.ziniakov.conichichallenge.gateway.VatGateway
import org.ziniakov.conichichallenge.properties.VatApiProperties

@Service
class VatService(
        private val vatGateway: VatGateway,
        private val vatApiProperties: VatApiProperties
) {
    fun validate(vatCode: String): VatResponse {
        val validationResponse = vatGateway.validate(vatApiProperties.apiKey, VatValidationRequest(vatCode))

        if (validationResponse.isValid) {
            return VatResponse(countryCode = validationResponse.countryCode)
        } else {
            throw Exception("VAT code $vatCode is not valid, please follow 'XX 123456789' format")
        }
    }
}