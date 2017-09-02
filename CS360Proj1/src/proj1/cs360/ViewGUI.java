package proj1.cs360;

import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Sep 02 02:34:57 EDT 2017
 */

/*
 * 
 * MAYBE MAKE THIS BE PASSED A TOURNAMENT CLASS AT INITIALIZATION
 * 
 * @ANEESH
 */

/**
 * @author Benjamin Treesh
 */
public class ViewGUI extends JFrame {
	public ViewGUI() {
		initComponents();
	}
	
	

	public JLabel getLabel1() {
		return label1;
	}



	public JComboBox getComboBox1() {
		return comboBox1;
	}



	public JScrollPane getScrollPane1() {
		return scrollPane1;
	}



	public JTextArea getTextArea4() {
		return textArea4;
	}



	public JPanel getPanel1() {
		return panel1;
	}



	public JTextArea getTextArea3() {
		return textArea3;
	}



	public JTextArea getTextArea1() {
		return textArea1;
	}



	public JTextArea getTextArea2() {
		return textArea2;
	}



	public JButton getButton1() {
		return button1;
	}



	public JButton getButton2() {
		return button2;
	}



	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Benjamin Treesh
		label1 = new JLabel();
		comboBox1 = new JComboBox();
		scrollPane1 = new JScrollPane();
		textArea4 = new JTextArea();
		panel1 = new JPanel();
		textArea3 = new JTextArea();
		textArea1 = new JTextArea();
		textArea2 = new JTextArea();
		button1 = new JButton();
		button2 = new JButton();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 40, 124, 0, 76, 0, 0, 0, 0, 80, 0};
		((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};
		((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0E-4};

		setVisible(true);
		
		//---- label1 ----
		label1.setText("Select a Sectional to View");
		contentPane.add(label1, new GridBagConstraints(0, 0, 5, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));
		contentPane.add(comboBox1, new GridBagConstraints(0, 1, 5, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//======== scrollPane1 ========
		{

			//---- textArea4 ----
			textArea4.setEditable(false);
			scrollPane1.setViewportView(textArea4);
		}
		contentPane.add(scrollPane1, new GridBagConstraints(0, 2, 5, 7, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 5), 0, 0));

		//======== panel1 ========
		{

			panel1.setLayout(new GridBagLayout());
			((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 257, 0, 0, 0, 0, 0};
			((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
			((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
			((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

			//---- textArea3 ----
			textArea3.setText("feeds into...");
			textArea3.setBorder(BorderFactory.createEtchedBorder());
			textArea3.setEditable(false);
			panel1.add(textArea3, new GridBagConstraints(0, 0, 6, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- textArea1 ----
			textArea1.setText("Regional:");
			textArea1.setBorder(BorderFactory.createEtchedBorder());
			textArea1.setEditable(false);
			panel1.add(textArea1, new GridBagConstraints(0, 1, 6, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- textArea2 ----
			textArea2.setText("Semi State:");
			textArea2.setBorder(BorderFactory.createEtchedBorder());
			textArea2.setEditable(false);
			panel1.add(textArea2, new GridBagConstraints(0, 2, 6, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- button1 ----
			button1.setText("Generate Map of Sectional");
			panel1.add(button1, new GridBagConstraints(0, 3, 6, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- button2 ----
			button2.setText("Generate Spreadsheet of Tournament Setup");
			panel1.add(button2, new GridBagConstraints(0, 4, 6, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, new GridBagConstraints(0, 9, 5, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 5), 0, 0));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Benjamin Treesh
	private JLabel label1;
	private JComboBox comboBox1;
	private JScrollPane scrollPane1;
	private JTextArea textArea4;
	private JPanel panel1;
	private JTextArea textArea3;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JButton button1;
	private JButton button2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
