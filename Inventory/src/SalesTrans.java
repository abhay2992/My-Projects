import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.AbstractTableModel;
public class SalesTrans extends JFrame
{
    JTable jt;
    JScrollPane sp;
    ArrayList <Trans> a1;
    String Title[]={"Date","Owner","Item","Quantity","Price(per Item) ","Amount","Supplier Name","Company Name"};
    String type,user;
    Connection conn;
    Statement stmt;
    
    SalesTrans(String type, String user)
    {
        setLayout(null);
        this.type=type;
        this.user=user;
        setTitle(this.type+" Transactions");
        setBounds(220,10,905,705);
        a1=new ArrayList<>();
        if(this.type.equals("Sale"))
        {
            Title[6]="Customer Name";
        }
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","abhay","abhay");
            stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs;
            if(this.user.equals("admin"))
            {
                rs=stmt.executeQuery("select * from transaction where type = '"+this.type+"'");
            }
            else
            {
                rs=stmt.executeQuery("select * from transaction where type = '"+this.type+"' and owner = '"+user+"'");
            }
            while(rs.next())
            {
                java.util.Date date=rs.getDate("_DATE");
                DateFormat f=new SimpleDateFormat("dd-MM-yy");
                String d=f.format(date);
                String own=rs.getString("owner");
                String it=rs.getString("item");
                int qt=rs.getInt("quantity");
                float pr=rs.getFloat("price");
                float am=rs.getFloat("amount");
                String sn=rs.getString("supplier_name");
                String cn=rs.getString("company_name");
                
                a1.add(new Trans(d, own, it, qt, pr, am, sn, cn));
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        Table2 t1=new Table2();
        jt=new JTable();
        jt.setModel(t1);
        sp=new JScrollPane(jt);
        sp.setBounds(10, 10, 870, 650);
        add(sp);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        if(a1.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "No "+this.type+" Records Found..!!");
                try
                {
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
    
    class Table2 extends AbstractTableModel
    {
        
        
        @Override
        public String getColumnName(int c)
        {
            return Title[c];
        }
        public int getRowCount()
        {
            return a1.size();
        }

        @Override
        public int getColumnCount()
        {
            return Title.length;
        }

        @Override
        public Object getValueAt(int ri, int ci)
        {
            if(ci==0)
            {
                return a1.get(ri).Date;
            }
            else if(ci==1)
            {
                return a1.get(ri).owner;
            }
            else if(ci==2)
            {
                return a1.get(ri).Item;
            }
            else if(ci==3)
            {
                return a1.get(ri).qty;
            }
            else if(ci==4)
            {
                return a1.get(ri).price;
            }
            else if(ci==5)
            {
                return a1.get(ri).amt;
            }
            else if(ci==6)
            {
                return a1.get(ri).sn;
            }
            else
            {
                return a1.get(ri).cn;
            }
        }
        
        
    }
}
