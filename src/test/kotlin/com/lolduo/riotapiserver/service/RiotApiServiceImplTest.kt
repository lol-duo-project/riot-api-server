import com.lolduo.riotapiserver.service.CallApiService
import com.lolduo.riotapiserver.service.RiotApiServiceImpl
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.net.URL

class RiotApiServiceImplTest {

    @Mock
    private lateinit var callApiService: CallApiService

    @InjectMocks
    private lateinit var riotApiService: RiotApiServiceImpl

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testGetVersion() {
        //given
        val response = arrayListOf("11.4.1")
        `when`(callApiService.callApi(URL("https://ddragon.leagueoflegends.com/api/versions.json")))
            .thenReturn(response)

        //when
        val versions = riotApiService.getVersion()

        //then
        assertArrayEquals(arrayOf("11.4.1"), versions)
    }
}
