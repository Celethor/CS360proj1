package proj1.cs360;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainGUI extends JFrame{

	private final int WINDOW_WIDTH = 240;
	private final int WINDOW_HEIGHT = 240;
	private JTextField classText;
	private JLabel classLbl;
	private JPanel optPane = new JPanel();
	private JButton[] optBtns = new JButton[2];

	public MainGUI() {
		
		setTitle("Welcome, my Lord");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setSize(WINDOW_WIDTH + 1, WINDOW_HEIGHT + 1);
		
		setLayout(new GridLayout(3,1));
		
		//init and add classLbl
		classLbl = new JLabel("How many classes would you like?");
		add(classLbl);
		
		//init and add classText
		add(classText = new JTextField());
		classText.setBorder(BorderFactory.createEtchedBorder());
		
		// create buttons add to optnPane
		optBtns[0] = new JButton("Accept");
		optBtns[1] = new JButton("Cancel");
		
		//Add Listeners
		optBtns[0].addActionListener(new AcceptButtonListener());
		optBtns[1].addActionListener(new ExitButtonListener());
		
		for (int i = 0; i < 2; i++) {
			optPane.add(optBtns[i]);
		}

		add(optPane);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	
	// Opens main program when accept is hit with proper parameters
		private class AcceptButtonListener implements ActionListener {

			private ViewGUI setup;

			public void actionPerformed(ActionEvent arg0) {
				
				/*
				 * 
				 * PULL INFO From TEXTFIELDS INTO TOURNAMENT CLASS
				 * 
				 * THEN HAVE ViewGUI PULLING ITS INFO FROM TOURNAMENT INSTANCE
				 * 
				 */
				
				//Creates Main GUI
				for(int i = 0; i< Integer.parseInt(classText.getText()); i++) {
				setup = new ViewGUI();
				}
			}

		}
		
		// exits program
		private class ExitButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		}
}
