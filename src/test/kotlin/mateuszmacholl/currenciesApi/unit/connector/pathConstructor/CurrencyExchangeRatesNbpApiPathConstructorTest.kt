package mateuszmacholl.currenciesApi.unit.connector.pathConstructor

import mateuszmacholl.currenciesApi.connector.urlConstructor.CurrencyExchangeRatesNbpApiUrlConstructor
import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesParameters
import mateuszmacholl.currenciesApi.dto.ResponseFormat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CurrencyExchangeRatesNbpApiPathConstructorTest {
    private val currencyExchangeRatesNbpApiPathConstructor = CurrencyExchangeRatesNbpApiUrlConstructor()
    private val parameters = CurrencyExchangeRatesParameters("x", "y", "z")
    private val format = ResponseFormat.JSON

    @Test
    fun construct() {
        //given
        val correctPath = "http://api.nbp.pl/api/exchangerates/rates/c/${parameters.type}/${parameters.startDate}/${parameters.endDate}/?format=json"
        //when
        val path = currencyExchangeRatesNbpApiPathConstructor.construct(parameters, format.value)
        //then
        assertEquals(path, correctPath)
    }
}