package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CGPATest {

    @Test
    void calc_gpa() {

        CGPA CGPA=new CGPA();
        assertEquals(true,CGPA.calc_gpa("2020CSB1061"));
    }

    @Test
    void calc_sgpa() {
        CGPA CGPA=new CGPA();
        assertEquals(true,CGPA.calc_sgpa("2020CSB1061",2020,2));

    }
}