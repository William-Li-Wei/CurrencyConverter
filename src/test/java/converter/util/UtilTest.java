package converter.util;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by william on 03.04.16.
 */
public class UtilTest extends TestCase {
    @Test
    public void testStringToDouble() {
        assertEquals(234.56, Util.stringToDouble("234.56"));
        assertEquals(0.0, Util.stringToDouble("invalid number"));
    }
}
