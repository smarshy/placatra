
package UI;

import java.util.Date;
import javax.swing.JTextField;
import org.jbundle.thin.base.screen.jcalendarbutton.JTimeButton;

/**
 *
 * @author Vatsala
 */
public class datePopup {
   static Date dtString;
public static void datePopup (JTimeButton button,JTextField date_txt)
    {
        dtString=button.getTargetDate();
        try
        {
           if(dtString!=null)
           {
            String strDate=dateUIDB.convertdDateForUI(button.getTargetDate());
            date_txt.setText(strDate);
           }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
      
    }
}
