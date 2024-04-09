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





public class Edit extends Display implements ActionListener, MouseListener{
	
	DefaultTableModel model;
	
	JButton update;
	
	String updateID;
	
	
	//COPY AND PASTED FROM ENQUIRY CLASS
	String st_name, p_name, school, gr_lvl, marks, interested_course, address, st_phone_no, p_phone_no, st_gmail, p_gmail, date_of_enquiry, date_last_updated;
	
	
	JLabel sname, pname, sch_name, grade_lvl, class_marks, int_course, city_label, str, flt, stPhoneNo, pPhoneNo, stgmail, pgmail;
	JTextField stu_name, par_name, school_name, grade, classMarks, intCourse, city,street, flat, st_phone, p_phone, stu_gmail, par_gmail;

    
    JPopupMenu gradesMenu;
    JPopupMenu interested_courses;
    JMenuItem seven, eight, nine, ten, eleven, twelve;
    JMenuItem seventh, eighth, ninth, tenth, eleventh, twelfth, eleventh_JEE, twelfth_JEE, eleventh_NEET, twelfth_NEET, JEE, NEET; 
    //COPY AND PASTED FROM ENQUIRY CLASS
    
     
    String st_nameQ, p_nameQ, schoolQ, gr_lvlQ, marksQ, interested_courseQ, addressQ, st_phone_noQ, p_phone_noQ, st_gmailQ, p_gmailQ, date_of_enquiryQ, date_last_updatedQ;
	
    Connection connectionEdit = null;

    
	
	public Edit() {
		super();
		
		System.out.println("Inside Edit class constructor");
		
		super.dataTable.setBounds(0, 140, 1200,300);
		
		this.model = (DefaultTableModel) super.dataTable.getModel();	        
		 
		update = new JButton("Update");
		update.setSize(100,20);
		update.setLocation(1050, 680);
		update.addActionListener(this);
		f.add(update);
		
		setupEditableTable();
	}
	
	

	
	
	
	
