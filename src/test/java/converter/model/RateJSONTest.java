package converter.model;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by william on 02.04.16.
 */
public class RateJSONTest extends TestCase {
    @Test
    public void testGettersAndSetters() {
        RateJSON rateJson = new RateJSON();
        rateJson.setFrom("EUR");
        rateJson.setTo("USD");
        rateJson.setRate("1.3");

        assertTrue(rateJson.getFrom() instanceof String);
        assertTrue(rateJson.getTo() instanceof String);
        assertTrue(rateJson.getRate() instanceof String);

        assertEquals("EUR", rateJson.getFrom());
        assertEquals("USD", rateJson.getTo());
        assertEquals("1.3", rateJson.getRate());
    }
}
