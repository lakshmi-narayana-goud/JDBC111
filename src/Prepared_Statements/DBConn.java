package Prepared_Statements;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

    public static Connection getConn() throws Exception {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url, username, password);
    }
}