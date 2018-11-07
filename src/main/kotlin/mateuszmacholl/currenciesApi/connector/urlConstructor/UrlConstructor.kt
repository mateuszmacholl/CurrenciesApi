package mateuszmacholl.currenciesApi.connector.urlConstructor

interface UrlConstructor<in dataToConstruct> {
    fun construct(dataToConstruct: dataToConstruct, format: String): String
}