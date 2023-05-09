package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class disp_gradeTest {

    @Test
    void disp() {

        disp_grade disp_grade=new disp_grade();
        assertEquals(true,disp_grade.disp(2007));
        assertEquals(false,disp_grade.disp(2008));
    }
}