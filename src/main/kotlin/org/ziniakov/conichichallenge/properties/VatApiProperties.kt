package org.ziniakov.conichichallenge.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "vat-api")
class VatApiProperties {
    lateinit var url: String
    lateinit var apiKey: String
}