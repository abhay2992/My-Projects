package Games;
import javax.swing.*;
import java.awt.*;
import java.applet.*;

public class RandomBall1 extends JApplet
{
    int x=0,y=0;
    public void init()
    {
        setSize(500,600);
        
    }
    
    public void start()
    {
        while(true)  
        {
         repaint();
        if((x+50)<this.getWidth())
        {
            x++;
        }
        else
        {
            x--;
        }
        
        if(((x+50)!=this.getWidth())&&(y+50)<this.getHeight())
        {
            y++;
        }
        else
        {
            y--;
        }
        
       }
    }
    
    public void paint(Graphics g)
    {
        
        g.setColor(Color.black);
        g.fillOval(x,y,50,50);
        try
        {
              Thread.sleep(1000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        g.setColor(Color.white);
        g.fillOval(x,y,50,50);
         
        
    }
}
