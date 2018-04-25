package com.example.test;

import com.example.controller.GameLoopController;
import com.example.controller.ISubController;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameLoopControllerTest {

  /**
   * The sub controllers.
   */
  private List<ISubController> subControllers;

  /**
   * The grass.
   */
  GameLoopController tes = new GameLoopController(subControllers);

  /**
   * Test food.
   */
  @Test
  public void testGameLoopController() {
    assertFalse(tes.isAppPaused());
    tes.togglePause();
    assertTrue(tes.isAppPaused());
  }
}