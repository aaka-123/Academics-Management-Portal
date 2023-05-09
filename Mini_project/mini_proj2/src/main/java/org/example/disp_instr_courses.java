package org.example;

import java.sql.*;

public class disp_instr_courses {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres"; Connection c = null;
    Statement stmt = null;

    public boolean disp(String id) {
        boolean x = true;
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String query1 = "select offr_id,course_id,year,semester,cgpa_req from course_offer where instr_id=" + "\'" + id + "\'";
            ResultSet rs = stmt.executeQuery(query1);
            if (!rs.next()) {
                x=false;
                System.out.println("No courses !!!");
            } else {
                System.out.print("Offer Id" + "  ");
                System.out.print("Course" + "  ");
                System.out.print("year" + "  ");
                System.out.print("semester" + "  ");
                System.out.print("CGPA Required" + "  ");
                System.out.println();
                System.out.print(rs.getString(1) + "       ");
                System.out.print(rs.getString(2) + "   ");
                System.out.print(rs.getString(3) + "  ");
                System.out.print(rs.getString(4) + "         ");
                System.out.print(rs.getString(5) + "              ");
                System.out.println();
                while (rs.next()) {
                    System.out.print(rs.getString(1) + "       ");
                    System.out.print(rs.getString(2) + "   ");
                    System.out.print(rs.getString(3) + "  ");
                    System.out.print(rs.getString(4) + "         ");
                    System.out.print(rs.getString(5) + "  ");
                    System.out.println();}
                stmt.close();c.close();}
        } catch (SQLException e) {throw new RuntimeException(e);}
        return x;
    }
}
