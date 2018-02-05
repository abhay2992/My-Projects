import javax.swing.*;

public class JPasswordField1 extends JFrame
{
    JPasswordField jpf1,jpf2;
    JLabel lb1,lb2;
    JPasswordField1()
    {
        super("JPasswordField Demo");
        setLayout(null);
        jpf1 = new JPasswordField("Hello World");
        jpf1.setBounds(50,50,150,30);
        add(jpf1);

        jpf2 = new JPasswordField("Hello world");
        jpf2.setBounds(50,100,150,30);
        jpf2.setEchoChar('*');
        add(jpf2);

        lb1 = new JLabel("With Default Echo Chararacter");
        lb1.setBounds(210,55,200,25);
        add(lb1);

        lb2 = new JLabel("Setting * as Echo Chararacter");
        lb2.setBounds(210,105,200,25);
        add(lb2);

        setSize(430,250);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public static void main(String args[])
    {
        JPasswordField1 obj = new JPasswordField1();
    }
}
