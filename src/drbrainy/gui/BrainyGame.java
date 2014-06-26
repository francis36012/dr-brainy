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

import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.Date;
import java.awt.*;
import drbrainy.util.BrainyTimer;
import drbrainy.util.RandomNumberGenerator;
import drbrainy.util.BrainyScoreWriter;
import drbrainy.resources.game.*;
import com.sun.java.swing.plaf.windows.*;

public class BrainyGame implements ActionListener, KeyListener, Runnable {
	
    ClassLoader cl = this.getClass().getClassLoader();
	public static JFrame drbfrbrainy = new JFrame("Dr Brainy - v0.85");
	private JPanel drbjpitempane = new JPanel();
	private JPanel drbjpqaobj = new JPanel();
	private JPanel drbjpplayerinfo = new JPanel();
	private JScrollPane drbjspquest;
	private int vspane = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	private int hspane = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	private Thread timerUpdate;
	private BrainyTimer timeobject;
	private Timer timeseconds;
	
	private Icon drbicnewgame = new ImageIcon(
		cl.getResource("drbrainy/resources/images/newgame.png"));
	private Icon drbicscore = new ImageIcon(
		cl.getResource("drbrainy/resources/images/gamescore.png"));
	private Icon drbicabout = new ImageIcon(
		cl.getResource("drbrainy/resources/images/gameabout.png"));
	private Icon drbicexit = new ImageIcon(
		cl.getResource("drbrainy/resources/images/gameexit.png"));
	
	private JLabel drblbanswer = new JLabel("<HTML><B>"+"Answer"+"</B></HTML>");
	private JLabel drblbplayer =new JLabel("Player: ");
	private JLabel drblbtime = new JLabel("Time: ||");
	private JLabel drblbpoints = new JLabel("Answered: ");
	
	private JButton drbbtnewgame = new JButton(drbicnewgame);
	private JButton drbbtscore = new JButton(drbicscore);
	private JButton drbbtabout = new JButton(drbicabout);
	private JButton drbbtexit = new JButton(drbicexit);
	private JButton drbbtanswer = new JButton("OK");
	private JButton drbbtnext = new JButton("Next");
	private JButton drbbthint = new JButton("Hint");
	private JButton drbbtexit1 = new JButton("Exit");
	
	private JTextArea drbjtaquest = new JTextArea(10, 35);
	private JTextField drbjtfanswer = new JTextField(30);
	
	/**	Random number used for selecting question */
	private int drbmasternumber;
	
	/** Integer for storing number of all answered questions */
	private int drbansweredquestions;
	
	/**	Integer for storing number of correctly answered questions */
	private int drbcorrect;
	
	private static String player, question, answer, tip, useranswer;
	private static String userinfo;
	private static Date cdate = new Date();
	private static String datestring = cdate.toString();
	
	private int length = -1;
	private int[] numberAnsweredQuest = new int[1000];
	
	private Games allgames = new Games();
	
