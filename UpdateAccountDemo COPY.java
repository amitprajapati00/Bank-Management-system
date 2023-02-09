import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class UpdateAccount implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
JTextArea txtaddr;
JRadioButton r1,r2;
JButton b1,b2,b3;
Font f1;
Connection con;
PreparedStatement st;
ResultSet rs;
ButtonGroup rg;
String id,nm,addr,gen;
int mob;

UpdateAccount()
{
f=new JFrame("Open New Account");
f.setSize(1000,750);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

f1=new Font("Arial Black",Font.BOLD,14);


l1=new JLabel("Account No.");
l1.setBounds(50,50,150,30);
l1.setFont(f1);
l1.setForeground(Color.RED);
f.add(l1);


t1=new JTextField();
t1.setBounds(250,50,200,30);
t1.setFont(f1);
t1.addKeyListener(this);
f.add(t1);

l2=new JLabel("Customer Name");
l2.setBounds(50,130,150,30);
l2.setFont(f1);
l2.setForeground(Color.RED);
f.add(l2);


t2=new JTextField();
t2.setBounds(250,130,200,30);
t2.setFont(f1);
t2.addKeyListener(this);
f.add(t2);


l3=new JLabel("Address");
l3.setBounds(50,210,150,30);
l3.setFont(f1);
l3.setForeground(Color.RED);
f.add(l3);

txtaddr=new JTextArea();
txtaddr.setBounds(250,210,150,150);
txtaddr.setFont(f1);
f.add(txtaddr);

l4=new JLabel("Gender");
l4.setBounds(50,410,150,30);
l4.setFont(f1);
l4.setForeground(Color.RED);
f.add(l4);

rg=new ButtonGroup();
r1=new JRadioButton("Male");
r1.setBounds(250,410,150,30);
r1.setFont(f1);
f.add(r1);

r2=new JRadioButton("Female");
r2.setBounds(250,450,150,30);
r2.setFont(f1);
f.add(r2);

rg.add(r1);
rg.add(r2);

l5=new JLabel("Mobile No.");
l5.setBounds(500,50,150,30);
l5.setFont(f1);
l5.setForeground(Color.RED);
f.add(l5);

t3=new JTextField();
t3.setBounds(650,50,200,30);
t3.setFont(f1);
t3.addKeyListener(this);
f.add(t3);

l6=new JLabel("Aadhar No.");
l6.setBounds(500,130,150,30);
l6.setFont(f1);
l6.setForeground(Color.RED);
f.add(l6);

t4=new JTextField();
t4.setBounds(650,130,200,30);
t4.setFont(f1);
t4.addKeyListener(this);
f.add(t4);

l7=new JLabel("Account Type");
l7.setBounds(500,210,150,30);
l7.setFont(f1);
l7.setForeground(Color.RED);
f.add(l7);

t5=new JTextField();
t5.setBounds(650,210,200,30);
t5.setFont(f1);
t5.addKeyListener(this);
f.add(t5);

l8=new JLabel("E-mail ID");
l8.setBounds(500,290,150,30);
l8.setFont(f1);
l8.setForeground(Color.RED);
f.add(l8);

t6=new JTextField();
t6.setBounds(650,290,200,30);
t6.setFont(f1);
f.add(t6);

l9=new JLabel("PAN Card No.");
l9.setBounds(500,370,150,30);
l9.setFont(f1);
l9.setForeground(Color.RED);
f.add(l9);

t7=new JTextField();
t7.setBounds(650,370,200,30);
t7.setFont(f1);
t7.addKeyListener(this);
f.add(t7);

l10=new JLabel("Inistiat Balance");
l10.setBounds(500,450,150,30);
l10.setFont(f1);
l10.setForeground(Color.RED);
f.add(l10);

t8=new JTextField();
t8.setBounds(650,450,200,30);
t8.setFont(f1);
t8.addKeyListener(this);
f.add(t8);

l11=new JLabel("IFSC Code");
l11.setBounds(500,530,150,30);
l11.setFont(f1);
l11.setForeground(Color.RED);
f.add(l11);

t9=new JTextField();
t9.setBounds(650,530,200,30);
t9.setFont(f1);
t9.addKeyListener(this);
f.add(t9);

l12=new JLabel("Nationality");
l12.setBounds(50,530,150,30);
l12.setFont(f1);
l12.setForeground(Color.RED);
f.add(l12);


t10=new JTextField();
t10.setBounds(250,530,200,30);
t10.setFont(f1);
t10.addKeyListener(this);
t10.addKeyListener(this);
f.add(t10);

b1=new JButton("Submit");
b1.setBounds(150,600,100,30);
b1.setFont(f1);
b1.addActionListener(this);
f.add(b1);

b2=new JButton("Reset");
b2.setBounds(350,600,100,30);
b2.setFont(f1);
b2.addActionListener(this);
f.add(b2);

b3=new JButton("Search");
b3.setBounds(550,600,100,30);
b3.setFont(f1);
b3.addActionListener(this);
f.add(b3);


try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/demodb","root","");
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
id=t1.getText();
try
{
st=con.prepareStatement("delete from registration where sid=?");
st.setString(1,id);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Delete Successfully");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
t10.setText("");
txtaddr.setText("");
r1.setSelected(false);
r2.setSelected(false);
t3.setText("");
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
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t9.setText("");
t10.setText("");

txtaddr.setText("");
r1.setSelected(false);
r2.setSelected(false);
t3.setText("");
t1.requestFocus();
}
else if(ae.getSource()==b3)
{
id=t1.getText();
try
{
st=con.prepareStatement("select * from registration where sid=?");
st.setString(1,id);
rs=st.executeQuery();
if(rs.next())
{
nm=rs.getString(2);
addr=rs.getString(3);
gen=rs.getString(4);
mob=rs.getInt(5);
t2.setText(nm);
txtaddr.setText(addr);
t3.setText(String.valueOf(mob));
if(gen.equals("Male"))
r1.setSelected(true);
else
r2.setSelected(true);
}
else
{
JOptionPane.showMessageDialog(f,"Invalid Acount Number");
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

class UpdateAccountDemo
{
public static void main(String[] s)
{
UpdateAccount l=new UpdateAccount();
}
}