package com.lind.xo.controllers;

import com.lind.xo.model.Field;
import com.lind.xo.model.Figure;
import com.lind.xo.model.exceptions.InvalidPointException;

import java.awt.*;

import static com.lind.xo.model.Figure.X;
import static com.lind.xo.model.Figure.O;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {

        try {
            return countOfFigures(field);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Figure countOfFigures(final Field field) throws InvalidPointException {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (field.getFigure(new Point(i, j)) != null) {
                    if (field.getFigure(new Point(i, j)) == X) countX++;
                    else countO++;
                }
            }
        }
        if (countO + countX == 9) return null;
        if (countO == countX) return X;
        else return O;
    }

}
