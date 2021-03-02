package com.battleships.controller;

import com.battleships.model.Board;
import com.battleships.view.IWindow;

public class GameManager {
    Board player;
    Board computer;

    IWindow window;

    public GameManager(int boardSize) {
        player = new Board(boardSize);
        computer = new Board(boardSize);
    }
}
