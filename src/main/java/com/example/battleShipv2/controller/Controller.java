package com.example.battleShipv2.controller;

import com.example.battleShipv2.Entity.Battleship;
import com.example.battleShipv2.model.Board;

import java.util.Random;

public class Controller {

    private final Board board;
    Random rand;

    public Controller() {
        rand = new Random();
        board = new Board(7);
        // Two 3-tile ships
        while (board.shipCount() < 2) {
            Battleship ship = new Battleship(
                    3,
                    rand.nextInt(7),
                    rand.nextInt(7),
                    rand.nextBoolean() ? Battleship.HORIZONTAL : Battleship.VERTICAL
            );
            board.addShip(ship);
        }
        // One 4-tile ship
        while (board.shipCount() < 3) {
            Battleship ship = new Battleship(
                    4,
                    rand.nextInt(7),
                    rand.nextInt(7),
                    rand.nextBoolean() ? Battleship.HORIZONTAL : Battleship.VERTICAL
            );
            board.addShip(ship);
        }
    }

    public boolean hit(int x, int y)
    {
        Battleship ship = board.shipAtLocation(x,y);
        if (ship != null)
            return ship.hit(x,y);
        return false;
    }

    public boolean gameEnd()
    {
        return board.allBoom();
    }

    public boolean miss(int x, int y)
    {
        Battleship ship = board.shipAtLocation(x,y);
        return ship == null;
    }



}
