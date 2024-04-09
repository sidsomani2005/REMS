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



public class Admin implements ActionListener, ListSelectionListener{

	
	String driverName; 
	String url, userName, password; 
	String[] columns, adminData;
	
	String searchedName, searchedID;
	
	JTable dataTable;
	JScrollPane scrollPane;
	JFrame f;
	
	JMenuBar mb;
    JMenu profile, triB;
    JMenuItem display, logout, add, add_admin, admins;
    
    JTextField searchBarName, searchBarID, editUN, editPW;
    JButton searchName, searchID, removeBtn, editBtn, updateAdminInfo;
    JLabel adminName;
    
    ResultSet query_result = null;
	Connection connection = null; 
	
    static Login l;
    static Enquiry enq3;
    static Remove r2;
    static Display d;
	static Edit ed3;
	static Admin a2;
	static AddAdmin aa2; 
	

	
	public Admin() {
		//System.out.println("Display Class");
				f = new JFrame();
				
				//adminData = new String[4];
				
				updateAdminInfo = new JButton("Update");
				updateAdminInfo.setSize(100,20);
				updateAdminInfo.setLocation(1050, 320);
				updateAdminInfo.setVisible(false);
				updateAdminInfo.addActionListener(this);
				
				
				removeBtn = new JButton("Remove");
				removeBtn.setSize(100,20);
				removeBtn.setLocation(1050, 150);
				removeBtn.setVisible(false);
				removeBtn.addActionListener(this);
				
				editBtn = new JButton("Edit");
				editBtn.setSize(100,20);
				editBtn.setLocation(1050, 200);
				editBtn.setVisible(false);
				editBtn.addActionListener(this);
				
				editUN = new JTextField();
				editUN.setSize(120,20);
				editUN.setLocation(1040,250);
				editUN.setVisible(false);
				
				editPW = new JTextField();
				editPW.setSize(120,20);
				editPW.setLocation(1040,280);
				editPW.setVisible(false);
				
				
				searchBarName = new JTextField("Search by Name");
				searchBarName.setSize(1000,20);
				searchBarName.setLocation(50,50);
				
				searchName = new JButton();
				searchName.setText("Search Name");
				searchName.setSize(90,20);
				searchName.setLocation(1075,50);
				searchName.addActionListener(this);
				
				
				dataTable = new JTable();
				dataTable.setBounds(0, 140, 1000,650);
		        scrollPane = new JScrollPane(dataTable);
		        dataTable.getSelectionModel().addListSelectionListener(this);
		        
		        adminName = new JLabel();
		        adminName.setSize(100,20);
		        adminName.setLocation(1050,230);
		        adminName.setVisible(false);
		        
		        
		        f.setSize(1200, 800);
		        f.setLayout(null); 
		        
		        f.add(removeBtn);
		        f.add(editBtn);
		        f.add(editUN);
		        f.add(editPW);
		        f.add(updateAdminInfo);
		        f.add(adminName);
		        
		        
		        f.add(searchBarName);
		        f.add(searchName);
		        
		        
		        f.add(scrollPane); 
		        
		        f.add(dataTable);
		        
		        displayMenu();
		        
				f.setVisible(true);
				
	}
	
	
	
	
	

	public static void main(String[] args) {
		System.out.println("VIEWING ADMINS");
		SwingUtilities.invokeLater(() -> new Display().displayAll());
	}
	
	
	
	
	
	
	

	public void displayAdmins() {
		
		this.driverName = "com.mysql.jdbc.Driver";
		this.url = "jdbc:mysql://localhost:3306/mydb";
		this.userName = "root";
		this.password = "0Dinosaur";
		//ResultSet query_result = null;
		//Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		    connection = DriverManager.getConnection(url, userName, password);

		    Statement statement = connection.createStatement();

		    query_result = statement.executeQuery("SELECT * FROM admin");

			} catch(Exception err) {
				System.out.println(err);
		
			}		
		
		
		DefaultTableModel admin_table = new DefaultTableModel();
		
		ResultSetMetaData metaData;
		
