package project.d.kost;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class InfoKamar extends javax.swing.JFrame {
    private Color ClickedColor;
    private Color DefaultColor;
    public InfoKamar() {
        setUndecorated(true);
        initComponents();
        DefaultColor = new Color(0, 153, 153);
        ClickedColor = new Color(0, 102, 102);
        datatable();
        this.setLocationRelativeTo(null);
        txt_status.setEnabled(false);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN,14));        
        jTable1.setRowHeight(25);
    }

    public void datatable() {
        try {
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("Kdkamar");
            tbl.addColumn("Type");
            tbl.addColumn("Ukuran");
            tbl.addColumn("Fasilitas");
            tbl.addColumn("Harga");
            tbl.addColumn("Status");
            jTable1.setModel(tbl);
            try (
             Statement statement = Config.getConnection().createStatement();
             ResultSet res = statement.executeQuery("SELECT * FROM kamar"))
            {
                while (res.next()) {
                    tbl.addRow(new Object[]{
                        res.getString("Kdkamar"),
                        res.getString("type_kamar"),
                        res.getString("Ukuran"),
                        res.getString("Fasilitas"),
                        res.getString("Harga"),
                        res.getString("Status"),});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Salah ");
        }
    }
private void status() {
    try {
        Connection con = Config.getConnection();
        String sql_tingkat = "SELECT Nama FROM datapenghuni WHERE Kdkamar = ?";

        try (PreparedStatement ps = con.prepareStatement(sql_tingkat)) {
            ps.setString(1, (String) cmkamar.getSelectedItem());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // If there is a result, set the status to "Dihuni"
                    txt_status.setText("Dihuni");
                } else {
                    // If there is no result, set the status to "Tidak Dihuni"
                    txt_status.setText("Tidak Dihuni");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void kosong(){
        txt_ukuran.setText("");
        txt_fasilitas.setText("");
        txt_harga.setText("");
        cmkamar.setSelectedItem(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btncari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        kodekamar = new javax.swing.JLabel();
        txt_ukuran = new javax.swing.JTextField();
        fasilitas = new javax.swing.JLabel();
        txt_fasilitas = new javax.swing.JTextField();
        txt_harga = new javax.swing.JTextField();
        harga = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        kodekamar1 = new javax.swing.JLabel();
        cmkamar = new javax.swing.JComboBox<>();
        txt_status = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        kodekamar2 = new javax.swing.JLabel();
        cmtype = new javax.swing.JComboBox<>();
        Jlabelll1 = new javax.swing.JLabel();
        Jlabelll2 = new javax.swing.JLabel();
        Jlabelll3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnmain = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
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
        setMinimumSize(new java.awt.Dimension(850, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncari.setBackground(new java.awt.Color(255, 255, 255));
        btncari.setFont(new java.awt.Font("Futura Md BT", 0, 12)); // NOI18N
        btncari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Btn cari.jpg"))); // NOI18N
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        jPanel6.add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 88, 37, 30));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Kamar", "Type", "Ukuran", "Fasilitas", "Harga", "Status"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 590, 180));

        txtcari.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });
        jPanel6.add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 88, 120, 28));

        kodekamar.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        kodekamar.setText("Ukuran");
        jPanel6.add(kodekamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 150, -1, -1));

        txt_ukuran.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel6.add(txt_ukuran, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 148, 150, 28));

        fasilitas.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        fasilitas.setText("Fasilitas");
        jPanel6.add(fasilitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 183, -1, -1));

        txt_fasilitas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel6.add(txt_fasilitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 179, 150, 28));

        txt_harga.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel6.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 213, 150, 28));

        harga.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        harga.setText("Harga");
        jPanel6.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 217, -1, -1));

        status.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        status.setText("Status");
        jPanel6.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 251, 39, -1));

        kodekamar1.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        kodekamar1.setText("Kode Kamar");
        jPanel6.add(kodekamar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 92, -1, -1));

        cmkamar.setBackground(new java.awt.Color(0, 102, 102));
        cmkamar.setMaximumRowCount(11);
        cmkamar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9" }));
        cmkamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmkamarActionPerformed(evt);
            }
        });
        jPanel6.add(cmkamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 88, 92, -1));

        txt_status.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel6.add(txt_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 247, 150, 28));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Informasi Kamar");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 35, -1, -1));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg dkost ats.jpg"))); // NOI18N
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 110, 76));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg dkost ats2.jpg"))); // NOI18N
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 76));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg_dkostbwh-kiri.png"))); // NOI18N
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, -1));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg_dkostbwh-.png"))); // NOI18N
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, -1, -1));

        kodekamar2.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        kodekamar2.setText("Type kamar");
        jPanel6.add(kodekamar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 122, 79, -1));

        cmtype.setBackground(new java.awt.Color(0, 102, 102));
        cmtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ekonomi", "Elite", "VIP" }));
        cmtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmtypeActionPerformed(evt);
            }
        });
        jPanel6.add(cmtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 118, 92, -1));

        Jlabelll1.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        Jlabelll1.setForeground(new java.awt.Color(255, 255, 255));
        Jlabelll1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/tambah 1.png"))); // NOI18N
        Jlabelll1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jlabelll1MouseClicked(evt);
            }
        });
        jPanel6.add(Jlabelll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        Jlabelll2.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        Jlabelll2.setForeground(new java.awt.Color(255, 255, 255));
        Jlabelll2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/edit 1.png"))); // NOI18N
        Jlabelll2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jlabelll2MouseClicked(evt);
            }
        });
        jPanel6.add(Jlabelll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        Jlabelll3.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        Jlabelll3.setForeground(new java.awt.Color(255, 255, 255));
        Jlabelll3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/hapus 1.png"))); // NOI18N
        Jlabelll3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jlabelll3MouseClicked(evt);
            }
        });
        jPanel6.add(Jlabelll3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, -1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel10.setText("Cari Data");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 90, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 680, 500));

        pnmain.setBackground(new java.awt.Color(0, 153, 153));
        pnmain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnmain.setForeground(new java.awt.Color(255, 255, 255));
        pnmain.setPreferredSize(new java.awt.Dimension(150, 514));

        jLabel2.setFont(new java.awt.Font("Futura Bk BT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ganti Akun");

        jLabel14.setFont(new java.awt.Font("Futura Bk BT", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Menu Pemilik");
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
            .addGap(0, 241, Short.MAX_VALUE)
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
            .addGap(0, 241, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/logo dkost.png"))); // NOI18N

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
        Jlabel.setText("Data Pengeluaran");
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
                .addContainerGap(43, Short.MAX_VALUE))
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
        menu4.setText("Laporan Pembayaran");
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
        jha.setText("Informasi Kamar");
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
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnmainLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnmainLayout.createSequentialGroup()
                            .addGroup(pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnmainLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel5)
                                    .addGap(102, 102, 102)
                                    .addComponent(jLabel26))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnmainLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(jLabel14))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnmainLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(1, 1, 1)))
                    .addGroup(pnmainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnmainLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(Menu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Menu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Menu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Menu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnmainLayout.setVerticalGroup(
            pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnmainLayout.createSequentialGroup()
                .addGroup(pnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnmainLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel26)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnmainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)))
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(7, 7, 7)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Menu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Menu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Menu5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(pnmain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased

    }//GEN-LAST:event_txtcariKeyReleased

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
        DefaultTableModel ob = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        jTable1.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtcari.getText()));
    }//GEN-LAST:event_txtcariActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();

        String tblkodekamar = tblModel.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String tbltype = tblModel.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String tblukuran = tblModel.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String tblfasilitas = tblModel.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String tblharga = tblModel.getValueAt(jTable1.getSelectedRow(), 4).toString();
        String tblstatus = tblModel.getValueAt(jTable1.getSelectedRow(), 5).toString();

        cmkamar.setSelectedItem(tblkodekamar);
        cmtype.setSelectedItem(tbltype);
        txt_ukuran.setText(tblukuran);
        txt_fasilitas.setText(tblfasilitas);
        txt_harga.setText(tblharga);
        txt_status.setText(tblstatus);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        DefaultTableModel ob = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        jTable1.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtcari.getText()));
    }//GEN-LAST:event_btncariActionPerformed

    private void cmkamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmkamarActionPerformed
    status();
    }//GEN-LAST:event_cmkamarActionPerformed

    private void Jlabelll1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jlabelll1MouseClicked
