
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.sql.*;


public class GUI_JDBC extends javax.swing.JFrame {

   ArrayList<StudentInfo> al = new ArrayList<StudentInfo>();
   TableModel tm  = new TableModel();
   public GUI_JDBC()
    {
        initComponents();
        jTable1.setModel(tm);
        setSize(500,500);

        try
        {
           
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver Loaded");
//            Connection conn=DriverManager.getConnection("jdbc:mysql://192.168.137.232:3306/test","root","system");
//            System.out.println("Connection Build");
//            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//            System.out.println("Statement Created");
//            ResultSet rs=stmt.executeQuery("select * from table_for_jdbc");
//            while(rs.next())
//            {
//               int rollno = rs.getInt("rollno");
//               String name = rs.getString("name");
//               String marks = rs.getString("marks");
//               al.add(new StudentInfo(rollno, name, marks));
//           // rs.insertRow();
//            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }





    }

    class TableModel extends AbstractTableModel
    {

        String [] title = {"ROLLNO","NAME","MARKS"};
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
        String marks;

        StudentInfo(int r, String n, String m)
        {
            this.rollno =r;
            this.name = n;
            this.marks = m;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 90, 350, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_JDBC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
