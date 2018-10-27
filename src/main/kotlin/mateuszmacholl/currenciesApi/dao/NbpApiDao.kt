package mateuszmacholl.currenciesApi.dao

import mateuszmacholl.currenciesApi.connector.NbpApiConnector
import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesParameters
import org.springframework.stereotype.Repository

@Repository
class NbpApiDao(private val nbpApiConnector: NbpApiConnector) {
    fun getPurchaseRates(currencyExchangeRatesParameters: CurrencyExchangeRatesParameters): List<Double> {
        val averageRatesCurrency = nbpApiConnector.getCurrencyExchangeRates(currencyExchangeRatesParameters)
        return averageRatesCurrency.rates.map { it.bid }
    }
    fun getSalesRates(currencyExchangeRatesParameters: CurrencyExchangeRatesParameters): List<Double> {
        val averageRatesCurrency = nbpApiConnector.getCurrencyExchangeRates(currencyExchangeRatesParameters)
        return averageRatesCurrency.rates.map { it.ask }
    }
}