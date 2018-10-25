package mateuszmacholl.currenciesApi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CurrenciesApiApplication

fun main(args: Array<String>) {
    runApplication<CurrenciesApiApplication>(*args)
}
