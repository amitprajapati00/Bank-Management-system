import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class DeleteCustomerLoan implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JTextField t1,t2,t3,t4,t5,t6,t7,t8;
JButton b1,b2,b3,b4;
Font f1;   
ImageIcon im; 
Connection con;
PreparedStatement st;
ResultSet rs;
String accn,lontyp,cusnm,roi,tp,des,dt,loamt;

DeleteCustomerLoan()
{
f=new JFrame("Customer Loan Detail");
f.setSize(800,800);
f.setResizable(false);
f.setLocationRelativeTo(null); 
f.setLayout(null); 
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image customer loan 3.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,800,800);
f.add(bg);


f1=new Font("Arial Black",Font.BOLD,14);
f.setBackground(Color.BLACK);

l1=new JLabel("Account No");
l1.setBounds(50,50,150,30);
l1.setFont(f1);
l1.setForeground(Color.RED);
bg.add(l1);

t1=new JTextField();
t1.setBounds(550,50,200,30);
t1.setFont(f1);
bg.add(t1);
t1.addKeyListener(this);

l2=new JLabel("Loan Type");
l2.setBounds(50,120,150,30);
l2.setFont(f1);
l2.setForeground(Color.RED);
bg.add(l2);

t2=new JTextField();
t2.setBounds(550,120,200,30);
t2.setFont(f1);
t2.addKeyListener(this);
bg.add(t2);


l3=new JLabel("Customer Name");
l3.setBounds(50,200,200,30);
l3.setFont(f1);
l3.setForeground(Color.RED);
bg.add(l3);

t3=new JTextField();
t3.setBounds(550,200,200,30);
t3.setFont(f1);
bg.add(t3);
t3.addKeyListener(this);

l4=new JLabel("Rate of Intrest");
l4.setBounds(50,280,200,30);
l4.setFont(f1);
l4.setForeground(Color.RED);
bg.add(l4);

t4=new JTextField();
t4.setBounds(550,280,200,30);
t4.setFont(f1);
bg.add(t4);
t4.addKeyListener(this);

l5=new JLabel("Loan Amount");
l5.setBounds(50,360,200,30);
l5.setFont(f1);
l5.setForeground(Color.RED);
bg.add(l5);

t5=new JTextField();
t5.setBounds(550,360,200,30);
t5.setFont(f1);
t5.addKeyListener(this);
bg.add(t5);

l6=new JLabel("Time Period");
l6.setBounds(50,440,200,30);
l6.setFont(f1);
l6.setForeground(Color.RED);
bg.add(l6);

t6=new JTextField();
t6.setBounds(550,440,200,30);
t6.setFont(f1);
bg.add(t6);
t6.addKeyListener(this);


l7=new JLabel("Description");
l7.setBounds(50,520,200,30);
l7.setFont(f1);
l7.setForeground(Color.RED);
bg.add(l7);

t7=new JTextField();
t7.setBounds(550,520,200,30);
t7.setFont(f1);
bg.add(t7);
t7.addKeyListener(this);

l8=new JLabel("Date");
l8.setBounds(50,600,200,30);
l8.setFont(f1);
l8.setForeground(Color.RED);
bg.add(l8);

t8=new JTextField();
t8.setBounds(550,600,200,30);
t8.setFont(f1);
bg.add(t8);
t8.addKeyListener(this);


b1=new JButton("Submit");
b1.setBounds(100,700,100,30);
b1.setFont(f1);
b1.setForeground(Color.BLUE);
b1.addActionListener(this);
bg.add(b1);

b2=new JButton("Reset");
b2.setBounds(375,700,100,30);
b2.setFont(f1);
b2.setForeground(Color.BLUE);
b2.addActionListener(this);
bg.add(b2);

b3=new JButton("Search");
b3.setBounds(400,50,100,30);
b3.setFont(f1);
b3.setForeground(Color.BLUE);
b3.addActionListener(this);
bg.add(b3);

b4=new JButton("Back");
b4.setBounds(625,700,100,30);
b4.setFont(f1);
b4.setForeground(Color.BLUE);
b4.addActionListener(this);
bg.add(b4);

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
}//const

public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==b1)
{
accn=t1.getText();
try
{
st=con.prepareStatement("delete from customerloan where account_number=?");
st.setString(1,accn);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Delete Successfully");
t1.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
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
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t1.requestFocus();
}//if b2

else if(ae.getSource()==b3)
{
accn=t1.getText();
try
{
st=con.prepareStatement("select * from customerloan where account_number=?");
st.setString(1,accn);
rs=st.executeQuery();
if(rs.next())
{
lontyp=rs.getString(2);
cusnm=rs.getString(3);
roi=rs.getString(4);
tp=rs.getString(5);
des=rs.getString(6);
dt=rs.getString(7);
t2.setText(lontyp);
t3.setText(cusnm);
t4.setText(roi);
t5.setText(loamt);
t6.setText(tp);
t7.setText(des);
t8.setText(dt);
}//if

else
{
JOptionPane.showMessageDialog(f,"Invalid Account no");

}//else
}//try
catch(Exception e)
{
System.out.print(e);
}//catch
}//else if b3

else if(ae.getSource()==b4)
{
MainCustomerLoan mn=new MainCustomerLoan();
f.dispose();
}//else if b4

}//action method
public void keyPressed(KeyEvent ke)
{
}

public void keyReleased(KeyEvent ke)
{
}

public void keyTyped(KeyEvent ke)
{
if(ke.getSource()==t7)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c==32))
{

}

else {

ke.consume();
}}

else if(ke.getSource()==t1)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
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
}}
else if(ke.getSource()==t4)
{
char c=ke.getKeyChar();
if((c>='0' && c<='9') || (c=='.') || (c=='%'))
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

else if(ke.getSource()==t6)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c==32) || (c>='0' && c<='9'))
{

}

else {

ke.consume();
}}

}
}

class DeleteCustomerLoanDemo
{
public static void main(String[] a)
{
DeleteCustomerLoan l=new DeleteCustomerLoan();
}
}






















