package mateuszmacholl.currenciesApi.dto.input

data class AverageRatesCurrencyDto(
        val table: String,
        val currency: String,
        val code: String,
        val rates: List<CurrencyRateDto>
)