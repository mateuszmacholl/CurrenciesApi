package mateuszmacholl.currenciesApi.service.connector

import mateuszmacholl.currenciesApi.config.exception.nbp.NbpApiBadRequestException
import mateuszmacholl.currenciesApi.dto.input.AverageRatesCurrencyDto
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Service
class NbpApiConnectorService(private val restTemplate: RestTemplate){

    val apiPath: String = "http://api.nbp.pl/api/"
    val format: String = "json"

    fun getCurrencyExchangeRates(type: String, startDate: String, endDate: String): AverageRatesCurrencyDto {
        try {
            val response = restTemplate.getForEntity<AverageRatesCurrencyDto>(
                    apiPath + "exchangerates/rates/c/$type/$startDate/$endDate/?$format",
                    AverageRatesCurrencyDto::class
            )
            return response.body!!
        } catch (e: Exception) {
            throw NbpApiBadRequestException()
        }
    }
}