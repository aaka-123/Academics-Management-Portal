package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class studentTest {

    @Test
    void student_4() throws SQLException, IOException {
        student student=new student();
        ByteArrayInputStream in=new ByteArrayInputStream("4\n".getBytes());
        System.setIn(in);
        assertTrue(student.s_menu("2020CSB1060"));
    }

    @Test
    void student_2() throws SQLException, IOException {
        student student=new student();
        ByteArrayInputStream in=new ByteArrayInputStream("2\n1\n2034\n4\n".getBytes());
        System.setIn(in);
        assertTrue(student.s_menu("2020CSB1063"));
    }



    @Test
    void student_3() throws SQLException, IOException {
        student student=new student();
        ByteArrayInputStream in=new ByteArrayInputStream("2\n2\n2017\n4\n".getBytes());
        System.setIn(in);
        assertTrue(student.s_menu("2020CSB1062"));
    }





}