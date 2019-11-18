package org.ziniakov.conichichallenge.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.ziniakov.conichichallenge.dto.Date
import org.ziniakov.conichichallenge.service.DateService

@RestController("/api/date")
class DateController(
        private val dateService: DateService
) {
    @RequestMapping(value = ["/current"], method = [RequestMethod.GET])
    fun getCurrent(): Date = dateService.getCurrentDate()
}