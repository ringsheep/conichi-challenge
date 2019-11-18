package org.ziniakov.conichichallenge.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.ziniakov.conichichallenge.dto.VatResponse
import org.ziniakov.conichichallenge.service.VatService

@RestController
@RequestMapping("/api/vat")
class VatController(
        private val vatService: VatService
) {
    @GetMapping(value = ["/validate"])
    fun validate(vatCode: String): VatResponse = vatService.validate(vatCode)
}