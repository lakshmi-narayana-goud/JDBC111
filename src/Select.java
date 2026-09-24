import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {

    public static void main(String[] args) {

        try {
            Connection con = DBConn.getConn();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM employee";

            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("%-10s %-30s %-25s %-10s\n", "EmpID", "EmpName", "Department", "Salary");
            System.out.println("--------------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-10d %-30s %-25s %-10.2f\n",
                        rs.getInt("empid"),
                        rs.getString("empname"),
                        rs.getString("dept"),
                        rs.getDouble("sal"));
            }

            System.out.println("--------------------------------------------------------------------------------");

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}