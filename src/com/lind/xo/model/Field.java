package com.lind.xo.model;


import com.lind.xo.model.exceptions.InvalidPointException;
import com.lind.xo.model.exceptions.AlreadyOccupiedException;

import java.awt.*;

public class Field {

    private static final int FIELD_SIZE = 3;

    private final Figure[][] figures = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return figures[(int)point.getX()][(int)point.getY()];

    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        if (figures[(int)point.getX()][(int)point.getY()] != null) {
            throw new AlreadyOccupiedException();
        }
        figures[(int) point.getX()][(int) point.getY()] = figure;

    }

    private boolean checkPoint(final Point point) {
        return (checkValid((int)point.getX()) && checkValid((int)point.getY()));

    }

    private boolean checkValid(final int coordinate) {
        if (coordinate < 0 || coordinate >= FIELD_SIZE) {return false;}
        return true;
    }





}
