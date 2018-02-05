//JProgressBar -- ChangeListener

import java.awt.Color;
import javax.swing.*;
import javax.swing.event.*;

public class JProgressBar1 extends JFrame implements ChangeListener
{
    JProgressBar jprogressbar;
    JLabel lb1;
    JProgressBar1()
    {
        super("JProgressBar Demo");
        setLayout(null);
        jprogressbar = new JProgressBar(JProgressBar.HORIZONTAL,0,100);
        lb1 = new JLabel();

        add(jprogressbar);
        add(lb1);

        jprogressbar.setBackground(Color.WHITE);
        jprogressbar.setForeground(Color.GRAY);
        jprogressbar.setStringPainted(true);

        jprogressbar.setBounds(50,50,200,30);
        lb1.setBounds(50,100,200,30);
        jprogressbar.addChangeListener(this);
 setSize(300,300);
        setVisible(true);
        

        try
        {
            for(int i=0; i<=100; i++)
            {
                Thread.sleep(100);
                jprogressbar.setValue(i);
                jprogressbar.setString(i+"%");
            }
            JOptionPane.showMessageDialog(this, "Download complete");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

       
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void stateChanged(ChangeEvent e)
    {
        lb1.setText(jprogressbar.getValue()+" % Completed");
    }

    public static void main(String args[])
    {
        JProgressBar1 obj = new JProgressBar1();
    }

}
