package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class set_sem_yrTest {

    @Test
    void set() {

        set_sem_yr set_sem_yr=new set_sem_yr();
        assertEquals(true,set_sem_yr.set(3,2023));
    }
}