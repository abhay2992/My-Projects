import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;

class My1 extends JFrame implements ActionListener
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
    
    My1()
    {
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
        sp.setBounds(10,10,200,320);
        b1.setBounds(240,10,150,30);
        b2.setBounds(240,60,150,30);
        b3.setBounds(240,110,150,30);
        tf1.setBounds(240,230,150,30);
        tf2.setBounds(240,270,150,30);
        tf3.setBounds(240,310,150,30);
        b4.setBounds(310,350,80,20);
        b5.setBounds(80,330,80,30);
        lb1.setBounds(240, 190, 150, 40);
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

public class Assign36 extends JFrame implements ActionListener
{
    JPasswordField jpf;
    Assign36()
    {
        jpf=new JPasswordField();
        jpf.setEchoChar('*');
        setSize(300,300);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
    }
    
    
    public static void main(String[] args)
    {   
        My1 obj=new My1();
        
    }
}
