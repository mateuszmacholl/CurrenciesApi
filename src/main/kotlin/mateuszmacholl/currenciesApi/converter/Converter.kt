package mateuszmacholl.currenciesApi.converter

import org.springframework.stereotype.Service

@Service
abstract class Converter<in from, out to>{
    abstract fun convert(from: from): to
}