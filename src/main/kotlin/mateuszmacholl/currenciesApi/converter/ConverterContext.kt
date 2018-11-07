package mateuszmacholl.currenciesApi.converter

import mateuszmacholl.currenciesApi.utils.FactoryContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service //factory class
class ConverterContext: FactoryContext<Converter<*, *>>() {
    @Autowired
    override fun set(list: MutableList<Converter<*, *>>) {
        this.list = list
    }
}
