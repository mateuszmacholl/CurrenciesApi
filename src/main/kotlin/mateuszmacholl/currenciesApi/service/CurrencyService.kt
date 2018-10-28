package mateuszmacholl.currenciesApi.service

import mateuszmacholl.currenciesApi.component.CurrencyCalculator
import mateuszmacholl.currenciesApi.dao.NbpApiDao
import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesParameters
import org.springframework.stereotype.Service

@Service
class CurrencyService(private val nbpApiDao: NbpApiDao,
                      private val currencyCalculator: CurrencyCalculator) {

    fun getAveragePurchaseRate(currencyExchangeRatesParameters: CurrencyExchangeRatesParameters): Double {
        val purchaseRates = nbpApiDao.getPurchaseRates(currencyExchangeRatesParameters)
        return currencyCalculator.getAverage(purchaseRates)
    }

    fun getSalesStandardDeviation(currencyExchangeRatesParameters: CurrencyExchangeRatesParameters): Double {
        val salesRates = nbpApiDao.getSalesRates(currencyExchangeRatesParameters)
        return currencyCalculator.getStandardDeviation(salesRates)
    }
}