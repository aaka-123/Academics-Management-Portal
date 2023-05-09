package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class disp_all_offrTest {

    @Test
    void disp() {
        disp_all_offr disp_all_offr =new disp_all_offr();
        assertEquals(true,disp_all_offr.disp(1));
    }
}