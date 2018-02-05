import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class InputDialogBoxDemo extends JFrame implements ActionListener
{
    JButton bt;
    public InputDialogBoxDemo()
    {
        setLayout(null);
        bt = new JButton("Click");
        bt.setBounds(20,20,100,30);
        add(bt);
        bt.addActionListener(this);
        setVisible(true);
        setSize(300,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = JOptionPane.showInputDialog("Enter your name");
        System.out.println(" you  entered  : "+s);
    }
    public static void main(String args[])
    {
        InputDialogBoxDemo obj = new InputDialogBoxDemo();
    }

}
