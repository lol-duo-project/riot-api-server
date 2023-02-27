package com.lolduo.riotapiserver.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.web.client.RestTemplate

@Configuration
class Config {

    @Bean
    fun restTemplate(): RestTemplate {
        val headers = HttpHeaders()
        //후에 properties 파일로 빼야함
        headers.set("X-Riot-Token", "riot-api-key")
        return RestTemplate().apply {
            interceptors.add { request, body, execution ->
                request.headers.addAll(headers)
                execution.execute(request, body)
            }
        }
    }
}