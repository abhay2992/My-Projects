
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CardLayoutDemo1 extends JFrame implements ActionListener,MouseListener
{
    CardLayout cardLayout;
    Checkbox WinXP,Win7,Mac,Linux;
    JButton win,other;
    JPanel osCards;
    CardLayoutDemo1()
    {
        cardLayout = new CardLayout(); //Cardlayout with gaps of size 0
        //cardLayout = new CardLayout(10,10);
        //setLayout(cardLayout);
        setLayout(new FlowLayout());

        win = new JButton("Windows");
        other = new JButton("Others");

        add(win);
        add(other);

        osCards = new JPanel();
        osCards.setLayout(cardLayout);

        WinXP = new Checkbox("WindowsXP");
        Win7 = new Checkbox("Windows7");
        Mac = new Checkbox("Mac");
        Linux = new Checkbox("Linux");
        
        JPanel winPan = new JPanel();
        winPan.add(WinXP);
        winPan.add(Win7);
        JPanel otherPan = new JPanel();
        otherPan.add(Mac);
        otherPan.add(Linux);

        osCards.add(winPan,"Windows");
        osCards.add(otherPan,"Others");
        add(osCards);

        win.addActionListener(this);
        other.addActionListener(this);
        addMouseListener(this);



        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==win)
        {
            cardLayout.show(osCards, "Windows");
        }
        else
        {
            cardLayout.show(osCards,"Others");
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        cardLayout.next(osCards);
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static void main(String args[])
    {
        CardLayoutDemo1 obj = new CardLayoutDemo1();
    }


}
