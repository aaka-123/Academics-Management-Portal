package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class disp_adm_gradeTest {

    @Test
    void disp() throws SQLException {
        disp_adm_grade disp_adm_grade=new disp_adm_grade();

        assertEquals(true,disp_adm_grade.disp(2007));
    }
}