package com.lolduo.riotapiserver.controller

import com.lolduo.riotapiserver.service.riotApi.RiotApiService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(RiotApiController::class)
class RiotApiControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var riotApiService: RiotApiService

    @Test
    fun testGetVersion() {
        // Set up the mock response from the RiotApiService
        val versionArray = arrayOf("v1", "v2", "v3")
        `when`(riotApiService.getVersion()).thenReturn(versionArray)

        // Make a GET request to the "/version" endpoint
        mockMvc.perform(get("/version")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json("[\"v1\", \"v2\", \"v3\"]"))
    }
}
