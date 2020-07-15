package com.lind.xo.controllers;

import com.lind.xo.model.Field;
import com.lind.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getWinner() throws Exception{

        final Field field = new Field();
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < field.getSize(); i++) {
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }

    }
}