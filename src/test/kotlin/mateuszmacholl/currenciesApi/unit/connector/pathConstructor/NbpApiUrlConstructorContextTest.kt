package mateuszmacholl.currenciesApi.unit.connector.pathConstructor

import mateuszmacholl.currenciesApi.connector.urlConstructor.CurrencyExchangeRatesNbpApiUrlConstructor
import mateuszmacholl.currenciesApi.connector.urlConstructor.NbpApiUrlConstructorContext
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NbpApiUrlConstructorContextTest {

    @Autowired
    private lateinit var nbpApiUrlConstructorContext: NbpApiUrlConstructorContext

    @Test
    fun getConverter_returnCorrectConverter() {
        //when
        val nbpApiUrlConstructor = nbpApiUrlConstructorContext.get(CurrencyExchangeRatesNbpApiUrlConstructor::class.java)
        //then
        Assertions.assertTrue(CurrencyExchangeRatesNbpApiUrlConstructor::class.isInstance(nbpApiUrlConstructor))
    }

    @Test
    fun getConverter_withNull_throwIllegalArgumentException() {
        //given
        val emptyNbpApiUrlConstructorContext = NbpApiUrlConstructorContext()
        //then
        Assertions.assertThrows<IllegalArgumentException>(IllegalArgumentException::class.java) {
            //when
            emptyNbpApiUrlConstructorContext.get(CurrencyExchangeRatesNbpApiUrlConstructor::class.java)
        }
    }


}