package mateuszmacholl.currenciesApi.connector.constructor

import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesParameters
import org.springframework.stereotype.Repository

@Repository
class CurrencyExchangeRatesNbpApiPathConstructor {
    val apiPath: String = "http://api.nbp.pl/api/"
    val format: String = "json"

    fun construct(currencyExchangeRatesParameters: CurrencyExchangeRatesParameters): String{
        return apiPath + "exchangerates/rates/c/" +
                "${currencyExchangeRatesParameters.type}/" +
                "${currencyExchangeRatesParameters.startDate}/" +
                "${currencyExchangeRatesParameters.endDate}/" +
                "?format=$format"
    }
}