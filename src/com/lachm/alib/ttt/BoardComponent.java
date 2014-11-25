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
import java.awt.Rectangle;
import java.awt.RenderingHints;

/**
 *
 * @author Lachlan McCarty
 */
public class BoardComponent extends JComponent {
    
    private Board board = new Board();
    private int dimen;
    private OXComponent[][] components = new OXComponent[3][3];
    private int[] val = new int[4];
    
    public BoardComponent() {
        super();
        this.setLayout(null);
        for (int i = 0; i < components.length; i++) {
            for (int j = 0; j < components[i].length; j++) {
                components[i][j] = new OXComponent();
                add(components[i][j]);
            }
        }
    }
    
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
        // turn on antialiasing so it doesn't look like crap
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(rh);
        
        val[0] = (int)(dimen*(1.0/23));
        val[1] = (int)(dimen*(8.0/23));
        val[2] = (int)(dimen*(15.0/23));
        val[3] = (int)(dimen*(22.0/23));
        
        g2.setStroke(new BasicStroke((int)(dimen * 0.02)));
        g2.drawLine(val[1], val[0], val[1], val[3]);
        g2.drawLine(val[2], val[0], val[2], val[3]);
        g2.drawLine(val[0], val[1], val[3], val[1]);
        g2.drawLine(val[0], val[2], val[3], val[2]);
        
        for (int row = Board.ROW1; row <= Board.ROW3; row++) {
            for (int col = Board.COL1; col <= Board.COL3; col++) {
                BoardValues boardValue = board.get(row, col);
                if (boardValue == BoardValues.X) {
                    setX(row, col);
                }
                else if (boardValue == BoardValues.O) {
                    setO(row, col);
                }
            }
        }
        
        for (int i = 0; i < components.length; i++) {
            for (int j = 0; j < components[i].length; j++) {
                components[i][j].setBounds(dimenForSub(i, j)); 
            }
        }
    }
    
    private void setX(int row, int col) {
        components[row][col].setBoardValue(BoardValues.X);
    }
    
    private void setO(int row, int col) {
        components[row][col].setBoardValue(BoardValues.O);
    }
    
    private void setDimen() {
        if (getWidth() > getHeight()) dimen = getHeight();
        else dimen = getWidth();
    }
    
    private Rectangle dimenForSub(int row, int col) {
        setDimen();
        int x, y, width, height;
        switch (col) {
            case Board.COL1:
                x = val[0];
                break;
            case Board.COL2:
                x = val[1];
                break;
            case Board.COL3:
                x = val[2];
                break;
            default:
                // this shouldnt happen but
                x = 0;
                break;
        }
        switch (row) {
            case Board.ROW1:
                y = val[0];
                break;
            case Board.ROW2:
                y = val[1];
                break;
            case Board.ROW3:
                y = val[2];
                break;
            default:
                // this shouldnt happen but
                y = 0;
                break;
        }
        width = (int)(dimen*(7.0/23));
        height = (int)(dimen*(7.0/23));
        return new Rectangle(x,y,width,height);
    }
}
