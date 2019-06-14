import java.awt.*;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.border.LineBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Home {

	public JFrame frame;
	public JPanel startPanel;
	public JPanel mainPanel;
	public JPanel HomePanel;
	public CardLayout card = new CardLayout();	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home()throws IOException{
									//****HOME STARTS****//
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.BLACK);
		frame = new JFrame();
		frame.setBackground(Color.BLUE);
		frame.setTitle("CRYPTIC TOOLS");
		frame.setResizable(false);
		frame.setLocation(300,225);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			JOptionPane.showMessageDialog(null,"THANK YOU! :)");
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(card);
		frame.setSize(636, 441);
		frame.setVisible(true);
		frame.getContentPane().add(mainPanel);
		
		startPanel = new JPanel();
		startPanel.setBackground(Color.BLUE.darker().darker());
		mainPanel.add("Start",startPanel);
		GridBagLayout gbl_startPanel = new GridBagLayout();
		gbl_startPanel.columnWidths = new int[]{447, 128, 34};
		gbl_startPanel.rowHeights = new int[]{114, 49, 47, 53, 46, 55,0};
		gbl_startPanel.columnWeights = new double[]{1.0, 0.0};
		gbl_startPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		startPanel.setLayout(gbl_startPanel);
		
		JLabel lblNewLabel_1 = new JLabel("CRYPTIC TOOLS");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		startPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(System.getProperty("user.dir") +  System.getProperty("file.separator") + "img/crypt.jpeg"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		startPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnStart = new JButton("START");
		btnStart.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel,"Home");
			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.fill = GridBagConstraints.BOTH;
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 1;
		gbc_btnStart.gridy = 1;
		startPanel.add(btnStart, gbc_btnStart);
		
		JButton btnHelp = new JButton("HELP");
		btnHelp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HTMLFrame("file:"+ System.getProperty("user.dir") +
						System.getProperty("file.separator") + "Help.html", false);
			}
		});
		GridBagConstraints gbc_btnHelp = new GridBagConstraints();
		gbc_btnHelp.fill = GridBagConstraints.BOTH;
		gbc_btnHelp.insets = new Insets(0, 0, 5, 5);
		gbc_btnHelp.gridx = 1;
		gbc_btnHelp.gridy = 3;
		startPanel.add(btnHelp, gbc_btnHelp);
		
		JButton btnAboutUs = new JButton("ABOUT US");
		btnAboutUs.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 new AboutFrame();
			}
		});
		GridBagConstraints gbc_btnAboutUs = new GridBagConstraints();
		gbc_btnAboutUs.insets = new Insets(0, 0, 5, 5);
		gbc_btnAboutUs.fill = GridBagConstraints.BOTH;
		gbc_btnAboutUs.gridx = 1;
		gbc_btnAboutUs.gridy = 5;
		startPanel.add(btnAboutUs, gbc_btnAboutUs);
		
		HomePanel = new JPanel();
		HomePanel.setBackground(Color.BLUE.darker().darker());
		mainPanel.add("Home",HomePanel);
		GridBagLayout gbl_HomePanel = new GridBagLayout();
		gbl_HomePanel.columnWidths = new int[]{41, 158, 182, 42, 166,20};
		gbl_HomePanel.rowHeights = new int[]{52, 26, 31, 53, 35, 49, 45,44};
		gbl_HomePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_HomePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		HomePanel.setLayout(gbl_HomePanel);
		
		JButton btnWhatIsCryptography = new JButton("WHAT IS CRYPTOGRAPHY?");
		btnWhatIsCryptography.setForeground(Color.BLUE.darker());
		btnWhatIsCryptography.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new HTMLFrame("file:"+ System.getProperty("user.dir") +
						System.getProperty("file.separator") + "History.htm", false);
			}
		});
		GridBagConstraints gbc_btnWhatIsCryptography = new GridBagConstraints();
		gbc_btnWhatIsCryptography.gridwidth = 2;
		gbc_btnWhatIsCryptography.fill = GridBagConstraints.BOTH;
		gbc_btnWhatIsCryptography.insets = new Insets(0, 0, 5, 5);
		gbc_btnWhatIsCryptography.gridx = 2;
		gbc_btnWhatIsCryptography.gridy = 0;
		HomePanel.add(btnWhatIsCryptography, gbc_btnWhatIsCryptography);
		
		
		JButton btnNewButton = new JButton("CEASER'S CIPHER");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		HomePanel.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL - CEASER'S CIPHER");
				card.show(mainPanel,"Ceaser");
			}
		});
		
		JButton btnNewButton_4 = new JButton("MONO-ALPHABETIC");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_4.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 2;
		gbc_btnNewButton_4.gridy = 3;
		HomePanel.add(btnNewButton_4, gbc_btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL - MONO-ALPHABETIC CIPHER");
				card.show(mainPanel, "Mono");
			}
		});
		
		JButton btnNewButton_1 = new JButton("RAIL FENCE CIPHER");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 3;
		HomePanel.add(btnNewButton_1, gbc_btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL - RAIL FENCE CIPHER");
				card.show(mainPanel,"Rf");
			}
		});
		
		JButton btnNewButton_2 = new JButton("VIGENERE CIPHER");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 5;
		HomePanel.add(btnNewButton_2, gbc_btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL - VIGENERE CIPHER");
				card.show(mainPanel,"Atbash");
			}
		});
		
		JButton btnNewButton_5 = new JButton("POLY-ALPHABETIC");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_5.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 2;
		gbc_btnNewButton_5.gridy = 5;
		HomePanel.add(btnNewButton_5, gbc_btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL - POLY-ALPHABETIC CIPHER");
				card.show(mainPanel,"Poly");
			}
		});
		
		JButton btnNewButton_3 = new JButton("  ONE TIME PAD    ");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_3.gridx = 4;
		gbc_btnNewButton_3.gridy = 5;
		HomePanel.add(btnNewButton_3, gbc_btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL - ONE TIME PAD");
				card.show(mainPanel,"OTP");
			}
		});
		
		JButton btnHistory = new JButton("HISTORY");
		btnHistory.setForeground(Color.BLUE.darker());
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DBFrame();
			}
		});
		
		JButton btnBack = new JButton("  BACK  ");
		btnBack.setForeground(Color.BLUE.darker());
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(mainPanel,"Start");
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 7;
		HomePanel.add(btnBack, gbc_btnBack);
		GridBagConstraints gbc_btnHistory = new GridBagConstraints();
		gbc_btnHistory.fill = GridBagConstraints.BOTH;
		gbc_btnHistory.insets = new Insets(0, 0, 0, 5);
		gbc_btnHistory.gridx = 4;
		gbc_btnHistory.gridy = 7;
		HomePanel.add(btnHistory, gbc_btnHistory);
		
												//****HOME ENDS****//
		
		
												//****CEASER START****//
		Shift s = new Shift();
		mainPanel.add("Ceaser",s.CeaserPanel);		
		
		s.btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel,"Home");
			}
		});
		
		s.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel,"Home");
			}
		});
		s.btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel, "Home");
			}
		});
		
											//****CEASER ENDS****//
		
											//****OTP STARTS****//
		OneTimePad otp = new OneTimePad();
		mainPanel.add("OTP",otp.OTPpanel);
		otp.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel, "Home");
			}
		});
		otp.btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel, "Home");
			}
		});
		otp.btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel, "Home");
			}
		});
											//****OTP ENDS*****//
	
											//****RF STARTS****//
		RF r = new RF();
		mainPanel.add("Rf",r.RfPanel);
		r.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel,"Home");
			}
		});
		r.btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel,"Home");
			}
		});
		r.btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel,"Home");
			}
		});	
											//****RF ENDS****//
		
											//****ATBASH STARTS****//
		
		Vigenere a = new Vigenere();
		mainPanel.add("Atbash",a.Atbash);
		a.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel,"Home");
			}
		});
		a.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel, "Home");
			}
		});
		a.btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel, "Home");}
		});
											//****ATBASH ENDS****//
		
											//****POLY STARTS****//
		
		Poly p = new Poly();
		mainPanel.add("Poly",p.poly);
		p.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				
				card.show(mainPanel,"Home");
			}
		});
		p.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel,"Home");
			}
		});
		p.btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				card.show(mainPanel,"Home");}
		});
		
											//****POLY ENDS****//
		
										   //****MONO STARTS****//
		Mono m = new Mono();
		mainPanel.add("Mono",m.mono);
		m.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
							card.show(mainPanel,"Home");
			}
		});
		m.btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				
				card.show(mainPanel,"Home");
			}
		});
		m.btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("CRYPTIC TOOL");
				
				card.show(mainPanel,"Home");
				}
		});
										  
		
										   //****MONO ENDS****//
		
		
		
		
	}
}
