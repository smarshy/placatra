

package UI;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author Vatsala
 */
public class datefn {

static String date;
public  static String Date(JTextField date_lbl)
    {
    Calendar cal = new GregorianCalendar();
    int month = cal.get(Calendar.MONTH);
    int year = cal.get(Calendar.YEAR);
    int day = cal.get(Calendar.DAY_OF_MONTH);
    date_lbl.setText( + day + "-" + (month + 1) + "-" + year );
       return  date;
    }

public static  String L_Date(JLabel date_lbl)
    {
    Calendar cal = new GregorianCalendar();
    int month = cal.get(Calendar.MONTH);
    int year = cal.get(Calendar.YEAR);
    int day = cal.get(Calendar.DAY_OF_MONTH);
    date_lbl.setText( + day + "-" + (month + 1) + "-" + year );
       return  date;
    }


public  static String C_Date(JComboBox date_cmb)
    {
    Calendar cal = new GregorianCalendar();
    int month = cal.get(Calendar.MONTH);
    int year = cal.get(Calendar.YEAR);
    int day = cal.get(Calendar.DAY_OF_MONTH);
    date_cmb.addItem( + day + "-" + (month + 1) + "-" + year );
    date_cmb.setSelectedItem(+ day + "-" + (month + 1) + "-" + year );
       return  date;
    }

}
