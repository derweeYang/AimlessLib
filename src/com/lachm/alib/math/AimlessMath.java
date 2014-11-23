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
package com.lachm.alib.math;

import java.util.Random;

/**
 * Class with static methods for Math-related tasks
 * @author Lachlan McCarty
 */
public class AimlessMath {
    
    private AimlessMath() {
        // so user cannot construct object
    }
    
    /**
     * Finds the greatest common divisor of two integers using the Euclidean algorithm.
     * @param a the first integer
     * @param b the second integer
     * @return the GCD of the two integers
     */
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
    
    /**
     * Returns a random integer in an inclusive range.
     * @param min the minimum value the random number can be
     * @param max the maximum value the random number can be
     * @return random integer in [min, max]
     */
    public static int randInt(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    } 
}
