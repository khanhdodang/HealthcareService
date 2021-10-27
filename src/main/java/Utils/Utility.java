package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    /**
     * get Datetime with format dd/MM/yyyy
     *
     * @return
     */
    public static String getDatetime() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
        return sdfDate.format(now);
    }
}
