package Prepared_Statements;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Prepared_Deletion {

    public static void main(String[] args) throws Exception {

        Connection con = DBConn.getConn();

        String sql = "DELETE FROM employee WHERE empid = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        // Delete employee with ID 1
        ps.setInt(1, 1);

        int result = ps.executeUpdate();

        if (result > 0) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }

        ps.close();
        con.close();
    }
}
