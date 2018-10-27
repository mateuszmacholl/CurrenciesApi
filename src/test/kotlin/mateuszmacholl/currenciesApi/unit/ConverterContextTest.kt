package mateuszmacholl.currenciesApi.unit

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
        converterContext.setConverters(converters)
    }

    @Test
    fun getConverter_returnCorrectConverter() {
        //when
        val converter = converterContext.getConverter(ShowAverageRateCurrencyConverter::class)
        //then
        assertTrue(ShowAverageRateCurrencyConverter::class.isInstance(converter))
    }

    @Test
    fun getConverter_returnWrongConverter() {
        //when
        val converter = converterContext.getConverter(ShowAverageRateCurrencyConverter::class)
        //then
        assertFalse(ShowStandardDeviationCurrencyConverter::class.isInstance(converter))
    }

    @Test
    fun getConverter_withNull_throwIllegalArgumentException() {
        //given
        val converters = ArrayList<Converter<*,*>>()
        converters.add(ShowAverageRateCurrencyConverter())
        converterContext.setConverters(converters)
        //then
        assertThrows<IllegalArgumentException>(IllegalArgumentException::class.java) {
            //when
            converterContext.getConverter(ShowStandardDeviationCurrencyConverter::class)
        }
    }


}