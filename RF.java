import java.awt.EventQueue;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.awt.*;
import java.awt.Point;
import java.applet.*;
import java.io.*;

public class RF{
	public JTabbedPane RfPanel;
	public JScrollPane js;
	public JPanel RfPanel1;
	public JPanel RfPanel2;
	public JPanel RfPanel3;
	public JTextField textField;
	public JTextField textField_1;
	public JButton btnBack;
	private JLabel lblFileSource;
	private JButton btnBrowse;
	public StringBuilder sb;
	private JButton btnSave;
	GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gbc_lblCeasersCipher = new GridBagConstraints();
    public JTextArea txtrInCryptographyA = new JTextArea();
    public JTextArea txtrTheEncryptionStep = new JTextArea();
    public JLabel label = new JLabel();
    public JButton btnNewButton_2;
    public JButton btnNewButton_4;
    private JLabel label_1 = new JLabel("");
    public JTextField textField_3;
    public TextArea textArea_1;
    public TextArea textArea_2;
    private JButton btnNewButton_5;
    public String EncFile;
	public String DecFile;
	public String KEY;
    public String source = "Rail Fence";
    private JLabel lblPlainText;
    private JLabel lblCipherText;
    
	public RF() {
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon("img/rf2.jpg"));
		RfPanel = new JTabbedPane();
		RfPanel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		RfPanel.setSize(556,416);
	
   	 	RfPanel1 = new JPanel();
		RfPanel1.setBackground(Color.BLUE.darker());
    	 RfPanel1.setLayout(gb);
		 gb.columnWidths = new int[] {130,130,130,130};
		 gb.rowHeights = new int[] {60,60,60,60,60};
		 gbc_lblCeasersCipher.insets = new Insets(0, 0, 5, 0);
		 gbc_lblCeasersCipher.fill = GridBagConstraints.BOTH;
		 gbc_lblCeasersCipher.gridx=0;
		 gbc_lblCeasersCipher.gridy=0;
		 gbc_lblCeasersCipher.gridwidth = GridBagConstraints.REMAINDER;
		 JLabel lblCeasersCipher = new JLabel("RAIL FENCE CIPHER");
		 lblCeasersCipher.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		 lblCeasersCipher.setForeground(Color.WHITE);
		 lblCeasersCipher.setHorizontalAlignment(SwingConstants.CENTER);
		 RfPanel1.add(lblCeasersCipher, gbc_lblCeasersCipher);	

		 js = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 js.getVerticalScrollBar().setUnitIncrement(18);
		 js.getVerticalScrollBar().setValue(0);
		
		 js.setViewportView(RfPanel1);
		 
		 GridBagConstraints gbc_txtrInCryptographyA = new GridBagConstraints();
		 gbc_txtrInCryptographyA.gridwidth = 4;
		 gbc_txtrInCryptographyA.insets = new Insets(0, 0, 5, 0);
		 gbc_txtrInCryptographyA.fill = GridBagConstraints.BOTH;
		 gbc_txtrInCryptographyA.gridx = 0;
		 gbc_txtrInCryptographyA.gridy = 1;
		 txtrInCryptographyA.setBorder(null);
		 txtrInCryptographyA.setForeground(Color.WHITE);
		 txtrInCryptographyA.setBackground(Color.BLUE.darker());
		 txtrInCryptographyA.setLineWrap(true);
		 txtrInCryptographyA.setWrapStyleWord(true);
		 txtrInCryptographyA.setText("The railfence cipher is a very simple, easy to crack cipher. It is a transposition cipher that follows a simple rule for mixing up the characters in the plaintext to form the ciphertext. The railfence cipher offers essentially no communication security, and it will be shown that it can be easily broken even by hand.\r\n\r\nAlthough weak on its own, it can be combined with other ciphers, such as a substitution cipher, the combination of which is more difficult to break than either cipher on it's own.");
		 RfPanel1.add(txtrInCryptographyA, gbc_txtrInCryptographyA);
		 
