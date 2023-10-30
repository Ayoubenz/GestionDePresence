package util;


import javax.management.Query;
import java.sql.*;
public class DatabaseConnectionManager {

    private static String url = AppConfig.getDbUrl();
    private static String userName = AppConfig.getDbUsername();
    private static String passWord = AppConfig.getDbPassword();
    public static Connection getConnection() throws SQLException{

        Connection con = DriverManager.getConnection(url, userName, passWord);

        return con;
    }
}
