/*
 * Copyright (C) 2012 Francis Agyapong <francisagyapong2@gmail.com>
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
 *
 */

package drbrainy.util;

/**
 * Class for holding <code>genRandNum</code>
 * <code>genRandNum</code> is a method for random number generation with a specified range
 * @author Francis Agyapong
 * @version	0.2
 */
public class RandomNumberGenerator {
	
	/**
	 * Random number generation method within a range
	 * @param arg0	Least or minimum number to be generated
	 * @param arg1	Highest or maximum number to be generated
	 * @return	<code>int result</code> - Generated number
	 */
	public static int genRandNum(int arg0, int arg1) {
		
		int result;
		result = arg0 + (int)(Math.random() * ((arg1 - arg0) + 1));
		return result;
	}

}
