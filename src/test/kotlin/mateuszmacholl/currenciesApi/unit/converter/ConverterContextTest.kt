package mateuszmacholl.currenciesApi.unit.converter

import mateuszmacholl.currenciesApi.converter.Converter
import mateuszmacholl.currenciesApi.converter.ConverterContext
import mateuszmacholl.currenciesApi.converter.ShowAverageRateCurrencyConverter
import mateuszmacholl.currenciesApi.converter.ShowStandardDeviationCurrencyConverter
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

class ConverterContextTest {

    private val converterContext = ConverterContext()

    @BeforeEach
    fun init() {
        //given
        val converters = ArrayList<Converter<*,*>>()
        converters.add(ShowAverageRateCurrencyConverter())
        converters.add(ShowStandardDeviationCurrencyConverter())
        converterContext.set(converters)
    }

    @Test
    fun getConverter_returnCorrectConverter() {
        //when
        val converter = converterContext.get(ShowAverageRateCurrencyConverter::class.java)
        //then
        assertTrue(ShowAverageRateCurrencyConverter::class.isInstance(converter))
    }

    @Test
    fun getConverter_returnWrongConverter() {
        //when
        val converter = converterContext.get(ShowAverageRateCurrencyConverter::class.java)
        //then
        assertFalse(ShowStandardDeviationCurrencyConverter::class.isInstance(converter))
    }

    @Test
    fun getConverter_withNull_throwIllegalArgumentException() {
        //given
        val converters = ArrayList<Converter<*,*>>()
        converters.add(ShowAverageRateCurrencyConverter())
        converterContext.set(converters)
        //then
        assertThrows<IllegalArgumentException>(IllegalArgumentException::class.java) {
            //when
            converterContext.get(ShowStandardDeviationCurrencyConverter::class.java)
        }
    }


}