package org.ziniakov.conichichallenge.service

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.ziniakov.conichichallenge.dto.VatResponse
import org.ziniakov.conichichallenge.dto.externalApi.VatValidationRequest
import org.ziniakov.conichichallenge.dto.externalApi.VatValidationResponse
import org.ziniakov.conichichallenge.gateway.VatGateway
import org.ziniakov.conichichallenge.properties.VatApiProperties

internal class VatServiceTest {
    private val gateway = mock<VatGateway> {
        on { validate(apiKey = "apiKey", request = VatValidationRequest("DE 260543043")) } doReturn
                VatValidationResponse(
                        countryCode = "DE",
                        isValid = true
                )
    }

    private val properties = VatApiProperties().apply {
        apiKey = "apiKey"
        url = "https://example.com"
    }

    private val service = VatService(gateway, properties)

    @Test
    fun should_validate_correct_vat_code() {
        val result = service.validate(vatCode = "DE 260543043")

        Assertions.assertThat(result).isEqualTo(VatResponse(countryCode = "DE"))
    }
}