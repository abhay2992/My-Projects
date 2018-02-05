//JTextArea --

import javax.swing.*;

public class JTextArea1 extends JFrame
{
    JTextArea ta1,ta2,ta3,ta4;
    JScrollPane sp1,sp2,sp3,sp4;
    JLabel lb1,lb2,lb3,lb4;

    public JTextArea1()
    {
        super("JTextArea Demo");
        setLayout(null);

        lb1 = new JLabel("JTextArea()");
        lb2 = new JLabel("JTextArea(\"Hello World\")");
        lb3 = new JLabel("JTextArea(\"Hello World\",200,100)");
        lb4 = new JLabel("JTextArea(200,100)");
        ta1 = new JTextArea();
        ta2 = new JTextArea("Hello World");
        ta3 = new JTextArea("Hello Java",200,100);
        ta4 = new JTextArea(200,100);
        
        sp1 = new JScrollPane(ta1);
        sp2 = new JScrollPane(ta2);
        sp3 = new JScrollPane(ta3);
        sp4 = new JScrollPane(ta4);

        sp1.setBounds(30,30,200,100);
        sp2.setBounds(30,140,200,100);
        sp3.setBounds(30,250,200,100);
        sp4.setBounds(30,360,200,100);

        lb1.setBounds(240,80,200,30);
        lb2.setBounds(240,190,200,30);
        lb3.setBounds(240,300,200,30);
        lb4.setBounds(240,410,200,30);

        add(sp1);
        add(sp2);
        add(sp3);
        add(sp4);
        add(lb1);
        add(lb2);
        add(lb3);
        add(lb4);

        setSize(500,550);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String args[])
    {
        JTextArea1 obj = new JTextArea1();
    }


}
