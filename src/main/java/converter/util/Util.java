package converter.util;

/**
 * Created by william on 02.04.16.
 */
public class Util {

    public static Double stringToDouble(String input) {
        Double output;
        try{
            output = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            output = 0.0;
        }

        return output;
    }
}
