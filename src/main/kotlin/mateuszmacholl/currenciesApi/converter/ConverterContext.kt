package mateuszmacholl.currenciesApi.converter

import mateuszmacholl.currenciesApi.utils.FactoryContext
import org.springframework.stereotype.Service

@Service //factory class
class ConverterContext: FactoryContext<Converter<*, *>>()
