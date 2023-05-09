package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Upload_gradesTest {

    @Test
    void enter_grade() {
        Upload_grades Upload_grades=new Upload_grades();
        assertEquals(true,Upload_grades.enter_grade(2007,"C:\\Users\\Aakash\\IdeaProjects\\mini_proj\\src\\main\\java\\org\\example\\grades.csv"));
    }
}