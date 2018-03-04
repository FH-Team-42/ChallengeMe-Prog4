package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Max on 02.01.2017.
 */
public class Utils {


    public static Date parseDate(String pattern) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(pattern);
        } catch (ParseException e) {
            return null;
        }
    }
}

