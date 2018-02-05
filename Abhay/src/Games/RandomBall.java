package Games;
import javax.swing.*;
import java.awt.*;
import java.applet.*;

public class RandomBall extends JApplet implements Runnable
{
    int x=0,y=0;
    Thread t1;
    public void init()
    {
        t1=new Thread(this);
        setSize(400,450);
       
        t1.start();
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.black);
        g.fillOval(x,y,50,50);
         
        
    }
   
    
    public void run()
    {
      boolean flagx=false, flagy=false;
      while(true)  
      {
        try
        {
              Thread.sleep(1);
        } 
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(((x+50)<this.getWidth())&&(flagx==false))
        {
            x++;
            if((x+50)==this.getWidth())
            {
                flagx=true;
            }
        }
        
        else if(flagx==true)
        {
            x--;
            if((x-50)==0)
                flagx=false;
        }
        
        if((y+50)<this.getHeight()&&(flagy==false))
        {
            y++;
            if((y+50)==this.getHeight())
                flagy=true;
        }
        else if(flagy==true)
        {
            y--;
            if((y-50)==0)
                flagy=false;
        }
        
        repaint();
      }
    }
    
}
