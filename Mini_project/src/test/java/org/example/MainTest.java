package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main2() throws SQLException, IOException {
        Main main=new Main();


        ByteArrayInputStream in=new ByteArrayInputStream("2\n".getBytes());
        System.setIn(in);
        assertTrue(Main.main(new String[]{"dh"}));


    }

    @Test
    void main1() throws SQLException, IOException {
        Main main=new Main();


        ByteArrayInputStream in=new ByteArrayInputStream("1\n2020CSB1060\niitropa\n2\n".getBytes());
        System.setIn(in);
        assertTrue(Main.main(new String[]{"dh"}));


    }
}