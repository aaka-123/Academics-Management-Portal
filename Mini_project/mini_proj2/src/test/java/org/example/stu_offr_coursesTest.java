package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class stu_offr_coursesTest {

    @Test
    void disp() {

        stu_offr_courses stu_offr_courses=new stu_offr_courses();
        assertEquals("available",stu_offr_courses.disp("2020CSB1061"));
    }
}