		try {
			
			metaData = query_result.getMetaData();
			int columnCount = metaData.getColumnCount();
			columns = new String[columnCount];
			
			for (int column = 1; column <= columnCount; column++) {
                admin_table.addColumn(metaData.getColumnName(column));
                columns[column-1] = metaData.getColumnName(column);
            }
			
			
			while (query_result.next()) {
                Object[] rowData = new Object[columnCount];
                
                for (int column = 1; column <= columnCount; column++) {
                    rowData[column - 1] = query_result.getObject(column);
                    
                }
                admin_table.addRow(rowData);
            }
			
			
			//System.out.println("Creating dataTable");
			dataTable.setModel(admin_table); // Set the model to the JTable
			//System.out.println("Finished creating dataTable");
			
			
			TableColumnModel columnModel = dataTable.getColumnModel();

			connection.close();
			//System.out.println("CONNECTION CLOSED");
			
        } catch (SQLException e) {
            e.printStackTrace();
        }
			
		
	}
	
	
	public void displayMenu() {
        
             
        display = new JMenuItem("Display");
        add = new JMenuItem("Add");

        
        triB = new JMenu("Menu");

        triB.add(display);
        triB.add(add);
        
        
        profile = new JMenu("Profile");   
        profile.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        logout = new JMenuItem("Logout");
        add_admin = new JMenuItem("Add Admin");
        admins = new JMenuItem("Admins");
        
        profile.add(admins);
        profile.add(add_admin);
        profile.add(logout);
        
        

        display.addActionListener(this);
        add.addActionListener(this);
        logout.addActionListener(this);
        add_admin.addActionListener(this);
        admins.addActionListener(this);
        
        
        mb = new JMenuBar();
        f.setJMenuBar(mb);
        
        mb.add(triB);
        mb.add(Box.createHorizontalGlue());
        mb.add(profile);
        
        f.add(mb);
                
        
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		if(e.getSource()==add) {
			
			//System.out.println("ADD BUTTON CLICKED");			
			this.f.dispose();
			
			enq3 = new Enquiry();
			enq3.displayEnquiryForm();
			
			
		} else if(e.getSource()==logout) {
			
			System.out.println("LOGOUT BUTTON CLICKED");
			this.f.dispose();
			
			l = new Login();
			l.displayLogin();
	        
		} else if(e.getSource()==display) {
			
			this.f.dispose();
			
			d = new Display();
			d.displayAll();
			
		} else if(e.getSource()==admins){
		
			this.f.dispose();
			
			a2 = new Admin();
			a2.displayAdmins();
			
		} else if(e.getSource()==add_admin){
		
			this.f.dispose();
			
			aa2 = new AddAdmin();
			
		} else if(e.getSource()==searchName) {
					
			this.searchedName = searchBarName.getText();	
			System.out.println(searchedName);
			
			removeBtn.setVisible(true);
			editBtn.setVisible(true);
			
			editUN.setVisible(false);
			editPW.setVisible(false);
			
			
			try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        connection = DriverManager.getConnection(url, userName, password);;
		        Statement statement = connection.createStatement();
		        query_result = statement.executeQuery("SELECT * FROM admin WHERE admin_name = '" + searchedName + "'");
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
		            
		            
		            for (int i=0; i<rowData.length; i++) {
		            	System.out.println(adminData[i]);
		            }
		        }
		        
		        

		        dataTable.setModel(searchResultsModel); // Set the model to the JTable 

				TableColumnModel columnModel = dataTable.getColumnModel();
		        
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
			
			
		} else if(e.getSource()==removeBtn) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

			    Connection connection = DriverManager.getConnection(url, userName, password);
			    System.out.println("CONNECTION CREATED");

			    Statement statement = connection.createStatement();
			    System.out.println("CONNECTION ESTABLISHED");

			    String deleteQuery = "DELETE FROM admin WHERE admin_name = '"+adminData[1]+"'";
			 
			    PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			    
			    //preparedStatement.setString(1, searchBarName.getText());
			    preparedStatement.executeUpdate();
			    
		        System.out.println("QUERIES EXECUTED");
		        
			    connection.close();

				} catch(Exception err) {
					System.out.println(err);
				}		

			System.out.println("Admin REMOVED");
			removeBtn.setVisible(false);
        	editBtn.setVisible(false);
        	editUN.setVisible(false);
		    editPW.setVisible(false);
		    updateAdminInfo.setVisible(false);
        	displayAdmins();
		
		
		} else if(e.getSource()==editBtn) {
			
			editUN.setVisible(true);
			editPW.setVisible(true);
			updateAdminInfo.setVisible(true);
			
			System.out.println(""+adminData[1]+", "+adminData[2]+", "+adminData[3]);
			
			editUN.setText(adminData[2]);
			editPW.setText(adminData[3]);
			
			
			
			
		} else if(e.getSource()==updateAdminInfo) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

			    Connection connection = DriverManager.getConnection(url, userName, password);
			    System.out.println("CONNECTION CREATED");

			    Statement statement = connection.createStatement();
			    System.out.println("CONNECTION ESTABLISHED");

			    String updateQuery = "UPDATE admin SET admin_un= '"+this.editUN.getText()+"', admin_pw='"+this.editPW.getText()+"' WHERE admin_name = '" + adminData[1] + "'";
			    
			    Statement stmt = connection.createStatement();
			    stmt.executeUpdate(updateQuery);
			    
		        System.out.println("QUERIES EXECUTED");
		        
			    connection.close();
			    
			    this.editUN.setVisible(false);
			    this.editPW.setVisible(false);
			    this.editBtn.setVisible(false);
			    this.removeBtn.setVisible(false);
			    this.updateAdminInfo.setVisible(false);
			    displayAdmins();
			    
			    
				
				searchBarName.setText("Search by Name"); 

				} catch(Exception err) {
					System.out.println(err);
				}
		}

		
		
	} 



//adminName.setVisible(true);
//adminName.setText(adminData[1]);

	
	
	
	
	@Override
    public void valueChanged(ListSelectionEvent e) {
        
		if (!e.getValueIsAdjusting()) { // To avoid handling multiple events for the same selection
            int selectedRow = dataTable.getSelectedRow();

            if (selectedRow != -1) { // If a row is selected
               
            	dataTable.setBounds(0, 140, 1000,650);

    			try {
    		        Class.forName("com.mysql.cj.jdbc.Driver");

    		        connection = DriverManager.getConnection(url, userName, password);

    		        Statement statement = connection.createStatement();

    		        query_result = statement.executeQuery("SELECT * FROM admin WHERE admin_id = '" + dataTable.getValueAt(selectedRow, 0) + "'");

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
    		            
    		            for (int i=0; i<rowData.length; i++) {
    		            	System.out.println(adminData[i]);
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
    			
            	System.out.println("Row Selected: "+selectedRow);
            	editBtn.setVisible(true);
            	removeBtn.setVisible(true);
            	
            	
            } 
        }
    }

	


	
	
}




