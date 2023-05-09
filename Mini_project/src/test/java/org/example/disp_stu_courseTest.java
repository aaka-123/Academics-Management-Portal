package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class disp_stu_courseTest {

    @Test
    void dis_course() {
        disp_stu_course disp_stu_course=new disp_stu_course();
        assertEquals(true,disp_stu_course.dis_course("2020CSB1060"));
    }
}