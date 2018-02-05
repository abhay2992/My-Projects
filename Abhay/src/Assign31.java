import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Assign31 extends Applet implements ActionListener
{
    TextField t1;
    Button b1;
    String s="";
    Font f;
    
    public void init()
    {
        t1=new TextField(25);
        b1=new Button("Click");
        f=new Font("Times New Roman",Font.BOLD,50);
        add(t1);
        add(b1);
        b1.addActionListener(this);
    }
    
    public void paint(Graphics gg)
    {
        gg.setFont(f);
        gg.drawString(s,50,150);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        s=t1.getText();
        repaint();
    }
}