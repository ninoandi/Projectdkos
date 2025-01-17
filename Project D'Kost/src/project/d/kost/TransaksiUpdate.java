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
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
public class TransaksiUpdate extends javax.swing.JFrame {
    private Color ClickedColor;
    private Color DefaultColor;
    public TransaksiUpdate() {
        setUndecorated(true);
        initComponents();
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN,14));
        jTable1.setRowHeight(25);
        DefaultColor = new Color(0, 153, 153);
        ClickedColor = new Color(0, 102, 102);
        this.setLocationRelativeTo(null);
        txkamar.setEnabled(false);
        txtotalbayar.setEnabled(false);
        txstatus.setEnabled(false);
        txnama.setEnabled(false);
        txtanggungan.setEnabled(false);
        txransaksi.setEnabled(false);
        datatable();
    }

    public void datatable() {
        try {

            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("ID");
            tbl.addColumn("Kamar");
            tbl.addColumn("Nama");
            tbl.addColumn("TotalBayar");
            tbl.addColumn("Tanggungan");
            tbl.addColumn("Status");

            jTable1.setModel(tbl);

            try (
                    Statement statement = Config.getConnection().createStatement(); ResultSet res = statement.executeQuery("SELECT * FROM transaksi")) {

                while (res.next()) {
                    tbl.addRow(new Object[]{
                        res.getString("ID"),
                        res.getString("Kdkamar"),
                        res.getString("nama"),
                        res.getString("total_bayar"),
                        res.getString("tanggungan"),
                        res.getString("status"),});
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Salah ");
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        txtotalbayar = new javax.swing.JTextField();
        txbayar = new javax.swing.JTextField();
        txtanggungan = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txstatus = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txkamar = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txnama = new javax.swing.JTextField();
        txransaksi = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Jlabelll2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Jlabelll1 = new javax.swing.JLabel();
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

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 153));
        jLabel16.setText("Update Pembayaran");
        jLabel16.setIconTextGap(10);
        jLabel16.setMaximumSize(new java.awt.Dimension(60, 16));
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 28, -1, -1));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kamar", "Nama", "Total Bayar", "Tanggungan", "Status"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 228, 623, 187));

        jLabel47.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel47.setText("Tanggungan");
        jPanel7.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 124, -1, -1));

        txtotalbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtotalbayarActionPerformed(evt);
            }
        });
        jPanel7.add(txtotalbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 85, 130, -1));

        txbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbayarActionPerformed(evt);
            }
        });
        jPanel7.add(txbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 187, 130, -1));

        txtanggungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtanggunganActionPerformed(evt);
            }
        });
        jPanel7.add(txtanggungan, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 119, 130, -1));

        jLabel44.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel44.setText("Total Bayar");
        jPanel7.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        txstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txstatusActionPerformed(evt);
            }
        });
        jPanel7.add(txstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 153, 130, -1));

        jLabel45.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel45.setText("Status");
        jPanel7.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 158, -1, -1));

        jLabel46.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel46.setText("Pembayaran");
        jPanel7.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 192, -1, -1));

        jLabel38.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel38.setText("Kode Kamar");
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 124, -1, -1));

        txkamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txkamarActionPerformed(evt);
            }
        });
        jPanel7.add(txkamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 119, 130, -1));

        jLabel19.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel19.setText("ID Transaksi");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 90, -1, -1));

        txnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnamaActionPerformed(evt);
            }
        });
        jPanel7.add(txnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 153, 130, -1));

        txransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txransaksiActionPerformed(evt);
            }
        });
        jPanel7.add(txransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 85, 130, -1));

        jLabel42.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel42.setText("Nama");
        jPanel7.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 159, -1, -1));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg dkost ats2.jpg"))); // NOI18N
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 76));

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg_dkostbwh-.png"))); // NOI18N
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, -1, -1));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg dkost ats.jpg"))); // NOI18N
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 110, 76));

        Jlabelll2.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        Jlabelll2.setForeground(new java.awt.Color(255, 255, 255));
        Jlabelll2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/edit 1.png"))); // NOI18N
        Jlabelll2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jlabelll2MouseClicked(evt);
            }
        });
        jPanel7.add(Jlabelll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, -1, 28));

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg_dkostbwh-kiri.png"))); // NOI18N
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, -1));

        Jlabelll1.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        Jlabelll1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/kembali 1.png"))); // NOI18N
        Jlabelll1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jlabelll1MouseClicked(evt);
            }
        });
        jPanel7.add(Jlabelll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 80, 28));

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
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        String tblKamar = tblModel.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String tblID = tblModel.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String tblNama = tblModel.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String tblTotalbayar = tblModel.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String tblStatus = tblModel.getValueAt(jTable1.getSelectedRow(), 5).toString();
        String tblTanggungan = tblModel.getValueAt(jTable1.getSelectedRow(), 4).toString();
        

        txkamar.setText(tblKamar);
        txransaksi.setText(tblID);
        txnama.setText(tblNama);
        txtotalbayar.setText(tblTotalbayar);
        txstatus.setText(tblStatus);
        txtanggungan.setText(tblTanggungan);
        

    }//GEN-LAST:event_jTable1MouseClicked

    private void txtotalbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtotalbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtotalbayarActionPerformed

    private void txbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbayarActionPerformed

        int total, bayar, tanggungan;
        total = Integer.valueOf(txtanggungan.getText());
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

    private void txstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txstatusActionPerformed

    private void txkamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txkamarActionPerformed

    }//GEN-LAST:event_txkamarActionPerformed

    private void txnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnamaActionPerformed

    private void txransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txransaksiActionPerformed

    private void Jlabelll2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jlabelll2MouseClicked
