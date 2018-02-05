import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.Position;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class RemoveNodesFromTree extends JFrame implements ActionListener,TreeSelectionListener
{
    JTree jt;
    DefaultMutableTreeNode root,ch1,ch2,ch3,ch4,c1,c2,c3,c4,a1,a2,a3,a4,a5,a6;
    JScrollPane sp;
    JButton bt;
    JButton bt1;
    DefaultTreeModel tm;
    DefaultMutableTreeNode selectedNode;
    TreePath path;
    public RemoveNodesFromTree()
    {
        super("JTree Elements Remove Demo");
        setLayout(null);

        bt = new JButton("Remove Node");
        bt.setBounds(10,10,150,30);
        add(bt);
        bt.addActionListener(this);

        bt1 = new JButton("Remove Tree");
        bt1.setBounds(170,10,150,30);
        add(bt1);
        bt1.addActionListener(this);


        root = new DefaultMutableTreeNode("My Computer");
        ch1 = new DefaultMutableTreeNode("C:");
        ch2 = new DefaultMutableTreeNode("D:");
        ch3 = new DefaultMutableTreeNode("E:");
        ch4 = new DefaultMutableTreeNode("F:");

        c1 = new DefaultMutableTreeNode("My Music");
        c2 = new DefaultMutableTreeNode("My Documents");
        c3 = new DefaultMutableTreeNode("My Pictures");
        c4 = new DefaultMutableTreeNode("My Videos");

        a1 = new DefaultMutableTreeNode("one.mp3");
        a2 = new DefaultMutableTreeNode("two.mp3");
        a3 = new DefaultMutableTreeNode("three.mp3");
        a4 = new DefaultMutableTreeNode("four.mp3");
        a5 = new DefaultMutableTreeNode("five.mp3");
        a6 = new DefaultMutableTreeNode("six.mp3");

        c1.add(a1);
        c1.add(a2);
        c1.add(a3);
        c1.add(a4);
        c1.add(a5);
        c1.add(a6);

        ch1.add(c1);
        ch1.add(c2);
        ch1.add(c3);
        ch1.add(c4);

        root.add(ch1);
        root.add(ch2);
        root.add(ch3);
        root.add(ch4);

        jt = new JTree(root);
        jt.addTreeSelectionListener(this);
        tm = (DefaultTreeModel)jt.getModel();

        sp = new JScrollPane(jt);
        add(sp);
        sp.setBounds(10,60,200,200);

        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        
         if(e.getSource()==bt)
         {
             //path = jt.getNextMatch(selectedNode.toString(), 0, Position.Bias.Forward);
             //mNode = (MutableTreeNode)path.getLastPathComponent();
             int n=JOptionPane.showConfirmDialog(this, "Are you sure to delete ?");
             if(n==JOptionPane.YES_OPTION)
             {
                 tm.removeNodeFromParent(selectedNode);
             JOptionPane.showMessageDialog(null, "Node deleted successfully");
             }

         }
         else if(e.getSource()==bt1)
         {
             tm.setRoot(null);
             JOptionPane.showMessageDialog(null,"Tree deleted successfully");
         }
    }

    public void valueChanged(TreeSelectionEvent e)
    {
        try
        {
            selectedNode = (DefaultMutableTreeNode) jt.getSelectionPath().getLastPathComponent();
            System.out.println(selectedNode.toString());
        }
        catch(Exception ex)
        {
            
        }

    }


    public static void main(String args[])
    {
        RemoveNodesFromTree obj = new RemoveNodesFromTree();
    }



}
