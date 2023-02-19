package com.lolduo.riotapiserver.service.riotApi

import com.lolduo.riotapiserver.service.callApi.CallApiService
import com.lolduo.riotapiserver.service.riotApi.response.Champion
import org.springframework.stereotype.Service
import java.net.URL

@Service
class RiotApiServiceImpl(private val callApiService: CallApiService) : RiotApiService {

    override fun getVersion(): Array<String> {
        val url = URL("https://ddragon.leagueoflegends.com/api/versions.json")
        val response = callApiService.callApi(url)

        val versions = (response as? ArrayList<String>)?.toTypedArray()

        return versions ?: throw Exception("Error response from Riot API")
    }

    override fun getChampions(): Array<Champion> {
        TODO()
    }
}