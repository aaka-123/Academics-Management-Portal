package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class registerTest {

    @Test
    void deregister() {
        register register=new register();

        assertEquals(false,register.deregister("2020CSB1063",2007));
        assertEquals(false,register.deregister("2020CSB1060",2001));

    }

    @Test
    void register() {
        register register=new register();
        assertEquals(true,register.register(2005,"2020CSB1063"));
        assertEquals(false,register.register(2017,"2020CSB1062"));
    }

}