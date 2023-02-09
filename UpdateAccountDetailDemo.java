import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class UpdateAccountDetail implements KeyListener, ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4;
JTextField t1,t2,t3,t4;
JButton b1,b2,b3,b4;
Font f1;
ImageIcon im;
Connection con;
PreparedStatement st;
ResultSet rs;
String accn,des,roi,cntry;

UpdateAccountDetail()
{
f=new JFrame("Modefie Account Details");
f.setSize(800,500);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image account detail 2.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,800,500);
f.add(bg);

f1=new Font("Arial Black",Font.BOLD,14);

l1=new JLabel("Account Name");
l1.setBounds(50,50,150,30);
l1.setFont(f1);
l1.setForeground(Color.GREEN);
bg.add(l1);

t1=new JTextField();
t1.setBounds(550,50,200,30);
t1.setFont(f1);
bg.add(t1);
t1.addKeyListener(this);

l2=new JLabel("Description");
l2.setBounds(50,140,150,30);
l2.setFont(f1);
l2.setForeground(Color.GREEN);
bg.add(l2);

t2=new JTextField();
t2.setBounds(550,140,200,30);
t2.setFont(f1);
bg.add(t2);
t2.addKeyListener(this);

l3=new JLabel("Rate Of Intrest");
l3.setBounds(50,230,150,30);
l3.setFont(f1);
l3.setForeground(Color.GREEN);
bg.add(l3);

t3=new JTextField();
t3.setBounds(550,230,200,30);
t3.setFont(f1);
bg.add(t3);
t3.addKeyListener(this);

l4=new JLabel("Country");
l4.setBounds(50,320,150,30);
l4.setFont(f1);
l4.setForeground(Color.GREEN);
bg.add(l4);

t4=new JTextField();
t4.setBounds(550,320,200,30);
t4.setFont(f1);
bg.add(t4);
t4.addKeyListener(this);

b1=new JButton("Update");
b1.setBounds(50,425,100,30);
b1.setFont(f1);
b1.addActionListener(this);
bg.add(b1);

b2=new JButton("Reset");
b2.setBounds(350,425,100,30);
b2.setFont(f1);
b2.addActionListener(this);
bg.add(b2);

b3=new JButton("Search");
b3.setBounds(400,50,100,30);
b3.setFont(f1);
b3.addActionListener(this);
bg.add(b3);

b4=new JButton("Back");
b4.setBounds(650,425,100,30);
b4.setFont(f1);
b4.addActionListener(this);
bg.add(b4);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://Localhost/bankproject","root","");
/*
st=con.prepareStatement("Select account_type from accountdetail");
rs=st.executeQuery();
while(rs.next())
{
t1.addItem(rs.getString(4));
}//while       
*/
}
catch(Exception e)
{
System.out.print(e);
}


f.setVisible(true);
}   //end of constructor

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b2)
{
t2.setText("");
t3.setText("");
t4.setText("");
}

else if(ae.getSource()==b4)
{
MainAccount mn=new MainAccount();
f.dispose();
}

else if(ae.getSource()==b1)
{
accn=t1.getText();
des=t2.getText();
roi=t3.getText();
cntry=t4.getText();

try
{
st=con.prepareStatement("Update accountdetail set description=?,rate_of_intrest=?,country=? where account_name=?");

st.setString(1,des);
st.setString(2,roi);
st.setString(3,cntry);
st.setString(4,accn);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Update Successfully");

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

else if(ae.getSource()==b3)
{
accn=t1.getText();
try
{
st=con.prepareStatement("select * from accountdetail where account_name=?");
st.setString(1,accn);
rs=st.executeQuery();
if(rs.next())
{
des=rs.getString(2);
roi=rs.getString(3);
cntry=rs.getString(4);
t2.setText(des);
t3.setText(roi);
t4.setText(cntry);
}//if

else
{
JOptionPane.showMessageDialog(f,"Invalid Account Name");
}//else
}//try
catch(Exception e)
{
System.out.print(e);
}//catch
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
if(ke.getSource()==t2)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c==32))
{

}

else {

ke.consume();
}}

else if(ke.getSource()==t3)
{
char c=ke.getKeyChar();
if((c>='0' && c<='9') || (c=='.') || (c=='%'))
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
}}

else if(ke.getSource()==t1)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c==32))
{

}

else {

ke.consume();
}}


}

}//clase

class UpdateAccountDetailDemo
{
public static void main(String[] a)
{
UpdateAccountDetail l=new UpdateAccountDetail();
}
}