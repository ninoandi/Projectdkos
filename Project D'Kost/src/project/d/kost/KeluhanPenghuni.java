package project.d.kost;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.Font;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



public class KeluhanPenghuni extends javax.swing.JFrame {
    private Color ClickedColor;
    private Color DefaultColor;
    public KeluhanPenghuni() {
        setUndecorated(true);
        initComponents();
        DefaultColor = new Color(0, 153, 153);
        ClickedColor = new Color(0, 102, 102);
        datatable();
        loadNIK();
        loadnama();
        txt_NIK.setEnabled(false);
        txt_nama.setEnabled(false);
        this.setLocationRelativeTo(null);
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        txtanggal.setText(s.format(date));
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedNow = now.format(formatter);
        txt_waktu.setText(formattedNow);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN,14));        
        jTable1.setRowHeight(25);
        
    }
       public void datatable() {
    try {   
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode Kamar");
        tbl.addColumn("NIK");
        tbl.addColumn("Keluhan");
        tbl.addColumn("Tanggal");
        tbl.addColumn("Waktu");
        tbl.addColumn("Status");
        jTable1.setModel(tbl);

        try (
             Statement statement = Config.getConnection().createStatement();
             ResultSet res = statement.executeQuery("SELECT * FROM keluhan")) 
        {
            while (res.next()) {
                tbl.addRow(new Object[]{
                        res.getString("Kdkamar"),
                        res.getString("NIK"),
                        res.getString("Keluhan_penghuni"),
                        res.getString("tanggal"),
                        res.getString("Waktu"),
                        res.getString("status"),
                        
                });
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Salah ");
    }
}
    public void kosong(){
        txt_NIK.setText("");
        txt_nama.setText("");
        txt_keluhan.setText("");
    }
    
private void loadNIK() {
    try {
        Connection con = Config.getConnection();
        String sql_tingkat = "SELECT NIK FROM datapenghuni WHERE Kdkamar = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql_tingkat)) {
            ps.setString(1, (String) cmkamar.getSelectedItem());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    txt_NIK.setText(rs.getString("NIK"));
                } else {
                    // Handle the case where no results are found
                    txt_NIK.setText("Not Found");
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
                    txt_nama.setText(rs.getString("nama"));
                } else {
                    // Handle the case where no results are found
                    txt_nama.setText("Not Found");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        pn_kanan = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_NIK = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_keluhan = new javax.swing.JTextField();
        txt_cari = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmkamar = new javax.swing.JComboBox<>();
        txtanggal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmstatus = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Jlabelll1 = new javax.swing.JLabel();
        Jlabelll2 = new javax.swing.JLabel();
        Jlabelll3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_waktu = new javax.swing.JTextField();
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

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pn_kanan.setBackground(new java.awt.Color(255, 255, 255));
        pn_kanan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Keluhan Penghuni");
        pn_kanan.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 35, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel4.setText("NIK");
        pn_kanan.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 144, -1, -1));

        jLabel6.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel6.setText("Nama");
        pn_kanan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 178, -1, -1));
        pn_kanan.add(txt_NIK, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 139, 155, -1));
        pn_kanan.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 173, 155, -1));

        jLabel9.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel9.setText("Keluhan");
        pn_kanan.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 214, -1, -1));
        pn_kanan.add(txt_keluhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 208, 155, -1));

        txt_cari.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        pn_kanan.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 100, 123, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Btn cari.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pn_kanan.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 37, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel8.setText("Kode Kamar");
        pn_kanan.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 105, -1, -1));

        cmkamar.setBackground(new java.awt.Color(0, 102, 102));
        cmkamar.setMaximumRowCount(11);
        cmkamar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9" }));
        cmkamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmkamarActionPerformed(evt);
            }
        });
        pn_kanan.add(cmkamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 101, 100, -1));

        txtanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtanggalActionPerformed(evt);
            }
        });
        pn_kanan.add(txtanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 241, 155, -1));

        jLabel11.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel11.setText("Tanggal");
        pn_kanan.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 246, -1, -1));

        cmstatus.setBackground(new java.awt.Color(0, 102, 102));
        cmstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diproses", "Selesai" }));
        cmstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmstatusActionPerformed(evt);
            }
        });
        pn_kanan.add(cmstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 275, 100, -1));

        jLabel12.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel12.setText("Status");
        pn_kanan.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 279, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Kamar", "NIK", "Keluhan", "Tanggal", "Waktu", "Status"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        pn_kanan.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 311, 564, 160));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg dkost ats2.jpg"))); // NOI18N
        pn_kanan.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 76));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg_dkostbwh-kiri.png"))); // NOI18N
        pn_kanan.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 421, -1, -1));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg_dkostbwh-.png"))); // NOI18N
        pn_kanan.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 421, -1, -1));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg dkost ats.jpg"))); // NOI18N
        pn_kanan.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 110, 76));

        Jlabelll1.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        Jlabelll1.setForeground(new java.awt.Color(255, 255, 255));
        Jlabelll1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/tambah 1.png"))); // NOI18N
        Jlabelll1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jlabelll1MouseClicked(evt);
            }
        });
        pn_kanan.add(Jlabelll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        Jlabelll2.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        Jlabelll2.setForeground(new java.awt.Color(255, 255, 255));
        Jlabelll2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/edit 1.png"))); // NOI18N
        Jlabelll2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jlabelll2MouseClicked(evt);
            }
        });
        pn_kanan.add(Jlabelll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        Jlabelll3.setFont(new java.awt.Font("Futura Bk BT", 0, 18)); // NOI18N
        Jlabelll3.setForeground(new java.awt.Color(255, 255, 255));
        Jlabelll3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/hapus 1.png"))); // NOI18N
        Jlabelll3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jlabelll3MouseClicked(evt);
            }
        });
        pn_kanan.add(Jlabelll3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, -1, 30));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel10.setText("Cari Data");
        pn_kanan.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 105, -1, -1));

        jLabel5.setFont(new java.awt.Font("Futura Md BT", 0, 14)); // NOI18N
        jLabel5.setText("Waktu");
        pn_kanan.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        txt_waktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_waktuActionPerformed(evt);
            }
        });
        pn_kanan.add(txt_waktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 90, -1));

        getContentPane().add(pn_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 730, 500));

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

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed

    }//GEN-LAST:event_txt_cariActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel ob =(DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        jTable1.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txt_cari.getText()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmkamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmkamarActionPerformed
    loadNIK();
    loadnama();
    }//GEN-LAST:event_cmkamarActionPerformed

    private void cmstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmstatusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        String tblKode_Kamar = tblModel.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String tblNIK = tblModel.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String tblKeluhan = tblModel.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String tbltanggal = tblModel.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String tblWaktu = tblModel.getValueAt(jTable1.getSelectedRow(), 4).toString();
        String tblstatus = tblModel.getValueAt(jTable1.getSelectedRow(), 5).toString();
        cmkamar.setSelectedItem(tblKode_Kamar);
        txt_NIK.setText(tblNIK);
        txt_keluhan.setText(tblKeluhan);
        txtanggal.setText(tbltanggal);
        txt_waktu.setText(tblWaktu);
        cmstatus.setSelectedItem(tblstatus);
    }//GEN-LAST:event_jTable1MouseClicked

    private void Jlabelll1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jlabelll1MouseClicked
