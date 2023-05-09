package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class edit_catTest {

    @Test
    void add_to_cat() {
        edit_cat edit_cat=new edit_cat();
        assertEquals(true,edit_cat.add_to_cat("Industrial Management","HS301",3,1,0,3,"CSE","PE"));
    }

    @Test
    void cat_delete() {
        edit_cat edit_cat=new edit_cat();
        assertEquals(true,edit_cat.cat_delete("HS301"));
    }
}