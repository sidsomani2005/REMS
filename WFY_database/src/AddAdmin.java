import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.*;




public class AddAdmin extends Admin implements ActionListener{
	
	String admin_name, admin_username, admin_password;
	
	JTextField adminName, adminUsername, adminPassword;
	
	JButton add_adminBtn;
	
	JLabel newAdmin, name, username, password;
	
	JFrame f;
	
	JMenuBar mb;
    JMenu profile, triB, query;
    JMenuItem home, display, logout, add, distinct, remove, edit, add_admin, admins;
	
    static Login l;
    static Enquiry enq3;
    static Remove r2;
    static Display d;
	static Edit ed3;
	static Admin a3;
	//static AddAdmin aa3; 
    
    
    
	public AddAdmin() {
		
		f = new JFrame();
		f.setTitle("Add New Admin");
		
		
		add_adminBtn = new JButton("Add Admin");
		add_adminBtn.setSize(100,20);
		add_adminBtn.setLocation(430, 480);
		add_adminBtn.addActionListener(this);
		
		name = new JLabel("Admin Name");
		name.setSize(100,20);
		name.setLocation(280,370);
		
		username = new JLabel("Admin Username");
		username.setSize(150,20);
		username.setLocation(280,400);
		
		password = new JLabel("Admin Password");
		password.setSize(150,20);
		password.setLocation(280,430);
		
		
	
		adminName = new JTextField();
		adminName.setSize(200,20);
		adminName.setLocation(400,370);
		
		adminUsername = new JTextField();
		adminUsername.setSize(200,20);
		adminUsername.setLocation(400,400);
		
		adminPassword = new JTextField();
		adminPassword.setSize(200,20);
		adminPassword.setLocation(400,430);
		
		f.setSize(1200, 800);
        f.setLayout(null);
		
		f.add(add_adminBtn);
		f.add(name);
		f.add(username);
		f.add(password);
		f.add(adminUsername);
		f.add(adminPassword);
		f.add(adminName);
		
		
		displayMenu();
        
		f.setVisible(true);
		
	}
	
	
	
	
	public void displayMenu() {
        
        home = new JMenuItem("Home");        
        display = new JMenuItem("Display");
        remove = new JMenuItem("Remove");
        edit = new JMenuItem("Edit");
        query = new JMenu("Query");
        add = new JMenuItem("Add");
        distinct = new JMenuItem("Distinct Op.");
        
        
        query.add(add);
        query.add(distinct);
        query.add(remove);
        query.add(edit);
        
        triB = new JMenu("Menu");
        triB.add(home);
        triB.add(display);
        triB.add(query);
        
        
        profile = new JMenu("Profile");   
        profile.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        logout = new JMenuItem("Logout");
        add_admin = new JMenuItem("Add Admin");
        admins = new JMenuItem("Admins");
        profile.add(admins);
        profile.add(add_admin);
        profile.add(logout);
        
        

        home.addActionListener(this);
        display.addActionListener(this);
        add.addActionListener(this);
        distinct.addActionListener(this);
        logout.addActionListener(this);
        add_admin.addActionListener(this);
        admins.addActionListener(this);
        remove.addActionListener(this);
        edit.addActionListener(this);
        
        //try {
        mb = new JMenuBar();
        //f.setJMenuBar(mb);     
        mb.add(triB);
        mb.add(Box.createHorizontalGlue());
        mb.add(profile);
        
        f.add(mb);
        
       //} catch(NullPointerException e) {
        	//System.out.println(e);
        	//System.out.println(e.getCause());
        //}
        
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==add) {
			
			//System.out.println("ADD BUTTON CLICKED");			
			this.f.dispose();
			 
			enq3 = new Enquiry();
			enq3.displayEnquiryForm();
			
			
		} else if(e.getSource()==home) {
			
			//System.out.println("HOME BUTTON CLICKED");
			
			//Home display method 
			
		} else if(e.getSource()==logout) {
			
			System.out.println("LOGOUT BUTTON CLICKED");
			this.f.dispose();
			
			l = new Login();
			l.displayLogin();
	        
		} else if(e.getSource()==display) {
			
			this.f.dispose();
			
			d = new Display();
			d.displayAll();
			
		} else if(e.getSource()==remove) {
			
			//System.out.println("EDIT BUTTON CLICKED");
			
			this.f.dispose();
			
			r2 = new Remove();
			r2.setupEditableTable();
			
			
		} else if(e.getSource()==edit) {
			
			this.f.dispose();
			
			ed3 = new Edit();
			ed3.displayUpdateFields();
			
		} else if(e.getSource()==admins){
		
			this.f.dispose();
			
			a3 = new Admin();
			a3.displayAdmins();
			
		} else if(e.getSource()==add_admin){
		
			//this.f.dispose();
			
			//aa3 = new AddAdmin();
			
		} else if(e.getSource()==add_adminBtn) {
			
			String url = "jdbc:mysql://localhost:3306/mydb";
			String user = "root";
			String pw = "0Dinosaur";
			
			this.admin_name = adminName.getText();
			this.admin_username = adminUsername.getText();
			this.admin_password = adminPassword.getText();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

			    Connection connection = DriverManager.getConnection(url, user, pw);
			    System.out.println("CONNECTION CREATED");

			    Statement statement = connection.createStatement();
			    System.out.println("CONNECTION ESTABLISHED");

			    String insertQuery = "INSERT INTO admin (admin_name, admin_un, admin_pw) VALUES ('"+ admin_name + "', '" + admin_username + "', '" + admin_password + "')";
		        statement.executeUpdate(insertQuery);
		        
			    
		        System.out.println("QUERIES EXECUTED");
		        System.out.println("Admin ADDED");
		        
			    connection.close();

				} catch(Exception err) {
					System.out.println(err);
				}
			
			
		}
		
	}
	
	
}
