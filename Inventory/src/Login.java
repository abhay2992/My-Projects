import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    Icon i1,i2;
    JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
    JPanel jp;
    JTextField tf1;
    JPasswordField jpf;
    JButton bt1,bt2;
    String user;
    public Login()
    {
        super("Inventory - Login");
        setBounds(180, 20, 1000, 680);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        lb1=new JLabel();
        lb2=new JLabel();
        lb3=new JLabel("Welcome to the Inventory System");
        lb4=new JLabel("Username");
        lb5=new JLabel("Password");
        lb6=new JLabel("Wrong Username or Password.");
        lb7=new JLabel("You have been Successfully Logged out..!!");
        jp=new JPanel();
        tf1=new JTextField(25);
        jpf=new JPasswordField(25);
        bt1=new JButton("Login");
        bt2=new JButton("New User");
        jpf.setEchoChar('*');
        jp.setLayout(null);
        lb1.setBounds(90,10,800,80);
        lb2.setBounds(0,85,1000,380);
        
        jp.setBounds(0,465,1000,235);
        
        lb3.setBounds(50,20,600,30);
        lb4.setBounds(600,28,80,10);
        lb5.setBounds(600,60,80,10);
        lb6.setBounds(720, 87, 200, 10);
        lb7.setBounds(50, 100, 600, 30);
        tf1.setBounds(700, 20, 230, 25);
        jpf.setBounds(700, 55, 230, 25);
        bt1.setBounds(720, 110, 80, 25);
        bt2.setBounds(810, 110, 90, 25);
        i1= new ImageIcon(getClass().getResource("c.jpg"));
        i2= new ImageIcon(getClass().getResource("a.jpg"));
        lb1.setIcon(i1);
        lb2.setIcon(i2);
        lb3.setForeground(Color.BLUE);
        lb4.setForeground(Color.BLUE);
        lb5.setForeground(Color.BLUE);
        lb6.setForeground(Color.red);
        lb7.setForeground(Color.red);
        
        lb3.setFont(new Font("Times new roman", Font.BOLD,24));
        lb7.setFont(new Font("Times new roman", Font.BOLD,24));
        jp.add(lb3);
        jp.add(lb4);
        jp.add(lb5);
        jp.add(lb6);
        jp.add(lb7);
        
        jp.add(tf1);
        jp.add(jpf);
        jp.add(bt1);
        jp.add(bt2);
        
        lb6.setVisible(false);
        lb7.setVisible(false);
        
        jp.setBackground(new Color(60, 160, 255));
        getContentPane().setBackground(new Color(60, 160, 255));
        add(lb1);
        add(lb2);
        add(jp);
        tf1.addActionListener(this);
        jpf.addActionListener(this);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        addWindowListener(new WindowAdapter()
            {
                public void windowActivated(WindowEvent e)
                {
                    tf1.requestFocus();
                }
            }
        );
        
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==tf1)
        {
            jpf.requestFocus();
        }
        
        else if((e.getSource()==jpf)||(e.getSource()==bt1))
        {
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","abhay","abhay");
                Statement stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs= stmt.executeQuery("select * from user_accounts where username = '"+tf1.getText()+"' and password = '"+jpf.getText()+"'");
                if(rs.next())
                {
                    lb6.setVisible(false);
                    stmt.close();
                    conn.close();
                    this.dispose();
                    user=tf1.getText();
                    InventoryFrame i1=new InventoryFrame(user);
                }
                else
                {
                    lb6.setVisible(true);
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        else if(e.getSource()==bt2)
        {
            Signup obj=new Signup(); 
            
        }
        
    }
    
    public static void main(String args[])
    {
        Login l=new Login();
    }
    
}
