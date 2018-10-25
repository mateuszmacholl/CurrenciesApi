package mateuszmacholl.currenciesApi.controller

import mateuszmacholl.currenciesApi.converter.CurrencyConverter
import mateuszmacholl.currenciesApi.service.currency.CurrencyService
import mateuszmacholl.currenciesApi.validation.CorrectDateFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@Validated
@RequestMapping(value =  ["/currencies"])
class CurrencyController(private val currencyService: CurrencyService,
                         private val currencyConverter: CurrencyConverter ) {

    @RequestMapping(value = ["/{type}/average-purchase-rate"], method = [RequestMethod.GET])
    fun getAveragePurchaseRate(@PathVariable(value = "type") type: String,
                               @RequestParam @CorrectDateFormat startDate: String,
                               @RequestParam @CorrectDateFormat endDate: String): ResponseEntity<*>{

        val currencyExchangeRatesDto = currencyConverter.convertToCurrencyExchangeRatesDto(type, startDate, endDate)
        val averagePurchaseRate = currencyService.getAveragePurchaseRate(currencyExchangeRatesDto)
        val showAverageRateCurrencyDto = currencyConverter.convertToShowAverageRateCurrencyDto(averagePurchaseRate)
        return ResponseEntity<Any>(showAverageRateCurrencyDto, HttpStatus.OK)
    }

    @RequestMapping(value = ["/{type}/sale-standard-deviation"], method = [RequestMethod.GET])
    fun getSaleStandardDeviation(@PathVariable(value = "type") type: String,
                               @RequestParam @CorrectDateFormat startDate: String,
                               @RequestParam @CorrectDateFormat endDate: String): ResponseEntity<*>{

        val currencyExchangeRatesDto = currencyConverter.convertToCurrencyExchangeRatesDto(type, startDate, endDate)
        val saleStandardDeviation = currencyService.getStandardDeviation(currencyExchangeRatesDto)
        val showStandardDeviationCurrencyDto = currencyConverter
                .convertToShowStandardDeviationCurrencyDto(saleStandardDeviation)
        return ResponseEntity<Any>(showStandardDeviationCurrencyDto, HttpStatus.OK)
    }
}