package mateuszmacholl.currenciesApi.integrationTests

import mateuszmacholl.currenciesApi.dto.output.ShowAverageRateCurrencyDto
import mateuszmacholl.currenciesApi.dto.output.ShowStandardDeviationCurrencyDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CurrencyControllerTest extends Specification {
    @Autowired
    private TestRestTemplate restTemplate

    private String path = "/currencies/"

    def "get average purchase rate for euro"(){
        given:
        def type = "eur"
        def startDate = "2017-11-20"
        def endDate = "2017-11-24"
        Double correctAverage = 4.1815
        when:
        def response = restTemplate.getForEntity(path + type + '/purchase/average-rate?startDate=' + startDate + '&endDate=' + endDate, ShowAverageRateCurrencyDto.class)
        then:
        HttpStatus.OK == response.statusCode
        response.body.averageRate == correctAverage
    }

    def "get sale standard deviation for euro"(){
        given:
        def type = "eur"
        def startDate = "2017-11-20"
        def endDate = "2017-11-24"
        Double standardDeviation = 0.0101
        when:
        def response = restTemplate.getForEntity(path + type + '/sale/standard-deviation?startDate=' + startDate + '&endDate=' + endDate, ShowStandardDeviationCurrencyDto.class, startDate, endDate)
        then:
        HttpStatus.OK == response.statusCode
        response.body.standardDeviation == standardDeviation
    }
}
