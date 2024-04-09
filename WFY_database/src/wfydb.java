



import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.*;
import java.util.Date;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.*;






public class wfydb{
	
	
	static Enquiry enq;
	static Login login_init;
	static Home h;
	static Display d;
	static Remove rem;
	static Edit ed;
	static Admin a;
	static AddAdmin aa;
	static CommentsJEE c1;
	

	public wfydb() {
		
		
		
	}
	 
	public static void main(String[] args) {
		
		login_init = new Login();
		login_init.displayLogin();

		//enq = new Enquiry();
		//enq.displayEnquiryForm();	
		
		//d = new Display();		
		//d.displayAll();
		
		//rem = new Remove();
		//rem.setupEditableTable();
		
		//ed = new Edit();
		//ed.setupEditableTable();
		//ed.displayUpdateFields();

		//a = new Admin();
		//a.displayAdmins();
		
		//aa = new AddAdmin();
		
		//c1 = new CommentsJEE();
		
		
		
	}
	
	
	
}


















