import java.awt.*;
import javax.swing.*;
public class buttin {
	JPanel jp;
	buttin(){
		jp = new JPanel();
		jp.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Documents and Settings\\Deepak\\My Documents\\Downloads\\mycode\\code\\Images\\Help.gif"));
		btnNewButton.setBounds(52, 55, 88, 33);
		jp.add(btnNewButton);
	}
}
