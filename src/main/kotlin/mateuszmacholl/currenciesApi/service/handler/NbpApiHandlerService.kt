package mateuszmacholl.currenciesApi.service.handler

import mateuszmacholl.currenciesApi.service.connector.NbpApiConnectorService
import mateuszmacholl.currenciesApi.service.helper.CurrencyCalculator
import org.springframework.stereotype.Service

@Service
class NbpApiHandlerService(
        private val nbpApiConnectorService: NbpApiConnectorService,
        private val currencyCalculator: CurrencyCalculator) {

    fun handleAveragePurchasePrice(type: String, startDate: String, endDate: String): Double {
        val purchaseRates = getPurchaseRates(type, startDate, endDate)
        return currencyCalculator.calculateAverage(purchaseRates)
    }

    fun handleStandardDeviation(type: String, startDate: String, endDate: String): Double{
        val salesRates = getSalesRates(type, startDate, endDate)
        return currencyCalculator.calculateStandardDeviation(salesRates)
    }

    private fun getPurchaseRates(type: String, startDate: String, endDate: String): List<Double> {
        val averagePurchasePriceCurrencyDto = nbpApiConnectorService.getCurrencyExchangeRates(type, startDate, endDate)
        return averagePurchasePriceCurrencyDto.rates.map { it.bid }
    }

    private fun getSalesRates(type: String, startDate: String, endDate: String): List<Double> {
        val averagePurchasePriceCurrencyDto = nbpApiConnectorService.getCurrencyExchangeRates(type, startDate, endDate)
        return averagePurchasePriceCurrencyDto.rates.map { it.ask }
    }
}