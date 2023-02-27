package com.lolduo.riotapiserver.controller.response.champion

data class InfoResponse(
    val attack: Int,
    val defense: Int,
    val magic: Int,
    val difficulty: Int
)