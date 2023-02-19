package com.lolduo.riotapiserver.controller

import com.lolduo.riotapiserver.controller.response.ChampionResponse
import com.lolduo.riotapiserver.controller.response.champion.ImageResponse
import com.lolduo.riotapiserver.controller.response.champion.InfoResponse
import com.lolduo.riotapiserver.controller.response.champion.StatsResponse
import com.lolduo.riotapiserver.service.riotApi.RiotApiService
import com.lolduo.riotapiserver.service.riotApi.response.Champion
import com.lolduo.riotapiserver.service.riotApi.response.champion.Image
import com.lolduo.riotapiserver.service.riotApi.response.champion.Info
import com.lolduo.riotapiserver.service.riotApi.response.champion.Stats
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@WebMvcTest(RiotApiController::class)
class RiotApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var riotApiService: RiotApiService

    @MockBean
    lateinit var convertResponse: ConvertResponse

    @Test
    fun testGetVersion() {
        // Set up the mock response from the RiotApiService
        val versions = arrayOf("11.3.1", "11.2.1", "11.1.1")
        `when`(riotApiService.getVersion()).thenReturn(versions)

        // Make a GET request to the "/version" endpoint
        mockMvc.perform(get("/version")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0]").value(versions[0]))
            .andExpect(jsonPath("$[1]").value(versions[1]))
            .andExpect(jsonPath("$[2]").value(versions[2]))
    }

    @Test
    fun testGetChampions() {
        // Set up the mock response from the RiotApiService
        val champions = arrayOf(
            Champion("11.3.1", "Aatrox", "266", "아트록스", "다르킨의 검", "...",
                Info(0,0,0,0),
                Image("...", "...", "...", 0,0,0,0),
                arrayOf("..."),
                "...",
                Stats(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)
            ),
        )
        `when`(riotApiService.getChampions()).thenReturn(champions)

        // Set up the mock response from the ConvertResponse
        val championResponses = arrayOf(
            ChampionResponse("11.3.1", "Aatrox", "266", "아트록스", "다르킨의 검", "...",
                InfoResponse(0,0,0,0),
                ImageResponse("...", "...", "...", 0,0,0,0),
                arrayOf("..."),
                "...",
                StatsResponse(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)
            ),
        )
        `when`(convertResponse.convertChampion(champions[0])).thenReturn(championResponses[0])

        // Make a GET request to the "/champions" endpoint
        mockMvc.perform(get("/champions")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id").value(championResponses[0].id))
    }
}

