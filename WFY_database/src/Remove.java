import java.sql.*;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.util.*;
import java.util.Date;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.*;
import java.beans.*;




public class Remove extends Display implements ActionListener{
	
	DefaultTableModel model;
	
	JButton remove;
	
	String removeID;

	//COPY AND PASTED FROM ENQUIRY CLASS
		//String st_name, p_name, school, gr_lvl, marks, interested_course, address, st_phone_no, p_phone_no, st_gmail, p_gmail, date_of_enquiry, date_last_updated;
		
		
		JLabel sname, pname, sch_name, grade_lvl, class_marks, int_course, city_label, str, flt, stPhoneNo, pPhoneNo, stgmail, pgmail;
		JTextField stu_name, par_name, school_name, grade, classMarks, intCourse, city,street, flat, st_phone, p_phone, stu_gmail, par_gmail;

	   
	    
	    JPopupMenu gradesMenu;
	    JPopupMenu interested_courses;
	    JMenuItem seven, eight, nine, ten, eleven, twelve;
	    JMenuItem seventh, eighth, ninth, tenth, eleventh, twelfth, eleventh_JEE, twelfth_JEE, eleventh_NEET, twelfth_NEET, JEE, NEET; 
	    //COPY AND PASTED FROM ENQUIRY CLASS
	
	
	public Remove() {
		super();
	
		super.dataTable.setBounds(0, 140, 1200,300);
		
		
		remove = new JButton("Remove");
		remove.setSize(100,20);
		remove.setLocation(1050, 690);

		remove.addActionListener(this);
 
		f.add(remove);
        
        //f.setVisible(true);
		
		setupEditableTable();
		
	}
	
	

	public void setupEditableTable() {
			super.displayAll(); // Populate the JTable
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		super.actionPerformed(e);
		
		if(e.getSource() == remove) { 
			
			removeID = searchBarID.getText();
			
			System.out.println("ID of Enquiry to Remove: "+removeID);
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

			    Connection connection = DriverManager.getConnection(url, userName, password);
			    System.out.println("CONNECTION CREATED");

			    Statement statement = connection.createStatement();
			    System.out.println("CONNECTION ESTABLISHED");

			    String deleteQuery = "DELETE FROM enquiries WHERE id = ?";
			 
			    PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			    
			    preparedStatement.setString(1, searchBarID.getText());
			    preparedStatement.executeUpdate();
			    
		        System.out.println("QUERIES EXECUTED");
		        
			    connection.close();

				} catch(Exception err) {
					System.out.println(err);
				}		
			
			
			
			System.out.println("Enquiry REMOVED");
			
			
			
		} 
		
	
	}
	



	
	
}
