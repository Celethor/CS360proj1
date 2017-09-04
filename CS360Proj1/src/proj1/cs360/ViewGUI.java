package proj1.cs360;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Sep 02 02:34:57 EDT 2017
 */

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;



/**
 * @author Benjamin Treesh 
 */
public class ViewGUI extends JFrame {
	public ViewGUI() {
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner License - Benjamin Treesh
		slctClsLbl = new JLabel();
		clsComboBox = new JComboBox();
		slctSectLbl = new JLabel();
		sectComboBox = new JComboBox();
		scrollPane1 = new JScrollPane();
		schoolDisplay = new JTextArea();
		panel1 = new JPanel();
		feedInto = new JTextArea();
		regText = new JTextArea();
		semiText = new JTextArea();
		mapGenBtn = new JButton();
		sheetGenBtn = new JButton();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 40, 124, 0, 76, 0, 0, 0, 0, 80, 0};
		((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};
		((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0E-4};

		//---- slctClsLbl ----
		slctClsLbl.setText("Choose a Class to View");
		contentPane.add(slctClsLbl, new GridBagConstraints(0, 0, 5, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 5, 5), 0, 0));
		contentPane.add(clsComboBox, new GridBagConstraints(0, 1, 5, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//---- slctSectLbl ----
		slctSectLbl.setText("Select a Sectional to View");
		contentPane.add(slctSectLbl, new GridBagConstraints(0, 2, 5, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 5, 5), 0, 0));
		contentPane.add(sectComboBox, new GridBagConstraints(0, 3, 5, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//======== scrollPane1 ========
		{

			//---- schoolDisplay ----
			schoolDisplay.setEditable(false);
			scrollPane1.setViewportView(schoolDisplay);
		}
		contentPane.add(scrollPane1, new GridBagConstraints(0, 4, 5, 7, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//======== panel1 ========
		{

			panel1.setLayout(new GridBagLayout());
			((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 257, 0, 0, 0, 0, 0};
			((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
			((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
			((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

			//---- feedInto ----
			feedInto.setText("feeds into...");
			feedInto.setBorder(BorderFactory.createEtchedBorder());
			feedInto.setEditable(false);
			panel1.add(feedInto, new GridBagConstraints(0, 0, 6, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- regText ----
			regText.setText("Regional:");
			regText.setBorder(BorderFactory.createEtchedBorder());
			regText.setEditable(false);
			panel1.add(regText, new GridBagConstraints(0, 1, 6, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- semiText ----
			semiText.setText("Semi State:");
			semiText.setBorder(BorderFactory.createEtchedBorder());
			semiText.setEditable(false);
			panel1.add(semiText, new GridBagConstraints(0, 2, 6, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- mapGenBtn ----
			mapGenBtn.setText("Generate Map of Sectional");
			panel1.add(mapGenBtn, new GridBagConstraints(0, 3, 6, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));
				//Add Eventhandler to button
				mapGenBtn.addActionListener(new mapGenListener());

			//---- sheetGenBtn ----
			sheetGenBtn.setText("Generate Spreadsheet of Tournament Setup");
			panel1.add(sheetGenBtn, new GridBagConstraints(0, 4, 6, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, new GridBagConstraints(0, 11, 5, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 5), 0, 0));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Benjamin Treesh
	private JLabel slctClsLbl;
	private JComboBox clsComboBox;
	private JLabel slctSectLbl;
	private JComboBox sectComboBox;
	private JScrollPane scrollPane1;
	private JTextArea schoolDisplay;
	private JPanel panel1;
	private JTextArea feedInto;
	private JTextArea regText;
	private JTextArea semiText;
	private JButton mapGenBtn;
	private JButton sheetGenBtn;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	//Generates map given URL created by MapBuilder Class
	private class mapGenListener implements ActionListener {

		
		public void actionPerformed(ActionEvent arg0) {
			
			//Test URL string for window
			String url = "https://maps.googleapis.com/maps/api/staticmap?center=Indianapolis,IN&zoom=7&size=500x500&markers=color:green%7CHuntington+North+High+School";
			

			Display display = new Display();
			
	        Shell shell = new Shell(display);
	        shell.setSize(552, 575);
	        
	        new MapGUI(shell, SWT.NONE, url);

//	         the layout manager handle the layout
//	         of the widgets in the container
	        shell.setLayout(new FillLayout());

	        //add some widgets to the Shell
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
