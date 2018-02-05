//FlowLayout is the default layout for applet and panel

import java.awt.FlowLayout;
import javax.swing.*;
public class FlowLayoutDemo extends JFrame
{
    JButton bt1,bt2,bt3,bt4,bt5;
    FlowLayout flowLayout;
    FlowLayoutDemo()
    {
        //flowLayout =new FlowLayout();  // By default hgap and vgap
                                       // b/w components is 5 units
                                       // and CENTER Aligned

        //flowLayout =new FlowLayout(FlowLayout.LEFT);  //LEFT,RIGHT,CENTER
        flowLayout =new FlowLayout(FlowLayout.LEFT,10,10);
        this.setLayout(flowLayout);

        bt1 = new JButton("Button 1");
        bt2 = new JButton("Button 2");
        bt3 = new JButton("Button 3");
        bt4 = new JButton("Button 4");
        bt5 = new JButton("Button 5");

        add(bt1);
        add(bt2);
        add(bt3);
        add(bt4);
        add(bt5);

        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    public static void main(String args[])
    {
        FlowLayoutDemo obj = new FlowLayoutDemo();
    }
}
