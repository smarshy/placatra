
package UI;

import java.util.Date;
import java.text.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author Vatsala
 */
public class dateUIDB {
 public static String convertDateForDB(String strDate, String dateType) {
        String strReturnValue = null;
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat(dateType);
            date = (Date) formatter.parse(strDate);

            formatter = new SimpleDateFormat("yyyy-MM-dd");
            strReturnValue = formatter.format(date);
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return strReturnValue;
        }
        return strReturnValue;

    }

public  static String convertdtDateForDB(Date strDate, String dateType) {
        String strReturnValue = null;
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat(dateType);

            formatter = new SimpleDateFormat("yyyy-MM-dd");
            strReturnValue = formatter.format(strDate);
         } catch (Exception e) {
            System.out.println("Exception :" + e);
            return strReturnValue;
        }
        return strReturnValue;

    }


public  static String convertdtDateForUI(Date strDate) {
        String strReturnValue = null;
        try {
            DateFormat formatter;
//            formatter = new SimpleDateFormat(dateType);

            formatter = new SimpleDateFormat("dd-MM-yyyy");
            strReturnValue = formatter.format(strDate);
         } catch (Exception e) {
            System.out.println("Exception :" + e);
            return strReturnValue;
        }
        return strReturnValue;

    }

public  static String convertdDateForUI(Date strDate) {
        String strReturnValue = null;
        try {
            DateFormat formatter;
//            formatter = new SimpleDateFormat(dateType);

            formatter = new SimpleDateFormat("dd-MM-yyyy");
            strReturnValue = formatter.format(strDate);
         } catch (Exception e) {
            System.out.println("Exception :" + e);
            return strReturnValue;
        }
        return strReturnValue;

    }
public static String convertDateForUI(String strDate, String dateType) {
        String strReturnValue = null;
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat(dateType);
            date = (Date) formatter.parse(strDate);

            formatter = new SimpleDateFormat("dd-MM-yyyy");
            strReturnValue = formatter.format(date);
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return strReturnValue;
        }
        return strReturnValue;

    }
}
