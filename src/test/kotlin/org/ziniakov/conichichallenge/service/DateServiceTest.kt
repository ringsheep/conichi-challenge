package org.ziniakov.conichichallenge.service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.ziniakov.conichichallenge.dto.Date
import java.time.Clock
import java.time.Instant
import java.time.ZoneId

internal class DateServiceTest {
    private val clockMock = Clock.fixed(Instant.ofEpochSecond(1560729600), ZoneId.systemDefault())

    private val service = DateService(clockMock)

    @Test
    fun should_return_current_date() {
        val result = service.getCurrentDate()

        Assertions.assertThat(result).isEqualTo(Date(timestamp = 1560729600, formattedStringUtc = "17/06/19 00:00"))
    }
}