package com.lolduo.riotapiserver.service.callApi

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URL

@Service
class CallApiServiceImpl(private val restTemplate: RestTemplate) : CallApiService {

    override fun callApi(url: URL): Any {
        try{
            val response = restTemplate.getForEntity(url.toString(), Any::class.java)
            return response.body ?: throw Exception("Error response from Riot API")
        }catch (e: Exception){
            throw Exception("Error response from Riot API")
        }
    }
}
