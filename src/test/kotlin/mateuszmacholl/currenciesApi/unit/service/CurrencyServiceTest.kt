package mateuszmacholl.currenciesApi.unit.service

import mateuszmacholl.currenciesApi.component.CurrencyCalculator
import mateuszmacholl.currenciesApi.dao.NbpApiDao
import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesParameters
import mateuszmacholl.currenciesApi.service.CurrencyService
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class CurrencyServiceTest {
    private val nbpApiDao = mock(NbpApiDao::class.java)
    private val currencyCalculator = mock(CurrencyCalculator::class.java)
    private val currencyService = CurrencyService(nbpApiDao, currencyCalculator)
    private val currencyExchangeRatesParameters = mock(CurrencyExchangeRatesParameters::class.java)
    private val list = listOf<Double>()

    @Test
    fun getAveragePurchaseRate(){
        //given
        `when`(nbpApiDao.getPurchaseRates(currencyExchangeRatesParameters)).thenReturn(list)
        `when`(currencyCalculator.getAverage(list)).thenReturn(5.5)
        //when
        val averagePurchaseRate = currencyService.getAveragePurchaseRate(currencyExchangeRatesParameters)
        //then
        assertTrue(averagePurchaseRate == 5.5)
    }

    @Test
    fun getSaleStandardDeviation(){
        //given
        `when`(nbpApiDao.getSalesRates(currencyExchangeRatesParameters)).thenReturn(list)
        `when`(currencyCalculator.getStandardDeviation(list)).thenReturn(2.5)
        //when
        val saleStandardDeviation = currencyService.getSaleStandardDeviation(currencyExchangeRatesParameters)
        //then
        assertTrue(saleStandardDeviation == 2.5)
    }
}