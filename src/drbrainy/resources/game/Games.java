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

package drbrainy.resources.game;

public class Games {
	
	private static String games[] = new String[1000];
	private static String answers[] = new String[1000];
	private static String hints[] = new String[1000];
	
	public String getQuestion(int num) {
		return Games.games[num];
	}
	
	public String getAnswer(int num) {
		return Games.answers[num];
	}
	
	public String getHint(int num) {
		return Games.hints[num];
	}
	
	
	public Games() {
		
		/**
		 *	Logic
		 *	Age
		 */
		games[0] = "Martin is 46 years old. His son is 9 years younger than half of Martin's age. How old is Martin\'s son?";
		answers[0] = "14";
		hints[0] = "No hint";

		games[1] = "Martin is 46 years old. His son is 6 years younger than half of Martin's age. How old is Martin\'s son?";
		answers[1] = "17";
		hints[1] = "No hint";

		games[2] = "Martin is 46 years old. His son is 10 years younger than half of Martin's age. How old is Martin\'s son?";
		answers[2] = "13";
		hints[2] = "No hint";

		/**
		 *	Mathematics
		 *	Combination
		 */
		games[3] = "A file is protected by a password formed by a 6-digit number [ranging from 0 to 9]. How many different passwords can you have?";
		answers[3] = "6000000";
		hints[3] = "The total number of possibilities is 10 to the power of 6";

		games[4] = "How many matches does it take to determine the winner of a tennis tournament that starts with 32 players?";
		answers[4] = "31";
		hints[4] = "A player is eliminated in every game";

		games[5] = "What number should be added to 43 to get 77?";
		answers[5] = "34";
		hints[5] = "No hint";

		games[6] = "How many stars can be found in the flag of Ghana?";
		answers[6] = "1";
		hints[6] = "Look around for the flag of Ghana :-)";

		games[7] = "In a horse race, there are 48 eyes and 72 legs. How many horses are present at the race?";
		answers[7] = "12";
		hints[7] =  "Horses have 4 legs";
		
		games[8] = "Which scientists dig up on cultures of the past";
		answers[8] = "Archaeologists";
		hints[8] = "No hint";
		
		games[9] = "In which year did the world war I end?";
		answers[9] = "1934";
		hints[9] = "No hint";
		
		games[10] = "A person whose work has become a defining style for that field is?";
		answers[10] = "Pioneer";
		hints[10] = "No hint";
		
		games[11] = "What is a halberd?";
		answers[11] = "Weapon";
		hints[11] = "It sure comes in handy during a war :-)";
		
		games[12] = "A car is to a garage as a plane is to a?";
		answers[12] = "Hangar";
		hints[12] = "No hint";
		
		games[13] = "A desert is to an oasis as a sea is to a[n]?";
		answers[13] = "Island";
		hints[13] = "No hint";
		
		games[14] = "Horticulture is to plants as ornithology is to?";
		answers[14] = "Birds";
		hints[14] = "No hints";
		
		games[15] = "5 is to pentagon as 10 is to?";
		answers[15] = "Decagon";
		hints[15] = "No hint";
		
		games[16] = "Constellation is to stars as archipelago is to?";
		answers[16] = "Islands";
		hints[16] = "No hint";
		
		games[17] = "";
		answers[17] = "";
		hints[17] = "";
		
		games[18] = "";
		answers[18] = "";
		hints[18] = "";
		
		games[19] = "";
		answers[19] = "";
		hints[19] = "";
		
		games[20] = "";
		answers[20] = "";
		hints[20] = "";
		
		games[21] = "";
		answers[21] = "";
		hints[21] = "";
		
		games[22] = "";
		answers[22] = "";
		hints[22] = "";
		
		games[23] = "";
		answers[23] = "";
		hints[23] = "";
		
		games[24] = "";
		answers[24] = "";
		hints[24] = "";
		
		games[25] = "";
		answers[25] = "";
		hints[25] = "";
		
		games[26] = "";
		answers[26] = "";
		hints[26] = "";
		
		games[27] = "";
		answers[27] = "";
		hints[27] = "";
		
		games[28] = "";
		answers[28] = "";
		hints[28] = "";
		
		games[29] = "";
		answers[29] = "";
		hints[29] = "";
		
		games[30] = "";
		answers[30] = "";
		hints[30] = "";
		
		games[31] = "";
		answers[31] = "";
		hints[31] = "";
		
		games[32] = "";
		answers[32] = "";
		hints[32] = "";
		
		games[33] = "";
		answers[33] = "";
		hints[33] = "";
		
		games[34] = "";
		answers[34] = "";
		hints[34] = "";
		
		games[35] = "";
		answers[35] = "";
		hints[35] = "";
		
		games[36] = "";
		answers[36] = "";
		hints[36] = "";
		
		games[37] = "";
		answers[37] = "";
		hints[37] = "";
		
		games[38] = "";
		answers[38] = "";
		hints[38] = "";
		
		games[39] = "";
		answers[39] = "";
		hints[39] = "";
		
		games[40] = "";
		answers[40] = "";
		hints[40] = "";
		
		games[41] = "";
		answers[41] = "";
		hints[41] = "";
		
		games[42] = "";
		answers[42] = "";
		hints[42] = "";
		
		games[43] = "";
		answers[43] = "";
		hints[43] = "";
		
		games[44] = "";
		answers[44] = "";
		hints[44] = "";
		
		games[45] = "";
		answers[45] = "";
		hints[45] = "";
		
		games[46] = "";
		answers[46] = "";
		hints[46] = "";
		
		games[47] = "";
		answers[47] = "";
		hints[47] = "";
		
		games[48] = "";
		answers[48] = "";
		hints[48] = "";
		
		games[49] = "";
		answers[49] = "";
		hints[49] = "";
	}
}