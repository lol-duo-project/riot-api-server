package com.lolduo.riotapiserver.controller

import com.lolduo.riotapiserver.service.riotApi.RiotApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RiotApiController(
    private val riotApiService: RiotApiService,
) {

    @GetMapping("/version")
    fun getVersion(): Array<String> {
        return riotApiService.getVersion()
    }
}