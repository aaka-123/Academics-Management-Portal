package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class offer_course {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";
    public  boolean offer_course(String c_id,String user,Float cg) {


boolean x=true;
        Connection c = null;
        Statement stmt = null;
        try {

            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();

            int sem=0;
            int yr=0;
            String q1="select sem from semester where status="+"\'"+"t"+"\'";
            String q2="select year from semester where status="+"\'"+"t"+"\'";
            ResultSet rs=stmt.executeQuery(q1);
            rs.next();
             sem=rs.getInt(1);

            rs=stmt.executeQuery(q2);
            rs.next();
            yr=rs.getInt(1);
            String q3="select * from course_offer where year="+yr+" and semester="+sem+" and course_id="+"\'"+c_id+"\'";
//   System.out.println(q3);
            String dept="select c.dept from course_cat c where c.course_id="+"\'"+c_id+"\'";
            rs=stmt.executeQuery(dept);
            rs.next();
            dept=rs.getString(1);
            String type="select c.type from course_cat c where c.course_id="+"\'"+c_id+"\'";
            rs=stmt.executeQuery(type);
            rs.next();
            type=rs.getString(1);
            rs=stmt.executeQuery(q3);
            if(rs.next())
            { x=false;System.out.println("The course is already being offered in this sem!!!");}
            else{
                String query1 = "insert into course_offer(course_id,year,semester,instr_id,cgpa_req,dept,type) values ('"+c_id+"\'"+","+yr+","+sem+","+"\'"+user+"\'"+","+cg+","+"\'"+dept+"\'"+","+"\'"+type+"\'"+")";
                stmt.executeUpdate(query1);
                System.out.println("The course "+c_id+" is now being offered by you in this sem!!!");
                stmt.close();c.close();rs.close();}}
        catch (Exception e) {x=false;System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);}return x;

    }
}
