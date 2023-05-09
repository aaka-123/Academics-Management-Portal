package org.example;

import java.sql.*;

public class disp_all_offr {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres"; Connection c = null;
    Statement stmt = null;
    public boolean disp(int a)
    {
        boolean x=true;
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String query1 = "select offr_id,course_id,year,semester,instr_id,cgpa_req,type from course_offer ";
            // String query2 = "select name from instructor where instr_id="+"\,"++"\'";
            // System.out.println(query1);
            ResultSet rs = stmt.executeQuery(query1);
            if(!rs.next() )
            {x=false;System.out.println("No courses !!!");
            }
            else {System.out.print("Offer Id" + "  ");
                System.out.print("Course" + "  ");
                System.out.print("year" + "  ");
                System.out.print("semester" + "  ");
                System.out.print("Instr_id" + "     ");
                System.out.print("CGPA Required" + "  ");
                System.out.print("type" + "  ");
                System.out.println();
                System.out.print(rs.getString(1) + "       ");
                System.out.print(rs.getString(2) + "   ");
                System.out.print(rs.getString(3) + "  ");
                System.out.print(rs.getString(4) + "         ");
                System.out.print(rs.getString(5) + "  ");
                System.out.print(rs.getString(6) + "              ");
                System.out.print(rs.getString(7) + "    ");
                System.out.println();
                while (rs.next()) {
                    System.out.print(rs.getString(1) + "       ");
                    System.out.print(rs.getString(2) + "   ");
                    System.out.print(rs.getString(3) + "  ");
                    System.out.print(rs.getString(4) + "         ");
                    System.out.print(rs.getString(5) + "  ");
                    System.out.print(rs.getString(6) + "              ");
                    System.out.print(rs.getString(7) + "    ");
                    System.out.println();
                }
            }
        }catch (SQLException e) {throw new RuntimeException(e);
        }
        return x;
    }
}
