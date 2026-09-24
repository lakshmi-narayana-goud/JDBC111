import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the employee ID to delete:");
        int empid = sc.nextInt();

        try {
            Connection con = DBConn.getConn();
            Statement stmt = con.createStatement();

            String sql = "DELETE FROM employee WHERE empid=" + empid;

            int rowsAffected = stmt.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("No record found with the given ID.");
            }

            stmt.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}