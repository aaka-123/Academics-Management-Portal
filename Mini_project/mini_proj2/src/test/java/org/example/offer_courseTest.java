package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class offer_courseTest {

    @Test
    void offer_course() {
        offer_course ofr=new offer_course();

        assertEquals(true,ofr.offer_course("HS491","2008CSI1060", (float) 0));
    }
}