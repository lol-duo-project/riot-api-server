package com.lolduo.riotapiserver.service.riotApi.response

import com.lolduo.riotapiserver.service.riotApi.response.champion.Image
import com.lolduo.riotapiserver.service.riotApi.response.champion.Info
import com.lolduo.riotapiserver.service.riotApi.response.champion.Stats

data class Champion(
    val version: String,
    val id: String,
    val key: String,
    val name: String,
    val title: String,
    val blurb: String,
    val info: Info,
    val image: Image,
    val tags: Array<String>,
    val partype: String,
    val stats: Stats
)
