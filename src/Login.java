
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());

     Conexion cnx = new Conexion();
    
        String puesto = "SELECT puesto FROM empleados WHERE codigo = '%s' AND nip = '%s'";
        int intentos=0;
        
    public Login() {
        initComponents();
        setTitle("L O G I N");
        setLocationRelativeTo(null);
        
        if (cnx.conectar("localhost", "fondatel", "root", "") == 0) {
            JOptionPane.showMessageDialog(this, "Sin conexión. La ventana se cerrará...");
            System.exit(0);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TUsuario = new javax.swing.JTextField();
        TPassword = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("INICIAR SESION");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 0, 232, 58));

        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, 20));

        jLabel3.setText("NIP:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, 20));

        TUsuario.addActionListener(this::TUsuarioActionPerformed);
        getContentPane().add(TUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 210, -1));
        getContentPane().add(TPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 210, -1));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 120, 30));

        jButton2.setText("Cancelar");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 120, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String usr = TUsuario.getText();
        String nip = TPassword.getText();
        String sql = String.format(puesto, usr, nip);
        String tipo =cnx.obtenerDato(sql);
        
        switch(tipo){
            case "Gerente":
                FAGerente ge = new FAGerente();
                cnx.desconectar();
                this.dispose();
                ge.setVisible(true);
                break;
            case "Cocinero":
                FACocinero co = new FACocinero();
                cnx.desconectar();
                this.dispose();
                co.setVisible(true);
                break;
            case "Mesero":
                FAMesero me = new FAMesero();
                cnx.desconectar();
                this.dispose();
                me.setVisible(true);
                break;
            case "cajero":
                FACajero ca = new FACajero();
                cnx.desconectar();
                this.dispose();
                ca.setVisible(true);
                break;
                case"":
                JOptionPane.showMessageDialog(this, "Credenciales Incorrectas");
                intentos++;
                if (intentos >=3) {
                    JOptionPane.showMessageDialog(this, "Numeros de intentos excedidos");
                    System.exit(0);
                }
                break;
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TPassword;
    private javax.swing.JTextField TUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
