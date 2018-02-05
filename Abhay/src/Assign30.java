import java.applet.*;
import java.awt.*;
public class Assign30 extends  Applet
{
    //int x[]=new int[4];
    //int y[]=new int[4];
    public void paint(Graphics g)
    {
        int x[]={100, 120, 220, 200};
        int y[]={50,100,90,40};
        g.setColor(Color.green);
        g.fillPolygon(x,y,4);
        g.setColor(Color.red);
        g.drawPolygon(x,y,4);
        g.drawLine(120,100,120,180);
        g.drawLine(220,90,220,170);
        g.drawLine(120,180,220,170);
        g.drawLine(100,50,80,100);
        g.drawLine(80,100,80,180);
        g.drawLine(80,180,120,180);
        
        g.setColor(Color.blue);
        g.fillRect(88,150,20,30);
        int a[]={100,103,110,105,105,100,95,95,90,97};
        int b[]={67,74,74,79,85,79,85,79,74,74};
        g.drawPolygon(a,b,10);
        g.setColor(Color.green.darker());
        g.fillPolygon(a,b,10);
        int c[]={150,190,192,152};
        int d[]={120,116,156,160};
        g.drawPolygon(c,d,4);
        g.drawLine(170,118,172,158);
        g.drawLine(151,140,191,136);
        //g.drawLine(80,100,80,170);
        
        
    }
}
