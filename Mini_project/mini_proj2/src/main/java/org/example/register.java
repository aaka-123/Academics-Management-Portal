package org.example;

import java.sql.*;
import java.util.Scanner;

public class register {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";


    public boolean deregister(String s,int inp1) {

boolean x=true;

        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = c.createStatement();
            String course;
            String query = "select status,course_id from student_transcript where stu_id=" +"\'"+s+"\'" +" and offr_id="+inp1;
             System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            if (!rs.next()) { x=false;
                System.out.println("Enter correct offer id!!!");
            } else {
                query = rs.getString(1);
                course = rs.getString(2);
                rs.close();
                if (query.equals("completed")) {x=false;
                    System.out.println("Course has already Completed!!!");
                } else {
                    query = "delete from student_transcript where stu_id='" + s + "\'" + "and offr_id=" + inp1;
                    stmt.executeUpdate(query);
                    System.out.println("You have  dropped course " + course + ".");
                }
                stmt.close();
                c.close();
            }
        }
        catch(Exception e) {x=false;System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);}


return x;

}


    public  boolean register(int offr_id,String id) {
        boolean x = true;
        Connection c = null;
        Statement stmt = null;
        int adm_year = 0;
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();


            String query1 = "CREATE OR REPLACE FUNCTION check_eligibility( id varchar,ofr_id int,adm_yr int) RETURNS text AS $$  DECLARE pre_req text[]; var text; cmt int;sem int; yr int; c_cred float; cred_lt float; curr_cred int; curr_sem int; curr_yr int; course text; cgpa float; cgpa_req float; count int;  satisfy int; r1 record;rec record; cr CURSOR FOR (select * from student_transcript where offr_id=ofr_id and stu_id=id);  c CURSOR (key text) FOR (select * from student_transcript s where s.stu_id=id and s.course_id=key);  BEGIN cmt=0; OPEN cr;Loop FETCH FROM cr INTO r1;if not found then exit ; else cmt=1;end if;end loop;close cr;if cmt=1 then return 'You are already registered in this course'; end if; yr=(select year from course_offer c where c.offr_id=ofr_id);  sem=(select semester from course_offer c where c.offr_id=ofr_id);  curr_yr=(select year from semester where status='t'); curr_sem=(select s.sem from semester s where status='t'); cgpa_req=(select c.cgpa_req from course_offer c where c.offr_id=ofr_id); cgpa=calc_gpa(id); course =(select course_id from course_offer c where c.offr_id=ofr_id);  pre_req=(select p.pre_req from pre_req p,course_offer c where p.course_id=c.course_id and c.offr_id=ofr_id);  count=0; c_cred=(select distinct(ct.c) from course_cat ct,course_offer o where ct.course_id=o.course_id and ct.course_id=course);  if curr_sem=2 then cred_lt= (select sum(t.credits) from student_transcript t where((t.year=yr and t.sem=1) or (t.year=yr-1 and t.sem=2))  and t.stu_id=id );  else cred_lt= (select sum(t.credits) from student_transcript t where t.year=yr-1  );  end if; curr_cred= (select sum(ct.c) from course_cat ct,student_transcript t where (t.year=curr_yr and t.sem=curr_sem and t.stu_id=id and t.course_id=ct.course_id) );  curr_cred=curr_cred+c_cred;  if curr_yr=adm_yr then cred_lt=18; else cred_lt=cred_lt/2;cred_lt=1.25*cred_lt; end if; if curr_cred> cred_lt then  return 'Credit limit is exceeding!!!';  end if; if  cgpa<cgpa_req  then return 'CGPA criteria  not satisifed!!';  elseif yr!=curr_yr or curr_sem!=sem then return 'This course is not offered in the current semester!!!'; end if; IF array_length(pre_req, 1) > 0 THEN foreach var in array pre_req  loop satisfy=0; OPEN c(var); Loop FETCH FROM c INTO rec; if not found then exit ; else  if rec.grade!='F' and rec.grade!='E' and rec.grade!='NA' then satisfy=1; end if; count=count+1; end if; end Loop; CLOSE c;  if count=0 or satisfy=0 then return 'You do not satisfy the pre requisites for this course!!';  end if; end loop;end if; return 'Yes you are eligible for this course'; end; $$language plpgsql; ";

            String adm = id.substring(0, 4);
            adm_year = Integer.parseInt(adm);
            // System.out.println(query1);
            stmt.executeUpdate(query1);

            stmt.close();
            c.close();


        } catch (Exception e) {System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);}

        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            CallableStatement cst = c.prepareCall("{call check_eligibility(?,?,?,?)}");

            cst.setString(1, id);
            cst.setInt(2, offr_id);
            cst.setInt(3, adm_year);
            cst.registerOutParameter(4, Types.VARCHAR);
            cst.execute();

            String ans = cst.getString(4);
          System.out.println(ans);
            cst.close();
            c.close();

            if (ans.equals("Yes you are eligible for this course")) {


                String c_id = "select course_id from course_offer where offr_id=" + offr_id;
                String year = "select year from course_offer where offr_id=" + offr_id;

                String sem = "select semester from course_offer where offr_id=" + offr_id;

                // offr_id |   stu_id    | course_id | year | sem | grade | credits
                String cs_id = new String();
                int yr = 0;
                int sm = 0;
                int crd = 0;

                c = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = c.createStatement();

                // String query2 = "select name from instructor where instr_id="+"\,"++"\'";
                // System.out.println(c_id);
                ResultSet rs = stmt.executeQuery(c_id);
                rs.next();
                cs_id = rs.getString(1);
                rs = stmt.executeQuery(year);
                rs.next();
                yr = rs.getInt(1);
                rs = stmt.executeQuery(sem);
                rs.next();
                sm = rs.getInt(1);

                String cred = "select c from course_cat where course_id=" + "\'" + cs_id + "\'";
                String type = "select type from course_cat where course_id=" + "\'" + cs_id + "\'";
                rs = stmt.executeQuery(type);
                rs.next();
                type = rs.getString(1);
                // String query2 = "select name from instructor where instr_id="+"\,"++"\'";
                System.out.println(cred);

                rs = stmt.executeQuery(cred);
                rs.next();
                crd = rs.getInt(1);
                String query = "insert into student_transcript values(" + offr_id + "," + "\'" + id + "\'" + "," + "\'" + cs_id + "\'" + "," + yr + "," + sm + "," + "\'" + "NA" + "\'" + ",0,'running'," + "\'" + type + "\'" + ");";
                System.out.println(query);
                stmt.executeUpdate(query);
                //  rs.next();
                System.out.println("Your Registration into course " + cs_id + " has been done.");

                stmt.close();
                c.close();
                rs.close();

            } else {
                x = false;
            }

        } catch (Exception e) {x = false;System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);
        }

        return x;


    }}
