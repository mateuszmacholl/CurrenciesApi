package mateuszmacholl.currenciesApi.connector.urlConstructor

import mateuszmacholl.currenciesApi.dto.CurrencyExchangeRatesParameters
import org.springframework.stereotype.Repository

@Repository
class CurrencyExchangeRatesNbpApiUrlConstructor: NbpApiUrlConstructor<CurrencyExchangeRatesParameters>() {
    override fun construct(dataToConstruct: CurrencyExchangeRatesParameters, format: String): String{
        return apiData.url + "exchangerates/rates/c/" +
                "${dataToConstruct.type}/" +
                "${dataToConstruct.startDate}/" +
                "${dataToConstruct.endDate}/" +
                "?format=$format"
    }
}