
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.DriverManager;
import javax.swing.*;
import java.sql.*;
import java.util.*;


public class AddItem extends JFrame implements ActionListener,TextListener
{
    JLabel lb1,lb2,lb3,lb4, lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12;
    JTextField tf3,tf4,tf5,tf6,tf7;
    TextField tf1,tf2;
    JComboBox cb;
    JButton bt1,bt2,bt3;
    int id=1;
    String user;
    Connection conn;
    Statement stmt;
    InventoryFrame parent;
    
    AddItem(String user, InventoryFrame i1)
    {
        super("Purchase");
        this.parent=i1;
        this.user=user;
        setLayout(null);
        setBounds(480,120,400,500);
        
        lb1=new JLabel("Item :");
        lb2=new JLabel("Quantity :");
        lb3=new JLabel("Price :");
        lb4=new JLabel("Owner :");
        lb5=new JLabel("* Fill Valid Detail..!!");
        lb6=new JLabel("* Item Not Available..!!");
        lb7=new JLabel("Date :");
        lb8=new JLabel("Supplier Name :");
        lb9=new JLabel("Company Name :");
        lb10=new JLabel("Amount :");
        lb11=new JLabel("Quantity Unavailable..!!");
        
        tf1=new TextField();
        tf2=new TextField();
        tf3=new JTextField();
        tf4=new JTextField("DD-MM-YYYY");
        tf5=new JTextField();
        tf6=new JTextField();
        tf7=new JTextField();
        cb=new JComboBox();
        bt1=new JButton("Purchase");
        bt2=new JButton("Cancel");
        bt3=new JButton("Get Amt.");
        
        lb5.setForeground(Color.red);
        lb6.setForeground(Color.red);
        lb11.setForeground(Color.red);
        
        
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","abhay","abhay");
            stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=stmt.executeQuery("select * from user_accounts");
            while(rs.next())
            {
                String s=rs.getString("username");
                cb.addItem(s);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        lb7.setBounds(10, 10, 50, 25);
        tf4.setBounds(120, 10, 80, 25);
        
        lb4.setBounds(10, 60, 50, 25);
        cb.setBounds(120, 60, 220, 25);
        lb8.setBounds(10, 100, 100, 25);
        tf5.setBounds(120, 100, 220, 25);
        lb9.setBounds(10, 140, 100, 25);
        tf6.setBounds(120, 140, 220, 25);
        lb1.setBounds(10, 180, 50, 25);
        tf1.setBounds(120, 180, 220, 25);
        lb2.setBounds(10, 220, 100, 25);
        tf2.setBounds(120, 220, 220, 25);
        lb3.setBounds(10, 260, 100, 25);
        tf3.setBounds(120, 260, 220, 25);
        lb10.setBounds(10, 300, 60, 25);
        tf7.setBounds(120, 300, 100, 25);
        bt3.setBounds(240, 300, 100, 25);
        lb5.setBounds(10, 363, 110, 20);
        bt1.setBounds(160, 360, 95, 30);
        bt2.setBounds(265, 360, 75, 30);
        lb6.setBounds(10, 400, 150, 20);
        lb11.setBounds(10, 430, 150, 20);

        lb5.setVisible(false);
        lb6.setVisible(false);
        lb11.setVisible(false);

        cb.setSelectedItem(user);
        
        if(user.equals("admin")==false)
        {
            cb.setEnabled(false);
        }
       
        
        add(lb1);
        add(tf1);
        add(lb2);
        add(tf2);
        add(lb3);
        add(tf3);
        add(lb4);
        add(lb5);
        add(lb6);
        add(lb11);
        add(cb);
        add(bt1);
        add(bt2);
        add(lb7);
        add(lb8);
        add(lb9);
        add(lb10);
        add(tf4);
        add(tf5);
        add(tf6);
        add(tf7);
        add(bt3);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e)
            {
                try
                {
                    if(conn.isClosed())
                    {
                        end();
                    }
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        
        
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
    
    void end()
    {
        JOptionPane.showMessageDialog(this, "Your Session Expired..!!");
        dispose();
    }
    
    
    void sale()
    {
        setTitle("Sale");
        lb8.setText("Customer Name :");
        bt1.setText("Sell");
        
        tf1.addTextListener(this);
        tf2.addTextListener(this);
    }
    
    void edit(Inventory i7)
    {
        setTitle("Edit an Item");
        
        setBounds(560,200,350,280);
        lb7.setVisible(false);
        lb8.setVisible(false);
        lb9.setVisible(false);
        lb10.setVisible(false);
        
        tf4.setVisible(false);
        tf5.setVisible(false);
        tf6.setVisible(false);
        tf7.setVisible(false);
        
        bt3.setVisible(false);

        this.id=i7.id;
        tf1.setText(i7.item);
        tf2.setText(i7.qty+"");
        tf3.setText(i7.price+"");
        bt1.setText("Apply Changes");
        bt1.setBounds(120, 360, 120, 30);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            if(tf1.getText().isEmpty()||tf2.getText().isEmpty()||tf3.getText().isEmpty()||tf4.getText().equals("DD-MM-YYYY") ||tf5.getText().isEmpty()||tf6.getText().isEmpty())
            {
                lb5.setVisible(true);
            }
            else
            {
                lb5.setVisible(false);
                
                try
                {
                    if(bt1.getText().equals("Purchase"))
                    {
                        ResultSet rs0=stmt.executeQuery("select * from inventory where item = '"+tf1.getText()+"' and owner = '"+cb.getSelectedItem()+"'");
                        
                        if(rs0.next()==false)
                        {
                            ResultSet rs1=stmt.executeQuery("select MAX(id) from inventory");
                            if(rs1.next())
                            {
                                id=rs1.getInt("MAX(id)");
                                id++;
                            }
                            int q=Integer.parseInt(tf2.getText());
                            float p=Float.parseFloat(tf3.getText());
                            stmt.execute("insert into inventory values ("+id+", '"+tf1.getText()+"' , "+q+", "+p+", '"+cb.getSelectedItem()+"')");
                            
                            JOptionPane.showMessageDialog(this, "Operation Successful.");
    
                            Inventory i = new Inventory(id, tf1.getText(), q, p, (String)cb.getSelectedItem());
                            parent.add(i);
                        }
                        else
                        {
                            //lb6.setVisible(true);
                            rs0.last();
                            int a=rs0.getInt("id");
                            int q2=Integer.parseInt(tf2.getText()) + rs0.getInt("quantity");
                            float p2=((Float.parseFloat(tf3.getText())*Integer.parseInt(tf2.getText()))+(rs0.getInt("quantity")*rs0.getFloat("price")))/q2;
                            stmt.execute("update inventory set quantity = "+q2+",price = "+p2+",owner = '"+cb.getSelectedItem()+"' where id = "+rs0.getInt("id"));
                            
                            for(int i=0;i<parent.al.size();i++)
                            {
                                if(parent.al.get(i).id== a)
                                {
                                    parent.al.get(i).qty=q2;
                                    parent.al.get(i).price=p2;
                                }
                            }
                            JOptionPane.showMessageDialog(this, "Operation Successful.");
                        }
                        
                        float amt= (Integer.parseInt(tf2.getText())) * (Float.parseFloat(tf3.getText())) ;

                        stmt.execute("insert into transaction values (to_date('"+tf4.getText()+"','dd-mm-yyyy'), '"+tf1.getText()+"', "+Integer.parseInt(tf2.getText())+", "+Float.parseFloat(tf3.getText())+", '"+tf5.getText()+"', '"+tf6.getText()+"', "+amt+", '"+cb.getSelectedItem()+"', 'Purchase')");
                        parent.requestFocus();
                        this.dispose();
                        
                        
                    }
                    else if(bt1.getText().equals("Sell"))
                    {
                        if((lb6.isVisible()==false)&&(lb11.isVisible()==false))
                        {
                            ResultSet rs0=stmt.executeQuery("select * from inventory where item = '"+tf1.getText()+"' and owner = '"+cb.getSelectedItem()+"'");
                            rs0.next();
                            int i0= rs0.getInt("id");
                            int q0=((rs0.getInt("quantity")) - (Integer.parseInt(tf2.getText())));
                            stmt.execute("update inventory set quantity = "+q0+" where item = '"+tf1.getText()+"' and owner = '"+cb.getSelectedItem()+"'");
                            for(int i=0;i<parent.al.size();i++)
                            {
                                if(parent.al.get(i).id== i0)
                                {
                                    parent.al.get(i).qty=q0;
                                }
                            }
                            JOptionPane.showMessageDialog(this, "Operation Successful.");
                            float amt= (Integer.parseInt(tf2.getText())) * (Float.parseFloat(tf3.getText())) ;
                            stmt.execute("insert into transaction values (to_date('"+tf4.getText()+"','dd-mm-yyyy'), '"+tf1.getText()+"', "+Integer.parseInt(tf2.getText())+", "+Float.parseFloat(tf3.getText())+", '"+tf5.getText()+"', '"+tf6.getText()+"', "+amt+", '"+cb.getSelectedItem()+"', 'Sale')");
                            parent.requestFocus();
                            this.dispose();
                        }
                        
                        
                    }
                    else if(bt1.getText().equals("Apply Changes"))
                    {
                        int q1=Integer.parseInt(tf2.getText());
                        float p1=Float.parseFloat(tf3.getText());

                        stmt.execute("update inventory set item = '"+tf1.getText()+"' , quantity = "+q1+", price = "+p1+", owner = '"+cb.getSelectedItem()+"' where id = "+id);
                        
                        JOptionPane.showMessageDialog(this, "Operation Successful.");

                        Inventory i = new Inventory(id, tf1.getText(), q1, p1, (String)cb.getSelectedItem());
                        parent.edit(i);
                        parent.requestFocus();
                        this.dispose();
                    }
                    
                }
                catch(NumberFormatException ext)
                {
                    lb5.setVisible(true);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
              }
          }
        
        else if(e.getSource()==bt3)
        {
            try
            {
                float amt= (Integer.parseInt(tf2.getText())) * (Float.parseFloat(tf3.getText())) ;
                tf7.setText(amt+"");
            }
            catch(NumberFormatException ex)
            {
                lb5.setVisible(true);
            }
            
        }
        
        else if(e.getSource()==bt2)
        {
            this.dispose();
        }
            
    }

    @Override
    public void textValueChanged(TextEvent e)
    {
        try
        {
            if(e.getSource()==tf1)
            {
                    ResultSet rs=stmt.executeQuery("select * from inventory where item = '"+tf1.getText()+"' and owner = '"+cb.getSelectedItem()+"'");
                    if(rs.next()==false)
                    {
                        lb6.setVisible(true);
                    }
                    else
                    {
                        lb6.setVisible(false);
                        float p=rs.getFloat("price");
                        tf3.setText(p+"");
                    }
            
            }
            
            else if(e.getSource()==tf2)
            {
                if((tf1.getText().isEmpty()==false)&&(lb6.isVisible()==false))
                {
                    ResultSet rs1=stmt.executeQuery("select * from inventory where item = '"+tf1.getText()+"' and owner = '"+cb.getSelectedItem()+"'");
                    rs1.next();
                    int qty=rs1.getInt("quantity");
                    int q=Integer.parseInt(tf2.getText());
                    if(q>qty)
                    {
                        lb11.setVisible(true);
                    }
                    else
                    {
                        lb11.setVisible(false);
                    }
                }
            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    
        
}
    
    
    
