import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Update{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the id of the record to update:");
        int empid = sc.nextInt();
        sc.nextLine();   // consume the leftover newline
        
        System.out.println("Enter the new name:");
        String empname = sc.nextLine();
        
        System.out.println("Enter the new department:");
        String dept = sc.nextLine();
        
        System.out.println("Enter the new salary:");
        double sal = sc.nextDouble();

        try {
            Connection con = DBConn.getConn();
            Statement stmt = con.createStatement();
            String sql = "UPDATE employee SET empname='" + empname +
                    "', dept='" + dept +
                    "', sal=" + sal +
                    " WHERE empid=" + empid;

            System.out.println(sql);
            
            int rowsAffected = stmt.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record found with the given id.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}