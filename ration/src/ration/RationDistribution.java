package ration;

import java.util.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class RationDistribution extends JFrame implements ActionListener
{
    JLabel rtitle,rtitle1,rtitle2,rtitle3,rtitle4,ritem1,ritem2,ritem3,ritem4,ritem5,ritem6,rp1,rp2,rp3,rp4,rp5,rp6;
    JTextField rt_item1,rt_item2,rt_item3,rt_item4,rt_item5,rt_item6;
    JButton r_cal,r_clr,r_submit,r_save;
    int ans = 0,rno=0;
    public RationDistribution(int rno)
    {
    	this.rno = rno;
        rtitle = new JLabel("ITEMS LIST");
        rtitle1 = new JLabel("Name");
        rtitle2 = new JLabel("Price per(kg)");
        rtitle3 = new JLabel("Quantity");
        rtitle4 = new JLabel("");
        rp1 = new JLabel("1");
        rp2 = new JLabel("8");
        rp3 = new JLabel("15");
        rp4 = new JLabel("30");
        rp5 = new JLabel("30");
        rp6 = new JLabel("25");
        ritem1 = new JLabel("Rice");
        rt_item1 = new JTextField(5);
        ritem2 = new JLabel("Wheet");
        rt_item2 = new JTextField(5);
        ritem3 = new JLabel("Sugar");
        rt_item3 = new JTextField(5);
        ritem4 = new JLabel("Toor Dhal");
        rt_item4 = new JTextField(5);
        ritem5 = new JLabel("Urid Dhal");
        rt_item5 = new JTextField(5);
        ritem6 = new JLabel("Palmolein OIL");
        rt_item6 = new JTextField(5);
        r_cal = new JButton("Calculate");
        r_clr = new JButton("Clear");
        r_save = new JButton("Save");
       JPanel rpan = new JPanel();
       rpan.setLayout(null);
       rpan.add(rtitle);rtitle.setBounds(100,10,100,20);
       rpan.add(rtitle1);rtitle1.setBounds(10,40,100,20);
       rpan.add(rtitle2);rtitle2.setBounds(90,40,100,20);
       rpan.add(rtitle3);rtitle3.setBounds(190,40,100,20);
       rpan.add(ritem1);ritem1.setBounds(10,70,100,20);
       rpan.add(rp1);rp1.setBounds(120,70,100,20);
       rpan.add(rt_item1);rt_item1.setBounds(210,70,30,20);
       rpan.add(ritem2);ritem2.setBounds(10,100,100,20);
       rpan.add(rp2);rp2.setBounds(120,100,100,20);
       rpan.add(rt_item2);rt_item2.setBounds(210,100,30,20);
       rpan.add(ritem3);ritem3.setBounds(10,130,100,20);
       rpan.add(rp3);rp3.setBounds(120,130,100,20);
       rpan.add(rt_item3);rt_item3.setBounds(210,130,30,20);
       rpan.add(ritem4);ritem4.setBounds(10,160,100,20);
       rpan.add(rp4);rp4.setBounds(120,160,100,20);
       rpan.add(rt_item4);rt_item4.setBounds(210,160,30,20);
       rpan.add(ritem5);ritem5.setBounds(10,190,100,20);
       rpan.add(rp5);rp5.setBounds(120,190,100,20);
       rpan.add(rt_item5);rt_item5.setBounds(210,190,30,20);
       rpan.add(ritem6);ritem6.setBounds(10,220,100,20);
       rpan.add(rp6);rp6.setBounds(120,220,100,20);
       rpan.add(rt_item6);rt_item6.setBounds(210,220,30,20);
       rpan.add(r_clr);r_clr.setBounds(20,270,100,20);r_cal.addActionListener(this);
       rpan.add(r_cal);r_cal.setBounds(140,270,100,20);r_clr.addActionListener(this);
       r_save.addActionListener(this);
       rpan.add(rtitle4);rtitle4.setBounds(100,300,180,20);
       rpan.add(r_save);
       add(rpan);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String rd = ae.getActionCommand();
        if(rd.equals("Clear"))
        {
            rt_item1.setText("");
            rt_item2.setText("");
            rt_item3.setText("");
            rt_item4.setText("");
            rt_item5.setText("");
            rt_item6.setText("");
            rtitle4.setText("");
        }else if(rd.equals("Save")) {
    		String databaseURL = "jdbc:ucanaccess:///C://Users//rocks//Documents//ration.accdb";
            
            try (Connection connection = DriverManager.getConnection(databaseURL)) {
            	
            	String sql = "INSERT INTO bill (ration_number,Amount,bill_date) VALUES (?,?,NOW())";
                
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,rno );
                preparedStatement.setInt(2,ans );
                 
                 int row = preparedStatement.executeUpdate();
                 
                if (row > 0) {
             
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        	dispose();
        }
        else{
        if(rt_item1.getText().equals("")||rt_item2.getText().equals("")||rt_item3.getText().equals("")||
        rt_item4.getText().equals("")||rt_item5.getText().equals("")||rt_item6.getText().equals(""))
        {
           JOptionPane.showMessageDialog(this,"Please fill the details","ERROR",JOptionPane.WARNING_MESSAGE);
        }
        else{
             ans = Integer.parseInt(rt_item1.getText())*1+ Integer.parseInt(rt_item2.getText())*8 + Integer.parseInt(rt_item3.getText())*15 +
             Integer.parseInt(rt_item4.getText())*30 + Integer.parseInt(rt_item5.getText())*30 + Integer.parseInt(rt_item6.getText())*25 ;
             rtitle4.setText("Total amount :- "+ans);
             r_save.setBounds(100,320,180,20);
        }
      }
    }
    public static void main(String argv[])
    {
        RationDistribution r = new RationDistribution(38);
        r.setVisible(true);
        r.setSize(400,400);
        r.setDefaultCloseOperation(EXIT_ON_CLOSE);
        r.setTitle("ITEM LIST");
    }
} 

