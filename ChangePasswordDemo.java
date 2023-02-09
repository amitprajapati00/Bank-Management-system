import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ChangePassword implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4;
JTextField t1;
JPasswordField t2,t3,t4;
JButton b1,b2,b3;
Font f1;
ImageIcon im;
Connection con;
PreparedStatement st;
ResultSet rs;

ChangePassword()
{
f=new JFrame("Change Password");
f.setSize(500,400);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image ChangePassowrd.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,500,400);
f.add(bg);

f1=new Font("Arial Black",Font.BOLD,14);

l1=new JLabel("User Name");
l1.setBounds(50,80,100,30);
l1.setFont(f1);
l1.setForeground(Color.RED);
bg.add(l1);

t1=new JTextField();
t1.setBounds(250,80,200,30);
t1.setFont(f1);
t1.addKeyListener(this);
bg.add(t1);

l2=new JLabel("Old Password");
l2.setBounds(50,130,150,30);
l2.setFont(f1);
l2.setForeground(Color.RED);
bg.add(l2);


t2=new JPasswordField();
t2.setBounds(250,130,200,30);
t2.setFont(f1);
bg.add(t2);

l3=new JLabel("New Password");
l3.setBounds(50,180,150,30);
l3.setFont(f1);
l3.setForeground(Color.RED);
bg.add(l3);

t3=new JPasswordField();
t3.setBounds(250,180,200,30);
t3.setFont(f1);
bg.add(t3);

l4=new JLabel("Confirm Password");
l4.setBounds(50,230,170,30);
l4.setFont(f1);
l4.setForeground(Color.RED);
bg.add(l4);

t4=new JPasswordField();
t4.setBounds(250,230,200,30);
t4.setFont(f1);
bg.add(t4);

b1=new JButton("Change");
b1.setBounds(60,300,100,30);
b1.setFont(f1);
b1.addActionListener(this);
bg.add(b1);

b2=new JButton("Reset");
b2.setBounds(210,300,100,30);
b2.setFont(f1);
b2.addActionListener(this);
bg.add(b2);

b3=new JButton("Back");
b3.setBounds(360,300,100,30);
b3.setFont(f1);
b3.addActionListener(this);
bg.add(b3);

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
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
String un,opwd,npwd,cpwd;
un=t1.getText();
opwd=t2.getText();
npwd=t3.getText();
cpwd=t4.getText();
if(npwd.equals(cpwd))
{
try
{
st=con.prepareStatement("select * from login where username=? and password=?");
st.setString(1,un);
st.setString(2,opwd);
rs=st.executeQuery();
if(rs.next())
{
st=con.prepareStatement("update login set password=? where username=?");
st.setString(1,npwd);
st.setString(2,un);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Password Changed Successfully");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t1.requestFocus();
}
else
{
JOptionPane.showMessageDialog(f,"Invalid User Name/Password");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
}
}
catch(Exception e)
{
System.out.print(e);
}
}
else
{
JOptionPane.showMessageDialog(f,"New Password & Confirm Password Did not Match");
}
}
else if(ae.getSource()==b2)
{
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t1.requestFocus();
}

else if(ae.getSource()==b3)
{
JOptionPane.showMessageDialog(f,"Back to login screen");
Login l=new Login();
f.dispose();
}//b3

}

public void keyPressed(KeyEvent ke)
{
}

public void keyReleased(KeyEvent ke)
{
}
public void keyTyped(KeyEvent ke)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
{
}
else
{
ke.consume();
}

}

}

class ChangePasswordDemo
{
public static void main(String[] s)
{
ChangePassword l=new ChangePassword();
}
}