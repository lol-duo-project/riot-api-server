package com.lolduo.riotapiserver.service.callApi

import java.net.URL

interface CallApiService {
    fun callApi(url : URL): Any
}