package mateuszmacholl.currenciesApi.unit

import mateuszmacholl.currenciesApi.converter.ShowStandardDeviationCurrencyConverter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShowStandardDeviationCurrencyConverterTest {

    private val showStandardDeviationCurrencyConverter = ShowStandardDeviationCurrencyConverter()
    private val standardDeviation = 0.34

    @Test
    fun convert() {
        //when
        val showAverageRateCurrencyDto = showStandardDeviationCurrencyConverter.convert(standardDeviation)
        //then
        assertEquals(showAverageRateCurrencyDto.standardDeviation, standardDeviation)
    }
}