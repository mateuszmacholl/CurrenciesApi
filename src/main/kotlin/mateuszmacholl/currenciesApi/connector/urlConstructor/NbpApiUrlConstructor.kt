package mateuszmacholl.currenciesApi.connector.urlConstructor

import mateuszmacholl.currenciesApi.dto.ApiData

abstract class NbpApiUrlConstructor<in dataToConstruct>: UrlConstructor<dataToConstruct>() {
    init {
        apiData = ApiData("http://api.nbp.pl/api/")
    }
}