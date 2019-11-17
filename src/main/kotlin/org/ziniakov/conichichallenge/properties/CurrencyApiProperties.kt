package org.ziniakov.conichichallenge.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "currency-api")
class CurrencyApiProperties {
    lateinit var url: String
    lateinit var apiKey: String
}
