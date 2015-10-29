

package DataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vatsala
 */
public class RegisterDataAccess {
    public static List selectData(String query){
        ResultSet rs;
        //collection for dynamic memory
        List<List> dataFromQuery=new ArrayList();
        Connection conn = DBConnection.getConnection();
        try {
            //before passing query,we need a statement
            Statement stmt = conn.createStatement();
            //now executing query on statement channel
            rs = stmt.executeQuery(query);
            //background /all info about table along with data will be stored in resultset
            ResultSetMetaData rsmd = rs.getMetaData();
            //while we keep getting data row by row
            while(rs.next()){
                //every time a new arraylist created ,in which we will add data columnwise
                List rows = new ArrayList();
                for(int i=1;i<=rsmd.getColumnCount();i++){  
                    rows.add(rs.getString(i));
                }  
                //after each row,adding it to dataFromQuery list,which we intend to return
                dataFromQuery.add(rows);
            }
            conn.close();
        } catch (Exception ex) {
            //incase exception thrown,displays error dialog box-we have imported file required for this
            JOptionPane.showMessageDialog(null, "Database Connection error");
        }
        
        return dataFromQuery;
    }
    
    public static void insertStudentDetails(String query){
        Connection conn= DBConnection.getConnection();
        try {
            Statement stmt = conn.createStatement();
            //method called accordingly as per return type of method
            int i = stmt.executeUpdate(query);
            System.out.println(i);
            if(i>0){
                //returns no of rows affected-if affected,successful updation
                JOptionPane.showMessageDialog(null,"Update Successful");
            }else{
                JOptionPane.showMessageDialog(null,"Update Unsuccessful");
            }
        } 
        //we try to catch exception generated from sql queries
        catch (SQLException ex) {
            Logger.getLogger(RegisterDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}

