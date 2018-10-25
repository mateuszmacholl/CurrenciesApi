package mateuszmacholl.currenciesApi.model

data class AverageRatesCurrency(
        val table: String,
        val currency: String,
        val code: String,
        val rates: List<CurrencyRate>
)