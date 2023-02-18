package com.lolduo.riotapiserver.service

class RiotApiServiceImpl : RiotApiService {
    override fun getVersion(): Array<String> {
        return arrayOf("0.0.1-SNAPSHOT")
    }
}