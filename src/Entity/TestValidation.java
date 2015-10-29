

package Entity;

import java.util.Calendar;



/**
 *
 * @author vatsala
 */
//for validation of your entered data-id,name,degree,etc.
public class TestValidation {
public static String checkIsID(String fid){
      int x=0;
      String err="";
      try{
          //casting exception
      x=Integer.parseInt(fid);
      if(x<0)
          err="Enter valid Id";
      }
      catch(NumberFormatException e){
           err= "Enter valid Id";
      }      
      return err;
}

public static String checkIsPerc(String per){
      double p;
      String err="";
     try{
         p=Double.parseDouble(per);
         if(p<0||p>100){
       err= "Enter valid Percentage";
       } 
     }
     catch(NumberFormatException e){
          return "Enter valid Percentage";
      } 
     return err ;
}

public static String checkIsEmail(String per){
      String email= "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
      String err="";
      if(!(per.matches(email)))
      {
          return "Enter valid Email_id.";
      }
      else
      {
           return err;
      }
 
}

public static String checkIsContact(String fid){
      String cntc="^[789]\\d{9}$";
      String err="";
     if(!(fid.matches(cntc))) 
     {
         return "Enter valid Contant no.";
     }
     else
     {
          return err;
     }
    
}

public static String checkIsPhone(String fid){
      String cntc="^[0-9]\\d{11}$";
      String err="";
     if(!(fid.matches(cntc))) 
     {
         return "Enter valid Contant no.";
     }
     else
     {
          return err;
     }
    
}

public static String checkIsYear(String fid){
      String err="";
      int this_year = Calendar.getInstance().get(Calendar.YEAR);
    if (fid.length() != 4) 
    {
         return "Enter valid year";
    }
    else{
        try{
       if(Integer.parseInt(fid) > this_year || Integer.parseInt(fid) < 1900)
            return "Enter valid year";
   }
   catch(NumberFormatException e)
   {
       return "Enter valid year";
   }
     
}
    return err;
}
}