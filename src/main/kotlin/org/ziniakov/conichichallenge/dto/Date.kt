package org.ziniakov.conichichallenge.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp

data class Date (
        @get:JsonProperty var timestamp: Long,
        @get:JsonProperty var formattedStringUtc: String
)