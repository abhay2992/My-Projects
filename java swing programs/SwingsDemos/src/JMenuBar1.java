import javax.swing.*;
import java.awt.event.*;

public class JMenuBar1 extends JFrame implements ActionListener
{
    JMenuBar menubar;
    JMenu menu1,menu2,menu3;
    JMenuItem menuItem1,menuItem2,menuItem3,
              menuItem4,menuItem5,menuItem6,menuItem7,
              menuItem8,menuItem9,menuItem10;
    JMenuBar1()
    {
       super("JMenu Demo");
       setLayout(null);

       menubar = new JMenuBar();
       menu1 = new JMenu("File");
       menu2 = new JMenu("Edit");
       menu3 = new JMenu("Open Recent Files");

       menuItem1 = new JMenuItem("New Project");
       menuItem2 = new JMenuItem("New File");
       menuItem3 = new JMenuItem("Open Project");
       menuItem4 = new JMenuItem("Undo");
       menuItem5 = new JMenuItem("Cut");
       menuItem6 = new JMenuItem("Copy");
       menuItem7 = new JMenuItem("abc.java");
       menuItem8 = new JMenuItem("pqr.java");
       menuItem9 = new JMenuItem("mno.jpg");
       menuItem10 = new JMenuItem("xyz.java");

       menu3.add(menuItem7);
       menu3.add(menuItem8);
       menu3.add(menuItem9);
       menu3.add(menuItem10);

       menu1.add(menuItem1);
       menu1.add(menuItem2);
       menu1.add(menuItem3);
       menu1.add(menu3);
       
       menu2.add(menuItem4);
       menu2.add(menuItem5);
       menu2.add(menuItem6);

       menubar.add(menu1);
       menubar.add(menu2);
       menubar.setBounds(10, 10, 270, 20);

       add(menubar);
       menuItem1.addActionListener(this);
       menuItem2.addActionListener(this);

       setSize(300,300);
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==menuItem1)
        {
            JOptionPane.showMessageDialog(null,"You clicked \""+menuItem1.getText()+"\"");
        }
        else if(e.getSource()==menuItem2)
        {
            JOptionPane.showMessageDialog(null,"You clicked \""+menuItem2.getText()+"\"");
        }

    }
    public static void main(String args[])
    {
        JMenuBar1 obj = new JMenuBar1();
    }

}
