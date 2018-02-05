import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class main1 extends JFrame implements ActionListener
{
	JMenu acd,vd,tr,inst;
	JMenuItem m1,m2,m3,m4,m5,m6;
	JMenuBar b;
	
 amount_deposit ad;
	public main1()
	{
	acd=new JMenu("Account Details");
	vd=new JMenu("View Details");
	tr=new JMenu("Transactions");
	inst=new JMenu("Interest");
	b=new JMenuBar();
	m1=new JMenuItem("Create Customer Account");
	m2=new JMenuItem("View Customer Account");
	m3=new JMenuItem("Amount Deposit");
	m4=new JMenuItem("Amount Withdrawal");
	m5=new JMenuItem("Calculate Interest ");
	m6=new JMenuItem("View Interest ");
	acd.add(m1);
	vd.add(m2);
	tr.add(m3);
	tr.add(m4);
	inst.add(m5);
	inst.add(m6);
    b.add(acd);
    b.add(vd);
    b.add(tr);
    b.add(inst);
    setJMenuBar(b);
	m1.addActionListener(this);
	m2.addActionListener(this);
	m3.addActionListener(this);
	m4.addActionListener(this);
	m5.addActionListener(this);
	m6.addActionListener(this);
	}

    
	
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	     
		if(arg0.getSource()==m1)
		{
			customer_account q=new customer_account();
			q.setSize(1000,900);
			q.setVisible(true);
			//q.setTitle("Customer Account/BANKING SYSTEM/ SARANG KAUR(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
			
		}
		if(arg0.getSource()==m2)
		{
			view_customer_details d=new view_customer_details();
			d.setSize(1000,900);
			d.setVisible(true);
			//d.setTitle("View Customer Details/BANKING SYSTEM/ SARANG KAUR(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
		 	
		}
		if(arg0.getSource()==m3)
		{
			amount_deposit e=new amount_deposit();

			e.setSize(1000,900);
			e.setVisible(true);
			//e.setTitle("Amount Deposit/BANKING SYSTEM/ SARANG KAUR(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
		 	
		}
		if(arg0.getSource()==m4)
		{
			amount_withdrawal w=new amount_withdrawal();
			w.setSize(1000,900);
			w.setVisible(true);
			//w.setTitle("Amount Withdrawal/BANKING SYSTEM/ SARANG KAUR(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
		 	
		}
		if(arg0.getSource()==m5)
		{
			customer_interest c=new customer_interest();
			c.setSize(1000,900);
			c.setVisible(true);
			//c.setTitle("Customer Interest/BANKING SYSTEM/ SARANG KAUR(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
		 	
		}
		
		if(arg0.getSource()==m6)
		{
			view_interest c=new view_interest();
			c.setSize(1000,900);
			c.setVisible(true);
			//c.setTitle("Customer Interest/BANKING SYSTEM/ SARANG KAUR(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
		 	
		}
	}
	public static void main(String args[])
	{
		
        main1 k=new main1();
		k.setSize(1000,1000);
		k.setVisible(true);
		k.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	k.setTitle("Main Menu/BANKING SYSTEM/ SARANG KAUR(B.tech CSE 3rd yr GNDU Amritsar) copyright protection");
	 	
	
	}
	}


