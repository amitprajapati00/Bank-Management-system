import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainOpenAccount implements ActionListener
{
JFrame f;
JButton b1,b2,b3,b4;
JLabel l1;
Font f1,f2;
ImageIcon im;

MainOpenAccount()
{
	f=new JFrame("SAP Bank");
	f.setSize(500,500);
	f.setResizable(false);
	f.setLocationRelativeTo(null);
	f.setLayout(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image account main.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,500,500);
f.add(bg);


f1=new Font("Arial Black",Font.BOLD,14);
f2=new Font("Arial Black",Font.BOLD,22);

l1=new JLabel("Would You Like An Open Account ?");
l1.setBounds(25,50,475,30);
l1.setFont(f2);
l1.setForeground(Color.RED);
bg.add(l1);

b1=new JButton("New Account");
b1.setBounds(125,150,200,30);
b1.setFont(f1);
//b1.setForeground(Color.YELLOW);
bg.add(b1);
b1.addActionListener(this);
 
b2=new JButton("Update Account");
b2.setBounds(125,220,200,30);
b2.setFont(f1);
bg.add(b2);
b2.addActionListener(this);

b3=new JButton("Delete Account");
b3.setBounds(125,300,200,30);
b3.setFont(f1);
bg.add(b3);
b3.addActionListener(this);

b4=new JButton("Back");
b4.setBounds(350,380,100,30);
b4.setFont(f1);
bg.add(b4);
b4.addActionListener(this);

 
f.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
JOptionPane.showMessageDialog(f,"Please open your account carefully");
OpenAccount d=new OpenAccount();
f.dispose();
}

else if(ae.getSource()==b2)
{
JOptionPane.showMessageDialog(f,"Would you like something change in your details?");
UpdateOpenAccount g=new UpdateOpenAccount();
f.dispose();
}

else if(ae.getSource()==b3)
{
JOptionPane.showMessageDialog(f,"I think something want wrong.If you want delete?");
DeleteOpenAccount h=new DeleteOpenAccount();
f.dispose();
}

else if(ae.getSource()==b4)
{
JOptionPane.showMessageDialog(f,"Are you sure go to Home?then click on Ok");
Main l=new Main();
f.dispose();
}

}
}

class MainOpenAccountDemo
{
public static void main(String[] a)
{
MainOpenAccount l=new MainOpenAccount();
}
}