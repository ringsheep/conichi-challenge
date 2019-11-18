package org.ziniakov.conichichallenge.gateway

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.ziniakov.conichichallenge.dto.externalApi.VatValidationRequest
import org.ziniakov.conichichallenge.dto.externalApi.VatValidationResponse

@FeignClient(name = "vat-api", url = "\${vat-api.url}")
interface VatGateway {
    @PostMapping(
            path = ["/lookup"],
            consumes = [APPLICATION_JSON_VALUE],
            produces = [APPLICATION_JSON_VALUE]
    )
    fun validate(@RequestHeader("Apikey") apiKey: String,
                 request: VatValidationRequest): VatValidationResponse
}