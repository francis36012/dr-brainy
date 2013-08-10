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

import java.util.*;
import java.text.*;

public class BrainyTimer extends TimerTask{
	
	private int second = 0, minute = 0, hour = 0;
	private DecimalFormat decformat = new DecimalFormat("00");
	
	public void run() {
		
		second++;
		
		if (second == 60) {
			minute++;
			second = 0;
		}
		
		if (minute == 60) {
			hour++;
			minute = 0;
		}
	}
	
	public BrainyTimer() {
	}
	
	public void resetTime() {
		second = minute = hour = 0;
	}
	
	public int getSeconds() {
		return second;
	}
	
	public int getMinutes() {
		return minute;
	}
	
	public int getHours() {
		return hour;
	}
	
	public String getTime() {
		return defaultTimeFormat();
	}
	
	private String defaultTimeFormat() {
		return "" + decformat.format(hour) + ":" + decformat.format(minute) + ":" + decformat.format(second);
	}

}
