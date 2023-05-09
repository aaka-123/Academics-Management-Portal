package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class set_sem_yr {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";
    Connection c = null;
    Statement stmt = null;
    public  boolean set(int sem,int year)

    {
        boolean x=true;
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            int yr,sm;
            if(sem==1)
            {yr=year-1;sm=2;
            } else{sm=1;yr=year;}String query1="update semester set status='f' where year="+yr+" and sem="+sm;
            String query = "insert into semester values('"+year+"\'"+","+"\'"+sem+"\'"+","+"\'1"+"\'"+");";
            // System.out.println(query2);stmt.executeUpdate(query1);stmt.executeUpdate(query);stmt.close();
            c.close();}
        catch (Exception e) {x=false;System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);}return x;
    }}

