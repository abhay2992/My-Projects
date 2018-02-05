
import javax.swing.text.*;
import javax.swing.*;

public class JFormattedTextField1 extends JFrame
{
    JFormattedTextField ftf1,ftf2;
    MaskFormatter mf1,mf2;

    public JFormattedTextField1() 
    {
        super("JFormattedTextField Demo");
        setLayout(null);
        try
        {
            mf1= new MaskFormatter("##/##/####");
            mf1.setPlaceholderCharacter('_');
            ftf1 = new JFormattedTextField(mf1);
            ftf1.setBounds(30,30,150,30);
            add(ftf1);

            mf2= new MaskFormatter("(###)-##-####");
            mf2.setPlaceholderCharacter('_');
            ftf2 = new JFormattedTextField(mf2);
            ftf2.setBounds(30,70,150,30);
            add(ftf2);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String args[])
    {
        JFormattedTextField1 obj = new JFormattedTextField1();
    }
}
