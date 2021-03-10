package com.battleships.entity;

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

    public Battleship fire(int x, int y) {
        //attempt to update ship at location and return Battleship for status update
        Battleship ship = null;
        for (Battleship s : ships)
            if (s.existsAtTile(x, y) == TileContent.Alive_Ship) {
                ship = s;
                break;
            }

        
        return ship;
    }

    public boolean allBoom ()
    {
        // check to see if all ships are dead
        boolean boom = true;

        for(Battleship b : ships)
            if(!b.isSunk())
                boom = false;

        return boom;
    }



}
