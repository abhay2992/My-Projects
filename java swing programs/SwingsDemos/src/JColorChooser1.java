import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class JColorChooser1 extends JFrame implements ActionListener
{
    JColorChooser colorChooser;
    JButton bt;
    Color cl;
    
    public JColorChooser1()
    {
        super("JColorChooser Demo");
        setLayout(null);

        bt = new JButton("Select color");
        bt.setBounds(50,50,150,30);
        add(bt);

        bt.addActionListener(this);
        
        setSize(250,270);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        cl=  JColorChooser.showDialog(null, "Select Color", Color.BLACK);
        repaint();

    }

    public void paint(Graphics g)
    {
        g.setColor(cl);
        g.fillOval(70, 140, 100, 100);
    }

    public static void main(String args[])
    {
        JColorChooser1 obj = new JColorChooser1();
    }
}
