import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
public class Poly {

	public JTabbedPane poly;
	public JScrollPane js;
	public JPanel poly1;
	public JPanel poly2;
	public JPanel poly3; 
	public JButton btnBack;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public StringBuilder sb;
	public TextArea textArea_1;
	public TextArea textArea_2;
	public  int Len=0;
	public String keyword;
	public  String PlainText;
	 GridBagLayout gb = new GridBagLayout();
     GridBagConstraints gbc_lblCeasersCipher = new GridBagConstraints();
     public JTextArea txtrInCryptographyA = new JTextArea();
     public JTextArea txtrTheEncryptionStep = new JTextArea();
     public JLabel label = new JLabel();
     public JButton btnNewButton;
     public String EncFile;
 	public String DecFile;
 	public String KEY;
   public String source = "Poly Alphabetic";  
     
	    public String cyphir;
	    public String [][] charmatriex;
	    public String matrixv;
	    public char [][] CharMatrix=new char[26][26];
	    public  char characters[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','.',',','-'};   
		public String dcyphir;
	 char vignereTable[][]= new char[26][26];
	 public JButton btnBack_1;
	 private JButton btnClear_1;
	 
	 public void FillCharacMatrix(){
         	        for(int i=0; i<=25; i++){
	            for(int j=0; j<=25; j++){
	                CharMatrix[i][j]=characters[(j+i)%26];
	            }
	        }                     
	    }
	 public String getCipher(){
	        return cyphir;
	    }
	          
	    public String getDeCipher(){
	        return dcyphir;
	    }
	 public String Encrypt() {
	        int sub1=0,sub2=0,sub3=0;
	        int sub=0;
	        char char_num;
	        int start=0;
	        for(int i=0; i<PlainText.length(); i++) {
	            sub1=PlainText.substring(i,i+1).codePointAt(0);
	            sub2=keyword.substring(start,start+1).codePointAt(0);
	            start++;
	            sub3=sub1+sub2;
	            sub3=sub3%97;
	            sub=sub3%26;
     
	            if(cyphir==null)
	                cyphir=""+characters[sub];
	            else
	                cyphir+=characters[sub];
            
	            if(start==keyword.length()){
	                start=0;
	            } 
	        }
	        return cyphir;
	    }
	 public String Decrypt(){
	        int sub1=0,sub2=0,sub3=0;
	        int keyword_len;
	        int sub=0;
	        int cyphir_len;
	        char char_num;
	        int start=0;
	        for(int i=0; i<PlainText.length(); i++) {
	            sub1=cyphir.substring(i,i+1).codePointAt(0);
	            sub2=keyword.substring(start,start+1).codePointAt(0);
	     
	            start++;
	             
	            sub1=(sub1%97)%26;
	            sub2=(sub2%97)%26;
	             
	             
	            for(int k=0; k<26; k++) {
	                sub3=(Integer.parseInt(""+(short)CharMatrix[sub2][k])%97)%26;
	                 
	                if(sub1==sub3){
	                     
	                    if(dcyphir==null)
	                        dcyphir=Character.toString(CharMatrix[0][k]);
	                    else
	                        dcyphir+=Character.toString(CharMatrix[0][k]);
	                }
	            }  
	            if(start==keyword.length()){
	                start=0;
	            }      
	        }
	        return  dcyphir;
	         
	    }
	public Poly(){
		poly = new JTabbedPane();
		poly.setFont(new Font("Times New Roman", Font.BOLD, 15));
		poly.setSize(556, 416);
		poly2 = new JPanel();
		poly2.setBackground(Color.BLUE.darker());
			
		 poly1 = new JPanel();
		 poly1.setBackground(Color.BLUE.darker());
    	 poly1.setLayout(gb);
		 gb.columnWidths = new int[] {130,130,130,130};
		 gb.rowHeights = new int[] {60,60,60,60,60};
		 gbc_lblCeasersCipher.insets = new Insets(0, 0, 5, 0);
		 gbc_lblCeasersCipher.fill = GridBagConstraints.BOTH;
		 gbc_lblCeasersCipher.gridx=0;
		 gbc_lblCeasersCipher.gridy=0;
		 gbc_lblCeasersCipher.gridwidth = GridBagConstraints.REMAINDER;
		 JLabel lblCeasersCipher = new JLabel("POLY-ALPHABETIC CIPHER\r\n");
		 lblCeasersCipher.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		 lblCeasersCipher.setForeground(Color.WHITE);
		 lblCeasersCipher.setHorizontalAlignment(SwingConstants.CENTER);
		 poly1.add(lblCeasersCipher, gbc_lblCeasersCipher);	

		 js = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			js.getVerticalScrollBar().setUnitIncrement(16);
			js.getVerticalScrollBar().setValue(0);
		 js.setViewportView(poly1);
		 
		 GridBagConstraints gbc_txtrInCryptographyA = new GridBagConstraints();
		 gbc_txtrInCryptographyA.gridwidth = 4;
		 gbc_txtrInCryptographyA.insets = new Insets(0, 0, 5, 0);
		 gbc_txtrInCryptographyA.fill = GridBagConstraints.BOTH;
		 gbc_txtrInCryptographyA.gridx = 0;
		 gbc_txtrInCryptographyA.gridy = 1;
		 txtrInCryptographyA.setForeground(Color.WHITE);
		 txtrInCryptographyA.setBorder(null);
		 txtrInCryptographyA.setBackground(Color.BLUE.darker());
		 txtrInCryptographyA.setLineWrap(true);
		 txtrInCryptographyA.setWrapStyleWord(true);
		 txtrInCryptographyA.setText("A polyalphabetic cipher is any cipher based on substitution, using multiple substitution alphabets. The Vigen\u00E8re cipher is probably the best-known example of a polyalphabetic cipher, though it is a simplified special case. The Enigma machine is more complex but still fundamentally a polyalphabetic substitution cipher.");
		 poly1.add(txtrInCryptographyA, gbc_txtrInCryptographyA);
		 
		 GridBagConstraints gbc_label = new GridBagConstraints();
		 gbc_label.gridwidth = 4;
		 gbc_label.insets = new Insets(0, 0, 5, 0);
		 gbc_label.gridx = 0;
		 gbc_label.gridy = 2;
		 label.setIcon(new ImageIcon("img/poly.png"));
		 poly1.add(label, gbc_label);
		 
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
		 txtrTheEncryptionStep.setText("How this Cipher Works\r\n\r\n    Pick a keyword (for our example, the keyword will be \"MEC\").\r\n\r\n    Write your keyword across the top of the text you want to encipher, repeating it as many times as necessary.\r\n\r\n    For each letter, look at the letter of the keyword above it (if it was 'M', then you would go to the row that starts with an 'M'), and find that row in the Vigenere table.\r\n\r\n    Then find the column of your plaintext letter (for example, 'w', so the twenty-third column).\r\n\r\n    Finally, trace down that column until you reach the row you found before and write down the letter in the cell where they intersect (in this case, you find an 'I' there). \r\n\r\nExample:\r\nKeyword: \tM E C M E C M E C M E C M E C M E C M E C M\r\nPlaintext: \tw e n e e d m o r e s u p p l i e s f a s t\r\nCiphertext: \tI I P Q I F Y S T Q W W B T N U I U R E U F\r\n\r\nThus, the urgent message \"We need more supplies fast!\" comes out:\r\n\r\nI I P Q I F Y S T Q W W B T N U I U R E U F\r\n\r\nSo, as you can see, the letter 'e' is enciphered sometimes as an 'I' and sometimes as a 'Q'. Not only that, but 'I' represents two different letters, sometimes a 'w' and sometimes an 'e'. This renders our favorite tool, frequency analysis, nearly useless. Even though 'e' is used very often in the plaintext, the letters that replace it ('I' and 'Q') don't show up as frequently. Also, now if we check doubled letters in the ciphertext (say 'II' or 'WW'), these are not doubled letters in the plaintext.\r\n\r\nYou may, then, ask yourself \"is there any hope?\" Fortunately, there is! Given a long enough piece of ciphertext, certain words or parts of words (like \"the\") will line up with the keyword several times, giving rise to a repeated string of letters in the ciphertext (\"the\" may be enciphered as \"KPQ\" more than once). This can give us a clue as to the length of the keyword. After that, we can use frequency analysis on each piece that was enciphered with the same letter to crack the code. Consequently, cracking these ciphers hinges on finding repeated strings of letters in the ciphertext.\r\n\r\nHow to crack this cipher:\r\n\r\n    Search the ciphertext for repeated strings of letters; the longer strings you find the better (say you find the string \"KPQ\" four times). Note where they are by circling them or highlighting them in some manner.\r\n\r\n    For each occurrence of a repeated string, count how many letters are between the first letters in the string and add one (for example, if our ciphertext contains KPQRE IIJKO KPQAE, we count that there are nine letters between the first 'K' in the first \"KPQ\" and the first 'K' in the second \"KPQ\"; adding one yields ten).\r\n\r\n    Factor the number you got in the above computation (2 and 5 are factors of 10)\r\n\r\n    Repeat this process with each repeated string you find and make a table of common factors. The most common factor is probably the length of the keyword that was used to encipher the ciphertext (in our case, assume it was five). Call this number 'n'.\r\n\r\n    Do a frequency count on the ciphertext, on every nth letter. You should end up with n different frequency counts.\r\n\r\n    Compare these counts to standard frequency tables to figure out how much each letter was shifted by.\r\n\r\n    Undo the shifts and read off the message! ");
		 poly1.add(txtrTheEncryptionStep, gbc_txtrTheEncryptionStep);
		 
		 btnNewButton = new JButton("BACK");
		 GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		 gbc_btnNewButton.gridx = 3;
		 gbc_btnNewButton.gridy = 4;
		 poly1.add(btnNewButton, gbc_btnNewButton);
		 poly.add("ABOUT",js);
		
		poly.add("ENCRYPTION",poly2);
		poly2.setLayout(null);
		
		btnBack = new JButton("BACK");
		btnBack.setBounds(408, 290, 89, 29);
		poly2.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(121, 25, 261, 36);
		poly2.add(textField);
		textField.setColumns(10);
		
		JLabel lblMessage = new JLabel("MESSAGE:");
		lblMessage.setForeground(Color.WHITE);
		lblMessage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMessage.setBounds(22, 37, 89, 20);
		poly2.add(lblMessage);
		
		JLabel lblKey = new JLabel("KEY:*");
		lblKey.setForeground(Color.WHITE);
		lblKey.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKey.setBounds(65, 101, 46, 14);
		poly2.add(lblKey);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 89, 206, 36);
		poly2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCipherText = new JLabel("CIPHER TEXT:");
		lblCipherText.setForeground(Color.WHITE);
		lblCipherText.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCipherText.setBounds(10, 173, 101, 14);
		poly2.add(lblCipherText);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.WHITE);
		textField_2.setEditable(false);
		textField_2.setBounds(121, 157, 261, 36);
		poly2.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnEncrypt = new JButton("ENCRYPT");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					cyphir = "";
				dcyphir = "";
				PlainText= textField.getText(); 
		        PlainText = PlainText.replaceAll("\\s+","");
				keyword = textField_1.getText();
		        textField_2.setText(Encrypt());
		        FillCharacMatrix();
		    }catch(Exception a){
		    	JOptionPane.showMessageDialog(new JFrame(),"Please enter the message or key as required");
		    }
			}
		});
		btnEncrypt.setBounds(65, 234, 89, 23);
		poly2.add(btnEncrypt);
		
		JButton btnClear = new JButton("DECRYPT");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
			textField_2.setText(Decrypt());
			}catch(Exception e1){
				JOptionPane.showMessageDialog(new JFrame(),"Please enter the message or key as required");
			}
		}
		});
		btnClear.setBounds(293, 234, 89, 23);
		poly2.add(btnClear);
		
		btnClear_1 = new JButton("CLEAR");
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnClear_1.setBounds(407, 231, 90, 28);
		poly2.add(btnClear_1);
		
		poly3 = new JPanel();
		poly3.setBackground(Color.BLUE.darker());
		poly.add("FILE I/O", poly3);
		poly3.setLayout(null);
		
		JLabel lblFileSource = new JLabel("FILE SOURCE:");
		lblFileSource.setForeground(Color.WHITE);
		lblFileSource.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFileSource.setBounds(23, 19, 90, 16);
		poly3.add(lblFileSource);
		
		textField_3 = new JTextField();
		textField_3.setBounds(125, 13, 275, 28);
		poly3.add(textField_3);
		textField_3.setColumns(10);
		
		textArea_1 = new TextArea();
		textArea_1.setForeground(Color.BLACK);
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setEditable(false);
		textArea_1.setBounds(23, 58, 377, 93);
		poly3.add(textArea_1);
		
		JButton btnBrowse = new JButton("BROWSE");
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
		btnBrowse.setBounds(432, 13, 90, 28);
		poly3.add(btnBrowse);
		
		JButton btnEncrypt_1 = new JButton("ENCRYPT");
		btnEncrypt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					cyphir = "";
				dcyphir = "";
				PlainText =  sb.toString(); 
				PlainText = PlainText.replaceAll("\\s+","");
		        keyword = textField_4.getText();
		        KEY = keyword;
		        textArea_2.setText(Encrypt());	
		        FillCharacMatrix();
		    }catch(Exception d){
		    	JOptionPane.showMessageDialog(new JFrame(),"Please enter the message or key as required");
		    }
			}
		});
		btnEncrypt_1.setBounds(432, 58, 90, 28);
		poly3.add(btnEncrypt_1);
		
		JLabel lblKey_1 = new JLabel("KEY:*");
		lblKey_1.setForeground(Color.WHITE);
		lblKey_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKey_1.setBounds(36, 180, 55, 16);
		poly3.add(lblKey_1);
		
		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setBounds(103, 174, 204, 28);
		poly3.add(textField_4);
		textField_4.setColumns(10);
		
		textArea_2 = new TextArea();
		textArea_2.setForeground(Color.BLACK);
		textArea_2.setBackground(Color.WHITE);
		textArea_2.setEditable(false);
		textArea_2.setBounds(23, 214, 377, 99);
		poly3.add(textArea_2);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textArea_2.getText().equals(""))
					JOptionPane.showMessageDialog(new JFrame(),"Noting to Save");
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
			}catch(IOException e1) {
					
				}
		}
		});
		btnSave.setBounds(432, 214, 90, 28);
		poly3.add(btnSave);
		
		JButton btnDecrypt = new JButton("DECRYPT");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
			textArea_2.setText(Decrypt());
			}catch(Exception e2){
				JOptionPane.showMessageDialog(new JFrame(),"Please enter the message or key as required");
			}
		}
		});
		btnDecrypt.setBounds(432, 112, 90, 28);
		poly3.add(btnDecrypt);
		
		btnBack_1 = new JButton("BACK");
		btnBack_1.setBounds(432, 285, 90, 28);
		poly3.add(btnBack_1);
	}
}
