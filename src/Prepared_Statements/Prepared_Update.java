package Prepared_Statements;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Prepared_Update {

    public static void main(String[] args) throws Exception {

        Connection con = DBConn.getConn();

        String sql = "UPDATE employee SET sal = ? WHERE empid = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        // New salary
        ps.setDouble(1, 60000);

        // Employee ID
        ps.setInt(2, 1);

        int result = ps.executeUpdate();

        if (result > 0) {
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }

        ps.close();
        con.close();
    }
}
