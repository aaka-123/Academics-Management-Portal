package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class disp_catTest {

    @Test
    void disp_course_cat() {
        disp_cat disp_cat=new disp_cat();
        assertEquals(true,disp_cat.disp_course_cat(1));
    }
}