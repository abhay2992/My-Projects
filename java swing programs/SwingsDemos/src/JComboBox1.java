//JButton -- ActionListener

import javax.swing.*;
import java.awt.event.*;

public class JComboBox1 extends JFrame implements ItemListener
{
    JComboBox cb1,cb2;
    String browser[] = {"Internet Explorer","Mozila","Safari","Crome","Opera"};
    JTextField tf1,tf2;
    JLabel lb1,lb2;

    public JComboBox1()
    {

        super("JCombobox Demo");
        setLayout(null);

        tf1 = new JTextField();
        tf2 = new JTextField();
        lb1 =new JLabel("Operating System");
        lb2 =new JLabel("Browser");
        cb2 = new JComboBox(browser);
        cb1 = new JComboBox();

        cb1.addItem("Windows");
        cb1.addItem("Linux");
        cb1.addItem("Mac");
        cb1.addItem("Android");

        lb1.setBounds(70,50,150,30);
        lb2.setBounds(250,50,150,30);
        cb1.setBounds(50,90,150,30);
        cb2.setBounds(210,90,150,30);
        tf1.setBounds(50,130,150,30);
        tf2.setBounds(210,130,150,30);

        add(lb1);
        add(lb2);
        add(cb1);
        add(cb2);
        add(tf1);
        add(tf2);

        cb1.addItemListener(this);
        cb2.addItemListener(this);

        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void itemStateChanged(ItemEvent e)
    {
        if(e.getSource()==cb1)
        {
            tf1.setText(cb1.getSelectedItem().toString());
        }
        if(e.getSource()==cb2)
        {
            tf2.setText(cb2.getSelectedItem().toString());
        }
    }

    public static void main(String args[])
    {
        JComboBox1 obj = new JComboBox1();
    }
   
}
