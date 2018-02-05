//JButton -- ActionListener

import javax.swing.*;
import java.awt.event.*;

public class JButton1 extends JFrame implements ActionListener
{
    JButton bt1;
    JTextField tf1,tf2;

    public JButton1()
    {
        super("JButton Demo");
        setLayout(null);

        tf1 = new JTextField();
        tf2 = new JTextField();
        bt1 = new JButton("Count Characters");

        add(tf1);
        add(tf2);
        add(bt1);

        tf1.setBounds(50,50,150,30);
        tf2.setBounds(50,100,150,30);
        bt1.setBounds(50,150,150,30);

        bt1.addActionListener(this);

        setSize(280,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        int n = tf1.getText().length();
        tf2.setText(Integer.toString(n));
    }

    public static void main(String args[])
    {
        JButton1 obj = new JButton1();
    }
}
