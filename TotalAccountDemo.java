import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;

 class TotalAccount implements ActionListener
{
JFrame f;
JButton b1;
JTable tb;
DefaultTableModel model;
JScrollPane js;
ResultSet rs;
Statement st;
Connection con;


TotalAccount()
{

f=new JFrame("All Accounts");
f.setSize(930,550);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


tb=new JTable();
model=new DefaultTableModel();
String heads[]={"account_number","customer_name","address","gender","mobile_number","account_type","email_id","inistiat_balance"};
model.setColumnIdentifiers(heads);
tb.setModel(model);
js=new JScrollPane(tb);
js.setBounds(30,30,850,400);//Jtable
f.add(js);


b1=new JButton("Back");
b1.setBounds(800,450,100,30);
//b1.setFont(f1);
f.add(b1);
//b1.setForeground(Color.BLUE);
b1.addActionListener(this);


try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bankproject","root","");
st=con.createStatement();

String ss="select * from openaccount";
System.out.println("query:"+ss);
 rs=st.executeQuery(ss);
while(rs.next())
{
String s1=rs.getString("account_number");
String s2=rs.getString("customer_name");
String s3=rs.getString("address");
String s4=rs.getString("gender");
String s5=rs.getString("mobile_number");
String s6=rs.getString("account_type");
String s7=rs.getString("email_id");
String s8=rs.getString("inistiat_balance");

model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7,s8});


}
con.close();
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
Main m=new Main();
f.dispose();
}
}

}
class TotalAccountDemo
{
public static void main(String s[])
{

TotalAccount ta=new TotalAccount();
}}