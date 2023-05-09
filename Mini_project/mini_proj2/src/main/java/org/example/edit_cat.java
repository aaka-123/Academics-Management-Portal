package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class edit_cat {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";
    public  boolean add_to_cat(String name,String id,int l,int t,int p,int cr,String dept ,String type) {

boolean x=true;
Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String query1 = "insert into course_cat values('"+name+"\'"+","+"\'"+id+"\'"+","+l+","+t+","+p+","+cr+","+"\'"+dept+"\'"+","+"\'"+type+"\'"+")";
            stmt.executeUpdate(query1);System.out.println(query1);stmt.close();
            c.close();} catch (Exception e) {x=false;System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);
        }System.out.println("Course "+id +" has been added to course catalogue!!");
return x;}
    public boolean cat_delete(String id) {
        boolean x=true;
        Connection c = null;
        Statement stmt = null;
        try {c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            int sem=2;int yr=2020;
            String query1 = "delete from course_cat where course_id ="+"\'"+id+"\'";
            stmt.executeUpdate(query1);stmt.close();c.close();
        }
        catch (Exception e) {System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);}System.out.println("Course "+id+" has been deleted from catalogue!!!!");return x;}

}
