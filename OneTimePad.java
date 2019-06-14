import java.awt.EventQueue;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Color;
import java.io.*;
import java.awt.GridLayout;


public class OneTimePad {

	public JTabbedPane OTPpanel;
	public JScrollPane js;
	public JPanel OTPpanel1;
	public JPanel OTPpanel2;
	public JPanel OTPpanel3;
	public JTextField textField;
	public JTextField textField_1;
	public JLabel lblKey;
	public JTextField textField_2;
	public JLabel lblMessage;
	public JButton btnEncrypt;
	public JButton btnBack;
	public JButton btnNewButton;
	private JLabel lblFileSource;
	private JTextField textField_4;
	private JButton btnBrowse;
	private JButton btnEncryt;
	private JLabel lblKey_1;
	public StringBuilder sb;
	private JButton btnDecrypt;
	GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gbc_lblCeasersCipher = new GridBagConstraints();
    public  JTextArea txtrInCryptographyA = new JTextArea();
    public JTextArea txtrTheEncryptionStep = new JTextArea();
    public JLabel img = new JLabel();
    public JButton btnBack_1;
    public JButton btnBack_2;
    private JTextField textField_3;
    private TextArea textArea_1;
    private TextArea textArea_2;
    private JButton btnClear;
    public String EncFile;
	public String DecFile;
	public String KEY;
	public String source = "One Time Pad";
	private JLabel lblPlainText;
	private JLabel lblPlainText_1;

