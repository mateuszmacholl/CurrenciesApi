package mateuszmacholl.currenciesApi.controller

import mateuszmacholl.currenciesApi.dto.output.ShowAverageRateCurrencyDto
import mateuszmacholl.currenciesApi.dto.output.ShowStandardDeviationCurrencyDto
import mateuszmacholl.currenciesApi.service.CurrencyService
import mateuszmacholl.currenciesApi.validation.CorrectDateFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@Validated
@RequestMapping(value =  ["/currencies"])
class CurrencyController(val currencyService: CurrencyService) {

    @RequestMapping(value = ["/{type}/purchase/average-rate"], method = [RequestMethod.GET])
    fun getAveragePurchaseRate(@PathVariable(value = "type") type: String,
                               @RequestParam @CorrectDateFormat startDate: String,
                               @RequestParam @CorrectDateFormat endDate: String): ResponseEntity<*>{
        val averagePurchaseRate = currencyService.getAveragePurchaseRate(type, startDate, endDate)
        val showAverageRateCurrencyDto = ShowAverageRateCurrencyDto(averagePurchaseRate)
        return ResponseEntity<Any>(showAverageRateCurrencyDto, HttpStatus.OK)
    }

    @RequestMapping(value = ["/{type}/sale/standard-deviation"], method = [RequestMethod.GET])
    fun getSaleStandardDeviation(@PathVariable(value = "type") type: String,
                               @RequestParam @CorrectDateFormat startDate: String,
                               @RequestParam @CorrectDateFormat endDate: String): ResponseEntity<*>{
        val standardDeviation = currencyService.getStandardDeviation(type, startDate, endDate)
        val showStandardDeviationCurrencyDto = ShowStandardDeviationCurrencyDto(standardDeviation)
        return ResponseEntity<Any>(showStandardDeviationCurrencyDto, HttpStatus.OK)
    }
}