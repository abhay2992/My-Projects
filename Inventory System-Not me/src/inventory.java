import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class inventory extends JFrame implements ActionListener{

JMenuBar mb;
JButton m1,m2,m3,m4,m5,m6,pd;
JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
JMenu file,detail;
JLabel l1;
String sq;

	public inventory()
	{
		setBackground(Color.black);
	
		
		l1=new JLabel(sq);
		FlowLayout f=new FlowLayout(FlowLayout.LEFT);
		setTitle("Inventory System/ NITIN JINDAL(B.tech CSE 3rd yr GNDU Amritsar) copyright protection ");
		mb=new JMenuBar();
		file=new JMenu("Menu");
		detail=new JMenu("Balance");
		pd=new JButton("Product Balance");
		m1=new JButton("Category");
		m2=new JButton("Product");
		m3=new JButton("Supplier");
		m4=new JButton("Customer");
		m5=new JButton("Purchase");
		m6=new JButton("Sale");
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		p9=new JPanel();
		p10=new JPanel();
		
		p1.add(m1);
		p2.add(m2);
		p3.add(m3);
		p4.add(m4);
		p5.add(m5);
		p6.add(m6);
		p7.add(pd);
		
		p8.add(p1);
		p8.add(p2);
		p8.add(p3);
		p8.add(p4);
		p8.add(p5);
		p8.add(p6);
		p8.add(p7);
		
		add(p8);
		add(l1);
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);
		m5.addActionListener(this);
		m6.addActionListener(this);
		pd.addActionListener(this);
		setLayout(f);
		}
public static void main(String a[])
{
	inventory z=new inventory();
	z.setSize(770,250);
	z.setVisible(true);
}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==m1)
		{
			category k=new category();
			k.setSize(400,200);
			k.setVisible(true);
		
		}
		if(arg0.getSource()==m2)
		{
			product k=new product();
			k.setSize(400,400);
			k.setVisible(true);
		
		}
		if(arg0.getSource()==m3)
		{
			suplier k=new suplier();
			k.setSize(400,500);
			k.setVisible(true);
		
		}
		if(arg0.getSource()==m4)
		{
			customer k=new customer();
			k.setSize(400,500);
			k.setVisible(true);
		
		}
		if(arg0.getSource()==m5)
		{
			purchase k=new purchase();
			k.setSize(600,700);
			k.setVisible(true);
		
		}
		if(arg0.getSource()==m6)
		{
			
				sale k=new sale();
				k.setSize(600,700);
				k.setVisible(true);
			
		}
		if(arg0.getSource()==pd)
		{
				getdetail m =new getdetail();
				m.setSize(400,350);
				m.setVisible(true);
			
		}
	}

}
