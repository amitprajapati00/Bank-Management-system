import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class OpenAccount implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
JTextField t1,t2,t3,t4,t5,t6,t8,t9,t10,t11;
JComboBox t7;
JTextArea txtaddr;
JRadioButton r1,r2;
JButton b1,b2,b3,b4,b5;
Font f1;
ImageIcon im;
Connection con;
PreparedStatement st;
ResultSet rs;
ButtonGroup rg;
String acc,cn,addr,gen,adhar,acctyp,email,pan,inibal,ifsc,nation,date,mob;


OpenAccount()
{
f=new JFrame("Customer Detail");
f.setSize(1000,750);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image transaction.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,1000,750);
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
t1.setEditable(false);

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
f.add(txtaddr);

l4=new JLabel("Date");
l4.setBounds(50,310,150,30);
l4.setFont(f1);
l4.setForeground(Color.RED);
bg.add(l4);

t3=new JTextField();
t3.setBounds(250,310,200,30);
t3.setFont(f1);
bg.add(t3);
t3.addKeyListener(this);


l5=new JLabel("Gender");
l5.setBounds(50,370,150,30);
l5.setFont(f1);
l5.setForeground(Color.RED);
bg.add(l5);

rg=new ButtonGroup();
r1=new JRadioButton("Male");
r1.setBounds(250,370,150,30);
r1.setFont(f1);
bg.add(r1);

r2=new JRadioButton("Female");
r2.setBounds(250,430,150,30);
r2.setFont(f1);
bg.add(r2);

rg.add(r1);
rg.add(r2);

l6=new JLabel("Nationality");
l6.setBounds(50,510,150,30);
l6.setFont(f1);
l6.setForeground(Color.RED);
bg.add(l6);

t4=new JTextField();
t4.setBounds(250,510,200,30);
t4.setFont(f1);
t4.addKeyListener(this);
bg.add(t4);
t4.setForeground(Color.BLUE);
t4.addKeyListener(this);


l7=new JLabel("Mobile No.");
l7.setBounds(500,50,150,30);
l7.setFont(f1);
l7.setForeground(Color.RED);
bg.add(l7);

t5=new JTextField();
t5.setBounds(700,50,200,30);
t5.setFont(f1);
bg.add(t5);
t5.addKeyListener(this);


l8=new JLabel("Aadhar No.");
l8.setBounds(500,130,150,30);
l8.setFont(f1);
l8.setForeground(Color.RED);
bg.add(l8);

t6=new JTextField();
t6.setBounds(700,130,200,30);
t6.setFont(f1);
bg.add(t6);
t6.addKeyListener(this);

l9=new JLabel("Account Type");
l9.setBounds(500,210,150,30);
l9.setFont(f1);
l9.setForeground(Color.RED);
bg.add(l9);

t7=new JComboBox();
t7.setBounds(700,210,200,30);
t7.setFont(f1);
bg.add(t7);
t7.addKeyListener(this);

l10=new JLabel("E-mail ID");
l10.setBounds(500,290,150,30);
l10.setFont(f1);
l10.setForeground(Color.RED);
bg.add(l10);

t8=new JTextField();
t8.setBounds(700,290,200,30);
t8.setFont(f1);
bg.add(t8);

l11=new JLabel("PAN Card No.");
l11.setBounds(500,370,150,30);
l11.setFont(f1);
l11.setForeground(Color.RED);
bg.add(l11);

t9=new JTextField();
t9.setBounds(700,370,200,30);
t9.setFont(f1);
bg.add(t9);

l12=new JLabel("Initial Balance");
l12.setBounds(500,450,150,30);
l12.setFont(f1);
l12.setForeground(Color.RED);
bg.add(l12);

t10=new JTextField();
t10.setBounds(700,450,200,30);
t10.setFont(f1);
bg.add(t10);
t10.addKeyListener(this);

