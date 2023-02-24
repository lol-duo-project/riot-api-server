package com.lolduo.riotapiserver.service.callApi

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URL

@Service
class CallApiServiceImpl(private val restTemplate: RestTemplate) : CallApiService {

    override fun <T> callApi(url: URL, responseType: Class<T>): T {
        try {
            val response = restTemplate.getForEntity(url.toString(), responseType)
            return response.body ?: throw Exception("Error response from Riot API")
        } catch (e: Exception) {
            throw Exception("Error response from Riot API")
        }
    }

}
