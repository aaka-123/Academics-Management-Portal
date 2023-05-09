package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class stu_offr_courses {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";
    Connection c = null;
    Statement stmt = null;
    public  String disp(String user) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String query="select dept from student where entry_no="+"\'"+user+"\'";
            //    System.out.println(query);
            ResultSet rs=stmt.executeQuery(query);

            if(!rs.next()) {System.out.println("student does not exist"); return "student does not exist";}
            else{
                String dept=rs.getString(1);
                String query1 = "select offr_id,course_id,year,semester,instr_id,cgpa_req,type from course_offer where dept="+"\'"+dept+"\'";
                rs = stmt.executeQuery(query1);
                if(!rs.next() )
                {
                    System.out.println("No courses !!!");
                    return "No courses !!!";
                }
                else {
                    System.out.print("Offer Id"+"  ");
                    System.out.print("Course"+"  ");
                    System.out.print("year"+"  ");
                    System.out.print("semester"+"  ");
                    System.out.print("Instr_id"+"     ");
                    System.out.print("CGPA Required"+"  ");
                    System.out.print("type"+"  ");
                    System.out.println();
                    System.out.print(rs.getString(1)+"       ");
                    System.out.print(rs.getString(2)+"   ");
                    System.out.print(rs.getInt(3)+"  ");
                    System.out.print(rs.getInt(4)+"         ");
                    System.out.print(rs.getString(5)+"  ");
                    System.out.print(rs.getFloat(6)+"              ");
                    System.out.print(rs.getString(7)+"    ");
                    System.out.println();
                    while(rs.next())
                    {
                        System.out.print(rs.getString(1)+"       ");
                        System.out.print(rs.getString(2)+"   ");
                        System.out.print(rs.getInt(3)+"  ");
                        System.out.print(rs.getInt(4)+"         ");
                        System.out.print(rs.getString(5)+"  ");
                        System.out.print(rs.getFloat(6)+"              ");
                        System.out.print(rs.getString(7)+"    ");
                        System.out.println();
                    }
                    stmt.close();
                    c.close();
                    rs.close();
                    return "available";
                }
            }
        }
        catch (Exception e) {System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);return "error";}

    }
}
