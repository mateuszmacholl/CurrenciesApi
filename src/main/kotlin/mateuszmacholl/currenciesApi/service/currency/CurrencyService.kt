package mateuszmacholl.currenciesApi.service.currency

import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesDto
import mateuszmacholl.currenciesApi.service.dao.NbpApiDao
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