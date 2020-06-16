/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vultureservices;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Matty
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(800, 600);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbUsername = new javax.swing.JLabel();
        jlbPassword = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jlbTitle = new javax.swing.JLabel();
        jbtLogin = new javax.swing.JButton();
        jpsPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbUsername.setText("Username:");

        jlbPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbPassword.setText("Password:");

        jtfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsernameActionPerformed(evt);
            }
        });

        jlbTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlbTitle.setText("Login System");

        jbtLogin.setText("Login");
        jbtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLoginActionPerformed(evt);
            }
        });

        jpsPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpsPasswordActionPerformed(evt);
            }
        });

        jLabel1.setText("Username and Password are case sensitive");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtLogin)
                    .addComponent(jlbTitle)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jlbUsername, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlbPassword, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jpsPassword, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel1))
                .addContainerGap(531, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTitle)
                .addGap(18, 18, 18)
                .addComponent(jlbUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpsPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(365, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsernameActionPerformed

    }//GEN-LAST:event_jtfUsernameActionPerformed

    private void jbtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLoginActionPerformed

        ResultSet rs;
        String user = jtfUsername.getText();
        String pass = String.valueOf(jpsPassword.getPassword());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {
                String query = "SELECT * FROM employees WHERE BINARY emp_name=? AND BINARY password=?";
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, user);
                ps.setString(2, pass);
                rs = ps.executeQuery();

                if (rs.next()) {
                    String role = rs.getString("emp_role");
                    dispose();

                    if (role.equals("Technician")) {
                        TechnicianHome tf = new TechnicianHome();
                        tf.setVisible(true);
                        tf.setSize(800, 600);
                        tf.setLocationRelativeTo(null);
                        tf.jlbUser.setText(user);
                    }

                    if (role.equals("Customer Services")) {
                        CSHome cf = new CSHome();
                        cf.setVisible(true);
                        cf.setSize(800, 600);
                        cf.setLocationRelativeTo(null);
                        cf.jlbUser.setText(user);
                    }
                    if (role.equals("IT Services"))   {
                        ManagerHome mf = new ManagerHome();
                        mf.setVisible(true);
                        mf.setSize(800, 600);
                        mf.setLocationRelativeTo(null);
                        mf.jlbUser.setText(user);
                    }
                    if (role.equals("Finance")) {
                        FinanceHome ff = new FinanceHome();
                        ff.setVisible(true);
                        ff.setSize(800, 600);
                        ff.setLocationRelativeTo(null);
                        ff.jlbUser.setText(user);
                    }

                    if (role.equals("Human Resources")) {
                        CSHome hf = new CSHome();
                        hf.setVisible(true);
                        hf.setSize(800, 600);
                        hf.setLocationRelativeTo(null);
                        hf.jlbUser.setText(user);
                    }
                    if (role.equals("Manager")) {
                        ManagerHome hf = new ManagerHome();
                        hf.setVisible(true);
                        hf.setSize(800, 600);
                        hf.setLocationRelativeTo(null);
                        hf.jlbUser.setText(user);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Username or Password Incorrect. Please try again.");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtLoginActionPerformed

    private void jpsPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpsPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpsPasswordActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton jbtLogin;
    private javax.swing.JLabel jlbPassword;
    private javax.swing.JLabel jlbTitle;
    private javax.swing.JLabel jlbUsername;
    private javax.swing.JPasswordField jpsPassword;
    private javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
