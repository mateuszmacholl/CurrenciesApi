package mateuszmacholl.currenciesApi.dto.input

import java.util.*

data class CurrencyRateDto(
        val no: String,
        val effectiveDate: Date,
        val bid: Double,
        val ask: Double
)
