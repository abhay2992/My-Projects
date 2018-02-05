
import javax.swing.UIManager;


public class ChangeLookAndFeel extends javax.swing.JFrame
{
    public ChangeLookAndFeel()
    {
        initComponents();
        setSize(500,500);
        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setText("ALL LOOK AND FEELS IN JAVA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 20, 250, 30);

        jButton1.setText("Button 1");
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 70, 100, 30);

        jButton2.setText("Button 2");
        getContentPane().add(jButton2);
        jButton2.setBounds(150, 70, 120, 30);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Motif Look and Feel");
        jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(40, 170, 200, 23);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(40, 120, 230, 30);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Windows Look and Feel");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(40, 210, 190, 23);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Metal Look and Feel");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton3);
        jRadioButton3.setBounds(40, 260, 190, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Jellyfish.jpg")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 440, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            repaint();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jRadioButton1ItemStateChanged

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
       try
       {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            repaint();
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
       try
       {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            repaint();
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeLookAndFeel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
