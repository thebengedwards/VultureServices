package vultureservices;

import java.awt.Component;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Matty
 */
public class JobDelay extends javax.swing.JFrame {

    /**
     * Creates new form JobDelay
     */
    public JobDelay() {
        initComponents();
        updateTaskTable();
        updateTaskSuspendTable();
        updateJobTable();
        updateJobSuspendTable();
    }

    private void updateJobTable() {
        DefaultTableModel model = (DefaultTableModel) jtbJob.getModel();
        model.setRowCount(0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {
                String query = "SELECT * FROM job";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String jobID = rs.getString("job_id");
                    String jobName = rs.getString("job_number");
                    String dateCollected = rs.getString("date_collected");
                    String returnDate = rs.getString("return_date");
                    String checkedBy = rs.getString("checked_by");
                    String inspectedBy = rs.getString("inspected_by");
                    String labourTime = rs.getString("labour_time");
                    String motorID = rs.getString("motor_id");
                    model.addRow(new Object[]{jobID, jobName, dateCollected, returnDate, checkedBy, inspectedBy, labourTime, motorID});
                    jtbJob.setModel(model);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateJobSuspendTable() {
        DefaultTableModel model = (DefaultTableModel) jtbJobSuspend.getModel();
        model.setRowCount(0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {
                String query = "SELECT * FROM suspended WHERE job_id IS NOT NULL AND task_id IS NULL";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String jobID = rs.getString("job_id");
                    String jobName = rs.getString("job_number");
                    String dateCollected = rs.getString("date_collected");
                    String returnDate = rs.getString("return_date");
                    String checkedBy = rs.getString("checked_by");
                    String inspectedBy = rs.getString("inspected_by");
                    String labourTime = rs.getString("labour_time");
                    String motorID = rs.getString("motor_id");
                    model.addRow(new Object[]{jobID, jobName, dateCollected, returnDate, checkedBy, inspectedBy, labourTime,  motorID});
                    jtbJobSuspend.setModel(model);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTaskTable() {
        DefaultTableModel model = (DefaultTableModel) jtbTask.getModel();
        model.setRowCount(0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {
                String query = "SELECT * FROM task WHERE emp_id IS NOT NULL AND task_id IS NOT NULL";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String taskID = rs.getString("task_id");
                    String taskName = rs.getString("task");
                    String jobID = rs.getString("job_id");
                    String notes = rs.getString("notes");
                    String dateAssigned = rs.getString("date_assigned");
                    String empID = rs.getString("emp_id");
                    model.addRow(new Object[]{taskID, taskName, notes, dateAssigned, empID, jobID,});
                    jtbTask.setModel(model);
                }
            } catch (SQLException ex) {

                Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTaskSuspendTable() {
        DefaultTableModel model = (DefaultTableModel) jtbTaskSuspend.getModel();
        model.setRowCount(0);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {
                String query = "SELECT * FROM suspended WHERE task_id IS NOT NULL";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String taskID = rs.getString("task_id");
                    String taskName = rs.getString("task");
                    String notes = rs.getString("notes");
                    String dateAssigned = rs.getString("date_assigned");
                    String empID = rs.getString("emp_id");
                    String jobID = rs.getString("job_id");
                    model.addRow(new Object[]{taskID, taskName, notes, dateAssigned, empID, jobID});
                    jtbTaskSuspend.setModel(model);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jtbTaskSuspend = new javax.swing.JTable();
        jlbWelcome = new javax.swing.JLabel();
        jlbUser = new javax.swing.JLabel();
        jbtSignout = new javax.swing.JButton();
        jbtMenu1 = new javax.swing.JButton();
        jbtSuspendJob = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbJobSuspend = new javax.swing.JTable();
        jbtSuspendTask = new javax.swing.JButton();
        jbtResumeJob = new javax.swing.JButton();
        jbtResumeTask = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtbJob = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtbTask = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlbTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbTaskSuspend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Task ID", "Task Name", "Notes", "Date Assigned", "Emp ID", "Job ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbTaskSuspend.setRequestFocusEnabled(false);
        jtbTaskSuspend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTaskSuspendMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbTaskSuspend);
        if (jtbTaskSuspend.getColumnModel().getColumnCount() > 0) {
            jtbTaskSuspend.getColumnModel().getColumn(0).setMinWidth(80);
            jtbTaskSuspend.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtbTaskSuspend.getColumnModel().getColumn(0).setMaxWidth(80);
            jtbTaskSuspend.getColumnModel().getColumn(4).setMinWidth(80);
            jtbTaskSuspend.getColumnModel().getColumn(4).setPreferredWidth(80);
            jtbTaskSuspend.getColumnModel().getColumn(4).setMaxWidth(80);
            jtbTaskSuspend.getColumnModel().getColumn(5).setMinWidth(80);
            jtbTaskSuspend.getColumnModel().getColumn(5).setPreferredWidth(80);
            jtbTaskSuspend.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 530, 860, 300));

        jlbWelcome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbWelcome.setText("Welcome");
        getContentPane().add(jlbWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jlbUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbUser.setText("jLabel1");
        jlbUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jlbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 6, -1, -1));

        jbtSignout.setText("Signout");
        jbtSignout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSignoutActionPerformed(evt);
            }
        });
        getContentPane().add(jbtSignout, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 37, -1, -1));

        jbtMenu1.setText("Menu");
        jbtMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMenu1ActionPerformed(evt);
            }
        });
        getContentPane().add(jbtMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1690, 20, -1, -1));

        jbtSuspendJob.setText("Suspend Job");
        jbtSuspendJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSuspendJobActionPerformed(evt);
            }
        });
        getContentPane().add(jbtSuspendJob, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jtbJobSuspend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job ID", "Job Number", "Date Collected", "Return Date", "Checked By", "Inspected By", "Labour Time", "Motor ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbJobSuspend.setRequestFocusEnabled(false);
        jtbJobSuspend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbJobSuspendMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtbJobSuspend);
        if (jtbJobSuspend.getColumnModel().getColumnCount() > 0) {
            jtbJobSuspend.getColumnModel().getColumn(0).setMinWidth(80);
            jtbJobSuspend.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtbJobSuspend.getColumnModel().getColumn(0).setMaxWidth(80);
            jtbJobSuspend.getColumnModel().getColumn(7).setMinWidth(80);
            jtbJobSuspend.getColumnModel().getColumn(7).setPreferredWidth(80);
            jtbJobSuspend.getColumnModel().getColumn(7).setMaxWidth(80);
        }

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 130, 860, 300));

        jbtSuspendTask.setText("Suspend Task");
        jbtSuspendTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSuspendTaskActionPerformed(evt);
            }
        });
        getContentPane().add(jbtSuspendTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 840, -1, -1));

        jbtResumeJob.setText("Resume Job");
        jbtResumeJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtResumeJobActionPerformed(evt);
            }
        });
        getContentPane().add(jbtResumeJob, new org.netbeans.lib.awtextra.AbsoluteConstraints(1660, 440, -1, -1));

        jbtResumeTask.setText("Resume Task");
        jbtResumeTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtResumeTaskActionPerformed(evt);
            }
        });
        getContentPane().add(jbtResumeTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(1650, 840, -1, -1));

        jtbJob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job ID", "Job Number", "Date Collected", "Return Date", "Checked By", "Inspected By", "Labour Time", "Motor ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbJob.setRequestFocusEnabled(false);
        jtbJob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbJobMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtbJob);
        if (jtbJob.getColumnModel().getColumnCount() > 0) {
            jtbJob.getColumnModel().getColumn(0).setMinWidth(80);
            jtbJob.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtbJob.getColumnModel().getColumn(0).setMaxWidth(80);
            jtbJob.getColumnModel().getColumn(5).setResizable(false);
            jtbJob.getColumnModel().getColumn(7).setMinWidth(80);
            jtbJob.getColumnModel().getColumn(7).setPreferredWidth(80);
            jtbJob.getColumnModel().getColumn(7).setMaxWidth(80);
        }

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 860, 300));

        jtbTask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Task ID", "Task Name", "Notes", "Date Assigned", "Emp ID", "Job ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbTask.setRequestFocusEnabled(false);
        jtbTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTaskMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtbTask);
        if (jtbTask.getColumnModel().getColumnCount() > 0) {
            jtbTask.getColumnModel().getColumn(0).setMinWidth(80);
            jtbTask.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtbTask.getColumnModel().getColumn(0).setMaxWidth(80);
            jtbTask.getColumnModel().getColumn(4).setMinWidth(80);
            jtbTask.getColumnModel().getColumn(4).setPreferredWidth(80);
            jtbTask.getColumnModel().getColumn(4).setMaxWidth(80);
            jtbTask.getColumnModel().getColumn(5).setMinWidth(80);
            jtbTask.getColumnModel().getColumn(5).setPreferredWidth(80);
            jtbTask.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 860, 300));

        jLabel1.setText("SUSPEND JOB: To suspend a job select a row of the table below  and select \"Suspend Job\"");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel2.setText("RESUME JOB: To resume a job select a row of the TABLE below and select \"Resume Job\"");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, -1, -1));

        jLabel3.setText("RESUME TASK: To resume a task select a row of the table below and select \"Resume Task\"");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 510, -1, -1));

        jLabel4.setText("SUSPEND TASK: To suspend a task select a row of the table below and select \"Suspend Task\"");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        jlbTitle.setText("Suspend or Resume Jobs and Tasks");
        getContentPane().add(jlbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtSignoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSignoutActionPerformed
        dispose();
        Login lf = new Login();
        lf.setVisible(true);
        lf.pack();
        lf.setSize(800, 600);
        lf.setLocationRelativeTo(null);
    }//GEN-LAST:event_jbtSignoutActionPerformed

    private void jbtMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMenu1ActionPerformed

        String user = jlbUser.getText();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {
                String query = "SELECT * FROM employees WHERE emp_name =?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, user);
                ResultSet rs = ps.executeQuery();

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
                    if (role.equals("Manager") || role.equals("IT Services")) {
                        ManagerHome mf = new ManagerHome();
                        mf.setVisible(true);
                        mf.setSize(800, 600);
                        mf.setLocationRelativeTo(null);
                        mf.jlbUser.setText(user);
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtMenu1ActionPerformed

    private void jtbTaskSuspendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTaskSuspendMouseClicked

    }//GEN-LAST:event_jtbTaskSuspendMouseClicked

    private void jtbJobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbJobMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbJobMouseClicked

    private void jtbTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTaskMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbTaskMouseClicked

    private void jbtSuspendJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSuspendJobActionPerformed
        int row = jtbJob.getSelectedRow();
        String cell = jtbJob.getModel().getValueAt(row, 0).toString();
        String cell2 = jtbJob.getModel().getValueAt(row, 1).toString();
        String cell3 = jtbJob.getModel().getValueAt(row, 2).toString();
        String cell4 = jtbJob.getModel().getValueAt(row, 3).toString();
        String cell5 = jtbJob.getModel().getValueAt(row, 4).toString();
        String cell6 = jtbJob.getModel().getValueAt(row, 5).toString();
        String cell7 = jtbJob.getModel().getValueAt(row, 6).toString();
        String cell8 = jtbJob.getModel().getValueAt(row, 7).toString();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");                      
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {
                // INSERT
                String query = "INSERT INTO suspended (job_id, job_number, date_collected, return_date, checked_by, inspected_by, labour_time, motor_id) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, cell);
                ps.setString(2, cell2);
                ps.setString(3, cell3);
                ps.setString(4, cell4);
                ps.setString(5, cell5);
                ps.setString(6, cell6);
                ps.setString(7, cell7);
                ps.setString(8, cell8);
                ps.execute();

                // DELETE
                String query2 = "DELETE FROM job WHERE job_id = " + cell;
                PreparedStatement ps2 = con.prepareStatement(query2);
                ps2.execute();
                JOptionPane.showMessageDialog(null, "Job Suspended");
                updateJobTable();
                updateJobSuspendTable();

            } catch (SQLException ex) {
                Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error suspending job");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtSuspendJobActionPerformed

    private void jbtResumeJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtResumeJobActionPerformed
        int row = jtbJobSuspend.getSelectedRow();
        String cell = jtbJobSuspend.getModel().getValueAt(row, 0).toString();
        String cell2 = jtbJobSuspend.getModel().getValueAt(row, 1).toString();
        String cell3 = jtbJobSuspend.getModel().getValueAt(row, 2).toString();
        String cell4 = jtbJobSuspend.getModel().getValueAt(row, 3).toString();
        String cell5 = jtbJobSuspend.getModel().getValueAt(row, 4).toString();
        String cell6 = jtbJobSuspend.getModel().getValueAt(row, 5).toString();
        String cell7 = jtbJobSuspend.getModel().getValueAt(row, 6).toString();
        String cell8 = jtbJobSuspend.getModel().getValueAt(row, 7).toString();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {
                // INSERT
                String query = "INSERT INTO job (job_id, job_number, date_collected, return_date, checked_by, inspected_by, labour_time,  motor_id) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, cell);
                ps.setString(2, cell2);
                ps.setString(3, cell3);
                ps.setString(4, cell4);
                ps.setString(5, cell5);
                ps.setString(6, cell6);
                ps.setString(7, cell7);
                ps.setString(8, cell8);
                ps.execute();
                // DELETE
                String query2 = "DELETE FROM suspended WHERE job_id = " + cell;
                PreparedStatement ps2 = con.prepareStatement(query2);
                ps2.execute();
                JOptionPane.showMessageDialog(null, "Job Resumed");
                updateJobTable();
                updateJobSuspendTable();

            } catch (SQLException ex) {
                Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error resuming job");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtResumeJobActionPerformed

    private void jbtSuspendTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSuspendTaskActionPerformed
        int row = jtbTask.getSelectedRow();
        String cell = jtbTask.getModel().getValueAt(row, 0).toString();
        String cell2 = jtbTask.getModel().getValueAt(row, 1).toString();
        String cell3 = jtbTask.getModel().getValueAt(row, 2).toString();
        String cell4 = jtbTask.getModel().getValueAt(row, 3).toString();
        String cell5 = jtbTask.getModel().getValueAt(row, 4).toString();
        String cell6 = jtbTask.getModel().getValueAt(row, 5).toString();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {
                // INSERT
                String query = "INSERT INTO suspended (task_id, task, notes, date_assigned, emp_id, job_id) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, cell);
                ps.setString(2, cell2);
                ps.setString(3, cell3);
                ps.setString(4, cell4);
                ps.setString(5, cell5);
                ps.setString(6, cell6);
                ps.execute();
                
                // DELETE
                String query2 = "DELETE FROM task WHERE task_id = " + cell;
                PreparedStatement ps2 = con.prepareStatement(query2);
                ps2.execute();
                JOptionPane.showMessageDialog(null, "Task Suspended");
                updateTaskTable();
                updateTaskSuspendTable();

            } catch (SQLException ex) {
                Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error suspending task");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtSuspendTaskActionPerformed

    private void jbtResumeTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtResumeTaskActionPerformed
        int row = jtbTaskSuspend.getSelectedRow();
        String cell = jtbTaskSuspend.getModel().getValueAt(row, 0).toString();
        String cell2 = jtbTaskSuspend.getModel().getValueAt(row, 1).toString();
        String cell3 = jtbTaskSuspend.getModel().getValueAt(row, 2).toString();
        String cell4 = jtbTaskSuspend.getModel().getValueAt(row, 3).toString();
        String cell5 = jtbTaskSuspend.getModel().getValueAt(row, 4).toString();
        String cell6 = jtbTaskSuspend.getModel().getValueAt(row, 5).toString();
        String LabourTime = "3";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vulture", "root", "24652066")) {
                // INSERT
                String query = "INSERT INTO task (task_id, task, notes, time_needed, date_assigned, emp_id, job_id) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, cell);
                ps.setString(2, cell2);
                ps.setString(3, cell3);
                ps.setString(4, LabourTime);
                ps.setString(5, cell4);
                ps.setString(6, cell5);
                ps.setString(7, cell6);
                ps.execute();
                
                // DELETE
                String query2 = "DELETE FROM suspended WHERE task_id = " + cell;
                PreparedStatement ps2 = con.prepareStatement(query2);
                ps2.execute();
                DefaultTableModel model = (DefaultTableModel)jtbTaskSuspend.getModel();
                model.removeRow(row);
                updateTaskTable();

            } catch (SQLException ex) {
                Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error resuming task");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtResumeTaskActionPerformed

    private void jtbJobSuspendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbJobSuspendMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbJobSuspendMouseClicked

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
            java.util.logging.Logger.getLogger(JobDelay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JobDelay.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JobDelay.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JobDelay.class.getName()).log(Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JobDelay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton jbtMenu1;
    private javax.swing.JButton jbtResumeJob;
    private javax.swing.JButton jbtResumeTask;
    private javax.swing.JButton jbtSignout;
    private javax.swing.JButton jbtSuspendJob;
    private javax.swing.JButton jbtSuspendTask;
    private javax.swing.JLabel jlbTitle;
    public javax.swing.JLabel jlbUser;
    public javax.swing.JLabel jlbWelcome;
    private javax.swing.JTable jtbJob;
    private javax.swing.JTable jtbJobSuspend;
    private javax.swing.JTable jtbTask;
    private javax.swing.JTable jtbTaskSuspend;
    // End of variables declaration//GEN-END:variables
}
