package mateuszmacholl.currenciesApi.converter

import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesDto
import mateuszmacholl.currenciesApi.dto.ShowAverageRateCurrencyDto
import mateuszmacholl.currenciesApi.dto.ShowStandardDeviationCurrencyDto
import org.springframework.stereotype.Component

@Component
class CurrencyConverter {

    fun convertToCurrencyExchangeRatesDto(type: String, startDate: String, endDate: String)
            = CurrencyExchangeRatesDto(type, startDate, endDate)
    fun convertToShowAverageRateCurrencyDto(averagePurchaseRate: Double)
            = ShowAverageRateCurrencyDto(averagePurchaseRate)
    fun convertToShowStandardDeviationCurrencyDto(standardDeviation: Double)
            = ShowStandardDeviationCurrencyDto(standardDeviation)
}