package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class fac_offr_courseTest {

    @Test
    void disp() {
        fac_offr_course fac_offr_course=new fac_offr_course();

        assertEquals(true,fac_offr_course.disp("2008CSi1060",2002));
    }
}