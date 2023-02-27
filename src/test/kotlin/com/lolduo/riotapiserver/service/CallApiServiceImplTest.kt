package com.lolduo.riotapiserver.service

import com.lolduo.riotapiserver.service.callApi.CallApiServiceImpl
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import java.net.URL

class CallApiServiceImplTest {

    @Mock
    private lateinit var restTemplate: RestTemplate

    @InjectMocks
    private lateinit var callApiService: CallApiServiceImpl

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testCallApi() {
        //given
        val url = URL("https://ddragon.leagueoflegends.com/api/versions.json")
        val expectedResponse = arrayListOf("11.4.1")
        `when`(restTemplate.getForEntity(url.toString(), Any::class.java))
            .thenReturn(ResponseEntity(expectedResponse, HttpStatus.OK))

        //when
        val response = callApiService.callApi(url, Any::class.java)

        //then
        assertEquals(expectedResponse, response)
    }
}