import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.*;








public class Login implements ActionListener{


	
	String driverName, url, userName, passWord; 
	
	String[] columns, adminData;
	
	String name;
	String username;
	String password;
	
	JTextField nameEntry, unEntry, pwEntry;
	JButton loginBtn;
	
	JLabel heading;
	
	static Enquiry enq2;
	
	JFrame f;
	
	JLabel logoLabel;
	

    ResultSet query_result = null;
	Connection connection = null;
	
	
	
	public static void main(String[] args) {
		System.out.println("Login Page!");
		
	}
	
	
	
	public void displayLogin() {
		
		f = new JFrame();
		f.setTitle("Login Page");
		

		
		
		
		
		f.getContentPane().setBackground(Color.white);
		
		this.nameEntry = new JTextField("admin name");
		this.nameEntry.setSize(200,30);
		this.nameEntry.setLocation(500,415);
		
		this.unEntry = new JTextField("username");
		this.unEntry.setSize(200,30);
		this.unEntry.setLocation(500,450);

		this.pwEntry = new JTextField("password");
		this.pwEntry.setSize(200,30);
		this.pwEntry.setLocation(500,485);
		
		this.loginBtn = new JButton("Login");
		this.loginBtn.setSize(100,30);
		this.loginBtn.setLocation(550,550);
		loginBtn.addActionListener(this);
				
		
		
	
		
		//f.setLayout(new GridLayout(1,2,300,400));
		f.setLayout(null);
		f.setSize(1200, 800);
		
		displayLogo();
		f.add(nameEntry);
		f.add(unEntry);
		f.add(pwEntry);
		f.add(loginBtn);
		
		f.setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==loginBtn) {
			/*
			this.driverName = "com.mysql.jdbc.Driver";
			this.url = "jdbc:mysql://localhost:3306/mydb";
			this.userName = "root";
			this.password = "0Dinosaur";
			

			try {
		        Class.forName("com.mysql.cj.jdbc.Driver");

		        connection = DriverManager.getConnection(url, userName, password);

		        Statement statement = connection.createStatement();

		        query_result = statement.executeQuery("SELECT * FROM admin WHERE admin_name = '" + this.nameEntry.getText() + "'");

		        System.out.println();

		        DefaultTableModel searchResultsModel = new DefaultTableModel();

		        ResultSetMetaData metaData = query_result.getMetaData();
		        int columnCount = metaData.getColumnCount();

		        
		        for (int column = 1; column <= columnCount; column++) {
		            searchResultsModel.addColumn(metaData.getColumnName(column));
		        }

		        
		        while (query_result.next()) {
		        	Object[] rowData = new Object[columnCount];
		        	adminData = new String[columnCount];
		            
		            for (int column = 1; column <= columnCount; column++) {
		                rowData[column - 1] = query_result.getObject(column);
		                adminData[column-1] = rowData[column-1].toString();
		            }
		            searchResultsModel.addRow(rowData);
		        }


		    } catch (Exception err) {
		        System.out.println(err);

		    } finally {
		        try {
		            if (query_result != null) {
		                query_result.close();
		            }
		            if (connection != null) {
		                connection.close();
		            }
		                
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
			*/
			//if(this.unEntry.getText().equals(adminData[2]) && this.pwEntry.getText().equals(adminData[3])) {
			
				f.dispose();
				enq2 = new Enquiry();
				enq2.displayEnquiryForm(); 
				
				
			
			//}
						
		}
		
	}
	
	
	
	public void displayLogo() {
	    ImageIcon logoIcon = new ImageIcon("/Users/sidsomani/Desktop/logo.jpg"); // Replace "logo.png" with your image file path
	    
	    Image scaledImage = logoIcon.getImage().getScaledInstance(650, 300, Image.SCALE_SMOOTH);
	    ImageIcon scaledIcon = new ImageIcon(scaledImage);
	    
	    logoLabel = new JLabel(scaledIcon);
	    
	    logoLabel.setBounds(350, 100, scaledIcon.getIconWidth(), scaledIcon.getIconHeight());
	    f.add(logoLabel);
	    
	}
	
	
	
}


