	public OneTimePad() {
		OTPpanel = new JTabbedPane();
		OTPpanel.setSize(new Dimension(556, 416));
		OTPpanel.setFont(new Font("Consolas", Font.PLAIN, 15));;
		
		
		OTPpanel2 = new JPanel();
		OTPpanel2.setBackground(Color.BLUE.darker());
		OTPpanel2.setSize(556,416);
		GridBagLayout gbl_OTPpanel2 = new GridBagLayout();
		gbl_OTPpanel2.columnWidths = new int[]{67, 60, 89, 100, 112, 134, 0};
		gbl_OTPpanel2.rowHeights = new int[]{52, 36, 37, 53, 56, 58, 69, 0};
		gbl_OTPpanel2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_OTPpanel2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		OTPpanel2.setLayout(gbl_OTPpanel2);
		
		btnNewButton = new JButton("DECRYPT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				int temp;
				char c;
				String Msg = "";
				int sum;
				String key = textField_1.getText();
				String ctx = textField_2.getText().toUpperCase();
				for(int i=0;i<ctx.length();i++) {
					sum = ctx.charAt(i) - key.charAt(i);
					if(sum>=0) {
						temp = sum + 64;
					}
					else {
						temp = sum + 90;
					}
					c = (char)temp;
					Msg = Msg + c ;
				}
				textField_2.setText(Msg);	
				}catch(Exception e3){
					JOptionPane.showMessageDialog(new JFrame(),"Please enter the message or key as required");
				}
			}
		});
		
		JLabel lblPhrase = new JLabel("Phrase:");
		lblPhrase.setForeground(Color.WHITE);
		lblPhrase.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPhrase = new GridBagConstraints();
		gbc_lblPhrase.anchor = GridBagConstraints.WEST;
		gbc_lblPhrase.fill = GridBagConstraints.VERTICAL;
		gbc_lblPhrase.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhrase.gridx = 1;
		gbc_lblPhrase.gridy = 1;
		OTPpanel2.add(lblPhrase, gbc_lblPhrase);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 3;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		OTPpanel2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblKey = new JLabel("Key:");
		lblKey.setForeground(Color.WHITE);
		lblKey.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_lblKey = new GridBagConstraints();
		gbc_lblKey.fill = GridBagConstraints.BOTH;
		gbc_lblKey.insets = new Insets(0, 0, 5, 5);
		gbc_lblKey.gridx = 1;
		gbc_lblKey.gridy = 3;
		OTPpanel2.add(lblKey, gbc_lblKey);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		OTPpanel2.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblMessage = new JLabel("Message:");
		lblMessage.setForeground(Color.WHITE);
		lblMessage.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.fill = GridBagConstraints.BOTH;
		gbc_lblMessage.insets = new Insets(0, 0, 5, 5);
		gbc_lblMessage.gridx = 1;
		gbc_lblMessage.gridy = 4;
		OTPpanel2.add(lblMessage, gbc_lblMessage);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 4;
		OTPpanel2.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		btnEncrypt = new JButton("ENCRYPT");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try{
			String msg = textField.getText().replaceAll("\\s","");
			String key="",ctx="";
			msg = msg.toUpperCase();
			Random r = new Random();
			for(int i=0;i<msg.length();++i) {
				int rm = r.nextInt(26);
				key = key + (char)(64 + rm);
			}
			textField_1.setText(key);
			int t;
			for(int i=0;i<msg.length();i++) {
				t = msg.charAt(i) + key.charAt(i);
				if(t >= 155)
					t =t - 90;
				else
					t = t -64;
				char c = (char)t;
				ctx = ctx + c;
			}
			textField_2.setText(ctx);
			}catch(Exception e1){
				JOptionPane.showMessageDialog(new JFrame(),"Please enter the message or key as required");
			}
		}
		});
		GridBagConstraints gbc_btnEncrypt = new GridBagConstraints();
		gbc_btnEncrypt.insets = new Insets(0, 0, 5, 5);
		gbc_btnEncrypt.gridx = 2;
		gbc_btnEncrypt.gridy = 5;
		OTPpanel2.add(btnEncrypt, gbc_btnEncrypt);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 5;
		OTPpanel2.add(btnNewButton, gbc_btnNewButton);
		
		btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		
		
		OTPpanel1 = new JPanel();
		OTPpanel1.setForeground(Color.WHITE);
		OTPpanel1.setFont(new Font("Consolas", Font.PLAIN, 12));
		OTPpanel1.setLayout(gb);
		OTPpanel1.setBackground(Color.BLUE.darker());
		js = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.getVerticalScrollBar().setUnitIncrement(16);
		js.getViewport().setViewPosition(new Point(0,0));
		js.setViewportView(OTPpanel1);
		
				
		 gb.columnWidths = new int[] {120,120,120,120};
		 gb.rowHeights = new int[] {60,60,60,60,60};
		 gbc_lblCeasersCipher.insets = new Insets(0, 0, 5, 0);
		 gbc_lblCeasersCipher.fill = GridBagConstraints.BOTH;
		 gbc_lblCeasersCipher.gridx=0;
		 gbc_lblCeasersCipher.gridy=0;
		 gbc_lblCeasersCipher.gridwidth = GridBagConstraints.REMAINDER;
		 JLabel lblCeasersCipher = new JLabel("ONE TIME PAD");
		 lblCeasersCipher.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		 lblCeasersCipher.setForeground(Color.WHITE);
		 lblCeasersCipher.setHorizontalAlignment(SwingConstants.CENTER);
		 OTPpanel1.add(lblCeasersCipher, gbc_lblCeasersCipher);	
		 
		 		 
		 		 GridBagConstraints gbc_txtrInCryptographyA = new GridBagConstraints();
		 		 gbc_txtrInCryptographyA.gridwidth = 4;
		 		 gbc_txtrInCryptographyA.insets = new Insets(0, 0, 5, 0);
		 		 gbc_txtrInCryptographyA.fill = GridBagConstraints.BOTH;
		 		 gbc_txtrInCryptographyA.gridx = 0;
		 		 gbc_txtrInCryptographyA.gridy = 1;
		 		 txtrInCryptographyA.setBorder(null);
		 		 txtrInCryptographyA.setBackground(Color.BLUE.darker());
		 		 txtrInCryptographyA.setForeground(Color.WHITE);
		 		 txtrInCryptographyA.setLineWrap(true);
		 		 txtrInCryptographyA.setWrapStyleWord(true);
		 		 txtrInCryptographyA.setText("In cryptography, the one-time pad (OTP) is an encryption technique that cannot be cracked if used correctly. In this technique, a plaintext is paired with a random secret key (also referred to as a one-time pad). Then, each bit or character of the plaintext is encrypted by combining it with the corresponding bit or character from the pad using modular addition. If the key is truly random, is at least as long as the plaintext, is never reused in whole or in part, and is kept completely secret, then the resulting ciphertext will be impossible to decrypt or break.[1][2][3] It has also been proven that any cipher with the perfect secrecy property must use keys with effectively the same requirements as OTP keys.[4] However, practical problems have prevented one-time pads from being widely used.");
		 		 OTPpanel1.add(txtrInCryptographyA, gbc_txtrInCryptographyA);
		 		 
		 		 gbc_lblCeasersCipher = new GridBagConstraints();
		 		 gbc_lblCeasersCipher.insets = new Insets(0, 0, 5, 0);
		 		 gbc_lblCeasersCipher.fill = GridBagConstraints.BOTH;
		 		 gbc_lblCeasersCipher.gridx=0;
		 		 gbc_lblCeasersCipher.gridy=2;
		 		 gbc_lblCeasersCipher.gridwidth = GridBagConstraints.REMAINDER;
		 		 img.setHorizontalAlignment(SwingConstants.CENTER);
		 		 img.setIcon(new ImageIcon("img/otp.png"));
		 		 OTPpanel1.add(img, gbc_lblCeasersCipher);
		 		 
		 		 GridBagConstraints gbc_txtrTheEncryptionStep = new GridBagConstraints();
		 		 gbc_txtrTheEncryptionStep.insets = new Insets(0, 0, 5, 0);
		 		 gbc_txtrTheEncryptionStep.gridwidth = 4;
		 		 gbc_txtrTheEncryptionStep.fill = GridBagConstraints.BOTH;
		 		 gbc_txtrTheEncryptionStep.gridx = 0;
		 		 gbc_txtrTheEncryptionStep.gridy = 3;
		 		 txtrTheEncryptionStep.setBorder(null);
		 		 txtrTheEncryptionStep.setForeground(Color.WHITE);
		 		 txtrTheEncryptionStep.setBackground(Color.BLUE.darker());
		 		 txtrTheEncryptionStep.setLineWrap(true);
		 		 txtrTheEncryptionStep.setWrapStyleWord(true);
		 		 txtrTheEncryptionStep.setText("Suppose Alice wishes to send the message \"HELLO\" to Bob. Assume two pads of paper containing identical random sequences of letters were somehow previously produced and securely issued to both. Alice chooses the appropriate unused page from the pad. The way to do this is normally arranged for in advance, as for instance 'use the 12th sheet on 1 May', or 'use the next available sheet for the next message'.\r\n\r\nThe material on the selected sheet is the key for this message. Each letter from the pad will be combined in a predetermined way with one letter of the message. (It is common, but not required, to assign each letter a numerical value, e.g., \"A\" is 0, \"B\" is 1, and so on.)\r\n\r\nIn this example, the technique is to combine the key and the message using modular addition. The numerical values of corresponding message and key letters are added together, modulo 26. So, if key material begins with \"XMCKL\" and the message is \"HELLO\", then the coding would be done as follows:\r\n\r\n      H       E       L       L       O  message\r\n   7 (H)   4 (E)  11 (L)  11 (L)  14 (O) message\r\n+ 23 (X)  12 (M)   2 (C)  10 (K)  11 (L) key\r\n= 30      16      13      21      25     message + key\r\n=  4 (E)  16 (Q)  13 (N)  21 (V)  25 (Z) message + key (mod 26)\r\n      E       Q       N       V       Z  \u2192 ciphertext\r\n\r\nIf a number is larger than 26, then the remainder after subtraction of 26 is taken in modular arithmetic fashion. This simply means that if the computations \"go past\" Z, the sequence starts again at A.\r\n\r\nThe ciphertext to be sent to Bob is thus \"EQNVZ\". Bob uses the matching key page and the same process, but in reverse, to obtain the plaintext. Here the key is subtracted from the ciphertext, again using modular arithmetic:\r\n\r\n       E       Q       N       V       Z  ciphertext\r\n    4 (E)  16 (Q)  13 (N)  21 (V)  25 (Z) ciphertext\r\n-  23 (X)  12 (M)   2 (C)  10 (K)  11 (L) key\r\n= -19       4      11      11      14     ciphertext \u2013 key\r\n=   7 (H)   4 (E)  11 (L)  11 (L)  14 (O) ciphertext \u2013 key (mod 26)\r\n       H       E       L       L       O  \u2192 message\r\n\r\nSimilar to the above, if a number is negative then 26 is added to make the number zero or higher");
		 		 OTPpanel1.add(txtrTheEncryptionStep, gbc_txtrTheEncryptionStep);
		 		 
		 		 btnBack_1 = new JButton("BACK");
		 		 GridBagConstraints gbc_btnBack_1 = new GridBagConstraints();
		 		 gbc_btnBack_1.gridx = 3;
		 		 gbc_btnBack_1.gridy = 4;
		 		 OTPpanel1.add(btnBack_1, gbc_btnBack_1);
		 		 OTPpanel.add("ABOUT", js);
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.insets = new Insets(0, 0, 5, 0);
		gbc_btnClear.gridx = 5;
		gbc_btnClear.gridy = 5;
		OTPpanel2.add(btnClear, gbc_btnClear);
		
		btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridx = 5;
		gbc_btnBack.gridy = 6;
		OTPpanel2.add(btnBack, gbc_btnBack);
			
		OTPpanel.add("ENCRYPTION",OTPpanel2); 
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		
		OTPpanel3 = new JPanel();
		OTPpanel3.setForeground(Color.BLACK);
		OTPpanel3.setBackground(Color.BLUE.darker());
		OTPpanel3.setSize(556,416);
		OTPpanel.add("FILE I/O",OTPpanel3);
		GridBagLayout gbl_OTPpanel3 = new GridBagLayout();
		gbl_OTPpanel3.columnWidths = new int[]{97,60,60,182,102,60};
		gbl_OTPpanel3.rowHeights = new int[]{47, 60,40, 0,55,46, 0};
		gbl_OTPpanel3.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0};
		gbl_OTPpanel3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		OTPpanel3.setLayout(gbl_OTPpanel3);
		
		lblFileSource = new JLabel("FILE SOURCE:");
		lblFileSource.setForeground(Color.WHITE);
		lblFileSource.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFileSource = new GridBagConstraints();
		gbc_lblFileSource.anchor = GridBagConstraints.EAST;
		gbc_lblFileSource.fill = GridBagConstraints.VERTICAL;
		gbc_lblFileSource.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileSource.gridx = 0;
		gbc_lblFileSource.gridy = 0;
		OTPpanel3.add(lblFileSource, gbc_lblFileSource);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 0;
		OTPpanel3.add(textField_3, gbc_textField_3);
		
		btnBrowse = new JButton("BROWSE");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(new JFrame());
				if (result == JFileChooser.APPROVE_OPTION) {
			    File selectedFile = fileChooser.getSelectedFile();
			    textField_3.setText(selectedFile.getAbsolutePath());
			    EncFile = textField_3.getText();
			    BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(selectedFile.getAbsolutePath()));
				
			        sb = new StringBuilder();
			        String line = br.readLine();

			        while (line != null) {
			            sb.append(line);
			            sb.append("\n");
			            line = br.readLine();
			        }
			        textArea_1.setText(sb.toString());
			    } catch (IOException e1) {
					e1.printStackTrace();
				}
				} 
			}
		});
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 5);
		gbc_btnBrowse.gridx = 4;
		gbc_btnBrowse.gridy = 0;
		OTPpanel3.add(btnBrowse, gbc_btnBrowse);
		
		lblPlainText = new JLabel("Plain Text:");
		lblPlainText.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPlainText = new GridBagConstraints();
		gbc_lblPlainText.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlainText.gridx = 0;
		gbc_lblPlainText.gridy = 1;
		OTPpanel3.add(lblPlainText, gbc_lblPlainText);
		
		textArea_1 = new TextArea("", 4, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		textArea_1.setForeground(Color.BLACK);
		textArea_1.setEditable(false);
		textArea_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textArea_1.gridwidth = 3;
		gbc_textArea_1.gridheight = 2;
		gbc_textArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_1.gridx = 1;
		gbc_textArea_1.gridy = 1;
		OTPpanel3.add(textArea_1, gbc_textArea_1);
		
		btnEncryt = new JButton("ENCRYPT");
		btnEncryt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				String key="",ctx="";
				String msg = sb.toString().toUpperCase();
				msg = msg.replaceAll("\\s","");
				Random r = new Random();
				for(int i=0;i<msg.length();++i) {
					int rm = r.nextInt(26);
					key = key + (char)(64 + rm);
				}
				textField_4.setText(key);
				KEY = key;
				int t;
				for(int i=0;i<msg.length();i++) {
					t = msg.charAt(i) + key.charAt(i);
					if(t >= 155)
						t =t - 90;
					else
						t = t -64;
					char c = (char)t;
					ctx = ctx + c;
				}
				textArea_2.setText(ctx);
			}catch(Exception e2){
				JOptionPane.showMessageDialog(new JFrame(),"Please enter the message or key as required");
			}
		}
		});
		GridBagConstraints gbc_btnEncryt = new GridBagConstraints();
		gbc_btnEncryt.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnEncryt.insets = new Insets(0, 0, 5, 5);
		gbc_btnEncryt.gridx = 4;
		gbc_btnEncryt.gridy = 1;
		OTPpanel3.add(btnEncryt, gbc_btnEncryt);
		
		btnDecrypt = new JButton("DECRYPT");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
			int temp;
			char c;
			String Msg = "";
			int sum;
			String Key = textField_4.getText();
			String s = textArea_2.getText();
			for(int i=0;i<s.length();i++) {
				sum = s.charAt(i) - Key.charAt(i);
				if(sum>=0) {
					temp = sum + 64;
				}
				else {
					temp = sum + 90;
				}
				c = (char)temp;
				Msg = Msg + c ;
			}
			textArea_2.setText(Msg);	
			}catch(Exception e4){
				JOptionPane.showMessageDialog(new JFrame(),"Please enter the message or key as required");
			}
		}
		});
		GridBagConstraints gbc_btnDecrypt = new GridBagConstraints();
		gbc_btnDecrypt.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnDecrypt.insets = new Insets(0, 0, 5, 5);
		gbc_btnDecrypt.gridx = 4;
		gbc_btnDecrypt.gridy = 2;
		OTPpanel3.add(btnDecrypt, gbc_btnDecrypt);
		
		lblKey_1 = new JLabel("KEY:");
		lblKey_1.setForeground(Color.WHITE);
		lblKey_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblKey_1 = new GridBagConstraints();
		gbc_lblKey_1.fill = GridBagConstraints.BOTH;
		gbc_lblKey_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblKey_1.gridx = 0;
		gbc_lblKey_1.gridy = 3;
		OTPpanel3.add(lblKey_1, gbc_lblKey_1);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 3;
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 3;
		OTPpanel3.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		lblPlainText_1 = new JLabel("Cipher Text:");
		lblPlainText_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPlainText_1 = new GridBagConstraints();
		gbc_lblPlainText_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlainText_1.gridx = 0;
		gbc_lblPlainText_1.gridy = 4;
		OTPpanel3.add(lblPlainText_1, gbc_lblPlainText_1);
		
		textArea_2 = new TextArea("", 4, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		textArea_2.setEditable(false);
		textArea_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
		gbc_textArea_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textArea_2.gridwidth = 3;
		gbc_textArea_2.gridheight = 2;
		gbc_textArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_2.gridx = 1;
		gbc_textArea_2.gridy = 4;
		OTPpanel3.add(textArea_2, gbc_textArea_2);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				if(textArea_2.getText().equals(""))
					JOptionPane.showMessageDialog(new JFrame(),"Nothing to Show");
				else{
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to save");
				File fileToSave=null ;
				int userSelection = fileChooser.showSaveDialog(new JFrame());
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					fileToSave = fileChooser.getSelectedFile();
				}
				String s = textArea_2.getText();
				File file = new File(fileToSave.getAbsolutePath());
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(s);
				fileWriter.close();
				DecFile = fileToSave.getAbsolutePath();
				new DB().init(EncFile,DecFile,KEY,source);
			}
				}catch(IOException e1) {	}
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 4;
		gbc_btnSave.gridy = 4;
		OTPpanel3.add(btnSave, gbc_btnSave);
		
		btnBack_2 = new JButton("BACK");
		GridBagConstraints gbc_btnBack_2 = new GridBagConstraints();
		gbc_btnBack_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack_2.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnBack_2.gridx = 4;
		gbc_btnBack_2.gridy = 5;
		OTPpanel3.add(btnBack_2, gbc_btnBack_2);

		
	}
}
