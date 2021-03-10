package com.battleships;

import com.battleships.controller.GameManager;
import com.battleships.gui.BoardGUI;

public class BattleshipApplication {
    public static void main(String[] args) {
        GameManager m = new GameManager(5, BoardGUI.class);
        BoardGUI board = new BoardGUI();

        //setSampleEnemyBoatBoard();

        board.createMainBoard();

        //to call/show the board window
        //board.setSize(400,400);
        //board.setVisible(true);
        //or call the method which makes JFrame from BoardGUI class, like below:
        //demo();
    }
}
