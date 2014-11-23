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
package com.lachm.alib.ttt;

/**
 * Board holds the Tic-Tac-Toe board data.
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
    
    public boolean set(int row, int col, BoardValues value) {
        if (col > COL3 || col < COL1 || 
            row > ROW3 || row < ROW1 || 
            value == BoardValues.EMPTY ||
            value == BoardValues.ERROR) return false;
        if (board[row][col] != BoardValues.EMPTY) return false;
        board[row][col] = value;
        return true;
    }
    
    public BoardValues get(int row, int col) {
        if (col > COL3 || col < COL1 || 
            row > ROW3 || row < ROW1) return BoardValues.ERROR;
        return board[row][col];
    }
    
    public void clear() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = BoardValues.EMPTY;
            }
        }
    }
    
    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                switch (board[i][j]) {
                    case X:
                        string += "X";
                        break;
                    case O:
                        string += "O";
                        break;
                    case EMPTY:
                        string += " ";
                        break;
                    case ERROR:
                    default:
                        string += "?";
                        break;
                }
                if (j != board[i].length - 1) string+=" | ";
            }
            if (i != board.length -1) string += "\n---------\n";
        }
        return string;
    }
}
