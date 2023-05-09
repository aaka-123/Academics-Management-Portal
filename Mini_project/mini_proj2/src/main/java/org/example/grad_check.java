package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class grad_check {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";
    public boolean grad_check(String id)

    {id=id.toUpperCase();
        boolean x=true;
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
//            select sum(credits) from student_transcript where stu_id='2020CSB1060' and type='PC' and course_id!='CP301-1' and course_id!='CP301-2'and course_id!='CP301-3' and status='completed
            String query="select sum(credits) from student_transcript where (course_id=" +"\'"+"CP301-1"+"\'"+" or course_id=" +"\'" +"CP301-2" +"\'" +" or course_id="+"\'"+"CP301-3"+"\')"+" and status="+"\'"+"completed"+"\'"+"and stu_id="+"\'"+id+"\';";
            String query1="select sum(credits) from student_transcript where stu_id="+"\'"+id+"\'"+" and (status='completed')";
            String pc="select sum(credits) from student_transcript where stu_id="+"\'"+id+"\'"+" and type="+"\'"+"PC"+"\'"+" and course_id!='CP301-1' and course_id!='CP301-2'and course_id!='CP301-3' and status='completed' ";
            String pe="select sum(credits) from student_transcript where stu_id="+"\'"+id+"\'"+" and type="+"\'"+"PE"+"\'"+" and (status='completed')";
            String elec="select sum(credits) from student_transcript where stu_id="+"\'"+id+"\'"+" and type="+"\'"+"E"+"\'"+" and (status='completed')";
            System.out.println(query);
            System.out.println(pc);
              System.out.println(pe);
            System.out.println(elec);
            int a=0;
            try{
                c = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = c.createStatement();
              ResultSet rs=stmt.executeQuery(query);
                rs.next();
                 a=rs.getInt(1);
rs.close();
                System.out.println("q1");
            } catch (Exception e) {}

            if(a<9) {x=false;System.out.println("BTP course not done so cant graduate!!");}
            else{
                int tc=0,pc1=0,pe1=0,elec1=0;
                try{
                    c = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = c.createStatement();
                    ResultSet rs=stmt.executeQuery(query1);
                    rs.next();
                     tc=rs.getInt(1);
                     tc=tc-a;
                   System.out.println(tc);
                   rs.close();
                } catch (Exception e) {}
                try{
                    c = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = c.createStatement();
                   ResultSet rs=stmt.executeQuery(pc);
                    rs.next();
                     pc1=rs.getInt(1);
                    System.out.println(pc1);
                    rs.close();
                }
                catch (Exception e) {}
                try{
                    c = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = c.createStatement();
                   ResultSet rs=stmt.executeQuery(pe);
                    rs.next();
                     pe1=rs.getInt(1);
                    System.out.println(pe1);
rs.close();
                }
                catch (Exception e) {}
                try{
                    c = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = c.createStatement();
                   ResultSet rs=stmt.executeQuery(elec);
                    rs.next();
                     elec1=rs.getInt(1);
                    System.out.println(elec1);rs.close();
                } catch (Exception e) {}
                if(tc<120){x=false; System.out.println("Your total credits are less than 120 so can't graduate!!!");}
                else if(pc1<90) {x=false;System.out.println("Your program core  are less than 90 credits so can't graduate!!!");}
                else if(pe1<30){x=false;System.out.println("Your program elective  are less than 30 credits so can't graduate!!!");}
                else if(elec1<30){x=false;System.out.println("Your electives  are less than 30 credits so can't graduate!!!");}
                else{
                    x=false;
                    System.out.println("Eligible for graduation");
                }stmt.close();c.close();
            }
        } catch (Exception e) {System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);}return x;}

}
