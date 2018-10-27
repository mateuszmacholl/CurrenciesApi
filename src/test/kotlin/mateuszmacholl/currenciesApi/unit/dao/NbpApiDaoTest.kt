package mateuszmacholl.currenciesApi.unit.dao

import mateuszmacholl.currenciesApi.connector.NbpApiConnector
import mateuszmacholl.currenciesApi.dao.NbpApiDao
import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesParameters
import mateuszmacholl.currenciesApi.model.AverageRatesCurrency
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class NbpApiDaoTest {
    private val nbpApiConnector = mock(NbpApiConnector::class.java)
    private val currencyExchangeRatesParameters = mock(CurrencyExchangeRatesParameters::class.java)
    private val averageRatesCurrency = mock(AverageRatesCurrency::class.java)
    private val list = listOf<Double>()
    private val nbpApiDao = NbpApiDao(nbpApiConnector)

    @BeforeEach
    fun init() {
        //given
        `when`(nbpApiConnector.getCurrencyExchangeRates(currencyExchangeRatesParameters)).thenReturn(averageRatesCurrency)
    }

    @Test
    fun getPurchaseRates(){
        //given
        `when`(averageRatesCurrency.rates.map { it.bid }).thenReturn(list)
        //when
        val purchaseRates = nbpApiDao.getPurchaseRates(currencyExchangeRatesParameters)
        //then
        assertEquals(list, purchaseRates)
    }

    @Test
    fun getSalesRates(){
        //given
        `when`(averageRatesCurrency.rates.map { it.ask }).thenReturn(list)
        //when
        val salesRates = nbpApiDao.getSalesRates(currencyExchangeRatesParameters)
        //then
        assertEquals(list, salesRates)
    }
}