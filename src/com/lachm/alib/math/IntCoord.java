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
 *
 * @author Lachlan McCarty
 */
public class IntCoord {
    private int x;
    private int y;
    
    /**
     * Construct an object to hold x and y values.
     * In AimlessLib everything involving rows and columns (unless otherwise stated) uses the x value for rows and the y values for columns.
     * @param x The x or row value.
     * @param y The y or column value.
     */
    public IntCoord(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {return x;}
    
    public int getRow() {return x;}
    
    public int getY() {return y;}
    
    public int getCol() {return y;}
}
