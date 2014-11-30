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

import com.lachm.alib.ttt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame {
    private final int FRAME_WIDTH = 300;
    private final int FRAME_HEIGHT = 350;
    private SetErrorValues lastVal;
    private BoardValues currentPlayer;

    private BoardComponent comp = new BoardComponent();
    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();

    public int lastRow;
    public int lastCol;
    public int lastid;
    public int id;

    public static void main(String[] args) {
        new TicTacToe();
    }

    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        add(panel);

        panel.setLayout(new BorderLayout());

        comp.addMouseListener(new LM_CustomMouseListener(this));
        panel.add(comp, BorderLayout.CENTER);

        label.setFont(new Font("SansSerif", Font.BOLD, 26));
        panel.add(label, BorderLayout.SOUTH);

        setVisible(true);

        game();
    }

    private void game() {
        label.setText("Player X's turn.");
        comp.getBoard().clear();
        lastRow = -1;
        lastCol = -1;
        lastid = Integer.MIN_VALUE;
        id = Integer.MIN_VALUE;
        currentPlayer = BoardValues.X;
        lastVal = SetErrorValues.SUCCESS;
        comp.repaint();

        while (lastVal != SetErrorValues.SOMEONE_HAS_WON && lastVal != SetErrorValues.BOARD_FULL) {
            waitForClick();
            lastVal = comp.getBoard().set(lastRow, lastCol, currentPlayer);
            if (lastVal == SetErrorValues.SOMEONE_HAS_WON || lastVal == SetErrorValues.SUCCESS) {
                currentPlayer = invert(currentPlayer);
                switch(currentPlayer) {
                    case X:
                        label.setText("Player X's turn.");
                        break;
                    case O:
                        label.setText("Player O's turn.");
                        break;
                    default:
                        label.setText("Error");
                        break;
                }
            }
            comp.repaint();
        }
        switch (lastVal) {
            case BOARD_FULL:
                label.setText("Draw");
                break;
            case SOMEONE_HAS_WON:
                switch(comp.getBoard().getWinner()) {
                    case X:
                        label.setText("Player X has won.");
                        break;
                    case O:
                        label.setText("Player O has won.");
                        break;
                    default:
                        label.setText("Error");
                        break;
                }
                break;
            default:
                label.setText("Error");
        }
        int option = JOptionPane.showConfirmDialog(this,
            "Would you like to play again?",
            "Play Again",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            game();
        }
        else {
            System.exit(0);
        }
    }

    private BoardValues invert(BoardValues bval) {
        switch (bval) {
            case X:
                return BoardValues.O;
            case O:
                return BoardValues.X;
            default:
                return BoardValues.ERROR;
        }
    }

    private void waitForClick() {
        lastid = id;
        while (id <= lastid) {
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
                label.setText("Error");
            }
        }
    }
}

class LM_CustomMouseListener implements MouseListener {
    private TicTacToe ttt;

    public LM_CustomMouseListener(TicTacToe ttt) {
        this.ttt = ttt;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (e.getSource().getClass().equals(new OXComponent().getClass())) {
            OXComponent oxsource = (OXComponent) source;
            ttt.lastCol = oxsource.getIntendedCol();
            ttt.lastRow = oxsource.getIntendedRow();
            ttt.id++;
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