	public BrainyGame(String playername) {
		
		drbfrbrainy.setLayout(new BorderLayout());
		drbfrbrainy.addWindowListener(BrainyWindowListener);
		drbfrbrainy.setSize(350, 390);
		drbfrbrainy.setIconImage(Toolkit.getDefaultToolkit().getImage(
				cl.getResource("drbrainy/resources/images/gameicon.png")));
		
		drbbtnewgame.addActionListener(this);
		drbbtscore.addActionListener(this);
		drbbtabout.addActionListener(this);
		drbbtexit.addActionListener(this);
		drbbtanswer.addActionListener(this);
		drbbtnext.addActionListener(this);
		drbbthint.addActionListener(this);
		drbbtexit1.addActionListener(this);
		drbjtfanswer.addActionListener(this);
		
		drbbtnewgame.setToolTipText("New Game");
		drbbtscore.setToolTipText("Game Score");
		drbbtabout.setToolTipText("About Dr Brainy");
		drbbtexit.setToolTipText("Click to get outta here");
		drbbtanswer.setToolTipText("You have the answer in the answer field, "
			+ "click me!");
		drbbtnext.setToolTipText("Click me if you don\'t like the question");
		drbbthint.setToolTipText("You need a hint right? Click me!");
		drbbtexit1.setToolTipText("Oooh :-(");
		
		drbjspquest = new JScrollPane(drbjtaquest, vspane, hspane);
		drbjtaquest.setEditable(false);
		drbjtaquest.setLineWrap(true);
		drbjtaquest.setWrapStyleWord(true);
		
		drbjpitempane.setLayout(new FlowLayout());
		drbjpitempane.add(drbbtnewgame);
		drbjpitempane.add(drbbtscore);
		drbjpitempane.add(drbbtabout);
		drbjpitempane.add(drbbtexit);
		
		drbjpqaobj.setLayout(new FlowLayout());
		drbjpqaobj.add(drbjspquest);
		drbjpqaobj.add(drblbanswer);
		drbjpqaobj.add(drbjtfanswer);
		drbjpqaobj.add(drbbtanswer);
		drbjpqaobj.add(drbbtnext);
		drbjpqaobj.add(drbbthint);
		drbjpqaobj.add(drbbtexit1);
		
		drbjpplayerinfo.setLayout(new FlowLayout());
		drbjpplayerinfo.add(drblbplayer);
		drbjpplayerinfo.add(drblbtime);
		drbjpplayerinfo.add(drblbpoints);
		
		player = playername;
		
		setQuestion();
		drblbplayer.setText("Player: " + player + " || ");
		
		setupTime();
		timerUpdate = new Thread(this, "timer");
		timerUpdate.start();
		
		drbfrbrainy.add(drbjpitempane, "North");
		drbfrbrainy.add(drbjpqaobj, "Center");
		drbfrbrainy.add(drbjpplayerinfo, "South");
		setLook();
		drbfrbrainy.setVisible(true);
	}
	
	/**
	 * It is just used in <code>this</code> for disposing the parent frame <code>drbfrbrainy</code>
	 * <br>Comes in handy for some cleanup
	 */
	public void dispose() {
		drbfrbrainy.dispose();
	}
	
