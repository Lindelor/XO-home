package com.lind.xo.controllers;

import com.lind.xo.model.Field;
import com.lind.xo.model.Figure;
import com.lind.xo.model.exceptions.AlreadyOccupiedException;
import com.lind.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws AlreadyOccupiedException,
                                                        InvalidPointException {

        field.setFigure(point, figure);

    }

}
