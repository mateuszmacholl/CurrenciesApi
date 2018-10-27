package mateuszmacholl.currenciesApi.converter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.reflect.KClass

@Service //factory class
class ConverterContext {
    private var converters: MutableList<Converter<*, *>> = mutableListOf()

    fun <K  : Converter<*, *>> getConverter(converterClass: KClass<K>): K {
        val converter = converters.firstOrNull { converterClass.isInstance(it) } ?: throw IllegalArgumentException()
        @Suppress("UNCHECKED_CAST") // safety is implied by the high-level program logic
        return converter as K
    }

    @Autowired
    fun setConverters(converter: MutableList<Converter<*, *>>) {
        this.converters = converter
    }
}
