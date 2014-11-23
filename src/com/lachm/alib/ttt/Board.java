/*
 * Copyright (C) 2014 lLachlan McCartys
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
package com.lachm.alib.ttt;

import com.lachm.alib.ttt.BoardValues;

/**
 *
 * @author Lachlan McCarty
 */
public class Board {
    public static final int COL1 = 0;
    public static final int COL2 = 1;
    public static final int COL3 = 2;
    
    public static final int ROW1 = 0;
    public static final int ROW2 = 1;
    public static final int ROW3 = 2;
    
    private BoardValues[][] board = new BoardValues[3][3];
    
    public Board() {
        clear();
    }
    
    public boolean set(int col, int row, BoardValues value) {
        return false;
    }
    
    public boolean get() {
        return false;
    }
    
    public void clear() {
        for (BoardValues[] subarray : board) {
            for (BoardValues value : subarray) {
                value = BoardValues.EMPTY;
            }
        }
    }
}
