import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Login implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2;
JTextField t1;
JPasswordField t2;
JButton b1,b2,b3,b4;
Font f1;    //font style
Connection con;
PreparedStatement st;
ResultSet rs;
ImageIcon im;

Login()
{
f=new JFrame("Login");
f.setSize(600,400);
f.setResizable(false);
f.setLocationRelativeTo(null); //screen location
f.setLayout(null); // accordin to user input
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image Login.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,600,400);
f.add(bg);

f1=new Font("Arial Black",Font.BOLD,14);

l1=new JLabel("User Name");
l1.setBounds(50,50,100,30);
l1.setFont(f1);
l1.setForeground(Color.RED);
bg.add(l1);

t1=new JTextField();
t1.setBounds(350,50,200,30);
t1.setFont(f1);
t1.addKeyListener(this);
bg.add(t1);

l2=new JLabel("Password");
l2.setBounds(50,130,100,30);
l2.setFont(f1);
l2.setForeground(Color.RED);
bg.add(l2);


t2=new JPasswordField();
t2.setBounds(350,130,200,30);
t2.setFont(f1);
bg.add(t2);

b1=new JButton("Login");
b1.setBounds(70,210,100,30);
b1.setFont(f1);
b1.addActionListener(this);
bg.add(b1);


b2=new JButton("Reset");
b2.setBounds(400,210,100,30);
b2.setFont(f1);
b2.addActionListener(this);
bg.add(b2);

b3=new JButton("Forgot Password");
b3.setBounds(50,300,200,30);
b3.setFont(f1);
b3.addActionListener(this);
bg.add(b3);

b4=new JButton("Change Password");
b4.setBounds(350,300,200,30);
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
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
String un,pwd;
un=t1.getText();
pwd=t2.getText();
try
{
st=con.prepareStatement("select * from login where username=? and password=?");
st.setString(1,un);
st.setString(2,pwd);
rs=st.executeQuery();
if(rs.next())
{
JOptionPane.showMessageDialog(f,"welcome to Your Bank");
Main m=new Main();
f.dispose();
}
else
{
JOptionPane.showMessageDialog(f,"Invalid user Name/Password");
}
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
t1.requestFocus();
}

else if(ae.getSource()==b3)
{
JOptionPane.showMessageDialog(f,"If you want to forget your password? press Ok");
ForgetPassword ps=new ForgetPassword();
f.dispose();
}//else if b3

else if(ae.getSource()==b4)
{
JOptionPane.showMessageDialog(f,"If you want to change your password?prss ok");
ChangePassword l=new ChangePassword();
f.dispose();
}//b4
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
class LoginDemo
{
public static void main(String[] a)
{
Login l=new Login();
}
}






