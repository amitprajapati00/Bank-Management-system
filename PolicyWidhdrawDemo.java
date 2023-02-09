import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class PolicyWidhdraw implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4;
JTextField t2,t3,t4;
JComboBox t1;
JButton b1,b2,b3;
Font f1;
ImageIcon im;
Connection con;
String accno,cusnm,dt,amtw;
ResultSet rs;
PreparedStatement st;

PolicyWidhdraw()
{
f=new JFrame("Policy Widhdraw");
f.setSize(700,500);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image Policy widhdraw.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,700,500);
f.add(bg);


f1=new Font("Arial Black",Font.BOLD,14);

l1=new JLabel("Account No.");
l1.setBounds(50,50,150,30);
l1.setFont(f1);
l1.setForeground(Color.GREEN);
bg.add(l1);

t1=new JComboBox();
t1.setBounds(450,50,200,30);
t1.setFont(f1);
bg.add(t1);
t1.addKeyListener(this);

l2=new JLabel("Customer Name");
l2.setBounds(50,130,150,30);
l2.setFont(f1);
l2.setForeground(Color.GREEN);
bg.add(l2);

t2=new JTextField();
t2.setBounds(450,130,200,30);
t2.setFont(f1);
bg.add(t2);
t2.addKeyListener(this);

l3=new JLabel("Date");
l3.setBounds(50,210,150,30);
l3.setFont(f1);
l3.setForeground(Color.GREEN);
bg.add(l3);

t3=new JTextField();
t3.setBounds(450,210,200,30);
t3.setFont(f1);
bg.add(t3);
t3.addKeyListener(this);

l4=new JLabel(" Amount Widhdraw");
l4.setBounds(50,290,200,30);
l4.setFont(f1);
l4.setForeground(Color.GREEN);
bg.add(l4);


t4=new JTextField();
t4.setBounds(450,290,200,30);
t4.setFont(f1);
bg.add(t4);
t4.addKeyListener(this);

b1=new JButton("Widhdraw");
b1.setBounds(100,420,130,30);
b1.setFont(f1);
b1.addActionListener(this);
bg.add(b1);

b2=new JButton("Reset");
b2.setBounds(310,420,100,30);
b2.setFont(f1);
b2.addActionListener(this);
bg.add(b2);

b3=new JButton("Back");
b3.setBounds(510,420,100,30);
b3.setFont(f1);
b3.addActionListener(this);
bg.add(b3);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bankproject","root","");
st=con.prepareStatement("select account_no from customerpolicy");
rs=st.executeQuery();
while(rs.next())
{
t1.addItem(rs.getString(1));
}//while
}
catch(Exception e)
{
System.out.print(e.getMessage());
}


f.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b2)
{
//t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t1.requestFocus();
}//if 

else if(ae.getSource()==b3)
{
JOptionPane.showMessageDialog(f,"Press ok to go to Home");
MainPolicyTransaction l=new MainPolicyTransaction();
f.dispose();
}//b3

else if(ae.getSource()==b1)
{
accno=t1.getSelectedItem().toString();
cusnm=t2.getText();
dt=t3.getText();
amtw=t4.getText();
 try
{
st=con.prepareStatement("insert into policywidhdraw values(?,?,?,?)");
st.setString(1,accno);
st.setString(2,cusnm);
st.setString(3,dt);
st.setString(4,amtw);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Amount Widhdrawl Successfully");

int amt1=0, tot=0,intbal=0;
amt1=Integer.parseInt(t4.getText());
st=con.prepareStatement("select * from customerpolicy where account_no=?");
st.setString(1,accno);
ResultSet rs=st.executeQuery();
if(rs.next())
   intbal=Integer.parseInt(rs.getString("amount"));

tot=intbal+amt1;
st=con.prepareStatement("Update customerpolicy set amount=? where account_no=?");
st.setString(2,accno);
st.setString(1,""+tot);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Updation Successfully");
//t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t1.requestFocus();
}//try
catch(Exception e)
{
System.out.print(e);
}//catch
}//else if b1
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

else if(ke.getSource()==t3)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9')
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

}


}

class PolicyWidhdrawDemo
{
public static void main(String[] a)
{
PolicyWidhdraw l=new PolicyWidhdraw();
}
}


