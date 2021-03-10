package com.example.battleShipv2.GUI;

public interface IWindow {
    int LEFT_BOARD = 0;
    int RIGHT_BOARD = 1;

    void drawHit(int board, int x, int y);
}
