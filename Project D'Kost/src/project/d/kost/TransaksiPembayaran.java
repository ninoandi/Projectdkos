/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project.d.kost;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
public class TransaksiPembayaran extends javax.swing.JFrame {
    private Color ClickedColor;
    private Color DefaultColor;
private void autonumber() {
    try {
        java.sql.Connection conn = (Connection) Config.getConnection();
        Statement s = conn.createStatement();
        String sql = "SELECT * FROM transaksi ORDER BY ID DESC";
        ResultSet r = s.executeQuery(sql);
        
        // Check if there are any records in the table
        if (r.next()) {
            String id_transaksi = r.getString("ID").substring(2);
            String TR = "" + (Integer.parseInt(id_transaksi) + 1);
            String Nol = "";

            if (TR.length() == 1) {
                Nol = "000";
            } else if (TR.length() == 2) {
                Nol = "00";
            } else if (TR.length() == 3) {
                Nol = "0";
            } else if (TR.length() == 4) {
                Nol = "";
            }
            txransaksi.setText("TR" + Nol + TR);
        } else {
            // If there are no records in the table, set the text to "TR0001"
            txransaksi.setText("TR0001");
        }
        r.close();
        s.close();
    } catch (Exception e) {
        System.out.println("autonumber error: " + e.getMessage());
    }
}
    public void clear() {
        txstatus.setText("");
        txharga.setText("");
        txnama.setText("");
        txtotalbayar.setText("");
        txtanggungan.setText("");
        txsewa.setText("");       
    }
    public TransaksiPembayaran() {
        setUndecorated(true);
        initComponents();
        DefaultColor = new Color(0, 153, 153);
        ClickedColor = new Color(0, 102, 102);
        this.setLocationRelativeTo(null);
        txharga.setText("");
        txnama.setText("");
        txharga.setEnabled(false);
        txtotalbayar.setEnabled(false);
        txstatus.setEnabled(false);
        txransaksi.setEnabled(false);
        txtanggungan.setEnabled(false);
        txnama.setEnabled(false);
        txbulankeluar.setEnabled(false);
        
        autonumber();
    }
    private void loadHarga() {
        try {
            Connection con = Config.getConnection();
            String sql_tingkat = "SELECT harga FROM kamar WHERE Kdkamar = ?";

            try (PreparedStatement ps = con.prepareStatement(sql_tingkat)) {
                ps.setString(1, (String) cmkamar.getSelectedItem());

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        txharga.setText(rs.getString("harga"));
                    } else {
                        // Handle the case where no results are found
                        txharga.setText("Not Found");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void loadnama() {
        try {
            Connection con = Config.getConnection();
            String sql_tingkat = "SELECT nama FROM datapenghuni WHERE Kdkamar = ?";

            try (PreparedStatement ps = con.prepareStatement(sql_tingkat)) {
                ps.setString(1, (String) cmkamar.getSelectedItem());

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        txnama.setText(rs.getString("nama"));
                    } else {
                        // Handle the case where no results are found
                        txnama.setText("Not Found");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txransaksi = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txharga = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtotalbayar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txbayar = new javax.swing.JTextField();
        txtanggungan = new javax.swing.JTextField();
        cmkamar = new javax.swing.JComboBox<>();
        txnama = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txstatus = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txsewa = new javax.swing.JTextField();
        cmbulanmasuk = new javax.swing.JComboBox<>();
        txbulankeluar = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Jlabelll2 = new javax.swing.JLabel();
        Jlabelll1 = new javax.swing.JLabel();
        Jlabelll3 = new javax.swing.JLabel();
        pnmain = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Menu5 = new javax.swing.JPanel();
        Jlabelll = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Menu4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        Jlabel = new javax.swing.JLabel();
        Menu3 = new javax.swing.JPanel();
        menu4 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Menu2 = new javax.swing.JPanel();
        jha = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Menu1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        ja = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Pembayaran");
        jLabel11.setIconTextGap(10);
        jLabel11.setMaximumSize(new java.awt.Dimension(60, 16));
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 239, -1, -1));

        txransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txransaksiActionPerformed(evt);
            }
        });
        jPanel7.add(txransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 128, 155, -1));

