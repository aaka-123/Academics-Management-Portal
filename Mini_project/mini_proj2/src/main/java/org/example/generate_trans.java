package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class generate_trans {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";

    public boolean generate_transcript(String id) throws IOException
    {
        boolean x=true;

        Connection c = null;
        Statement stmt = null;
        FileWriter fw=new FileWriter("C:\\Users\\Aakash\\IdeaProjects\\mini_proj\\src\\main\\java\\org\\example\\transcript.txt");
        PrintWriter bw=new PrintWriter(fw);
        try {
            c = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = c.createStatement();
            float cg=0,sg=0,cred_reg=0,cred_earned=0;
            String adm=id.substring(0,4);
            int adm_yr=Integer.parseInt(adm);
            //   System.out.println(adm_yr);
            //   System.exit(0);
            int sem=2;
            String name=new String();
            String entry_no=new String();
            String q12="select name,entry_no from student where entry_no="+"\'"+id+"\'";
            //  System.out.println(q12);
            ResultSet rs = stmt.executeQuery(q12);
            if(!rs.next()) {x=false;
                System.out.println("No student with this id") ;
            }

            else{
                name=rs.getString(1);



                entry_no=rs.getString(2);
            }


            //  System.out.println("erre");

            String q10="select sem from semester where status="+"\'"+"t"+"\'";
            String q11="select year from semester where status="+"\'"+"t"+"\'";
            //  System.out.println(q11);
            rs= stmt.executeQuery(q11);
            rs.next();
            int curr_yr=rs.getInt(1);

            rs= stmt.executeQuery(q10);
            rs.next();
            //  System.out.println(q10);
            int curr_sem=rs.getInt(1);


            bw.print("Name: "+name);
            bw.println("     Entry Number: "+entry_no+"   ");
            int dif=curr_yr-adm_yr;
            for(int j=0;j<=dif;j++)
            {
                if(adm_yr>curr_yr) continue;
                for(int m=1;m<=2;m++)
                {
                    sem=m;
                    if(adm_yr==curr_yr && m==curr_sem) continue;
                    String query = "select t.course_id,ct.name,t.grade from student_transcript t,course_cat ct where t.year="+adm_yr+" and t.sem="+sem+" and t.stu_id='"+id+"\'"+" and t.course_id=ct.course_id";
                    // System.out.println(query);
                    String q2="select calc_sgpa('"+id+"\'"+","+adm_yr+","+sem+")";
                    String q3="select calc_gpa('"+id+"\'"+")";
                    String q4="select sum(t.credits) from student_transcript t where t.year="+curr_yr+" and t.sem="+sem+" and t.stu_id='"+id+"\'";
                    String q5="select sum(ct.c) from student_transcript t,course_cat ct where t.year="+curr_yr+" and t.sem="+sem+" and t.stu_id='"+id+"\'"+"and t.course_id=ct.course_id";
                    rs = stmt.executeQuery(q2);
                    rs.next();
                    sg=rs.getFloat(1);

                    rs =  stmt.executeQuery(q3);
                    rs.next();
                    cg=rs.getFloat(1);

                    rs =  stmt.executeQuery(q4);
                    rs.next();
                    cred_earned=rs.getFloat(1);

                    rs = stmt.executeQuery(q5);
                    rs.next();
                    cred_reg=rs.getFloat(1);
                    rs=  stmt.executeQuery(query);

                    if(!rs.next() )
                    {
                        System.out.println("No courses done by student in  year "+adm_yr+"and "+"semester "+sem);
                    }
                    else {

                        bw.print("Session: "+adm_yr+"-"+sem);
                        bw.print("     SGPA: "+sg);
                        bw.print("     Credits Registered: "+cred_reg);
                        bw.print("     Credits Earned: "+cred_earned);
                        bw.print("      CGPA: "+cg);
                        bw.print("\n");
                        bw.print("Course Id"+"  ");
                        bw.print("Course Name"+"                             ");
                        bw.print("Grade"+"  ");
                        bw.print("\n");
                        bw.print(rs.getString(1)+"      ");
                        String p=rs.getString(2);
                        String s="";
                        bw.print(p);
                        for(int o=0;o<40-p.length();o++)
                        {
                            bw.print(" ");
                        }
                        bw.print(rs.getString(3)+"     ");
                        bw.println("\n");
                        while(rs.next())
                        {  bw.print(rs.getString(1)+"      ");
                            p=rs.getString(2);
                            s="";
                            bw.print(p);
                            for(int n=0;n<40-p.length();n++)
                            {
                                bw.print(" ");
                            }
                            bw.print(rs.getString(3)+"     ");
                            bw.print("\n");
                        }}}
                if(sem==2) adm_yr++;
                bw.print(" \n ");
                bw.print("  \n    ");
            }
            stmt.close();
            c.close();
            rs.close();
        }
        catch (Exception e) {x=false;System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);}
        bw.close();
        return x;
    }

}
