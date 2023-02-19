package com.lolduo.riotapiserver.controller.response

import com.lolduo.riotapiserver.controller.response.champion.ImageResponse
import com.lolduo.riotapiserver.controller.response.champion.InfoResponse
import com.lolduo.riotapiserver.controller.response.champion.StatsResponse

data class ChampionResponse(
    val version: String,
    val id: String,
    val key: String,
    val name: String,
    val title: String,
    val blurb: String,
    val info: InfoResponse,
    val image: ImageResponse,
    val tags: Array<String>,
    val partype: String,
    val stats: StatsResponse
)
