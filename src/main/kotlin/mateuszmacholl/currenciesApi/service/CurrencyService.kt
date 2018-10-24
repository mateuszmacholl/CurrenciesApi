package mateuszmacholl.currenciesApi.service

import mateuszmacholl.currenciesApi.service.handler.NbpApiHandlerService
import org.springframework.stereotype.Service

@Service
class CurrencyService(private val nbpApiHandlerService: NbpApiHandlerService) {
    fun getAveragePurchaseRate(type: String, startDate: String, endDate: String): Double {
        return nbpApiHandlerService.handleAveragePurchasePrice(type, startDate, endDate)
    }
    fun getStandardDeviation(type: String, startDate: String, endDate: String): Double {
        return nbpApiHandlerService.handleStandardDeviation(type, startDate, endDate)
    }
}