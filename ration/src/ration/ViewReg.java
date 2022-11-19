package ration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewReg extends JFrame implements ActionListener{
	   JLabel f_name,f_no,f_age,f_aadhar,f_gender,title1,f_doorno,f_street,f_city,f_district,f_state,f_pincode,ftitle;
	   JTextField ft_name,ft_age,ft_no,ft_aadhar,ft_doorno,ft_street,ft_city,ft_district,ft_state,ft_pincode;
	   JButton submit; 
	   JRadioButton b1,b2,b3;
	   ButtonGroup bg;
	   DefaultTableModel dtm;
	   JTable tab;
	   JScrollPane sp;
	   String row[] = {"Name","Age","Gender","Relationship","Aadhar No"};
	   JDBCAccess j = new JDBCAccess();
	   int rt=0;
	   public ViewReg() {

		     title1 = new JLabel("REGISTERATION FORM");
		     ftitle = new JLabel("FAMILY MEMBERS DETAILS ");
		     f_name = new JLabel("Name :- ");
		     ft_name = new JTextField(20);
		     f_age = new JLabel("Enter Age:"); 
		     ft_age = new JTextField(10);
		     f_no= new JLabel("Phone no :-  ");
		      ft_no = new JTextField(20);
		     f_gender = new JLabel("Gender :- ");
		      b1 = new JRadioButton("Male");
		      b2 = new JRadioButton("Female");
		      b3 = new JRadioButton("others");
		      f_aadhar = new JLabel("Aadhar no :- ");
		      ft_aadhar = new JTextField(20);
		      bg = new ButtonGroup();
		      bg.add(b1);bg.add(b2);bg.add(b3);
		      submit = new JButton("Close");
		      submit.addActionListener(this);
		       f_doorno = new JLabel("Door No :- ");
		       f_street = new JLabel("Street :- ");
		       f_city = new JLabel("City :- ");
		       f_district = new JLabel("District :- ");
		       f_state = new JLabel("State :- ");
		       f_pincode = new JLabel("Pincode :- ");
		       ft_doorno = new JTextField(15);  
		       ft_street = new JTextField(25);
		       ft_city = new JTextField(20);
		       ft_district = new JTextField(20);
		       ft_state = new JTextField(20);
		       ft_pincode = new JTextField(20);
		       dtm = new DefaultTableModel();
		       tab = new JTable(dtm);
		       dtm.addColumn("NAME");
		       dtm.addColumn("AGE");
		       dtm.addColumn("GENDER");
		       dtm.addColumn("RELATIONSHIP");
		       dtm.addColumn("AADHAR NO ");
		       sp = new JScrollPane(tab);
		       JPanel pan = new JPanel();
		      pan.setLayout(null);
		      pan.add(title1);title1.setBounds(120,10,150,20);
		      pan.add(f_name);f_name.setBounds(10,40,100,20);
		      pan.add(ft_name);ft_name.setBounds(80,40,100,20);
		      pan.add(f_age);f_age.setBounds(10,80,100,20);
		      pan.add(ft_age);ft_age.setBounds(80,80,100,20);
		      pan.add(f_no);f_no.setBounds(10,120,100,20);
		      pan.add(ft_no);ft_no.setBounds(80,120,100,20);
		      pan.add(f_gender);f_gender.setBounds(10,160,100,20);
		      pan.add(b1);b1.setBounds(80,160,60,20);
		      pan.add(b2);b2.setBounds(140,160,70,20);
		      pan.add(b3);b3.setBounds(210,160,60,20);
		      pan.add(f_aadhar);f_aadhar.setBounds(10,200,100,20);       
		      pan.add(ft_aadhar);ft_aadhar.setBounds(90,200,100,20);
		      pan.add(f_doorno);f_doorno.setBounds(10,240,100,20);
		      pan.add(ft_doorno);ft_doorno.setBounds(80,240,100,20);  
		      pan.add(f_street);f_street.setBounds(220,240,100,20);
		      pan.add(ft_street);ft_street.setBounds(290,240,100,20);
		      pan.add(f_city);f_city.setBounds(10,280,100,20);
		      pan.add(ft_city);ft_city.setBounds(80,280,100,20);
		      pan.add(f_district);f_district.setBounds(220,280,100,20);
		      pan.add(ft_district);ft_district.setBounds(290,280,100,20);
		      pan.add(f_state);f_state.setBounds(10,320,100,20);
		      pan.add(ft_state);ft_state.setBounds(80,320,100,20);
		      pan.add(f_pincode);f_pincode.setBounds(220,320,100,20);
		      pan.add(ft_pincode);ft_pincode.setBounds(290,320,100,20);
		      pan.add(ftitle);ftitle.setBounds(10,420,250,20);
		      pan.add(sp);sp.setBounds(10,460,650,150);
		      pan.add(submit);submit.setBounds(80,630,100,20);
		      add(pan);
			   ft_name.setEditable(false);
			   ft_age.setEditable(false);
			   ft_aadhar.setEditable(false);
			   ft_no.setEditable(false);
			   ft_doorno.setEditable(false);
			   ft_street.setEditable(false);
			   ft_district.setEditable(false);
			   ft_state.setEditable(false);
			   ft_city.setEditable(false); 
			   ft_pincode.setEditable(false);
		   
	   }
	   public ViewReg(int t) {
		   this();
		 String databaseURL = "jdbc:ucanaccess:///C://Users//rocks//Documents//ration.accdb";
		   
		   try (Connection connection = DriverManager.getConnection(databaseURL)) {
		     Statement stmt=connection.createStatement();  
		     ResultSet rs=stmt.executeQuery("select * from rationcard where ration_number="+t);  
		     while(rs.next()) {
		   ft_name.setText(rs.getString(2));
		   ft_age.setText(""+rs.getInt(3));
		   ft_aadhar.setText(""+rs.getLong(4));
		   ft_no.setText(""+rs.getString(7));
		   ft_doorno.setText(""+rs.getString(8));
		   ft_street.setText(rs.getString(9));
		   ft_district.setText(rs.getString(10));
		   ft_state.setText(rs.getString(11));
		   ft_city.setText(rs.getString(12)); 
		   ft_pincode.setText(""+rs.getString(13));
		   
			  String ts = rs.getString(6);
	         if(ts.equals("M")) {
	         	b1.setSelected(true);
	         }else if(ts.equals("F")) {
	          	b2.setSelected(true);
	         }else  {
	          	b3.setSelected(true);
	         }
		    }
		    b1.setEnabled(false);
		    b2.setEnabled(false);
		    b3.setEnabled(false); 
	    	 System.out.println("hii "+t);
		     Statement stmt2=connection.createStatement();  
		     ResultSet rs2=stmt2.executeQuery("select * from member where ration_number="+t);  
		     while(rs2.next()) {
		    	 dtm.addRow(new Object[]{rs2.getString(2),rs2.getString(3),rs2.getString(7),rs2.getString(5),rs2.getString(4)});
		    	 System.out.println("hii");
		     }
		   } catch (SQLException ex) {
		     ex.printStackTrace();
		   }
		   tab.setEnabled(false);

	   }
	   public void actionPerformed(ActionEvent ae)
	   {
	        String click = ae.getActionCommand();
	       if(click.equals("Close"))
	       {
	    	   dispose();
	       }
	   }

	   public static void main(String argc[])
	   {
	      ViewReg l = new ViewReg(40);
	      l.setSize(700,700);
	      l.setVisible(true);
	      l.setTitle("Register form");
	      l.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   }
}