		 GridBagConstraints gbc_label = new GridBagConstraints();
		 gbc_label.gridwidth = 4;
		 gbc_label.insets = new Insets(0, 0, 5, 0);
		 gbc_label.gridx = 0;
		 gbc_label.gridy = 2;
		 label.setIcon(new ImageIcon("img/rf4.jpg"));
		 RfPanel1.add(label, gbc_label);
		 
		 GridBagConstraints gbc_txtrTheEncryptionStep = new GridBagConstraints();
		 gbc_txtrTheEncryptionStep.insets = new Insets(0, 0, 5, 0);
		 gbc_txtrTheEncryptionStep.gridwidth = 4;
		 gbc_txtrTheEncryptionStep.fill = GridBagConstraints.BOTH;
		 gbc_txtrTheEncryptionStep.gridx = 0;
		 gbc_txtrTheEncryptionStep.gridy = 3;
		 txtrTheEncryptionStep.setForeground(Color.WHITE);
		 txtrTheEncryptionStep.setBackground(Color.BLUE.darker());
		 txtrTheEncryptionStep.setBorder(null);
		 txtrTheEncryptionStep.setLineWrap(true);
		 txtrTheEncryptionStep.setWrapStyleWord(true);
		 txtrTheEncryptionStep.setText("In the rail fence cipher, the plaintext is written downwards and diagonally on successive \"rails\" of an imaginary fence, then moving up when we reach the bottom rail. When we reach the top rail, the message is written downwards again until the whole plaintext is written out. The message is then read off in rows. For example, if we have 3 \"rails\" and a message of 'WE ARE DISCOVERED. FLEE AT ONCE', the cipherer writes out:\r\n\r\nW . . . E . . . C . . . R . . . L . . . T . . . E\r\n. E . R . D . S . O . E . E . F . E . A . O . C .\r\n. . A . . . I . . . V . . . D . . . E . . . N . .\r\n\r\nThen reads off to get the ciphertext:\r\n\r\nWECRL TEERD SOEEF EAOCA IVDEN\r\n\r\nDECRYPTION:\r\n\r\nThe decryption process for the Rail Fence Cipher involves reconstructing the diagonal grid used to encrypt the message. We start writing the message, but leaving a dash in place of the spaces yet to be occupied. Gradually, you can replace all the dashes with the corresponding letters, and read off the plaintext from the table.\r\nWe start by making a grid with as many rows as the key is, and as many columns as the length of the ciphertext. We then place the first letter in the top left square, and dashes diagonally downwards where the letters will be. When we get back to the top row, we place the next letter in the ciphertext. Continue like this across the row, and start the next row when you reach the end.\r\nFor example, if you receive the ciphertext \"TEKOOHRACIRMNREATANFTETYTGHH\", encrypted with a key of 4, you start by placing the \"T\" in the first square. You then dash the diagonal down spaces until you get back to the top row, and place the \"E\" here. Continuing to fill the top row you get the pattern below.\r\n\r\nMany websites claim that the rail-fence cipher is a simpler \"write down the columns, read along the rows\" cipher. This is equivalent to using an un-keyed columnar transposition cipher.");
		 RfPanel1.add(txtrTheEncryptionStep, gbc_txtrTheEncryptionStep);
		 
