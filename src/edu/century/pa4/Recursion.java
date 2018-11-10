package edu.century.pa4;
/**public class Recursion from the package edu.century.pa4
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  Recursion.java, Programming Assignment 04.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 11/09/2018
 * */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class Recursion {
	
	public static void main(String[] args) {
		//To show calculation and display Pyramid on console.
		System.out.println("C( n , r) = " + C(10,5));
		System.out.println(pyramid(10, "*"));
		//****************************
		
		//To show calculation and display Pyramid on GUI.
		recursionGUI();
	}
	
//*******Start for Combinations Calculator***********************************
	/* public static long C(long n, long r)
	 * @Descriptions 
	 * 		to calculate Combinations. 
	 * @Parameter
	 * 		n - long integer number a set;
	 * 		r - long integer number of possible;
	 * @Precondition
	 * 		n - must positive and larger than r;
	 * 		r - must be positive and smaller than n;
	 * @Postcondition
	 * @Return
	 * 		 long integer number of calculating combinatiions.
	 * @Thorws 	
	 * 		the Exception if enter wrong numbers.	
	 * */
	public static long C(long n, long r) {
		if(n==r) return 1;
		if(n<r || n<=0 ||r<=0)
			try {
				throw new Exception( "Please...Enter"
						+ " the Correct Numbers!\n");
			} catch (Exception e) {
				e.printStackTrace();
				txtrAreaOfDisplay.append(e.getMessage());
			}else return  factorial(n) 
					/ (factorial(r) * factorial(n-r));		
		return 0;
	}	
	
	/* private static long factorial(long n)
	 * @Descriptions 
	 * 		to calculate factorial. 
	 * @Parameter
	 * 		n - long integer number a set;
	 * @Precondition
	 * 		n - must positive.
	 * @Postcondition
	 * @Return
	 * 		 the number of calculating factorial.
	 * @Thorws 	
	 * 		the Exception if enter negative numbers.	
	 * */
	private static long factorial(long n) {
		if(n<=0)
			try {
				throw new Exception( "Please...Enter"
						+ " the Correct Numbers!\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		if(n==1) return 1;
		else return n * factorial(n-1);
	}
//*******End for Combinations Calculator******************************
	
//*******Start for Pyramid methods**************************************
	//Global available for set row for pyramid.
	private static int row;
	//Global available for add all the symbols.
	private static String addAllSymbol;
	//Global available for set the symbols for pyramid.
	private static String symbol;
	//Global available for counting all the symbols.	
	private static int countSymbol;
	
	/* public static String pyramid(int setRow, String setSymbol)
	 * @Descriptions 
	 * 		to display the pyramid of a symbol and total number of symbol. 
	 * @Parameter
	 * 		setRow - integer number of row of pyramid;
	 * 		setSymbol - String symbol that set to pyramid;
	 * @Precondition
	 * 		setRow - must be positive numbers;
	 * 		setSymbol - must not be null;
	 * @Postcondition
	 * @Return
	 * 		 String of pyramid and total number of symbols.
	 * @Thorws 	
	 * 		the Exception if enter negative numbers
	 * 		 to set row and null to set symbol.	
	 * */	
	public static String pyramid(int setRow, String setSymbol) {
		if(setRow<1) {
			try {
				throw new Exception( "Please...Enter "
						+ "Numbers! larger than 1.\n");
			} catch (Exception e) {
				e.printStackTrace();
				txtrAreaOfDisplay.append(e.getMessage());
			return "";
			}
		}else {
			addAllSymbol = "";
			row = setRow;
			symbol = setSymbol;
			countSymbol=0;
		return pyramidTree(0) + "Total Numbers "
				+ "of Symbols: " +countSymbol+"\n";
		}
	}
	
	/* private static String pyramidTree(int i)
	 * @Descriptions 
	 * 		to build the pyramid of symbol by recursive function. 
	 * @Parameter
	 * 		i - integer number for set start to build pyramid;
	 * @Precondition
	 * 		i - must be positive numbers;
	 * @Postcondition
	 * @Return
	 * 		 String of pyramid tree of all symbols.
	 * @Thorws 	
	 * 		the Exception if enter negative numbers	
	 * */
	private static String pyramidTree(int i) {		
		rowSpace(0,i);
		rowSymbol(row,i);
		addAllSymbol += "\n";
		if(++i < row) pyramidTree(i);
		return addAllSymbol;
	}
	
	/* private static void rowSpace(int j, int i)
	 * @Descriptions 
	 * 		to build the space of each row for the pyramid of symbol by recursive function. 
	 * @Parameter
	 * 		j - integer number for set start to recursion;
	 * 		i - integer number for set start to recursion;
	 * @Precondition
	 * 		j - must be positive numbers;
	 * 		i - must be positive numbers;
	 * @Postcondition
	 * @Return
	 * @Thorws 	
	 * */
	private static void rowSpace(int j, int i) {
		if(j<row-i-1) {
		addAllSymbol += " ";
		rowSpace(j+1,i);		
		}
	}
	
	/* private static void rowSymbol(int k, int i)
	 * @Descriptions 
	 * 		to build the Symbols of each row for the pyramid of symbol by recursive function. 
	 * @Parameter
	 * 		k - integer number for set start to recursion;
	 * 		i - integer number for set start to recursion;
	 * @Precondition
	 * 		k - must be positive numbers;
	 * 		i - must be positive numbers;
	 * @Postcondition
	 * @Return
	 * @Thorws 	
	 * */
	private static void rowSymbol(int k, int i) {
		if(k>row-i-1) {
			addAllSymbol += symbol +" "; 
			countSymbol++;
		rowSymbol(k-1, i);
		}	
	}
//*******End for Pyramid methods*************************************

	
	
	
	
	
//*******Start for GUI method**************************************
	private static JTextArea txtrAreaOfDisplay;
	private static JTextField textField_3;
	private static JTextField textField_4;
	public static void recursionGUI() {
		JFrame frame = new JFrame("Recursion");
		frame.setBounds(100, 100, 445, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("C( n , r ) :");
		panel.add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setText("12");
		panel.add(textField);
		textField.setColumns(3);
		
		JTextField textField_1 = new JTextField();
		textField_1.setText("4");
		panel.add(textField_1);
		textField_1.setColumns(3);
		
		
		
		JLabel lblResult = new JLabel("Result:");
		panel.add(lblResult);
		
		JTextField txtResult = new JTextField();
		txtResult.setEditable(false);
		panel.add(txtResult);
		txtResult.setColumns(7);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{86, 0};
		gbl_panel_1.rowHeights = new int[]{41, 
				33, 27, 37, 16, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblPyramid = new JLabel("      Pyramid Tree   ");
		GridBagConstraints gbc_lblPyramid = new GridBagConstraints();
		gbc_lblPyramid.fill = GridBagConstraints.BOTH;
		gbc_lblPyramid.insets = new Insets(0, 0, 5, 0);
		gbc_lblPyramid.gridx = 0;
		gbc_lblPyramid.gridy = 0;
		panel_1.add(lblPyramid, gbc_lblPyramid);
		
		JLabel lblNewLabel_1 = new JLabel("   Set Symbol:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setText("*");
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.insets = new Insets(0, 30, 5, 30);
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 2;
		panel_1.add(textField_3, gbc_textField_3);
		textField_3.setColumns(5);
		
		JLabel lblNewLabel_2 = new JLabel("   Set Number Row:    ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setText("10");
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 30, 5, 30);
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 0;
		gbc_textField_4.gridy = 4;
		panel_1.add(textField_4, gbc_textField_4);
		textField_4.setColumns(5);
		
		
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		txtrAreaOfDisplay = new JTextArea();
		txtrAreaOfDisplay.setText("Area of Display: \n");
		txtrAreaOfDisplay.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtrAreaOfDisplay);
		scrollPane.setVerticalScrollBarPolicy(
				scrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(
				scrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_2.add(scrollPane);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtrAreaOfDisplay.append("C( "+textField.getText()+" , " + 
				textField_1.getText()+" ) = "+String.valueOf(
						C(Integer.valueOf(textField.getText()),
						Integer.valueOf(textField_1.getText())))+"\n");
			}
		});
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//txtrAreaOfDisplay.setText("");
				txtrAreaOfDisplay.append(pyramid(Integer.valueOf(
						textField_4.getText()),
						textField_3.getText()));
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 6;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		panel.add(btnCalculate);
		
		frame.setVisible(true);
	}
//*******End for GUI method*************************************
	
}


