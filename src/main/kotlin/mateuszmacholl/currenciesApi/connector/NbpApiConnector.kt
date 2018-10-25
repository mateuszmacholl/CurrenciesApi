package mateuszmacholl.currenciesApi.connector

import mateuszmacholl.currenciesApi.config.exception.nbp.NbpApiBadRequestException
import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesDto
import mateuszmacholl.currenciesApi.model.AverageRatesCurrency
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Repository
class NbpApiConnector(private val restTemplate: RestTemplate){

    val apiPath: String = "http://api.nbp.pl/api/"
    val format: String = "json"

    fun getCurrencyExchangeRates(currencyExchangeRatesDto: CurrencyExchangeRatesDto): AverageRatesCurrency {
        try {
            val response = restTemplate.getForEntity<AverageRatesCurrency>(
                    apiPath + "exchangerates/rates/c/" +
                            "${currencyExchangeRatesDto.type}/" +
                            "${currencyExchangeRatesDto.startDate}/" +
                            "${currencyExchangeRatesDto.endDate}/" +
                            "?format=$format",
                    AverageRatesCurrency::class
            )
            return response.body!!
        } catch (e: Exception) {
            throw NbpApiBadRequestException()
        }
    }
}