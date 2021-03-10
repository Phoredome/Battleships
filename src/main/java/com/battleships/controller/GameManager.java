package com.battleships.controller;

import com.battleships.entity.Board;
import com.battleships.gui.BattleshipGUI;
import com.battleships.gui.IWindow;

import java.lang.reflect.InvocationTargetException;

public class GameManager<T extends IWindow> implements IFireHandler{
    Board player;

    IWindow window;

    public int x,y;
    public MouseEventHandler gui_sho = new MouseEventHandler();

    public Board board;
    public BattleshipGUI battleshipGUI;

    public GameManager(int boardSize, Class<T> guiClass){
        try {
            window = guiClass.getConstructor().newInstance();
            window.addFireHandler(this);
        }
        catch (NoSuchMethodException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException e) {

        }
        player = new Board(boardSize);
    }


    @Override
    public void fire(int x, int y) {
        board.fire(x, y);
        // Do shit
    }
}
