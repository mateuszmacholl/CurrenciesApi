package mateuszmacholl.currenciesApi.converter

import org.springframework.stereotype.Service

@Service
interface Converter<in from, out to>{
    fun convert(from: from): to
}