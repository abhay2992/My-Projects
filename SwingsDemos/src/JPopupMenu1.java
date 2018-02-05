import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import javax.swing.*;
public class JPopupMenu1 extends JFrame implements MouseListener,ActionListener
{
    JPopupMenu popupMenu;
    JMenuItem menuItem1,menuItem2,menuItem3,menuItem4,menuItem5;
    JLabel lb1;
    JPopupMenu1()
    {
        super("JPopupMenu Demo");
        setLayout(null);

        menuItem1 = new JMenuItem("Copy");
        menuItem2 = new JMenuItem("Cut");
        menuItem3 = new JMenuItem("Paste");
        menuItem4 = new JMenuItem("Undo");
        menuItem5 = new JMenuItem("Refresh");
        lb1 = new JLabel();
        lb1.setBounds(20,20,150,25);
        
        popupMenu = new JPopupMenu("One");
        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
        popupMenu.addSeparator();
        popupMenu.add(menuItem3);
        popupMenu.add(menuItem4);
        popupMenu.addSeparator();
        popupMenu.add(menuItem5);

        add(popupMenu);
        add(lb1);

        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        menuItem5.addActionListener(this);
        addMouseListener(this);

        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String args[])
    {
        JPopupMenu1 obj = new JPopupMenu1();
    }

    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==menuItem1)
            lb1.setText("You choose  \"  "+menuItem1.getText()+"  \"");
        else if(e.getSource()==menuItem2)
            lb1.setText("You choose  \"  "+menuItem2.getText()+"  \"");
        else if(e.getSource()==menuItem3)
            lb1.setText("You choose  \"  "+menuItem3.getText()+"  \"");
        else if(e.getSource()==menuItem4)
            lb1.setText("You choose  \"  "+menuItem4.getText()+"  \"");
        else if(e.getSource()==menuItem5)
            lb1.setText("You choose  \"  "+menuItem5.getText()+"  \"");
    }

    public void mousePressed(MouseEvent e)
    {
        if(e.getButton()==MouseEvent.BUTTON3)       //BUTTON1 for left
        {                                           //BUTTON2 for center
            popupMenu.show(this,e.getX(),e.getY()); //BUTTON3 for right
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
