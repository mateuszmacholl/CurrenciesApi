package mateuszmacholl.currenciesApi.service

import mateuszmacholl.currenciesApi.component.CurrencyCalculator
import mateuszmacholl.currenciesApi.dao.NbpApiDao
import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesDto
import org.springframework.stereotype.Service

@Service
class CurrencyService(private val nbpApiDao: NbpApiDao,
                      private val currencyCalculator: CurrencyCalculator) {

    fun getAveragePurchaseRate(currencyExchangeRatesDto: CurrencyExchangeRatesDto): Double {
        val purchaseRates = nbpApiDao.getPurchaseRates(currencyExchangeRatesDto)
        return currencyCalculator.getAverage(purchaseRates)
    }

    fun getStandardDeviation(currencyExchangeRatesDto: CurrencyExchangeRatesDto): Double {
        val salesRates = nbpApiDao.getSalesRates(currencyExchangeRatesDto)
        return currencyCalculator.getStandardDeviation(salesRates)
    }
}