import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class BalanceEnquiery implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3;
JTextField t1,t2,t3;
JButton b1,b2,b3,b4;
Font f1;
Connection con;
BalanceEnquiery()
{
f=new JFrame("Balance Check");
f.setSize(530,500);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

f1=new Font("Arial Black",Font.BOLD,14);

l1=new JLabel("Account No.");
l1.setBounds(50,50,130,30);
l1.setFont(f1);
l1.setForeground(Color.BLUE);
f.add(l1);

t1=new JTextField();
t1.setBounds(250,50,100,30);
t1.setFont(f1);
f.add(t1);
t1.addKeyListener(this);

l2=new JLabel("Customer Name");
l2.setBounds(50,130,150,30);
l2.setFont(f1);
l2.setForeground(Color.BLUE);
f.add(l2);

t2=new JTextField();
t2.setBounds(250,130,200,30);
t2.setFont(f1);
f.add(t2);
t2.addKeyListener(this);

l3=new JLabel("Total Balance");
l3.setBounds(50,200,150,30);
l3.setFont(f1);
l3.setForeground(Color.BLUE);
f.add(l3);

t3=new JTextField();
t3.setBounds(250,210,200,30);
t3.setFont(f1);
f.add(t3);
t3.addKeyListener(this);

b1=new JButton("Entery");
b1.setBounds(60,300,100,30);
b1.setFont(f1);
f.add(b1);

b2=new JButton("Back");
b2.setBounds(220,300,100,30);
b2.setFont(f1);
b2.addActionListener(this);
f.add(b2);

b3=new JButton("Reset");
b3.setBounds(360,300,100,30);
b3.setFont(f1);
b3.addActionListener(this);
f.add(b3);

b4=new JButton("Search");
b4.setBounds(360,50,100,30);
b4.setFont(f1);
b4.addActionListener(this);
f.add(b4);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bankproject","root","");
}//try

catch(Exception e)
{
System.out.print(e);
}//catch

f.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b3)
{
t1.setText("");
t2.setText("");
t3.setText("");
t1.requestFocus();
}//if 

else if(ae.getSource()==b2)
{
JOptionPane.showMessageDialog(f,"Press ok to go to Home");
Main mn=new Main();
f.dispose();
}//b3

}//action method

public void keyPressed(KeyEvent ke)
{
}

public void keyReleased(KeyEvent ke)
{
}

public void keyTyped(KeyEvent ke)
{
if(ke.getSource()==t1)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9') 
{

}

else {

ke.consume();
}}

else if(ke.getSource()==t2)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z'))
{

}

else {

ke.consume();
}
}

else if(ke.getSource()==t3)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
{

}

else {

ke.consume();
}}


}



}

class BalanceEnquieryDemo
{
public static void main(String[] a)
{
BalanceEnquiery bl=new BalanceEnquiery();
}
} 







