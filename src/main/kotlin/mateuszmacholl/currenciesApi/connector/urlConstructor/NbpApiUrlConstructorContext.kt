package mateuszmacholl.currenciesApi.connector.urlConstructor

import mateuszmacholl.currenciesApi.utils.FactoryContext
import org.springframework.stereotype.Service

@Service // factory class
class NbpApiUrlConstructorContext: FactoryContext<NbpApiUrlConstructor<*>>()