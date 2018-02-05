import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class form6 extends JFrame implements ActionListener
{
	JPanel jp;
	JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6,lb7,
	lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15;
	JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,
	txt8,txt9,txt10,txt11,txt12,txt13,txt14,txt15;
	JButton btn1,btn2,btn3,btn4,btn5;
	Connection con;
	PreparedStatement ps;

		form6()
	{
		super("FORM 6");
		jp=new JPanel();
		jp.setLayout(null);
		jp.setBackground(Color.gray);
		getContentPane().add(jp);
			lb=new JLabel("RETRIEVE STUDENT DETAIL");
			lb.setFont(new Font("Courier New",Font.BOLD,50));
			lb.setForeground(Color.black);
		lb1=new JLabel("Student ID");
	lb1.setFont(new Font("courier New",Font.BOLD,20));
	lb1.setForeground(Color.black);	
		lb2=new JLabel("Student Name");
	lb2.setFont(new Font("courier New",Font.BOLD,20));
	lb2.setForeground(Color.black);	
		lb3=new JLabel("Father Name");
	lb3.setFont(new Font("Courier New",Font.BOLD,20));
	lb3.setForeground(Color.black);	
		lb4=new JLabel("Address ");
	lb4.setFont(new Font("Courier New",Font.BOLD,20));
	lb4.setForeground(Color.black);
		lb5=new JLabel("City");	
	lb5.setFont(new Font("Courier New",Font.BOLD,20));
	lb5.setForeground(Color.black);
		lb6=new JLabel("Pin");
	lb6.setFont(new Font("Courier New",Font.BOLD,20));
	lb6.setForeground(Color.black);
		lb7=new JLabel("State");
	lb7.setFont(new Font("Courier New",Font.BOLD,20));
	lb7.setForeground(Color.black);
		lb8=new JLabel("Contact No.");
	lb8.setFont(new Font("Courier New",Font.BOLD,20));
	lb8.setForeground(Color.black);
		lb9=new JLabel("Email ID");
	lb9.setFont(new Font("Courier New",Font.BOLD,20));
	lb9.setForeground(Color.black);
		lb10=new JLabel("Admission Date");
	lb10.setFont(new Font("Courier New",Font.BOLD,20));
	lb10.setForeground(Color.black);
		lb11=new JLabel("Draft No.");
	lb11.setFont(new Font("Courier New",Font.BOLD,20));
	lb11.setForeground(Color.black);
		lb12=new JLabel("Course");
	lb12.setFont(new Font("Courier New",Font.BOLD,20));
	lb12.setForeground(Color.black);
		lb13=new JLabel("Semester");
	lb13.setFont(new Font("Courier New",Font.BOLD,20));
	lb13.setForeground(Color.black);
		lb14=new JLabel("Fee Paid");
	lb14.setFont(new Font("Courier New",Font.BOLD,20));
	lb14.setForeground(Color.black);
		lb15=new JLabel("Balance");
	lb15.setFont(new Font("Courier New",Font.BOLD,20));
	lb15.setForeground(Color.black);
		
	txt1=new JTextField ();
	txt2=new JTextField();
	txt3=new JTextField();
	txt4=new JTextField();
	txt5=new JTextField();
	txt6=new JTextField();
	txt7=new JTextField(); 
	txt8=new JTextField();
	txt9=new JTextField();
	txt10=new JTextField();
	txt11=new JTextField();
	txt12=new JTextField();
	txt13=new JTextField();
	txt14=new JTextField();
	txt15=new JTextField();

	btn1=new JButton("RETRIEVE");
	btn2=new JButton("RESET");
	btn3=new JButton("UPDATE");
	btn4=new JButton("DELETE");
	btn5=new JButton("CANCEL");

		jp.add(lb);
		jp.add(lb1);
		jp.add(txt1);
		jp.add(lb2);
		jp.add(txt2);	
		jp.add(lb3);
		jp.add(txt3);
		jp.add(lb4);
		jp.add(txt4);
		jp.add(lb5);
		jp.add(txt5);
		jp.add(lb6);
		jp.add(txt6);
		jp.add(lb7);
		jp.add(txt7);
		jp.add(lb8);
		jp.add(txt8);
		jp.add(lb9);
		jp.add(txt9);
		jp.add(lb10);
		jp.add(txt10);
		jp.add(lb11);
		jp.add(txt11);
		jp.add(lb12);
		jp.add(txt12);
		jp.add(lb13);
		jp.add(txt13);
		jp.add(lb14);
		jp.add(txt14);
		jp.add(lb15);
		jp.add(txt15);

		jp.add(btn1);
		jp.add(btn2);
		jp.add(btn3);
		jp.add(btn4);
		jp.add(btn5);

	lb.setBounds(250,50,800,30);
	lb1.setBounds(50,150,200,40);
	lb2.setBounds(600,150,200,40);
	lb3.setBounds(50,200,200,40);
	lb4.setBounds(50,250,200,40);
	lb5.setBounds(600,250,200,40);
	lb6.setBounds(50,300,200,40);
	lb7.setBounds(600,300,200,40);
	lb8.setBounds(50,350,200,40);
	lb9.setBounds(600,350,200,40);
	lb10.setBounds(50,400,200,40);
	lb11.setBounds(600,400,200,40);
	lb12.setBounds(50,450,200,40);
	lb13.setBounds(600,450,200,40);
	lb14.setBounds(50,500,200,40);
	lb15.setBounds(600,500,200,40);

txt1.setBounds(300,150,200,40);
txt2.setBounds(800,150,200,40);
txt3.setBounds(300,200,200,40);
txt4.setBounds(300,250,200,40);
txt5.setBounds(800,250,200,40);
txt6.setBounds(300,300,200,40);
txt7.setBounds(800,300,200,40);
txt8.setBounds(300,350,200,40);
txt9.setBounds(800,350,200,40);
txt10.setBounds(300,400,200,40);
txt11.setBounds(800,400,200,40); 
txt12.setBounds(300,450,200,40);
txt13.setBounds(800,450,200,40);
txt14.setBounds(300,500,200,40);
txt15.setBounds(800,500,200,40);

btn1.setBounds(100,600,100,40);
btn2.setBounds(300,600,100,40);
btn3.setBounds(500,600,100,40);
btn4.setBounds(700,600,100,40);
btn5.setBounds(900,600,100,40);

btn1.addActionListener(this);
btn2.addActionListener(this);
btn3.addActionListener(this);
btn4.addActionListener(this);
btn5.addActionListener(this);

	setVisible(true);
	setSize(1000,1000);

    }	
			public void actionPerformed(ActionEvent e)
			{
				Object o=e.getSource();
				JOptionPane msg=new JOptionPane();
			if(o==btn1)
			{
			try
			{
		
				String code=txt1.getText();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("Jdbc:Odbc:data");
				ps=con.prepareStatement("select * from studentdetail where id=?");
				ps.setString(1,code);
				ResultSet rs;
				rs=ps.executeQuery();

			if(rs.next())
		{
msg.showMessageDialog(null,"VALID ID","Information",1);
			txt2.setText(rs.getString(2));
			txt3.setText(rs.getString(3));
			txt4.setText(rs.getString(4));
			txt5.setText(rs.getString(5));
			txt6.setText(rs.getString(6));
			txt7.setText(rs.getString(7));
			txt8.setText(rs.getString(8));
			txt9.setText(rs.getString(9));
			txt10.setText(rs.getString(10));
			txt11.setText(rs.getString(11));
			txt12.setText(rs.getString(12));
			txt13.setText(rs.getString(13));
			txt14.setText(rs.getString(14));
			txt15.setText(rs.getString(15));

		}
		else
		{
			msg.showMessageDialog(null,"Record is not Exist","Information",1);
		}
}
			catch(Exception ee)
			{
                            ee.printStackTrace();
                        }

		}
			else if(o==btn2)
			{
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
				txt5.setText("");
				txt6.setText("");
				txt7.setText("");
				txt8.setText("");
				txt9.setText("");
				txt10.setText("");
				txt11.setText("");
				txt12.setText("");
				txt13.setText("");
				txt14.setText("");
				txt15.setText("");
			}

	if(o==btn3)
	{
	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("Jdbc:Odbc:data");
		ps=con.prepareStatement("insert into upstudent values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,txt1.getText());
		ps.setString(2,txt2.getText());
		ps.setString(3,txt3.getText());
		ps.setString(4,txt4.getText());
		ps.setString(5,txt5.getText());
		ps.setString(6,txt6.getText());
		ps.setString(7,txt7.getText());
		ps.setString(8,txt8.getText());
		ps.setString(9,txt9.getText());
		ps.setString(10,txt10.getText());
		ps.setString(11,txt11.getText());
		ps.setString(12,txt12.getText());
		ps.setString(13,txt13.getText());
		ps.setString(14,txt14.getText());
		ps.setString(15,txt15.getText());
		ps.executeUpdate();

msg.showMessageDialog(null,"RECORD IS UPDATED","info",1);
	}
	catch(Exception ee)
{
	msg.showMessageDialog(null,"RECORD IS ALREADY EXIST"+ee,"Information",1);
}
	
}
	
		if(o==btn4)
		{
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("Jdbc:Odbc:data");
		ps=con.prepareStatement("delete * from studentdetail where id=?");
		ps.setString(1,txt1.getText());
		ps.executeUpdate();

		msg.showMessageDialog(null,"RECORD IS DELETED","Information",1);
	
	}	
		catch(Exception ee)
	{
			msg.showMessageDialog(null,"Record is not Found"+ee,"Information",1);
	}
}
			else if(o==btn5)
			{
                            this.dispose();
			}
			

		}
	}