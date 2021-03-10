package com.battleships.gui;

import com.battleships.controller.IFireHandler;

public interface IWindow {
    void drawHit(int x, int y);
    void drawMiss(int x, int y);
    void showMessage(String message);
    void addFireHandler(IFireHandler handler);
}
