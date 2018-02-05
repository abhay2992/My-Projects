import javax.swing.*;
import javax.swing.table.AbstractTableModel;
public class JTableDemo1 extends JFrame
{
    JTable jt;
    JScrollPane sp;
    String names[] = {"Parwinder","Abhay","Rajiv","Harpuneet","Hello","World"};
  TableModel tm = new TableModel();
    public JTableDemo1()
    {
        setLayout(null);

        jt = new JTable();
        jt.setModel(tm);

        sp = new JScrollPane(jt);
        sp.setBounds(20,20,200,250);
        add(sp);

        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    class TableModel extends AbstractTableModel
    {
        @Override
        public String getColumnName(int c)
        {
            return "NAMES";
        }
        public int getRowCount()
        {
            return names.length;
        }

        public int getColumnCount()
        {
            return 1;
        }

        public Object getValueAt(int rowIndex, int columnIndex)
        {
            return names[rowIndex];
        }

    }


    public static void main(String args[])
    {
        JTableDemo1 obj = new JTableDemo1();
    }
}