String Kdkamar = cmkamar.getSelectedItem().toString();
String type_kamar = cmtype.getSelectedItem().toString();
String Ukuran = txt_ukuran.getText();
String Fasilitas = txt_fasilitas.getText();
String Harga = txt_harga.getText();
String Status = txt_status.getText();

try {
int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menambahkan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
    PreparedStatement preparedStatement = Config.getConnection().prepareStatement("INSERT INTO kamar (Kdkamar, type_kamar, ukuran, fasilitas, harga, status) VALUES (?,?,?,?,?,?)");
    preparedStatement.setString(1, Kdkamar);
    preparedStatement.setString(2, type_kamar);
    preparedStatement.setString(3, Ukuran);
    preparedStatement.setString(4, Fasilitas);
    preparedStatement.setString(5, Harga);
    preparedStatement.setString(6, Status);

    // Check if Kdkamar already exists in the database
    PreparedStatement checkStatement = Config.getConnection().prepareStatement("SELECT * FROM kamar WHERE Kdkamar =?");
    checkStatement.setString(1, Kdkamar);
    ResultSet resultSet = checkStatement.executeQuery();
    if (resultSet.next()) {
        JOptionPane.showMessageDialog(null, "Kdkamar Sudah ada dalam database!");
    } else {
        // If Kdkamar doesn't exist, insert the data
        preparedStatement.executeUpdate();
        preparedStatement.close();
        checkStatement.close();
        resultSet.close();
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
    }
}
    }catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error menyimpan data: " + e.getMessage());
}
        datatable();
        kosong();
    }//GEN-LAST:event_Jlabelll1MouseClicked

    private void Jlabelll2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jlabelll2MouseClicked
