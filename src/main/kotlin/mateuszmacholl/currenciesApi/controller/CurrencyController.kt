package mateuszmacholl.currenciesApi.controller

import mateuszmacholl.currenciesApi.converter.ConverterContext
import mateuszmacholl.currenciesApi.converter.ShowAverageRateCurrencyConverter
import mateuszmacholl.currenciesApi.converter.ShowStandardDeviationCurrencyConverter
import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesParameters
import mateuszmacholl.currenciesApi.service.CurrencyService
import mateuszmacholl.currenciesApi.validation.correctDateFormat.CorrectDateFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@Validated
@RequestMapping(value =  ["/currencies"])
class CurrencyController(private val currencyService: CurrencyService,
                         private val converterContext: ConverterContext ) {

    @RequestMapping(value = ["/{type}/average-purchase-rate"], method = [RequestMethod.GET])
    fun getAveragePurchaseRate(@PathVariable(value = "type") type: String,
                               @RequestParam @CorrectDateFormat startDate: String,
                               @RequestParam @CorrectDateFormat endDate: String): ResponseEntity<*>{

        val currencyExchangeRatesParameters = CurrencyExchangeRatesParameters(type, startDate, endDate)

        val averagePurchaseRate = currencyService.getAveragePurchaseRate(currencyExchangeRatesParameters)

        val converter = converterContext.getConverter(ShowAverageRateCurrencyConverter::class)
        val showAverageRateCurrencyDto = converter.convert(averagePurchaseRate)
        return ResponseEntity<Any>(showAverageRateCurrencyDto, HttpStatus.OK)
    }

    @RequestMapping(value = ["/{type}/sale-standard-deviation"], method = [RequestMethod.GET])
    fun getSaleStandardDeviation(@PathVariable(value = "type") type: String,
                                 @RequestParam @CorrectDateFormat startDate: String,
                                 @RequestParam @CorrectDateFormat endDate: String): ResponseEntity<*>{

        val currencyExchangeRatesParameters = CurrencyExchangeRatesParameters(type, startDate, endDate)

        val saleStandardDeviation = currencyService.getSaleStandardDeviation(currencyExchangeRatesParameters)
        val converter = converterContext.getConverter(ShowStandardDeviationCurrencyConverter::class)
        val showStandardDeviationCurrencyDto = converter.convert(saleStandardDeviation)
        return ResponseEntity<Any>(showStandardDeviationCurrencyDto, HttpStatus.OK)
    }
}