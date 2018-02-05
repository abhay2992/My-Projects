package Games;

import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class TicTacToe extends Applet implements ActionListener
{
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;





    String msg="";
    Button bt;

    Button btRestart;
    boolean flag;
    static int count=0;
    static int i=0;



    @Override
    public void init()
    {
        setLayout(null);




        bt1= new Button(" 1 ");
        bt2= new Button(" 2 ");
        bt3= new Button(" 3 ");
        bt4= new Button(" 4 ");
        bt5= new Button(" 5 ");
        bt6= new Button(" 6 ");
        bt7= new Button(" 7 ");
        bt8= new Button(" 8 ");
        bt9= new Button(" 9 ");

        bt1.setBounds(100,50,40,40);
        bt2.setBounds(140,50,40,40);
        bt3.setBounds(180,50,40,40);
        bt4.setBounds(100,90,40,40);
        bt5.setBounds(140,90,40,40);
        bt6.setBounds(180,90,40,40);
        bt7.setBounds(100,130,40,40);
        bt8.setBounds(140,130,40,40);
        bt9.setBounds(180,130,40,40);

        btRestart = new Button("Restart Game");
        btRestart.setBounds(230,90,100,40);

        add(bt1);
        add(bt2);
        add(bt3);
        add(bt4);
        add(bt5);
        add(bt6);
        add(bt7);
        add(bt8);
        add(bt9);

        add(btRestart);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);
        bt6.addActionListener(this);
        bt7.addActionListener(this);
        bt8.addActionListener(this);
        bt9.addActionListener(this);
        btRestart.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e)
    {
        bt = (Button)e.getSource();


        if(bt.getLabel().equals("Restart Game"))
        {
            count=0;
            i=0;
            setEnabledAll();
            msg="";
            repaint();
        }
        else
        {

        if(!(bt.getLabel().equals("X")) && !(bt.getLabel().equals("0")))
        {
            i++;
            if(count==0 || count%2==0)
            {
                bt.setLabel("X");
                count++;
            }
            else
            {
                bt.setLabel("0");
                count++;
            }
            if(i==9 && flag==false)
            {
                msg="Match Draw";
                repaint();
            }
        }
        }


        ////////////////////////////////////////
        flag=isWon(bt1,bt2,bt3);
        if(flag==true)
        {
            msg=bt1.getLabel()+" won";
            disabledAll();
            repaint();

        }
        flag=isWon(bt4,bt5,bt6);
        if(flag==true)
        {
            msg=bt4.getLabel()+" won";
            disabledAll();
            repaint();

        }
        flag=isWon(bt7,bt8,bt9);
        if(flag==true)
        {
            msg=bt7.getLabel()+" won";
            disabledAll();
            repaint();

        }
        flag=isWon(bt1,bt4,bt7);
        if(flag==true)
        {
            msg=bt1.getLabel()+" won";
            disabledAll();
            repaint();

        }
        flag=isWon(bt2,bt5,bt8);
        if(flag==true)
        {
            msg=bt2.getLabel()+" won";
            disabledAll();
            repaint();

        }
        flag=isWon(bt3,bt6,bt9);
        if(flag==true)
        {
            msg=bt3.getLabel()+" won";
            disabledAll();
            repaint();

        }
        flag=isWon(bt1,bt5,bt9);
        if(flag==true)
        {
            msg=bt1.getLabel()+" won";
            disabledAll();
            repaint();

        }
        flag=isWon(bt3,bt5,bt7);
        if(flag==true)
        {
            msg=bt3.getLabel()+" won";
            disabledAll();
            repaint();
        }

    }
   //////////////////////////////////////////////////////////////////////////
    boolean isWon(Button b1, Button b2, Button b3)
    {
        if(b1.getLabel().equals(b2.getLabel()) && b2.getLabel().equals(b3.getLabel()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
 ///////////////////////////////////////////////////////////////////////////////
    @Override
    public void paint(Graphics g)
    {
        g.drawString(msg, 140, 190);
    }

    //////////////////////////////////////////////////////////////////////////



    void disabledAll()
    {
        bt1.setEnabled(false);
        bt2.setEnabled(false);
        bt3.setEnabled(false);
        bt4.setEnabled(false);
        bt5.setEnabled(false);
        bt6.setEnabled(false);
        bt7.setEnabled(false);
        bt8.setEnabled(false);
        bt9.setEnabled(false);
    }


    void setEnabledAll()
    {

        bt1.setLabel(" 1 ");
        bt2.setLabel(" 2 ");
        bt3.setLabel(" 3 ");
        bt4.setLabel(" 4 ");
        bt5.setLabel(" 5 ");
        bt6.setLabel(" 6 ");
        bt7.setLabel(" 7 ");
        bt8.setLabel(" 8 ");
        bt9.setLabel(" 9 ");

        bt1.setEnabled(true);
        bt2.setEnabled(true);
        bt3.setEnabled(true);
        bt4.setEnabled(true);
        bt5.setEnabled(true);
        bt6.setEnabled(true);
        bt7.setEnabled(true);
        bt8.setEnabled(true);
        bt9.setEnabled(true);

    }


}
