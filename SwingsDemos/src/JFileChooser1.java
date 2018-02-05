import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
public class JFileChooser1 extends JFrame implements ActionListener
{
    JButton bt1,bt2;
    JFileChooser fileChooser;
    JTextField tf1,tf2;
    JLabel lb1,lb2;

    public JFileChooser1()
    {
        super("JFileChooser Demo");
        setLayout(null);

        fileChooser= new JFileChooser();

        bt1 = new JButton("Open File");
        bt1.setBounds(100,50,150,30);
        add(bt1);

        bt2 = new JButton("Sava File");
        bt2.setBounds(280,50,150,30);
        add(bt2);

        lb1 = new JLabel("Selected File is : ");
        lb1.setBounds(50,120,200,25);
        add(lb1);

        tf1 = new JTextField();
        tf1.setBounds(50,150,400,25);
        add(tf1);

        lb2 = new JLabel("File save at : ");
        lb2.setBounds(50,180,200,25);
        add(lb2);

        tf2 = new JTextField();
        tf2.setBounds(50,210,400,25);
        add(tf2);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);

        setSize(500,300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            int result = fileChooser.showOpenDialog(null);
            if(result==JFileChooser.APPROVE_OPTION)
            {
                File f = fileChooser.getSelectedFile();
                tf1.setText(f.getPath());
            }
        }
        else
        {
            int result = fileChooser.showSaveDialog(null);
            if(result==JFileChooser.APPROVE_OPTION)
            {
                File f = fileChooser.getSelectedFile();
                tf2.setText(f.getPath());
            }
        }
    }

    public static void main(String args[])
    {
        JFileChooser1 obj = new JFileChooser1();
    }
}
