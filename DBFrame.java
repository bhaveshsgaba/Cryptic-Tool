import java.awt.*;

import javax.swing.table.TableColumn;

import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

 

public class DBFrame{ 
JFrame frame1;
JPanel main = new JPanel();
JPanel upper= new JPanel();
JPanel lower= new JPanel();
    JButton b1;

    Connection con;

    ResultSet rs, rs1;

    Statement st, st1;

    PreparedStatement pst;

    String ids;

    static JTable table;

    String[] columnNames = {"Type","Original File", "New File", "KEY(if any)"};

    String from;

    DefaultTableModel model;

    DBFrame() {

 
        frame1 = new JFrame("Database Search Result");

        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setVisible(true);

//TableModel tm = new TableModel();

        model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);

//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

//table = new JTable(model);

        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        table.setFillsViewportHeight(true);

        TableColumn column1 = table.getColumnModel().getColumn(1);
        column1.setMinWidth(350);
        column1.setMaxWidth(350);
        column1.setPreferredWidth(350);
        TableColumn column = table.getColumnModel().getColumn(2);
        column.setMinWidth(350);
        column.setMaxWidth(350);
        column.setPreferredWidth(350);
        
        TableColumn column2 = table.getColumnModel().getColumn(3);
        column2.setMinWidth(350);
        column2.setMaxWidth(350);
        column2.setPreferredWidth(350);
        
        TableColumn column3 = table.getColumnModel().getColumn(0);
        column3.setMinWidth(250);
        column3.setMaxWidth(250);
        column3.setPreferredWidth(250);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, 0, 0, 0);
        
        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


//String textvalue = textbox.getText();

        String EncFile = "";

        String DecFile = "";

        String KEY = "";
        
        String source = "";
 

        try {
       		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

             con = DriverManager.getConnection("jdbc:ucanaccess://DB/history.accdb;");

             st = con.createStatement();


            pst = con.prepareStatement("select * from Table1");

            ResultSet rs = pst.executeQuery();

            int i = 0;

            while(rs.next()) {
            	source = rs.getString(1);
            		
                EncFile = rs.getString(2);

                DecFile = rs.getString(3);

                KEY = rs.getString(4);

                model.addRow(new Object[]{source,EncFile,DecFile,KEY});

                i++;

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        frame1.getContentPane().add(scroll);
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame1.setSize(dimension.width, dimension.height);

    }
}