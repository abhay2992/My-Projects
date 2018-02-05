import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
public class JTableDemo2 extends JFrame implements ActionListener
{
    JTable jt;
    JScrollPane sp;
    ArrayList<String> al = new ArrayList<String>();
    TableModel tm = new TableModel();
    JTextField tf1 = new JTextField(23);
    JButton bt1 = new JButton("ADD");
    JButton bt2 = new JButton("REMOVE");
    public JTableDemo2()
    {
        setLayout(null);
        al.add("Parwinder");
        al.add("Abhay");
        al.add("Rajiv");
        al.add("Harpuneet");
        al.add("Gagan");
        al.add("Dinesh");
        jt = new JTable();
        jt.setModel(tm);
        sp = new JScrollPane(jt);
        sp.setBounds(20,20,200,250);
        add(sp);
        tf1.setBounds(240,100,150,30);
        bt1.setBounds(240,150,100,30);
        bt2.setBounds(240,200,100,30);
        add(tf1);
        add(bt1);
        add(bt2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1){
        System.out.println("Button clicked");
        al.add(tf1.getText());
        tf1.setText("");
        tm.fireTableDataChanged();
        }
        else
        {
            int i=jt.getSelectedRow();
            if(i==-1)
            {
                JOptionPane.showMessageDialog(null, "Select row first !!");
            }
            else
            {
                al.remove(i);
                tm.fireTableDataChanged();
            }
        }
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
            return al.size();
        }

        public int getColumnCount()
        {
            return 1;
        }

        public Object getValueAt(int rowIndex, int columnIndex)
        {
            return al.get(rowIndex);
        }

    }


    public static void main(String args[])
    {
        JTableDemo2 obj = new JTableDemo2();
    }
}
