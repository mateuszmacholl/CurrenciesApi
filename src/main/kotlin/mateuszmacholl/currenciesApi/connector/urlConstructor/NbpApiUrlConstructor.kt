package mateuszmacholl.currenciesApi.connector.urlConstructor

import mateuszmacholl.currenciesApi.dto.ApiData

abstract class NbpApiUrlConstructor<in dataToConstruct>: UrlConstructor<dataToConstruct> {
    protected val apiData: ApiData = ApiData("http://api.nbp.pl/api/")
}