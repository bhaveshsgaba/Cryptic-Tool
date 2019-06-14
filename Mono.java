import java.awt.EventQueue;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Color;
import java.io.*;

public class Mono {
	public JTabbedPane mono;
	public JScrollPane js;
	public JPanel mono1;
	public JPanel mono2;
	public JPanel mono3;
	public JButton btnBack_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public StringBuilder sb;
	public static char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',

        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',

        'w', 'x', 'y', 'z','1','2','3','4','5','6','7','8','9','0',',','.','@','$' };

	public static char ch[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',

        'P', 'A', 'S', 'D','1','2','3','4','5', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',

        'V', 'B', 'N', 'M','6','7','8','9','0',',','.','@','$' };
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblFileSource;
	private JTextField textField_3;
	private JButton btnBrose;
	private JButton btnEncrypt_1;
	private JButton btnDecrypt;
	private TextArea textArea_1;
	private TextArea textArea_2;
	private JButton btnSave;
	GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gbc_lblCeasersCipher = new GridBagConstraints();
    public JTextArea txtrInCryptographyA = new JTextArea();
    public JTextArea txtrTheEncryptionStep = new JTextArea();
    public JLabel label = new JLabel();
    public JButton btnBack;
    public JButton btnBack_2;
    private JButton btnClear;
    public String EncFile;
	public String DecFile;
	public String KEY;
    public String source = "Mono Alphabetic";
    
	public Mono(){
		mono = new JTabbedPane();
		mono.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		mono1 = new JPanel(); 
		mono1.setBackground(Color.BLUE.darker());
      	 mono1.setLayout(gb);
      	mono1.setSize(556,416);
		 gb.columnWidths = new int[] {130,130,130,130};
		 gb.rowHeights = new int[] {60,60,60,60,60};
		 gbc_lblCeasersCipher.insets = new Insets(0, 0, 5, 0);
		 gbc_lblCeasersCipher.fill = GridBagConstraints.BOTH;
		 gbc_lblCeasersCipher.gridx=0;
		 gbc_lblCeasersCipher.gridy=0;
		 gbc_lblCeasersCipher.gridwidth = GridBagConstraints.REMAINDER;
		 JLabel lblCeasersCipher = new JLabel("MONOALPHABETIC CIPHER");
		 lblCeasersCipher.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		 lblCeasersCipher.setForeground(Color.WHITE);
		 lblCeasersCipher.setHorizontalAlignment(SwingConstants.CENTER);
		 mono1.add(lblCeasersCipher, gbc_lblCeasersCipher);	
		 js = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			js.getVerticalScrollBar().setUnitIncrement(16);
			js.getVerticalScrollBar().setValue(0);
		 js.setViewportView(mono1);
		 
		 GridBagConstraints gbc_txtrInCryptographyA = new GridBagConstraints();
		 gbc_txtrInCryptographyA.gridwidth = 4;
		 gbc_txtrInCryptographyA.insets = new Insets(0, 0, 5, 0);
		 gbc_txtrInCryptographyA.fill = GridBagConstraints.BOTH;
		 gbc_txtrInCryptographyA.gridx = 0;
		 gbc_txtrInCryptographyA.gridy = 1;
		 txtrInCryptographyA.setForeground(Color.WHITE);
		 txtrInCryptographyA.setBackground(Color.BLUE.darker());
		 txtrInCryptographyA.setLineWrap(true);
		 txtrInCryptographyA.setWrapStyleWord(true);
		 txtrInCryptographyA.setText("Substitution ciphers are probably the most common form of cipher. They work by replacing each letter of the plaintext (and sometimes puntuation marks and spaces) with another letter (or possibly even a random symbol).\r\n\r\nA monoalphabetic substitution cipher, also known as a simple substitution cipher, relies on a fixed replacement structure. That is, the substitution is fixed for each letter of the alphabet. Thus, if \"a\" is encrypted to \"R\", then every time we see the letter \"a\" in the plaintext, we replace it with the letter \"R\" in the ciphertext.\r\nA simple example is where each letter is encrypted as the next letter in the alphabet: \"a simple message\" becomes \"B TJNQMF NFTTBHF\". In general, when performing a simple substitution manually, it is easiest to generate the ciphertext alphabet first, and encrypt by comparing this to the plaintext alphabet. The table below shows how one might choose to, and we will, lay them out for this example.");
		 mono1.add(txtrInCryptographyA, gbc_txtrInCryptographyA);
		 
		 GridBagConstraints gbc_label = new GridBagConstraints();
		 gbc_label.gridwidth = 4;
		 gbc_label.insets = new Insets(0, 0, 5, 0);
		 gbc_label.gridx = 0;
		 gbc_label.gridy = 2;
		 label.setIcon(new ImageIcon("img/mono.jpg"));
		 mono1.add(label, gbc_label);
		 
		 GridBagConstraints gbc_txtrTheEncryptionStep = new GridBagConstraints();
		 gbc_txtrTheEncryptionStep.insets = new Insets(0, 0, 5, 0);
		 gbc_txtrTheEncryptionStep.gridwidth = 4;
		 gbc_txtrTheEncryptionStep.fill = GridBagConstraints.BOTH;
		 gbc_txtrTheEncryptionStep.gridx = 0;
		 gbc_txtrTheEncryptionStep.gridy = 3;
		 txtrTheEncryptionStep.setForeground(Color.WHITE);
		 txtrTheEncryptionStep.setBorder(null);
		 txtrTheEncryptionStep.setBackground(Color.BLUE.darker());
		 txtrTheEncryptionStep.setLineWrap(true);
		 txtrTheEncryptionStep.setWrapStyleWord(true);
		 txtrTheEncryptionStep.setText("There are many different monoalphabetic substitution ciphers, in fact infinitely many, as each letter can be encrypted to any symbol, not just another letter.\r\nThe history of simple substitution ciphers can be traced back to the very earliest civisilisations, and for a long time they were more than adequate for the purposes for which they were needed. By today's standards they are very weak, and incredibly easy to break, but they were a very important step in developing cryptography.");
		 mono1.add(txtrTheEncryptionStep, gbc_txtrTheEncryptionStep);
		 
		 btnBack = new JButton("BACK");
		 GridBagConstraints gbc_btnBack = new GridBagConstraints();
		 gbc_btnBack.gridx = 3;
		 gbc_btnBack.gridy = 4;
		 mono1.add(btnBack, gbc_btnBack);
		 mono.add("ABOUT",js);
		
		mono2 = new JPanel();
		mono2.setBackground(Color.BLUE.darker());
		mono.addTab("ENCRYPTION", mono2);
		GridBagLayout gbl_mono2 = new GridBagLayout();
		gbl_mono2.columnWidths = new int[]{61, 92, 82, 89, 123, 89, 0};
		gbl_mono2.rowHeights = new int[]{45, 35, 14, 14, 37, 14, 14, 36, 29, 37, 29, 0};
		gbl_mono2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_mono2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mono2.setLayout(gbl_mono2);
		
		JLabel lblMessage = new JLabel("MESSAGE:");
		lblMessage.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.anchor = GridBagConstraints.EAST;
		gbc_lblMessage.insets = new Insets(0, 0, 5, 5);
		gbc_lblMessage.gridx = 1;
		gbc_lblMessage.gridy = 0;
		mono2.add(lblMessage, gbc_lblMessage);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridwidth = 4;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		mono2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblEncrypted = new JLabel("ENCRYPTED");
		lblEncrypted.setForeground(Color.WHITE);
		lblEncrypted.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblEncrypted = new GridBagConstraints();
		gbc_lblEncrypted.anchor = GridBagConstraints.WEST;
		gbc_lblEncrypted.fill = GridBagConstraints.VERTICAL;
		gbc_lblEncrypted.insets = new Insets(0, 0, 5, 5);
		gbc_lblEncrypted.gridx = 1;
		gbc_lblEncrypted.gridy = 2;
		mono2.add(lblEncrypted, gbc_lblEncrypted);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridheight = 2;
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		mono2.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel = new JLabel("MESSAGE:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		mono2.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblDecryptedMessage = new JLabel("DECRYPTED");
		lblDecryptedMessage.setForeground(Color.WHITE);
		lblDecryptedMessage.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDecryptedMessage = new GridBagConstraints();
		gbc_lblDecryptedMessage.anchor = GridBagConstraints.WEST;
		gbc_lblDecryptedMessage.fill = GridBagConstraints.VERTICAL;
		gbc_lblDecryptedMessage.insets = new Insets(0, 0, 5, 5);
		gbc_lblDecryptedMessage.gridx = 1;
		gbc_lblDecryptedMessage.gridy = 5;
		mono2.add(lblDecryptedMessage, gbc_lblDecryptedMessage);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridheight = 2;
		gbc_textField_2.gridwidth = 4;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 5;
		mono2.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnEncrypt = new JButton("ENCRYPT");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String s = textField.getText().toLowerCase().replaceAll("\\s","");;
				char c[] = new char[(s.length())];
		        for (int i = 0; i < s.length(); i++)
		        {
		            for (int j = 0; j < 40; j++)
		            {
		                if (p[j] == s.charAt(i))
		                {
		                    c[i] = ch[j];
		                    break;
		                }
		            }
		        }
		        textField_1.setText(new String(c));
			}catch(Exception d){
				JOptionPane.showMessageDialog(new JFrame(),"Please enter the message or key as required");
			}
		}
		});
		
		lblNewLabel_1 = new JLabel("MESSAGE:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		mono2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		GridBagConstraints gbc_btnEncrypt = new GridBagConstraints();
		gbc_btnEncrypt.fill = GridBagConstraints.VERTICAL;
		gbc_btnEncrypt.insets = new Insets(0, 0, 5, 5);
		gbc_btnEncrypt.gridwidth = 2;
		gbc_btnEncrypt.gridx = 1;
		gbc_btnEncrypt.gridy = 8;
		mono2.add(btnEncrypt, gbc_btnEncrypt);
		
		JButton btnNewButton = new JButton("DECRYPT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				String s = textField_1.getText(); 
				char p1[] = new char[(s.length())];
			        for (int i = 0; i < s.length(); i++)
			        {
			            for (int j = 0; j < 40; j++)
			            {
			                if (ch[j] == s.charAt(i))
			                {
			                    p1[i] = p[j];
			                    break;
			                }
			            }
			        }
			        textField_2.setText(new String(p1));
			}catch(Exception p){
				JOptionPane.showMessageDialog(new JFrame(),"Please enter the message or key as required");
			}
		}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 8;
		mono2.add(btnNewButton, gbc_btnNewButton);
		
		btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.anchor = GridBagConstraints.NORTH;
		gbc_btnClear.insets = new Insets(0, 0, 5, 0);
		gbc_btnClear.gridx = 5;
		gbc_btnClear.gridy = 8;
		mono2.add(btnClear, gbc_btnClear);
		
		btnBack_1 = new JButton("BACK");
		GridBagConstraints gbc_btnBack_1 = new GridBagConstraints();
		gbc_btnBack_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnBack_1.gridx = 5;
		gbc_btnBack_1.gridy = 10;
		mono2.add(btnBack_1, gbc_btnBack_1);
		
		mono3 = new JPanel();
		mono3.setBackground(Color.BLUE.darker());
		mono.add("FILE I/O",mono3);
		mono3.setLayout(null);
		
		lblFileSource = new JLabel("FILE SOURCE:");
		lblFileSource.setForeground(Color.WHITE);
		lblFileSource.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFileSource.setBounds(29, 19, 93, 16);
		mono3.add(lblFileSource);
		
		textField_3 = new JTextField();
		textField_3.setBounds(134, 13, 262, 28);
		mono3.add(textField_3);
		textField_3.setColumns(10);
		
		btnBrose = new JButton("BROWSE");
		btnBrose.addActionListener(new ActionListener() {
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
					JOptionPane.showMessageDialog(new JFrame(),	"FILE ERROR");
				}
				}
			}
		});
		btnBrose.setBounds(435, 13, 90, 28);
		mono3.add(btnBrose);
		
		textArea_1 = new TextArea("",4,30,TextArea.SCROLLBARS_VERTICAL_ONLY);
		textArea_1.setBounds(29, 62, 367, 93);
		mono3.add(textArea_1);
		
		textArea_2 = new TextArea("",4,30,TextArea.SCROLLBARS_VERTICAL_ONLY);
		textArea_2.setBounds(29, 211, 367, 98);
		mono3.add(textArea_2);
		
		btnEncrypt_1 = new JButton("ENCRYPT");
		btnEncrypt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String s = sb.toString().replaceAll("\\s","");;
				char c[] = new char[(s.length())];
		        for (int i = 0; i < s.length(); i++)
		        {
		            for (int j = 0; j < 40; j++)
		            {
		                if (p[j] == s.charAt(i))
		                {
		                    c[i] = ch[j];
		                    break;
		                }
		            }
		        }
		        textArea_2.setText(new String(c));
			}catch(Exception b){
				JOptionPane.showMessageDialog(new JFrame(),"Please enter the message or key as required");
			}
		}
		});
		btnEncrypt_1.setBounds(435, 62, 90, 28);
		mono3.add(btnEncrypt_1);
		
		btnDecrypt = new JButton("DECRYPT");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				 String s;
				 s = textArea_2.getText(); 
				char p1[] = new char[(s.length())];
			        for (int i = 0; i < s.length(); i++)
			        {
			            for (int j = 0; j < 40; j++)
			            {
			                if (ch[j] == s.charAt(i))
			                {
			                    p1[i] = p[j];
			                    break;
			                }
			            }
			        }
			        textArea_2.setText(new String(p1));
			}catch(Exception g){
				JOptionPane.showMessageDialog(new JFrame(),"Please enter the message or key as required");
			}		
		}
		});
		btnDecrypt.setBounds(435, 127, 90, 28);
		mono3.add(btnDecrypt);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				if(textArea_2.getText().equals(""))
					JOptionPane.showMessageDialog(new JFrame(),"Nothing to Save");
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
			}catch(Exception e1) {
					
				}
			}
		});
		btnSave.setBounds(435, 215, 90, 28);
		mono3.add(btnSave);
		
		btnBack_2 = new JButton("BACK");
		btnBack_2.setBounds(435, 279, 90, 28);
		mono3.add(btnBack_2);
	}
}
