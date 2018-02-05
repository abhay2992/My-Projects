import javax.swing.*;
import java.awt.event.*;
public class JToggleButton1 extends JFrame implements ActionListener
{

    JToggleButton tb1;
    JLabel lb1;
    
    public JToggleButton1() 
    {
        super("JToggleButton Demo");
        setLayout(null);
        
        lb1 = new JLabel("Hello Java");
        tb1 = new JToggleButton("Change Label Text");
        
        lb1.setBounds(50,50,100,30);
        tb1.setBounds(50,100,200,30);
        
        add(lb1);
        add(tb1);
        
        tb1.addActionListener(this);
        
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(tb1.isSelected())
            lb1.setText("Hello World");
        else
            lb1.setText("Hello Java");
        
    }
    public static void main(String args[])
    {
        JToggleButton1 obj = new JToggleButton1();
    }

}
