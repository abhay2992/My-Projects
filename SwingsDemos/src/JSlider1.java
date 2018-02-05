import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class JSlider1 extends JFrame implements ChangeListener
{

    JSlider slider1,slider2,slider3,slider4;
    JLabel lb1,lb2,lb3,lb4;
    public JSlider1()
    {
        super("JSlider Demo");
        setLayout(null);

       
        slider2 = new JSlider(JSlider.HORIZONTAL);
        slider3 = new JSlider(0,100);
        slider4 = new JSlider(JSlider.HORIZONTAL,0,200,25);

        lb1 = new JLabel("JSlider(JSlider.HORIZONTAL)");
        lb2 = new JLabel("JSlider(0,100)");
        lb3 = new JLabel("JSlider(JSlider.HORIZONTAL,0,200,25)");
        lb4 = new JLabel("Value selected : "+slider4.getValue());

        slider2.setBounds(110,25,300,50);
        slider3.setBounds(110,150,300,50);
        slider4.setBounds(110,270,300,50);

        lb1.setBounds(450,25,300,30);
        lb2.setBounds(450,150,300,30);
        lb3.setBounds(450,270,300,30);
        lb4.setBounds(110,350,200,30);

        slider3.setPaintTicks(true);
        slider3.setMinorTickSpacing(10);
        slider3.setPaintLabels(true);
        slider3.setMajorTickSpacing(20);

        slider4.setPaintTicks(true);
        slider4.setMinorTickSpacing(10);
        slider4.setPaintLabels(true);
        slider4.setMajorTickSpacing(20);

        add(slider2);
        add(slider3);
        add(slider4);
        add(lb1);
        add(lb2);
        add(lb3);
        add(lb4);

        slider4.addChangeListener(this);

        setSize(700,450);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void stateChanged(ChangeEvent e)
    {
        lb4.setText("Value selected : "+slider4.getValue());
    }
    public static void main(String args[])
    {
        JSlider1 obj = new JSlider1();
    }

}
