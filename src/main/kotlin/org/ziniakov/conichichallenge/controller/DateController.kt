package org.ziniakov.conichichallenge.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.ziniakov.conichichallenge.dto.Date
import org.ziniakov.conichichallenge.service.DateService

@RestController
@RequestMapping("/api/date")
class DateController(
        private val dateService: DateService
) {
    @GetMapping(
            path = ["/current"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getCurrent(): Date = dateService.getCurrentDate()
}