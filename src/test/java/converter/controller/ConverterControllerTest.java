package converter.controller;

import converter.model.ExchangeResult;
import converter.model.Rate;
import converter.util.Util;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

/**
 * Created by william on 02.04.16.
 */
public class ConverterControllerTest extends TestCase {

    @Test
    public void testGetExchangeRate() {
        ConverterController controller = new ConverterController();
        String from = "EUR";
        String to = "USD";

        Rate rate = controller.getExchangeRate(from, to);

        assertEquals("EUR", rate.getFrom());
        assertEquals("USD", rate.getTo());
        // real time rate on 01.04.16, could be changed from time to time
        assertEquals(1.1394, rate.getRate());
    }

    @Test
    public void testGetExchangeResult() {
        ConverterController controller = new ConverterController();
        String from = "EUR";
        String to = "USD";
        String amount = "10";

        Rate expectedRate = controller.getExchangeRate(from, to);
        ExchangeResult expectedExchangeResult = new ExchangeResult(Util.stringToDouble(amount), expectedRate);

        ResponseEntity response = controller.exchangeCurrency(amount, from, to);
        ExchangeResult actualExchangeResult = (ExchangeResult) response.getBody();

        assertEquals(expectedExchangeResult.getAmountFrom(), actualExchangeResult.getAmountFrom());
        assertEquals(expectedExchangeResult.getAmountTo(), actualExchangeResult.getAmountTo());

        assertEquals(expectedExchangeResult.getExchangeRate().getFrom(), actualExchangeResult.getExchangeRate().getFrom());
        assertEquals(expectedExchangeResult.getExchangeRate().getTo(), actualExchangeResult.getExchangeRate().getTo());
        assertEquals(expectedExchangeResult.getExchangeRate().getRate(), actualExchangeResult.getExchangeRate().getRate());
    }

    // TODO: add more tests for bad requests
}
