/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vultureservices;

/**
 *
 * @author Matty
 */
public class HRHome extends javax.swing.JFrame {

    /**
     * Creates new form HRHome
     */
    public HRHome() {
        initComponents();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbTitle = new javax.swing.JLabel();
        jbtStatistics = new javax.swing.JButton();
        jbtDelay = new javax.swing.JButton();
        jlbJobs = new javax.swing.JLabel();
        jlbData = new javax.swing.JLabel();
        jlbWelcome = new javax.swing.JLabel();
        jbtViewJob = new javax.swing.JButton();
        jbtSignout = new javax.swing.JButton();
        jlbUser = new javax.swing.JLabel();
        jbtChangePass = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbTitle.setText("Menu");

        jbtStatistics.setText("Statistics");
        jbtStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtStatisticsActionPerformed(evt);
            }
        });

        jbtDelay.setText("Job Delay");
        jbtDelay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDelayActionPerformed(evt);
            }
        });

        jlbJobs.setText("Jobs");

        jlbData.setText("Data/Information");

        jlbWelcome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbWelcome.setText("Welcome");

        jbtViewJob.setText("Edit Job");
        jbtViewJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtViewJobActionPerformed(evt);
            }
        });

        jbtSignout.setText("Signout");
        jbtSignout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSignoutActionPerformed(evt);
            }
        });

        jlbUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbUser.setText("jLabel1");
        jlbUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jbtChangePass.setText("Change Password");
        jbtChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtChangePassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbWelcome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbUser)
                                .addGap(273, 273, 273)
                                .addComponent(jlbTitle))
                            .addComponent(jbtSignout))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                        .addComponent(jbtChangePass))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtViewJob, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlbJobs)
                            .addComponent(jbtStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbData))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbTitle)
                            .addComponent(jlbWelcome)
                            .addComponent(jlbUser))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtSignout))
                    .addComponent(jbtChangePass))
                .addGap(18, 18, 18)
                .addComponent(jlbJobs)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtViewJob, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtStatisticsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtStatisticsActionPerformed

    private void jbtDelayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDelayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDelayActionPerformed

    private void jbtViewJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewJobActionPerformed

        dispose();
        EditJob ej = new EditJob();
        ej.setVisible(true);
        ej.pack();
        ej.setLocationRelativeTo(null);
        String user = jlbUser.getText();
        ej.jlbUser.setText(user);
        
    }//GEN-LAST:event_jbtViewJobActionPerformed

    private void jbtSignoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSignoutActionPerformed
        dispose();
        Login lf = new Login();
        lf.setVisible(true);
        lf.pack();
        lf.setSize(800, 600);
        lf.setLocationRelativeTo(null);
    }//GEN-LAST:event_jbtSignoutActionPerformed

    private void jbtChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtChangePassActionPerformed
        dispose();
        ChangePassword cp = new ChangePassword();
        cp.setVisible(true);
        cp.pack();
        cp.setLocationRelativeTo(null);
        cp.setSize(800, 600);
        String user = jlbUser.getText();
        cp.jlbUser.setText(user);
    }//GEN-LAST:event_jbtChangePassActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HRHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HRHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HRHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HRHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HRHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtChangePass;
    private javax.swing.JButton jbtDelay;
    private javax.swing.JButton jbtSignout;
    private javax.swing.JButton jbtStatistics;
    private javax.swing.JButton jbtViewJob;
    private javax.swing.JLabel jlbData;
    private javax.swing.JLabel jlbJobs;
    private javax.swing.JLabel jlbTitle;
    public javax.swing.JLabel jlbUser;
    public javax.swing.JLabel jlbWelcome;
    // End of variables declaration//GEN-END:variables
}
