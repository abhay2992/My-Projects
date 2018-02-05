import java.awt.Color;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;

class My2 extends JFrame implements ActionListener
{
    JTable jt;
    JScrollPane sp;
    JButton b1,b2,b3,b4,b5;
    JLabel lb1;
    JTextField tf1,tf2,tf3;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    ArrayList<Student>al;
    TableModel tm;
    
    My2()
    {
        super("Student- Database");
        setLayout(null);
        setSize(500,500);
        //setVisible(true);
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver loaded successfully");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","abhay","abhay");
            System.out.println("Connection build");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        al=new ArrayList();
        tm=new TableModel();
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jt=new JTable();
        sp=new JScrollPane(jt);
        b1=new JButton("Fetch Data");
        b2=new JButton("Remove");
        b3=new JButton("Insert");
        b4=new JButton("Submit");
        b5=new JButton("Clear");
        tf1=new JTextField("Roll No.",25);
        tf2=new JTextField("Name",25);
        tf3=new JTextField("Marks",25);
        lb1=new JLabel("Insert Values here :");
        jt.setModel(tm);
        sp.setBounds(30,30,200,320);
        b1.setBounds(270,30,100,30);
        b2.setBounds(270,80,100,30);
        b3.setBounds(270,130,100,30);
        tf1.setBounds(270,230,150,30);
        tf2.setBounds(270,270,150,30);
        tf3.setBounds(270,310,150,30);
        b4.setBounds(340,350,80,20);
        b5.setBounds(95,370,80,30);
        lb1.setBounds(270, 190, 150, 40);
        add(sp);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(lb1);
        add(tf1);
        add(tf2);
        add(tf3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        tf1.addActionListener(this);
        tf2.addActionListener(this);
        tf3.addActionListener(this);

        
        lb1.setVisible(false);
        tf1.setVisible(false);
        tf2.setVisible(false);
        tf3.setVisible(false);
        b4.setVisible(false);
    }
    
    class TableModel extends AbstractTableModel
    {
        String title[]={"Roll No.","Name","Marks"};
        public String getColumnName(int c)
        {
            return title[c];
        }
        public int getRowCount()
        {
            return al.size();
        }
        public int getColumnCount()
        {
            return title.length;
        }
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            if(columnIndex==0)
            {
                return al.get(rowIndex).rollno;
            }
            else if(columnIndex==1)
            {
                return al.get(rowIndex).name;
            }
            else
            {
                return al.get(rowIndex).marks;
            }
        }
    }
    
    class Student
    {
        int rollno;
        String name;
        String marks;
        Student(int r,String n,String m)
        {
            this.rollno=r;
            this.name=n;
            this.marks=m;
            
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(e.getSource()==b1)
            {
                rs=stmt.executeQuery("select * from student");
                while(rs.next())
                {
                    int r=rs.getInt("Roll_no");
                    String n=rs.getString("Name");
                    String m=rs.getString("Marks");
                    al.add(new Student(r,n,m));
                }
                tm.fireTableDataChanged();
                repaint();
            }
            else if(e.getSource()==b2)
            {
                int a=jt.getSelectedRow();
                if(a==-1)
                {
                    JOptionPane.showMessageDialog(null,"Select Row first..!!!");
                }
                else
                {
                    int x=al.get(a).rollno;
                    rs=stmt.executeQuery("delete student where roll_no="+x);
//                    rs.next();
//                    System.out.println(rs.getInt("roll_no"));
//                    rs.deleteRow();
                    al.remove(a);
                    tm.fireTableDataChanged();
                    
                }
            }
            else if(e.getSource()==b3)
            {
                lb1.setVisible(true);
                tf1.setVisible(true);
                tf2.setVisible(true);
                tf3.setVisible(true);
                b4.setVisible(true);
            }
            else if(e.getSource()==b4)
            {
                al.add(new Student(Integer.parseInt(tf1.getText()), tf2.getText(),tf3.getText()));
                tm.fireTableDataChanged();
                stmt.execute("insert into student values ("+Integer.parseInt(tf1.getText())+","+"'"+tf2.getText()+"'"+","+"'"+tf3.getText()+"'"+")");
//                rs.moveToInsertRow();
//                rs.updateInt("Roll_no", Integer.parseInt(tf1.getText()));
//                rs.updateString("name", tf2.getText());
//                rs.updateString("marks", tf3.getText());
//                rs.insertRow();
                tf1.setText("Roll No");
                tf2.setText("Name");
                tf3.setText("Marks");
            }
            else if(e.getSource()==b5)
            {
                al.clear();
                tm.fireTableDataChanged();
            }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    
}

public class JDBC2 extends JFrame implements ActionListener
{
    JPanel p1;
    JTextField tf1;
    JPasswordField jpf;
    JButton b1;
    JLabel lb1,lb2;
    
    JDBC2()
    {
        super("Login");
        setSize(300,300);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        p1=new JPanel();
        tf1=new JTextField(25);
        b1=new JButton("Login");
        lb1=new JLabel("Username :");
        lb2=new JLabel("Password :");
        jpf=new JPasswordField(25);
        jpf.setEchoChar('*');
        
        
        p1.setLayout(null);
        p1.setBounds(50,80,300,220);
        tf1.setBounds(100,65,150,20);
        jpf.setBounds(100,115,150,20);
        b1.setBounds(140,170,70,30);
        lb1.setBounds(30,60,70,30);
        lb2.setBounds(30,110,70,30);
        p1.setBackground(Color.blue);
        
        p1.add(lb1);
        p1.add(tf1);
        p1.add(lb2);
        p1.add(jpf);
        p1.add(b1);
        add(p1);
        b1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            
            if((tf1.getText().equals("abhay"))&&(jpf.getText().equals("abhay")))
            {
                My2 obj=new My2();
                obj.setVisible(true);
                dispose();
            }
        }
    }
    
    
    public static void main(String[] args)
    {   
        JDBC2 obj2=new JDBC2();
    }
}
