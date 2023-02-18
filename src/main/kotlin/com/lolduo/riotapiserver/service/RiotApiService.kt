package com.lolduo.riotapiserver.service


interface RiotApiService {
    fun getVersion(): Array<String>
}