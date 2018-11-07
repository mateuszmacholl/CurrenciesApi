package mateuszmacholl.currenciesApi.connector

import mateuszmacholl.currenciesApi.config.exception.nbp.NbpApiBadRequestException
import mateuszmacholl.currenciesApi.connector.urlConstructor.CurrencyExchangeRatesNbpApiUrlConstructor
import mateuszmacholl.currenciesApi.connector.urlConstructor.NbpApiUrlConstructorContext
import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesParameters
import mateuszmacholl.currenciesApi.dto.ResponseFormat
import mateuszmacholl.currenciesApi.model.AverageRatesCurrency
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Repository
class NbpApiConnector(
        private val restTemplate: RestTemplate,
        private val nbpApiUrlConstructorContext: NbpApiUrlConstructorContext) {

    fun getCurrencyExchangeRates(currencyExchangeRatesParameters: CurrencyExchangeRatesParameters): AverageRatesCurrency {
        val responseFormat = ResponseFormat.JSON
        val constructor = nbpApiUrlConstructorContext.get(CurrencyExchangeRatesNbpApiUrlConstructor::class.java)
        val path = constructor.construct(currencyExchangeRatesParameters, responseFormat.value)
        try {
            return restTemplate.getForEntity<AverageRatesCurrency>(path, AverageRatesCurrency::class).body!!
        } catch (e: Exception) {
            throw NbpApiBadRequestException()
        }
    }
}