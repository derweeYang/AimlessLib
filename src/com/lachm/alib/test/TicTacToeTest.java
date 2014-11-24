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
import com.lachm.alib.math.AimlessMath;
import com.lachm.alib.math.IntCoord;

/**
 *
 * @author Lachlan McCarty
 */
public class TicTacToeTest {
    private Board board;
    
    public TicTacToeTest() {
        board = new Board();
        start();
    }
    
    public TicTacToeTest(Board board) {
        this.board = board;
        start();
    }
    
    public void start() {
        random();
    }
    
    private void random() {
        BoardValues bval = BoardValues.X;
        SetErrorValues lastVal = SetErrorValues.SUCCESS;
        while (lastVal != SetErrorValues.SOMEONE_HAS_WON && lastVal != SetErrorValues.BOARD_FULL) {
            lastVal = setAndDisplay(randCoord(), bval);
            if (lastVal == SetErrorValues.SOMEONE_HAS_WON || lastVal == SetErrorValues.SUCCESS)
                bval = invert(bval);
        }
    }
    
    private SetErrorValues setAndDisplay(IntCoord coord, BoardValues value) {
        SetErrorValues val = board.set(coord, value);
        System.out.println(board);
        System.out.println(val.name());
        System.out.println();
        return val;
    }
    
    private IntCoord randCoord() {
        return new IntCoord(AimlessMath.randInt(Board.ROW1,Board.ROW3), 
                AimlessMath.randInt(Board.COL1,Board.COL3));
    }
    
    private BoardValues invert(BoardValues bval) {
        int randint = AimlessMath.randInt(0,1);
        switch (bval) {
            case X:
                return BoardValues.O;
            case O:
                return BoardValues.X;
            default:
                return BoardValues.ERROR;
        }
    }
}
