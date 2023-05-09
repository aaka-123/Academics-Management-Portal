package org.example;
import java.io.*;

import java.util.Scanner;
import java.sql.*;

public class Main {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/aims";

    static final String USER = "postgres";
    static final String PASS = "postgres";


    //////////////////////////////////////////////////////////////////

    // Main driver method
    public static boolean main(String[] args) throws IOException, SQLException {
        boolean x=true;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        Connection c = null;
        Statement stmt = null;
        while(true) {System.out.println("Press 1 to login and 2 to exit!!");

            int a=Integer.parseInt(reader.readLine());if(a==2) break;
            else {System.out.println("                   Welcome to aims portal!!!!");
                System.out.println("Enter User Name: ");

                String user = reader.readLine();
                user = user.toUpperCase();
                System.out.println("Enter Password: ");
                String pswd = reader.readLine();
                pswd = pswd.toLowerCase();
                String cnt = "select count(*) from auth where user_name=" + "\'" + user + "\'";
                String uname = "select role from auth where user_name=" + "\'" + user + "\'";
                String pwd = "select pswd from auth where user_name=" + "\'" + user + "\'";
                int reg = 0;try {c = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = c.createStatement();ResultSet rs = stmt.executeQuery(cnt);
                    rs.next();reg = rs.getInt(1);stmt.close();c.close();
                    rs.close();}
                catch (Exception e) {System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);}
                if (reg == 0) {System.out.println("User is not registered!!!");}
                else {
                    try
                    {
                        c = DriverManager.getConnection(DB_URL, USER, PASS);
                        stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery(pwd);
                        rs.next();
                        pwd = rs.getString(1);stmt.close();
                        c.close();rs.close();}
                    catch (Exception e) {System.err.println(e.getClass().getName() + ": " + e.getMessage());System.exit(0);}
                    if (pwd.equals(pswd)) {
                        try {c = DriverManager.getConnection(DB_URL, USER, PASS);
                            stmt = c.createStatement();
                            ResultSet rs = stmt.executeQuery(uname);
                            rs.next();uname = rs.getString(1);
                            stmt.close();c.close();rs.close();}
                        catch (Exception e) {System.err.println(e.getClass().getName() + ": " + e.getMessage());
                            System.exit(0);}
                        if (uname.equals("student")) {student student=new student();student.s_menu(user);}
                        else if (uname.equals("faculty")) {faculty faculty=new faculty();faculty.f_menu(user);}
                        else {admin admin=new admin();admin.a_menu(user);}}else {System.out.println("Wrong Password");
                        break;
               }}}}


return x;
    }
}