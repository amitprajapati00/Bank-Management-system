import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class ModefieAccountDetail implements KeyListener
{
JFrame f;
JLabel l1,l2,l3,l4;
JTextField t2,t3,t4;
JComboBox t1;
JButton b1,b2,b3,b4;
Font f1;

ModefieAccountDetail()
{
f=new JFrame("Modefie Account Details");
f.setSize(700,500);
f.setResizable(false);
f.setLocationRelativeTo(null);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

f1=new Font("Arial Black",Font.BOLD,14);

l1=new JLabel("Account Name");
l1.setBounds(50,50,150,25);
l1.setFont(f1);
l1.setForeground(Color.GREEN);
f.add(l1);

t1=new JComboBox();
t1.setBounds(250,50,200,25);
t1.setFont(f1);
t1.addItem("Current Account");
t1.addItem("Saving Account");
t1.addItem("Demat Account");
f.add(t1);

l2=new JLabel("Description");
l2.setBounds(50,120,150,25);
l2.setFont(f1);
l2.setForeground(Color.GREEN);
f.add(l2);

t2=new JTextField();
t2.setBounds(250,120,200,25);
t2.setFont(f1);
t2.addKeyListener(this);
f.add(t2);

l3=new JLabel("Rate Of Intrest");
l3.setBounds(50,200,150,25);
l3.setFont(f1);
l3.setForeground(Color.GREEN);
f.add(l3);

t3=new JTextField();
t3.setBounds(250,200,200,25);
t3.setFont(f1);
t3.addKeyListener(this);
f.add(t3);

l4=new JLabel("Country");
l4.setBounds(50,270,150,25);
l4.setFont(f1);
l4.setForeground(Color.GREEN);
f.add(l4);

t4=new JTextField();
t4.setBounds(250,270,200,25);
t4.setFont(f1);
t4.addKeyListener(this);
f.add(t4);

b1=new JButton("Submit");
b1.setBounds(60,350,100,30);
b1.setFont(f1);
f.add(b1);

b2=new JButton("Reset");
b2.setBounds(210,350,100,30);
b2.setFont(f1);
f.add(b2);

b3=new JButton("Search");
b3.setBounds(500,50,100,30);
b3.setFont(f1);
f.add(b3);

b4=new JButton("Back");
b4.setBounds(360,350,100,30);
b4.setFont(f1);
f.add(b4);


f.setVisible(true);
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
if((c>='a' && c<='z') || (c>='A' && c<='Z'))
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

else if(ke.getSource()==t4)
{
char c=ke.getKeyChar();
if((c>='a' && c<='z') || (c>='A' && c<='Z'))
{

}

else {

ke.consume();
}}


}


}

class ModefieAccountDetailDemo
{
public static void main(String[] a)
{
ModefieAccountDetail l=new ModefieAccountDetail();
}
}