        jLabel19.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel19.setText("ID Transaksi");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 133, -1, -1));

        jLabel38.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel38.setText("Kode Kamar");
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 100, -1, -1));

        txharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txhargaActionPerformed(evt);
            }
        });
        jPanel7.add(txharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 199, 155, -1));

        jLabel40.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel40.setText("Lama Sewa(Bulan)");
        jPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 99, -1, -1));

        txtotalbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtotalbayarActionPerformed(evt);
            }
        });
        jPanel7.add(txtotalbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 282, 161, -1));

        jLabel12.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel12.setText("Harga/Perbulan");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 204, -1, -1));

        jLabel41.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel41.setText("Bulan Masuk");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 133, -1, -1));

        txbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbayarActionPerformed(evt);
            }
        });
        jPanel7.add(txbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 317, 161, -1));

        txtanggungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtanggunganActionPerformed(evt);
            }
        });
        jPanel7.add(txtanggungan, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 317, 124, -1));

        cmkamar.setBackground(new java.awt.Color(0, 102, 102));
        cmkamar.setMaximumRowCount(11);
        cmkamar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9" }));
        cmkamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmkamarActionPerformed(evt);
            }
        });
        jPanel7.add(cmkamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 96, 85, -1));

        txnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnamaActionPerformed(evt);
            }
        });
        jPanel7.add(txnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 162, 155, -1));

        jLabel42.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel42.setText("Nama");
        jPanel7.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 168, -1, -1));

        jLabel43.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel43.setText("Bulan Keluar");
        jPanel7.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 167, -1, -1));

        jLabel44.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel44.setText("Total Bayar");
        jPanel7.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 287, -1, -1));

        txstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txstatusActionPerformed(evt);
            }
        });
        jPanel7.add(txstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 282, 124, -1));

        jLabel45.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel45.setText("Status");
        jPanel7.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 287, -1, -1));

        jLabel46.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel46.setText("Pembayaran");
        jPanel7.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 317, -1, -1));

        txsewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txsewaActionPerformed(evt);
            }
        });
        jPanel7.add(txsewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 94, 96, -1));

        cmbulanmasuk.setBackground(new java.awt.Color(0, 102, 102));
        cmbulanmasuk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER" }));
        cmbulanmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbulanmasukActionPerformed(evt);
            }
        });
        jPanel7.add(cmbulanmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 128, 96, -1));

        txbulankeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbulankeluarActionPerformed(evt);
            }
        });
        jPanel7.add(txbulankeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 158, 96, -1));

        jLabel47.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel47.setText("Tanggungan");
        jPanel7.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 322, -1, -1));

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg_dkostbwh-.png"))); // NOI18N
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, -1, -1));

        jLabel30.setBackground(new java.awt.Color(0, 0, 0));
        jLabel30.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg dkost ats.jpg"))); // NOI18N
        jPanel7.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 110, 76));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg dkost ats2.jpg"))); // NOI18N
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 76));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 153));
        jLabel16.setText("Tambah Data Transaksi");
        jLabel16.setIconTextGap(10);
        jLabel16.setMaximumSize(new java.awt.Dimension(60, 16));
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg_dkostbwh-kiri.png"))); // NOI18N
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, -1));

        Jlabelll2.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        Jlabelll2.setForeground(new java.awt.Color(255, 255, 255));
        Jlabelll2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/tambah 1.png"))); // NOI18N
        Jlabelll2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jlabelll2MouseClicked(evt);
            }
        });
        jPanel7.add(Jlabelll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, 28));

        Jlabelll1.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        Jlabelll1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/kembali 1.png"))); // NOI18N
        Jlabelll1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jlabelll1MouseClicked(evt);
            }
        });
        jPanel7.add(Jlabelll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 80, 28));

        Jlabelll3.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        Jlabelll3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/refresh.png"))); // NOI18N
        Jlabelll3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jlabelll3MouseClicked(evt);
            }
        });
        jPanel7.add(Jlabelll3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 80, 28));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 680, 500));

        pnmain.setBackground(new java.awt.Color(0, 153, 153));
        pnmain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnmain.setForeground(new java.awt.Color(255, 255, 255));
        pnmain.setPreferredSize(new java.awt.Dimension(150, 514));

        jLabel2.setFont(new java.awt.Font("Futura Bk BT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ganti Akun");

        jLabel14.setFont(new java.awt.Font("Futura Bk BT", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Menu Admin");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(234, 3));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/logo dkost.png"))); // NOI18N

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Ic.png"))); // NOI18N

        Menu5.setBackground(new java.awt.Color(0, 153, 153));
        Menu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Menu5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Menu5MouseExited(evt);
            }
        });

        Jlabelll.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        Jlabelll.setForeground(new java.awt.Color(255, 255, 255));
        Jlabelll.setText("Logout");
        Jlabelll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlabelllMouseClicked(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Logout.png"))); // NOI18N

        javax.swing.GroupLayout Menu5Layout = new javax.swing.GroupLayout(Menu5);
        Menu5.setLayout(Menu5Layout);
        Menu5Layout.setHorizontalGroup(
            Menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(Jlabelll)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        Menu5Layout.setVerticalGroup(
            Menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(Menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jlabelll, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap())
        );

        Menu4.setBackground(new java.awt.Color(0, 153, 153));
        Menu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Menu4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Menu4MouseExited(evt);
            }
        });

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Keluhan.png"))); // NOI18N

        Jlabel.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        Jlabel.setForeground(new java.awt.Color(255, 255, 255));
        Jlabel.setText("Keluhan Penghuni");
        Jlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Menu4Layout = new javax.swing.GroupLayout(Menu4);
        Menu4.setLayout(Menu4Layout);
        Menu4Layout.setHorizontalGroup(
            Menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(Jlabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Menu4Layout.setVerticalGroup(
            Menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu4Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(Menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Jlabel)
                    .addComponent(jLabel27))
                .addContainerGap())
        );

        Menu3.setBackground(new java.awt.Color(0, 153, 153));
        Menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Menu3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Menu3MouseExited(evt);
            }
        });

        menu4.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        menu4.setForeground(new java.awt.Color(255, 255, 255));
        menu4.setText("Data Transaksi");
        menu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu4MouseClicked(evt);
            }
        });

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Transaksi.png"))); // NOI18N

        javax.swing.GroupLayout Menu3Layout = new javax.swing.GroupLayout(Menu3);
        Menu3.setLayout(Menu3Layout);
        Menu3Layout.setHorizontalGroup(
            Menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(menu4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Menu3Layout.setVerticalGroup(
            Menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(Menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(menu4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu2.setBackground(new java.awt.Color(0, 153, 153));
        Menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Menu2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Menu2MouseExited(evt);
            }
        });

        jha.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        jha.setForeground(new java.awt.Color(255, 255, 255));
        jha.setText("Data Penghuni");
        jha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jhaMouseClicked(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Data Penghuni.png"))); // NOI18N

        javax.swing.GroupLayout Menu2Layout = new javax.swing.GroupLayout(Menu2);
        Menu2.setLayout(Menu2Layout);
        Menu2Layout.setHorizontalGroup(
            Menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Menu2Layout.setVerticalGroup(
            Menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Menu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu1.setBackground(new java.awt.Color(0, 153, 153));
        Menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Menu1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Menu1MouseExited(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Menu Utama.png"))); // NOI18N

        ja.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        ja.setForeground(new java.awt.Color(255, 255, 255));
        ja.setText("Menu Utama");
        ja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout Menu1Layout = new javax.swing.GroupLayout(Menu1);
        Menu1.setLayout(Menu1Layout);
        Menu1Layout.setHorizontalGroup(
            Menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(ja, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Menu1Layout.setVerticalGroup(
            Menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(Menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ja)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnmainLayout = new javax.swing.GroupLayout(pnmain);
        pnmain.setLayout(pnmainLayout);
        pnmainLayout.setHorizontalGroup(
            pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnmainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnmainLayout.createSequentialGroup()
                        .addGroup(pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(Menu1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Menu3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Menu2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Menu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnmainLayout.createSequentialGroup()
                                .addGap(0, 9, Short.MAX_VALUE)
                                .addGroup(pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(Menu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnmainLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel26))
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19))
                    .addGroup(pnmainLayout.createSequentialGroup()
                        .addGroup(pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnmainLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnmainLayout.setVerticalGroup(
            pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnmainLayout.createSequentialGroup()
                .addGroup(pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnmainLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel26)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnmainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Menu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Menu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Menu5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        getContentPane().add(pnmain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txransaksiActionPerformed

    }//GEN-LAST:event_txransaksiActionPerformed

    private void txhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txhargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txhargaActionPerformed

    private void txtotalbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtotalbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtotalbayarActionPerformed

    private void txbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbayarActionPerformed
        
        int total, bayar, tanggungan;
        total = Integer.valueOf(txtotalbayar.getText());
        bayar = Integer.valueOf(txbayar.getText());

        tanggungan = total - bayar;
        txtanggungan.setText(String.valueOf(tanggungan));

        if (tanggungan == 0) {
            txstatus.setText("Lunas");
        } else if (tanggungan > 0) {
            txstatus.setText("Belum Lunas");
        } else {
            txstatus.setText("Lunas");
        }
    }//GEN-LAST:event_txbayarActionPerformed

    private void txtanggunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtanggunganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtanggunganActionPerformed

    private void cmkamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmkamarActionPerformed
        loadHarga();
        loadnama();
    }//GEN-LAST:event_cmkamarActionPerformed

    private void txnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnamaActionPerformed

    private void txstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txstatusActionPerformed

    private void txsewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txsewaActionPerformed
        
        String bulanmasuk, bulankeluar;
        int sewa;
        int totalBayar, sewa2, harga;

        try {
            // Assuming txsewa is a valid reference to a text field containing the rental period
            sewa = Integer.parseInt(txsewa.getText());

            // Assuming bulanMasuk is initialized before this point
            if (cmbulanmasuk != null) {
                bulanmasuk = String.valueOf(cmbulanmasuk.getSelectedItem()); // Assuming cmbulanmasuk is a valid reference to a combo box
                int bulanMasukIndex = Arrays.asList(Month.values()).indexOf(Month.valueOf(bulanmasuk.toUpperCase()));

                // Perform more accurate month calculation
                int bulanKeluarIndex = (bulanMasukIndex + sewa) % 12;

                // Set the new month in the txbulankeluar field
                // Assuming txbulankeluar is a valid reference to a text field
                txbulankeluar.setText(Month.values()[bulanKeluarIndex].toString());
            } else {
                throw new IllegalArgumentException("Month combo box is not initialized.");
            }
        } catch (Exception t){
            // Handle NumberFormatException or IllegalArgumentException (e.g., display an error message)
            txbulankeluar.setText("Error calculating month");
        }

        try {
            sewa2 = Integer.valueOf(txsewa.getText());
            harga = Integer.valueOf(txharga.getText());

            totalBayar = harga * sewa2;
            txtotalbayar.setText(String.valueOf(totalBayar));
        } catch (NumberFormatException e) {
            // Handle NumberFormatException (e.g., display an error message)
            txtotalbayar.setText("Error calculating total payment");
        }
    }//GEN-LAST:event_txsewaActionPerformed

    private void cmbulanmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbulanmasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbulanmasukActionPerformed

    private void txbulankeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbulankeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbulankeluarActionPerformed

    private void Jlabelll1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jlabelll1MouseClicked
        this.setVisible(false);
        new DataTransaksi().setVisible(true);
    }//GEN-LAST:event_Jlabelll1MouseClicked

    private void Jlabelll2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jlabelll2MouseClicked
String Kdkamar = cmkamar.getSelectedItem().toString();
String ID = txransaksi.getText();
String Nama = txnama.getText();
String Harga = txharga.getText();
String Lama_sewa = txsewa.getText();
String Total_bayar = txtotalbayar.getText();
String Bulan_masuk = cmbulanmasuk.getSelectedItem().toString();
String Bulan_keluar = txbulankeluar.getText();
String Tanggungan = txtanggungan.getText();
String Status = txstatus.getText();

try {
    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menambahkan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {

        PreparedStatement preparedStatement = Config.getConnection().prepareStatement("INSERT INTO transaksi (ID, Kdkamar, Nama, Harga, Lama_Sewa,Total_bayar,Bulan_Masuk,Bulan_Keluar,Tanggungan,Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, ID);
        preparedStatement.setString(2, Kdkamar);
        preparedStatement.setString(3, Nama);
        preparedStatement.setString(4, Harga);
        preparedStatement.setString(5, Lama_sewa);
        preparedStatement.setString(6, Total_bayar);
        preparedStatement.setString(7, Bulan_masuk);
        preparedStatement.setString(8, Bulan_keluar);
        preparedStatement.setString(9, Tanggungan);
        preparedStatement.setString(10, Status);

        preparedStatement.executeUpdate();
        preparedStatement.close();

        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
    }
} catch (SQLException e) {

    JOptionPane.showMessageDialog(null, "Data gagal disimpan: " + e.getMessage());
}

    }//GEN-LAST:event_Jlabelll2MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked

        this.setVisible(false);
        new MenuAdmin().setVisible(true);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void JlabelllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlabelllMouseClicked
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_JlabelllMouseClicked

    private void Menu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu5MouseClicked
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_Menu5MouseClicked

    private void Menu5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu5MouseEntered
        Menu5.setBackground(ClickedColor);
    }//GEN-LAST:event_Menu5MouseEntered

    private void Menu5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu5MouseExited
        Menu5.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu5MouseExited

    private void JlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlabelMouseClicked

    }//GEN-LAST:event_JlabelMouseClicked

    private void Menu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu4MouseClicked
        this.setVisible(false);
        new KeluhanPenghuni().setVisible(true);
    }//GEN-LAST:event_Menu4MouseClicked

    private void Menu4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu4MouseEntered
        Menu4.setBackground(ClickedColor);
    }//GEN-LAST:event_Menu4MouseEntered

    private void Menu4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu4MouseExited
        Menu4.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu4MouseExited

    private void menu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu4MouseClicked
        this.setVisible(false);
        new DataTransaksi().setVisible(true);
    }//GEN-LAST:event_menu4MouseClicked

    private void Menu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu3MouseClicked
        this.setVisible(false);
        new DataTransaksi().setVisible(true);
    }//GEN-LAST:event_Menu3MouseClicked

    private void Menu3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu3MouseEntered
        Menu3.setBackground(ClickedColor);
    }//GEN-LAST:event_Menu3MouseEntered

    private void Menu3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu3MouseExited
        Menu3.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu3MouseExited

    private void jhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jhaMouseClicked
        this.setVisible(false);
        new DataPenghuni().setVisible(true);
    }//GEN-LAST:event_jhaMouseClicked

    private void Menu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MouseClicked
        this.setVisible(false);
        new DataPenghuni().setVisible(true);
    }//GEN-LAST:event_Menu2MouseClicked

    private void Menu2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MouseEntered
        Menu2.setBackground(ClickedColor);
    }//GEN-LAST:event_Menu2MouseEntered

    private void Menu2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MouseExited
        Menu2.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu2MouseExited

    private void jaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jaMouseClicked
        this.setVisible(false);
        new MenuAdmin().setVisible(true);
    }//GEN-LAST:event_jaMouseClicked

    private void jaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jaMousePressed

    private void Menu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu1MouseClicked
        this.setVisible(false);
        new MenuAdmin().setVisible(true);
    }//GEN-LAST:event_Menu1MouseClicked

    private void Menu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu1MouseEntered
        Menu1.setBackground(ClickedColor);
    }//GEN-LAST:event_Menu1MouseEntered

    private void Menu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu1MouseExited
        Menu1.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu1MouseExited

    private void Jlabelll3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jlabelll3MouseClicked
        this.setVisible(false);
        new TransaksiPembayaran().setVisible(true);
    }//GEN-LAST:event_Jlabelll3MouseClicked

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
            java.util.logging.Logger.getLogger(TransaksiPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiPembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiPembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel;
    private javax.swing.JLabel Jlabelll;
    private javax.swing.JLabel Jlabelll1;
    private javax.swing.JLabel Jlabelll2;
    private javax.swing.JLabel Jlabelll3;
    private javax.swing.JPanel Menu1;
    private javax.swing.JPanel Menu2;
    private javax.swing.JPanel Menu3;
    private javax.swing.JPanel Menu4;
    private javax.swing.JPanel Menu5;
    private javax.swing.JComboBox<String> cmbulanmasuk;
    private javax.swing.JComboBox<String> cmkamar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel ja;
    private javax.swing.JLabel jha;
    private javax.swing.JLabel menu4;
    private javax.swing.JPanel pnmain;
    private javax.swing.JTextField txbayar;
    private javax.swing.JTextField txbulankeluar;
    private javax.swing.JTextField txharga;
    private javax.swing.JTextField txnama;
    private javax.swing.JTextField txransaksi;
    private javax.swing.JTextField txsewa;
    private javax.swing.JTextField txstatus;
    private javax.swing.JTextField txtanggungan;
    private javax.swing.JTextField txtotalbayar;
    // End of variables declaration//GEN-END:variables
}
