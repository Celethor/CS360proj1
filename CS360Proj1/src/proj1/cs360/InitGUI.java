package proj1.cs360;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InitGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1758122877465171902L;
	private JLabel welcome;
	private JButton start = new JButton("Start");
	
	public InitGUI() {
		
		setSize(1000,300);
		setTitle("IHSAA Cross-Country Tournament Realignment Explorer");
		setLayout(new GridLayout(1,2));
		
		//add listener to button
		start.addActionListener(new StartListener());
		
		welcome = new JLabel(new ImageIcon("IHSAA.png"));
		
		JPanel other = new JPanel(new GridLayout(2,1));
		other.add(new JLabel("Copyright 2017 by the Indiana High School Athletic Association. All rights reserved."));
		other.add(start);
		
		add(welcome);
		add(other);
		
		setVisible(true);
	}


	private class StartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			new MainGUI();
			setVisible(false);
		}
		
	}
}