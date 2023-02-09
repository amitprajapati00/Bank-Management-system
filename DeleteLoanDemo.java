import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class DeleteLoan implements KeyListener, ActionListener

{
JFrame f;
JLabel l1,l2,l3,l4;
JTextField t1,t2,t3,t4;
JButton b1,b2,b3,b4;
Font f1;
ImageIcon im;
PreparedStatement st;
ResultSet rs;
Connection con;
String lontyp,roi,tac,des;

DeleteLoan()
{
f=new JFrame("Delete Loan Information");
f.setSize(700,500);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image loan 3.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,700,500);
f.add(bg);

f1=new Font("Arial Black",Font.BOLD,14);

l1=new JLabel("Loan Type");
l1.setBounds(50,50,100,30);
l1.setFont(f1);
l1.setForeground(Color.RED);
bg.add(l1);

t1=new JTextField();
t1.setBounds(450,50,200,30);
t1.setFont(f1);
bg.add(t1);
//t1.addKeyListener(this);

l2=new JLabel("Rate of Intrest");
l2.setBounds(50,120,150,30);
l2.setFont(f1);
l2.setForeground(Color.RED);
bg.add(l2);

t2=new JTextField();
t2.setBounds(450,120,200,30);
t2.setFont(f1);
t2.addKeyListener(this);
bg.add(t2);

l3=new JLabel("Terms and Condition");
l3.setBounds(50,190,180,30);
l3.setFont(f1);
l3.setForeground(Color.RED);
bg.add(l3);

t3=new JTextField();
t3.setBounds(450,190,200,30);
t3.setFont(f1);
t3.addKeyListener(this);
bg.add(t3);

l4=new JLabel("Description");
l4.setBounds(50,260,100,30);
l4.setFont(f1);
l4.setForeground(Color.RED);
bg.add(l4);

t4=new JTextField();
t4.setBounds(450,260,200,30);
t4.setFont(f1);
t4.addKeyListener(this);
bg.add(t4);

b1=new JButton("Delete");
b1.setBounds(50,400,100,30);
b1.setFont(f1);
b1.addActionListener(this);
bg.add(b1);

b2=new JButton("Reset");
b2.setBounds(300,400,100,30);
b2.setFont(f1);
b2.addActionListener(this);
bg.add(b2);

b3=new JButton("Back");
b3.setBounds(550,400,100,30);
b3.setFont(f1);
b3.addActionListener(this);
bg.add(b3);

b4=new JButton("Search");
b4.setBounds(300,50,100,30);
b4.setFont(f1);
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
}

f.setVisible(true);
}//const

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
 lontyp=t1.getText();

try
{
st=con.prepareStatement("delete from loan where loan_type=?");
st.setString(1,lontyp);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Delete Successfully");

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
}//b1

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
MainLoan mn=new MainLoan();
f.dispose();
}//b3

else if(ae.getSource()==b4)
{
lontyp=t1.getText();
try
{
st=con.prepareStatement("select * from loan where loan_type=?");
st.setString(1,lontyp);
rs=st.executeQuery();
if(rs.next())
{
roi=rs.getString(2);
tac=rs.getString(3);
des=rs.getString(4);
t2.setText(roi);
t3.setText(tac);
t4.setText(des);
}//if

else
{
JOptionPane.showMessageDialog(f,"Invalid Loan Type");
}//else
}//try

catch(Exception e)
{
System.out.print(e);
}//catch
}//b4
}//action method

public void keyPressed(KeyEvent ke)
{
}

public void keyReleased(KeyEvent ke)
{
}

public void keyTyped(KeyEvent ke)
{
if(ke.getSource()==t2)
{
char c=ke.getKeyChar();
if((c>='0'  && c<='9') || (c=='.') || (c=='%'))
{

}

else {

ke.consume();
}//else
}//if t2

 if(ke.getSource()==t3)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c==32))
{

}

else {

ke.consume();
}
}//t3

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
}//key listener
}//class

class DeleteLoanDemo
{
public static void main(String[] a)
{
DeleteLoan I=new DeleteLoan();
}
}


