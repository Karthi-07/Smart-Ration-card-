import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class NewRegister extends JFrame implements ActionListener
{
   JLabel f_name,f_no,f_age,f_aadhar,f_gender,title1,f_doorno,f_street,f_city,f_district,f_state,f_pincode,ftitle;
   JTextField ft_name,ft_age,ft_no,ft_aadhar,ft_doorno,ft_street,ft_city,ft_district,ft_state,ft_pincode;
   JButton addfam,sign,clr; 
   JRadioButton b1,b2,b3;
   ButtonGroup bg;
   DefaultTableModel dtm;
   JTable tab;
   JScrollPane sp;
   String row[] = {"Name","Age","Gender","Relationship","Aadhar No"};
  public NewRegister()
  {
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
      clr = new JButton("Clear");
      clr.addActionListener(this);
      addfam = new JButton("Add Members");
      addfam.addActionListener(this);
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
      pan.add(clr);clr.setBounds(80,380,100,20);
      pan.add(addfam);addfam.setBounds(210,380,120,20);
      pan.add(ftitle);ftitle.setBounds(10,420,250,20);
      pan.add(sp);sp.setBounds(10,460,650,350);
      add(pan);
   }
   public void actionPerformed(ActionEvent ae)
   {
        String click = ae.getActionCommand();
       int flag=0;
       if(click.equals("Clear"))
       {
          ft_no.setText("");
          ft_name.setText("");
          ft_aadhar.setText("");
          ft_age.setText("");
          ft_doorno.setText("");
          ft_street.setText("");
          ft_city.setText("");
          ft_district.setText("");
          ft_state.setText("");
          ft_pincode.setText("");
          bg.clearSelection();
        }       
       else
       { 
           if(ft_no.getText().equals("") || ft_name.getText().equals("") || ft_aadhar.getText().equals("") || ft_age.getText().equals("") || 
            ft_doorno.getText().equals("") || ft_street.getText().equals("") || ft_city.getText().equals("") || ft_district.getText().equals("") || ft_state.getText().equals("") || ft_pincode.getText().equals(""))
           {
                 JOptionPane.showMessageDialog(this,"Please fill the details","ERROR",JOptionPane.WARNING_MESSAGE);      
           }
           else
           { 
            class Addmember extends JFrame implements ActionListener
            {
              JLabel title,name,rel,age,gen,aadhar;
              JTextField t_name,t_rel,t_age,t_gen,t_aadhar;
              JButton sub_clr,sub;
              JRadioButton a,b,c; 
              ButtonGroup bg2;
              public Addmember()
              {
               title = new JLabel("Family members details");
               name = new JLabel("Name : -");
               t_name = new JTextField(20);
               age = new JLabel("Age :- ");
               t_age = new JTextField(20);
               gen = new JLabel("Gender");
               a=new JRadioButton("Male");b=new JRadioButton("Female");c=new JRadioButton("others");
               bg2 = new ButtonGroup();
               bg2.add(a);
               bg2.add(b);
               bg2.add(c);
               rel = new JLabel("RelationShip :- ");
               t_rel = new JTextField(20);
               aadhar=new JLabel("Aadhar no :- ");
               t_aadhar = new JTextField(20);
               sub = new JButton("Submit");
               sub.addActionListener(this);
               sub_clr = new JButton("Clear");
               sub_clr.addActionListener(this);
               JPanel pan1 = new JPanel();
               pan1.setLayout(null);
               pan1.add(title);title.setBounds(50,10,180,20);
               pan1.add(name);name.setBounds(10,40,100,20);
               pan1.add(t_name);t_name.setBounds(80,40,100,20);
               pan1.add(age);age.setBounds(10,80,100,20);
               pan1.add(t_age);t_age.setBounds(80,80,100,20);
               pan1.add(gen);gen.setBounds(10,120,100,20);
               pan1.add(a);a.setBounds(80,120,60,20);
               pan1.add(b);b.setBounds(140,120,70,20);
               pan1.add(c);c.setBounds(210,120,60,20);
               pan1.add(rel);rel.setBounds(10,160,100,20);
               pan1.add(t_rel);t_rel.setBounds(120,160,100,20);
               pan1.add(aadhar);aadhar.setBounds(10,200,100,20);
               pan1.add(t_aadhar);t_aadhar.setBounds(120,200,100,20);
               pan1.add(sub);sub.setBounds(30,240,100,20);
               pan1.add(sub_clr);sub_clr.setBounds(150,240,100,20); 
              add(pan1);
              }
             public void actionPerformed(ActionEvent ae)
             {
                String k = ae.getActionCommand();
                if(k.equals("Clear"))
                {
                   t_name.setText("");
                   t_rel.setText("");
                   t_age.setText("");
                   t_aadhar.setText("");
                   bg2.clearSelection();
                   sub.setEnabled(true);
                }
                else{
                   if(t_name.getText().equals("") || t_rel.getText().equals("") || t_aadhar.getText().equals("")|| t_age.getText().equals(""))
                     {
                        JOptionPane.showMessageDialog(this,"Please fill the details","ERROR",JOptionPane.WARNING_MESSAGE);      
                     }
                     else{ 
                        String cd="";
                        if(a.isSelected()) 
                             cd = "Male";
                        else if(b.isSelected())
                             cd = "Female"; 
                        else
                            cd = "others"; 
                          String ab = t_name.getText();
                          String bc = t_age.getText();
                          String de = t_rel.getText();
                          String ef = t_aadhar.getText();
                          dtm.addRow(new Object[]{ab,bc,cd,de,ef});
                         sub.setEnabled(false);
                    }
                }
             }
            }
            Addmember s = new Addmember();
            s.setLocation(420,40);
            s.setSize(400,400);
            s.setTitle("Family member details");
            s.setVisible(true);  
        }
     }
   }
   public static void main(String argc[])
   {
      NewRegister l = new NewRegister();
      l.setSize(700,700);
      l.setVisible(true);
      l.setTitle("Register form");
      l.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
}