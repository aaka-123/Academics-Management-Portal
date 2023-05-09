package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class student {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";

    public boolean s_menu(String user) throws SQLException, IOException {
        Connection c = null;
        Statement stmt = null;
        boolean x = true;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Press 1 to see  your courses and grades:");
            System.out.println("Press 2 to register/deregister for a course:");
            System.out.println("Press 3 to calculate current CGPA:");
            System.out.println("Press 4 to logg out");
            student obj = new student();
            int inp = Integer.parseInt(reader.readLine());
            if (inp == 1) {
                disp_stu_course disp_stu_course = new disp_stu_course();
                disp_stu_course.dis_course(user);
                System.out.println();
            } else if (inp == 2) {
                System.out.println("Press 1 to register and 2 to deregister for a course:");
                inp = Integer.parseInt(reader.readLine());;
                if (inp == 1) {
                    stu_offr_courses stu_offr_courses = new stu_offr_courses();
                    String ans = stu_offr_courses.disp(user);
                    if (!ans.equals("No courses !!!")) {
                        System.out.println("Enter a course offer ID to register:");
                        int inp1 = Integer.parseInt(reader.readLine());;
                        register register = new register();
                        register.register(inp1, user);
                    }
                    System.out.println();
                } else if (inp == 2) {
                    c = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = c.createStatement();
                    register register = new register();
                    disp_stu_course disp_stu_course = new disp_stu_course();
                    disp_stu_course.dis_course(user);
                    System.out.println("Enter offer_ID to deregister!!");

                    int inp1 = Integer.parseInt(reader.readLine());;
                    register.deregister(user, inp1);
                    System.out.println();
                }
            } else if (inp == 3) {
                CGPA CGPA = new CGPA();
                CGPA.calc_gpa(user);
                System.out.println();
            } else {
                break;
            }
        }
        return x;
    }


}
