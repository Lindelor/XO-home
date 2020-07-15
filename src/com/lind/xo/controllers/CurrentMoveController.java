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
        int countFigure = 0;
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (field.getFigure(new Point(i, j)) != null) {
                    countFigure += 1;
                }
            }
        }
        if (countFigure == 9) {return null;}
        if ((countFigure % 2) == 0) {return X;}
        else return O;
    }

}
