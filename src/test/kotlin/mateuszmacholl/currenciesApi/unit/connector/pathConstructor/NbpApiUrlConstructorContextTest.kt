package mateuszmacholl.currenciesApi.unit.connector.pathConstructor

import mateuszmacholl.currenciesApi.connector.urlConstructor.CurrencyExchangeRatesNbpApiUrlConstructor
import mateuszmacholl.currenciesApi.connector.urlConstructor.NbpApiUrlConstructor
import mateuszmacholl.currenciesApi.connector.urlConstructor.NbpApiUrlConstructorContext
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

class NbpApiUrlConstructorContextTest {

    private val nbpApiUrlConstructorContext = NbpApiUrlConstructorContext()

    @BeforeEach
    fun init() {
        //given
        val nbpApiUrlConstructors = ArrayList<NbpApiUrlConstructor<*>>()
        nbpApiUrlConstructors.add(CurrencyExchangeRatesNbpApiUrlConstructor())
        nbpApiUrlConstructorContext.set(nbpApiUrlConstructors)
    }

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
        val nbpApiUrlConstructor = ArrayList<NbpApiUrlConstructor<*>>()
        nbpApiUrlConstructorContext.set(nbpApiUrlConstructor)
        //then
        Assertions.assertThrows<IllegalArgumentException>(IllegalArgumentException::class.java) {
            //when
            nbpApiUrlConstructorContext.get(CurrencyExchangeRatesNbpApiUrlConstructor::class.java)
        }
    }


}