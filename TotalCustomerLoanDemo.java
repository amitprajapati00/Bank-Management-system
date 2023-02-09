import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;

 class TotalCustomerLoan implements ActionListener
{
JFrame f;
JButton b1;
JTable tb;
DefaultTableModel model;
JScrollPane js;
ResultSet rs;
Statement st;
Connection con;

TotalCustomerLoan()
{

f=new JFrame("All Customer Loan");
f.setSize(830,550);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


tb=new JTable();
model=new DefaultTableModel();
String heads[]={"account_number","loan_type","customer_name","loan_amount","time_period","date"};
model.setColumnIdentifiers(heads);
tb.setModel(model);
js=new JScrollPane(tb);
js.setBounds(30,30,750,400);//Jtable
f.add(js);


b1=new JButton("Back");
b1.setBounds(700,450,100,30);
//b1.setFont(f1);
f.add(b1);
//b1.setForeground(Color.BLUE);
b1.addActionListener(this);


try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/bankproject","root","");
st=con.createStatement();

String ss="select * from customerloan";
System.out.println("query:"+ss);
 rs=st.executeQuery(ss);
while(rs.next())
{
String s1=rs.getString("account_number");
String s2=rs.getString("loan_type");
String s3=rs.getString("customer_name");
String s4=rs.getString("loan_amount");
String s5=rs.getString("time_period");
String s6=rs.getString("date");

model.addRow(new Object[]{s1,s2,s3,s4,s5,s6});


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
class TotalCustomerLoanDemo
{
public static void main(String s[])
{

TotalCustomerLoan ta=new TotalCustomerLoan();
}}