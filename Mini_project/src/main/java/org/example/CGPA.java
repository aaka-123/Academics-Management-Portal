package org.example;

import java.sql.*;
import java.io.*;

import java.util.Scanner;
import java.sql.*;

public class CGPA {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";

    public  boolean calc_gpa(String id) {
    boolean x=true;
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String query = " CREATE OR REPLACE FUNCTION calc_gpa( id varchar) RETURNS float AS $$  DECLARE pre_req text[];  cred_point float; earned_cred float; cgpa float; rec record;  c CURSOR (key text) FOR (select t.grade ,ct.c,t.credits from student_transcript t,course_cat ct where t.stu_id=key and ct.course_id=t.course_id);  BEGIN  cred_point=0; earned_cred=0; OPEN c(id);  Loop FETCH FROM c INTO rec;  if not found then exit ; else  if rec.grade='A' then cred_point=cred_point+(10*(rec.c)); elseif rec.grade='A-' then cred_point=cred_point+(9*(rec.c)); elseif rec.grade='B' then cred_point=cred_point+(8*(rec.c)); elseif rec.grade='B-' then cred_point=cred_point+(7*(rec.c)); elseif rec.grade='C' then cred_point=cred_point+(6*(rec.c)); elseif rec.grade='C-' then cred_point=cred_point+(5*(rec.c)); elseif rec.grade='D' then cred_point=cred_point+(4*(rec.c)); elseif rec.grade='D-' then cred_point=cred_point+(3*(rec.c)); end if;end if; end loop;  CLOSE c; OPEN c(id);  Loop FETCH FROM c INTO rec;  if not found then exit ; else  if rec.grade!='Z' and  rec.grade!='S' and  rec.grade!='NP' and rec.grade!='NF' then  earned_cred=earned_cred+(rec.credits); end if; end if; end loop; CLOSE c; if earned_cred=0  then return 0; else  cgpa=cred_point/earned_cred; cgpa=(select ROUND(cgpa::numeric, 2)); return cgpa; end if; end;  $$ language plpgsql;";
            // System.out.println(query);
            stmt.executeUpdate(query);

            CallableStatement cst = c.prepareCall("{call calc_gpa(?,?)}");

            cst.setString(1,id);

            cst.registerOutParameter(2, Types.FLOAT);

            cst.execute();
            System.out.println("Function executed successfully");
            double ans= cst.getDouble(2);
            System.out.println(ans);
            // System.out.println(pnr);
            cst.close();
            stmt.close();
            c.close();

        }
        catch (Exception e) {x=false;System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);}
return x;
    }

    public boolean calc_sgpa(String id,int yr,int sm) {
        Connection c = null;
        Statement stmt = null;
        boolean x=true;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            String query = "  CREATE OR REPLACE FUNCTION calc_sgpa( id varchar,yr int,sm int) RETURNS float AS $$  DECLARE pre_req text[];   cred_point float; earned_cred float; sgpa float; rec record;c CURSOR (key text,semm int,yrr int) FOR (select t.grade ,ct.c,t.credits from student_transcript t,course_cat ct where t.stu_id=key and ct.course_id=t.course_id and t.year=yrr and t.sem=semm);  BEGIN  cred_point=0; earned_cred=0; OPEN c(id,sm,yr);  Loop FETCH FROM c INTO rec;  if not found then exit ; else  if rec.grade='A' then cred_point=cred_point+(10*(rec.c));  elseif rec.grade='A-' then cred_point=cred_point+(9*(rec.c));  elseif rec.grade='B' then cred_point=cred_point+(8*(rec.c)); elseif rec.grade='B-' then cred_point=cred_point+(7*(rec.c));  elseif rec.grade='C' then cred_point=cred_point+(6*(rec.c)); elseif rec.grade='C-' then cred_point=cred_point+(5*(rec.c));  elseif rec.grade='D' then cred_point=cred_point+(4*(rec.c)); elseif rec.grade='D-' then cred_point=cred_point+(3*(rec.c)); elseif rec.grade='E' then cred_point=cred_point+(2*(rec.c));  end if;end if; end loop;  CLOSE c; OPEN c(id,sm,yr);  Loop FETCH FROM c INTO rec;  if not found then exit ;  else  if rec.grade!='Z' and  rec.grade!='S' and  rec.grade!='NP' and rec.grade!='NF' then  earned_cred=earned_cred+(rec.c);  raise notice '%',earned_cred;end if; end if; end loop; CLOSE c; if earned_cred=0  then return 0; else  sgpa=cred_point/earned_cred;  sgpa=(select ROUND(sgpa::numeric, 2)); return sgpa; end if; end;  $$ language plpgsql;";
            // System.out.println(query);
            stmt.executeUpdate(query);
            CallableStatement cst = c.prepareCall("{call calc_sgpa(?,?,?,?)}");
            cst.setString(1,id);
            cst.setInt(2,yr);
            cst.setInt(3,sm);

            cst.registerOutParameter(4, Types.DOUBLE);

            cst.execute();

            Double ans= cst.getDouble(4);
            System.out.println(ans);
            cst.close();
            stmt.close();
            c.close();
        }
        catch (Exception e) {System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);x=false;}
        return x;
    }

}
