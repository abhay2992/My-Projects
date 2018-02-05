
import java.awt.GridLayout;
import javax.swing.*;

public class GridLayoutDemo extends JFrame
{
    GridLayout gridLayout;
    JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7;
    GridLayoutDemo()
    {
        //gridLayout = new GridLayout();  // Create grid layout having one column for each component
        //gridLayout = new GridLayout(3,3); // Create grid layout having 3 rows and 3 columns
                                          // No. of rows having more priority
        gridLayout = new GridLayout(3,3,10,10);  // (Rows,Cols,hgap,vgap)

        this.setLayout(gridLayout);

        bt1 = new JButton("Button 1");
        bt2 = new JButton("Button 2");
        bt3 = new JButton("Button 3");
        bt4 = new JButton("Button 4");
        bt5 = new JButton("Button 5");
        bt6 = new JButton("Button 6");
        bt7 = new JButton("Button 7");

        add(bt1);
        add(bt2);
        add(bt3);
        add(bt4);
        add(bt5);
        add(bt6);
        add(bt7);

        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    public static void main(String args[])
    {
        GridLayoutDemo obj = new GridLayoutDemo();
    }

}
