package converter.model;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by william on 02.04.16.
 */
public class ExchangeResultTest extends TestCase {
    @Test
    public void testGettersAndSetters() {
        // init rateJson, rate and exchangeRate
        RateJSON rateJson = new RateJSON();
        rateJson.setFrom("EUR");
        rateJson.setTo("USD");
        rateJson.setRate("1.3");

        Rate rate = new Rate(rateJson);

        ExchangeResult exchangeResult = new ExchangeResult(10.0, rate);

        // test against variable type
        assertTrue(exchangeResult.getAmountFrom() instanceof Double);
        assertTrue(exchangeResult.getAmountTo() instanceof Double);
        assertTrue(exchangeResult.getExchangeRate() instanceof Rate);

        // test against getters
        assertEquals(10.0, exchangeResult.getAmountFrom());
        assertEquals(13.0, exchangeResult.getAmountTo());
        assertEquals(rate, exchangeResult.getExchangeRate());


        // change amountFrom
        exchangeResult.setAmountFrom(20.0);

        assertEquals(20.0, exchangeResult.getAmountFrom());
        assertEquals(20 * 1.3, exchangeResult.getAmountTo());
        assertEquals(rate, exchangeResult.getExchangeRate());


        // change exchangeRate: including currency code and rate
        rate.setFrom("GBP");
        rate.setTo("EUR");
        rate.setRate(1.6);

        exchangeResult.setExchangeRate(rate);
        assertEquals(20.0, exchangeResult.getAmountFrom());
        assertEquals(20 * 1.6, exchangeResult.getAmountTo());
        assertEquals(rate, exchangeResult.getExchangeRate());
    }
}
