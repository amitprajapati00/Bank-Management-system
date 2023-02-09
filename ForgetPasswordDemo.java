import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class ForgetPassword implements ActionListener
{
JFrame f;
Font f1;
ImageIcon im;
JLabel l1,l2;
JTextField t1;
JPasswordField t2,t3;
JButton b1,b2,b3;
Connection con;
ResultSet rs;
PreparedStatement st;
String usnm,pwd;
ForgetPassword()
{
f=new JFrame("Forgot Password");
f.setSize(500,400);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image customer loan 3.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,500,400);
f.add(bg);

f1=new Font("Arial",Font.BOLD,14);

l1=new JLabel("User Name");
l1.setBounds(50,50,150,30);
l1.setForeground(Color.BLUE);
l1.setFont(f1);
bg.add(l1);

t1=new JTextField();
t1.setBounds(250,50,200,30);
t1.setFont(f1);
bg.add(t1);

l2=new JLabel("Password");
l2.setBounds(50,130,150,30);
l2.setForeground(Color.BLUE);
l2.setFont(f1);
bg.add(l2);

t2=new JPasswordField();
t2.setBounds(250,130,200,30);
t2.setFont(f1);
bg.add(t2);

b1=new JButton("Forgot");
b1.setBounds(50,300,100,30);
b1.addActionListener(this);
b1.setFont(f1);
bg.add(b1);

b2=new JButton("Reset");
b2.setBounds(200,300,100,30);
b2.setFont(f1);
b2.addActionListener(this);
bg.add(b2);

b3=new JButton("Back");
b3.setBounds(350,300,100,30);
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
t1.requestFocus();
}//cons

public void actionPerformed(ActionEvent ae)
{
if (ae.getSource()==b1)
{

if(t1.getText().trim().isEmpty()  )
{
JOptionPane.showMessageDialog(f,"Username must be filled");
}
try
{
   st=con.prepareStatement("select * from login where username=?");
     st.setString(1,usnm);
     rs=st.executeQuery();

     if(rs.next())
     {
  pwd=rs.getString(2);
 t2.setText(pwd); 
     JOptionPane.showMessageDialog(f,"Foregot Password");  
t1.setText("");
t2.setText("");
t1.requestFocus();
}
     else
     {
     JOptionPane.showMessageDialog(f,"Inavlid username");  
     t1.setText("");
     }
}
catch(Exception e)
{
    System.out.print(e);
}

}//if b1

else if(ae.getSource()==b2)
{
t1.setText("");
t2.setText("");

t1.requestFocus();
}//fi b2

else if(ae.getSource()==b3)
{
Login ln=new Login();
f.dispose();

}//else if b3
}//action method

}//class

class ForgetPasswordDemo
{
public static void main(String[] a)
{
ForgetPassword l=new ForgetPassword();
}
}


