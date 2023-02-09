import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class DeleteCustomerPolicy implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7;
JTextField t1,t2,t3,t4,t5,t6,t7;
JButton b1,b2,b3,b4;
Font f1;    
ImageIcon im;
Connection con;
PreparedStatement st;
ResultSet rs;
String accn,cusnm,pnm,bf,tp,dt,amt;


DeleteCustomerPolicy()
{
f=new JFrame("Customer Policy Detail");
f.setSize(800,700);
f.setResizable(false);
f.setLocationRelativeTo(null); 
f.setLayout(null); 
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image Customer policy 3.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,800,700);
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

l2=new JLabel("Customer Name");
l2.setBounds(50,120,150,30);
l2.setFont(f1);
l2.setForeground(Color.RED);
bg.add(l2);

t2=new JTextField();
t2.setBounds(550,120,200,30);
t2.setFont(f1);
bg.add(t2);
t2.addKeyListener(this);

l3=new JLabel("Policy Name");
l3.setBounds(50,200,200,30);
l3.setFont(f1);
l3.setForeground(Color.RED);
bg.add(l3);

t3=new JTextField();
t3.setBounds(550,200,200,30);
t3.setFont(f1);
bg.add(t3);
t3.addKeyListener(this);

l4=new JLabel("Benefits");
l4.setBounds(50,280,200,30);
l4.setFont(f1);
l4.setForeground(Color.RED);
bg.add(l4);

t4=new JTextField();
t4.setBounds(550,280,200,30);
t4.setFont(f1);
bg.add(t4);
t4.addKeyListener(this);

l5=new JLabel("Time Period");
l5.setBounds(50,360,200,30);
l5.setFont(f1);
l5.setForeground(Color.RED);
bg.add(l5);

t5=new JTextField();
t5.setBounds(550,360,200,30);
t5.setFont(f1);
bg.add(t5);
t5.addKeyListener(this);

l6=new JLabel("Date");
l6.setBounds(50,440,200,30);
l6.setFont(f1);
l6.setForeground(Color.RED);
bg.add(l6);

t6=new JTextField();
t6.setBounds(550,440,200,30);
t6.setFont(f1);
bg.add(t6);
t6.addKeyListener(this);

l7=new JLabel("Amount");
l7.setBounds(50,520,200,30);
l7.setFont(f1);
l7.setForeground(Color.RED);
bg.add(l7);

t7=new JTextField();
t7.setBounds(550,520,200,30);
t7.setFont(f1);
bg.add(t7);
t7.addKeyListener(this);


b1=new JButton("Delete");
b1.setBounds(100,600,100,30);
b1.setFont(f1);
b1.setForeground(Color.BLACK);
b1.addActionListener(this);
bg.add(b1);

b2=new JButton("Reset");
b2.setBounds(375,600,100,30);
b2.setFont(f1);
b2.setForeground(Color.BLACK);
b2.addActionListener(this);
bg.add(b2);

b3=new JButton("Search");
b3.setBounds(400,50,100,30);
b3.setFont(f1);
b3.setForeground(Color.BLACK);
b3.addActionListener(this);
bg.add(b3);

b4=new JButton("Back");
b4.setBounds(625,600,100,30);
b4.setFont(f1);
b4.setForeground(Color.BLACK);
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
st=con.prepareStatement("delete from customerpolicy where account_no=?");
st.setString(1,accn);

st.executeUpdate();

JOptionPane.showMessageDialog(f,"Delete Successfully");
t1.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");

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

t1.requestFocus();
}//else if b2

else if(ae.getSource()==b3)
{
accn=t1.getText();
try
{
st=con.prepareStatement("select * from customerpolicy where account_no=?");
st.setString(1,accn);
rs=st.executeQuery();
if(rs.next())
{
cusnm=rs.getString(2);
pnm=rs.getString(3);
bf=rs.getString(4);
tp=rs.getString(5);
dt=rs.getString(6);
amt=rs.getString(7);
t1.setText(accn);
t2.setText(cusnm);
t3.setText(pnm);
t4.setText(bf);
t5.setText(tp);
t6.setText(dt);
t7.setText(amt);
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
MainCustomerPolicy mn=new MainCustomerPolicy();
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
if(ke.getSource()==t2)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c==32))
{

}

else {

ke.consume();
}}

else if(ke.getSource()==t5)
{
char c=ke.getKeyChar();
if((c>='0' && c<='9') || (c>='a' && c<='z') || (c>='A' && c<='Z') || (c==32))
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
else if(ke.getSource()==t6)
{
char c=ke.getKeyChar();
if(c>='0' && c<='9') 
{

}

else {

ke.consume();
}
}

else if(ke.getSource()==t7)
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

class DeleteCustomerPolicyDemo
{
public static void main(String[] a)
{
DeleteCustomerPolicy l=new DeleteCustomerPolicy();
}
}






















