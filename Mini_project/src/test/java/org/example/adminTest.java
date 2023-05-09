package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class adminTest {

    @Test
    void admin_7() throws SQLException, IOException {
        admin admin=new admin();
        ByteArrayInputStream in=new ByteArrayInputStream("7\n".getBytes());
        System.setIn(in);
        assertTrue(admin.a_menu("2020CSB1060"));
    }

//    @Test
////    void admin_1() throws SQLException, IOException {
////        admin admin=new admin();
////        ByteArrayInputStream in=new ByteArrayInputStream("1\n2023\n2\n7\n".getBytes());
////        System.setIn(in);
////        assertTrue(admin.a_menu("2020CSB1062"));
////    }
    @Test
    void


    admin_2() throws SQLException, IOException {
        admin admin=new admin();
        ByteArrayInputStream in=new ByteArrayInputStream("2\n1\nmaths\nMA202\n2\n1\n3\n3\nCSE\nPE\n7".getBytes());
        System.setIn(in);
        assertTrue(admin.a_menu("2020CSB1062"));
    }
    @Test
    void admin_3() throws SQLException, IOException {
        admin admin=new admin();
        ByteArrayInputStream in=new ByteArrayInputStream("3\n2004\n7".getBytes());
        System.setIn(in);
        assertTrue(admin.a_menu("2020CSB1062"));
    }


    @Test
    void admin_4() throws SQLException, IOException {
        admin admin=new admin();
        ByteArrayInputStream in=new ByteArrayInputStream("4\n2020CSB1060\n7".getBytes());
        System.setIn(in);
        assertTrue(admin.a_menu("2020CSB1062"));
    }

    @Test
    void admin_5() throws SQLException, IOException {
        admin admin=new admin();
        ByteArrayInputStream in=new ByteArrayInputStream("5\n2020CSB1060\n7".getBytes());
        System.setIn(in);
        assertTrue(admin.a_menu("2020CSB1062"));
    }
    @Test
    void admin_6() throws SQLException, IOException {
        admin admin=new admin();
        ByteArrayInputStream in=new ByteArrayInputStream("5\n2020CSB1060\n7".getBytes());
        System.setIn(in);
        assertTrue(admin.a_menu("2020CSB1062"));
    }
//
//
//
//    @Test
//    void student_5() throws SQLException, IOException {
//        admin admin=new admin();
//        ByteArrayInputStream in=new ByteArrayInputStream("5\n2020CSB1060\n7\n".getBytes());
//        System.setIn(in);
//        assertTrue(admin.a_menu("2020CSB1062"));
//    }
//    @Test
//    void student_4() throws SQLException, IOException {
//        admin admin=new admin();
//        ByteArrayInputStream in=new ByteArrayInputStream("4\n2020CSB1060\n7\n".getBytes());
//        System.setIn(in);
//        assertTrue(admin.a_menu("2020CSB1062"));
//    }
//    @Test
//    void student_3() throws SQLException, IOException {
//        admin admin=new admin();
//        ByteArrayInputStream in=new ByteArrayInputStream("3\nCS202\n7\n".getBytes());
//        System.setIn(in);
//        assertTrue(admin.a_menu("2020CSB1062"));
//    }
}