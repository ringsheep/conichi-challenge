package org.ziniakov.conichichallenge.service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.ziniakov.conichichallenge.dto.VatResponse
import org.ziniakov.conichichallenge.mock.vatGateway
import org.ziniakov.conichichallenge.mock.vatProperties

internal class VatServiceTest {
    private val service = VatService(vatGateway, vatProperties)

    @Test
    fun should_validate_correct_vat_code() {
        val result = service.validate(vatCode = "DE 260543043")

        Assertions.assertThat(result).isEqualTo(VatResponse(countryCode = "DE"))
    }

    @Test
    fun should_not_validate_incorrect_vat_code() {
        assertThrows<Exception> {
            service.validate(vatCode = "NN 111111111")
        }
    }
}