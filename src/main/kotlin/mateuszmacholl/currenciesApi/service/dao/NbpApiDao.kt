package mateuszmacholl.currenciesApi.service.dao

import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesDto
import mateuszmacholl.currenciesApi.service.connector.NbpApiConnector
import org.springframework.stereotype.Repository

@Repository
class NbpApiDao(private val nbpApiConnector: NbpApiConnector) {
    fun getPurchaseRates(currencyExchangeRatesDto: CurrencyExchangeRatesDto): List<Double> {
        val averageRatesCurrency = nbpApiConnector.getCurrencyExchangeRates(currencyExchangeRatesDto)
        return averageRatesCurrency.rates.map { it.bid }
    }
    fun getSalesRates(currencyExchangeRatesDto: CurrencyExchangeRatesDto): List<Double> {
        val averageRatesCurrency = nbpApiConnector.getCurrencyExchangeRates(currencyExchangeRatesDto)
        return averageRatesCurrency.rates.map { it.ask }
    }
}