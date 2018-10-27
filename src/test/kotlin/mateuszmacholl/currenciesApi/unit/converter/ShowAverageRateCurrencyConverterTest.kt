package mateuszmacholl.currenciesApi.unit.converter

import mateuszmacholl.currenciesApi.converter.ShowAverageRateCurrencyConverter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShowAverageRateCurrencyConverterTest {

    private val showAverageRateCurrencyConverter = ShowAverageRateCurrencyConverter()
    private val averageRate = 1.34

    @Test
    fun convert() {
        //when
        val showAverageRateCurrencyDto = showAverageRateCurrencyConverter.convert(averageRate)
        //then
        assertEquals(showAverageRateCurrencyDto.averageRate, averageRate)
    }
}