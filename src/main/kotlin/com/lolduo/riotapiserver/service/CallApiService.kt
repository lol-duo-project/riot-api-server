package com.lolduo.riotapiserver.service

import java.net.URL

interface CallApiService {
    fun callApi(url : URL): Any
}