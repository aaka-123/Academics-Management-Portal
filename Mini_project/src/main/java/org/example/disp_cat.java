package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class disp_cat {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";
    public  boolean disp_course_cat(int a) {
boolean x=true;
Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String query1 = "select name,course_id,l,t,p,c,dept,type from course_cat ";

            System.out.println(query1);
            ResultSet rs = stmt.executeQuery(query1);

            if(!rs.next() )
            {
                System.out.println("No courses to offer !!!");
            }
            else {
                System.out.print("Name"+"                                             ");
                System.out.print("Course Id"+"  ");
                System.out.print("L"+"  ");
                System.out.print("T"+"  ");
                System.out.print("P"+"  ");

                System.out.print("C"+"  ");
                System.out.print("Department"+"  ");
                System.out.print("Type"+"  ");
                System.out.println();
                String p=rs.getString(1);
                String s="";
                System.out.print(p);
                for(int i=0;i<50-p.length();i++)
                {
                    System.out.print(" ");
                }


                System.out.print(rs.getString(2)+"     ");
                System.out.print(rs.getString(3)+"  ");
                System.out.print(rs.getString(4)+"  ");
                System.out.print(rs.getString(5)+"  ");
                System.out.print(rs.getString(6)+"  ");
                System.out.print(rs.getString(7)+"         ");
                System.out.print(rs.getString(8)+"    ");


                System.out.println();
                while(rs.next())
                {
                    p=rs.getString(1);
                    s="";
                    System.out.print(p);
                    for(int i=0;i<50-p.length();i++)
                    {
                        System.out.print(" ");
                    }

                    System.out.print(rs.getString(2)+"     ");
                    System.out.print(rs.getString(3)+"  ");
                    System.out.print(rs.getString(4)+"  ");
                    System.out.print(rs.getString(5)+"  ");
                    System.out.print(rs.getString(6)+"  ");
                    System.out.print(rs.getString(7)+"         ");
                    System.out.print(rs.getString(8)+"    ");

                    System.out.println();
                }
                stmt.close();
                c.close();
                rs.close();
            }

        }
        catch (Exception e) {x=false;System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);
        }
        return x;

    }
}