String kdkamar = cmkamar.getSelectedItem().toString();
String NIK = txt_NIK.getText();
String keluhanPenghuni = txt_keluhan.getText();
String tanggal = txtanggal.getText();
String waktu = txt_waktu.getText();
String status = cmstatus.getSelectedItem().toString();
try {
    Connection connection = Config.getConnection();
    PreparedStatement checkStatement = connection.prepareStatement("SELECT COUNT(*) FROM keluhan WHERE kdkamar = ?");
    checkStatement.setString(1, kdkamar);
    ResultSet resultSet = checkStatement.executeQuery();
    resultSet.next();
    int count = resultSet.getInt(1);
    checkStatement.close();
    resultSet.close();

    if (count > 0) {
        JOptionPane.showMessageDialog(null, "Data dengan Kdkamar yang sama sudah ada.");
        return; 
    }
    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menambahkan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO keluhan (kdkamar, NIK, keluhan_penghuni, tanggal, Waktu, status) VALUES (?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, kdkamar);
        preparedStatement.setString(2, NIK);
        preparedStatement.setString(3, keluhanPenghuni);
        preparedStatement.setString(4, tanggal);
        preparedStatement.setString(5, waktu);
        preparedStatement.setString(6, status);
        int rowsAffected = preparedStatement.executeUpdate();
        
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } else {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data");
        }
        preparedStatement.close();
    }
    connection.close();
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
}
datatable(); 
kosong();  


    }//GEN-LAST:event_Jlabelll1MouseClicked

    private void Jlabelll2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jlabelll2MouseClicked
     try {
    int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin mengedit data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
    String sql = "UPDATE keluhan "
            + "SET NIK = ?, Keluhan_penghuni = ?, tanggal = ?, Waktu = ?, status = ?  "
            + "WHERE Kdkamar = ?";

    java.sql.Connection conn = (Connection) Config.getConnection();
    java.sql.PreparedStatement pst = conn.prepareStatement(sql);

    pst.setString(1, txt_NIK.getText());
    pst.setString(2, txt_keluhan.getText());
    pst.setString(3, txtanggal.getText());
     pst.setString(4, txt_waktu.getText());
    pst.setString(5, cmstatus.getSelectedItem().toString());
    pst.setString(6, cmkamar.getSelectedItem().toString());
    int rowsAffected = pst.executeUpdate();

    if (rowsAffected > 0) {
        JOptionPane.showMessageDialog(null, "Data Berhasil di edit");
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            jTable1.setValueAt(txt_NIK.getText(), selectedRow, 1);
            jTable1.setValueAt(txt_keluhan.getText(), selectedRow, 2);
            jTable1.setValueAt(txtanggal.getText(), selectedRow, 3);
            jTable1.setValueAt(txt_waktu.getText(), selectedRow, 4);
            jTable1.setValueAt(cmstatus.getSelectedItem().toString(), selectedRow, 5);
        }

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
    String sql = "DELETE FROM keluhan WHERE Kdkamar = ?";

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

    private void txtanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtanggalActionPerformed

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

    private void txt_waktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_waktuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_waktuActionPerformed

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
            java.util.logging.Logger.getLogger(DataPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KeluhanPenghuni().setVisible(true);
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
    private javax.swing.JComboBox<String> cmkamar;
    private javax.swing.JComboBox<String> cmstatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel ja;
    private javax.swing.JLabel jha;
    private javax.swing.JLabel menu4;
    private javax.swing.JPanel pn_kanan;
    private javax.swing.JPanel pnmain;
    private javax.swing.JTextField txt_NIK;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_keluhan;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_waktu;
    private javax.swing.JTextField txtanggal;
    // End of variables declaration//GEN-END:variables
}
