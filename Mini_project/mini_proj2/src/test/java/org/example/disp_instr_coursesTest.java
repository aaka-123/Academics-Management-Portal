package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class disp_instr_coursesTest {

    @Test
    void disp() {
        disp_instr_courses disp_instr_courses=new disp_instr_courses();
        assertEquals(true,disp_instr_courses.disp("2008CSI1060"));
    }
}