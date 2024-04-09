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







public class Comments implements ActionListener, ListSelectionListener{


    ResultSet query_result; // = null;
	Connection connection; // = null;
	
	String driverName; 
	String url; 
	String userName; 
	String password; 
	String[] columns, commentData;
	String searchedName;
	
	JTable dataTable;
	JScrollPane scrollPane;
	DefaultTableModel model;
	
	JFrame f;
	
	
	String batch, batch_DB;
	
	String intCourse, studentID;
	
	String c1,c2,c3;
	String d1,d2,d3;
	String status;
	
	JLabel student_name, comment_1, comment_2, comment_3;
	JTextField searchBarName, comment1, comment2, comment3;
    JButton searchName;
    JButton removeEnq, editEnq, update;
	
	
	
	public Comments() {
		
		//this.batch = b;
		//this.batch_DB = bDB;
		
		f = new JFrame();
		f.setSize(1200, 800);
        f.setLayout(null);
        
        searchBarName = new JTextField("Search by Name");
		searchBarName.setSize(1000,20);
		searchBarName.setLocation(50,50);
		
		searchName = new JButton();
		searchName.setText("Search Name");
		searchName.setSize(90,20);
		searchName.setLocation(1075,50);
		searchName.addActionListener(this);
		
		removeEnq = new JButton("Remove");
        removeEnq.setSize(100,20);
        removeEnq.setLocation(520, 600);
        removeEnq.setVisible(false);
        removeEnq.addActionListener(this);
        
        editEnq = new JButton("Edit");
        editEnq.setSize(100,20);
        editEnq.setLocation(380, 600);
        editEnq.setVisible(false);
        editEnq.addActionListener(this);
		

		dataTable = new JTable();
		dataTable.setBounds(0, 140, 1200,775);
        scrollPane = new JScrollPane(dataTable);
        
        
        comment_1 = new JLabel("Comment 1:");
        comment_1.setSize(100,20);
        comment_1.setLocation(105,450);
        
        comment1 = new JTextField();
        comment1.setSize(200,30);
        comment1.setLocation(100, 470);
        
        comment_2 = new JLabel("Comment 2:");
        comment_2.setSize(100,20);
        comment_2.setLocation(105,540);
        
        comment2 = new JTextField();
        comment2.setSize(200,30);
        comment2.setLocation(100, 560);
        
        comment_3 = new JLabel("Comment 3:");
        comment_3.setSize(100,20);
        comment_3.setLocation(105,630);
        
        comment3 = new JTextField();
        comment3.setSize(200,30);
        comment3.setLocation(100, 650);
        
        comment_1.setVisible(false);
        comment_2.setVisible(false);
        comment_3.setVisible(false);
        comment1.setVisible(false);
        comment2.setVisible(false);
        comment3.setVisible(false);
       
        
        update = new JButton("Update");
		update.setSize(100,20);
		update.setLocation(1050, 680);
		update.addActionListener(this);
		update.setVisible(false);
        
        this.model = (DefaultTableModel) dataTable.getModel();	        
		
        f.add(removeEnq);
        f.add(editEnq);
        
        f.add(comment_1);
        f.add(comment_2);
        f.add(comment_3);
        
        f.add(comment1);
        f.add(comment2);
        f.add(comment3);
        
        f.add(update);
        
        
        f.add(searchBarName);
        f.add(searchName);
        
        f.add(scrollPane); 
        
        f.add(dataTable);
        
        
        //displayAll();
        
        f.setVisible(true);
		
		
	}
	
	
	
	
	public void displayAll() {
		
		f.setTitle("Comments - "+batch);
		
		this.driverName = "com.mysql.jdbc.Driver";
		this.url = "jdbc:mysql://localhost:3306/mydb";
		this.userName = "root";
		this.password = "0Dinosaur";
		//ResultSet query_result = null;
		//Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		    connection = DriverManager.getConnection(url, userName, password);
		    System.out.println("CONNECTION CREATED");

		    Statement statement = connection.createStatement();
		    System.out.println("CONNECTION ESTABLISHED");

		    //query_result = statement.executeQuery("SELECT * FROM '"+batch_DB+"'");
		    
		    String selectAll = "SELECT * FROM "+this.batch_DB;
		    
		    query_result = statement.executeQuery(selectAll);
		    
	        System.out.println("QUERIES EXECUTED");
	        

			} catch(Exception err) {
				System.out.println(err);
				err.printStackTrace();
		
			}		
		
		
		DefaultTableModel st_comments = new DefaultTableModel();
		
		ResultSetMetaData metaData;
		
