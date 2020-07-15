package com.lind.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() {
        final String testName = "Testp";
        final String expectedName = "Testp";

        final Player player = new Player(testName, null);

        final String realValue = player.getName();

        assertEquals(expectedName, realValue);
    }

    @Test
    public void getFigure() {
        final Figure testFigure = Figure.X;
        final Figure expectedFigure = Figure.X;

        final Player player = new Player(null, testFigure);

        final Figure realValue = player.getFigure();

        assertEquals(expectedFigure, realValue);
    }
}