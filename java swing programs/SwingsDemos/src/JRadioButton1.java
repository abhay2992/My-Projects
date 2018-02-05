
//JButton -- ActionListener

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JRadioButton1 extends JFrame implements ItemListener
{


    JRadioButton rb1,rb2,rb3;
    ButtonGroup buttonGroup;
    int r,g,b;
    public JRadioButton1()
    {
        super("JRadioButton Demo");
        setLayout(null);

        rb1 = new JRadioButton("Red");
        rb2 = new JRadioButton("Green");
        rb3 = new JRadioButton("Blue");
        buttonGroup = new ButtonGroup();
        rb1.setSelected(true);

        buttonGroup.add(rb1);
        buttonGroup.add(rb2);
        buttonGroup.add(rb3);

        rb1.setBounds(50,50,100,30);
        rb2.setBounds(160,50,100,30);
        rb3.setBounds(270,50,100,30);

        add(rb1);
        add(rb2);
        add(rb3);

        rb1.addItemListener(this);
        rb2.addItemListener(this);
        rb3.addItemListener(this);

        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void itemStateChanged(ItemEvent e)
    {
        
        if(e.getSource()==rb1)
        {
            r=255; g=0; b=0;
        }
        else if(e.getSource()==rb2)
        {
            r=0; g=255; b=0;
        }
        else if(e.getSource()==rb3)
        {
            r=0; g=0; b=255;
        }

        repaint();

    }

    public void paint(Graphics grph)
    {
        Color cl = new Color(r,g,b);
        grph.setColor(cl);
        grph.fillOval(120,150,100,100);
    }

    public static void main(String args[])
    {
        JRadioButton1 obj = new JRadioButton1();
    }


}

