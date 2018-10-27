package mateuszmacholl.currenciesApi.unit.component

import mateuszmacholl.currenciesApi.component.CurrencyCalculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CurrencyCalculatorTest {
    private val currencyCalculator = CurrencyCalculator()
    private val values = mutableListOf<Double>()


    @BeforeEach
    fun init(){
        values.add(5.0)
        values.add(1.0)
        values.add(3.0)
    }

    @Test
    fun getAverage(){
        val average = currencyCalculator.getAverage(values)
        assertEquals(3.0, average)
    }

    @Test
    fun getStandardDeviation(){
        val standardDeviation = currencyCalculator.getStandardDeviation(values)
        assertEquals(1.633, standardDeviation)
    }
}