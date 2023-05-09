package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Upload_grades {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";

    public  boolean enter_grade(int ofr_id,String path) {
boolean x=true;

        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();


                int cred=0;
                String crd="select ct.c from course_cat ct,course_offer co where ct.course_id=co.course_id and co.offr_id="+ofr_id;
               ResultSet rs = stmt.executeQuery(crd);
               rs.next();
int cr=0;
               if(rs.next()) cr=rs.getInt(1);
                BufferedReader reader = null;
                String line = "";


                reader = new BufferedReader(new FileReader(path));
                while((line = reader.readLine()) != null) {

                    String[] row = line.split(",");
                    //String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                    //use this if your values already contain commas
                    int i=0;
                    String grade=new String();
                    String user=new String();
                    for(String index : row) {

                        // System.out.printf("%s ", index);
                        if(index.length()<4)
                        {
                            grade=index;
                        }
                        else{
                            user=index;
                        }


                    }

                    if(!grade.equals('E') && (!grade.equals('F'))) cred=cr;
                    else cred=0;
                   String query1 = "select * from student_transcript where stu_id="+"\'"+user+"\'"+" and offr_id="+ofr_id;
                    // String query2 = "select name from instructor where instr_id="+"\,"++"\'";
                    // System.out.println(query1);
                    rs = stmt.executeQuery(query1);

                    if(!rs.next() )
                    {
                        System.out.println("Student "+user+" does not exist.");

                    }
                    else {
                        query1="update student_transcript set grade='"+grade+"\'"+",status='completed', "+"credits="+cred+" where stu_id='"+user+"\'"+" and offr_id="+ofr_id;
                        stmt.executeUpdate(query1);

                        System.out.println("Grades entered for user  "+user);
                    }






                }reader.close();
                stmt.close();
                c.close();
                rs.close();
        }
        catch (Exception e) {x=false;System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);}


return x;
    }
}