		try {
			
			metaData = query_result.getMetaData();
			int columnCount = metaData.getColumnCount();
			columns = new String[columnCount];
			
			for (int column = 1; column <= columnCount; column++) {
                st_comments.addColumn(metaData.getColumnName(column));
                columns[column-1] = metaData.getColumnName(column);
            }
			
			
			while (query_result.next()) {
                Object[] rowData = new Object[columnCount];
                for (int column = 1; column <= columnCount; column++) {
                    rowData[column - 1] = query_result.getObject(column);
                }
                st_comments.addRow(rowData);
                

            }
			
			
			System.out.println("Creating dataTable");
			dataTable.setModel(st_comments); // Set the model to the JTable
			System.out.println("Finished creating dataTable");
			
			
			TableColumnModel columnModel = dataTable.getColumnModel();
			
			dataTable.getSelectionModel().addListSelectionListener(this);

			
			connection.close();
			//System.out.println("CONNECTION CLOSED");
			
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchName) {
			
			//System.out.println("Search Bar Pressed");			
			this.searchedName = searchBarName.getText();	
			System.out.println(searchedName);
			
			//System.out.println("Search Bar Text Retrieved");

			
			
			try {
		        Class.forName("com.mysql.cj.jdbc.Driver");

		        connection = DriverManager.getConnection(url, userName, password);

		        Statement statement = connection.createStatement();

		        query_result = statement.executeQuery("SELECT * FROM " + batch_DB + " WHERE st_name = '" + searchedName + "'");

		        System.out.println();

		        DefaultTableModel searchResultsModel = new DefaultTableModel();

		        ResultSetMetaData metaData = query_result.getMetaData();
		        int columnCount = metaData.getColumnCount();

		        
		        for (int column = 1; column <= columnCount; column++) {
		            searchResultsModel.addColumn(metaData.getColumnName(column));
		        }

		        
		        while (query_result.next()) {
		        	Object[] rowData = new Object[columnCount];
		        	
		            
		            for (int column = 1; column <= columnCount; column++) {
		                rowData[column - 1] = query_result.getObject(column);
		            }
		            searchResultsModel.addRow(rowData);
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
			
		} else if(e.getSource() == removeEnq) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

			    Connection connection = DriverManager.getConnection(url, userName, password);
			    
			    Statement statement = connection.createStatement();
			    
			    String deleteQuery = "DELETE FROM "+ batch_DB + " WHERE id = '" + dataTable.getValueAt(dataTable.getSelectedRow(), 0)+"'";
			    
			    PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			    
			    preparedStatement.executeUpdate();
		        
			    connection.close();

				} catch(Exception err) {
					System.out.println(err);
				}		
			
			System.out.println("Enquiry REMOVED");
			removeEnq.setVisible(false);
        	editEnq.setVisible(false);

        	displayAll();
			
			
			
		} else if(e.getSource()==editEnq) {
			
        	removeEnq.setVisible(false);
        	editEnq.setVisible(false);
        	update.setVisible(true);
        	
        	
        	//add code to make textfields to edit comments visible along with the update
		
        	comment_1.setVisible(true);
            comment_2.setVisible(true);
            comment_3.setVisible(true);
            
            comment1.setVisible(true);
            comment2.setVisible(true);
            comment3.setVisible(true);
            
            
            comment1.setText(commentData[3]);
            comment2.setText(commentData[5]);
            comment3.setText(commentData[7]);
            
        	
        	displayAll();
        	
		}  else if(e.getSource()==update) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

			    Connection connection = DriverManager.getConnection(url, userName, password);
			    System.out.println("CONNECTION CREATED");

			    Statement statement = connection.createStatement();
			    System.out.println("CONNECTION ESTABLISHED");

			    String updateQuery = "UPDATE " + batch_DB + " SET comment1 = '" + comment1.getText() + "', comment2 = '" + comment2.getText() + "', comment3 = '" + comment3.getText() + "' WHERE id='"+studentID+"'";
			    
			    Statement stmt = connection.createStatement();
			    stmt.executeUpdate(updateQuery);
			    
			    String dateUpdateQuery = "UPDATE " + batch_DB + " SET date_of_enq = '" + new SimpleDateFormat("yy/MM/dd").format(new Date())+"' WHERE id='"+studentID+"'";
			    stmt.executeUpdate(dateUpdateQuery);
			    
		        System.out.println("QUERIES EXECUTED");
		        
			    connection.close();
			    
			    displayAll();
			    
			} catch(Exception err) {
				System.out.println(err);
			}		

			
			//comment1.setText("");
			//comment2.setText("");
			//comment3.setText("");
			
			comment1.setVisible(false);
			comment2.setVisible(false);
			comment3.setVisible(false);
			comment_1.setVisible(false);
			comment_2.setVisible(false);
			comment_3.setVisible(false);
			
			editEnq.setVisible(false);
			removeEnq.setVisible(false);
			update.setVisible(false);
			
			

		}
	
	
	}	
	
	

	
	@Override
    public void valueChanged(ListSelectionEvent e) {
        
		if (!e.getValueIsAdjusting()) { // To avoid handling multiple events for the same selection
            int selectedRow = dataTable.getSelectedRow();

            if (selectedRow != -1) { // If a row is selected
               

    			try {
    		        Class.forName("com.mysql.cj.jdbc.Driver");

    		        connection = DriverManager.getConnection(url, userName, password);

    		        Statement statement = connection.createStatement();

    		        query_result = statement.executeQuery("SELECT * FROM "+batch_DB+" WHERE id = " + dataTable.getValueAt(selectedRow, 0).toString());

    		        System.out.println();

    		        DefaultTableModel searchResultsModel = new DefaultTableModel();

    		        ResultSetMetaData metaData = query_result.getMetaData();
    		        int columnCount = metaData.getColumnCount();

    		        for (int column = 1; column <= columnCount; column++) {
    		            searchResultsModel.addColumn(metaData.getColumnName(column));
    		        }

    		        while (query_result.next()) {
    		            Object[] rowData = new Object[columnCount];
    		            commentData = new String[columnCount];
    		            
    		            for (int column = 1; column <= columnCount; column++) {
    		                rowData[column - 1] = query_result.getObject(column);
    		                commentData[column-1] = rowData[column-1].toString();
    		            }
    		            
    		            for (int i=0; i<rowData.length; i++) {
    		            	System.out.println(commentData[i]);
    		            }
    		            
    		            studentID = commentData[0];
    		            
    		            c1 = commentData[3];
    		            c2 = commentData[5];
    		            c3 = commentData[7];
    		            status = commentData[9];
    		            
    		            System.out.println("Comment 1: "+c1);
    		            
    		            
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
            	dataTable.setBounds(0, 140, 1200,300);
            	removeEnq.setVisible(true);
            	editEnq.setVisible(true);
            	
            	
            } 
        }
    }

	
	
	
	
	
}
