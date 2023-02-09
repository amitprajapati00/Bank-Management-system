import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainStatement implements ActionListener
{
JFrame f;
JButton b1,b2,b3,b4;
JLabel l1;
Font f1,f2;
ImageIcon im;

MainStatement()
{
	f=new JFrame("SAP Bank");
	f.setSize(500,500);
	f.setResizable(false);
	f.setLocationRelativeTo(null);
	f.setLayout(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image main Statement.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,500,500);
f.add(bg);


f1=new Font("Arial Black",Font.BOLD,14);
f2=new Font("Arial Black",Font.BOLD,22);

l1=new JLabel("About Your Saving... ");
l1.setBounds(100,50,300,30);
l1.setFont(f2);
l1.setForeground(Color.RED);
bg.add(l1);

b1=new JButton("Widhdraw");
b1.setBounds(125,150,250,30);
b1.setFont(f1);
b1.setForeground(Color.BLUE);
bg.add(b1);
b1.addActionListener(this);
 
b2=new JButton("Deposite");
b2.setBounds(125,270,250,30);
b2.setFont(f1);
b2.addActionListener(this);
b2.setForeground(Color.BLUE);
bg.add(b2);

b4=new JButton("Back");
b4.setBounds(200,380,100,30);
b4.setFont(f1);
b4.addActionListener(this);
b4.setForeground(Color.RED);
bg.add(b4);

 
f.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
JOptionPane.showMessageDialog(f,"Are you agree to show widhdraw statement?");
Statement sal=new Statement();
f.dispose();
}

if(ae.getSource()==b2)
{
JOptionPane.showMessageDialog(f,"If you want to show deposite statement?");
DepositeStatement sal=new DepositeStatement();
f.dispose();
}

else if(ae.getSource()==b4)
{
Main mn=new Main();
f.dispose();
}
}
}
class MainStatementDemo
{
public static void main(String[] a)
{
MainStatement l=new MainStatement();
}
}