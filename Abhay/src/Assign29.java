import java.awt.*;
import java.applet.*;

public class Assign29 extends Applet
{
    public void paint(Graphics g)
    {
        g.setColor(Color.orange);
        g.fillOval(50,50,200,200);
        g.setColor(Color.black);
        g.fillOval(100, 100, 20,20);
        g.fillOval(180,100,20,20);
        g.drawLine(150,125,150,185);
        g.drawArc(62,43,180,175,230,78);
        g.drawLine(100,190,89,207);
        g.drawLine(202,192,213,206);
    }
}
