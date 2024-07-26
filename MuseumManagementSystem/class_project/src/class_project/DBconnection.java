package class_project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    static final String DB_URL = "jdbc:mysql://localhost/museumdb";
    static final String USER = "root";
    static final String PASS = "";

    public static Connection connectDB() {
        Connection conn = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");//loading the driver 
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        } catch (Exception ex) {
            System.out.println("connection error.");
            return null;
        }

    }
}
