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

package drbrainy.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;

public class Score implements ActionListener {
	
    ClassLoader cl = this.getClass().getClassLoader();
	static JFrame drbfrscore = new JFrame("Dr Brainy - Score");
	private JTextArea drbjtascore = new JTextArea(15, 30);
	private int drbvspane = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	private int drbhspane = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	private JPanel drbjpbuttons = new JPanel();
	private JScrollPane drbjspmainpane;
	private JButton drbbtclose = new JButton("Close");
	private JButton drbbtreset = new JButton("Reset Score");
	
	public Score() {
		
		drbjpbuttons.setLayout(new FlowLayout());
		drbbtclose.addActionListener(this);
		drbbtreset.addActionListener(this);
		drbjtascore.setEditable(false);
		
		drbfrscore.setSize(600, 450);
		drbfrscore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		drbfrscore.setLayout(new BorderLayout());
		drbfrscore.setIconImage(Toolkit.getDefaultToolkit().getImage(
				cl.getResource("drbrainy/resources/images/gameicon.png")));
		
		drbjpbuttons.add(drbbtreset);
		drbjpbuttons.add(drbbtclose);
		drbjspmainpane = new JScrollPane(drbjtascore, drbvspane, drbhspane);
		
		drbfrscore.add(drbjspmainpane, "Center");
		drbfrscore.add(drbjpbuttons, "South");
		
		setScoreData();
		setLook();
		drbfrscore.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		Object actionsource;
		actionsource = ae.getSource();
		
		if (actionsource.equals(drbbtclose)) {
			dispose();
		}
		if (actionsource.equals(drbbtreset)) {
			
			drbjtascore.setText("");
			String userdir = System.getenv("USERPROFILE");
			
			try {
				File scorefile = new File(userdir+"\\brainyscore.dsc");
				FileWriter scorewriter = new FileWriter(scorefile);
				scorewriter.write("");
				scorewriter.close();
			}
			catch (Exception ex) {
			}
		}
	}
	
	public void setScoreData() {
		
		String userdir = System.getenv("USERPROFILE");
		
		try {
			File scorefile = new File(userdir+"\\brainyscore.dsc");
			Scanner scorereader = new Scanner(scorefile);
			
			if (!scorefile.exists()) {
				drbjtascore.append("Error: Cannot find score file");
			}
			else {
				while (scorereader.hasNext()) {
					drbjtascore.append(scorereader.nextLine());
					drbjtascore.append("\n");
				}
			}
			scorereader.close();
		}
		catch (Exception ex) {
			
		}
	}
	
	public void setLook() {
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
			SwingUtilities.updateComponentTreeUI(drbfrscore);
		}
		catch (Exception ex) {
		}
	}
	
	public void dispose() {
		drbfrscore.dispose();
	}
}
