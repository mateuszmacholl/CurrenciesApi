package mateuszmacholl.currenciesApi.converter

import mateuszmacholl.currenciesApi.dto.view.ShowStandardDeviationCurrencyDto
import org.springframework.stereotype.Service

@Service
class ShowStandardDeviationCurrencyConverter: Converter<Double, ShowStandardDeviationCurrencyDto> {
    override fun convert(from: Double): ShowStandardDeviationCurrencyDto = ShowStandardDeviationCurrencyDto(from)
}