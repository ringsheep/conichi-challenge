package org.ziniakov.conichichallenge.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.ziniakov.conichichallenge.dto.VatResponse
import org.ziniakov.conichichallenge.service.VatService

@RestController("/api/vat")
class VatController(
        private val vatService: VatService
) {
    @RequestMapping(value = ["/validate"], method = [RequestMethod.GET])
    fun validate(vatCode: String): VatResponse = vatService.validate(vatCode)
}