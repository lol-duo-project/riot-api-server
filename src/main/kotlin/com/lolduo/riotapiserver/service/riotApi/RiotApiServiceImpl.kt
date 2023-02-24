package com.lolduo.riotapiserver.service.riotApi

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lolduo.riotapiserver.service.callApi.CallApiService
import com.lolduo.riotapiserver.service.riotApi.response.Champion
import org.springframework.stereotype.Service
import java.net.URL


@Service
class RiotApiServiceImpl(private val callApiService: CallApiService) : RiotApiService {

    override fun getVersion(): Array<String> {
        val url = URL("https://ddragon.leagueoflegends.com/api/versions.json")
        return callApiService.callApi(url, Array<String>::class.java)
    }


    override fun getChampions(version: String, locale: String): Array<Champion> {
        val url = URL("https://ddragon.leagueoflegends.com/cdn/$version/data/$locale/champion.json")
        val response = callApiService.callApi(url, Map::class.java)
        val jsonOfResponse = Gson().toJson(response["data"])
        val championType = object : TypeToken<Map<String, Champion>>() {}.type
        val championMap: Map<String, Champion> = Gson().fromJson(jsonOfResponse, championType)
        return championMap.values.toTypedArray()
    }
}