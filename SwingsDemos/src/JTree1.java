import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
public class JTree1 extends JFrame implements TreeSelectionListener,ActionListener
{
    DefaultMutableTreeNode root,child1,child2,child3,child4,child5;
    DefaultMutableTreeNode ch1,ch2,ch3,ch4,ch5;
    JTree myTree;
    JScrollPane sp;
    DefaultMutableTreeNode newNode,parentNode;

    JTextField tf1;
    JLabel lb1;
    JButton bt1;
    
    JTree1()
    {
        super("JTreeDemo");
        setLayout(null);
        lb1 = new JLabel("Enter name for new node");
        tf1 = new JTextField();
        bt1 = new JButton("Add Node");

        root = new DefaultMutableTreeNode("India");
        
        child1 = new DefaultMutableTreeNode("Punab");
        child2 = new DefaultMutableTreeNode("Haryana");
        child3 = new DefaultMutableTreeNode("Gujrat");
        child4 = new DefaultMutableTreeNode("Maharashtra");
        child5 = new DefaultMutableTreeNode("Kerela");
        
        ch1 = new DefaultMutableTreeNode("Moga");
        ch2 = new DefaultMutableTreeNode("Ferozepur");
        ch3 = new DefaultMutableTreeNode("Ludhiana");
        ch4 = new DefaultMutableTreeNode("Amritsar");
        ch5 = new DefaultMutableTreeNode("Jalandhar");

        child1.add(ch1);
        child1.add(ch2);
        child1.add(ch3);
        child1.add(ch4);
        child1.add(ch5);

        root.add(child1);
        root.add(child2);
        root.add(child3);
        root.add(child4);
        root.add(child5);

        myTree = new JTree(root);
        sp = new JScrollPane(myTree);
        sp.setBounds(50, 50, 390, 300);
        lb1.setBounds(50, 360, 180, 20);
        tf1.setBounds(240,360,200,25);
        bt1.setBounds(340,395,100,25);
        add(lb1);
        add(tf1);
        add(bt1);
        add(sp);
        bt1.addActionListener(this);

        myTree.addTreeSelectionListener(this);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String args[])
    {
        JTree1 obj = new JTree1();
    }
    public void valueChanged(TreeSelectionEvent e)
    {
        newNode = (DefaultMutableTreeNode) myTree.getSelectionPath().getLastPathComponent();
    }
    public void actionPerformed(ActionEvent e)
    {
      DefaultMutableTreeNode one = new DefaultMutableTreeNode(tf1.getText());
      newNode.add(one);
      myTree.fireTreeExpanded(myTree.getSelectionPath());
    }
}
