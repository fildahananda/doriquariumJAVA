package com.example.test;

import com.example.model.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    /** The test. */
    Point tes = new Point(3, 4);

    /**
     * Test point.
     */
    @Test
    public void testPoint() {
      assertEquals(3, tes.getX());
      assertEquals(4, tes.getY());
      tes.setX(5);
      tes.setY(6);
      assertEquals(5, tes.getX());
      assertEquals(6, tes.getY());
    }
}