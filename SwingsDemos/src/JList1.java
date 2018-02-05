//JButton -- ActionListener

import javax.swing.*;
import javax.swing.event.*;

public class JList1 extends JFrame implements ListSelectionListener
{
    JList list1;
    String items[] = {"Dell","Lenovo","HP","Sony","Compaq","Samsung","Acer"};
    JScrollPane scrollpanel;
    JTextField tf1;
    JLabel lb1;

    public JList1()
    {
        super("JList Demo");
        setLayout(null);


        lb1 = new JLabel("Select Brand");
        tf1 = new JTextField();
        list1 = new JList(items);
        scrollpanel = new JScrollPane(list1);

        lb1.setBounds(50,30,150,20);
        scrollpanel.setBounds(50,50,150,100);
        tf1.setBounds(50,160,150,30);

        add(scrollpanel);
        add(tf1);
        add(lb1);

        list1.addListSelectionListener(this);

        setSize(350,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void valueChanged(ListSelectionEvent e)
    {
        tf1.setText(list1.getSelectedValue().toString());
    }

    
    public static void main(String args[])
    {
        JList1 obj = new JList1();
    }


}


