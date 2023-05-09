package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class grad_checkTest {

    @Test
    void grad_check() {
        grad_check grad_check=new grad_check();
        assertEquals(false,grad_check.grad_check("2020CSB1060"));
    }
}