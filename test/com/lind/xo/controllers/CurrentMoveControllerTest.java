package com.lind.xo.controllers;

import com.lind.xo.model.Field;
import com.lind.xo.model.Figure;
import com.lind.xo.model.exceptions.AlreadyOccupiedException;
import com.lind.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void currentMoveNull() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field();
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < field.getSize(); i++) {
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.O);
            field.setFigure(new Point(2, i), Figure.X);
        }
        assertNull(currentMoveController.currentMove(field));
    }

    @Test
    public void currentMoveO() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field();
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < field.getSize(); i++) {
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.O);
            if (i < 2) {
                field.setFigure(new Point(2, i), Figure.X);
            }
        }
        assertEquals(Figure.X, currentMoveController.currentMove(field));
    }
}