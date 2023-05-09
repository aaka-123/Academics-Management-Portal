package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class fac_offr_course {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";
    Connection c = null;
    Statement stmt = null;
    public boolean disp(String id, int ofr_id) {
        boolean x = true;
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();

            disp_grade disp_grade=new disp_grade();
            x = disp_grade.disp(ofr_id);stmt.close();c.close();} catch (Exception e) {System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);
        }return x;

    }
}
