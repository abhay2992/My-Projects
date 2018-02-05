import java.awt.BorderLayout;
import javax.swing.*;
public class BorderLayoutDemo extends JFrame
{
    BorderLayout borderLayout;
    JButton bt1,bt2;
    JTextField tf1,tf2;
    JTextArea ta1;
    BorderLayoutDemo()
    {
        borderLayout = new BorderLayout(); //No gap between components
      //borderLayout = new BorderLayout(10,10);

        setLayout(borderLayout);

        bt1 = new JButton("Button1");
        bt2 = new JButton("Button 2");
        tf1 = new JTextField(20);
        tf2 = new JTextField(20);
        ta1 = new JTextArea();

        add("East",bt1);                 //1st Method
        add("West",bt2);
        add(BorderLayout.SOUTH,tf1);     //2nd Method
        add(tf2,BorderLayout.NORTH);
        add(ta1,BorderLayout.CENTER);    //3rd Method


        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public static void main(String args[])
    {
        BorderLayoutDemo obj = new BorderLayoutDemo();
    }
}
