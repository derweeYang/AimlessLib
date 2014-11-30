/*
 * Copyright (C) 2014 Lachlan McCarty
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.lachm.alib.math;

/**
 * Object that holds integer x and y values.
 * @author Lachlan McCarty
 */
public class IntCoord implements Coord {
    private int x;
    private int y;
    
    /**
     * Construct an object to hold integer x and y values.
     * By default the coordinate is (0,0).
     */
    public IntCoord() {
        this.x = 0;
        this.y = 0;
    }
    /**
     * Construct an object to hold integer x and y values.
     * @param x The x or row value.
     * @param y The y or column value.
     */
    public IntCoord(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {return x;}
    public void setX(int x) {this.x = x;}
    
    public int getY() {return y;}
    public void setY(int y) {this.y = y;}
    
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
