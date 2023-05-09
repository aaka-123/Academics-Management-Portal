package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class disp_stu_course {
    Connection c = null;
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";
    Statement stmt = null;
    public  boolean  dis_course(String s) {

        boolean x=true;

        Connection c = null;
        Statement stmt = null;
        try {
            x=true;
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String query = "select offr_id,course_id,year,sem,grade ,credits,status from student_transcript t where t.stu_id=" +"\'"+s+"\'"+"order by year desc  ,sem desc";
            // System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            if(!rs.next() )
            {
                x=false;
                System.out.println("No courses !!!");
            }
            else {
                x=true;
                System.out.print("Offer ID"+"  ");
                System.out.print("Course"+"  ");
                System.out.print("Year" +"  ");
                System.out.print("sem"+"  ");

                System.out.print("grade"+"  ");
                System.out.print("Credits_Earned   ");
                System.out.println("Status            ");

                System.out.print(rs.getString(1)+"      ");
                System.out.print(rs.getString(2)+"   ");
                System.out.print(rs.getString(3)+"  ");
                System.out.print(rs.getString(4)+"    ");
                System.out.print(rs.getString(5)+"      ");
                System.out.print(rs.getString(6)+"                ");
                System.out.println(rs.getString(7)+"   ");



                while(rs.next())
                {
                    System.out.print(rs.getString(1)+"      ");
                    System.out.print(rs.getString(2)+"   ");
                    System.out.print(rs.getString(3)+"  ");
                    System.out.print(rs.getString(4)+"    ");
                    System.out.print(rs.getString(5)+"      ");
                    System.out.print(rs.getString(6)+"                ");
                    System.out.println(rs.getString(7)+"   ");

                }

            }


            stmt.close();
            c.close();
            rs.close();

        }
        catch (Exception e) {x=false;System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);}
        return x;
    }


}
