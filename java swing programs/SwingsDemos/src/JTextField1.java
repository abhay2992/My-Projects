//JTextField -- ActionListener,CaretListener

import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class JTextField1 extends JFrame implements ActionListener,CaretListener
{
    JTextField tf1,tf2,tf3;
    public JTextField1()
    {
        super("JTextField Demo");
        setLayout(null);

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();

        add(tf1);
        add(tf2);
        add(tf3);

        tf1.setBounds(50, 50, 150, 30);
        tf2.setBounds(50, 100, 150, 30);
        tf3.setBounds(50, 150, 150, 30);

        tf1.addActionListener(this);
        tf1.addCaretListener(this);

        setSize(280,350);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        String s = tf1.getText();
        tf3.setText(s);
    }

    public void caretUpdate(CaretEvent e)
    {
        String s = tf1.getText();
        tf2.setText(s);
    }

    public static void main(String args[])
    {
        JTextField1 obj = new JTextField1();
    }
}
