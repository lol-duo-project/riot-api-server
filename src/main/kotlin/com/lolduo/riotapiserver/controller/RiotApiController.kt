package com.lolduo.riotapiserver.controller

import com.lolduo.riotapiserver.controller.response.ChampionResponse
import com.lolduo.riotapiserver.service.riotApi.RiotApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RiotApiController(
    private val riotApiService: RiotApiService,
    private val convertResponse: ConvertResponse
) {

    @GetMapping("/version")
    fun getVersion(): Array<String> {
        return riotApiService.getVersion()
    }

    @GetMapping("/champions")
    fun getChampions(): Array<ChampionResponse> {

        return riotApiService.getChampions().map { champion ->
            convertResponse.convertChampion(champion)
        }.toTypedArray()
    }
}