	public void setupEditableTable() {
		super.displayAll(); // Populate the JTable 
	}
	
	
	
	
	
	
	public void displayUpdateFields() {

				//labels
				sname = new JLabel("Student Name: ");
				pname = new JLabel("Parent Name: ");
				sch_name = new JLabel("School: ");
				grade_lvl = new JLabel("Class: ");
				class_marks = new JLabel("Previous Class Marks: ");
				int_course = new JLabel("Interested Course: ");
				city_label = new JLabel("City: ");
				str = new JLabel("Street: ");
				flt = new JLabel("Flat: ");
				stPhoneNo = new JLabel("Student Phone No.: ");
				pPhoneNo = new JLabel("Parent Phone No.: ");
				stgmail = new JLabel("Student Gmail: ");
				pgmail = new JLabel("Parent Gmail: ");
				
				
				
				sname.setSize(100,20);
			    sname.setLocation(50,480);			    
			 
				stu_name = new JTextField();
				stu_name.setSize(150,20);
			    stu_name.setLocation(45,500);
				
		        
			    pname.setSize(100,20);
			    pname.setLocation(225,480);
			    
		        par_name = new JTextField();
		        par_name.setSize(150,20);
			    par_name.setLocation(220,500);

			    
			    sch_name.setSize(100,20);
			    sch_name.setLocation(405,480);
			    
		        school_name = new JTextField();
		        school_name.setSize(300,20);
			    school_name.setLocation(400,500);

			    
			    grade_lvl.setSize(100,20);
			    grade_lvl.setLocation(745,480);
			    
			    grade = new JTextField();
			    grade.setSize(75,20);
			    grade.setLocation(740,500);
			    
			    
			    class_marks.setSize(200,20);
			    class_marks.setLocation(855,480);
			    
			    classMarks = new JTextField();
			    classMarks.setSize(200,20);
			    classMarks.setLocation(850,500);
			    
			    
			    int_course.setSize(200,20);
			    int_course.setLocation(50,530);
			    
			    intCourse = new JTextField();
			    intCourse.setSize(150,20);
			    intCourse.setLocation(45,550);
			    
			    
			    city_label.setSize(100,20);
			    city_label.setLocation(225,530);
			    
		        city = new JTextField();
		        city.setSize(150,20);
			    city.setLocation(220,550);
		        
			    
			    str.setSize(100,20);
			    str.setLocation(405,530);
			    
		        street = new JTextField();
		        street.setSize(150,20);
			    street.setLocation(400,550);

			    
			    flt.setSize(100,20);
			    flt.setLocation(595,530);
			    
		        flat = new JTextField();
		        flat.setSize(150,20);
			    flat.setLocation(590,550);

			    
			    stPhoneNo.setSize(200,20);
			    stPhoneNo.setLocation(50,580);
			    
		        st_phone = new JTextField();
		        st_phone.setSize(150,20);
			    st_phone.setLocation(45,600);

			    
			    pPhoneNo.setSize(150,20);
			    pPhoneNo.setLocation(225,580);
			    
		        p_phone = new JTextField();
		        p_phone.setSize(150,20);
			    p_phone.setLocation(220,600);
			    
			    
			    stgmail.setSize(150,20);
			    stgmail.setLocation(405,580);

		        stu_gmail = new JTextField();
		        stu_gmail.setSize(150,20);
			    stu_gmail.setLocation(400,600);
			    
			    
			    pgmail.setSize(150,20);
			    pgmail.setLocation(595,580);

		        par_gmail = new JTextField();
		        par_gmail.setSize(150,20);
			    par_gmail.setLocation(590,600);
			    

			    grade.addMouseListener(this);
		        grade.addActionListener(this);
		        gradesMenu = new JPopupMenu("Grades");
		        
		        gradesMenu.setSize(30,100);
		        gradesMenu.setLocation(200,255);
		        
		        seven = new JMenuItem("7");
		        seven.addActionListener(this);
		        
		        eight = new JMenuItem("8");
		        eight.addActionListener(this);
		        
		        nine = new JMenuItem("9");
		        nine.addActionListener(this);
		        
		        ten = new JMenuItem("10");
		        ten.addActionListener(this);
		        
		        eleven = new JMenuItem("11");
		        eleven.addActionListener(this);
		        
		        twelve = new JMenuItem("12");
		        twelve.addActionListener(this);
		        
		        gradesMenu.add(seven);
		        gradesMenu.add(eight);
		        gradesMenu.add(nine);
		        gradesMenu.add(ten);
		        gradesMenu.add(eleven);
		        gradesMenu.add(twelve);
		        
		        
		        
		        intCourse.addMouseListener(this);
		        intCourse.addActionListener(this);        
		        interested_courses = new JPopupMenu("Interested Course");
		        
		        seventh = new JMenuItem("7");
		        seventh.addActionListener(this);
		        
		        eighth = new JMenuItem("8");
		        eighth.addActionListener(this);
		        
		        ninth = new JMenuItem("9");
		        ninth.addActionListener(this);
		        
		        tenth = new JMenuItem("10");
		        tenth.addActionListener(this);
		        
		        eleventh_JEE = new JMenuItem("11 + JEE");
		        eleventh_JEE.addActionListener(this);
		        
		        twelfth_JEE = new JMenuItem("12 + JEE"); 
		        twelfth_JEE.addActionListener(this);
		        
		        eleventh_NEET = new JMenuItem("11 + NEET");
		        eleventh_NEET.addActionListener(this);
		        
		        twelfth_NEET = new JMenuItem("12 + NEET"); 
		        twelfth_NEET.addActionListener(this);
		        
		        JEE = new JMenuItem("JEE");
		        JEE.addActionListener(this);
		        
		        NEET = new JMenuItem("NEET");
		        NEET.addActionListener(this);
		        
		        interested_courses.add(seventh);
		        interested_courses.add(eighth);
		        interested_courses.add(ninth);
		        interested_courses.add(tenth);
		        interested_courses.add(eleventh_JEE);
		        interested_courses.add(twelfth_JEE);
		        interested_courses.add(eleventh_NEET);
		        interested_courses.add(twelfth_NEET);
		        interested_courses.add(JEE);
		        interested_courses.add(NEET);
		        
		        
		        //adding labels
		        f.add(sname);	
		        f.add(pname);
		        f.add(sch_name);
		        f.add(grade_lvl);
		        f.add(class_marks);
		        f.add(int_course);
		        f.add(city_label);
		        f.add(str);
		        f.add(flt);
		        f.add(stPhoneNo);
		        f.add(pPhoneNo);
		        f.add(stgmail);
		        f.add(pgmail);
		        
		        
		        //adding textfields
		        f.add(stu_name);
		        f.add(par_name);
		        f.add(school_name);
		        f.add(grade);
		        f.add(classMarks);
		        f.add(intCourse);
		        f.add(city);
		        f.add(street);
		        f.add(flat);
		        f.add(st_phone);
		        f.add(p_phone);
		        f.add(stu_gmail);
		        f.add(par_gmail);
		        
		        
		        
		        //adding popup menus
		        f.add(gradesMenu);
		        
		        
		        //f.setVisible(true);
		        
		        
	}
	
