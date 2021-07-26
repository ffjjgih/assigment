
package Sqlsever;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class Connect {

    
    private static  String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLSV";
    private static  String USER = "sa";
    private static  String PASS = "123456";

    public static java.sql.Connection getConnection() throws Exception{
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        
    }
}
