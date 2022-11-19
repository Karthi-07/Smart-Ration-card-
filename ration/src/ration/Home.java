package ration;

import java.util.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;

// Main class (home)

public class Home extends JFrame implements ActionListener
{
    JLabel ht1,ht2,ht3,ht4;
    JButton hb1,hb2,hb3;

public Home()
{
       ht1 = new JLabel("GOVERNMENT OF TAMILNADU");
       ht2 = new JLabel("CIVIL SUPPLIES & CONSUMER PROTECTION DEPARTMENT");
       ht3 = new JLabel("FAMILY CARD");
       hb1 = new JButton("New Register");
       hb2 = new JButton("View User");
       hb3 = new JButton("Ration Distribution");
       JPanel hp1 = new JPanel();
       hp1.setLayout(null);
       hp1.add(ht1);ht1.setBounds(90,10,250,30);
       hp1.add(ht2);ht2.setBounds(20,50,350,30);
       hp1.add(ht3);ht3.setBounds(120,90,150,30);
       hp1.add(hb1);hb1.setBounds(70,150,180,30);hb1.addActionListener(this);
       hp1.add(hb2);hb2.setBounds(70,190,180,30);hb2.addActionListener(this);
       hp1.add(hb3);hb3.setBounds(70,230,180,30);hb3.addActionListener(this);
       add(hp1);
}
public void actionPerformed(ActionEvent ae)
{
  String hs = ae.getActionCommand(); 
  if(hs.equals("New Register"))
  {
    NewRegister l = new NewRegister();
    l.setSize(700,700);
    l.setVisible(true);
    l.setTitle("Register form");
    
  }
  else if(hs.equals("View User"))
  {
	  ViewUser u = new ViewUser();
	  u.setVisible(true);
	  u.setSize(400,400); 
  }
  else
  {
	  RationUser u = new RationUser();
	  u.setVisible(true);
	  u.setSize(400,400); 
  }
}
    public static void main (String argv[])
    {
        Home h = new Home();
        h.setVisible(true);
        h.setSize(400,400);
        h.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class ViewUser extends JFrame implements ActionListener
{
    JLabel vt1,vt2,vt3,vt4;
    JButton vb1,vb2;
    JTextField vtext;

public ViewUser()
{
       vt1 = new JLabel("GOVERNMENT OF TAMILNADU");
       vt2 = new JLabel("CIVIL SUPPLIES & CONSUMER PROTECTION DEPARTMENT");
       vt3 = new JLabel("FAMILY CARD");
       vt4 = new JLabel("Enter Ration Card no :-");
       vb1 = new JButton("submit");
       vb2 = new JButton("clear");
       vtext = new JTextField(20);
       JPanel vp1 = new JPanel();
       vp1.setLayout(null);
       vp1.add(vt1);vt1.setBounds(90,10,250,30);
       vp1.add(vt2);vt2.setBounds(20,50,350,30);
       vp1.add(vt3);vt3.setBounds(120,90,150,30);
       vp1.add(vt4);vt4.setBounds(20,140,200,30);
       vp1.add(vtext);vtext.setBounds(180,140,80,30);
       vp1.add(vb1);vb1.setBounds(120,190,80,20);vb1.addActionListener(this);
       vp1.add(vb2);vb2.setBounds(30,190,80,20);vb2.addActionListener(this);
       add(vp1);
}
public void actionPerformed(ActionEvent ae)
{ 
	String xyz = ae.getActionCommand();
	if(xyz.equals("clear")) {
	  vtext.setText("");
	  
	}
	else
	{
		String st = vtext.getText();
		if(st.length()>6) {
			if(st.substring(0,5).equalsIgnoreCase("TNSM0")) {
				int qd = Integer.parseInt(st.substring(5)+"");
					
				 ViewReg l = new ViewReg(qd);
			      l.setSize(700,700);
			      l.setVisible(true);
			      l.setTitle("View User");
			      l.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}else {
			    JOptionPane.showMessageDialog(this,"Enter correct number ","Error",JOptionPane.WARNING_MESSAGE);      
			       
			}
		}else {
		    JOptionPane.showMessageDialog(this,"Enter correct number ","Error",JOptionPane.WARNING_MESSAGE);      
		}

	}
}
}

class RationUser extends JFrame implements ActionListener
{
    JLabel vt1,vt2,vt3,vt4;
    JButton vb1,vb2;
    JTextField vtext;

public RationUser()
{
       vt1 = new JLabel("GOVERNMENT OF TAMILNADU");
       vt2 = new JLabel("CIVIL SUPPLIES & CONSUMER PROTECTION DEPARTMENT");
       vt3 = new JLabel("FAMILY CARD");
       vt4 = new JLabel("Enter Ration Card no :-");
       vb1 = new JButton("submit");
       vb2 = new JButton("clear");
       vtext = new JTextField(20);
       JPanel vp1 = new JPanel();
       vp1.setLayout(null);
       vp1.add(vt1);vt1.setBounds(90,10,250,30);
       vp1.add(vt2);vt2.setBounds(20,50,350,30);
       vp1.add(vt3);vt3.setBounds(120,90,150,30);
       vp1.add(vt4);vt4.setBounds(20,140,200,30);
       vp1.add(vtext);vtext.setBounds(180,140,80,30);
       vp1.add(vb1);vb1.setBounds(120,190,80,20);vb1.addActionListener(this);
       vp1.add(vb2);vb2.setBounds(30,190,80,20);vb2.addActionListener(this);
       add(vp1);
}

public static int checkrecord(int rat_no) {
	 String databaseURL = "jdbc:ucanaccess:///C://Users//rocks//Documents//ration.accdb";
     
     try (Connection connection = DriverManager.getConnection(databaseURL)) {
     PreparedStatement ps = connection.prepareStatement("SELECT * FROM bill where ration_number="+rat_no+" and MONTH(bill_date)= MONTH(NOW())");
     ResultSet rts = ps.executeQuery();
     if(rts.next()) {
    	 return 0;
     }
    return 1;
     } catch (SQLException ex) {
         ex.printStackTrace();
     }
     return -1;
}

public void actionPerformed(ActionEvent ae)
{ 
	String xyz = ae.getActionCommand();
	if(xyz.equals("clear")) {
	  vtext.setText("");
	}
	else
	{
		String st = vtext.getText();
		if(st.length()>6) {
		if(st.substring(0,5).equalsIgnoreCase("TNSM0")) {
			int qd = Integer.parseInt(st.substring(5)+"");
			if( checkrecord(qd)==1 ) {
				String opt = "";
				String databaseURL = "jdbc:ucanaccess:///C://Users//rocks//Documents//ration.accdb";
			     
			     try (Connection connection = DriverManager.getConnection(databaseURL)) {
			     PreparedStatement ps = connection.prepareStatement("SELECT * FROM rationcard where ration_number="+qd);
			     ResultSet rts = ps.executeQuery();
			     if(rts.next()) {
			    	 opt=rts.getString(14);
			     }
			     } catch (SQLException ex) {
			         ex.printStackTrace();
			     }
			     System.out.println(opt);
			     if(opt.equalsIgnoreCase("sugar")) {
			    	 RationDistribution2 rb = new RationDistribution2(qd);  
			    	 rb.setVisible(true);
			         rb.setSize(400,400);
			         rb.setDefaultCloseOperation(EXIT_ON_CLOSE);
			         rb.setTitle("ITEM LIST");
			    	
			     }else {
			    	 RationDistribution rb = new RationDistribution(qd);  
			    	 rb.setVisible(true);
			         rb.setSize(400,400);
			         rb.setDefaultCloseOperation(EXIT_ON_CLOSE);
			         rb.setTitle("ITEM LIST");
			     }
			 
				
			}else {
			    JOptionPane.showMessageDialog(this,"Already purchased this Month ","Alert",JOptionPane.WARNING_MESSAGE);   
				
			}
		}else {
		    JOptionPane.showMessageDialog(this,"Enter correct number ","Error",JOptionPane.WARNING_MESSAGE);      
		       
		}
		}else {
		    JOptionPane.showMessageDialog(this,"Enter correct number ","Error",JOptionPane.WARNING_MESSAGE);      
		       
		}
		

	}
}

}

