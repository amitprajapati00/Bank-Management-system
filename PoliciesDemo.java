import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class Policies implements ActionListener,KeyListener
{
JFrame f;
JLabel l1,l2,l3,l4;
JTextField t1,t2,t3,t4;
JButton b1,b2,b3;
Font f1;
ImageIcon im;
Connection con;
ResultSet rs;
PreparedStatement st;
String pnm,elb,tac,ppft;

Policies()
{

f=new JFrame("Admin Policies");
f.setSize(700,500);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image policy 2.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,700,500);
f.add(bg);

f1=new Font("Arial Black",Font.BOLD,14);

l1=new JLabel("Policy Name");
l1.setBounds(50,50,150,30);
l1.setForeground(Color.RED);
l1.setFont(f1);
bg.add(l1);

t1=new JTextField();
t1.setBounds(450,50,200,30);
t1.setFont(f1);
t1.addKeyListener(this);
bg.add(t1);

l2=new JLabel("Eligibleity");
l2.setBounds(50,120,100,30);
l2.setForeground(Color.RED);
l2.setFont(f1);
bg.add(l2);

t2=new JTextField();
t2.setBounds(450,120,200,30);
t2.setFont(f1);
t2.addKeyListener(this);
bg.add(t2);

l3=new JLabel("Terms and Condition");
l3.setBounds(50,190,180,30);
l3.setForeground(Color.RED);
l3.setFont(f1);
bg.add(l3);

t3=new JTextField();
t3.setBounds(450,190,200,30);
t3.setFont(f1);
t3.addKeyListener(this);
bg.add(t3);

l4=new JLabel("Policy Profit");
l4.setBounds(50,260,150,30);
l4.setForeground(Color.RED);
l4.setFont(f1);
bg.add(l4);

t4=new JTextField();
t4.setBounds(450,260,200,30);
t4.setFont(f1);
t4.addKeyListener(this);
bg.add(t4);

b1=new JButton("Submit");
b1.setBounds(50,400,100,30);
b1.setFont(f1);
b1.addActionListener(this);
bg.add(b1);

b2=new JButton("Clear");
b2.setBounds(300,400,100,30);
b2.setFont(f1);
b2.addActionListener(this);
bg.add(b2);

b3=new JButton("Back");
b3.setBounds(550,400,100,30);
b3.setFont(f1);
b3.addActionListener(this);
bg.add(b3);

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

}//constructor

public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==b1)
{
pnm=t1.getText();
elb=t2.getText();
tac=t3.getText();
ppft=t4.getText();

try
{
st=con.prepareStatement("insert into policy values(?,?,?,?)");
st.setString(1,pnm);
st.setString(2,elb);
st.setString(3,tac);
st.setString(4,ppft);
st.executeUpdate();

JOptionPane.showMessageDialog(f,"Data store successfully");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t1.requestFocus();

}//try

catch(Exception e)
{
System.out.print(e);
}//catch
}//if b1

else if(ae.getSource()==b2)
{
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t1.requestFocus();
}//b2

else if(ae.getSource()==b3)
{
JOptionPane.showMessageDialog(f,"Press ok to go to Home");
MainPolicy l=new MainPolicy();
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
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c==32))
{

}

else {

ke.consume();
}
}

else if(ke.getSource()==t2)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c==32))
{

}

else {

ke.consume();
}
}
else if(ke.getSource()==t3)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c==32))
{

}

else {

ke.consume();
}
}
else if(ke.getSource()==t4)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c==32))
{

}

else {

ke.consume();
}
}

}//key method
}//class


class PoliciesDemo
{
public static void main(String[] a)
{
Policies l=new Policies();
}
}