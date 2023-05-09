package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class faculty {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";


    public boolean f_menu(String user) throws SQLException, IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Connection c = null;
        Statement stmt = null;
        boolean x = true;
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("Press 1 to see  your ongoing courses and grades:");
            System.out.println("Press 2 to offer/register a course or deregister a course:");
            System.out.println("Press 3  to see grades for different academic courses:");
            System.out.println("Press 4  to see grades for a particular student:");
            System.out.println("Press 5 to upload grades:");
            System.out.println("Press 6 to logg out");
            faculty obj = new faculty();
            int inp = Integer.parseInt(reader.readLine());
            if (inp == 1) {
                disp_instr_courses disp_instr_courses = new disp_instr_courses();
                disp_instr_courses.disp(user);
                System.out.println("Enter Offer Id of the course to see grade: ");
                int ofr_id =Integer.parseInt(reader.readLine());
                fac_offr_course fac_offr_course = new fac_offr_course();
                fac_offr_course.disp(user, ofr_id);
            } else if (inp == 2) {
                System.out.println("Press 1 to register/offer a course:");
                System.out.println("Press 2 to deregister a course:");
                inp =Integer.parseInt(reader.readLine());
                if (inp == 1) {
                    disp_cat disp = new disp_cat();
                    disp.disp_course_cat(1);
                    System.out.println("Enter course ID of the course to offer:");
                    String inp1 =reader.readLine();
                    System.out.println("Enter the CGPA requirement for the course : ");
                    Float cg_req = Float.parseFloat(reader.readLine());
                    offer_course oc = new offer_course();
                    oc.offer_course(inp1, user, cg_req);
                } else {
                    disp_instr_courses disp_instr_courses = new disp_instr_courses();
                    disp_instr_courses.disp(user);
                    System.out.println("Enter Offer Id of the course to delete: ");

                    int ofr_id = Integer.parseInt(reader.readLine());
                    drop_offer drop_offer = new drop_offer();
                    drop_offer.drop(ofr_id);
                }
            } else if (inp == 3) {
                disp_all_offr disp_all_offr = new disp_all_offr();
                disp_all_offr.disp(1);
                System.out.println("Enter Offer Id of the course for which you want to see the grades.");

                int ofr_id = Integer.parseInt(reader.readLine());;
                disp_adm_grade disp_adm_grade = new disp_adm_grade();
                disp_adm_grade.disp(ofr_id);
            } else if (inp == 4) {
                System.out.println("Enter User Id of the student:");
                Scanner s = new Scanner(System.in);
                String id = reader.readLine();
                id = id.toUpperCase();
                disp_stu_course disp_stu_course = new disp_stu_course();
                disp_stu_course.dis_course(id);
            } else if (inp == 5) {
                disp_instr_courses disp_instr_courses = new disp_instr_courses();
                disp_instr_courses.disp(user);
                System.out.println("Enter Offer Id of the course to enter grades: ");
                int ofr_id = Integer.parseInt(reader.readLine());
                System.out.println("Enter Path of your .csv file: ");

                String path = reader.readLine();
                Upload_grades upload = new Upload_grades();
                upload.enter_grade(ofr_id, path);
            } else {
                break;
            }
        }
        return x;
    }


}