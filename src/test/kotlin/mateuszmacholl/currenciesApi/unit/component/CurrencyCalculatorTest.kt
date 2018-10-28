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
        //given
        values.add(5.0)
        values.add(1.0)
        values.add(3.0)
    }

    @Test
    fun getAverage(){
        //when
        val average = currencyCalculator.getAverage(values)
        //then
        assertEquals(3.0, average)
    }

    @Test
    fun getStandardDeviation(){
        //when
        val standardDeviation = currencyCalculator.getStandardDeviation(values)
        //then
        assertEquals(1.633, standardDeviation)
    }
}