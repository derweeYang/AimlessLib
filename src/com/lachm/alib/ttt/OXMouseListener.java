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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

/**
 *
 * @author Lachlan McCarty
 */
public class OXMouseListener implements MouseListener {
    private JComponent container;
    
    public OXMouseListener(JComponent container) {
        this.container = container;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        MouseListener[] listeners = container.getMouseListeners();
        if (listeners.length > 0) {
            for (MouseListener listener: listeners) {
                listener.mouseClicked(e);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        MouseListener[] listeners = container.getMouseListeners();
        if (listeners.length > 0) {
            for (MouseListener listener: listeners) {
                listener.mousePressed(e);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MouseListener[] listeners = container.getMouseListeners();
        if (listeners.length > 0) {
            for (MouseListener listener: listeners) {
                listener.mouseReleased(e);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        MouseListener[] listeners = container.getMouseListeners();
        if (listeners.length > 0) {
            for (MouseListener listener: listeners) {
                listener.mouseEntered(e);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        MouseListener[] listeners = container.getMouseListeners();
        if (listeners.length > 0) {
            for (MouseListener listener: listeners) {
                listener.mouseExited(e);
            }
        }
    }
    
    
    
}
