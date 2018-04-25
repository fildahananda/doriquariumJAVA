package com.example.test;

import com.example.model.Piranha;
import org.junit.Test;

import static org.junit.Assert.*;

public class PiranhaTest {

    Piranha piranha = new Piranha();

    @Test
    public void testGuppy() {
        assertNotNull("Piranha ctor TEST FAIL", piranha);
        assertEquals("Piranha's hunger TEST FAIL", 0, piranha.getHunger());
        assertTrue("Piranha's facing TEST FAIL",piranha.isFacingRight());
    }
}