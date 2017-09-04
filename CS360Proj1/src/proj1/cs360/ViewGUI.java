package proj1.cs360;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	/**
	 * 
	 */
	private static final long serialVersionUID = -3475968061247067648L;
	public ViewGUI(Classify classObj) {
		this.classObj = classObj;
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
		
		//---- clsComboBox components ----
		//add classArr components
	//	for(int i = 0; i<classArr.length; i++){
	//		clsComboBox.addItem(classArr[i].getClassName());
	//	}
		
		

		//---- slctSectLbl ----
		slctSectLbl.setText("Select a Sectional to View");
		contentPane.add(slctSectLbl, new GridBagConstraints(0, 2, 5, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 5, 5), 0, 0));
		contentPane.add(sectComboBox, new GridBagConstraints(0, 3, 5, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		
		//-----sectComboBox components----
		//add sectional components for particular class
		ArrayList<Sectional> sectionals=classObj.getSectionals();
		for(int i=0;i<sectionals.size();i++){
			sectComboBox.addItem(i);
		}
		
		sectComboBox.addActionListener(new SectionalComboListener());
		
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
	private JComboBox  clsComboBox;
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
	private Classify[] classArr;
	private Classify classObj;
	private Sectional currentSect;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	
	//Combobox listener for sectionals
	public class SectionalComboListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//JComboBox cb=(JComboBox)e.getSource();
			//Sectional toDisplay=(Sectional)cb.getSelectedItem();
			int x=(int)sectComboBox.getSelectedItem();
			currentSect=classObj.getSectionals().get(x);
			schoolDisplay.setText(currentSect.toString());
			
			
			//update text field to show all current sectionals
			
			//update
			
			
		}
	}
	//Generates map given URL created by MapBuilder Class
	private class mapGenListener implements ActionListener {

		
		public void actionPerformed(ActionEvent arg0) {
			
			//Test URL string for window
			//String url = "https://maps.googleapis.com/maps/api/staticmap?&size=500x500&markers=size:small%7ccolor:green%7cHammond+Gavit+High+School,IN&markers=size:small%7ccolor:blue%7clabel:S%7c41.5762616,-87.4875017%7c41.5545436,-87.5048099%7c41.5481653,-87.45544319999999%7c41.5864118,-87.4398167%7c41.60522599999999,-87.509568%7c41.6283089,-87.491937%7c41.6179983,-87.5235321%7c41.5327164,-87.436207%7c41.59385,-87.4078595%7c41.6403209,-87.4853127%7c41.5476375,-87.4092115%7c41.5977957,-87.39227699999999%7c41.6782559,-87.50683839999999%7c&maptype=roadmap";
			
			//build new MapBuilder Obj
			MapBuilder map = new MapBuilder(currentSect.getHostSchool(),currentSect.getSchools());
			
			map.BuildURL();
			
			String url = map.getFinalURL();

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
	
	//Listener to check currently selected Sectional

		
	}
	

