import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;
import java.sql.*;
import javax.swing.border.Border;


public class InventoryFrame extends JFrame implements ActionListener,ItemListener,TextListener,MouseListener
{
    JLabel lb1,lb2,lb3,lb4,lb5;
    JComboBox cb;
    TextField tf;
    JButton bt,bt1,bt2,bt3,bt4,bt5,bt6,bt7;
    JTable jt;
    JScrollPane sp;
    ArrayList <Inventory> al;
    String user;
    Connection conn;
    Statement stmt;
    Table1 tm;
    int index;
    
    
    public InventoryFrame(String user)
    {
        super("Inventory - "+user);
        this.user=user; 
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(50, 200, 255));
        setBounds(400,40,520,600);
        al= new ArrayList <Inventory>();
        
        lb1=new JLabel("Show Items of : ");
        lb2=new JLabel("Search Item : ");
        lb3=new JLabel("* WildCards '_' and '%' can be used.");
        lb4=new JLabel("logout");
        lb5=new JLabel(user.toUpperCase());
        
        cb= new JComboBox();
        tf= new TextField();
        bt=new JButton("Search");
        bt1=new JButton("Purchase");
        bt2=new JButton("Edit");
        bt3=new JButton("Delete");
        bt4=new JButton("Delete User");
        bt5=new JButton("Sale");
        bt6=new JButton("Sales Detail");
        bt7=new JButton("Purchase Detail");
        
        
        lb3.setForeground(Color.red);
        lb4.setForeground(Color.red);
        
        lb3.setFont(new Font("Ariel",Font.PLAIN,11 ));
        lb4.setFont(new Font("Ariel",Font.BOLD,13 ));
        
        lb1.setBounds(10, 30, 100, 20);
        cb.setBounds(130, 30, 360, 25);
        lb2.setBounds(10, 70, 100, 20);
        tf.setBounds(130, 70, 250, 25);
        bt.setBounds(400, 68, 90, 30);
        lb3.setBounds(130, 93, 250, 20);
        if(user.equals("admin"))
        {
            lb5.setText("Administrator");
            lb5.setBounds(216, 0, 100, 25);
            lb5.setFont(new Font("Ariel",Font.BOLD,13 ));

            lb4.setBounds(445, 2, 60, 20);
            bt5.setBounds(145, 465, 90, 30);
            bt1.setBounds(245, 465, 90, 30);
            bt2.setBounds(345, 465, 65, 30);
            bt3.setBounds(420, 465, 70, 30);
        }
        else
        {
            lb5.setBounds(10, 2, 300, 50);
            lb5.setFont(new Font("Ariel",Font.BOLD,18 ));
            lb4.setBounds(435, 20, 60, 20);
            bt5.setBounds(20, 465, 105, 30);
            bt1.setBounds(145, 465, 105, 30);
            bt2.setBounds(270, 465, 105, 30);
            bt3.setBounds(395, 465, 105, 30);
        }

        
        bt4.setBounds(10, 465, 100, 30);
        
