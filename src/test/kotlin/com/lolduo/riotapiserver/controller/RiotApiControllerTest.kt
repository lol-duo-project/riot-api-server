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
}

