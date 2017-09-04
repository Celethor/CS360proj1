package proj1.cs360;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import com.google.maps.errors.ApiException;

public class MainGUI extends JFrame {

	private final int WINDOW_WIDTH = 240;
	private final int WINDOW_HEIGHT = 240;
	private JTextField classText;
	private JLabel classLbl;
	private JPanel optPane = new JPanel(new GridLayout(1,3));
	private JButton[] optBtns = new JButton[3];
	private Classify[] classObj;

	public MainGUI() {

		setTitle("Welcome, my Lord");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setSize(WINDOW_WIDTH + 1, WINDOW_HEIGHT + 1);

		setLayout(new GridLayout(3, 1));

		// init and add classLbl
		classLbl = new JLabel("How many classes would you like?");
		add(classLbl);

		// init and add classText
		add(classText = new JTextField());
		classText.setBorder(BorderFactory.createEtchedBorder());

		// create buttons add to optnPane
		optBtns[0] = new JButton("Accept");
		optBtns[1] = new JButton("Cancel");
		optBtns[2] = new JButton("View");

		// Add Listeners
		optBtns[0].addActionListener(new AcceptButtonListener());
		optBtns[1].addActionListener(new ExitButtonListener());
		optBtns[2].addActionListener(new ViewButtonListener());

		for (int i = 0; i < 3; i++) {
			optPane.add(optBtns[i]);
		}

		add(optPane);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	// Opens main program when accept is hit with proper parameters
	private class AcceptButtonListener implements ActionListener {


		public void actionPerformed(ActionEvent arg0) {

			/*
			 * 
			 * PULL INFO From TEXTFIELDS INTO TOURNAMENT CLASS
			 * 
			 * THEN HAVE ViewGUI PULLING ITS INFO FROM TOURNAMENT INSTANCE
			 * 
			 */

			// read schools
			File file = new File("All Schools Lists.txt");
			ArrayList<School> schools = new ArrayList<School>();
			School x = new School();
			String name;
			String location;
			int enrollment;
			boolean boys;
			boolean girls;
			boolean HostSect;
			boolean HostReg;
			boolean HostSemi;
			Scanner scan = null;
			try {
				scan = new Scanner(file).useDelimiter("\\*|\\n");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int c = 0;
			int hR = 0;
			int hS = 0;
			int hSec = 0;
			while (scan.hasNext()) {
				name = scan.next();
				enrollment = scan.nextInt();
				boys = assignBoolean(scan.next());
				girls = assignBoolean(scan.next());
				HostSect = assignBoolean(scan.next());
				if (HostSect == true)
					hSec++;
				HostReg = assignBoolean(scan.next());
				if (HostReg == true)
					hR++;
				// do this for semi hosts since scan.next() also reads
				// end of line character
				char q = scan.next().charAt(0);

				if (q == 'T' || q == 't') {
					hS++;
					HostSemi = true;
				} else
					HostSemi = false;
				c++;
				try {
					x = new School(name + ",IN", enrollment, boys, girls, HostSect, HostReg, HostSemi);
				} catch (ClassNotFoundException | ApiException | InterruptedException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				schools.add(x);
			}
			// now done reading schools
			// Creates Main GUI
			int numOfClasses = Integer.parseInt(classText.getText());
			SetupGUI setup[] = new SetupGUI[numOfClasses];
			classObj = new Classify[numOfClasses];

			for (int i = 0; i < numOfClasses; i++) {
				classObj[i] = new Classify();

				// Classify r=new Classify(schools);
				try {
					setup[i] = new SetupGUI(schools, i, classObj[i]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}

	}

	// exits program
		private class ViewButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Semi no. "+classObj[0].getSemiNo());
				//check if any classify objects have not been initialized 
				for(int i= 0; i < classObj.length; i++) {
					if(classObj[i].getSemiNo() == 0){
						JOptionPane.showMessageDialog(null, "Finish initializing all classes please.");
						return;
					}
				}
				
				//new ViewGUI(classObj);

			}

		}
	
	// exits program
	private class ExitButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}

	}

	public static boolean assignBoolean(String x) {
		if (x.equals("T") || x.equals("t"))
			return true;
		else
			return false;
	}
}
