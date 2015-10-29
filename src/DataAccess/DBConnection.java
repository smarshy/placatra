
package DataAccess;

import java.sql.*;

public class DBConnection {
    //study/refer to connection class in sql package to know its methods
    public static Connection getConnection(){
        Connection con=null;
        String url="jdbc:mysql://localhost:3306/";
        String dbName="pplacement";
        String driver="com.mysql.jdbc.Driver";
        String user="root";
        String pass="root";
        int result=0;
        try{
            if(con==null || con.isClosed())
            {//used to connect with the database driver
                Class.forName(driver);
                //used to get connection through driver manager(agent) to database
                con=DriverManager.getConnection(url+dbName, user, pass);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        return con;
    }
    
}
