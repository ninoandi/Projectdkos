package project.d.kost;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static project.d.kost.Config.getConnection;
import java.sql.*;
import project.d.kost.User;

public class Login extends javax.swing.JFrame {

    public Login() {
    try {
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbkost", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        setUndecorated(true);
        initComponents();

        setLocationRelativeTo(null);

    }
public void cek() {
    try {
        String username = txt_username.getText();
        String password = txt_password.getText();

        String sql = "SELECT * FROM akun WHERE username = ? AND password = ?";
        try (java.sql.Connection conn = Config.getConnection();
             java.sql.PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet res = preparedStatement.executeQuery()) {
                if (res.next()) {
                    String role = res.getString("Role");

                    if ("admin".equals(role)) {
                        MenuAdmin form = new MenuAdmin();
                        form.setVisible(true);
                        this.dispose();
                        JOptionPane.showMessageDialog(null, "Login berhasil sebagai Admin.");
                    } else if ("pemilik".equals(role)) {
                        MenuPemilik form = new MenuPemilik();
                        form.setVisible(true);
                        this.dispose();
                        JOptionPane.showMessageDialog(null, "Login berhasil sebagai Pemilik.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Maaf password atau username anda salah");
                    txt_username.setText("");
                    txt_password.setText("");
                    txt_username.requestFocus();
                }
            }
            
                    
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error executing SQL: " + e.getMessage());
        e.printStackTrace();
    }
}


        // Get the dimensions of the screen
        
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Jbuttonmasuk = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(11, 143, 130));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 30, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Login");
        jLabel1.setIconTextGap(10);
        jLabel1.setMaximumSize(new java.awt.Dimension(60, 16));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 111, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/btn close.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, -1, 24));

        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 223, 186, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Password");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 263, 85, 24));

        Jbuttonmasuk.setBackground(new java.awt.Color(0, 153, 153));
        Jbuttonmasuk.setFont(new java.awt.Font("Futura Bk BT", 1, 18)); // NOI18N
        Jbuttonmasuk.setForeground(new java.awt.Color(255, 255, 255));
        Jbuttonmasuk.setText("Masuk");
        Jbuttonmasuk.setBorder(null);
        Jbuttonmasuk.setInheritsPopupMenu(true);
        Jbuttonmasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JbuttonmasukMouseClicked(evt);
            }
        });
        Jbuttonmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbuttonmasukActionPerformed(evt);
            }
        });
        jPanel3.add(Jbuttonmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 335, 222, 37));
        jPanel3.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 289, 186, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Login.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 570, 500));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg dkost ats2.jpg"))); // NOI18N
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 76));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg_dkostbwh-kiri.png"))); // NOI18N
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 419, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Username");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 193, -1, 24));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JbuttonmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbuttonmasukActionPerformed
    cek();
    }//GEN-LAST:event_JbuttonmasukActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
try {
    String rfid = txt_username.getText();
    txt_username.setText("");
    String sql = "SELECT * FROM akun WHERE rfid_code=?";
    PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
    preparedStatement.setString(1, rfid);
   
    ResultSet result = preparedStatement.executeQuery();
    if (result.next()) {
        int id = result.getInt("id");
        String nama = result.getString("username");
        String role = result.getString("role");
       
        User.setId(id);
        User.setNama(nama);
       
        JOptionPane optionPane = new JOptionPane("Selamat Datang " + nama, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog(this, "Notification");
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
        if (role.equals("admin")) {
            MenuAdmin form = new MenuAdmin();
            this.hide();
            form.show();
        } else {
            MenuPemilik form = new MenuPemilik();
            this.hide();
            form.show();
        }
    } else {
         JOptionPane.showMessageDialog(this, "RFID Tidak Ditemukan");
    }
} catch(Exception e) {
    JOptionPane.showMessageDialog(this, e.toString());
}
     
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void JbuttonmasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbuttonmasukMouseClicked

    }//GEN-LAST:event_JbuttonmasukMouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jLabel2);
int confirm = JOptionPane.showConfirmDialog(frame, "Apakah anda ingin keluar?", "Confirm", JOptionPane.YES_NO_OPTION);
if (confirm == JOptionPane.YES_OPTION) {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.dispose();
}
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
SwingUtilities.invokeLater(() -> new Login());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
        // Run the GUI code on the Event Dispatch Thread (EDT)
        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbuttonmasuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
