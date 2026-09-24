package Prepared_Statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Prepared_Select {

    public static void main(String[] args) throws Exception {

        Connection con = DBConn.getConn();

        String sql = "SELECT * FROM employee";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            System.out.println("Employee ID   : " + rs.getInt("empid"));
            System.out.println("Employee Name : " + rs.getString("empname"));
            System.out.println("Department    : " + rs.getString("dept"));
            System.out.println("Salary        : " + rs.getDouble("sal"));
            System.out.println("-----------------------------");
        }

        rs.close();
        ps.close();
        con.close();
    }
}
