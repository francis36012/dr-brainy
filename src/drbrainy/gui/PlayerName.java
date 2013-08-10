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
import java.awt.*;
import com.sun.java.swing.plaf.windows.*;

public class PlayerName implements ActionListener, KeyListener {

    ClassLoader cl = this.getClass().getClassLoader();
	public static JFrame drbfrplayerframe = new JFrame("Enter Player Name");
	private Icon drbicplayername = new ImageIcon(
		cl.getResource("drbrainy/resources/images/playernamebanner.png"));
	private JLabel drblbplayername = new JLabel(drbicplayername);
	private JTextField drbtfplayername = new JTextField("Your name", 25);
	private JButton drbbtokbutt = new JButton("OK");
	private JButton drbbtcancelbutt = new JButton("Cancel");
	private JPanel drbjpbuttpane = new JPanel();
	
	private String drbstrusername;
	
	public PlayerName() {

		drbfrplayerframe.setSize(275, 175);
		drbfrplayerframe.setLayout(new BorderLayout());
		drbfrplayerframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		drbfrplayerframe.setIconImage(Toolkit.getDefaultToolkit().getImage(
				cl.getResource("drbrainy/resources/images/gameicon.png")));
		
		drbbtokbutt.addActionListener(this);
		drbbtcancelbutt.addActionListener(this);
		drbbtokbutt.addKeyListener(this);
		drbbtcancelbutt.addKeyListener(this);
		
		drbjpbuttpane.setLayout(new FlowLayout());
		drbjpbuttpane.add(drbtfplayername);
		drbjpbuttpane.add(drbbtokbutt);
		drbjpbuttpane.add(drbbtcancelbutt);
		
		drbfrplayerframe.add(drblbplayername, "North");
		drbfrplayerframe.add(drbjpbuttpane, "Center");
		
		setLook();
		drbfrplayerframe.setVisible(true);
	}
	
	private static void dispose() {
		drbfrplayerframe.dispose();
	}
	
	public void setLook() {
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
			SwingUtilities.updateComponentTreeUI(drbfrplayerframe);
		}
		catch (Exception ex) {
		}
	}
	
	public void actionPerformed(ActionEvent ae1) {
		
		String action;
		action = (String)ae1.getActionCommand();
		
		drbstrusername = drbtfplayername.getText();
		if ((drbstrusername.equals("null")) ||( drbstrusername.equals(""))|| drbstrusername.equals("Your name")){
			drbstrusername = "Unkwown";
		}
		
		if (action.equalsIgnoreCase("OK")) {
			new BrainyGame(drbstrusername);
			dispose();
		}
		
		if (action.equalsIgnoreCase("Cancel")) {
			new BrainyGame("Unknown");
			dispose();
		}
	}
	
	public void keyTyped(KeyEvent ke1) {
		
		char c;
		c = ke1.getKeyChar();
		
		drbstrusername = drbtfplayername.getText();
		if ((drbstrusername.equals("null")) ||( drbstrusername.equals(""))|| drbstrusername.equals("Your name")){
			drbstrusername = "Unkwown";
		}
		
		if (c == KeyEvent.VK_ENTER) {
			new BrainyGame(drbstrusername);
			dispose();
		}
	}
	
	public void keyPressed(KeyEvent ke2) {
	}
	
	public void keyReleased(KeyEvent ke3) {
	}
}