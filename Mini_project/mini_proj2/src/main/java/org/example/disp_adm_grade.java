package org.example;

import java.sql.*;

public class disp_adm_grade {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";
    Connection c = null;
    Statement stmt = null;
    public  boolean disp(int ofr_id) throws SQLException {
        boolean x=true;
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String query = "select course_id,stu_id,year,sem,grade ,status from student_transcript t where t.offr_id="+ofr_id+"order by grade desc";
            // System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            if(!rs.next() )
            {x=false;System.out.println("No Students registered !!!");
            }
            else {
                System.out.print("Course"+"  ");
                System.out.print("Student ID"+"  ");
                System.out.print("Year" +"  ");
                System.out.print("sem"+"  ");
                System.out.print("Grade"+"  ");
                System.out.println("Status         ");
                System.out.print(rs.getString(1)+"   ");
                System.out.print(rs.getString(2)+" ");
                System.out.print(rs.getString(3)+"  ");
                System.out.print(rs.getString(4)+"    ");
                System.out.print(rs.getString(5)+"    ");
                System.out.println(rs.getString(6)+"   ");
                while(rs.next())
                {
                    System.out.print(rs.getString(1)+"   ");
                    System.out.print(rs.getString(2)+" ");
                    System.out.print(rs.getString(3)+"  ");
                    System.out.print(rs.getString(4)+"    ");
                    System.out.print(rs.getString(5)+"    ");
                    System.out.println(rs.getString(6)+"   ");
                }
                stmt.close();
                c.close();
                rs.close();
            }
        } catch (SQLException ex) {throw new RuntimeException(ex);}return x;

    }
}
