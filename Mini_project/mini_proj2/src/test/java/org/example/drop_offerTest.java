package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class drop_offerTest {

    @Test
    void drop() {
        drop_offer drop_offer=new drop_offer();
        assertEquals(true,drop_offer.drop(2007));
    }
}