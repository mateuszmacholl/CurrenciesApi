package mateuszmacholl.currenciesApi.dto

data class CurrencyExchangeRatesDto(
        val type: String,
        val startDate: String,
        val endDate: String
)