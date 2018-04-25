package com.example.test;

import com.example.controller.SnailController;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnailControllerTest {

    SnailController snailController = new SnailController();

    @Test
    public void getSnails() {
        assertEquals(0, snailController.getSnails().size());
    }

    @Test
    public void addNewEntity() {
        snailController.addNewEntity();
        assertEquals(1, snailController.getSnails().size());
    }
}