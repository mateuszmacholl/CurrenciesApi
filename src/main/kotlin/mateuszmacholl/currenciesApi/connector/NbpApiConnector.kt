package mateuszmacholl.currenciesApi.connector

import mateuszmacholl.currenciesApi.config.exception.nbp.NbpApiBadRequestException
import mateuszmacholl.currenciesApi.connector.pathConstructor.CurrencyExchangeRatesNbpApiPathConstructor
import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesParameters
import mateuszmacholl.currenciesApi.model.AverageRatesCurrency
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Repository
class NbpApiConnector(
        private val restTemplate: RestTemplate,
        private val currencyExchangeRatesNbpApiPathConstructor: CurrencyExchangeRatesNbpApiPathConstructor) {

    fun getCurrencyExchangeRates(currencyExchangeRatesParameters: CurrencyExchangeRatesParameters): AverageRatesCurrency {
        val path = currencyExchangeRatesNbpApiPathConstructor.construct(currencyExchangeRatesParameters)
        try {
            val response = restTemplate.getForEntity<AverageRatesCurrency>(path, AverageRatesCurrency::class)
            return response.body!!
        } catch (e: Exception) {
            throw NbpApiBadRequestException()
        }
    }
}