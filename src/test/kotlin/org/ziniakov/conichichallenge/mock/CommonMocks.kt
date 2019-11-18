package org.ziniakov.conichichallenge.mock

import java.time.Clock
import java.time.Instant
import java.time.ZoneId

val clockMock = Clock.fixed(Instant.ofEpochSecond(1560729600), ZoneId.systemDefault())

const val apiKey = "apiKey"