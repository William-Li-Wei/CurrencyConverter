# CurrencyConverter

#### What is CurrencyConvertor
It's a RESTful web service with Spring, provde an api to convert currencies with the real time exchange rate.

Request URL 
```
http://localhost:8080/exchange?from=SOURCE_CURRENCY_CODE&to=TARGET_CURRENCY_CODE&amount=SOURCE_CURRENCY_AMOUNT
```

#### How to get started
It's build with Maven, to install Maven, see [https://maven.apache.org/][1]

Download the repo and cd into the project folder, then run 
```
mvn spring-boot:run
```
It would download all the dependencies, compile, test and then start the server. Or run
```
mvn clean package
```
It would build a jar file for you in the target folder and then run the JAR by typing
```
java -jar /PATH_TO_THE_PROJECT/target/currency-converter-0.1.0.jar
```

Now open your browser and visit [http://localhost:8080/exchange][2]

#### Depenceis
 - ***spring-boot-starter-web***, to build a RESTful web service with Spring.
 - ***junit***, for Unit Test.
 
#### Public API for the exchange rate
[https://rate-exchange.herokuapp.com/][3]

#### Contact
Please contact at liweisadleader@hotmail.com for more descussions
 
 
 
 
  [1]: https://maven.apache.org/
  [2]: http://localhost:8080/products
  [3]: https://rate-exchange.herokuapp.com/