		 btnNewButton_2 = new JButton("BACK");
		 GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		 gbc_btnNewButton_2.gridx = 3;
		 gbc_btnNewButton_2.gridy = 4;
		 RfPanel1.add(btnNewButton_2, gbc_btnNewButton_2);
		 RfPanel.add("ABOUT",js);
		 
		 
		RfPanel2 = new JPanel();
		RfPanel2.setBackground(Color.BLUE.darker());
		RfPanel.add("ENCRYPTION", RfPanel2);
		GridBagLayout gbl_RfPanel2 = new GridBagLayout();
		gbl_RfPanel2.columnWidths = new int[]{55, 62, 79, 180, 87, 0};
		gbl_RfPanel2.rowHeights = new int[]{51, 48, 65, 61, 39, 55, 58, 0};
		gbl_RfPanel2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_RfPanel2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		RfPanel2.setLayout(gbl_RfPanel2);
		JLabel lblNewLabel = new JLabel("Phrase:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		RfPanel2.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("Encrypt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String phrase = textField.getText();
				int l = phrase.length();
				char[] c = new char[l];
				int j=0;		
				for(int i=0;i<l;i++) {
					if(i%2==0)
						c[j++] = phrase.charAt(i);
				}
				for(int i=0;i<l;i++) {
					if(i%2==1)
						c[j++] = phrase.charAt(i);
				}
				String c1 = new String(c);
					textField_1.setText(c1);
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(new JFrame(), "Please Enter the Message and Key a required");
			}
			}
			});
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridwidth = 3;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		RfPanel2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Message:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		RfPanel2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setAlignmentY(Component.TOP_ALIGNMENT);
		textField_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField_1.setText("");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		RfPanel2.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		RfPanel2.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Decrypt");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String phrase = textField_1.getText();
				int l = phrase.length();
				char[] d = new char[l];
				int j=0,k;
				if(l%2==0)
				 	k = l/2;
				else
					k = (l/2)+1;
				for(int i=0;i<k;i++) {
					d[j] = phrase.charAt(i);
					j+=2;
				}
				j=1;
				for(int i=k;i<l;i++) {
					d[j] = phrase.charAt(i);
					j+=2;
				}
				String d1 = new String(d);
				textField_1.setText(d1);
			}catch(Exception e2) {
				JOptionPane.showMessageDialog(new JFrame(),"Please Enter the message or key as required");
			}
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 4;
		RfPanel2.add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton_5 = new JButton("CLEAR");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 4;
		gbc_btnNewButton_5.gridy = 4;
		RfPanel2.add(btnNewButton_5, gbc_btnNewButton_5);
		
		btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridx = 4;
		gbc_btnBack.gridy = 6;
		RfPanel2.add(btnBack, gbc_btnBack);
	
		RfPanel3 = new JPanel();
		RfPanel3.setBackground(Color.BLUE.darker());
		RfPanel.add("FILE I/O", RfPanel3);
		GridBagLayout gbl_RfPanel3 = new GridBagLayout();
		gbl_RfPanel3.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0};
		gbl_RfPanel3.columnWidths = new int[]{101,103,249,74,60,103};
		gbl_RfPanel3.rowHeights = new int[]{0, 48,35, 31,48,60};
		RfPanel3.setLayout(gbl_RfPanel3);
		
		lblFileSource = new JLabel("FILE SOURCE:");
		lblFileSource.setForeground(Color.WHITE);
		lblFileSource.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFileSource = new GridBagConstraints();
		gbc_lblFileSource.anchor = GridBagConstraints.EAST;
		gbc_lblFileSource.insets = new Insets(0, 0, 5, 5);
		gbc_lblFileSource.gridx = 0;
		gbc_lblFileSource.gridy = 0;
		RfPanel3.add(lblFileSource, gbc_lblFileSource);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 0;
		RfPanel3.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
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
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 0);
		gbc_btnBrowse.gridx = 5;
		gbc_btnBrowse.gridy = 0;
		RfPanel3.add(btnBrowse, gbc_btnBrowse);
		
		lblPlainText = new JLabel("Plain Text:");
		lblPlainText.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPlainText = new GridBagConstraints();
		gbc_lblPlainText.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlainText.gridx = 0;
		gbc_lblPlainText.gridy = 2;
		RfPanel3.add(lblPlainText, gbc_lblPlainText);
		
		textArea_1 = new TextArea("", 4, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		textArea_1.setEditable(false);
		textArea_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.gridheight = 2;
		gbc_textArea_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textArea_1.gridwidth = 3;
		gbc_textArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_1.gridx = 2;
		gbc_textArea_1.gridy = 2;
		RfPanel3.add(textArea_1, gbc_textArea_1);
		
		JButton btnNewButton_3 = new JButton("ENCRYPT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String phrase = sb.toString();
				int l = phrase.length();
				char[] c = new char[l];
				int j=0;		
				for(int i=0;i<l;i++) {
					if(i%2==0)
						c[j++] = phrase.charAt(i);
				}
				for(int i=0;i<l;i++) {
					if(i%2==1)
						c[j++] = phrase.charAt(i);
				}
				String c1 = new String(c);
					textArea_2.setText(c1);
			}catch(Exception e3) {
				JOptionPane.showMessageDialog(new JFrame(),"Please Enter the Message or Key as required");
			}
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 2;
		RfPanel3.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnCecrypt = new JButton("DECRYPT");
		btnCecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{String phrase = textArea_2.getText();
				int l = phrase.length();
				char[] d = new char[l];
				int j=0,k;
				if(l%2==0)
				 	k = l/2;
				else
					k = (l/2)+1;
				for(int i=0;i<k;i++) {
					d[j] = phrase.charAt(i);
					j+=2;
				}
				j=1;
				for(int i=k;i<l;i++) {
					d[j] = phrase.charAt(i);
					j+=2;
				}
				String d1 = new String(d);
				textArea_2.setText(d1);
			}catch(Exception e5) {
				JOptionPane.showMessageDialog(new JFrame(),"Please Enter the Message or Key as required");
			}
			}
		});
		GridBagConstraints gbc_btnCecrypt = new GridBagConstraints();
		gbc_btnCecrypt.insets = new Insets(0, 0, 5, 0);
		gbc_btnCecrypt.gridx = 5;
		gbc_btnCecrypt.gridy = 3;
		RfPanel3.add(btnCecrypt, gbc_btnCecrypt);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(textArea_1.getText().equals(""))
					JOptionPane.showMessageDialog(new JFrame(),"Nothing to Save");
				else {	
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to save");
				File fileToSave=null ;
				int userSelection = fileChooser.showSaveDialog(new JFrame());
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					fileToSave = fileChooser.getSelectedFile();
				}
				String s = textArea_1.getText();
				File file = new File(fileToSave.getAbsolutePath());
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(s);
				fileWriter.close();
				DecFile = fileToSave.getAbsolutePath();
				new DB().init(EncFile,DecFile,KEY,source);
			}
				}catch(Exception e4) {
					
				}
			}
		});
		
		lblCipherText = new JLabel("Cipher Text:");
		lblCipherText.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCipherText.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblCipherText = new GridBagConstraints();
		gbc_lblCipherText.anchor = GridBagConstraints.SOUTH;
		gbc_lblCipherText.insets = new Insets(0, 0, 5, 5);
		gbc_lblCipherText.gridx = 0;
		gbc_lblCipherText.gridy = 4;
		RfPanel3.add(lblCipherText, gbc_lblCipherText);
		
		textArea_2 = new TextArea("", 4, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		textArea_2.setEditable(false);
		textArea_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
		gbc_textArea_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textArea_2.gridheight = 2;
		gbc_textArea_2.gridwidth = 3;
		gbc_textArea_2.insets = new Insets(0, 0, 0, 5);
		gbc_textArea_2.gridx = 2;
		gbc_textArea_2.gridy = 4;
		RfPanel3.add(textArea_2, gbc_textArea_2);
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.anchor = GridBagConstraints.SOUTH;
		gbc_btnSave.insets = new Insets(0, 0, 5, 0);
		gbc_btnSave.gridx = 5;
		gbc_btnSave.gridy = 4;
		RfPanel3.add(btnSave, gbc_btnSave);
		
		btnNewButton_4 = new JButton("BACK");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.SOUTH;
		gbc_btnNewButton_4.gridx = 5;
		gbc_btnNewButton_4.gridy = 5;
		RfPanel3.add(btnNewButton_4, gbc_btnNewButton_4);
	}
}
