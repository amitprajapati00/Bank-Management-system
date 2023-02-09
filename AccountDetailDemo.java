import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class AccountDetail implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4;
JTextField t1,t2,t3,t4;
JButton b1,b2,b3;
Font f1;
ImageIcon im;
Connection con;
String accn,des,roi,cntry;
PreparedStatement st;

AccountDetail()
{
f=new JFrame("New Account Details");
f.setSize(700,500);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image account detail 1.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,700,500);
f.add(bg);


f1=new Font("Arial Black",Font.BOLD,14);

l1=new JLabel("Account Name");
l1.setBounds(50,50,150,25);
l1.setFont(f1);
l1.setForeground(Color.GREEN);
bg.add(l1);

t1=new JTextField();
t1.setBounds(450,50,200,25);
t1.addKeyListener(this);
t1.setFont(f1);
bg.add(t1);

l2=new JLabel("Description");
l2.setBounds(50,130,150,25);
l2.setFont(f1);
l2.setForeground(Color.GREEN);
bg.add(l2);

t2=new JTextField();
t2.setBounds(450,130,200,25);
t2.setFont(f1);
bg.add(t2);
t2.addKeyListener(this);

l3=new JLabel("Rate Of Intrest");
l3.setBounds(50,210,150,25);
l3.setFont(f1);
l3.setForeground(Color.GREEN);
bg.add(l3);

t3=new JTextField();
t3.setBounds(450,210,200,25);
t3.setFont(f1);
bg.add(t3);
t3.addKeyListener(this);

l4=new JLabel("Country");
l4.setBounds(50,290,150,25);
l4.setFont(f1);
l4.setForeground(Color.GREEN);
bg.add(l4);

t4=new JTextField();
t4.setBounds(450,290,200,25);
t4.setFont(f1);
bg.add(t4);
t4.addKeyListener(this);

b1=new JButton("Submit");
b1.setBounds(50,425,100,30);
b1.setFont(f1);
bg.add(b1);
b1.addActionListener(this);

b2=new JButton("Reset");
b2.setBounds(300,425,100,30);
b2.setFont(f1);
bg.add(b2);
b2.addActionListener(this);

b3=new JButton("Back");
b3.setBounds(550,425,100,30);
b3.setFont(f1);
b3.addActionListener(this);
bg.add(b3);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bankproject","root","");
/*st=con.prepareStatement("Select account_type from accountdetail");
rs=st.executeQuery();
while(rs.next())
{
t1.addItem(rs.getString(4));
}*/       
//while
}//try
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
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
}

else if(ae.getSource()==b3)
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
st=con.prepareStatement("insert into accountdetail values(?,?,?,?)");
st.setString(1,accn);
st.setString(2,des);
st.setString(3,roi);
st.setString(4,cntry);
st.executeUpdate();
JOptionPane.showMessageDialog(f,"Data store Successfully");
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t2.requestFocus();


else 
{
JOptionPane.showMessageDialog(f,"Inavlid Details");

}//else
}//try
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
if(ke.getSource()==t2)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c ==32))
{

}

else {

ke.consume();
}}

else if(ke.getSource()==t3)
{
char c=ke.getKeyChar();
if((c>='0' && c<='9') || (c=='.' ) || (c== '%'))
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
}
class AccountDetailDemo
{
public static void main(String[] a)
{
AccountDetail l=new AccountDetail();
}
}