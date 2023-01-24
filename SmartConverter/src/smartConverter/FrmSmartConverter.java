package smartConverter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmSmartConverter extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumberConversion;
	private JTextField txtHexadecimal;
	private JTextField txtBinary;
	private JTextField txtDecimal;
	private Binary binary;
	private Decimal decimal;
	private Hexadecimal hexadecimal;
	String conversionNumber = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSmartConverter frame = new FrmSmartConverter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmSmartConverter() {
		setTitle("Smart Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0xD0F0C0));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JComboBox cbxNumberSystem = new JComboBox();
		cbxNumberSystem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbxNumberSystem.setBackground(new Color(255, 255, 255));
		cbxNumberSystem.setModel(new DefaultComboBoxModel(new String[] {"Hexadecimal", "Binary", "Decimal"}));
		GridBagConstraints gbc_cbxNumberSystem = new GridBagConstraints();
		gbc_cbxNumberSystem.insets = new Insets(0, 0, 5, 5);
		gbc_cbxNumberSystem.gridwidth = 5;
		gbc_cbxNumberSystem.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxNumberSystem.gridx = 2;
		gbc_cbxNumberSystem.gridy = 1;
		contentPane.add(cbxNumberSystem, gbc_cbxNumberSystem);
		
		JLabel lblEnterNumber = new JLabel("Enter number for conversion:");
		lblEnterNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblEnterNumber = new GridBagConstraints();
		gbc_lblEnterNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterNumber.gridx = 2;
		gbc_lblEnterNumber.gridy = 2;
		contentPane.add(lblEnterNumber, gbc_lblEnterNumber);
		
		txtNumberConversion = new JTextField();
		txtNumberConversion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					conversionNumber = txtNumberConversion.getText();
					
					if(conversionNumber.equals("")) {
						JOptionPane.showMessageDialog(null, 
								"Niste upisali nijedan broj", "Los unos", JOptionPane.WARNING_MESSAGE);
					}else if(cbxNumberSystem.getSelectedIndex() == 0 && hexadecimal.check(conversionNumber) == true) {
						try {
							txtHexadecimal.setText(conversionNumber.toUpperCase());
							
							int decimalni = Integer.parseInt(conversionNumber, 16);
							txtDecimal.setText(Integer.toString(decimalni));
							
							int binarni = Integer.parseInt(conversionNumber, 16);
							txtBinary.setText(Integer.toBinaryString(binarni));
						}catch(NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, 
									"Niste upisali heksadecimalni broj", "Los unos", JOptionPane.WARNING_MESSAGE);
						}
					}else if (cbxNumberSystem.getSelectedIndex() == 1) {
						
						if(binary.check(conversionNumber) == true) {
						try {
							txtBinary.setText(conversionNumber);
							int decimalni = Integer.parseInt(conversionNumber, 2);
							txtDecimal.setText(Integer.toString(decimalni));
							
							int heksadecimalni = Integer.parseInt(conversionNumber, 2);
							txtHexadecimal.setText(Integer.toHexString(heksadecimalni).toUpperCase());
						
						}catch(Exception ee) {
							
							txtBinary.setText(conversionNumber);
							
							String binarni = conversionNumber;
							String invbin = binarni.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");
							int bin = Integer.parseInt(invbin);
							int bin1 = bin+1; 
							String binary = Integer.toString(bin1);
							
							int dec = Integer.parseInt(binary, 2);
							String decimalni = Integer.toString(dec);
							txtDecimal.setText("-"+decimalni);
							
							String heksadecimalni = Integer.toHexString(dec);
							txtHexadecimal.setText("-"+heksadecimalni.toUpperCase());
						}}else {
							JOptionPane.showMessageDialog(null, 
									"Niste upisali binarni broj", "Los unos", JOptionPane.WARNING_MESSAGE);
						
						}
						
					}else if(cbxNumberSystem.getSelectedIndex() == 2 && decimal.check(conversionNumber) == true){
						try {
							txtDecimal.setText(conversionNumber);
							
							int binarni = Integer.parseInt(conversionNumber, 10);
							txtBinary.setText(Integer.toBinaryString(binarni));
							
							if(conversionNumber.charAt(0) == '-') {
								int decimalni = Integer.parseInt(conversionNumber, 10);
								txtHexadecimal.setText("-" +Integer.toHexString(Math.abs(decimalni)).toUpperCase());
								}else {
									int heksadecimalni = Integer.parseInt(conversionNumber, 10);
									txtHexadecimal.setText(Integer.toHexString(heksadecimalni).toUpperCase());
								
								}
						}catch(NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, 
									"Niste upisali decimalni broj", "Los unos", JOptionPane.WARNING_MESSAGE);
						}	
					}
				}					
			}
		});
		txtNumberConversion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_txtNumberConversion = new GridBagConstraints();
		gbc_txtNumberConversion.gridwidth = 2;
		gbc_txtNumberConversion.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumberConversion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumberConversion.gridx = 5;
		gbc_txtNumberConversion.gridy = 2;
		contentPane.add(txtNumberConversion, gbc_txtNumberConversion);
		txtNumberConversion.setColumns(10);
		
		txtHexadecimal = new JTextField();
		txtHexadecimal.setEditable(false);
		txtHexadecimal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHexadecimal.setEnabled(true);
		txtHexadecimal.setText("Hexadecimal");
		GridBagConstraints gbc_txtHexadecimal = new GridBagConstraints();
		gbc_txtHexadecimal.gridwidth = 5;
		gbc_txtHexadecimal.insets = new Insets(0, 0, 5, 5);
		gbc_txtHexadecimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHexadecimal.gridx = 2;
		gbc_txtHexadecimal.gridy = 4;
		contentPane.add(txtHexadecimal, gbc_txtHexadecimal);
		txtHexadecimal.setColumns(10);
		
		txtBinary = new JTextField();
		txtBinary.setEditable(false);
		txtBinary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBinary.setEnabled(true);
		txtBinary.setText("Binary");
		GridBagConstraints gbc_txtBinary = new GridBagConstraints();
		gbc_txtBinary.gridwidth = 5;
		gbc_txtBinary.insets = new Insets(0, 0, 5, 5);
		gbc_txtBinary.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBinary.gridx = 2;
		gbc_txtBinary.gridy = 5;
		contentPane.add(txtBinary, gbc_txtBinary);
		txtBinary.setColumns(10);
		
		txtDecimal = new JTextField();
		txtDecimal.setEditable(false);
		txtDecimal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDecimal.setText("Decimal");
		txtDecimal.setEnabled(true);
		GridBagConstraints gbc_txtDecimal = new GridBagConstraints();
		gbc_txtDecimal.gridwidth = 5;
		gbc_txtDecimal.insets = new Insets(0, 0, 5, 5);
		gbc_txtDecimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDecimal.gridx = 2;
		gbc_txtDecimal.gridy = 6;
		contentPane.add(txtDecimal, gbc_txtDecimal);
		txtDecimal.setColumns(10);
		
		binary = new Binary();
		binary.setBinary(txtBinary.getText());
		
		decimal = new Decimal();
		decimal.setDecimal(txtDecimal.getText());
		
		hexadecimal = new Hexadecimal();
		hexadecimal.setHexadecimal(txtHexadecimal.getText());
	}

}
