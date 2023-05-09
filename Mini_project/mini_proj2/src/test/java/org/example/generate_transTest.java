package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class generate_transTest {

    @Test
    void generate_transcript() throws IOException {

        generate_trans gen=new generate_trans();
        assertEquals(true,gen.generate_transcript("2020CSB1060"));
        assertEquals(false,gen.generate_transcript("2020CSB1070"));
    }
}