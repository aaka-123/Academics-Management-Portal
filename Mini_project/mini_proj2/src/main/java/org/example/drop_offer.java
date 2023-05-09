package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class drop_offer {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";
    Connection c = null;
    Statement stmt = null;

    public boolean drop(int ofr_id) {
        boolean x = true;
        String course = new String();
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            course = "select course_id from course_offer where offr_id=" + ofr_id;
            ResultSet rs = stmt.executeQuery(course);
            rs.next();
           if(rs.next()) course = rs.getString(1);
            String query1 = "delete from course_offer where offr_id=" + ofr_id;
            stmt.executeUpdate(query1);

            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);
        }
        System.out.println("Course " + course + " has been deregistered!!");

        return x;
    }

}
