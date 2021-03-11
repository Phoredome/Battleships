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

    public Battleship shipAtLocation(int x, int y) {
        //attempt to update ship at location and return Battleship for status update
        Battleship ship = null;
        for (Battleship s : ships)
            if (s.existsAtTile(x, y)) {
                ship = s;
                break;
            }


        return ship;
    }

    public boolean addShip(Battleship ship) {
        // Make sure the ship is completely on the board
        if (ship.getX() < 0 || ship.getY() < 0)
            return false;
        else if (ship.getOrientation() == Battleship.HORIZONTAL &&
                ship.getX() + ship.getLength() >= boardSize)
            return false;
        else if (ship.getOrientation() == Battleship.VERTICAL &&
                ship.getY() + ship.getLength() >= boardSize)
            return false;

        // Make sure the ship isn't intersecting with an existing one
        for (int i = 0; i < ship.getLength(); i++)
            if (ship.getOrientation() == Battleship.HORIZONTAL &&
                    shipAtLocation(ship.getX() + i, ship.getY()) != null)
                return false;
            else if (ship.getOrientation() == Battleship.VERTICAL &&
                    shipAtLocation(ship.getX(), ship.getY() + i) != null)
                return false;

        ships.add(ship);
        return true;
    }

    public int shipCount()
    {
        return ships.size();
    }

    public boolean allBoom ()
    {
        // check to see if all ships are dead
        for(Battleship b : ships)
            if(b.alive())
                return false;
        return true;
    }
}
