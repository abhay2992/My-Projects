import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class form10 extends JFrame implements ActionListener
{
			JPanel jp;
			JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6;
			Choice c;
			JTextField txt1,txt2,txt3,txt4,txt5;
			JButton btn1,btn2;
			Connection con;
			PreparedStatement ps;
	
		form10()
	{
		super("Form 10");
		jp=new JPanel();
		jp.setLayout(null);
		jp.setBackground(Color.gray);
		getContentPane().add(jp);
	
		lb=new JLabel("Study Programmes Offered");
	lb.setFont(new Font("Courier New",Font.BOLD,50));
	lb.setForeground(Color.black);
		lb1=new JLabel("Course Name");
	lb1.setFont(new Font("Courier New",Font.BOLD,20));
	lb1.setForeground(Color.black);
		lb2=new JLabel("Duration");
	lb2.setFont(new Font("Courier New",Font.BOLD,20));
	lb2.setForeground(Color.black);
		lb3=new JLabel("MAX Duration");
	lb3.setFont(new Font("Courier New",Font.BOLD,20));
	lb3.setForeground(Color.black);
		lb4=new JLabel("MIN Duration");
	lb4.setFont(new Font("Courier New",Font.BOLD,20));
	lb4.setForeground(Color.black);
		lb5=new JLabel("Eligibility");
	lb5.setFont(new Font("Courier New",Font.BOLD,20));
	lb5.setForeground(Color.black);
		lb6=new JLabel("Fee Plan");
	lb6.setFont(new Font("Courier New",Font.BOLD,20));
	lb6.setForeground(Color.black);	
		
c=new Choice();
c.add("Select");
c.add("DCA");
c.add("PGDCA");
c.add("ADHNT#");
c.add("PGDBM");
c.add("BSC-IT");
c.add("MSC-IT");
c.add("BBA");
c.add("MBA");
c.add("BCA");
c.add("MCA");
txt1=new JTextField();
txt2=new JTextField();
txt3=new JTextField();
txt4=new JTextField();
txt5=new JTextField();

	btn1=new JButton("RETRIEVE");
	btn2=new JButton("CANCEL");

			jp.add(lb);
			jp.add(lb1);
			jp.add(c);
			jp.add(lb2);
			jp.add(txt1);
			jp.add(lb3);
			jp.add(txt2);
			jp.add(lb4);
			jp.add(txt3);
			jp.add(lb5);
			jp.add(txt4);
			jp.add(lb6);
			jp.add(txt5);
			
			jp.add(btn1);
			jp.add(btn2);

	lb.setBounds(250,50,800,50);
	lb1.setBounds(100,200,200,40);
	lb2.setBounds(100,250,200,40);
	lb3.setBounds(100,300,200,40);
	lb4.setBounds(100,350,200,40);
	lb5.setBounds(100,400,200,40);
	lb6.setBounds(100,450,200,40);

c.setBounds(400,200,200,40);
txt1.setBounds(400,250,200,30);
txt2.setBounds(400,300,200,30);
txt3.setBounds(400,350,200,30);
txt4.setBounds(400,400,200,30);
txt5.setBounds(400,450,200,30);

	btn1.setBounds(300,600,150,40);
	btn2.setBounds(600,600,150,40);

	btn1.addActionListener(this);
	btn2.addActionListener(this);

setVisible(true);
setSize(300,300);

		}
				public void actionPerformed (ActionEvent e)
			{
					Object o=e.getSource();
					JOptionPane msg=new JOptionPane();

				if(o==btn1)
				{
				try
				{
					String code=c.getSelectedItem();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("Jdbc:Odbc:data");
				ps=con.prepareStatement("Select * from coursedetail where coursename=?");
				ps.setString(1,code);
				ResultSet rs;
				rs=ps.executeQuery();
msg.showMessageDialog(null,"VALID ID","Information",1);

			if(rs.next())
			{
				txt1.setText(rs.getString(2));
				txt2.setText(rs.getString(3));
				txt3.setText(rs.getString(4));
				txt4.setText(rs.getString(5));
				txt5.setText(rs.getString(6));
		
				
			
			}

	}
			catch(Exception ee)
			{
				msg.showMessageDialog(null,"INVALID"+ee,"Information",1);
			}
}
			else if(o==btn2)
			{
				this.dispose();
			}
	}
			
}