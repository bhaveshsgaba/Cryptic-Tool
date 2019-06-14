import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class DB {	
	public String EncFile;
	public String DecFile;
	public String KEY; 
	public void init(String EncFile, String DecFile, String KEY,String s) {
	 try{        
	       //String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};Dbq=DB/history.accdb;";  
	       //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
	       Connection c=DriverManager.getConnection("jdbc:ucanaccess://DB/history.accdb;");  
	       String query = "insert into Table1 values ('"+s+"','"+EncFile+"','"+DecFile+"','"+KEY+"')";
	       Statement stmt = c.createStatement();
	       stmt.executeUpdate(query);
	       }catch(Exception ee){System.out.println(ee);}  
	      
	    }
}