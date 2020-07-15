package com.lind.xo.controllers;

import com.lind.xo.model.Field;
import com.lind.xo.model.Figure;
import com.lind.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner (final Field field) {

        for (int i = 0; i < field.getSize(); i++) {
            if (getRow(field, i)) {
                try {
                    return field.getFigure(new Point(0, i));
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
            if (getColumn(field, i)) {
                try {
                    return field.getFigure(new Point(i, 0));
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        }

        if (getDiagonal(field)) {
            try {
                return field.getFigure(new Point(1, 1));
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    private boolean getRow (final Field field, int i) {

        try {
            if (field.getFigure(new Point(0, i)) != null &&
                    field.getFigure(new Point(1, i)) != null &&
                    field.getFigure(new Point(2, i)) != null &&
                    (field.getFigure(new Point(0 ,i)) ==
                    field.getFigure(new Point(1, i)) &&
                    field.getFigure(new Point(1, i)) ==
                    field.getFigure(new Point(2, i)))) {
                return true;
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return false;

    }

    private boolean getColumn(final Field field, int i) {
        try {
            if (field.getFigure(new Point(i, 0)) != null &&
                    field.getFigure(new Point(i, 1)) != null &&
                    field.getFigure(new Point(i, 2)) != null &&
                    field.getFigure(new Point(i,0)) ==
                    field.getFigure(new Point(i, 1)) &&
                    field.getFigure(new Point(i, 1)) ==
                    field.getFigure(new Point(i, 2))) {
                return true;
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean getDiagonal(final Field field) {
        try {
            if (field.getFigure(new Point(0, 0)) != null &&
                    field.getFigure(new Point(1, 1)) != null &&
                    field.getFigure(new Point(2, 2)) != null &&
                    (field.getFigure(new Point(0, 0)) ==
                    field.getFigure(new Point(1, 1)) &&
                    field.getFigure(new Point(1, 1)) ==
                    field.getFigure(new Point(2, 2)))) {
                return true;
            }


        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        try {
            if (field.getFigure(new Point(0, 2)) != null &&
                    field.getFigure(new Point(2, 0)) != null &&
                    field.getFigure(new Point(1, 1)) != null &&
                    (field.getFigure(new Point(2, 0)) ==
                     field.getFigure(new Point(1, 1)) &&
                     field.getFigure(new Point(1, 1)) ==
                     field.getFigure(new Point(0, 2)))) {
                return true;
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return false;
    }
}
