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

public class License implements ActionListener {
	
    ClassLoader cl = this.getClass().getClassLoader();
	JDialog LDialog1 = new JDialog(About.ADialog1, "Dr Brainy v0.85 - License", true);
	JScrollPane LSPane1;
	JPanel LPanel1 = new JPanel();
	JTextArea LTArea1 = new JTextArea(30, 0);
	JButton LButton1 = new JButton("Close");
	
	int vspane = ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER;
	int hspane = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	
	String gnulicense =
		"Copyright (C) 2012, Francis Agyapong\n\n"
		+"Dr Brainy is free software: you can redistribute it\n"
		+"and/or modify it under terms of the GNU General\n"
		+"Public License as published by the Free Software Foundation,\n"
		+"either version 3 of the license, or (at your option) any later version\n\n"
		+"This program is distributed in the hope that it will be useful,\n"
		+"but WITHOUT ANY WARRANTY; without even the implied warranty of\n"
		+"MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the\n"
		+"GNU General Public License for more details.\n\n"
		+"You should have received a copy of the GNU General Public License\n"
		+"along with this program. If not, see <http://www.gnu.org/licenses/>";
	
	public License() {
		
		LTArea1.setEditable(false);
		LTArea1.setLineWrap(true);
		LTArea1.setWrapStyleWord(true);
		LTArea1.setText(gnulicense);
		LSPane1 = new JScrollPane(LTArea1, vspane, hspane);
		
		
		LPanel1.setLayout(new FlowLayout());
		LPanel1.add(LButton1);
		LButton1.addActionListener(this);
		
		LDialog1.setSize(510, 350);
		LDialog1.setLayout(new BorderLayout());
		LDialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		LDialog1.setIconImage(Toolkit.getDefaultToolkit().getImage(cl.getResource("drbrainy/resources/images/gameicon.png")));
		
		LDialog1.add(LSPane1, BorderLayout.CENTER);
		LDialog1.add(LPanel1, BorderLayout.SOUTH);
		
		setLook();
		LDialog1.setVisible(true);
	}
	
	public void dispose() {
		LDialog1.dispose();
	}
	
	public void setLook() {
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
			SwingUtilities.updateComponentTreeUI(LDialog1);
		}
		catch (Exception ex) {
		}
	}
	
	public void actionPerformed(ActionEvent ae1) {
		String actioncommand;
		actioncommand = (String)ae1.getActionCommand();
		
		if (actioncommand.equals("Close")) {
			dispose();
		}
	}

}
