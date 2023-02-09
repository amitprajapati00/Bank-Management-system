import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Registration implements KeyListener,ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5;
JTextField t1,t2,t3;
JTextArea txtaddr;
JRadioButton r1,r2;
JButton b1,b2,b3;
JTable t;
DefaultTableModel model;
String heads[]={"ID","Name","Address","Gender","Mobile No."};
JScrollPane js;
Font f1;
Connection con;
PreparedStatement st;
ResultSet rs;
ButtonGroup rg;
String id,nm,addr,gen;
int mob;


Registration()
{
f=new JFrame("Student Registration Form");
f.setSize(1000,800);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

f1=new Font("Arial Black",Font.BOLD,14);


l1=new JLabel("Student ID");
l1.setBounds(50,50,150,30);
l1.setFont(f1);
l1.setForeground(Color.RED);
f.add(l1);


t1=new JTextField();
t1.setBounds(300,50,150,30);
t1.setFont(f1);
t1.addKeyListener(this);
t1.setEditable(false);
f.add(t1);

l2=new JLabel("Student's Name");
l2.setBounds(50,130,150,30);
l2.setFont(f1);
l2.setForeground(Color.RED);
f.add(l2);


t2=new JTextField();
t2.setBounds(300,130,150,30);
t2.setFont(f1);
f.add(t2);


l3=new JLabel("Address");
l3.setBounds(50,210,150,30);
l3.setFont(f1);
l3.setForeground(Color.RED);
f.add(l3);

txtaddr=new JTextArea();
txtaddr.setBounds(300,210,150,150);
txtaddr.setFont(f1);
f.add(txtaddr);

l4=new JLabel("Gender");
l4.setBounds(50,410,150,30);
l4.setFont(f1);
l4.setForeground(Color.RED);
f.add(l4);

rg=new ButtonGroup();
r1=new JRadioButton("Male");
r1.setBounds(300,410,150,30);
r1.setFont(f1);
f.add(r1);

r2=new JRadioButton("Female");
r2.setBounds(300,450,150,30);
r2.setFont(f1);
f.add(r2);

rg.add(r1);
rg.add(r2);

l5=new JLabel("Mobile No.");
l5.setBounds(50,530,150,30);
l5.setFont(f1);
l5.setForeground(Color.RED);
f.add(l5);

t3=new JTextField();
t3.setBounds(300,530,150,30);
t3.setFont(f1);
f.add(t3);


b1=new JButton("Submit");
b1.setBounds(80,610,100,30);
b1.setFont(f1);
b1.addActionListener(this);
f.add(b1);

b2=new JButton("Reset");
b2.setBounds(240,610,100,30);
b2.setFont(f1);
b2.addActionListener(this);
f.add(b2);

b3=new JButton("Update All Records");
b3.setBounds(500,610,200,30);
b3.setFont(f1);
b3.addActionListener(this);
f.add(b3);




try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/demodb","root","");
st=con.prepareStatement("select count(sid) from registration");
rs=st.executeQuery();
rs.next();
int cn=rs.getInt(1);
cn=cn+1;
id="s" + String.valueOf(cn);
t1.setText(id);
}
catch(Exception e)
{
System.out.print(e);
}


t=new JTable();
model=new DefaultTableModel();
model.setColumnIdentifiers(heads);
t.setModel(model);
js=new JScrollPane(t);
js.setBounds(500,50,450,510);
f.add(js);

f.setVisible(true);
t2.requestFocus();
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
id=t1.getText();
nm=t2.getText();
addr=txtaddr.getText();
if(r1.isSelected()==true)
gen="Male";
else
gen="Female";
mob=Integer.parseInt(t3.getText());
model.addRow(new Object[]{id,nm,addr,gen,mob});
/* try
{
JOptionPane.showMessageDialog(f,"Registered Successfully");
id=id.substring(1);
int rn=Integer.parseInt(id)+1;
id="s"+String.valueOf(rn);
t1.setText(id);
t2.setText("");
txtaddr.setText("");
r1.setSelected(false);
r2.setSelected(false);
t3.setText("");
t1.requestFocus();
}
catch(Exception e)
{
System.out.print(e);
}*/
id=id.substring(1);
int rn=Integer.parseInt(id)+1;
id="s"+String.valueOf(rn);
t1.setText(id);
t2.setText("");
txtaddr.setText("");
r1.setSelected(false);
r2.setSelected(false);
t3.setText("");
t2.requestFocus();
}
else if(ae.getSource()==b2)
{
t1.setText("");
t2.setText("");
t1.requestFocus();
}
else if(ae.getSource()==b3)
{
int c=model.getRowCount();
JOptionPane.showMessageDialog(f,c);
try
{
for(int i=0;i<c;i++)
{
id=(String)model.getValueAt(i,0);
nm=(String)model.getValueAt(i,1);
addr=(String)model.getValueAt(i,2);
gen=(String)model.getValueAt(i,3);
mob=(Integer)model.getValueAt(i,4);
st=con.prepareStatement("insert into registration values(?,?,?,?,?)");
st.setString(1,id);
st.setString(2,nm);
st.setString(3,addr);
st.setString(4,gen);
st.setInt(5,mob);
st.executeUpdate();
}
JOptionPane.showMessageDialog(f,"Updated Successfully");
model.setRowCount(0);
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

class RegistrationDemo
{
public static void main(String[] s)
{
Registration l=new Registration();
}
}