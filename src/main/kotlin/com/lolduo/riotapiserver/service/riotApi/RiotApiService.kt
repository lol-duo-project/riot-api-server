package com.lolduo.riotapiserver.service.riotApi

import com.lolduo.riotapiserver.service.riotApi.response.Champion


interface RiotApiService {
    fun getVersion(): Array<String>
    fun getChampions(version:String, locale : String): Array<Champion>
    fun getLocales(): Array<String>
}