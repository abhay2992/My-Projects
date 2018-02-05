
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class JSpinner1 extends JFrame implements ActionListener
{
    JSpinner jspinner1,jspinner2,jspinner3,jspinner4;
    SpinnerDateModel sdm;
    SpinnerListModel slm;
    SpinnerNumberModel snm;
    ArrayList <String> al;
    JLabel lb1,lb2,lb3,lb4;
    JButton bt1,bt2,bt3,bt4;

    public JSpinner1()
    {
        super("JSpinner Demo");
        setLayout(null);

        jspinner1 = new JSpinner();
        jspinner1.setBounds(50,50,155,30);
        add(jspinner1);

        sdm = new SpinnerDateModel();
        jspinner2 = new JSpinner(sdm);
        jspinner2.setBounds(50,100,155,30);
        add(jspinner2);

        snm = new SpinnerNumberModel(40, 0, 100, 2);
        jspinner3 = new JSpinner(snm);
        jspinner3.setBounds(50,150,155,30);
        add(jspinner3);

        al = new ArrayList<String>();
        al.add("ABC");
        al.add("PQR");
        al.add("MNO");
        al.add("ASD");
        al.add("MNO");
        al.add("XYZ");
        slm = new SpinnerListModel(al);
        jspinner4 = new JSpinner(slm);
        jspinner4.setBounds(50,200,155,30);
        add(jspinner4);

        lb1 = new JLabel("new JSpinner()");
        lb2 = new JLabel("new JSpinner(new SpinnerDateModel())");
        lb3 = new JLabel("new JSpinner(new SpinnerNumberModel(40, 0, 100, 2))");
        lb4 = new JLabel("new JSpinner(new SpinnerListModel(new ArrayList<String>()))");

        lb1.setBounds(220,50,300,30);
        lb2.setBounds(220,100,300,30);
        lb3.setBounds(220,150,350,30);
        lb4.setBounds(220,200,400,30);

        add(lb1);
        add(lb2);
        add(lb3);
        add(lb4);

        bt1 = new JButton("JSpinner-1");
        bt2 = new JButton("JSpinner-2");
        bt3 = new JButton("JSpinner-3");
        bt4 = new JButton("JSpinner-4");

        bt1.setBounds(50,250,100,30);
        bt2.setBounds(170,250,100,30);
        bt3.setBounds(290,250,100,30);
        bt4.setBounds(410,250,100,30);

        add(bt1);
        add(bt2);
        add(bt3);
        add(bt4);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);


        setSize(700,350);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        JOptionPane.showMessageDialog(null,"Selected number from JSpinner-1 is : "+jspinner1.getValue());
        else if(e.getSource()==bt2)
        JOptionPane.showMessageDialog(null,"Selected date and time from JSpinner-2 is : "+jspinner2.getValue());
        else if(e.getSource()==bt3)
        JOptionPane.showMessageDialog(null,"Selected number from JSpinner-3 is : "+jspinner3.getValue());
        else if(e.getSource()==bt4)
        JOptionPane.showMessageDialog(null,"Selected item from JSpinner-4 is : "+jspinner4.getValue());
    }

    public static void main(String args[])
    {
        JSpinner1 obj = new JSpinner1();
    }



}
