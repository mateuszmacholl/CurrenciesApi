package mateuszmacholl.currenciesApi.service.helper

import org.springframework.stereotype.Service
import java.lang.Math.pow
import kotlin.math.sqrt

@Service
class CurrencyCalculator {
    fun calculateAverage(values: List<Double>): Double {
        return Math.round(values.average() * 10000.0) / 10000.0
    }

    fun calculateStandardDeviation(values: List<Double>): Double {
        val average = values.average()
        val standardDeviation = sqrt(values
                .map { it - average }
                .map { pow(it, 2.0) }
                .sumByDouble { it }
                / values.size )
        return Math.round(standardDeviation * 10000.0) / 10000.0
    }
}