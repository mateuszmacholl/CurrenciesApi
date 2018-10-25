package mateuszmacholl.currenciesApi.model

import java.util.*

data class CurrencyRate(
        val no: String,
        val effectiveDate: Date,
        val bid: Double,
        val ask: Double
)
