import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;


public class JTreeDemo extends JFrame implements TreeSelectionListener,ActionListener
{
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode child1,child2,child3,child4,child5;
    DefaultMutableTreeNode chld1,chld2,chld3,chld4,chld5;
    DefaultMutableTreeNode chd1,chd2,chd3,chd4,chd5;
    DefaultMutableTreeNode ch1,ch2,ch3,ch4,ch5;

    JScrollPane sp;
    JTree jt;
    DefaultTreeModel tm;
    DefaultMutableTreeNode selectedNode,newNode,nodeToDelete;
    TreePath path;
    JButton bt1,bt2,bt3,bt4;

    JTreeDemo()
    {
        super("JTreeDemo");
        setLayout(null);

        root = new DefaultMutableTreeNode("My Computer");

        child1 = new DefaultMutableTreeNode("C:");
        child2 = new DefaultMutableTreeNode("D:");
        child3 = new DefaultMutableTreeNode("E:");
        child4 = new DefaultMutableTreeNode("F:");
        child5 = new DefaultMutableTreeNode("G:");

        chld1 = new DefaultMutableTreeNode("Downloads");
        chld2 = new DefaultMutableTreeNode("Windows");
        chld3 = new DefaultMutableTreeNode("Program files");
        chld4 = new DefaultMutableTreeNode("Program files(x86)");
        chld5 = new DefaultMutableTreeNode("User");

        chd1 = new DefaultMutableTreeNode("Documents");
        chd2 = new DefaultMutableTreeNode("Compressed");
        chd3 = new DefaultMutableTreeNode("Music");
        chd4 = new DefaultMutableTreeNode("Videos");
        chd5 = new DefaultMutableTreeNode("Programs");

        ch1 = new DefaultMutableTreeNode("one.txt");
        ch2 = new DefaultMutableTreeNode("two.pdf");
        ch3 = new DefaultMutableTreeNode("three.docx");
        ch4 = new DefaultMutableTreeNode("four.pptx");
        ch5 = new DefaultMutableTreeNode("five.pdf");

        chd1.add(ch1);
        chd1.add(ch2);
        chd1.add(ch3);
        chd1.add(ch4);
        chd1.add(ch5);

        chld1.add(chd1);
        chld1.add(chd2);
        chld1.add(chd3);
        chld1.add(chd4);
        chld1.add(chd5);

        child1.add(chld1);
        child1.add(chld2);
        child1.add(chld3);
        child1.add(chld4);
        child1.add(chld5);

        root.add(child1);
        root.add(child2);
        root.add(child3);
        root.add(child4);
        root.add(child5);

        jt = new JTree(root);
        sp = new JScrollPane(jt);
        sp.setBounds(50,50,250,250);
        add(sp);

        bt1 = new JButton("Insert Node");
        bt1.setBounds(320,50,175,25);
        add(bt1);
        bt1.addActionListener(this);

        bt2 = new JButton("Remove Node");
        bt2.setBounds(320,85,175,25);
        add(bt2);
        bt2.addActionListener(this);

        bt3 = new JButton("Remove Root Node");
        bt3.setBounds(320,120,175,25);
        add(bt3);
        bt3.addActionListener(this);

        bt4 = new JButton("Remove Node By Search");
        bt4.setBounds(320,155,175,25);
        add(bt4);
        bt4.addActionListener(this);

        jt.addTreeSelectionListener(this);
        tm = (DefaultTreeModel)jt.getModel();

        setSize(600,500);
        setLocation(300,100);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            if(selectedNode==null)
            {
                    JOptionPane.showMessageDialog(this, "Select node first");
            }
            else
            {
                String str=JOptionPane.showInputDialog("Enter name for node");
                if(str.length()>0)
                {
                    newNode = new DefaultMutableTreeNode(str);
                    path = jt.getNextMatch(selectedNode+"", 0, Position.Bias.Forward);
                    tm.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
                    JOptionPane.showMessageDialog(null, "Node addedd successfully !!!");
                }
            }
        }

        else if(e.getSource()==bt2)
        {
             if(selectedNode==null)
             {
                 JOptionPane.showMessageDialog(this, "Select node first !!!");
             }
             else
             {
                int n=JOptionPane.showConfirmDialog(this, "Are you sure to delete ?");
                if(n==JOptionPane.YES_OPTION)
                {
                    tm.removeNodeFromParent(selectedNode);
                    JOptionPane.showMessageDialog(null, "Node deleted successfully");
                    selectedNode=null;
                }
             }
        }
        else if(e.getSource()==bt3)
        {
            tm.setRoot(null);
            JOptionPane.showMessageDialog(this, "Root node deleted successfully !!!");
        }
        else if(e.getSource()==bt4)
        {
            String name = JOptionPane.showInputDialog(this, "Enter node name");
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter name first !!!");
            }
            else
            {
                path = jt.getNextMatch(name, 0, Position.Bias.Forward);
                if(path==null)
                {
                    JOptionPane.showMessageDialog(null, "Node with given name doesnot exist");
                }
                else
                {
                    int n = JOptionPane.showConfirmDialog(this, "Are you sure to delete ?");
                    if(n==JOptionPane.YES_OPTION)
                    {
                        nodeToDelete = (DefaultMutableTreeNode)path.getLastPathComponent();
                        tm.removeNodeFromParent(nodeToDelete);
                        JOptionPane.showMessageDialog(null, "Node are deleted from tree!");
                    }
                }
            }
        }
    }

    public void valueChanged(TreeSelectionEvent e)
    {
        try
        {
            selectedNode = (DefaultMutableTreeNode) jt.getSelectionPath().getLastPathComponent();
        }
        catch(Exception ex)
        {

        }

    }


    public static void main(String args[])
    {
        JTreeDemo obj = new JTreeDemo();
    }


}
