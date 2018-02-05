import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Assign32 extends Applet implements ActionListener
{
    Button b1;
    Boolean bool=true;
    int a=0;
    public void init()
    {
        b1=new Button("Click me");
        add(b1);
        b1.addActionListener(this);
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.ORANGE);
        g.fillOval(50,50,200,200);
        g.setColor(Color.black);
        g.fillOval(100, 100, 20,20);
        g.fillOval(180,100,20,20);
        g.drawLine(150,125,150,185);
        if(bool)
        {
            g.drawArc(62,43,180,175,230,78);
        }
       else
        {
            g.drawArc(62,203,180,175,52,78);
        }
   
    }
    
    public void actionPerformed(ActionEvent e)
    {
        a++;
        if(a%2==0)
        {
            bool=true;
        }
        else
        {
            bool=false;
        }
        
        repaint();
    }
}
