/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Code.Student;
import Code.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Rajitha Shavinda
 */
public class StudentProfile extends javax.swing.JFrame {

    /**
     * Creates new form StudentProfile
     */
    String id;
    Student student;

    public void getStudent(String id1) {
        id = id1;

        try {
            java.sql.Connection con = ConnectionDB.Connect();// call "ConnectionDB" class "Connect()" method to initialize Connection object

            //query: get user details by user id
            String sql = "SELECT * FROM `student` WHERE `ID`='" + id1 + "';";
            
            
             //java.sql.Statement>> 'Statement' object used for executing a static SQL statement and returning the results it produces.
            java.sql.Statement state = con.createStatement();

            //'ResultSet' >> A table of data representing a database result set, which is usually generated by executing a 'Statement' that queries the database.
            ResultSet rs = state.executeQuery(sql);
            rs.next(); //it shifts the cursor to the next row of the result set || in this case >> first Row 

            
            //creating Student object using Result set data
            student = new Student(rs.getString("ID"), rs.getString("Name"),
                    rs.getString("email"), rs.getString("contact"),
                    rs.getString("Cname"), rs.getString("bday"), rs.getString("password"),
                    rs.getString("Subjects"), rs.getString("subNames"));

            rs.close();

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
            //return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //return null;
        }

        init(student);
    }

    public StudentProfile() {
        initComponents();
        setLocationRelativeTo(null);

    }

    private void init(Student std) {
        //fill Label values from table (using Student object)
        LoadTbl(std.getId(), std.getSubjects());

        lbl_ID.setText("Student ID : " + std.getId());

        lbl_Name.setText("Student Name : " + std.getName());

        lbl_email.setText("Email : " + std.getEmail());

        lbl_CName.setText("Course Name : " + std.getCourseName());

        lbl_contact.setText("Contact NO : " + std.getContact());

        lbl_bday.setText("Birthday : " + std.getBday());

        //list Enroll Subjects
        String[] sub = std.getSubNames().split("#"); //split words|| sbjects save like >> OOP#DBMS#FIT
        String s = "";
        for (int i = 1; i < sub.length; i++) {
            if(!(sub[i].equals("")))//if array index value is not empty
            s += sub[i] + "\n";
        }
        txtSubjects.setText(s.trim());

    }

    private void LoadTbl(String id, String sub) {
        try {

            String[] subjects = sub.split(" ");

            DefaultTableModel dm1 = (DefaultTableModel) jTable.getModel();// table object
            
            //clear all from current table
            dm1.getDataVector().removeAllElements();
            dm1.fireTableDataChanged();

            // call "ConnectionDB" class "Connect()" method to initialize Connection object
            java.sql.Connection con = ConnectionDB.Connect();

            //select all notification table rows
            String sql = "SELECT * FROM `notification`";

               //java.sql.Statement>> 'Statement' object used for executing a static SQL statement and returning the results it produces.
            java.sql.Statement state = con.createStatement();

               //'ResultSet' >> A table of data representing a database result set, which is usually generated by executing a 'Statement' that queries the database.
            ResultSet rs = state.executeQuery(sql);

            
            
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();// tabel object

            while (rs.next()) {

                for (int i = 0; i < subjects.length; i++) {

                    //if current record's Subject ID equals for  "Enroll Subjects" text area's subjects
                    if (subjects[i].equals(rs.getString("sID"))) {

                        model.addRow(new Object[]{  
                            rs.getString("dateTime"), rs.getString("Des")});// add time and description to the table row

                        jTable.setModel(model);
                    }
                }
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
        jTable = new javax.swing.JTable();
        lbl_bday = new javax.swing.JLabel();
        lbl_ID = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lbl_Name = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        lbl_contact = new javax.swing.JLabel();
        lbl_CName = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSubjects = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Message"
            }
        ));
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 350, 710, 160);

        lbl_bday.setText("bday");
        jPanel1.add(lbl_bday);
        lbl_bday.setBounds(10, 260, 290, 40);

        lbl_ID.setText("ID");
        jPanel1.add(lbl_ID);
        lbl_ID.setBounds(10, 60, 290, 40);

        jButton2.setText("Enroll Subjects");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(320, 290, 190, 40);

        jButton3.setText("Update Details");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(520, 290, 190, 40);

        lbl_Name.setText("name");
        jPanel1.add(lbl_Name);
        lbl_Name.setBounds(10, 100, 380, 40);

        lbl_email.setText("emali");
        jPanel1.add(lbl_email);
        lbl_email.setBounds(10, 140, 290, 40);

        lbl_contact.setText("contact");
        jPanel1.add(lbl_contact);
        lbl_contact.setBounds(10, 180, 290, 40);

        lbl_CName.setText("course name");
        jPanel1.add(lbl_CName);
        lbl_CName.setBounds(10, 220, 290, 40);

        txtSubjects.setEditable(false);
        txtSubjects.setColumns(20);
        txtSubjects.setRows(5);
        jScrollPane2.setViewportView(txtSubjects);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(520, 90, 190, 190);

        jLabel1.setText("Enroll Subjects");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(570, 60, 110, 20);

        jButton4.setText("exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(520, 510, 190, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Profile");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(200, 10, 320, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        subjectsStudentEnroll s = new subjectsStudentEnroll();
        s.setID(id);//send user id to "subjectsStudentEnroll" interface
        s.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Register r = new Register();
        r.init(student, false);//send student object to "Register" interface
        r.setAdmin(false);// go to the interface as Student
        r.setPasswordFields(true);// enable update password option
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    //get confirmation message's answer to the "dialogButton1" variable (yes || no)
        int dialogButton1 = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?", "Exit", JOptionPane.YES_NO_OPTION);

        if (dialogButton1 == 0) {//if user click yes, interface will close

            this.dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(StudentProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel lbl_CName;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JLabel lbl_Name;
    private javax.swing.JLabel lbl_bday;
    private javax.swing.JLabel lbl_contact;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JTextArea txtSubjects;
    // End of variables declaration//GEN-END:variables
}
