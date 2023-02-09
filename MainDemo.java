import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Main implements ActionListener
{
JFrame f;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
JLabel l1;
Font f1,f2;
ImageIcon im;

Main()
{
	f=new JFrame("SAP Bank");
	f.setSize(800,500);
	f.setResizable(false);
	f.setLocationRelativeTo(null);
	f.setLayout(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

im=new ImageIcon("WhatsApp Image Main Demo.jpeg");
JLabel bg=new JLabel("",im,JLabel.CENTER);
bg.setBounds(0,0,800,500);
f.add(bg);


f1=new Font("Arial Black",Font.BOLD,12);
f2=new Font("Arial Black",Font.BOLD,22);

l1=new JLabel("How can I Help You?");
l1.setBounds(250,30,300,30);
l1.setFont(f2);
l1.setForeground(Color.RED);
bg.add(l1);

b1=new JButton("Open Account ");
b1.setBounds(50,90,150,30);
b1.setFont(f1);
b1.setForeground(Color.BLUE);
bg.add(b1);
b1.addActionListener(this);
 
b2=new JButton("Account Detail");
b2.setBounds(50,160,150,30);
b2.setFont(f1);
b2.setForeground(Color.BLUE);
bg.add(b2);
b2.addActionListener(this);

b3=new JButton("Transaction");
b3.setBounds(50,230,150,30);
b3.setFont(f1);
b3.setForeground(Color.BLUE);
bg.add(b3);
b3.addActionListener(this);

b4=new JButton("Loan Detail");
b4.setBounds(50,300,150,30);
b4.setFont(f1);
b4.setForeground(Color.BLUE);
bg.add(b4);
b4.addActionListener(this); 

b5=new JButton("Customer Loan");                                 //600,120,150,30
b5.setBounds(50,370,150,30);
b5.setFont(f1);
b5.setForeground(Color.BLUE);
bg.add(b5);
b5.addActionListener(this);
 
b6=new JButton("Policy");
b6.setBounds(600,160,150,30);
b6.setFont(f1);
b6.setForeground(Color.BLUE);
bg.add(b6);
b6.addActionListener(this);
 
b7=new JButton("Customer Policy");
b7.setBounds(600,230,150,30);
b7.setFont(f1);
b7.setForeground(Color.BLUE);
bg.add(b7);
b7.addActionListener(this);
 
b8=new JButton("Total Details");
b8.setBounds(600,370,150,30);
b8.setFont(f1);
b8.setForeground(Color.BLUE);
b8.addActionListener(this);
bg.add(b8);

b9=new JButton("Logout");
b9.setBounds(650,415,100,30);
b9.setFont(f1);
bg.add(b9);
b9.setForeground(Color.RED);
b9.addActionListener(this);
 
b10=new JButton("Loan Transaction");                                 //
b10.setBounds(600,90,150,30);
b10.setFont(f1);
b10.setForeground(Color.BLUE);
bg.add(b10);
b10.addActionListener(this);

b11=new JButton("Policy Transaction");                                 //
b11.setBounds(600,300,150,30);
b11.setFont(f1);
b11.setForeground(Color.BLUE);
bg.add(b11);
b11.addActionListener(this);


f.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b9)
{
JOptionPane.showMessageDialog(f,"Are you sure logout? then click on OK");
Login l=new Login();
f.dispose();
}

else if(ae.getSource()==b1)
{
JOptionPane.showMessageDialog(f,"Welcome to Open Account");
MainOpenAccount n=new MainOpenAccount();
f.dispose(); 
}

else if(ae.getSource()==b2)
{
JOptionPane.showMessageDialog(f,"Welcome to Account Detail.");
MainAccount a=new MainAccount();
f.dispose();
}

else if(ae.getSource()==b3)
{
JOptionPane.showMessageDialog(f,"Welcome to Cash Department");
MainTransaction b=new MainTransaction();
f.dispose();
}

else if(ae.getSource()==b4)
{
JOptionPane.showMessageDialog(f,"Welcome to Loan Details");
MainLoan c=new MainLoan();
f.dispose();
}

else if(ae.getSource()==b5)
{
JOptionPane.showMessageDialog(f,"Welcome to Your Loan");
MainCustomerLoan d=new MainCustomerLoan();
f.dispose();
}

else if(ae.getSource()==b8)
{
JOptionPane.showMessageDialog(f,"Welcome to Total Accounts");
MainTotalDetail l=new MainTotalDetail();
f.dispose();
}

else if(ae.getSource()==b6)
{
JOptionPane.showMessageDialog(f,"Welcome to Policy Details");
MainPolicy pc=new MainPolicy();
f.dispose();
}

else if(ae.getSource()==b7)
{
JOptionPane.showMessageDialog(f,"Welcome to Customer Policy Details");
MainCustomerPolicy pc=new MainCustomerPolicy();
f.dispose();
}

else if(ae.getSource()==b10)
{
JOptionPane.showMessageDialog(f,"Welcome to Your Loan");
MainLoanTransaction l=new MainLoanTransaction();
f.dispose();
}

else if(ae.getSource()==b11)
{
JOptionPane.showMessageDialog(f,"Welcome to policy amount");
MainPolicyTransaction l=new MainPolicyTransaction();
f.dispose();
}


}//method

}//class

class MainDemo
{
public static void main(String[] a)
{
Main l=new Main();
}
}