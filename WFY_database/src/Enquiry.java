import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.*;
import java.util.Date;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.*;






public class Enquiry implements ActionListener, MouseListener{

	
	String st_name, p_name, school, gr_lvl, marks, interested_course, address, st_phone_no, p_phone_no, st_gmail, p_gmail, date_of_enquiry, date_last_updated;
	
	
	JLabel sname, pname, sch_name, grade_lvl, class_marks, int_course, city_label, str, flt, stPhoneNo, pPhoneNo, stgmail, pgmail, source;
	JTextField stu_name, par_name, school_name, grade, classMarks, intCourse, city,street, flat, st_phone, p_phone, stu_gmail, par_gmail, source_of_enquiry;
    
    JButton submit; 

   
	
    JMenuBar mb;
    JMenu profile, triB, comments;
    JMenuItem display, logout, add, add_admin, admins, comm_JEE, comm_NEET, comm7th, comm8th, comm9th, comm10th, comm11th, comm12th;
    
    JPopupMenu gradesMenu;
    JPopupMenu interested_courses;
    JMenuItem seven, eight, nine, ten, eleven, twelve;
    JMenuItem seventh, eighth, ninth, tenth, eleventh, twelfth, eleventh_JEE, twelfth_JEE, eleventh_NEET, twelfth_NEET, JEE, NEET; 
    
    
     
    
	static JFrame f;
	static Display d;
	static Login l;
	static Remove r;
	static Edit ed2;
	static Admin a4;
	static AddAdmin aa4;
	static CommentsJEE c2;
	static CommentsNEET c3;
	static Comments7th c7;
	static Comments8th c8;
	static Comments9th c9;
	static Comments10th c10;
	static Comments11th c11;
	static Comments12th c12;
	
    
    
	
	public static void main(String[] args) {	
		System.out.println("Enquiry Form!");
		SwingUtilities.invokeLater(() -> new Enquiry());
	}
	
	
	
	
	
	
	
