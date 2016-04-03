package converter.model;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by william on 02.04.16.
 */
public class RateTest extends TestCase {
    @Test
    public void testGettersAndSetters() {
        RateJSON rateJson = new RateJSON();
        rateJson.setFrom("EUR");
        rateJson.setTo("USD");
        rateJson.setRate("1.3");

        Rate rate = new Rate(rateJson);

        assertTrue(rate.getFrom() instanceof String);
        assertTrue(rate.getTo() instanceof String);
        assertTrue(rate.getRate() instanceof Double);

        assertEquals("EUR", rate.getFrom());
        assertEquals("USD", rate.getTo());
        assertEquals(1.3, rate.getRate());

        rate.setFrom("GBP");
        rate.setTo("EUR");
        rate.setRate(1.6);

        assertEquals("GBP", rate.getFrom());
        assertEquals("EUR", rate.getTo());
        assertEquals(1.6, rate.getRate());
    }
}