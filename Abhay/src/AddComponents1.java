import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class AddComponents1 extends Applet implements ActionListener
{
     Button b1;
     TextField t1;
     TextField t2;
     Color cl;
     
     public void init()
     {
         b1=new Button("Change Color");
         t1=new TextField(25);
         t2=new TextField(25);
         cl=new Color(255,3,2);
         add(t1);
         add(b1);
         add(t2);
         b1.addActionListener(this);
     }
     
     public void paint(Graphics gg)
     {
         gg.setColor(cl);
         gg.fillRect(10, 10, 50, 50);
     }
     
     public void actionPerformed(ActionEvent e)
     {
         int r=(int)(255*Math.random());
         int g=(int)(255*Math.random());
         int b=(int)(255*Math.random());
         cl=new Color(r,g,b);
         t2.setText(t1.getText());
         repaint();
     }
     
    
}
