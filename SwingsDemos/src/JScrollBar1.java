import javax.swing.*;
public class JScrollBar1 extends JFrame
{

    JScrollBar sb1,sb2;
    public JScrollBar1()
    {

        super("JScrollbar Demo");
        setLayout(null);
        
        sb2 = new JScrollBar(JScrollBar.HORIZONTAL);
        add(sb2);
        sb2.setBounds(30,250,200,20);

        sb1 = new JScrollBar(JScrollBar.VERTICAL);
        add(sb1);
        sb1.setBounds(210,40,20,200);

        setSize(350,350);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public static void main(String args[])
    {
        JScrollBar1 obj = new JScrollBar1();
    }


}
