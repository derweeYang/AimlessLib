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

import java.awt.BasicStroke;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Lachlan McCarty
 */
public class BoardComponent extends JComponent {
    
    private Board board = new Board();
    private int dimen;
    
    public void setBoard(Board board) {
        this.board = board;
    }
    
    public Board getBoard() {
        return board;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        setDimen();
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke((int)(dimen * 0.02)));
        g2.drawLine((int)(dimen*(1.0/3)), (int)(dimen*(1.0/20)), (int)(dimen*(1.0/3)), (int)(dimen*(19.0/20)));
        g2.drawLine((int)(dimen*(2.0/3)), (int)(dimen*(1.0/20)), (int)(dimen*(2.0/3)), (int)(dimen*(19.0/20)));
        g2.drawLine((int)(dimen*(1.0/20)), (int)(dimen*(1.0/3)), (int)(dimen*(19.0/20)), (int)(dimen*(1.0/3)));
        g2.drawLine((int)(dimen*(1.0/20)), (int)(dimen*(2.0/3)), (int)(dimen*(19.0/20)), (int)(dimen*(2.0/3)));
        
        for (int row = Board.ROW1; row <= Board.ROW3; row++) {
            for (int col = Board.COL1; col <= Board.COL3; col++) {
                BoardValues val = board.get(row, col);
                if (val == BoardValues.X) {
                    drawX(row, col);
                }
                else if (val == BoardValues.O) {
                    drawO(row, col);
                }
            }
        }
        
        g2.dispose();
    }
    
    private void drawX(int row, int col) {
        System.out.println("x "+row+" "+col);
    }
    
    private void drawO(int row, int col) {
        System.out.println("o "+row+" "+col);
    }
    
    private void setDimen() {
        if (getWidth() > getHeight()) dimen = getHeight();
        else dimen = getWidth();
    }
    
}
