import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class DeleteOpenAccount implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
JTextArea txtaddr,a1,a2;
JRadioButton r1,r2;
JButton b1,b2,b3,b4;
Font f1;
ImageIcon im;
Connection con;
PreparedStatement st;
ResultSet rs;
ButtonGroup rg;
String acc,cn,addr,gen,adhar,acctyp,email,pan,inibal,ifsc,nation,date,mob;


DeleteOpenAccount()
{
f=new JFrame("Delete Customer Detail");
f.setSize(1100,750);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image delete account.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,1100,750);
f.add(bg);

f1=new Font("Arial Black",Font.BOLD,14);

l1=new JLabel("Account No.");
l1.setBounds(50,50,150,30);
l1.setFont(f1);
l1.setForeground(Color.RED);
bg.add(l1);

t1=new JTextField();
t1.setBounds(250,50,200,30);
t1.setFont(f1);
t1.addKeyListener(this);
bg.add(t1);
t1.addKeyListener(this);

l2=new JLabel("Customer Name");
l2.setBounds(50,130,150,30);
l2.setFont(f1);
l2.setForeground(Color.RED);
bg.add(l2);

t2=new JTextField();
t2.setBounds(250,130,200,30);
t2.setFont(f1);
bg.add(t2);
t2.addKeyListener(this);

l3=new JLabel("Address");
l3.setBounds(50,210,150,30);
l3.setFont(f1);
l3.setForeground(Color.RED);
bg.add(l3);

txtaddr=new JTextArea();
txtaddr.setBounds(250,210,200,70);
txtaddr.setFont(f1);
bg.add(txtaddr);

l4=new JLabel("Gender");
l4.setBounds(50,410,150,30);
l4.setFont(f1);
l4.setForeground(Color.RED);
bg.add(l4);

rg=new ButtonGroup();
r1=new JRadioButton("Male");
r1.setBounds(250,410,150,30);
r1.setFont(f1);
bg.add(r1);

r2=new JRadioButton("Female");
r2.setBounds(250,450,150,30);
r2.setFont(f1);
bg.add(r2);

rg.add(r1);
rg.add(r2);

l5=new JLabel("Mobile No.");
l5.setBounds(650,50,150,30);
l5.setFont(f1);
l5.setForeground(Color.RED);
bg.add(l5);

t3=new JTextField();
t3.setBounds(850,50,200,30);
t3.setFont(f1);
bg.add(t3);
t3.addKeyListener(this);

l6=new JLabel("Aadhar No.");
l6.setBounds(650,130,150,30);
l6.setFont(f1);
l6.setForeground(Color.RED);
bg.add(l6);

t4=new JTextField();
t4.setBounds(850,130,200,30);
t4.setFont(f1);
bg.add(t4);
t4.addKeyListener(this);

l7=new JLabel("Account Type");
l7.setBounds(650,210,150,30);
l7.setFont(f1);
l7.setForeground(Color.RED);
bg.add(l7);

t5=new JTextField();
t5.setBounds(850,210,200,30);
t5.setFont(f1);
bg.add(t5);
t5.addKeyListener(this);

l8=new JLabel("E-mail ID");
l8.setBounds(650,290,150,30);
l8.setFont(f1);
l8.setForeground(Color.RED);
bg.add(l8);

t6=new JTextField();
t6.setBounds(850,290,200,30);
t6.setFont(f1);
bg.add(t6);

l9=new JLabel("PAN Card No.");
l9.setBounds(650,370,150,30);
l9.setFont(f1);
l9.setForeground(Color.RED);
bg.add(l9);

t7=new JTextField();
t7.setBounds(850,370,200,30);
t7.setFont(f1);
bg.add(t7);

l10=new JLabel("Initial Balance");
l10.setBounds(650,450,150,30);
l10.setFont(f1);
l10.setForeground(Color.RED);
bg.add(l10);

t8=new JTextField();
t8.setBounds(850,450,200,30);
t8.setFont(f1);
bg.add(t8);
t8.addKeyListener(this);

l11=new JLabel("IFSC Code");
l11.setBounds(650,530,150,30);
l11.setFont(f1);
l11.setForeground(Color.RED);
bg.add(l11);

