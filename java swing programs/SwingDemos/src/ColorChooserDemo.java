
import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;


public class ColorChooserDemo extends javax.swing.JFrame {

   JColorChooser chooser;
    public ColorChooserDemo() 
    {
        chooser = new JColorChooser();
        initComponents();
        jLabel1.setForeground(Color.red);
        setSize(500,500);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("Select Color");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 30, 160, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("This is testing label");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 120, 390, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            Color cl=JColorChooser.showDialog(this, "My Color Chooser", Color.green);
            jLabel1.setForeground(cl);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColorChooserDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
