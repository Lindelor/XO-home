package com.lind.xo.view;

import com.lind.xo.controllers.CurrentMoveController;
import com.lind.xo.controllers.MoveController;
import com.lind.xo.controllers.WinnerController;
import com.lind.xo.model.Field;
import com.lind.xo.model.Figure;
import com.lind.xo.model.Game;
import com.lind.xo.model.exceptions.AlreadyOccupiedException;
import com.lind.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ViewInConsole {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();

    public void show(final Game game) {

        final Field field = game.getField();
        System.out.format("Game Name: %s", game.getName());
        System.out.println("\n");
        for (int i = 0; i < field.getSize(); i++){
            printLine(field, i);
            if (i < field.getSize() - 1) {
                System.out.println("\n~~~~~~~~~");
            }
        }

    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            final Figure winner = winnerController.getWinner(field);
            if (winner == null) {
                System.out.println("It's a Draw");
                return false;
            }
        }
        System.out.format("\nPlease enter coordinate for %s", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            e.printStackTrace();
            System.out.println("Point is invalid!");
        }
        if (winnerController.getWinner(field) != null) {
            System.out.format("Winner is %s\n", winnerController.getWinner(field));
            return false;
        }
        return true;

    }

    private Point askPoint() {
        return new Point(askCoordinate("Y") - 1, askCoordinate("X") - 1);
    }

    private int askCoordinate (final String coordinateName) {
        System.out.format("\nPlease input: %s", coordinateName);
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private void printLine(final Field field, final int i) {

        for (int j = 0; j < field.getSize(); j++) {
            Figure figure;
            try {
                figure = field.getFigure(new Point(i, j));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
            if (j < field.getSize() - 1) {
                System.out.print((figure != null ? figure : " ") + " | ");
            }
            else {
                System.out.print(figure != null ? figure : " ");
            }
        }

    }

}
