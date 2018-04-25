package com.example.test;

import com.example.model.Guppy;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuppyTest {

    Guppy guppy = new Guppy();

    @Test
    public void testGuppy() {
        assertNotNull("Guppy ctor TEST FAIL", guppy);
        assertEquals("Guppy's hunger TEST FAIL", 0, guppy.getHunger());
        assertEquals("Guppy's state TEST FAIL",1, guppy.getState());
        guppy.hasEaten();
        guppy.hasEaten();
        assertEquals("Guppy's state TEST FAIL",3, guppy.getState());
    }
}