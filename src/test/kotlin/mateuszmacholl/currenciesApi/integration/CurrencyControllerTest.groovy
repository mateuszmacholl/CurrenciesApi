package mateuszmacholl.currenciesApi.integration

import mateuszmacholl.currenciesApi.dto.ShowAverageRateCurrencyDto
import mateuszmacholl.currenciesApi.dto.ShowStandardDeviationCurrencyDto
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

    def "get average purchase rate in euro"(){
        given:
        def type = "eur"
        def startDate = "2017-11-20"
        def endDate = "2017-11-24"
        Double correctAverage = 4.1815
        when:
        def response = restTemplate.getForEntity(path + type + '/average-purchase-rate?startDate=' + startDate + '&endDate=' + endDate, ShowAverageRateCurrencyDto.class)
        then:
        HttpStatus.OK == response.statusCode
        response.body.averageRate == correctAverage
    }


    def "wrong date format for startDate in average purchase rate"(){
        given:
        def type = "eur"
        def startDate = "2017-11-2"
        def endDate = "2017-11-24"
        when:
        def response = restTemplate.getForEntity(path + type + '/average-purchase-rate?startDate=' + startDate + '&endDate=' + endDate, ShowAverageRateCurrencyDto.class)
        then:
        HttpStatus.BAD_REQUEST == response.statusCode
    }

    def "wrong date format for endDate in average purchase rate"(){
        given:
        def type = "eur"
        def startDate = "2017-11-20"
        def endDate = "2017-24"
        when:
        def response = restTemplate.getForEntity(path + type + '/average-purchase-rate?startDate=' + startDate + '&endDate=' + endDate, ShowAverageRateCurrencyDto.class)
        then:
        HttpStatus.BAD_REQUEST == response.statusCode
    }

    def "get sale standard deviation in euro"(){
        given:
        def type = "eur"
        def startDate = "2017-11-20"
        def endDate = "2017-11-24"
        Double standardDeviation = 0.0101
        when:
        def response = restTemplate.getForEntity(path + type + '/sale-standard-deviation?startDate=' + startDate + '&endDate=' + endDate, ShowStandardDeviationCurrencyDto.class, startDate, endDate)
        then:
        HttpStatus.OK == response.statusCode
        response.body.standardDeviation == standardDeviation
    }

    def "wrong date format for startData in sale standard deviation"(){
        given:
        def type = "eur"
        def startDate = "2017-1-20"
        def endDate = "2017-11-24"
        when:
        def response = restTemplate.getForEntity(path + type + '/sale-standard-deviation?startDate=' + startDate + '&endDate=' + endDate, ShowStandardDeviationCurrencyDto.class, startDate, endDate)
        then:
        HttpStatus.BAD_REQUEST == response.statusCode
    }

    def "wrong date format for endData in sale standard deviation"(){
        given:
        def type = "eur"
        def startDate = "2017-11-20"
        def endDate = "2017-1-24"
        when:
        def response = restTemplate.getForEntity(path + type + '/sale-standard-deviation?startDate=' + startDate + '&endDate=' + endDate, ShowStandardDeviationCurrencyDto.class, startDate, endDate)
        then:
        HttpStatus.BAD_REQUEST == response.statusCode
    }

    def "wrong value for type in sale standard deviation"(){
        given:
        def type = "randomValue"
        def startDate = "2017-11-20"
        def endDate = "2017-11-24"
        when:
        def response = restTemplate.getForEntity(path + type + '/sale-standard-deviation?startDate=' + startDate + '&endDate=' + endDate, ShowStandardDeviationCurrencyDto.class, startDate, endDate)
        then:
        HttpStatus.BAD_REQUEST == response.statusCode
    }
}
