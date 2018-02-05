import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class CardLayoutDemo extends JFrame implements ActionListener
{
    CardLayout cardLayout;
    JButton bt1,bt2;
    JPanel mainPanel;
    JPanel panel1,panel2;
    JTextField tf1,tf2;
    JButton bt3,bt4;
    JLabel lb1,lb2;
    CardLayoutDemo()
    {
        //setLayout(new FlowLayout());
        setLayout(new BorderLayout());
        cardLayout = new CardLayout();

        bt1 = new JButton("Panel - 1");
        bt2 = new JButton("Panel - 2");
        add(bt1,BorderLayout.EAST);
        add(bt2,BorderLayout.WEST);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        mainPanel = new JPanel();
        mainPanel.setLayout(cardLayout);
        add(mainPanel,BorderLayout.CENTER);
        lb1 = new JLabel("This is Panel 1");
        tf1 = new JTextField(25);
        tf2 = new JTextField(25);
        panel1 = new JPanel();
        panel1.add(lb1);
        panel1.add(tf1);
        panel1.add(tf2);
        mainPanel.add(panel1,"firstpanel");

        lb2 = new JLabel("This is Panel 2");
        bt3 = new JButton("Button 1");
        bt4 = new JButton("Button 2");
        panel2 = new JPanel();
        panel2.add(lb2);
        panel2.add(bt3);
        panel2.add(bt4);
        mainPanel.add(panel2,"secondpanel");


        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            cardLayout.show(mainPanel, "firstpanel");
        }
        else
        {
            cardLayout.show(mainPanel, "secondpanel");
        }
    }

    public static void main(String args[])
    {
        CardLayoutDemo obj = new CardLayoutDemo();
    }
}
