package org.ziniakov.conichichallenge.service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.ziniakov.conichichallenge.dto.Date
import org.ziniakov.conichichallenge.mock.clockMock

internal class DateServiceTest {
    private val service = DateService(clockMock)

    @Test
    fun should_return_current_date() {
        val result = service.getCurrentDate()

        Assertions.assertThat(result).isEqualTo(Date(timestamp = 1560729600, formattedStringUtc = "2019-06-17T00:00:00Z"))
    }
}