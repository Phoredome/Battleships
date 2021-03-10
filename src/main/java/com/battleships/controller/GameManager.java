package com.battleships.controller;

import com.battleships.entity.Board;
import com.battleships.gui.BattleshipGUI;
import com.battleships.gui.IWindow;

public class GameManager {
    Board player;
    Board computer;

    IWindow window;

    public int x,y;
    public MouseEventHandler gui_sho = new MouseEventHandler();

    public Board board;
    public BattleshipGUI battleshipGUI;

    public GameManager(int boardSize) {
        player = new Board(boardSize);
        computer = new Board(boardSize);
    }

    
}
