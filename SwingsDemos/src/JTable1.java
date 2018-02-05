
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;


public class JTable1 extends JFrame implements ActionListener
{
    JTable jt1,jt2;
    TableModel1 tm1;
    TableModel2 tm2;
    JScrollPane sp1,sp2;
    String studentInfo[][];
    ArrayList<StudentInfo> al;
    JTextField tfRollno,tfName,tfMarks;
    JButton btAdd,btRemove,btClear;
    JLabel lb1,lb2,lb3;

    JTable1()
    {
        super("JTable Demo");
        setLayout(null);
        studentInfo = new String[7][2];
        al = new ArrayList<StudentInfo>();
        tfRollno = new JTextField();
        tfName = new JTextField();
        tfMarks = new JTextField();
        btAdd = new JButton("Add Record");
        btRemove = new JButton("Remove Record");
        btClear = new JButton("Clear List");
        lb1= new JLabel("Rollno");
        lb2= new JLabel("Name");
        lb3= new JLabel("Marks");


        tm1 = new TableModel1();
        jt1 = new JTable();
        jt1.setModel(tm1);
        sp1 = new JScrollPane(jt1);

        tm2 = new TableModel2();
        jt2 = new JTable();
        jt2.setModel(tm2);
        sp2 = new JScrollPane(jt2);
        
        studentInfo[0][0] = "1";
        studentInfo[0][1] = "ABC";
        studentInfo[1][0] = "2";
        studentInfo[1][1] = "PQR";
        studentInfo[2][0] = "3";
        studentInfo[2][1] = "MNO";
        studentInfo[3][0] = "4";
        studentInfo[3][1] = "STU";
        studentInfo[4][0] = "5";
        studentInfo[4][1] = "LMN";
        studentInfo[5][0] = "6";
        studentInfo[5][1] = "RSU";
        studentInfo[6][0] = "7";
        studentInfo[6][1] = "SSA";
        
        al.add(new StudentInfo(1, "ABC", 55.6));
        al.add(new StudentInfo(2, "PQR", 60));
        al.add(new StudentInfo(3, "MNO", 33.5));
        al.add(new StudentInfo(4, "ASD", 76.54));
        al.add(new StudentInfo(5, "XYZ", 90.23));
        al.add(new StudentInfo(6, "STU", 67.12));
        al.add(new StudentInfo(7, "LMN", 82));

        sp1.setBounds(100,30,300,115);
        add(sp1);
        sp2.setBounds(50,160,350,115);
        add(sp2);
        lb1.setBounds(50,300,110,20);
        add(lb1);
        lb2.setBounds(170,300,110,20);
        add(lb2);
        lb3.setBounds(290,300,110,20);
        add(lb3);
        tfRollno.setBounds(50,340,110,25);
        add(tfRollno);
        tfName.setBounds(170,340,110,25);
        add(tfName);
        tfMarks.setBounds(290,340,110,25);
        add(tfMarks);
        btAdd.setBounds(250,380,150,25);
        add(btAdd);
        btRemove.setBounds(250,415,150,25);
        add(btRemove);
        btClear.setBounds(250,450,150,25);
        add(btClear);

        btAdd.addActionListener(this);
        btRemove.addActionListener(this);
        btClear.addActionListener(this);

        setSize(450,600);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btAdd)
        {
            boolean flag=false;

            if(tfRollno.getText().trim().equals("")||
               tfName.getText().trim().equals("")||
               tfMarks.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter values in all fields");
            }
            else
            {
            int rollno = Integer.parseInt(tfRollno.getText());
            String name = tfName.getText();
            double marks = Double.parseDouble(tfMarks.getText());
            for(int i=0; i<al.size(); i++)
            {
                if(al.get(i).rollno==rollno)
                {
                    flag=true;
                    JOptionPane.showMessageDialog(null,"Rollno  "+rollno+"  already exists");
                    tfRollno.setText("");
                    break;
                }
            }
            if(flag==false)
            {
                al.add(new StudentInfo(rollno,name,marks));
                tm2.fireTableDataChanged();
                JOptionPane.showMessageDialog(null,"Record added successfully !!!");
            }
            }
        }
        else if(e.getSource()==btRemove)
        {
            int i = jt2.getSelectedRow();
            if(i==-1)
                JOptionPane.showMessageDialog(null,"Select record first");
            else
            {
                int option = JOptionPane.showConfirmDialog(null,"Are you sure to delete ?");
                if(option==0)
                {
                    al.remove(i);
                    tm2.fireTableDataChanged();
                }
            
            
            }
        }
        else
        {
            al.clear();
            tfRollno.setText("");
            tfName.setText("");
            tfMarks.setText("");
            tm2.fireTableDataChanged();
        }

    }

    public static void main(String args[])
    {
        JTable1 obj = new JTable1();

    }

    class TableModel1 extends AbstractTableModel
    {
        String title[] = {"ROLL NO","NAME"};

        public String getColumnName(int c)
        {
            return title[c];
        }

        public int getRowCount()
        {
            return studentInfo.length;
        }

        public int getColumnCount()
        {
            return title.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex)
        {
           if(columnIndex==0)
               return studentInfo[rowIndex][0];
           else
               return studentInfo[rowIndex][1];
        }

    }

    class TableModel2 extends AbstractTableModel
    {
        String[] title = {"ROLL No.","NAME", "MARKS"};

        @Override
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
                return al.get(rowIndex).rollno;
            else if(columnIndex==1)
                return al.get(rowIndex).name;
            else
                return al.get(rowIndex).marks;
        }

    }

    class StudentInfo
    {
        int rollno;
        String name;
        double marks;
        StudentInfo(int rollno,String name, double marks)
        {
            this.rollno = rollno;
            this.name = name;
            this.marks = marks;
        }
    }
}
