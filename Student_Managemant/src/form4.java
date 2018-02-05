import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class form4 extends JFrame implements ActionListener
{
	JPanel jp;
	JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6,lb7,
	lb8,lb9,lb10,lb11,lb12,lb13;
	JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;
	Choice c1,c2,c3,c4,c5,c6;
	Connection con;
	PreparedStatement ps;

	JButton btn1,btn2,btn3;	

		form4()
	{
		super("FORM 4");
		jp=new JPanel();
		jp.setLayout(null);
		jp.setBackground(Color.gray);
		getContentPane().add(jp);
			lb=new JLabel("Enquiry Detail");
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
		lb4=new JLabel("Occupation ");
	lb4.setFont(new Font("Courier New",Font.BOLD,20));
	lb4.setForeground(Color.black);
		lb5=new JLabel("Qualification");	
	lb5.setFont(new Font("Courier New",Font.BOLD,20));
	lb5.setForeground(Color.black);
		lb6=new JLabel("Address");
	lb6.setFont(new Font("Courier New",Font.BOLD,20));
	lb6.setForeground(Color.black);
		lb7=new JLabel("City");
	lb7.setFont(new Font("Courier New",Font.BOLD,20));
	lb7.setForeground(Color.black);
		lb8=new JLabel("pin");
	lb8.setFont(new Font("Courier New",Font.BOLD,20));
	lb8.setForeground(Color.black);
		lb9=new JLabel("State");
	lb9.setFont(new Font("Courier New",Font.BOLD,20));
	lb9.setForeground(Color.black);
		lb10=new JLabel("Contact No.");
	lb10.setFont(new Font("Courier New",Font.BOLD,20));
	lb10.setForeground(Color.black);
		lb11=new JLabel("Email ID");
	lb11.setFont(new Font("Courier New",Font.BOLD,20));
	lb11.setForeground(Color.black);
		lb12=new JLabel("Are you Employe");
	lb12.setFont(new Font("Courier New",Font.BOLD,20));
	lb12.setForeground(Color.black);
		lb13=new JLabel("Do you have Background in Computers");
	lb13.setFont(new Font("Courier New",Font.BOLD,20));
	lb13.setForeground(Color.black);
		
	txt1=new JTextField ();
	txt2=new JTextField();
	txt3=new JTextField();
	c1=new Choice();
		c1.add("employe");
		c1.add("self employe");
		c1.add("unemploye");
	c2=new Choice();
		c2.add("Matric");
		c2.add("+2");
		c2.add("Graduate");
		c2.add("Post Graduate");
	txt4=new JTextField();
	c3=new Choice();
		c3.add("Amritsar");
		c3.add("ffg"); 
		c3.add("aab");
	txt5=new JTextField();
	c4=new Choice();
		c4.add("Punjab");
		c4.add("Jammu");
		c4.add("bbc");
	txt6=new JTextField();
	txt7=new JTextField();
	c5=new Choice();
		c5.add("Yes");
		c5.add("No");
	c6=new Choice();
		c6.add("Yes");
		c6.add("No");

	btn1=new JButton("SUBMIT");
	btn2=new JButton("RESET");
	btn3=new JButton("CANCEL");
		jp.add(lb);
		jp.add(lb1);
		jp.add(txt1);
		jp.add(lb2);
		jp.add(txt2);	
		jp.add(lb3);
		jp.add(txt3);
		jp.add(lb4);
		jp.add(c1);
		jp.add(lb5);
		jp.add(c2);
		jp.add(lb6);
		jp.add(txt4);
		jp.add(lb7);
		jp.add(c3);
		jp.add(lb8);
		jp.add(txt5);
		jp.add(lb9);
		jp.add(c4);
		jp.add(lb10);
		jp.add(txt6);
		jp.add(lb11);
		jp.add(txt7);
		jp.add(lb12);
		jp.add(c5);
		jp.add(lb13);
		jp.add(c6);
		
		jp.add(btn1);
		jp.add(btn2);
		jp.add(btn3);
	lb.setBounds(400,50,800,50);
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
	lb13.setBounds(50,500,500,40);
	

txt1.setBounds(300,150,200,40);
txt2.setBounds(800,150,200,40);
txt3.setBounds(300,200,200,40);
c1.setBounds(300,250,200,40);
c2.setBounds(800,250,200,40);
txt4.setBounds(300,300,200,40);
c3.setBounds(800,300,200,40);
txt5.setBounds(300,350,200,40);
c4.setBounds(800,350,200,40);
txt6.setBounds(300,400,200,40);
txt7.setBounds(800,400,200,40); 
c5.setBounds(300,450,200,40);
c6.setBounds(550,500,200,40);


btn1.setBounds(300,600,100,40);
btn2.setBounds(500,600,100,40);
btn3.setBounds(700,600,100,40);

btn1.addActionListener(this);
btn2.addActionListener(this);
btn3.addActionListener(this);

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
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("Jdbc:Odbc:data");
			
			ps=con.prepareStatement("insert into enquirydetail values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,txt1.getText());
			ps.setString(2,txt2.getText());
			ps.setString(3,txt3.getText());
			ps.setString(4,(String)c1.getSelectedItem());
			ps.setString(5,txt4.getText());
			ps.setString(6,(String)c2.getSelectedItem());
			ps.setString(7,txt5.getText());
			ps.setString(8,txt6.getText());
			ps.setString(9,txt7.getText());
			ps.setString(10,(String)c3.getSelectedItem());
			ps.setString(11,(String)c4.getSelectedItem());
				ps.setString(12,(String)c5.getSelectedItem());
				ps.setString(13,(String)c6.getSelectedItem());
			
		ps.executeUpdate();

			msg.showMessageDialog(null,"DATA IS SAVED","Information",1);
	}
		catch(Exception ee)
	{
		msg.showMessageDialog(null,"RECORD is ALREADY EXIST","Information"+ee,1);
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
	
			
		}
			
				else if(o==btn3)
				{
                                    this.dispose();
				}
		}
		
	
	}