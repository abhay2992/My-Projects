//JLabel Demo --

import java.awt.event.*;
import javax.swing.*;


public class JLabel1 extends JFrame implements ActionListener
{
    JLabel lb1,lb2;
    JButton bt1;

    public JLabel1()
    {
        super("JLabel Demo");
        setLayout(null);

        lb1 = new JLabel();
        lb1.setText("This is label-1 text");
        lb2 = new JLabel("This is label-2 text");
        bt1 = new JButton("Click me");

        lb1.setBounds(50,50,200,30);
        lb2.setBounds(50,100,200,30);
        bt1.setBounds(50,150,100,30);

        add(lb1);
        add(lb2);
        add(bt1);
        
        bt1.addActionListener(this);
        
        setSize(250,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        lb1.setText("Hello World");
        lb2.setText("Hello Java");
    }

    public static void main(String args[])
    {
        JLabel1 obj = new JLabel1();
    }
}
