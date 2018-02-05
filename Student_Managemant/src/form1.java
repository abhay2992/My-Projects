import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class form1 extends JFrame implements ActionListener
{
	JPanel jp;
	JLabel lb,lbl,lbl1;
	JTextField txt;
	JPasswordField txt1;
	JButton btn;
	Connection con;
	PreparedStatement ps;
	
	form1()
{
	super("Login Form");
	jp=new JPanel();
	jp.setLayout(null);
	jp.setBackground(Color.gray);
	getContentPane().add(jp);
		lb=new JLabel("LOGIN FORM");
	lb.setFont(new Font("Courier New",Font.BOLD,50));	
	lb.setForeground(Color.black);
		lbl=new JLabel("USER NAME :");
	lbl.setFont(new Font("Courier New",Font.BOLD,20));
	lbl.setForeground(Color.black);
		lbl1=new JLabel("USER PASSWORD :");
	lbl1.setFont(new Font("Courier New",Font.BOLD,20));
	lbl1.setForeground(Color.black);

	txt=new JTextField();
	txt1=new JPasswordField();
	txt1.setEchoChar('*');
	txt1.setForeground(Color.black);
	btn=new JButton("Sign-In");
		jp.add(lb);
		jp.add(lbl);
		jp.add(txt);
		jp.add(lbl1);
		jp.add(txt1);
		jp.add(btn);
	
			lb.setBounds(400,100,300,50);
			lbl.setBounds(300,200,200,50);
			lbl1.setBounds(300,300,200,50);
			txt.setBounds(600,200,150,40);
			txt1.setBounds(600,300,150,40);
			btn.setBounds(500,400,100,40);

			btn.addActionListener(this);
	setVisible(true);
	setSize(100,100);
}

	public void actionPerformed(ActionEvent e)
	{
		Object o=e.getSource();
		JOptionPane msg=new JOptionPane();
			  try
			{
			if(o==btn)
			{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 con=DriverManager.getConnection("Jdbc:Odbc:data");
		 ps=con.prepareStatement("select * from login where  id=? and pass=?");
			ps.setString(1,txt.getText());
			ps.setString(2,txt1.getText());
			ResultSet rs=ps.executeQuery();

			if(rs.next())
			{
	msg.showMessageDialog(null,"WELCOME","Information",1);
				form2 f=new form2();
				this.dispose();

			}
		else
		{
			msg.showMessageDialog(null,"Invalid Password","Information",1);
		}
}
}
			catch(Exception ee)
		{
                    ee.printStackTrace();
		}
		
}
		
		public static void main(String s[])
	{
		new form1();
	}
}