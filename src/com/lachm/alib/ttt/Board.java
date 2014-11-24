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

import com.lachm.alib.math.IntCoord;

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
    
    private int numberOfSuccessfulSets = 0;
    
    private BoardValues winner = BoardValues.EMPTY;
    
    public Board() {
        clear();
    }
    
    public SetErrorValues set(IntCoord coord, BoardValues value) {
        return set(coord.getRow(), coord.getCol(), value);
    }
    
    public SetErrorValues set(int row, int col, BoardValues value) {
        if (winner != BoardValues.EMPTY && winner != BoardValues.ERROR) return SetErrorValues.SOMEONE_HAS_WON_ALREADY;
        if (col > COL3 || col < COL1 || 
            row > ROW3 || row < ROW1) return SetErrorValues.OUT_OF_BOUNDS;
        if (numberOfSuccessfulSets >= 9) return SetErrorValues.BOARD_FULL;
        if (value == BoardValues.EMPTY || value == BoardValues.ERROR) 
            return SetErrorValues.INVALID_VALUE;
        if (board[row][col] != BoardValues.EMPTY) return SetErrorValues.NOT_EMPTY;
        board[row][col] = value;
        winner = checkWin(row, col);
        numberOfSuccessfulSets++;
        if (winner != BoardValues.EMPTY && winner != BoardValues.ERROR) return SetErrorValues.SOMEONE_HAS_WON;
        return SetErrorValues.SUCCESS;
    }
    
    private BoardValues checkWin(int row, int col) {
        if (board[row][col] == BoardValues.EMPTY || board[row][col] == BoardValues.ERROR) 
            return BoardValues.ERROR; // should not happen
        // diagonal 1
        if (row == col) {
            if (board[ROW1][COL1] == board[ROW2][COL2] && board[ROW2][COL2] == board[ROW3][COL3]) {
                return board[row][col];
            }
        }
        // diagonal 2
        if (2-row == col) {
            if (board[ROW3][COL1] == board[ROW2][COL2] && board[ROW2][COL2] == board[ROW1][COL3]) {
                return board[row][col];
            }
        }
        // vertical 1
        if (col == COL1) {
            final int COLUMN = COL1;
            if (board[ROW1][COLUMN] == board[ROW2][COLUMN] && board[ROW2][COLUMN] == board[ROW3][COLUMN]) {
                return board[row][col];
            }
        }
        // vertical 2
        if (col == COL2) {
            final int COLUMN = COL2;
            if (board[ROW1][COLUMN] == board[ROW2][COLUMN] && board[ROW2][COLUMN] == board[ROW3][COLUMN]) {
                return board[row][col];
            }
        }
        // vertical 3
        if (col == COL3) {
            final int COLUMN = COL3;
            if (board[ROW1][COLUMN] == board[ROW2][COLUMN] && board[ROW2][COLUMN] == board[ROW3][COLUMN]) {
                return board[row][col];
            }
        }
        // horizontal 1
        if (row == ROW1) {
            final int ROW = ROW1;
            if (board[ROW][COL1] == board[ROW][COL2] && board[ROW][COL2] == board[ROW][COL3]) {
                return board[row][col];
            }
        }
        // horizontal 2
        if (row == ROW2) {
            final int ROW = ROW2;
            if (board[ROW][COL1] == board[ROW][COL2] && board[ROW][COL2] == board[ROW][COL3]) {
                return board[row][col];
            }
        }
        // horizontal 3
        if (row == ROW3) {
            final int ROW = ROW3;
            if (board[ROW][COL1] == board[ROW][COL2] && board[ROW][COL2] == board[ROW][COL3]) {
                return board[row][col];
            }
        }
        return BoardValues.EMPTY;
    }
    
    public BoardValues get(IntCoord coord) {
        return get(coord.getRow(), coord.getCol());
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
    
    public BoardValues getWinner() {
        return winner;
    }
    
    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                switch (get(i,j)) {
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
