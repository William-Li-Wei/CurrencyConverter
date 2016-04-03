package converter.controller;

import converter.model.ExchangeResult;
import converter.model.Rate;
import converter.model.RateJSON;
import converter.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by william on 02.04.16.
 */
@RestController
public class ConverterController {

    private static final String BASE_URL = "https://rate-exchange.herokuapp.com/";

    // TODO: make full use of the PathVariable to organize better url mapping, e.g. "/{from}/to/{to}?amount=1"

    @RequestMapping("/exchange")
    public ResponseEntity exchangeCurrency(
            @RequestParam(value="amount", defaultValue="1") String strAmount,
            @RequestParam(value="from", defaultValue="EUR") String from,
            @RequestParam(value="to", defaultValue="USD") String to
    ) {

        Double amount = Util.stringToDouble(strAmount);

        // return bad request for invalid amount
        if(amount == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: invalid amount.");
        }

        // get the exchange rate from the public api
        Rate rate = getExchangeRate(from, to);

        // return bad request for invalid currency code
        if(rate.rate == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: invalid currency code.");
        }

        return ResponseEntity.ok(new ExchangeResult(amount, rate));
    }

    public Rate getExchangeRate(String from, String to) {
        Rate rate;

        // prepare the url to the public currency exchange rate api
        String url = BASE_URL + "fetchRate?from=" + from + "&to=" + to;

        // create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // make the HTTP GET request, marshaling the response from JSON to an RateJSON object
        RateJSON rateJson = restTemplate.getForObject(url, RateJSON.class);

        // convert RateJSON to Rate
        // TODO use jackson mapper to handle the conversion
        rate = new Rate(rateJson);

        return rate;
    }


    @RequestMapping("/*")
    public ResponseEntity respondToOtherRequests() {
        String info = "Please make request in the following format: " +
                "'http://localhost:8080/exchange?" +
                "from=SOURCE_CURRENCY_CODE&to=TARGET_CURRENCY_CODE&amount=SOURCE_CURRENCY_AMOUNT'";

        // TODO: handle other requests better
        return ResponseEntity.ok(info);
    }
}
