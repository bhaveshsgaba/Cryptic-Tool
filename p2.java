import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
public class p2 extends Applet{
TextField t1 = new TextField();	
TextField t2 = new TextField();
TextField t3 = new TextField();
Label l1 = new Label("Num 1:");
Label l2 = new Label("Num 2:");
Label l3 = new Label("Num 3:");
Button b1 = new Button("Largest");
Button b2 = new Button("Smallest");
int a,b,c;
public void init(){
	add(l1);
	add(t1);
	add(l2);
	add(t2);
	add(l3);
	add(t3);
	add(b1);
	add(b2);
	a = Integer.parseInt(t1.getText());
	b = Integer.parseInt(t1.getText());
	c = Integer.parseInt(t1.getText());
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			int m = (a>b?(a>c?a:c):(b>c?b:c));
			JOptionPane.showMessageDialog(null,m);
		}
	});
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			int m = (a<b?(a<c?a:c):(b<c?b:c));
			JOptionPane.showMessageDialog(null,m);
		}
	});
}
}
