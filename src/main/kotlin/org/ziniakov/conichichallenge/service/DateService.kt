package org.ziniakov.conichichallenge.service

import org.springframework.stereotype.Service
import org.ziniakov.conichichallenge.dto.Date
import java.time.Clock
import java.time.Instant
import java.time.ZoneId
import java.util.Locale
import java.time.format.FormatStyle
import java.time.format.DateTimeFormatter



@Service
class DateService(
        private val clock: Clock
) {
    private val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
            .withLocale(Locale.UK)
            .withZone(ZoneId.of("UTC"))

    fun getCurrentDate(): Date {
        val instant = Instant.now(clock)
        return Date(timestamp = instant.epochSecond, formattedStringUtc = formatter.format(instant))
    }
}