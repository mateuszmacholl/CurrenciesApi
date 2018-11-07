package mateuszmacholl.currenciesApi.connector.urlConstructor

import mateuszmacholl.currenciesApi.utils.FactoryContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service // factory class
class NbpApiUrlConstructorContext: FactoryContext<NbpApiUrlConstructor<*>>() {
    @Autowired
    override fun set(list: MutableList<NbpApiUrlConstructor<*>>) {
        this.list = list
    }
}