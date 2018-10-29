# CurrenciesApi

## Endpoints
  - /currencies
    - /{type}
      - /purchase/average-rate [GET, parameters: startDate, endDate]
      - /sale/standard-deviation [GET, parameters: startDate, endDate]
      
## Examples
Average purchase rate:
  - http://localhost:9007/currencies/eur/average-purchase-rate?startDate=2017-11-20&endDate=2017-11-24
  
Sale standard deviation:
  - http://localhost:9007/currencies/eur/sale-standard-deviation?startDate=2017-11-20&endDate=2017-11-24
