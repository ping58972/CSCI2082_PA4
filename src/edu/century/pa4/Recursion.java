package edu.century.pa4;

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
		System.out.println("C( n , r) = "+C(10,5));
		System.out.println(pyramid(10, "*"));
		recursionGUI();
	}
	
	public static long C(long n, long r) {
		if(n==r) return 1;
		if(n<r || n<=0 ||r<=0)
			try {
				throw new Exception( "Please...Enter"
						+ " the Correct Numbers!\n");
			} catch (Exception e) {
				e.printStackTrace();
				txtrAreaOfDisplay.append(e.getMessage());
			}else return  factory(n) 
					/ (factory(r) * factory(n-r));		
		return 0;
	}
	public static long factory(long n) {
		if(n==1) return 1;
		else return n * factory(n-1);
	}
	
	private static int row;
	private static String str;
	private static String symbol;
	private static int totalSymbol;
	private static JTextField textField_3;
	private static JTextField textField_4;

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
			str = "";
			row = setRow;
			symbol = setSymbol;
			totalSymbol=0;
		return pyramidTree(0) + "Total Numbers "
				+ "of Symbols: " +totalSymbol+"\n";
		}
	}
	private static String pyramidTree(int i) {		
		rowSpace(0,i);
		rowStar(row,i);
		str += "\n";
		if(++i < row) pyramidTree(i);
		return str;
	}

	private static void rowSpace(int j, int i) {
		if(j<row-i-1) {
		str += " ";
		rowSpace(j+1,i);		
		}
	}
	
	private static void rowStar(int k, int i) {
		if(k>row-i-1) {
			str += symbol +" "; 
			totalSymbol++;
		rowStar(k-1, i);
		}	
	}
	
	
	private static JTextArea txtrAreaOfDisplay;
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
		gbl_panel_1.rowHeights = new int[]{41, 33, 27, 37, 16, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_2.add(scrollPane);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtrAreaOfDisplay.append("C( "+textField.getText()+" , " + 
				textField_1.getText()+" ) = "+String.valueOf(C(Integer.valueOf(textField.getText()),
						Integer.valueOf(textField_1.getText())))+"\n");
			}
		});
		
		JButton btnNewButton = new JButton("Display");
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//txtrAreaOfDisplay.setText("");
				txtrAreaOfDisplay.append(pyramid(Integer.valueOf(textField_4.getText()),
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
	
}


