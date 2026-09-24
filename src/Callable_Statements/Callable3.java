package Callable_Statements;

import java.sql.*;

class Callable3{
    public static void main(String[] args) {
        try{
            Connection con = DBConn.getConn();

            CallableStatement cs = con.prepareCall("{call SecondHighestSalary()}");
            ResultSet rs = cs.executeQuery();

            while(rs.next()){
                System.out.println("Employee ID: " + rs.getInt(1));
                System.out.println("Employee Name: " + rs.getString(2));
                System.out.println("Department: " + rs.getString(3));
                System.out.println("Salary: " + rs.getDouble(4));
                System.out.println("-----------------------------");
            }

            rs.close();
            cs.close();
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}