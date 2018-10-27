package mateuszmacholl.currenciesApi.unit.connector.pathConstructor

import mateuszmacholl.currenciesApi.connector.pathConstructor.CurrencyExchangeRatesNbpApiPathConstructor
import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesParameters
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CurrencyExchangeRatesNbpApiPathConstructorTest {
    private val currencyExchangeRatesNbpApiPathConstructor = CurrencyExchangeRatesNbpApiPathConstructor()
    private val currencyExchangeRatesParameters = CurrencyExchangeRatesParameters("x", "y", "z")

    @Test
    fun construct() {
        //given
        val correctPath = "http://api.nbp.pl/api/exchangerates/rates/c/x/y/z/?format=json"
        //when
        val path = currencyExchangeRatesNbpApiPathConstructor.construct(currencyExchangeRatesParameters)
        //then
        assertEquals(path, correctPath)
    }
}