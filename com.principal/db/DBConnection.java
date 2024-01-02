package db;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

static Connection con;
static String url = "jdbc:mysql://localhost:3306/students_system";
static String pass = "";
static String user = "root";

    public static Connection getDBConnection() {
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Get connection
        
            con = DriverManager.getConnection(url, user, pass);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}


