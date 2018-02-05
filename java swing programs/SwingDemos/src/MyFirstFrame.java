
import java.awt.Color;


public class MyFirstFrame extends javax.swing.JFrame
{

   
    public MyFirstFrame()
    {
        initComponents();
        setSize(500,500);
        setVisible(true);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lb1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        lb1.setText("Enter name");
        getContentPane().add(lb1);
        lb1.setBounds(50, 70, 140, 20);

        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(tf1);
        tf1.setBounds(250, 70, 180, 20);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 100, 60, 60);

        jButton1.setText("Click");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(250, 190, 130, 23);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("RED");
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(200, 240, 190, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("GREEN");
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(200, 270, 170, 23);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "abc", "mno", "pqr", "stu", "lmn" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(30, 150, 140, 20);

        jToggleButton1.setText("one");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(20, 230, 130, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       tf1.setText("HELLO WORLD");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
      int i=jComboBox1.getSelectedIndex();
        System.out.println(i);
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        System.out.println(jToggleButton1.isSelected());
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed

    }//GEN-LAST:event_tf1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setBackground(Color.red);
    }//GEN-LAST:event_jButton1MouseEntered

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        MyFirstFrame obj = new MyFirstFrame();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lb1;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables

}