try {
    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin Mengedit data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
    String sql = "UPDATE kamar "
        + "SET type_kamar = ?,ukuran = ?, fasilitas = ?, harga = ?, status = ? "
        + "WHERE Kdkamar = ?";

    java.sql.Connection conn = (Connection) Config.getConnection();
    java.sql.PreparedStatement pst = conn.prepareStatement(sql);

    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Silakan pilih baris data yang akan diubah.");
        return;
    }

    String Kdkamar = (String) jTable1.getValueAt(selectedRow, 0);
    pst.setString(1, cmtype.getSelectedItem().toString());
    pst.setString(2, txt_ukuran.getText());
    pst.setString(3, txt_fasilitas.getText());
    pst.setString(4, txt_harga.getText());
    pst.setString(5, txt_status.getText());
    pst.setString(6, Kdkamar);

    int rowsAffected = pst.executeUpdate();

    if (rowsAffected > 0) {
        JOptionPane.showMessageDialog(null, "Data Berhasil di edit");
        jTable1.setValueAt(cmtype.getSelectedItem().toString(), selectedRow, 1);
        jTable1.setValueAt(txt_ukuran.getText(), selectedRow, 2);
        jTable1.setValueAt(txt_fasilitas.getText(), selectedRow, 3);
        jTable1.setValueAt(txt_harga.getText(), selectedRow, 4);
        jTable1.setValueAt(txt_status.getText(), selectedRow, 5);
    } else {
        JOptionPane.showMessageDialog(null, "Tidak ada data dengan Kdkamar tersebut");

    }     
}
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Perubahan Data Gagal: " + e.getMessage());
}
        datatable();
        kosong();
    }//GEN-LAST:event_Jlabelll2MouseClicked

    private void Jlabelll3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jlabelll3MouseClicked
         try {
    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin Menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {         
            String sql = "DELETE FROM kamar WHERE Kdkamar = ?";

            java.sql.Connection conn = (Connection) Config.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

            // Set parameter using PreparedStatement
            pst.setString(1, cmkamar.getSelectedItem().toString());

            // Execute the delete
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                // Remove the selected row from the JTable
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                }

                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            } else {
                JOptionPane.showMessageDialog(this, "Tidak ada data dengan Kdkamar tersebut");
            }
    }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
        }
        datatable();
        kosong();
    }//GEN-LAST:event_Jlabelll3MouseClicked

    private void cmtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmtypeActionPerformed

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
        this.setVisible(false);
        new DataPengeluaran().setVisible(true);
    }//GEN-LAST:event_JlabelMouseClicked

    private void Menu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu4MouseClicked
        this.setVisible(false);
        new DataPengeluaran().setVisible(true);
    }//GEN-LAST:event_Menu4MouseClicked

    private void Menu4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu4MouseEntered
        Menu4.setBackground(ClickedColor);
    }//GEN-LAST:event_Menu4MouseEntered

    private void Menu4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu4MouseExited
        Menu4.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu4MouseExited

    private void menu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu4MouseClicked
        this.setVisible(false);
        new LaporanPembayaran().setVisible(true);
    }//GEN-LAST:event_menu4MouseClicked

    private void Menu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu3MouseClicked
        this.setVisible(false);
        new LaporanPembayaran().setVisible(true);
    }//GEN-LAST:event_Menu3MouseClicked

    private void Menu3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu3MouseEntered
        Menu3.setBackground(ClickedColor);
    }//GEN-LAST:event_Menu3MouseEntered

    private void Menu3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu3MouseExited
        Menu3.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu3MouseExited

    private void jhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jhaMouseClicked
        this.setVisible(false);
        new InfoKamar().setVisible(true);
    }//GEN-LAST:event_jhaMouseClicked

    private void Menu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MouseClicked
        this.setVisible(false);
        new InfoKamar().setVisible(true);
    }//GEN-LAST:event_Menu2MouseClicked

    private void Menu2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MouseEntered
        Menu2.setBackground(ClickedColor);
    }//GEN-LAST:event_Menu2MouseEntered

    private void Menu2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MouseExited
        Menu2.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu2MouseExited

    private void jaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jaMouseClicked
        this.setVisible(false);
        new MenuPemilik().setVisible(true);
    }//GEN-LAST:event_jaMouseClicked

    private void jaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jaMousePressed

    private void Menu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu1MouseClicked
        this.setVisible(false);
        new MenuPemilik().setVisible(true);
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
            java.util.logging.Logger.getLogger(InfoKamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoKamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoKamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoKamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoKamar().setVisible(true);
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
    private javax.swing.JButton btncari;
    private javax.swing.JComboBox<String> cmkamar;
    private javax.swing.JComboBox<String> cmtype;
    private javax.swing.JLabel fasilitas;
    private javax.swing.JLabel harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel ja;
    private javax.swing.JLabel jha;
    private javax.swing.JLabel kodekamar;
    private javax.swing.JLabel kodekamar1;
    private javax.swing.JLabel kodekamar2;
    private javax.swing.JLabel menu4;
    private javax.swing.JPanel pnmain;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txt_fasilitas;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_status;
    private javax.swing.JTextField txt_ukuran;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables

}
