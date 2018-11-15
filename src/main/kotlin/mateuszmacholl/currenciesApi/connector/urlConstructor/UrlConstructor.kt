package mateuszmacholl.currenciesApi.connector.urlConstructor

import mateuszmacholl.currenciesApi.dto.ApiData

abstract class UrlConstructor<in dataToConstruct> {
    protected lateinit var apiData: ApiData

    abstract fun construct(dataToConstruct: dataToConstruct, format: String): String
}