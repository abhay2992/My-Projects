import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class form11 extends JFrame implements ActionListener
{
	JPanel jp;
	JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6,lb7;
	JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7;
	JButton btn1,btn2,btn3;
	Connection con;
	PreparedStatement ps;	

		form11()
	{
		super("FORM 11");
		jp=new JPanel();
		jp.setLayout(null);
		jp.setBackground(Color.gray);
		getContentPane().add(jp);
			lb=new JLabel("Fee Detail");
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
		lb4=new JLabel("Course ");
	lb4.setFont(new Font("Courier New",Font.BOLD,20));
	lb4.setForeground(Color.black);
		lb5=new JLabel("Semester");	
	lb5.setFont(new Font("Courier New",Font.BOLD,20));
	lb5.setForeground(Color.black);
		lb6=new JLabel("Fee Paid");
	lb6.setFont(new Font("Courier New",Font.BOLD,20));
	lb6.setForeground(Color.black);
		lb7=new JLabel("Balance");
	lb7.setFont(new Font("Courier New",Font.BOLD,20));
	lb7.setForeground(Color.black);
	
	
		
	txt1=new JTextField ();
	txt2=new JTextField();
	txt3=new JTextField();
	txt4=new JTextField();
	txt5=new JTextField();
	txt6=new JTextField();
	txt7=new JTextField(); 
	

	btn1=new JButton("RETRIEVE");
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
		jp.add(txt4);
		jp.add(lb5);
		jp.add(txt5);
		jp.add(lb6);
		jp.add(txt6);
		jp.add(lb7);
		jp.add(txt7);
		jp.add(btn1);
		jp.add(btn2);
		jp.add(btn3);
	lb.setBounds(400,50,800,40);
	lb1.setBounds(50,150,200,40);
	lb2.setBounds(600,150,200,40);
	lb3.setBounds(50,200,200,40);
	lb4.setBounds(50,250,200,40);
	lb5.setBounds(600,250,200,40);
	lb6.setBounds(50,300,200,40);
	lb7.setBounds(600,300,200,40);


txt1.setBounds(300,150,200,40);
txt2.setBounds(800,150,200,40);
txt3.setBounds(300,200,200,40);
txt4.setBounds(300,250,200,40);
txt5.setBounds(800,250,200,40);
txt6.setBounds(300,300,200,40);
txt7.setBounds(800,300,200,40);

btn1.setBounds(400,400,100,40);
btn2.setBounds(600,400,100,40);
btn3.setBounds(800,400,100,40);

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
			String code=txt1.getText();
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con=DriverManager.getConnection("Jdbc:Odbc:data");
		ps=con.prepareStatement("select id,stuname,fname,course,semester,feepaid,balance from studentdetail where id=?");
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
		}
else
{
msg.showMessageDialog(null,"ID is not exist","Information",1);
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
}	
				else if(o==btn3)
				{
                                    this.dispose();
				}
		

			}
	
	}