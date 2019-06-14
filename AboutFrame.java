import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AboutFrame
	{
		JFrame frame;
		public AboutFrame()
		{   frame = new JFrame("ABOUT US");
   frame.getContentPane().setBackground(Color.BLUE.darker().darker());
   frame.setBackground(Color.GRAY);
			frame.getContentPane().setLayout(null);
			frame.setLocation(300,225);
			
			JLabel lblL = new JLabel("");
			lblL.setIcon(new ImageIcon("img/About.jpg"));
			lblL.setBounds(0, 37, 547, 249);
			frame.getContentPane().add(lblL);
			
			JButton btnHelp = new JButton("HELP");
			btnHelp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new HTMLFrame("file:"+ System.getProperty("user.dir") +
							System.getProperty("file.separator") + "Help.html", false);
				}
			});
			btnHelp.setBounds(240, 312, 89, 23);
			frame.getContentPane().add(btnHelp);
			frame.setSize(555,416);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	} 