package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Max on 02.01.2017.
 */
public class Utils {

    /**
     * Converts a date string into a date object
     * @param pattern The date string
     * @return A date object if successful, else null
     */
    public static Date parseDate(String pattern) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(pattern);
        } catch (ParseException e) {
            return null;
        }
    }
}

