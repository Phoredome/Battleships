package com.battleships.entity;

import com.battleships.model.TileContent;

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

    public TileContent existsAtTile(int x, int y) {
        // Find the section of the ship at the given coordinates.
        // At first we don't know that the coordinates are valid for this ship
        int section = -1;
        // Find if this ship occupies the given tile
        // If the ship is horizontal, the x coordinate must be equal
        // and the y coordinate can be up to 'length' higher
        if (orientation == HORIZONTAL &&
                x == this.x &&
                y >= this.y &&
                y < (this.y + sections.length))
            section = y - this.y;
        else if (orientation == VERTICAL &&
                y == this.y &&
                x >= this.x &&
                x < this.x + sections.length)
            section = x - this.x;

        if (section < 0)
            return TileContent.Empty;
        else if (sections[section])
            return TileContent.Hit_Ship;
        else
            return TileContent.Alive_Ship;
    }
}
