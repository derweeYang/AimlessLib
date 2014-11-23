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
package com.lachm.alib.test;

import com.lachm.alib.ttt.*;

/**
 *
 * @author Lachlan McCarty
 */
public class TicTacToeTest {
    private Board board;
    
    public TicTacToeTest () {
        board = new Board();
        start();
    }
    
    public void start() {
        setAndDisplay(Board.ROW2, Board.COL2, BoardValues.X);
        setAndDisplay(Board.ROW1, Board.COL1, BoardValues.X);
        setAndDisplay(Board.ROW3, Board.COL3, BoardValues.X);
        setAndDisplay(Board.ROW2, Board.COL1, BoardValues.O);
        setAndDisplay(Board.ROW3, Board.COL1, BoardValues.O);
        setAndDisplay(Board.ROW2, Board.COL2, BoardValues.O);
    }
    
    private void setAndDisplay(int row, int col, BoardValues value) {
        board.set(row, col, value);
        System.out.println(board);
        System.out.println();
    }
}
