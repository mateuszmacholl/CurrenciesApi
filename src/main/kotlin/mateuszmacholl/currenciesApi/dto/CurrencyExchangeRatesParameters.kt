package mateuszmacholl.currenciesApi.dto

data class CurrencyExchangeRatesParameters(
        val type: String,
        val startDate: String,
        val endDate: String
)