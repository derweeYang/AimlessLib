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
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Lachlan McCarty
 */
public class OXComponent extends JComponent {
    
    private JComponent container;
    private int intendedRow = -1;
    private int intendedCol = -1;
    
    private int dimen = 0;
    private BoardValues value = BoardValues.EMPTY;
    
    public OXComponent() {}
    
    public OXComponent(int intendedRow, int intendedCol, JComponent container) {
        this(intendedRow, intendedCol, container, true);
    }
    
    public OXComponent(int intendedRow, int intendedCol, JComponent container, boolean addMouseListener) {
        this.container = container;
        this.intendedRow = intendedRow;
        this.intendedCol = intendedCol;
        if (addMouseListener) {
            this.addMouseListener(new OXMouseListener(container));
        }
    }
    
    public int getIntendedRow() {
        return intendedRow;
    }
    
    public void setIntendedRow(int intendedRow) {
        this.intendedRow = intendedRow;
    }
    
    public int getIntendedCol() {
        return intendedCol;
    }
    
    public void setIntendedCol(int intendedCol) {
        this.intendedCol = intendedCol;
    }
    
    public void setBoardValue(BoardValues value) {
        this.value = value;
    }
    
    public BoardValues getBoardValue() {
        return value;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        setDimen();
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke((int)(dimen * 0.15)));
        
        g2.setColor(Color.BLACK);
        if (value == BoardValues.X) {
            drawX(g2);
        }
        else if (value == BoardValues.O) {
            drawO(g2);
        }
        
        g2.dispose(); // only use dispose when not adding subcomponents
    }
    
    private void drawX(Graphics2D g2) {
        int[] val = new int[2];
        val[0] = (int)(dimen*(5.0/20));
        val[1] = (int)(dimen*(15.0/20));
        
        g2.drawLine(val[0], val[0], val[1], val[1]);
        g2.drawLine(val[1], val[0], val[0], val[1]);
    }
    
    private void drawO(Graphics2D g2) {
        g2.setStroke(new BasicStroke((int)(dimen * 0.10)));
        int[] val = new int[2];
        val[0] = (int)(dimen*(3.0/20));
        val[1] = (int)(dimen*(14.0/20));
        
        g2.drawOval(val[0], val[0], val[1], val[1]);
        g2.setStroke(new BasicStroke((int)(dimen * 0.15)));
    }
    
    private void setDimen() {
        if (getWidth() > getHeight()) dimen = getHeight();
        else dimen = getWidth();
    }
}
