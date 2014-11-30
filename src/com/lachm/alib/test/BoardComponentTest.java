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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author Lachlan McCarty
 */
public class BoardComponentTest extends JFrame {
    private final int FRAME_WIDTH = 300;
    private final int FRAME_HEIGHT = 300;
    
    private BoardComponent comp = new BoardComponent();
    
    public BoardComponentTest() {
        setTitle("BoardComponent Test");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
                
        add(comp);
        new TicTacToeTest(comp.getBoard());
        comp.addMouseListener(new CustomMouseListener());
        
        setVisible(true);
    }
}

class CustomMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (e.getSource().getClass().equals(new OXComponent().getClass())) {
            OXComponent oxsource = (OXComponent) source;
            System.out.print("Row: ");
            System.out.print(oxsource.getIntendedRow()+1);
            System.out.print(" Col: ");
            System.out.println(oxsource.getIntendedCol()+1);
        }
        else {
            System.out.println(source.getClass());
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}