l13=new JLabel("IFSC Code");
l13.setBounds(500,530,150,30);
l13.setFont(f1);
l13.setForeground(Color.RED);
bg.add(l13);

t11=new JTextField();
t11.setBounds(700,530,200,30);
t11.setFont(f1);
bg.add(t11);

b1=new JButton("Submit");
b1.setBounds(150,650,100,30);
b1.setFont(f1);
b1.addActionListener(this);
bg.add(b1);

b2=new JButton("Reset");
b2.setBounds(470,650,100,30);
b2.setFont(f1);
b2.addActionListener(this);
bg.add(b2);

b5=new JButton("Back");
b5.setBounds(850,650,100,30);
b5.setFont(f1);
b5.addActionListener(this);
bg.add(b5);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bankproject","root","");
st=con.prepareStatement("select max(account_number)from openaccount");
rs=st.executeQuery();
if(rs.next())
{
acc=rs.getString(1);
acc=acc.substring(1);
int m=Integer.parseInt(acc)+1;
acc="1"+String.valueOf(m);
t1.setText(acc);
}//if

st=con.prepareStatement("select account_name from accountdetail");
rs=st.executeQuery();
while(rs.next())
{
t7.addItem(rs.getString(1));
}//while

}//try
catch(Exception e)
{
System.out.print(e.getMessage());
}
t2.requestFocus();
f.setVisible(true);
 }
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{

acctyp=t7.getSelectedItem().toString();
acc=t1.getText();
cn=t2.getText();
addr=txtaddr.getText();
if(r1.isSelected()==true)
gen="Male";
else
gen="Female";
mob=t5.getText();
adhar=t6.getText();
//acctyp=t7.getText();
email=t8.getText();
pan=t9.getText();
inibal=t10.getText();
ifsc=t11.getText();
date=t3.getText();
nation=t4.getText();

try
{
st=con.prepareStatement("insert into openaccount values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
st.setString(1,acc);
st.setString(2,cn);
st.setString(3,addr);
st.setString(5,gen);
st.setString(7,mob);
st.setString(8,adhar);
st.setString(9,acctyp);
st.setString(10,email);
st.setString(11,pan);
st.setString(12,inibal);
st.setString(13,ifsc);
st.setString(6,nation);
st.setString(4,date);
st.executeUpdate();

JOptionPane.showMessageDialog(f,"Data store Successfully");
acc=acc.substring(1);
int m=Integer.parseInt(acc)+1;
acc="1"+String.valueOf(m);
t1.setText(acc);
t2.setText("");
txtaddr.setText("");
r1.setSelected(false);
r2.setSelected(false);
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
//t7.setText("");
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
t2.setText("");
txtaddr.setText("");
r1.setSelected(false);
r2.setSelected(false);
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
//t7.setText("");
t8.setText("");
t9.setText("");
t10.setText("");
t11.setText("");
t1.requestFocus();
}

if(ae.getSource()==b5)
{
MainOpenAccount mn=new MainOpenAccount();
f.dispose();
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
if((c>='a' && c<='z') || (c>='A' && c<='Z') ||(c==32))
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
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c==32))
{
}

else {

ke.consume();
}
}
else if(ke.getSource()==t5)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9') 
{

}

else {

ke.consume();
}
}
else if(ke.getSource()==t6)
{
char c=ke.getKeyChar();
if((c>='0' && c<='9') || (c=='.') || (c=='%'))
{

}

else {

ke.consume();
}
}
else if(ke.getSource()==t11)
{
char c=ke.getKeyChar();
if((c>='0' && c<='9') || (c=='.') || (c=='%'))
{

}

else {

ke.consume();
}
}
else if(ke.getSource()==t10)
{
char c=ke.getKeyChar();
if((c>='0' && c<='9') || (c=='.') || (c=='%'))
{

}

else {

ke.consume();
}
}
}


}

class OpenAccountDemo
{
public static void main(String[] s)
{
OpenAccount l=new OpenAccount();
}
}