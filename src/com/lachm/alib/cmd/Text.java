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
package com.lachm.alib.cmd;

import java.awt.event.KeyEvent;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Lachlan McCarty
 */
public class Text {
    
    private Text() {
        // so user cannot construct object
    }
    
    /**
     * Prompts the user if they want to continue by either inputing 'y' or 'n'
     * This uses System.in for input and System.out for output.
     * @return true if they want to continue and false if they don't
     */
    public static boolean cont() {
        return cont(System.in, System.out);
    }
    
    /**
     * Prompts the user if they want to continue by either inputing 'y' or 'n'
     * @param in the InputStream you would like to get input from
     * @param out the PrintStream you would like to output to
     * @return true if they want to continue and false if they don't
     */
    public static boolean cont(InputStream in, PrintStream out) {
        Scanner scan = new Scanner(in);
        out.print("Continue (y/n): ");
        String input = scan.nextLine();
        if (input.length() < 1) {
                out.println("Invalid input");
                return cont(in, out);
        }
        else if (input.substring(0,1).equalsIgnoreCase("n")) {
                return false;
        }
        else if (input.substring(0,1).equalsIgnoreCase("y")) {
                return true;
        }
        else {
                System.out.println("Invalid input");
                return cont(in, out);
        } 
    }
    
}