t9=new JTextField();
t9.setBounds(850,530,200,30);
t9.setFont(f1);
bg.add(t9);

l12=new JLabel("Nationality");
l12.setBounds(50,530,150,30);
l12.setFont(f1);
l12.setForeground(Color.RED);
bg.add(l12);

t10=new JTextField();
t10.setBounds(250,530,200,30);
t10.setFont(f1);
t10.addKeyListener(this);
bg.add(t10);

l13=new JLabel("Date");
l13.setBounds(50,310,150,30);
l13.setFont(f1);
l13.setForeground(Color.RED);
bg.add(l13);

t11=new JTextField();
t11.setBounds(250,310,200,30);
t11.setFont(f1);
bg.add(t11);
t11.addKeyListener(this);

b1=new JButton("Delete");
b1.setBounds(150,650,100,30);
b1.setFont(f1);
b1.addActionListener(this);
bg.add(b1);

b2=new JButton("Reset");
b2.setBounds(470,650,100,30);
b2.setFont(f1);
b2.addActionListener(this);
bg.add(b2);

b3=new JButton("Back");
b3.setBounds(850,650,100,30);
b3.setFont(f1);
b3.addActionListener(this);
bg.add(b3);

b4=new JButton("Search");
b4.setBounds(500,50,100,30);
b4.setFont(f1);
b4.addActionListener(this);
bg.add(b4);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bankproject","root","");
}
catch(Exception e)
{
System.out.print(e);
}

f.setVisible(true);
t1.requestFocus();
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
acc=t1.getText();
try
{
st=con.prepareStatement("delete from openaccount where account_number=?");
st.setString(1,acc);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Delete Successfully");

t1.setText("");
t2.setText("");
txtaddr.setText("");
r1.setSelected(false);
r2.setSelected(false);
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
t10.setText("");
t11.setText("");
t1.requestFocus();
}
catch(Exception e)
{
System.out.print(e);
}
}
else if(ae.getSource()==b2)
{
t1.setText("");
t2.setText("");
txtaddr.setText("");
r1.setSelected(false);
r2.setSelected(false);
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
t10.setText("");
t11.setText("");

t1.requestFocus();
}

else if(ae.getSource()==b3)
{
MainOpenAccount mn=new MainOpenAccount();
f.dispose();
}//else if b3
else if(ae.getSource()==b4)
{
acc=t1.getText();
try
{
st=con.prepareStatement("select * from openaccount where account_number=?");
st.setString(1,acc);
rs=st.executeQuery();
if(rs.next())
{
cn=rs.getString(2);
addr=rs.getString(3);
gen=rs.getString(5);
mob=rs.getString(7);
adhar=rs.getString(8);
acctyp=rs.getString(9);
email=rs.getString(10);
pan=rs.getString(11);
inibal=rs.getString(12);
ifsc=rs.getString(13);
nation=rs.getString(6);
date=rs.getString(4);
t2.setText(cn);
txtaddr.setText(addr);
r1.setSelected(false);
r2.setSelected(false);
t5.setText(mob);
t6.setText(adhar);
t7.setText(acctyp);
t8.setText(email);
t9.setText(pan);
t10.setText(inibal);
t11.setText(ifsc);
t4.setText(nation);
t3.setText(date);
}
else
{
JOptionPane.showMessageDialog(f,"Invalid Account ID");
}
}
catch(Exception e)
{
System.out.print(e);
}
}
}

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
if(c>='0' && c<='9') 
{

}

else {

ke.consume();
}}
else if(ke.getSource()==t4)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
{

}

else {

ke.consume();
}
}
else if(ke.getSource()==t5)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c==32))
{

}

else {

ke.consume();
}
}
else if(ke.getSource()==t8)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
{

}

else {

ke.consume();
}
}
else if(ke.getSource()==t11)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
{

}

else {

ke.consume();
}
}
else if(ke.getSource()==t10)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z'))
{

}

else {

ke.consume();
}
}
}



}

class DeleteOpenAccountDemo
{
public static void main(String[] s)
{
DeleteOpenAccount l=new DeleteOpenAccount();
}
}