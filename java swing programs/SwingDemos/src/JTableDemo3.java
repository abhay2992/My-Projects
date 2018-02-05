import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;
import java.util.ArrayList;
public class JTableDemo3 extends JFrame
{
    JScrollPane sp;
    JTable jt;
    ArrayList<StudentInfo> al;
    TableModel tm;

    public JTableDemo3()
    {
        setLayout(null);
        al = new ArrayList<StudentInfo>();
        al.add(new StudentInfo(1,"Parwinder",35.45));
        al.add(new StudentInfo(2,"Dinesh",55.45));
        al.add(new StudentInfo(3,"Rajan",37.42));
        al.add(new StudentInfo(4,"Harpuneet",95.42));
        al.add(new StudentInfo(5,"Rajiv",56.85));
        al.add(new StudentInfo(6,"Gurwinder",55.40));
        tm = new TableModel();
        jt = new JTable();
        jt.setModel(tm);
        sp = new JScrollPane(jt);
        sp.setBounds(20,20,250,300);
        add(sp);

        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    class TableModel extends AbstractTableModel
    {
        String title[] = {"ROLLNO","NAME","MARKS"};
        @Override
        public String getColumnName(int c)
        {
            return title[c];
        }
        public int getRowCount()
        {
             return al.size();
        }

        public int getColumnCount() {
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

    class StudentInfo
    {
        int rollno;
        String name;
        double marks;
        public StudentInfo(int rollno, String name, double marks)
        {
            this.rollno = rollno;
            this.name = name;
            this.marks = marks;
        }

    }

    public static void main(String args[])
    {
        JTableDemo3 obj = new JTableDemo3();
    }

}
