package org.ziniakov.conichichallenge.gateway

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.ziniakov.conichichallenge.dto.externalApi.VatValidationResponse

@FeignClient(name = "vat-api", url = "{vat-api.url}")
interface VatGateway {
    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["lookup"],
            consumes = [APPLICATION_JSON_VALUE],
            produces = [APPLICATION_JSON_VALUE]
    )
    fun validate(@RequestHeader("Apikey") apiKey: String,
                 @RequestParam("VatCode") vatCode: String): VatValidationResponse
}