	public void displayEnquiryForm() {
		
		f = new JFrame("Radiant Enquiry Form");
		f.setSize(1200, 800);
	        
		f.setBackground(Color.white);
		f.setLayout(null);
		
	    
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
		stgmail = new JLabel("Student Email(Optional): ");
		pgmail = new JLabel("Parent Email(Optional): ");
		source = new JLabel("How did you come to know about Radiant?");
		
		
		sname.setSize(100,20);
	    sname.setLocation(205,130);
	    
		stu_name = new JTextField();
		stu_name.setSize(200,20);
	    stu_name.setLocation(200,150);
		
        
	    pname.setSize(100,20);
	    pname.setLocation(455,130);
	    
        par_name = new JTextField();
        par_name.setSize(200,20);
	    par_name.setLocation(450,150);

	    
	    sch_name.setSize(100,20);
	    sch_name.setLocation(705,130);
	    
        school_name = new JTextField();
        school_name.setSize(300,20);
	    school_name.setLocation(700,150);

	    
	    grade_lvl.setSize(100,20);
	    grade_lvl.setLocation(205,235);
	    
	    grade = new JTextField();
	    grade.setSize(75,20);
	    grade.setLocation(200,255);
	    
	    
	    class_marks.setSize(200,20);
	    class_marks.setLocation(455,235);
	    
	    classMarks = new JTextField();
	    classMarks.setSize(200,20);
	    classMarks.setLocation(450,255);
	    
	    
	    int_course.setSize(200,20);
	    int_course.setLocation(705,235);
	    
	    intCourse = new JTextField();
	    intCourse.setSize(300,20);
	    intCourse.setLocation(700,255);
	    
	    
	    city_label.setSize(100,20);
	    city_label.setLocation(205,330);
	    
        city = new JTextField();
        city.setSize(200,20);
	    city.setLocation(200,350);
        
	    
	    str.setSize(100,20);
	    str.setLocation(455,330);
	    
        street = new JTextField();
        street.setSize(200,20);
	    street.setLocation(450,350);

	    
	    flt.setSize(100,20);
	    flt.setLocation(705,330);
	    
        flat = new JTextField();
        flat.setSize(150,20);
	    flat.setLocation(700,350);

	    
	    stPhoneNo.setSize(200,20);
	    stPhoneNo.setLocation(205,400);
	    
        st_phone = new JTextField();
        st_phone.setSize(200,20);
	    st_phone.setLocation(200,420);

	    
	    pPhoneNo.setSize(200,20);
	    pPhoneNo.setLocation(455,400);
	    
        p_phone = new JTextField();
        p_phone.setSize(200,20);
	    p_phone.setLocation(450,420);
	    
	    
	    stgmail.setSize(200,20);
	    stgmail.setLocation(205,470);

        stu_gmail = new JTextField();
        stu_gmail.setSize(200,20);
	    stu_gmail.setLocation(200,490);
	    
	    
	    pgmail.setSize(200,20);
	    pgmail.setLocation(455,470);

        par_gmail = new JTextField();
        par_gmail.setSize(200,20);
	    par_gmail.setLocation(450,490);

	    
	    source.setSize(400,20);
	    source.setLocation(205, 540);
	    
	    source_of_enquiry = new JTextField();
	    stu_gmail.setSize(300,20);
	    stu_gmail.setLocation(200,560);
        
        
        //submit button
        submit = new JButton("Submit");
        submit.setSize(150,20);
	    submit.setLocation(400,650);
        submit.addActionListener(this);
        
        
        
        //menu bar + menu items/buttons to navigate to different screens
        mb = new JMenuBar();
        f.setJMenuBar(mb);
    
       
       
        triB = new JMenu("Menu");      
              
        display = new JMenuItem("Display");
        add = new JMenuItem("Add");
       
       

        triB.add(display);
        triB.add(add);
        
        
        comments = new JMenu("Comments");
        comm_JEE = new JMenuItem("JEE");
        comm_NEET = new JMenuItem("NEET");
        comm7th = new JMenuItem("7th");
        comm8th = new JMenuItem("8th");
        comm9th = new JMenuItem("9th");
        comm10th = new JMenuItem("10th");
        comm11th = new JMenuItem("11th");
        comm12th = new JMenuItem("12th");
        

        
        comments.add(comm7th); 
        comments.add(comm8th); 
        comments.add(comm9th); 
        comments.add(comm10th); 
        comments.add(comm11th); 
        comments.add(comm12th); 
        comments.add(comm_JEE);
        comments.add(comm_NEET);
        
        add_admin = new JMenuItem("Add Admin");
        admins = new JMenuItem("Admins");
        
        
        profile = new JMenu("Profile");   
        profile.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        logout = new JMenuItem("Logout");

        profile.add(admins);
        profile.add(add_admin);
        profile.add(logout);
        

        display.addActionListener(this);
        logout.addActionListener(this);
        add_admin.addActionListener(this);
        admins.addActionListener(this);
        
        
        comm_JEE.addActionListener(this);
        comm_NEET.addActionListener(this);
        comm7th.addActionListener(this);
        comm8th.addActionListener(this);
        comm9th.addActionListener(this);
        comm10th.addActionListener(this);
        comm11th.addActionListener(this);
        comm12th.addActionListener(this);
        
        
        
        mb.add(triB);
        mb.add(comments);
        mb.add(Box.createHorizontalGlue());
        mb.add(profile);
                
        
        
        grade.addMouseListener(this);
        grade.addActionListener(this);
        gradesMenu = new JPopupMenu("Grades");
        
        //gradesMenu.setSize(30,100);
        //gradesMenu.setLocation(200,255);
        
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
        f.add(source);
        
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
        f.add(source_of_enquiry);
        f.add(submit);
        
        
        
        
        //adding popup menus
        f.add(gradesMenu);
        
        //adding menubar
        f.add(mb);
        
        

        
      
		
		f.setVisible(true);
        
        
        
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == submit) {
			
			System.out.println("SUBMIT BUTTON CLICKED");
			
			this.st_name = this.stu_name.getText();
			this.p_name = this.par_name.getText();
			this.school = this.school_name.getText();
			this.gr_lvl = this.grade.getText();
			this.marks = this.classMarks.getText();
			this.interested_course = this.intCourse.getText();
			this.address = ""+this.flat.getText()+", "+this.street.getText()+", "+this.city.getText()+"";
			this.st_phone_no = this.st_phone.getText();
			this.p_phone_no = this.p_phone.getText();
			this.st_gmail = this.stu_gmail.getText();
			this.p_gmail = this.par_gmail.getText(); 
			
			
			//System.out.println("student name: "+st_name);
			//System.out.println("parent name: "+p_name);
			//System.out.println("school: "+school);
			//System.out.println("address:"+address);
			//System.out.println("student phone #: "+st_phone_no);
			//System.out.println("parent phone #"+p_phone_no);
			//System.out.println("student gmail: "+st_gmail);
			//System.out.println("parent gmail: "+p_gmail);
			
			
			String url = "jdbc:mysql://localhost:3306/mydb";
			String user = "root";
			String pw = "0Dinosaur";
			
			Date d = new Date();
			
			System.out.println("Today's Date: "+d);
			
			//JDBC connectivity setup
			try {
				
				String date = new SimpleDateFormat("yy/MM/dd").format(new Date()); 
				
				Class.forName("com.mysql.cj.jdbc.Driver");

			    Connection connection = DriverManager.getConnection(url, user, pw);
			    System.out.println("CONNECTION CREATED");

			    Statement statement = connection.createStatement();
			    System.out.println("CONNECTION ESTABLISHED");

			    String insertQuery = "INSERT INTO enquiries (st_name, p_name, school, class, prev_marks, interested_course, address, st_phone_no, p_phone_no, st_email, p_email, date_of_enquiry) VALUES ('"+ st_name + "', '" + p_name + "', '" + school + "', '" + gr_lvl + "', '" + marks + "', '" + interested_course + "',  '" + address + "', '" + st_phone_no+ "', '" + p_phone_no + "', '" + st_gmail + "', '" + p_gmail + "', '"+ date+"')"; //new SimpleDateFormat("yy/MM/dd").format(new Date()) + "')";
		        
			    String commentsQuery = "";
			    
			    
			    
			    
			    //CONDITIONALS TO ADD INTO SPECIFIC COMMENTS TABLE -------------------------------------------------------------------------------------------
		        
			    if(this.interested_course.equals("JEE")) {
		        	commentsQuery = "INSERT INTO commentsJEE (st_name, date_of_enq, comment1, dateC1, comment2, dateC2, comment3, dateC3, latest_status) VALUES ('"+ st_name + "', '"+ date+"','none','n/a','none','n/a','none','n/a','none')";
		        
		        } else if(this.interested_course.equals("NEET")) {
		        	commentsQuery = "INSERT INTO commentsNEET (st_name, date_of_enq, comment1, dateC1, comment2, dateC2, comment3, dateC3, latest_status) VALUES ('"+ st_name + "', '"+ date+"','none','n/a','none','n/a','none','n/a','none')";
		        	
		        } else if(this.interested_course.equals("7")) {
		        	commentsQuery = "INSERT INTO comments7th (st_name, date_of_enq, comment1, dateC1, comment2, dateC2, comment3, dateC3, latest_status) VALUES ('"+ st_name + "', '"+ date+"','none','n/a','none','n/a','none','n/a','none')";
		        	
		        } else if(this.interested_course.equals("8")) {
		        	commentsQuery = "INSERT INTO comments8th (st_name, date_of_enq, comment1, dateC1, comment2, dateC2, comment3, dateC3, latest_status) VALUES ('"+ st_name + "', '"+ date+"','none','n/a','none','n/a','none','n/a','none')";
		        	
		        } else if(this.interested_course.equals("9")) {
		        	commentsQuery = "INSERT INTO comments9th (st_name, date_of_enq, comment1, dateC1, comment2, dateC2, comment3, dateC3, latest_status) VALUES ('"+ st_name + "', '"+ date+"','none','n/a','none','n/a','none','n/a','none')";
		        	
		        } else if(this.interested_course.equals("10")) {
		        	commentsQuery = "INSERT INTO comments10th (st_name, date_of_enq, comment1, dateC1, comment2, dateC2, comment3, dateC3, latest_status) VALUES ('"+ st_name + "', '"+ date+"','none','n/a','none','n/a','none','n/a','none')";
		        	
		        } else if(this.interested_course.equals("11")) {
		        	commentsQuery = "INSERT INTO comments11th (st_name, date_of_enq, comment1, dateC1, comment2, dateC2, comment3, dateC3, latest_status) VALUES ('"+ st_name + "', '"+ date+"','none','n/a','none','n/a','none','n/a','none')";
		        	
		        } else if(this.interested_course.equals("12")) {
		        	commentsQuery = "INSERT INTO comments12th (st_name, date_of_enq, comment1, dateC1, comment2, dateC2, comment3, dateC3, latest_status) VALUES ('"+ st_name + "', '"+ date+"','none','n/a','none','n/a','none','n/a','none')";
		        	
		        }
		        
		        //---------------------------------------------------------------------------------------------------------------------------------------------
		        	
		        	
			    statement.executeUpdate(commentsQuery);
			    System.out.println(commentsQuery);
			    
		        statement.executeUpdate(insertQuery);
		        
		        System.out.println("QUERIES EXECUTED");
		        
			    connection.close();

				} catch(Exception err) {
					System.out.println(err);
				}	
			
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
			
			
		} else if(e.getSource()==display) {
			
			System.out.println("DISPLAY BUTTON CLICKED");
			this.f.dispose();
			
			d = new Display();
			d.displayAll();
			
		} else if(e.getSource()==logout) {
			
			System.out.println("LOGOUT BUTTON CLICKED");
			this.f.dispose();
			
			l = new Login();
			l.displayLogin();
	        
		} else if(e.getSource()==admins){
		
			this.f.dispose();
			
			a4 = new Admin();
			a4.displayAdmins();
			
		} else if(e.getSource()==comm_JEE) {
			
			this.f.dispose();
			
			c2 = new CommentsJEE();
			
		} else if(e.getSource()==comm_NEET) {
			
			this.f.dispose();
			
			c3 = new CommentsNEET();
			
		} else if(e.getSource()==comm7th) {
			
			this.f.dispose();
			
			c7 = new Comments7th();
			
		} else if(e.getSource()==comm8th) {
			
			this.f.dispose();
			
			c8 = new Comments8th();
			
		} else if(e.getSource()==comm9th) {
			
			this.f.dispose();
			
			c9 = new Comments9th();
			
		} else if(e.getSource()==comm10th) {
			
			this.f.dispose();
			
			c10 = new Comments10th();
			
		} else if(e.getSource()==comm11th) {
			
			this.f.dispose();
			
			c11 = new Comments11th();
			
		} else if(e.getSource()==comm12th) {
			
			this.f.dispose();
			
			c12 = new Comments12th();
			
		} else  if(e.getSource()==seven) {
			grade.setText("7");
		} else if(e.getSource()==eight) {
			grade.setText("8");
		} else if(e.getSource()==nine) {
			grade.setText("9");
		} else if(e.getSource()==ten) {
			grade.setText("10");
		} else if(e.getSource()==eleven) {
			grade.setText("11");
		} else if(e.getSource()==twelve) {
			grade.setText("12");
		} else if(e.getSource()==seventh) {
			intCourse.setText("7");
		} else if(e.getSource()==eighth) {
			intCourse.setText("8");
		} else if(e.getSource()==ninth) {
			intCourse.setText("9");
		} else if(e.getSource()==tenth) {
			intCourse.setText("10");
		} else if(e.getSource()==eleventh_JEE) {
			intCourse.setText("11 + JEE");
		} else if(e.getSource()==twelfth_JEE) {
			intCourse.setText("12 + JEE");
		} else if(e.getSource()==eleventh_NEET) {
			intCourse.setText("11 + NEET");
		} else if(e.getSource()==twelfth_NEET) {
			intCourse.setText("12 + NEET");
		} else if(e.getSource()==JEE) {
			intCourse.setText("JEE");
		} else if(e.getSource()==NEET) {
			intCourse.setText("NEET");
		} 
		
		
	}







	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==grade) {
			gradesMenu.show(f, 205, 325);			
		} else if(e.getSource()==intCourse) {
			interested_courses.show(f,705,325);
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


