package com.example.battleShipv2.Entity;

import com.example.battleShipv2.model.TileContent;

public class Battleship {
    public static final int VERTICAL = 0;
    public static final int HORIZONTAL = 1;

    private final int x;
    private final int y;
    private final int orientation;
    private final boolean[] sections;

    public Battleship(int length, int x, int y, int orientation) {
        sections = new boolean[length];
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getOrientation() {
        return orientation;
    }

    public boolean[] getSections() {
        return sections;
    }

    public boolean alive() {
        for (boolean section : sections)
            if (!section)
                return true;
        return false;
    }

    public boolean hit(int x, int y) {
        int segment = -1;
        if (orientation == VERTICAL &&
                x == this.x &&
                y >= this.y &&
                y < this.y + sections.length)
            segment = y - this.y;
        else if (orientation == HORIZONTAL &&
                y == this.y &&
                x >= this.x &&
                x < this.x + sections.length)
            segment = x - this.x;
        if (segment >= 0 && segment < sections.length && !sections[segment])
            return sections[segment] = true;
        else
            return false;
    }

    public int getLength()
    {
        return sections.length;
    }

    public boolean existsAtTile(int x, int y) {
        // Find the section of the ship at the given coordinates.
        // At first we don't know that the coordinates are valid for this ship
        // Find if this ship occupies the given tile
        // If the ship is horizontal, the x coordinate must be equal
        // and the y coordinate can be up to 'length' higher
        return ((orientation == VERTICAL &&
                x == this.x &&
                y >= this.y &&
                y < this.y + sections.length) ||
                (orientation == HORIZONTAL &&
                        y == this.y &&
                        x >= this.x &&
                        x < this.x + sections.length));
    }
}