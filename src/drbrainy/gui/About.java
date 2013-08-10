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
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;

/**
 * Class for about dialog
 * @author Francis Agyapong
 * @version Version 1.01
 */
public class About implements ActionListener, KeyListener {
	
    ClassLoader cl = this.getClass().getClassLoader();
	static JDialog ADialog1 = new JDialog(BrainyGame.drbfrbrainy, "Dr. Brainy v0.85 - About", false);
	JButton AButton1 = new JButton("Close");
	JButton AButton2 = new JButton("License");
	JPanel ABPanel1 = new JPanel();
	JLabel ALabel1 = new JLabel(new ImageIcon(
			cl.getResource("drbrainy/resources/images/aboutinfo.png")));
	Point Loc = BrainyGame.drbfrbrainy.getLocation();
	Object eventsource;
	
	/**
	 * UI Contructor for <code>About</code>
	 */
	public About() {
		
		AButton2.addActionListener(this);
		AButton1.addActionListener(this);
		AButton1.addKeyListener(this);
		AButton2.addKeyListener(this);
		
		ADialog1.setSize(300, 270);
		ADialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ADialog1.setIconImage(Toolkit.getDefaultToolkit().getImage(
				cl.getResource("drbrainy/resources/images/gameicon.png")));
		ADialog1.setLocation(Loc);
		ADialog1.setLayout(new BorderLayout());
		
		ABPanel1.setLayout(new FlowLayout());
		ABPanel1.add(AButton2);
		ABPanel1.add(AButton1);
		
		ADialog1.add(ALabel1, BorderLayout.CENTER);
		ADialog1.add(ABPanel1, BorderLayout.SOUTH);

		setLook();
		ADialog1.setVisible(true);
	}
	
	/**
	 * Method for disposing <code>ADialog1</code>
	 */
	public void dispose() {
		ADialog1.dispose();
	}
	
	public void setLook() {
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
			SwingUtilities.updateComponentTreeUI(ADialog1);
		}
		catch (Exception ex) {
		}
	}
	
	/**
	 * <code>actionPerformed</code> method for handling UI events
	 */
	public void actionPerformed(ActionEvent ae1) {
		eventsource = ae1.getSource();
		
		if (eventsource == AButton1) {
			dispose();
		}
		if (eventsource == AButton2) {
			new License();
		}
	}
	
	public void keyTyped(KeyEvent ke1) {
		char c = ke1.getKeyChar();
		if ((c == KeyEvent.VK_ESCAPE)) {
			dispose();
		}
	}
	public void keyPressed(KeyEvent e) {	
	}
	
	public void keyReleased(KeyEvent e) {	
	}
}