	public void setLook() {
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
			SwingUtilities.updateComponentTreeUI(drbfrbrainy);
		}
		catch (Exception ex) {
		}
	}
	
	/**
	 * Used for cleaning up the question and answer areas
	 */
	public void resetGame() {
		drbjtaquest.setText("");
		drbjtfanswer.setText("");
	}
	
	/**
	 * Generates a random number and extract the
	 * question, answer and tip that corresponds to the number generated.
	 * It also sets the question to the question area <code>drbjtaquest</code>
	 */
	public void setQuestion() {
		
		drbmasternumber = RandomNumberGenerator.genRandNum(0, 15);
		
		if (length == -1) {
			length++;
			numberAnsweredQuest[length] = drbmasternumber;
			question = allgames.getQuestion(drbmasternumber);
			answer = allgames.getAnswer(drbmasternumber);
			tip = allgames.getHint(drbmasternumber);
			
			drbjtaquest.setText(question);
			drbbtanswer.setEnabled(true);
			if (tip.equals("No hint")) {
				drbbthint.setEnabled(false);
			}
			else {
				drbbthint.setEnabled(true);
			}
		}
		else {
			while (checkRepitions(drbmasternumber)) {
				drbmasternumber = RandomNumberGenerator.genRandNum(0, 15);
				System.out.println(drbmasternumber);
			}
		
			length++;
			numberAnsweredQuest[length] = drbmasternumber;
			question = allgames.getQuestion(drbmasternumber);
			answer = allgames.getAnswer(drbmasternumber);
			tip = allgames.getHint(drbmasternumber);
		
			drbjtaquest.setText(question);
			drbbtanswer.setEnabled(true);
			if (tip.equals("No hint")) {
				drbbthint.setEnabled(false);
			}
			else {
				drbbthint.setEnabled(true);
			}
		}
	}
	
	/**
	 * Used for the threading stuff
	 */
	public void setupTime() {
		timeobject = new BrainyTimer();
		timeseconds = new Timer();
		timeseconds.schedule(timeobject, 0, 1 * 1000);
	}
	
	private boolean checkRepitions(int key) {
		
		boolean state = false;
		int i;
		
		for (i = 0; i < numberAnsweredQuest.length;) {
			
			if (key == numberAnsweredQuest[i]) {
				state = true;
				break;
			}
			else {
				state = false;
				break;
			}
		}
		return state;
	}
	
	/**
	 * Extracts time from <code>timeobject</code>
	 * @return	Extracted time is returned as a string
	 */
	public String getTime() {
		return timeobject.getTime();
	}
	
	/**
	 * Used for reseting the <code>timeobject's</code> time
	 */
	public void resetTime() {
		timeobject.resetTime();
	}
	
	public void run() {
		Thread newThread = timerUpdate;
		
		while (newThread == timerUpdate) {
			drblbtime.setText("Time: " + getTime() + " || ");
			
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException iex) {
			}
		}
	}
	
	/**
	 * <code>actionPerformed</code> method for handling events
	 */
	public void actionPerformed(ActionEvent ae) {
		Object eventsource;
		eventsource = ae.getSource();
		
		try {
			if (eventsource == drbbtnewgame) {
				resetGame();
				resetTime();
				drbansweredquestions = drbcorrect = 0;
				drblbpoints.setText(drbcorrect + " / " + drbansweredquestions);
				setQuestion();
			}
			
			if (eventsource == drbbtabout) {
				new About();
			}
			
			if (eventsource == drbbtscore) {
				new Score();
				System.out.println("Score clicked");
			}
			
			if ((eventsource == drbbtexit) || (eventsource ==  drbbtexit1)) {
				userinfo = "------------------------------------------------------------------------------------------------------------\n\n"
					  +"Time: "+datestring+"  ||  "+"Player: "+player+"  ||  "+"Answered: "+drbcorrect+" (Correct) of "+drbansweredquestions+" (All questions)";
				BrainyScoreWriter.writeScore(userinfo);
				System.exit(0);
			}
				
			if (eventsource == drbbtanswer) {
				drbbtanswer.setEnabled(false);
				useranswer = drbjtfanswer.getText();
				useranswer.trim();
				
				if (useranswer.equalsIgnoreCase(answer)) {
					drbjtaquest.append("\nCorrect! - ");
					drbjtaquest.append(answer + " is the correct answer");
					drbansweredquestions = drbansweredquestions + 1;
					drbcorrect = drbcorrect + 1;
					drblbpoints.setText(drbcorrect + " / " + drbansweredquestions);
				}
				else {
					drbjtaquest.append("\n"+ useranswer +" is Wrong! - ");
					drbjtaquest.append(answer + " is the correct answer");
					drbansweredquestions = drbansweredquestions + 1;
					drblbpoints.setText("Answered: " + drbcorrect + " / " + drbansweredquestions);
				}
			}
				
			if (eventsource == drbbtnext) {
				resetGame();
				setQuestion();
			}
				
			if (eventsource == drbbthint) {
				drbjtaquest.append("\n\nHint: " + tip);
				drbbthint.setEnabled(false);
			}
		}
		catch (Exception ex) {
		}
	}
	
	public void keyTyped(KeyEvent ke) {
	}
	
	public void keyPressed(KeyEvent ke) {
		char c;
		c = ke.getKeyChar();
		
		if (c == KeyEvent.VK_ENTER) {
			drbbtanswer.setEnabled(false);
			useranswer = drbjtfanswer.getText();
			useranswer.trim();
			
			if (useranswer.equalsIgnoreCase(answer)) {
				drbjtaquest.append("\nCorrect! - ");
				drbjtaquest.append(answer + " is the correct answer");
				drbansweredquestions = drbansweredquestions + 1;
				drbcorrect = drbcorrect + 1;
				drblbpoints.setText(drbcorrect + " / " + drbansweredquestions);
			}
			else {
				drbjtaquest.append("\n"+ useranswer +" is Wrong! - ");
				drbjtaquest.append(answer + " is the correct answer");
				drbansweredquestions = drbansweredquestions + 1;
				drblbpoints.setText("Answered: " + drbcorrect + " / " + drbansweredquestions);
			}
		}
	}
	
	public void keyReleased(KeyEvent ke) {
	}
	
	WindowListener BrainyWindowListener = new WindowAdapter() {
		
		public void windowClosing(WindowEvent we) {
			
			userinfo = "------------------------------------------------------------------------------------------------------------\n\n"
				  +"Time: "+datestring+"  ||  "+"Player: "+player+"  ||  "+"Answered: "+drbcorrect+" (Correct) of "+drbansweredquestions+" (All questions)";
			BrainyScoreWriter.writeScore(userinfo);
			System.exit(0);
		}
	};
}