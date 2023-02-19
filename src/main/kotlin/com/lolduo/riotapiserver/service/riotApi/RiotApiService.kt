package com.lolduo.riotapiserver.service.riotApi

import com.lolduo.riotapiserver.service.riotApi.response.Champion


interface RiotApiService {
    fun getVersion(): Array<String>
    fun getChampions(): Array<Champion>
}