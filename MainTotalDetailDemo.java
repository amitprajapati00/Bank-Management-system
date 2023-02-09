import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainTotalDetail implements ActionListener
{
JFrame f;
JButton b1,b2,b3,b4;
JLabel l1;
Font f1,f2;
ImageIcon im;

MainTotalDetail()
{
	f=new JFrame("SAP Bank");
	f.setSize(500,500);
	f.setResizable(false);
	f.setLocationRelativeTo(null);
	f.setLayout(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image MainTotal .jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,500,500);
f.add(bg);


f1=new Font("Arial Black",Font.BOLD,14);
f2=new Font("Arial Black",Font.BOLD,22);

l1=new JLabel("Total Details");
l1.setBounds(100,50,300,30);
l1.setFont(f2);
l1.setForeground(Color.RED);
bg.add(l1);

b1=new JButton("Account Details");
b1.setBounds(125,150,250,30);
b1.setFont(f1);
b1.addActionListener(this);
//b1.setForeground(Color.YELLOW);
bg.add(b1);
 
b2=new JButton("Loan Details");
b2.setBounds(125,220,250,30);
b2.addActionListener(this);
b2.setFont(f1);
bg.add(b2);

b3=new JButton(" Policy Details");
b3.setBounds(125,300,250,30);
b3.addActionListener(this);
b3.setFont(f1);
bg.add(b3);

b4=new JButton("Back");
b4.setBounds(200,380,100,30);
b4.setFont(f1);
b4.addActionListener(this);
bg.add(b4);

 
f.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
JOptionPane.showMessageDialog(f,"Welcome to admine policy detail");
TotalAccount ta=new TotalAccount();
f.dispose();
}//b1

else if(ae.getSource()==b2)
{
JOptionPane.showMessageDialog(f,"If you to change something in admin policy details?press ok");
TotalCustomerLoan tl=new TotalCustomerLoan();
f.dispose();
}//b2

else if(ae.getSource()==b3)
{
JOptionPane.showMessageDialog(f,"If you to delete policy details?press ok");
TotalCustomerPolicy tp=new TotalCustomerPolicy();
f.dispose();
}//b3

else if(ae.getSource()==b4)
{
Main y=new Main();
f.dispose();
}//b4
}//action method
}//class
class MainTotalDetailDemo
{
public static void main(String[] a)
{
MainTotalDetail l=new MainTotalDetail();
}
}