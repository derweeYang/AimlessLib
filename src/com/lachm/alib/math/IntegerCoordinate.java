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
public interface IntegerCoordinate {
    /**
     * Set the coordinate's x and y values.
     * @param x the x value
     * @param y the y value
     */
    void setCoord(int x, int y);
    
    int getX();
    void setX(int x);
    
    int getY();
    void setY(int y);
    
    void move(int dx, int dy);
}
