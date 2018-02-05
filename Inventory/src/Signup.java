import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
public class Signup extends JFrame implements ActionListener,TextListener
{
    JLabel lb1,lb2,lb3,lb4,lb5;
    TextField tf1;
    JPasswordField jpf;
    JButton bt1;
    Icon icy, icn;
    Connection conn;
    Statement stmt;
    
    public Signup()
    {
        super("Signup - Form");
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(450,80,500,400);
        icy= new ImageIcon(getClass().getResource("yes.jpg"));
        icn= new ImageIcon(getClass().getResource("no.jpg"));
        lb1=new JLabel("Username *");
        lb2=new JLabel("Password *");
        lb3=new JLabel();
        lb4=new JLabel("Form not filled Accurately..!!");
        lb5=new JLabel("Account created Successfully..!!");
        tf1=new TextField();
        jpf=new JPasswordField();
        bt1=new JButton("Submit");
        lb1.setBounds(100,100,80,20);
        lb2.setBounds(100,140,80,20);
        tf1.setBounds(180,100,200,20);
        jpf.setBounds(180,140,200,20);
        bt1.setBounds(300,200,80,25);
        lb3.setBounds(385,97,25,25);
        lb4.setBounds(100,300,300,25);
        lb5.setBounds(100,340,300,25);
        lb4.setFont(new Font("Ariel",Font.BOLD,20));
        lb5.setFont(new Font("Ariel",Font.BOLD,20));
        lb4.setForeground(Color.red);
        lb5.setForeground(Color.green);
        lb4.setVisible(false);
        lb5.setVisible(false);
        add(lb1);
        add(lb2);
        add(lb3);
        add(lb4);
        add(lb5);
        add(tf1);
        add(jpf);
        add(bt1);
        tf1.addTextListener(this);
        jpf.addActionListener(this);
        bt1.addActionListener(this);
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","abhay","abhay");
            stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
        }
        catch(Exception ex1)
        {
            ex1.printStackTrace();
        }
        
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if((e.getSource()==jpf)||(e.getSource()==bt1))
        {
            if((tf1.getText().isEmpty())||(jpf.getText().isEmpty())||(lb3.getIcon()==icn))
            {
                lb5.setVisible(false);
                lb4.setVisible(true);
            }
            else if(lb3.getIcon()==icy)
            {
                try
                {
                    
                    stmt.execute("insert into user_accounts values ('"+tf1.getText()+"','"+jpf.getText()+"')");
                    lb4.setVisible(false);
                    lb5.setVisible(true);
                    JOptionPane.showMessageDialog(this, "Account created Successfully.");
                    stmt.close();
                    conn.close();
                    this.dispose();                    
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                
            }
        }
    }

    @Override
    public void textValueChanged(TextEvent te)
    {
        try
        {
            ResultSet rs= stmt.executeQuery("select * from user_accounts where username = '"+tf1.getText()+"'");
            if(rs.next())
            {
                lb3.setIcon(icn); 
            }
            else
            {
                lb3.setIcon(icy);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
