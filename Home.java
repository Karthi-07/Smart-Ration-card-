import java.util.*;
import java.awt.event.*;
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

  }
  else
  {
   RationDistribution r = new RationDistribution();
   r.setSize(700,700);
   r.setVisible(true);
   r.setTitle("Register form");
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
