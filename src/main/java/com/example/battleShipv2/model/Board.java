package com.example.battleShipv2.model;

import com.example.battleShipv2.Entity.Battleship;

import java.util.ArrayList;

public class Board {
    private final ArrayList<Battleship> ships;
    private final int boardSize;

    public Board(int boardSize) {
        ships = new ArrayList<>();
        this.boardSize = boardSize;
    }

    public ArrayList<Battleship> getShips() {
        return ships;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public boolean fire(int x, int y) {
        Battleship ship;
        for (Battleship s : ships)
            if (s.existsAtTile(x, y) == TileContent.Alive_Ship) {
                ship = s;
                break;
            }

        
        return false;
    }
}
