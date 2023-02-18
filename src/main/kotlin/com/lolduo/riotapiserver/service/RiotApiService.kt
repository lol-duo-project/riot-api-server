package com.lolduo.riotapiserver.service

import org.springframework.stereotype.Service

@Service
interface RiotApiService {
    fun getVersion(): Array<String>
}