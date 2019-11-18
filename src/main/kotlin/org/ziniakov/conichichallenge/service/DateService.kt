package org.ziniakov.conichichallenge.service

import org.springframework.stereotype.Service
import org.ziniakov.conichichallenge.dto.Date
import java.time.Clock
import java.time.Instant


@Service
class DateService(
        private val clock: Clock
) {
    fun getCurrentDate(): Date {
        val instant = Instant.now(clock)
        return Date(timestamp = instant.epochSecond, formattedStringUtc = instant.toString())
    }
}