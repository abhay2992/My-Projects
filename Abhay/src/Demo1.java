import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Demo1 extends Applet implements ItemListener
{
    Checkbox c1,c2,c3;
    Label l1,l2,l3;
    
    public void init()
    {
        setLayout(null);
        c1=new Checkbox("Red");
        c2=new Checkbox("Green");
        c3=new Checkbox("Blue");
        
        l1=new Label("RED SELECTED");
        l2=new Label("GREEN SELECTED");
        l3=new Label("BLUE SELECTED");
        
        c1.setBounds(10, 20, 100, 30);
        
        c2.setBounds(10, 60, 100, 30);
        
        c3.setBounds(10, 100, 100, 30);
        l1.setBounds(10, 140, 100, 30);
        
        l2.setBounds(10, 200, 100, 30);
        
        l3.setBounds(10, 260, 100, 30);
        add(c1);
        add(c2);
        add(c3);
        add(l1);
        add(l2);
        add(l3);
        
        
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
        
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        
    }
    
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getSource()==c1)
        {
            if(c1.getState()==true)
                l1.setVisible(true);
            else
                l1.setVisible(false);
        }
        
        else if(e.getSource()==c2)
        {
            if(c2.getState()==true)
                l2.setVisible(true);
            else
                l2.setVisible(false);
        }
        else if(e.getSource()==c3)
        {
            if(c3.getState()==true)
                l3.setVisible(true);
            else
                l3.setVisible(false);
       
        }
    }
    
    
}
//public class Demo1 extends Applet implements ActionListener
//{
//    TextField t1,t2;
//    Button b1,b2;
//    public void init()
//    {
//        t1=new TextField(25);
//        t2=new TextField(25);
//        b1=new Button("Button 1");
//        b2=new Button("Button 2");
//        add(t1);
//        add(t2);
//        add(b1);
//        add(b2);
//        t1.addActionListener(this);
//        b1.addActionListener(this);
//        t2.addActionListener(this);
//        
//        //b2.addActionListener(this);
//       
//    }
//    
//    public void actionPerformed(ActionEvent e)
//    {   
//        if(e.getSource()==t1)
//        {
//            t2.setText(t1.getText());
//        }
//        else if(e.getSource()==b1)
//            t2.setText("Event From Button 1");
//        else
//            t2.setText("Event From Button 2");
//    }
//}
