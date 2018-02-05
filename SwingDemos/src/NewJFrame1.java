
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class NewJFrame1 extends javax.swing.JFrame {

     ArrayList<StudentInfo> al;
    TableModel tm;
    public NewJFrame1()
    {
        al = new ArrayList<StudentInfo>();
        al.add(new StudentInfo(1,"Parwinder",35.45));
        al.add(new StudentInfo(2,"Dinesh",55.45));
        al.add(new StudentInfo(3,"Rajan",37.42));
        al.add(new StudentInfo(4,"Harpuneet",95.42));
        al.add(new StudentInfo(5,"Rajiv",56.85));
        al.add(new StudentInfo(6,"Gurwinder",55.40));
     
        initComponents();
        //jTable1.setModel(tm);
        setSize(500,500);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setModel(tm=new TableModel());
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 80, 350, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
