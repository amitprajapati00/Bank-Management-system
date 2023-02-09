import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;

class DepositeStatement implements ActionListener
{
	JFrame f;
	Font f1;
	JLabel l1;
    
	JTextField t1;
	JButton b1,b2;
	JTable tb;
	DefaultTableModel model;
	JScrollPane js;
	//Connection con;
	//ResultSet rs;
	//PreparedStatement st;
	//String medi,mrp,dis,price,unit,amount;

DepositeStatement()
{
f=new JFrame("Account Statement");
f.setSize(700,500);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// f.setBackground(Color.RED);

f1=new Font("Arial",Font.BOLD,14);

tb=new JTable();
model=new DefaultTableModel();
String heads[]={"account_number","customer_name","date","amount"};
model.setColumnIdentifiers(heads);
tb.setModel(model);
js=new JScrollPane(tb);
js.setBounds(50,100,600,250);    
f.add(js);

l1=new JLabel("Account Number");
l1.setBounds(30,30,150,30);
f.add(l1);
l1.setFont(f1);
l1.setForeground(Color.RED);

t1=new JTextField();
t1.setBounds(220,30,100,30);
t1.setFont(f1);
f.add(t1);
t1.setForeground(Color.BLUE);
//t1.addKeyListener(this);


b1=new JButton("View");
b1.setBounds(370,30,100,30);
b1.setFont(f1);
f.add(b1);
b1.setForeground(Color.BLUE);
//b1.addActionListener(this);

b2=new JButton("Back");
b2.setBounds(550,400,100,30);
b2.setFont(f1);
f.add(b2);
b2.setForeground(Color.BLUE);
b2.addActionListener(this);

f.setVisible(true);
}// cons

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b2)
{
MainStatement l=new MainStatement();
f.dispose();
}
}

}//End of class

class DepositeStatementDemo
{
public static void main(String s[])
{
DepositeStatement sal=new DepositeStatement();
}
}