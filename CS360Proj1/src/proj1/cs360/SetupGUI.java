package proj1.cs360;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SetupGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int WINDOW_WIDTH = 240;
	private final int WINDOW_HEIGHT = 240;
	private JPanel tilePane, optPane;
	private JButton[] optBtns = new JButton[3];
	private JTextField[] numMeets = new JTextField[3];

	public SetupGUI() {
		setTitle("Tournament Parameters");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setSize(WINDOW_WIDTH + 1, WINDOW_HEIGHT + 1);

		// Make new Jpanels with gridlayouts
		tilePane = new JPanel(new GridLayout(4, 1));

		optPane = new JPanel(new GridLayout(1, 3));

		// add tilePane to window
		add(tilePane);

		// create input boxes
		numMeets[0] = new JTextField();
		numMeets[1] = new JTextField();
		numMeets[2] = new JTextField();

		// add borders to input boxes
		numMeets[0].setBorder(BorderFactory.createTitledBorder("Number of Sectionals"));
		numMeets[1].setBorder(BorderFactory.createTitledBorder("Number of Regionals"));
		numMeets[2].setBorder(BorderFactory.createTitledBorder("Number of Semi States"));

		// add input boxes to tilePane
		for (int i = 0; i < 3; i++) {
			tilePane.add(numMeets[i]);
		}

		// create buttons add to optnPane then tilePane
		optBtns[0] = new JButton("Accept");
		optBtns[1] = new JButton("Load File");
		optBtns[2] = new JButton("Cancel");

		// add listeners to buttons
		optBtns[0].addActionListener(new AcceptButtonListener());
		// btn[1]
		optBtns[2].addActionListener(new ExitButtonListener());

		for (int i = 0; i < 3; i++) {
			optPane.add(optBtns[i]);
		}

		tilePane.add(optPane);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	// exits program
	private class ExitButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}

	}

	// Opens main program when accept is hit with proper parameters
	private class AcceptButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			/*
			 * 
			 * PULL INFO From TEXTFIELDS INTO TOURNAMENT CLASS
			 * 
			 * THEN HAVE MAIN GUI PULLING ITS INFO FROM TOURNAMENT INSTANCE
			 * 
			 */
			
			//Creates Main GUI
			Display display = new Display();

			Shell shell = new Shell(display);

			new GUITest(shell, SWT.NONE);

			// the layout manager handle the layout
			// of the widgets in the container
			shell.setLayout(new FillLayout());

			// add some widgets to the Shell
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
			display.dispose();

		}
	}
}
