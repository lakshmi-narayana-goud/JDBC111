package Prepared_Statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

class Employee {

    int empid;
    String empname;
    String dept;
    double sal;

    public Employee(int empid, String empname, String dept, double sal) {
        this.empid = empid;
        this.empname = empname;
        this.dept = dept;
        this.sal = sal;
    }
}

public class Prepared_Insertion {

    public static void main(String[] args) throws Exception {

        Connection con = DBConn.getConn();

        String sql = "INSERT INTO employee(empid, empname, dept, sal) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "John Doe", "IT", 50000));
        employees.add(new Employee(2, "Jane Smith", "HR", 45000));
        employees.add(new Employee(3, "Bob Johnson", "Finance", 55000));

        ArrayList<Employee> insertedEmployees = new ArrayList<>();

        for (Employee emp : employees) {

            String checkSql = "SELECT COUNT(*) FROM employee WHERE empid = ?";

            PreparedStatement checkStmt = con.prepareStatement(checkSql);

            checkStmt.setInt(1, emp.empid);

            ResultSet rs = checkStmt.executeQuery();

            rs.next();

            int count = rs.getInt(1);

            rs.close();
            checkStmt.close();

            if (count == 0) {

                ps.setInt(1, emp.empid);
                ps.setString(2, emp.empname);
                ps.setString(3, emp.dept);
                ps.setDouble(4, emp.sal);

                ps.addBatch();

                insertedEmployees.add(emp);

                System.out.println("Added to batch: " + emp.empid);

            } else {

                System.out.println(
                    "Employee with ID " + emp.empid +
                    " already exists. Skipping insertion."
                );
            }
        }

        int[] result = ps.executeBatch();

        System.out.println("\nInsertion completed.");

        for (int i = 0; i < result.length; i++) {

            System.out.println(
                "Employee " + insertedEmployees.get(i).empid +
                " inserted successfully."
            );
        }

        ps.close();
        con.close();
    }
}