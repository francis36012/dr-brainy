/*
 * Copyright (C) 2012 Francis Agyapong <francisagyapong2@gmail.com>
 * 
 * This file is part of Dr Brainy.
 *
 * Dr Brainy is free software: you can redistribute it and/or modify
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

import java.io.*;

/**
 * Scorer for the game
 * @author Francis Agyapong
 * @version 0.5
 */
public class BrainyScoreWriter {

	static String userdir = System.getenv("USERPROFILE");
	
	public static void writeScore(String text) {
		
		String text1;
		text1 = text;
		
		try {
			
			File score = new File(userdir + "\\brainyscore.dsc");
			if (!score.exists()) {
				FileWriter BFilewrt = new FileWriter(score);
				BufferedWriter BBufferedwrt = new BufferedWriter(BFilewrt);
			
				BBufferedwrt.write(text1);
				BBufferedwrt.close();
			}
			else {
				FileWriter BFilewrt = new FileWriter(score, true);
				BufferedWriter BBufferedwrt = new BufferedWriter(BFilewrt);
			
				BBufferedwrt.write("\n");
				BBufferedwrt.write(text1);
				BBufferedwrt.close();
			}
		}
		catch (Exception ex1) {
		}	
	}
}
