package org.ziniakov.conichichallenge.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Clock

@Configuration
class DateConfiguration {
    @Bean
    fun clock(): Clock = Clock.systemUTC()
}