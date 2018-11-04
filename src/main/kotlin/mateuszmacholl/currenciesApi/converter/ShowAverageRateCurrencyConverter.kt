package mateuszmacholl.currenciesApi.converter

import mateuszmacholl.currenciesApi.dto.ShowAverageRateCurrencyDto
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class ShowAverageRateCurrencyConverter: Converter<Double, ShowAverageRateCurrencyDto> {
    override fun convert(from: Double): ShowAverageRateCurrencyDto = ShowAverageRateCurrencyDto(from)
}