/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Code.ConnectionDB;
import Code.Subject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rajitha Shavinda
 */
public class SubjectsDetails extends javax.swing.JFrame {

    /**
     * Creates new form Subjects
     */
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm a"); //date time object
    Date date = new Date();

    public SubjectsDetails() {
        initComponents();
        setLocationRelativeTo(null);

    }

    public void init(Subject sub) {
        //fill the text boxes using "Subject" object
        txtId.setText(sub.getID());
        txtname.setText(sub.getName());
        txtkey.setText(sub.getKey());
        txtdes.setText(sub.getDes());
        LoadTbl(sub.getID()); // load table
    }

    private void LoadTbl(String id) {
        try {
            Subjects s = new Subjects();

             //get current table model and clear all 
            DefaultTableModel dm1 = (DefaultTableModel) jTable1.getModel();
            dm1.getDataVector().removeAllElements();
            dm1.fireTableDataChanged();

             // call "ConnectionDB" class "Connect()" method to initialize Connection object
            java.sql.Connection con = ConnectionDB.Connect();

            //query: get notification details by Subject ID
            String sql = "SELECT * FROM `notification` where `sID`='" + id + "'";

             //java.sql.Statement>> 'Statement' object used for executing a static SQL statement and returning the results it produces.
            java.sql.Statement state = con.createStatement();

             //'ResultSet' >> A table of data representing a database result set, which is usually generated by executing a 'Statement' that queries the database.
            ResultSet rs = state.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();//get current table model || table object

            while (rs.next()) {

                //fill table rows as notification ID,date and time,Description
                model.addRow(new Object[]{rs.getString("nid"), rs.getString("dateTime"),
                     rs.getString("Des")});

                jTable1.setModel(model);
            }

            state.close(); //Statement

            rs.close(); // ResultSet

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        //---------------------------------------------------------------------
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdes = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNotification = new javax.swing.JTextArea();
        txtId = new javax.swing.JTextField();
        txtkey = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Time", "Message"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(250, 320, 340, 150);

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(490, 90, 90, 40);

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(490, 150, 90, 40);

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(130, 470, 100, 30);

        txtdes.setColumns(20);
        txtdes.setRows(5);
        jScrollPane2.setViewportView(txtdes);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(140, 200, 320, 96);

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(20, 470, 100, 30);

        jLabel1.setText("Description ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 200, 120, 30);

        jLabel2.setText("Subject Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 110, 120, 30);

        jLabel3.setText("Subject ID");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 70, 120, 30);

        jLabel4.setText("Enrolment key ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 150, 120, 30);

        txtNotification.setColumns(20);
        txtNotification.setRows(5);
        jScrollPane3.setViewportView(txtNotification);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(20, 320, 210, 96);

        txtId.setEditable(false);
        jPanel1.add(txtId);
        txtId.setBounds(140, 70, 320, 30);
        jPanel1.add(txtkey);
        txtkey.setBounds(140, 150, 320, 30);
        jPanel1.add(txtname);
        txtname.setBounds(140, 110, 320, 30);

        jButton5.setText("Send notification ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(20, 430, 210, 30);

        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(470, 473, 120, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Subject Information");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(160, 0, 320, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row = -1;

        String id;

        row = jTable1.getSelectedRow();//get select row number

        if (row == -1) {

            JOptionPane.showMessageDialog(null, "Please select an item");

        } else {

            try {
                id = jTable1.getValueAt(row, 0).toString();//get selected item's id
                
                java.sql.Connection con = ConnectionDB.Connect();
                
                //query: update notification table row values
                String str = "UPDATE `notification` SET `dateTime`='" + dateFormat.format(date) + "',"
                        + "`Des`='" + txtname.getText() + " || " + txtNotification.getText() + "' Where `nid`='" + id + "';";

                Statement statement = con.createStatement();

                statement.executeUpdate(str);//update

                statement.close();

                JOptionPane.showMessageDialog(null, "Successfull");

                LoadTbl(txtId.getText());//Re-load table

            } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se.getMessage());
                //return null;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                //return null;
            }

        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {

            java.sql.Connection con = ConnectionDB.Connect();
            
            //insert new Message to notification table
            String str = "INSERT INTO `notification` (sID, dateTime,Des) values('" + txtId.getText() + "','" + dateFormat.format(date) + "','"
                    + txtname.getText() + "  || " + txtNotification.getText() + "');";

            Statement statement = con.createStatement();

            statement.executeUpdate(str);//Insert

            statement.close();

            JOptionPane.showMessageDialog(null, "Successfull");

            LoadTbl(txtId.getText());

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
            //return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //return null;
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            java.sql.Connection con = ConnectionDB.Connect();
            
            //Update Subject details
            String str = "UPDATE `subjects` SET `SName`='" + txtname.getText() + "',`Key`='" + txtkey.getText() + "',"
                    + "`Des`='" + txtdes.getText() + "' Where `sID`='" + txtId.getText() + "';";

            Statement statement = con.createStatement();

            statement.executeUpdate(str);

            statement.close();

            JOptionPane.showMessageDialog(null, "Successfull");

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
            //return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //return null;
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new Subjects().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            
        //get confirmation message's answer to the "dialogButton1" variable (yes || no)
               int dialogButton1 = JOptionPane.showConfirmDialog(null, "Are you sure you want to permanently delete this Subject?", "Delete", JOptionPane.YES_NO_OPTION);

                if (dialogButton1 == 0) {//if user click yes,

                    
            
            java.sql.Connection con = ConnectionDB.Connect();
            
            //query: delete subject from Subjects tble
            String str = "delete from `subjects` Where `sID`='" + txtId.getText() + "';";

            Statement statement = con.createStatement();

            statement.executeUpdate(str);//delete

            statement.close();

            JOptionPane.showMessageDialog(null, "Successfull");

            new Subjects().setVisible(true);
            this.dispose();
                }

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
            //return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //return null;
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int row = -1;

        row = jTable1.getSelectedRow(); //get select row number

        String id = " ";

        if (row == -1) {

            JOptionPane.showMessageDialog(null, "Please select an item");

        } else {

            try {
                java.sql.Connection con = ConnectionDB.Connect();
                id = jTable1.getValueAt(row, 0).toString();//get selected item's id

                //delete selected item from notification table
                String str = "delete from `notification` Where `nid`='" + id + "';";

                Statement statement = con.createStatement();

                statement.executeUpdate(str);

                LoadTbl(txtId.getText()); // Re-load table

                statement.close();

                JOptionPane.showMessageDialog(null, "Successfull");

            } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, se.getMessage());
                //return null;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                //return null;
            }

        }

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(SubjectsDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubjectsDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubjectsDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubjectsDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubjectsDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtNotification;
    private javax.swing.JTextArea txtdes;
    private javax.swing.JTextField txtkey;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
