package Callable_Statements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
public class Callable {
    public static void main(String[] args) {
        
        int count = 0;

        try{

            Connection con = DBConn.getConn();

            CallableStatement cs = con.prepareCall("{call GetEmployees()}");

            ResultSet rs = cs.executeQuery();


            while(rs.next()){
                System.out.println("empid: " + rs.getInt(1));
                System.out.println("empname: " + rs.getString(2));
                System.out.println("dept: " + rs.getString(3));
                System.out.println("sal: " + rs.getDouble(4));
                System.out.println("====================================");
                count++;
            }
            System.out.println("Total Employees: " + count);
            
            rs.close();
            cs.close();
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