        bt6.setBounds(80, 510, 150, 30);
        bt7.setBounds(300, 510, 150, 30);
        add(lb1);
        add(lb2);
        add(lb3);
        add(lb4);
        add(lb5);
        add(cb);
        add(tf);
        add(bt);
        add(bt1);
        add(bt2);
        add(bt3);
        add(bt4);
        add(bt5);
        add(bt6);
        add(bt7);
        bt.addActionListener(this);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);
        bt6.addActionListener(this);
        bt7.addActionListener(this);
       
        
        
        tf.addActionListener(this);
        tf.addTextListener(this);
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","abhay","abhay");
            stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= stmt.executeQuery("select * from user_accounts");
            cb.addItem("All");
            while(rs.next())
            {
                String s=rs.getString("username");
                cb.addItem(s);
            }

        
            if(user.equals("admin"))
            {
                cb.setSelectedItem("All");
                ResultSet rs1=stmt.executeQuery("select * from inventory order by id");
                while(rs1.next())
                {
                    int id1 = rs1.getInt("id");
                    String item=rs1.getString("item");
                    int qty=rs1.getInt("quantity");
                    float price=rs1.getFloat("price");
                    String owner=rs1.getString("owner");
                    al.add(new Inventory(id1, item, qty, price, owner));
                }
                
            }   
        
            else
            {
                lb1.setVisible(false);
                cb.setVisible(false);
                bt4.setVisible(false);
                ResultSet rs2=stmt.executeQuery("select * from inventory where owner = '"+user+"' order by id");
                while(rs2.next())
                {
                    int id1 = rs2.getInt("id");
                    String item=rs2.getString("item");
                    int qty=rs2.getInt("quantity");
                    float price=rs2.getFloat("price");
                    String owner=rs2.getString("owner");
                    al.add(new Inventory(id1, item, qty, price, owner));
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        tm=new Table1();
        jt=new JTable();
        sp=new JScrollPane(jt);
        jt.setModel(tm);
        sp.setBounds(10, 120, 480, 330);
        add(sp);
        cb.addItemListener(this);
        
        addFocusListener(new FocusAdapter()
        {
            public void focusGained(FocusEvent e)
            {
                tm.fireTableDataChanged();
            }
        });
        
        lb4.addMouseListener(this);
        
        setVisible(true);
        

    }
    
    void add(Inventory e)
    {
        al.add(e);
    }
    
    void edit(Inventory e)
    {
        al.remove(index);
        al.add(index, e);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if((e.getSource()==tf)||(e.getSource()==bt))
            {
                    al.clear();
                    ResultSet rs5;

                    if(user.equals("admin"))
                    {
                        if(((String)cb.getSelectedItem()).equals("All"))
                        {
                                rs5=stmt.executeQuery("select * from inventory where item = '"+tf.getText()+"' order by id");
                        }   
                        else
                        {
                                rs5=stmt.executeQuery("select * from inventory where item = '"+tf.getText()+"' and owner= '"+cb.getSelectedItem()+"' order by id");
                        }
                    }
                    else
                    {
                                rs5=stmt.executeQuery("select * from inventory where item = '"+tf.getText()+"' and owner= '"+user+"' order by id");
                    }                    
                    
                    while(rs5.next())
                            {
                                int id = rs5.getInt("id");
                                String item=rs5.getString("item");
                                int qty=rs5.getInt("quantity");
                                float price=rs5.getFloat("price");
                                String owner=rs5.getString("owner");
                                al.add(new Inventory(id, item, qty, price, owner));
                            }
                            tm.fireTableDataChanged();
                
            }
            
            else if(e.getSource()==bt1)
            {
                AddItem a=new AddItem(user, this);
            }
            
            else if(e.getSource()==bt2)
            {
                index= jt.getSelectedRow();
                if(index==-1)
                {
                    JOptionPane.showMessageDialog(this, "     Select Row First..!!");
                }
                else
                {
                    Inventory i2= al.get(index);
                    AddItem a=new AddItem(user, this);
                    a.edit(i2);
                }
            }
            
            else if(e.getSource()==bt3)
            {
                int i= jt.getSelectedRow();
                if(i==-1)
                {
                    JOptionPane.showMessageDialog(this, "     Select Row First..!!");
                }
                else
                {
                    int a=JOptionPane.showConfirmDialog(this, "Are you sure you want to delete ?");
                    if(a==JOptionPane.YES_OPTION)
                    {
                        stmt.execute("delete inventory where id = "+al.get(i).id);
                        al.remove(i);
                        this.requestFocus();
                    }
                    
                }
            }
            
            else if(e.getSource()==bt4)
            {
                if(cb.getSelectedItem().equals("All")==false)
                {
                    int b= JOptionPane.showConfirmDialog(this, "Are you sure you want to delete "+cb.getSelectedItem()+" user ?");
                    if(b==JOptionPane.YES_OPTION)
                    {
                        String s=cb.getSelectedItem() + "";
                        
                        stmt.execute("delete inventory where owner = '"+s+"'");
                        if(s.equals("admin")==false)
                        {
                            stmt.execute("delete user_accounts where username = '"+s+"'");
                        }
                        
                        for(int i=0;i<al.size();i++)
                        {
                            if(al.get(i).owner.equals(s))
                            {
                                al.remove(i);
                            }
                        }
                        
                        cb.removeItem(s);
                        
                        this.requestFocus();
                        
                    }
                    
                }
                
                else
                {
                    int b= JOptionPane.showConfirmDialog(this, "Are you sure you want to delete All users ?");
                    if(b==JOptionPane.YES_OPTION)
                    {
                        
                        stmt.execute("delete inventory");
                        stmt.execute("delete user_accounts where username not in ('admin')");
                        
                        al.clear();
                        
                        for(int i=0;i<cb.getItemCount();i++)
                        {
                            if(cb.getItemAt(i).equals("All")||cb.getItemAt(i).equals("admin"))
                            {
                                continue;
                            }
                            else
                            {
                                cb.removeItem(i);
                            }
                        }
                        repaint();
                        this.requestFocus();
                    }
                }
            }
            
            else if(e.getSource()==bt5)
            {
                AddItem a1=new AddItem(user,this);
                a1.sale();
            }
            
            else if(e.getSource()==bt6)
            {
                SalesTrans st=new SalesTrans("Sale",user);
            }
            else if(e.getSource()==bt7)
            {
                SalesTrans st=new SalesTrans("Purchase",user);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    
    @Override
    public void itemStateChanged(ItemEvent e)
    {
        al.clear();
        String s= (String)cb.getSelectedItem();
        
        try
        {
        if(s.equals("All"))
        {
                ResultSet rs2=stmt.executeQuery("select * from inventory order by id");
                while(rs2.next())
                {
                    int id = rs2.getInt("id");
                    String item=rs2.getString("item");
                    int qty=rs2.getInt("quantity");
                    float price=rs2.getFloat("price");
                    String owner=rs2.getString("owner");
                    al.add(new Inventory(id, item, qty, price, owner));
                }
        }
        else
        {
          ResultSet rs3=stmt.executeQuery("select * from inventory where owner = '"+s+"' order by id");
                while(rs3.next())
                {
                    int id = rs3.getInt("id");
                    String item=rs3.getString("item");
                    int qty=rs3.getInt("quantity");
                    float price=rs3.getFloat("price");
                    String owner=rs3.getString("owner");
                    al.add(new Inventory(id, item, qty, price, owner));
                }  
        }
        }
        
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        tm.fireTableDataChanged();
         
    }
    
    public void textValueChanged(TextEvent e)
    {
        try
        {
            if(e.getSource()==tf)
            {
                    al.clear();
                    ResultSet rs7;

                    if(user.equals("admin"))
                    {
                        if(((String)cb.getSelectedItem()).equals("All"))
                        {
                            rs7=stmt.executeQuery("select * from inventory where item LIKE '"+tf.getText()+"%' order by id ");
                        }   
                        else
                        {
                            rs7=stmt.executeQuery("select * from inventory where item LIKE '"+tf.getText()+"%' and owner= '"+cb.getSelectedItem()+"' order by id");
                        }
                    }
                    else
                    {
                            rs7=stmt.executeQuery("select * from inventory where item LIKE '"+tf.getText()+"%' and owner= '"+user+"' order by id");
                    }
                    
                    while(rs7.next())
                    {
                                int id = rs7.getInt("id");
                                String item=rs7.getString("item");
                                int qty=rs7.getInt("quantity");
                                float price=rs7.getFloat("price");
                                String owner=rs7.getString("owner");
                                al.add(new Inventory(id, item, qty, price, owner));
                    }
               
                    tm.fireTableDataChanged();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        if((e.getSource()==lb4)&&(e.getButton()==MouseEvent.BUTTON1))
        {
                try
                {
                    
                    stmt.close();
                    conn.close();
                    Login l=new Login();
                    l.lb7.setVisible(true);
                    dispose();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        setCursor(Cursor.HAND_CURSOR);
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        setCursor(Cursor.DEFAULT_CURSOR);
    }
    
    class Table1 extends AbstractTableModel
    {
        String title[]={"Identity No.","Item","Quantity","Price","Owner"};
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
        
        public Object getValueAt(int r, int c)
        {
            if(c==0)
            {
                return al.get(r).id;
            }
            else if(c==1)
            {
                return al.get(r).item;
            }
            else if(c==2)
            {
                return al.get(r).qty;
            }
            else if(c==3)
            {
                return al.get(r).price;
            }
            else
            {
                return al.get(r).owner;
            }
        }
    }
    
}
