package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class facultyTest {

    @Test
    void faculty_6() throws SQLException, IOException {
        faculty faculty=new faculty();
        ByteArrayInputStream in=new ByteArrayInputStream("6\n".getBytes());
        System.setIn(in);
        assertTrue(faculty.f_menu("2020CSB1060"));
    }
    @Test
    void faculty_1() throws SQLException, IOException {
        faculty faculty=new faculty();
        ByteArrayInputStream in=new ByteArrayInputStream("1\n2008\n6\n".getBytes());
        System.setIn(in);
        assertTrue(faculty.f_menu("2020CSB1060"));
    }

    @Test
    void faculty_2() throws SQLException, IOException {
        faculty faculty=new faculty();
        ByteArrayInputStream in=new ByteArrayInputStream("2\n1\nCS546\n0\n6\n".getBytes());
        System.setIn(in);
        assertTrue(faculty.f_menu("2008CSI1060"));
    }


    @Test
    void faculty_3() throws SQLException, IOException {
        faculty faculty=new faculty();
        ByteArrayInputStream in=new ByteArrayInputStream("2\n2\n2004\n6\n".getBytes());
        System.setIn(in);
        assertTrue(faculty.f_menu("2008CSI1060"));
    }


    @Test
    void faculty_4() throws SQLException, IOException {
        faculty faculty=new faculty();
        ByteArrayInputStream in=new ByteArrayInputStream("3\n2034\n6\n".getBytes());
        System.setIn(in);
        assertTrue(faculty.f_menu("2008CSI1060"));
    }
    @Test
    void faculty_5() throws SQLException, IOException {
        faculty faculty=new faculty();
        ByteArrayInputStream in=new ByteArrayInputStream("4\n2020CSB1060\n6\n".getBytes());
        System.setIn(in);
        assertTrue(faculty.f_menu("2008CSI1060"));
    }

    @Test
    void faculty_7() throws SQLException, IOException {
        faculty faculty=new faculty();
        ByteArrayInputStream in=new ByteArrayInputStream("5\n2034\nC:\\Users\\Aakash\\IdeaProjects\\mini_proj\\src\\main\\java\\org\\example\\grades.csv\n6\n".getBytes());
        System.setIn(in);
        assertTrue(faculty.f_menu("2008CSI1060"));
    }



}