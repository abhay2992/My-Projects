import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ConfirmDialogBoxDemo extends JFrame implements ActionListener
{
    JButton bt;
    public ConfirmDialogBoxDemo()
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
        int ans = JOptionPane.showConfirmDialog(this, "Are you sure to delete ?","Hello",1,2);
        if(ans==JOptionPane.YES_OPTION)
        {
            System.out.println("You selected Yes");
        }
    }
    public static void main(String args[])
    {
        ConfirmDialogBoxDemo obj = new ConfirmDialogBoxDemo();
    }

}
