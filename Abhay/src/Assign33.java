import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Assign33 extends Applet implements ActionListener
{
    TextField t1;
    TextField t2;
    TextField t3;
    TextField t4;
    Button b1;
    int a,b,c,d;
    
    public void init()
    {
        a=b=c=d=0;
        t1=new TextField(10);
        t2=new TextField(10);
        t3=new TextField(10);
        t4=new TextField(10);
        Button b1=new Button("Click me");
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(b1);
        b1.addActionListener(this);
    }
    
    public void paint(Graphics g)
    {
        
        g.drawLine(300,300,500,300);
        g.drawLine(300,300,300,200);
        g.setColor(Color.BLUE);
        g.fillRect(315,300-(a/4),30,a/4);
        g.setColor(Color.green);
        g.fillRect(360,300-(b/4),30,b/4);
        g.setColor(Color.red);
        g.fillRect(405,300-(c/4),30,c/4);
        g.setColor(Color.GRAY);
        g.fillRect(450,300-(d/4),30,d/4);
        g.setColor(Color.black);
        g.drawString(t1.getText(), 315, 315);
        g.drawString(t2.getText(), 360, 315);
        g.drawString(t3.getText(), 405, 315);
        g.drawString(t4.getText(), 450, 315);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        a=Integer.parseInt(t1.getText());
        b=Integer.parseInt(t2.getText());
        c=Integer.parseInt(t3.getText());
        d=Integer.parseInt(t4.getText());
        repaint();
    }
    


}
