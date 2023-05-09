package org.example;

import java.sql.*;

import java.io.FileWriter;
import java.io.IOException;



import java.io.*;

import java.util.Scanner;
public class admin {


    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";


    public boolean a_menu(String user) throws SQLException, IOException {
        Connection c = null;
        Statement stmt = null;
        boolean x=true;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Press 1 to see  set current year and semester: ");
            System.out.println("Press 2 to Update course catalogue:");
            System.out.println("Press 3 to see grades for different academic courses:");
            System.out.println("Press 4  to see grades for a particular student:");
            System.out.println("Press 5 to generate transcript: ");
            System.out.println("Press 6 for graduation check: ");
            System.out.println("Press 7 to logg out");
            // System.in is a standard input stream
            int inp = Integer.parseInt(reader.readLine());
            admin admin = new admin();
            if (inp == 1) {
                System.out.println("Enter current year: ");int year = Integer.parseInt(reader.readLine());
                System.out.println("Enter current sem (1 or 2): "); // System.in is a standard input stream
                int sem =Integer.parseInt(reader.readLine());set_sem_yr set_sem_yr = new set_sem_yr();
                set_sem_yr.set(sem, year);
            } else if (inp == 2) {
                disp_cat disp = new disp_cat();disp.disp_course_cat(1);
                System.out.println("Press 1 to add a course: ");System.out.println("Press 2 to delete a course: ");
                int inp1 = Integer.parseInt(reader.readLine());
                if (inp1 == 1) {int l=0;
                    System.out.println("Enter name of the new course: ");String name =reader.readLine() ;
                    System.out.println("Enter the course ID: ");String id = reader.readLine();System.out.println("Enter L: ");

                     l = Integer.parseInt(reader.readLine());System.out.println("Enter T: ");
                    int t = Integer.parseInt(reader.readLine());System.out.println("Enter P: ");
                    int p = Integer.parseInt(reader.readLine());System.out.println("Enter C: ");
                    int cr = Integer.parseInt(reader.readLine());System.out.println("Enter dept: ");
                    String dept = reader.readLine();
                    System.out.println("Enter type: ");String type = reader.readLine();edit_cat edit = new edit_cat();
                    edit.add_to_cat(name, id, l, t, p, cr, dept, type);
                } else {
                    System.out.println("Enter the course ID of the course to delete :");String id = reader.readLine();edit_cat edit = new edit_cat();edit.cat_delete(id);
                }
            } else if (inp == 3) {
                disp_all_offr disp_all_offr = new disp_all_offr();disp_all_offr.disp(1);
                System.out.println("Enter Offer Id of the course for which you want to see the grades.");
                int ofr_id = Integer.parseInt(reader.readLine());disp_adm_grade disp_adm_grade =new disp_adm_grade () ;
                disp_adm_grade.disp(ofr_id);
            } else if (inp == 4) {
                System.out.println("Enter User Id of the student:"); String id =reader.readLine();
                id = id.toUpperCase();disp_stu_course disp_stu_course = new disp_stu_course();disp_stu_course.dis_course(id);
            } else if (inp == 5) {
                System.out.println("Enter student Id for which you want to generate transcript:"); String id = reader.readLine();
                id = id.toUpperCase();generate_trans ob = new generate_trans();ob.generate_transcript(id);
            } else if (inp == 6) {
                System.out.println("Enter student Id for which you want to do grad check:"); String id = reader.readLine();
                id = id.toUpperCase();grad_check gd = new grad_check();gd.grad_check(id);
            }else {
                break;
            }
        }
        return x;

    }
}





