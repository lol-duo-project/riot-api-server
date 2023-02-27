package com.lolduo.riotapiserver.service.callApi

import java.net.URL

interface CallApiService {
    fun <T> callApi(url: URL, responseType: Class<T>): T
}