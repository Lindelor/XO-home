package com.lind.xo;

import com.lind.xo.model.Field;
import com.lind.xo.model.Figure;
import com.lind.xo.model.Game;
import com.lind.xo.model.Player;
import com.lind.xo.view.ViewInConsole;

public class XOCLI {

    public static void main(final String[] args) {
        final String name1 = "Lind";
        final String name2 = "Kek";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Field(), "XO");

        final ViewInConsole viewInConsole = new ViewInConsole();

        viewInConsole.show(gameXO);

        while(viewInConsole.move(gameXO)) {
            viewInConsole.show(gameXO);
        }
    }

}