try {
    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin mengedit data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        String sql = "UPDATE transaksi "
                + "SET Kdkamar = ?, Nama = ?, Total_bayar = ?, Tanggungan = ?, Status = ? "
                + "WHERE ID = ?";

        java.sql.Connection conn = (Connection) Config.getConnection();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);

        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Silakan pilih baris data yang akan diubah.");
            return;
        }
        pst.setString(1, txkamar.getText());
        pst.setString(2, txnama.getText());
        pst.setString(3, txtotalbayar.getText());
        pst.setString(4, txtanggungan.getText());
        pst.setString(5, txstatus.getText());
        pst.setString(6, txransaksi.getText());

        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Data Berhasil di edit");

            selectedRow = jTable1.getSelectedRow();
            if (selectedRow != -1) {
                jTable1.setValueAt(txkamar.getText(), selectedRow, 1);
                jTable1.setValueAt(txnama.getText(), selectedRow, 2);
                jTable1.setValueAt(txtotalbayar.getText(), selectedRow, 3);
                jTable1.setValueAt(txtanggungan.getText(), selectedRow, 4);
                jTable1.setValueAt(txstatus.getText(), selectedRow, 5);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tidak ada data dengan ID tersebut");
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Perubahan Data Gagal: " + e.getMessage());
}

    }//GEN-LAST:event_Jlabelll2MouseClicked

    private void Jlabelll1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jlabelll1MouseClicked
        this.setVisible(false);
        new DataTransaksi().setVisible(true);
    }//GEN-LAST:event_Jlabelll1MouseClicked

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
            java.util.logging.Logger.getLogger(TransaksiUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel;
    private javax.swing.JLabel Jlabelll;
    private javax.swing.JLabel Jlabelll1;
    private javax.swing.JLabel Jlabelll2;
    private javax.swing.JPanel Menu1;
    private javax.swing.JPanel Menu2;
    private javax.swing.JPanel Menu3;
    private javax.swing.JPanel Menu4;
    private javax.swing.JPanel Menu5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel ja;
    private javax.swing.JLabel jha;
    private javax.swing.JLabel menu4;
    private javax.swing.JPanel pnmain;
    private javax.swing.JTextField txbayar;
    private javax.swing.JTextField txkamar;
    private javax.swing.JTextField txnama;
    private javax.swing.JTextField txransaksi;
    private javax.swing.JTextField txstatus;
    private javax.swing.JTextField txtanggungan;
    private javax.swing.JTextField txtotalbayar;
    // End of variables declaration//GEN-END:variables
}