	public void actionPerformed(ActionEvent e) {
		
		super.actionPerformed(e);
		
		if(e.getSource()==searchID){   
			System.out.println("Student Name from searched ID: "+enquiryData[1]);
			    
			stu_name.setText(enquiryData[1]);
			par_name.setText(enquiryData[2]); 
			school_name.setText(enquiryData[3]);
			grade.setText(enquiryData[4]);
			classMarks.setText(enquiryData[5]);
			intCourse.setText(enquiryData[6]);
			//city.setText(enquiryData[]);
			//street.setText(enquiryData[]);
			//flat.setText(enquiryData[]);
			st_phone.setText(enquiryData[8]);
			p_phone.setText(enquiryData[9]);
			stu_gmail.setText(enquiryData[10]);
			par_gmail.setText(enquiryData[11]);
	
		} if(e.getSource()==update) {
			
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

			    Connection connection = DriverManager.getConnection(url, userName, password);
			    System.out.println("CONNECTION CREATED");

			    Statement statement = connection.createStatement();
			    System.out.println("CONNECTION ESTABLISHED");

			    String updateQuery = "UPDATE enquiries SET st_name= '"+this.stu_name.getText()+"', p_name='"+this.par_name.getText()+"', school='"+this.school_name.getText()+"', class='"+this.grade.getText()+"', prev_marks='"+this.classMarks.getText()+"', interested_course='"+this.intCourse.getText()+"', st_phone_no='"+this.st_phone.getText()+"', p_phone_no='"+this.p_phone.getText()+"', st_email='"+this.stu_gmail.getText()+"', p_email='"+this.par_gmail.getText()+"' WHERE id = '" + searchedID + "'";
			    
			    
			    Statement stmt = connection.createStatement();
			    stmt.executeUpdate(updateQuery);
			    
		        System.out.println("QUERIES EXECUTED");
		        
			    connection.close();
			    setupEditableTable();
			    
			    this.stu_name.setText("");
				this.par_name.setText("");
				this.school_name.setText("");
				this.grade.setText("");
				this.classMarks.setText("");
				this.intCourse.setText("");
				this.flat.setText("");
				this.street.setText("");
				this.city.setText("");
				this.st_phone.setText("");
				this.p_phone.setText("");
				this.stu_gmail.setText("");
				this.par_gmail.setText("");
				
				searchBarName.setText("Search by Name"); 
				searchBarID.setText("Search by ID");

				} catch(Exception err) {
					System.out.println(err);
				}		
			
			
		}
		
		
		
}	
		

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==grade) {
			gradesMenu.show(f, 745, 565);			
		} else if(e.getSource()==intCourse) {
			interested_courses.show(f,50,620);
		}
		
	}







	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
	
	
}
