//JCheckbox -- ItemListener

import javax.swing.*;
import java.awt.event.*;

public class JCheckbox1 extends JFrame implements ItemListener
{
    JLabel lb1,lb2,lb3;
    JCheckBox cb1,cb2,cb3;

    public JCheckbox1()
    {
        super("JCheckbox Demo");
        setLayout(null);

        lb1 = new JLabel("Red Selected");
        lb2 = new JLabel("Green Selected");
        lb3 = new JLabel("Blue Selected");

        cb1 = new JCheckBox("Red");
        cb2 = new JCheckBox("Green");
        cb3 = new JCheckBox("Blue");

        cb1.setSelected(true);

        cb1.setBounds(50,50,100,30);
        cb2.setBounds(160,50,100,30);
        cb3.setBounds(270,50,100,30);
        lb1.setBounds(50,100,150,30);
        lb2.setBounds(50,150,150,30);
        lb3.setBounds(50,200,150,30);

        add(cb1);
        add(cb2);
        add(cb3);
        add(lb1);
        add(lb2);
        add(lb3);

        lb1.setVisible(true);
        lb2.setVisible(false);
        lb3.setVisible(false);

        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);

        setSize(500,400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void itemStateChanged(ItemEvent e)
    {
        if(e.getSource()==cb1)
        {
            if(cb1.isSelected()==true)
                lb1.setVisible(true);
            else
                lb1.setVisible(false);
        }
        if(e.getSource()==cb2)
        {
            if(cb2.isSelected()==true)
                lb2.setVisible(true);
            else
                lb2.setVisible(false);
        }
        if(e.getSource()==cb3)
        {
            if(cb3.isSelected()==true)
                lb3.setVisible(true);
            else
                lb3.setVisible(false);
        }

    }

    public static void main(String args[])
    {
        JCheckbox1 obj = new JCheckbox1();
    }

}

