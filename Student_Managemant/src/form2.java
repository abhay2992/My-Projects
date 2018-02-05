import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class form2 extends JFrame implements ActionListener
{
		JPanel jp;
		JMenuBar mb;
		JMenu m1,m2,m3,m4;
		JMenuItem mi1,mi2,mi3,mi4,mi5,
		mi6,mi7,mi8,mi9,mi10;
		
	form2()
{
	super("Form 2");
	jp=new JPanel();
	getContentPane().add(jp);
	mb=new JMenuBar();
	setJMenuBar(mb);
	m1=new JMenu("Student Detail");
	m2=new JMenu("Staff Detail");
	m3=new JMenu("Courses");
	m4=new JMenu("Fees Detail");

		mi1=new JMenuItem("Admission Form");
		mi2=new JMenuItem("Enquiry Form");
		mi3=new JMenuItem("Re-Admission Form");	
		mi4=new JMenuItem("Retrieve Student Record");

		mi5=new JMenuItem("Technical Staff");
		mi6=new JMenuItem("Non-Technical Staff");
		mi7=new JMenuItem("Retrieve Teacher Record");
		mi8=new JMenuItem("Study Programmes");
		mi9=new JMenuItem("Fee Plan");
		mi10=new JMenuItem("Exit");

	mb.add(m1);
	mb.add(m2);
	mb.add(m3);
	mb.add(m4);
	m1.add(mi1);
	m1.add(mi2);
	m1.add(mi3);
	m1.add(mi4);

	
m2.add(mi5);
m2.add(mi6);
m2.add(mi7);

	m3.add(mi8);
	m4.add(mi9);
	m4.add(mi10);

 	mi1.addActionListener(this);
	mi2.addActionListener(this);
 	mi3.addActionListener(this);
	mi4.addActionListener(this);
	mi5.addActionListener(this);
	mi6.addActionListener(this);
	mi7.addActionListener(this);
	mi8.addActionListener(this);
	mi9.addActionListener(this);
	mi10.addActionListener(this);

	
	setVisible(true);
	setSize(300,300);
}
		public void actionPerformed(ActionEvent e)
	{
		Object o = e.getSource();
			if(o==mi1)
			{
				form3 f3=new form3();
				this.dispose();
			}
			else if(o==mi2)
			{
				form4 f4=new form4();
				this.dispose();
			}
			else if(o==mi3)
			{
				form5 f5=new form5();
				this.dispose();
			}
			else if(o==mi4)
			{
				form6 f6=new form6();
				this.dispose();
			}
			else if(o==mi5)
			{
				form7 f7=new form7();
				this.dispose();
			}
			else if(o==mi6)
			{
				form8 f8=new form8();
				this.dispose();
			}
			else if(o==mi7)
			{
				form9 f9=new form9();
				this.dispose();
			}
			else if(o==mi8)
			{
				form10 f10=new form10();
				this.dispose();
			}
			else if(o==mi9)
			{
				form11 f11=new form11();
				this.dispose();
			}
			else if(o==mi10)
			{
							this.dispose();
			}

	}
	
}
