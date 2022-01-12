/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.chandra.tubespbo;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chand
 */
public class Home extends javax.swing.JFrame {
    public Home() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2 - getHeight()/2);
           load_table();
           load_table_rute();
           load_table_admin();
           load_table_transaksi();
           Fillcombo();
           FillcomboMaskapai();
    }
    private void Fillcombo(){
        try {
            ResultSet rs =null;
            String sql = "SELECT * from kostumer";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String nama = rs.getString("nama_kostumer");
                bookingUsername.addItem(nama);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void FillcomboMaskapai(){
        try {
            ResultSet rs =null;
            String sql = "SELECT * from rute";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String nama = rs.getString("maskapai");
                maskapaiBooking.addItem(nama);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
private void load_table(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Umur");
        model.addColumn("noHO");
        model.addColumn("Alamat");        
        model.addColumn("Jenis Kelamin");

        
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String sql = "select * from kostumer";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});
            }
            tabelKostumer.setModel(model);
        } catch (Exception e) {
        }
}
private void load_table_rute(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID RUTE");
        model.addColumn("Maskapai");
        model.addColumn("Asal");
        model.addColumn("Tujuan");
        model.addColumn("Kursi");
        model.addColumn("Harga");
        
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String sql = "select * from rute";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
            }
            TabelRute.setModel(model);
        } catch (Exception e) {
        }
}private void load_table_admin(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama");
        model.addColumn("Username");
        model.addColumn("Password");
        
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String sql = "select * from login";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(2),res.getString(3),res.getString(4)});
            }
        } catch (Exception e) {
            
        }
}


private void load_table_transaksi(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("NIK");
        model.addColumn("UMUR");
        model.addColumn("HP");
        model.addColumn("ALAMAT");
        model.addColumn("MASKAPAI");
        model.addColumn("ASAL");
        model.addColumn("TUJUAN");
        model.addColumn("HARGA");
        model.addColumn("TGL");
        
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String sql = "select * from transaksi";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11)});
            }
            tabelTransaksi.setModel(model);
        } catch (Exception e) {
        }
}
private void kosongKostumer(){
        field_idUser.setText(null);
        field_namaUser.setText(null);
        field_nikUser.setText(null);
        field_noUser.setText(null);        
        field_alamatUser.setText(null);
        field_umurUser.setText(null);
        fiel_gender.setSelectedItem(this);
    }
private void kosongRute(){
        ruteField_id.setText(null);
        ruteCombo_maskapai.setSelectedItem(this);
        ruteField_Asal.setText(null);
        ruteField_Tujuan.setText(null);        
        ruteField_kursi.setText(null);
        ruteField_harga.setText(null);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        bodyPanel = new javax.swing.JPanel();
        panelKiri = new javax.swing.JPanel();
        homeMenu = new javax.swing.JButton();
        bookingMenu = new javax.swing.JButton();
        kostumerMenu = new javax.swing.JButton();
        transaksiMenu = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        ruteMenu = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        panelKanan = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bookingPanel = new javax.swing.JPanel();
        bookingUsername = new javax.swing.JComboBox<>();
        idBooking = new javax.swing.JTextField();
        bookingNIK = new javax.swing.JTextField();
        bookingUmur = new javax.swing.JTextField();
        bookingHP = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        bookingAlamat = new javax.swing.JTextArea();
        hargaBooking = new javax.swing.JTextField();
        tanggalBooking = new com.toedter.calendar.JDateChooser();
        maskapaiBooking = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        asalBooking = new javax.swing.JComboBox<>();
        tujuanBooking = new javax.swing.JComboBox<>();
        tanggalTes = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        text_errorNIKUser = new javax.swing.JPanel();
        text_idUser = new javax.swing.JLabel();
        text_alamatUser = new javax.swing.JLabel();
        text_nikUser = new javax.swing.JLabel();
        text_umurUser = new javax.swing.JLabel();
        text_noUser = new javax.swing.JLabel();
        field_noUser = new javax.swing.JTextField();
        text_namaUser = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelKostumer = new javax.swing.JTable();
        teks_genderUser = new javax.swing.JLabel();
        field_namaUser = new javax.swing.JTextField();
        field_nikUser = new javax.swing.JTextField();
        field_alamatUser = new javax.swing.JTextField();
        field_umurUser = new javax.swing.JTextField();
        field_idUser = new javax.swing.JTextField();
        button_simpanUser = new javax.swing.JButton();
        button_ubahUser = new javax.swing.JButton();
        button_hapusUser = new javax.swing.JButton();
        button_batalUser = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        fiel_gender = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        transaksiPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        panelRute = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ruteField_harga = new javax.swing.JTextField();
        ruteField_id = new javax.swing.JTextField();
        ruteField_Asal = new javax.swing.JTextField();
        ruteField_Tujuan = new javax.swing.JTextField();
        ruteField_kursi = new javax.swing.JTextField();
        ruteCombo_maskapai = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelRute = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(910, 583));

        bodyPanel.setBackground(new java.awt.Color(255, 255, 255));
        bodyPanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        bodyPanel.setMinimumSize(new java.awt.Dimension(1280, 720));
        bodyPanel.setPreferredSize(new java.awt.Dimension(1280, 720));

        panelKiri.setBackground(new java.awt.Color(102, 204, 255));
        panelKiri.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        panelKiri.setPreferredSize(new java.awt.Dimension(369, 713));

        homeMenu.setBackground(new java.awt.Color(102, 255, 255));
        homeMenu.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        homeMenu.setText("HOME");
        homeMenu.setToolTipText("");
        homeMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        homeMenu.setIconTextGap(25);
        homeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeMenuActionPerformed(evt);
            }
        });

        bookingMenu.setBackground(new java.awt.Color(102, 255, 255));
        bookingMenu.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        bookingMenu.setText("BOOKING");
        bookingMenu.setToolTipText("");
        bookingMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bookingMenu.setIconTextGap(25);
        bookingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingMenuActionPerformed(evt);
            }
        });

        kostumerMenu.setBackground(new java.awt.Color(102, 255, 255));
        kostumerMenu.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        kostumerMenu.setText("COSTUMER");
        kostumerMenu.setToolTipText("");
        kostumerMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kostumerMenu.setIconTextGap(25);
        kostumerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kostumerMenuActionPerformed(evt);
            }
        });

        transaksiMenu.setBackground(new java.awt.Color(102, 255, 255));
        transaksiMenu.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        transaksiMenu.setText("TRANSAKSI");
        transaksiMenu.setToolTipText("");
        transaksiMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        transaksiMenu.setIconTextGap(25);
        transaksiMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksiMenuActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(102, 255, 255));
        logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logout.setText("LOGOUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        ruteMenu.setBackground(new java.awt.Color(102, 255, 255));
        ruteMenu.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        ruteMenu.setText("RUTE");
        ruteMenu.setToolTipText("");
        ruteMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ruteMenu.setIconTextGap(25);
        ruteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruteMenuActionPerformed(evt);
            }
        });

        jLabel32.setIcon(new javax.swing.ImageIcon("P:\\DATA\\Bahan\\JavaGUI\\download (1) 1.png")); // NOI18N

        jLabel31.setIcon(new javax.swing.ImageIcon("P:\\DATA\\Bahan\\JavaGUI\\BUSSER.png")); // NOI18N

        javax.swing.GroupLayout panelKiriLayout = new javax.swing.GroupLayout(panelKiri);
        panelKiri.setLayout(panelKiriLayout);
        panelKiriLayout.setHorizontalGroup(
            panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKiriLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ruteMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transaksiMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kostumerMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookingMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKiriLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(103, 103, 103))
        );
        panelKiriLayout.setVerticalGroup(
            panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKiriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(homeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookingMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kostumerMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(transaksiMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ruteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        panelKanan.setBackground(new java.awt.Color(6, 214, 160));
        panelKanan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        panelKanan.setLayout(new java.awt.CardLayout());

        homePanel.setBackground(new java.awt.Color(255, 255, 255));
        homePanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        homePanel.setMinimumSize(new java.awt.Dimension(914, 587));
        homePanel.setPreferredSize(new java.awt.Dimension(914, 587));
        homePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("P:\\DATA\\Bahan\\JavaGUI\\Screenshot 2022-01-07 025416.png")); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jLabel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jLabel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        homePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 716));

        panelKanan.add(homePanel, "card2");

        bookingPanel.setBackground(new java.awt.Color(102, 204, 255));
        bookingPanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        bookingPanel.setMinimumSize(new java.awt.Dimension(914, 587));
        bookingPanel.setPreferredSize(new java.awt.Dimension(914, 587));
        bookingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookingUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingUsernameActionPerformed(evt);
            }
        });
        bookingPanel.add(bookingUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 180, -1));

        idBooking.setText("ID0");
        idBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idBookingActionPerformed(evt);
            }
        });
        bookingPanel.add(idBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 180, -1));

        bookingNIK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingNIKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookingNIKMouseEntered(evt);
            }
        });
        bookingNIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingNIKActionPerformed(evt);
            }
        });
        bookingPanel.add(bookingNIK, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 180, -1));

        bookingUmur.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bookingUmurMouseDragged(evt);
            }
        });
        bookingUmur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookingUmurMouseEntered(evt);
            }
        });
        bookingUmur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingUmurActionPerformed(evt);
            }
        });
        bookingUmur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bookingUmurKeyPressed(evt);
            }
        });
        bookingPanel.add(bookingUmur, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 180, -1));

        bookingHP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookingHPMouseEntered(evt);
            }
        });
        bookingPanel.add(bookingHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 180, -1));

        bookingAlamat.setColumns(20);
        bookingAlamat.setRows(5);
        bookingAlamat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookingAlamatMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(bookingAlamat);

        bookingPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 180, -1));

        hargaBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hargaBookingMouseEntered(evt);
            }
        });
        bookingPanel.add(hargaBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 180, -1));
        bookingPanel.add(tanggalBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 180, 20));

        bookingPanel.add(maskapaiBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 180, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("TAMPILTANGGAL:");
        bookingPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, -1, -1));

        asalBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                asalBookingMouseEntered(evt);
            }
        });
        asalBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asalBookingActionPerformed(evt);
            }
        });
        bookingPanel.add(asalBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 180, -1));

        tujuanBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tujuanBookingMouseEntered(evt);
            }
        });
        bookingPanel.add(tujuanBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 180, -1));

        tanggalTes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tanggalTesMouseEntered(evt);
            }
        });
        bookingPanel.add(tanggalTes, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 180, -1));

        jButton8.setBackground(new java.awt.Color(102, 255, 255));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setText("SIMPAN");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        bookingPanel.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 560, 280, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("ID BOOKING:");
        bookingPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("NAMA:");
        bookingPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("NIK:");
        bookingPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("UMUR:");
        bookingPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("NO HP:");
        bookingPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("ALAMAT:");
        bookingPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("BUS:");
        bookingPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("ASAL:");
        bookingPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("TUJUAN:");
        bookingPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("HARGA:");
        bookingPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("TANGGAL:");
        bookingPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, -1, -1));

        jLabel30.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 36)); // NOI18N
        jLabel30.setText("BOOKING BUS");
        bookingPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        panelKanan.add(bookingPanel, "card3");

        text_errorNIKUser.setBackground(new java.awt.Color(102, 204, 255));
        text_errorNIKUser.setMaximumSize(new java.awt.Dimension(1280, 720));
        text_errorNIKUser.setMinimumSize(new java.awt.Dimension(914, 587));
        text_errorNIKUser.setPreferredSize(new java.awt.Dimension(914, 587));
        text_errorNIKUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        text_idUser.setBackground(new java.awt.Color(0, 0, 0));
        text_idUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        text_idUser.setText("ID:");
        text_errorNIKUser.add(text_idUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        text_alamatUser.setBackground(new java.awt.Color(0, 0, 0));
        text_alamatUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        text_alamatUser.setText("ALAMAT:");
        text_errorNIKUser.add(text_alamatUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, -1));

        text_nikUser.setBackground(new java.awt.Color(0, 0, 0));
        text_nikUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        text_nikUser.setText("NIK:");
        text_errorNIKUser.add(text_nikUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));

        text_umurUser.setBackground(new java.awt.Color(0, 0, 0));
        text_umurUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        text_umurUser.setText("UMUR:");
        text_errorNIKUser.add(text_umurUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, -1, -1));

        text_noUser.setBackground(new java.awt.Color(0, 0, 0));
        text_noUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        text_noUser.setText("NO HP:");
        text_errorNIKUser.add(text_noUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        field_noUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_noUserActionPerformed(evt);
            }
        });
        field_noUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_noUserKeyPressed(evt);
            }
        });
        text_errorNIKUser.add(field_noUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 280, 40));

        text_namaUser.setBackground(new java.awt.Color(0, 0, 0));
        text_namaUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        text_namaUser.setText("NAMA:");
        text_errorNIKUser.add(text_namaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        tabelKostumer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "GENDER", "NIK", "NO HP", "UMUR", "ALAMAT"
            }
        ));
        tabelKostumer.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabelKostumerAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tabelKostumer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKostumerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelKostumer);

        text_errorNIKUser.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 810, 180));

        teks_genderUser.setBackground(new java.awt.Color(0, 0, 0));
        teks_genderUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        teks_genderUser.setText("GENDER:");
        text_errorNIKUser.add(teks_genderUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        field_namaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_namaUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(field_namaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 280, 40));

        field_nikUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_nikUserActionPerformed(evt);
            }
        });
        field_nikUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_nikUserKeyPressed(evt);
            }
        });
        text_errorNIKUser.add(field_nikUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 280, 40));

        field_alamatUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_alamatUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(field_alamatUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 280, 40));

        field_umurUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_umurUserActionPerformed(evt);
            }
        });
        field_umurUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_umurUserKeyPressed(evt);
            }
        });
        text_errorNIKUser.add(field_umurUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 280, 40));

        field_idUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_idUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(field_idUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 280, 40));

        button_simpanUser.setBackground(new java.awt.Color(153, 255, 255));
        button_simpanUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        button_simpanUser.setText("SIMPAN");
        button_simpanUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_simpanUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(button_simpanUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, -1, -1));

        button_ubahUser.setBackground(new java.awt.Color(153, 255, 255));
        button_ubahUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        button_ubahUser.setText("UBAH");
        button_ubahUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ubahUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(button_ubahUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));

        button_hapusUser.setBackground(new java.awt.Color(153, 255, 255));
        button_hapusUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        button_hapusUser.setText("HAPUS");
        button_hapusUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_hapusUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(button_hapusUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, -1));

        button_batalUser.setBackground(new java.awt.Color(153, 255, 255));
        button_batalUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        button_batalUser.setText("CLEAR");
        button_batalUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_batalUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(button_batalUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, -1));

        jLabel9.setText("TABEL");
        text_errorNIKUser.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        fiel_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki Laki", "Perempuan" }));
        fiel_gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiel_genderActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(fiel_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 280, 30));

        jLabel3.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 24)); // NOI18N
        jLabel3.setText("KOSTUMER MANAJEMEN");
        text_errorNIKUser.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        panelKanan.add(text_errorNIKUser, "card4");

        transaksiPanel.setBackground(new java.awt.Color(102, 204, 255));
        transaksiPanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        transaksiPanel.setMinimumSize(new java.awt.Dimension(914, 587));
        transaksiPanel.setPreferredSize(new java.awt.Dimension(914, 587));

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "nama", "nik", "umur", "hp", "alamat", "bus", "asal", "tujuan", "harga", "tanggal"
            }
        ));
        tabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTransaksiMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelTransaksi);

        jLabel15.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 36)); // NOI18N
        jLabel15.setText("TRANSAKSI HISTORI");

        javax.swing.GroupLayout transaksiPanelLayout = new javax.swing.GroupLayout(transaksiPanel);
        transaksiPanel.setLayout(transaksiPanelLayout);
        transaksiPanelLayout.setHorizontalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addGroup(transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(transaksiPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(transaksiPanelLayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel15)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        transaksiPanelLayout.setVerticalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel15)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelKanan.add(transaksiPanel, "card5");

        panelRute.setBackground(new java.awt.Color(102, 204, 255));
        panelRute.setMaximumSize(new java.awt.Dimension(1280, 720));
        panelRute.setMinimumSize(new java.awt.Dimension(914, 587));
        panelRute.setPreferredSize(new java.awt.Dimension(914, 587));
        panelRute.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel10.setText("ID RUTE:");
        panelRute.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel11.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel11.setText("TUJUAN:");
        panelRute.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel12.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel12.setText("BUS:");
        panelRute.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel13.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        panelRute.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel14.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel14.setText("ASAL:");
        panelRute.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel16.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel16.setText("HARGA:");
        panelRute.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, -1));

        jLabel17.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel17.setText("JUMLAH KURSI:");
        panelRute.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));
        panelRute.add(ruteField_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 230, 30));

        ruteField_id.setText("ID0");
        ruteField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruteField_idActionPerformed(evt);
            }
        });
        panelRute.add(ruteField_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 230, 30));

        ruteField_Asal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruteField_AsalActionPerformed(evt);
            }
        });
        panelRute.add(ruteField_Asal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 230, 30));
        panelRute.add(ruteField_Tujuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 230, 30));
        panelRute.add(ruteField_kursi, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 230, 30));

        ruteCombo_maskapai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PT. SINAR JAYA MEGAH LANGGENG", "PT. BIG BIRD PUSAKA", "PT. PRIMAJASA PERDANARAYAUTAMA", "PT. SINAR JAYA LANGGENG UTAMA", "PT. ARIMBI JAYA AGUNG", " ", " ", " ", " " }));
        ruteCombo_maskapai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruteCombo_maskapaiActionPerformed(evt);
            }
        });
        panelRute.add(ruteCombo_maskapai, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 230, 30));

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("SIMPAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelRute.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, -1, -1));

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelRute.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, -1, -1));

        jButton3.setBackground(new java.awt.Color(153, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("HAPUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelRute.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, -1, -1));

        jButton4.setBackground(new java.awt.Color(153, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("RESET");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelRute.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, -1, -1));

        TabelRute.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID RUTE", "BUS", "ASAL", "TUJUAN", "KURSI", "HARGA"
            }
        ));
        TabelRute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelRuteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TabelRute);

        panelRute.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 790, 120));

        jLabel18.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 36)); // NOI18N
        jLabel18.setText("PANEL RUTE");
        panelRute.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        panelKanan.add(panelRute, "card7");

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(panelKiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelKanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelKiri, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
            .addComponent(panelKanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transaksiMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiMenuActionPerformed
       // TODO add your handling code here:
        //dynamic panel
        // remove panel sebelumnya
        panelKanan.removeAll();
        panelKanan.repaint();
        panelKanan.revalidate();
        //repaint panel sebelumnya
        panelKanan.add(transaksiPanel);
        panelKanan.repaint();
        panelKanan.revalidate();
        
    }//GEN-LAST:event_transaksiMenuActionPerformed

    private void kostumerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kostumerMenuActionPerformed
        // TODO add your handling code here:
        //dynamic panel
        // remove panel sebelumnya
        panelKanan.removeAll();
        panelKanan.repaint();
        panelKanan.revalidate();
        //repaint panel sebelumnya
        panelKanan.add(text_errorNIKUser);
        panelKanan.repaint();
        panelKanan.revalidate();
    }//GEN-LAST:event_kostumerMenuActionPerformed

    private void bookingMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingMenuActionPerformed
        // TODO add your handling code here:
        //dynamic panel
        // remove panel sebelumnya
        panelKanan.removeAll();
        panelKanan.repaint();
        panelKanan.revalidate();
        //repaint panel sebelumnya
        panelKanan.add(bookingPanel);
        panelKanan.repaint();
        panelKanan.revalidate();
    }//GEN-LAST:event_bookingMenuActionPerformed

    private void homeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeMenuActionPerformed
        // TODO add your handling code here:
        //dynamic panel
        // remove panel sebelumnya
        panelKanan.removeAll();
        panelKanan.repaint();
        panelKanan.revalidate();
        //repaint panel sebelumnya
        panelKanan.add(homePanel);
        panelKanan.repaint();
        panelKanan.revalidate();
    }//GEN-LAST:event_homeMenuActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed

        int pesan = JOptionPane.showConfirmDialog(null, "Yakin Ingin Logout ? ","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(pesan == JOptionPane.YES_OPTION){
            setVisible(false);
            login_form login = new login_form();
            login.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void field_noUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_noUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_noUserActionPerformed

    private void field_namaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_namaUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_namaUserActionPerformed

    private void field_nikUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nikUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nikUserActionPerformed

    private void field_alamatUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_alamatUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_alamatUserActionPerformed

    private void field_umurUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_umurUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_umurUserActionPerformed

    private void field_idUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_idUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_idUserActionPerformed

    private void field_noUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_noUserKeyPressed
        // TODO add your handling code here:
        if(field_noUser.getText().length()>=12){
            field_noUser.setText(field_noUser.getText().substring(0, 11));
  
        }
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            field_noUser.setEditable(false);
        }
        else{
            field_noUser.setEditable(true);
        }
    }//GEN-LAST:event_field_noUserKeyPressed

    private void field_nikUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_nikUserKeyPressed
        // TODO add your handling code here:
        if(field_nikUser.getText().length()>=16){
            field_nikUser.setText(field_nikUser.getText().substring(0, 15));
  
        }
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            field_nikUser.setEditable(false);
        }
        else{
            field_nikUser.setEditable(true);
        }
    }//GEN-LAST:event_field_nikUserKeyPressed

    private void field_umurUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_umurUserKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            field_umurUser.setEditable(false);
        }
        else{
            field_umurUser.setEditable(true);
        }
    }//GEN-LAST:event_field_umurUserKeyPressed

    private void button_simpanUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_simpanUserActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO kostumer VALUES('"+field_idUser.getText()+"','"+field_namaUser.getText()+"','"+field_nikUser.getText()+"','"+field_umurUser.getText()+"','"+field_noUser.getText()+"','"+field_alamatUser.getText()+"','"+fiel_gender.getSelectedItem()+"')";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            load_table();
            kosongKostumer();
        }  catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_button_simpanUserActionPerformed

    private void fiel_genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiel_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fiel_genderActionPerformed

    private void tabelKostumerAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabelKostumerAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelKostumerAncestorAdded

    private void tabelKostumerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKostumerMouseClicked
        // TODO add your handling code here:
        int baris = tabelKostumer.rowAtPoint(evt.getPoint());
        String idUser =tabelKostumer.getValueAt(baris, 0).toString();
        field_idUser.setText(idUser);
        
        String namaUser =tabelKostumer.getValueAt(baris, 1).toString();
        field_namaUser.setText(namaUser);
        
        String gender =tabelKostumer.getValueAt(baris, 6).toString();
        fiel_gender.setSelectedItem(gender);
        
        String nikUser =tabelKostumer.getValueAt(baris, 2).toString();
        field_nikUser.setText(nikUser);
        
        String noHPUser =tabelKostumer.getValueAt(baris, 4).toString();
        field_noUser.setText(noHPUser);
        
        String umurUser =tabelKostumer.getValueAt(baris, 3).toString();
        field_umurUser.setText(umurUser);
        
        String alamatUser =tabelKostumer.getValueAt(baris, 5).toString();
        field_alamatUser.setText(alamatUser);
    }//GEN-LAST:event_tabelKostumerMouseClicked

    private void button_ubahUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ubahUserActionPerformed
        // TODO add your handling code here:
        try {
            String sql ="UPDATE kostumer SET id_kostumer = '"+field_idUser.getText()+"', nama_kostumer = '"+field_namaUser.getText()+"',nik_kostumer= '"+field_nikUser.getText()+"',umur_kostumer = '"+field_umurUser.getText()+"',no_kostumer= '"+field_noUser.getText()+"',alamat_kostumer= '"+field_alamatUser.getText()+"', jk_kostumer = '"+fiel_gender.getSelectedItem()+"' WHERE id_kostumer = '"+field_idUser.getText()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
        load_table();
        kosongKostumer();
    }//GEN-LAST:event_button_ubahUserActionPerformed

    private void button_hapusUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_hapusUserActionPerformed
        // TODO add your handling code here:
        try {
            String sql ="delete from kostumer where id_kostumer='"+field_idUser.getText()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table();
        kosongKostumer();
    }//GEN-LAST:event_button_hapusUserActionPerformed

    private void ruteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruteMenuActionPerformed
        // TODO add your handling code here:
        panelKanan.removeAll();
        panelKanan.repaint();
        panelKanan.revalidate();
        //repaint panel sebelumnya
        panelKanan.add(panelRute);
        panelKanan.repaint();
        panelKanan.revalidate();
    }//GEN-LAST:event_ruteMenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO rute VALUES ('"+ruteField_id.getText()+"','"+ruteCombo_maskapai.getSelectedItem()+"','"+ruteField_Asal.getText()+"','"+ruteField_Tujuan.getText()+"','"+ruteField_kursi.getText()+"','"+ruteField_harga.getText()+"')";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            load_table_rute();
            kosongRute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            String sql ="UPDATE rute SET id_rute = '"+ruteField_id.getText()+"', maskapai = '"+ruteCombo_maskapai.getSelectedItem()+"', asal = '"+ruteField_Asal.getText()+"', tujuan= '"+ruteField_Tujuan.getText()+"',jlhKursi= '"+ruteField_kursi.getText()+"',harga= '"+ruteField_harga.getText()+"' WHERE id_rute = '"+ruteField_id.getText()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
            load_table_rute();
            kosongRute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TabelRuteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelRuteMouseClicked
        // TODO add your handling code here:
        int baris = TabelRute.rowAtPoint(evt.getPoint());
        
        String idRute =TabelRute.getValueAt(baris, 0).toString();
        ruteField_id.setText(idRute);
        
        String namaMaskapai =TabelRute.getValueAt(baris, 1).toString();
        ruteCombo_maskapai.setSelectedItem(namaMaskapai);
        
        String asalRute =TabelRute.getValueAt(baris, 2).toString();
        ruteField_Asal.setText(asalRute);
        
        String tujuanRute = TabelRute.getValueAt(baris, 3).toString();
        ruteField_Tujuan.setText(tujuanRute);
        
        String kursiRute = TabelRute.getValueAt(baris, 4).toString();
        ruteField_kursi.setText(kursiRute);
        
        String hargaRute = TabelRute.getValueAt(baris, 5).toString();
        ruteField_harga.setText(hargaRute);
 
        
    }//GEN-LAST:event_TabelRuteMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            String sql ="delete from rute where id_rute='"+ruteField_id.getText()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
            load_table_rute();
            kosongRute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void button_batalUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_batalUserActionPerformed
        // TODO add your handling code here:
        kosongKostumer();
    }//GEN-LAST:event_button_batalUserActionPerformed

    private void bookingNIKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingNIKActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_bookingNIKActionPerformed

    private void bookingNIKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingNIKMouseClicked
         //TODO add your handling code here:
        
    }//GEN-LAST:event_bookingNIKMouseClicked

    private void bookingUmurKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookingUmurKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookingUmurKeyPressed

    private void bookingUmurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingUmurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookingUmurActionPerformed

    private void bookingUmurMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingUmurMouseDragged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bookingUmurMouseDragged

    private void bookingUmurMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingUmurMouseEntered
        // TODO add your handling code here:
        try {
            ResultSet rs =null;
            String sql = "SELECT umur_kostumer from kostumer where nama_kostumer ='"+bookingUsername.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("umur_kostumer");
                bookingUmur.setText(nama);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bookingUmurMouseEntered

    private void bookingNIKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingNIKMouseEntered
        // TODO add your handling code here:
        try {
            ResultSet rs =null;
            String sql = "SELECT nik_kostumer from kostumer where nama_kostumer ='"+bookingUsername.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("nik_kostumer");
                bookingNIK.setText(nama);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bookingNIKMouseEntered

    private void bookingHPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingHPMouseEntered
        // TODO add your handling code here:
        try {
            ResultSet rs =null;
            String sql = "SELECT no_kostumer from kostumer where nama_kostumer ='"+bookingUsername.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("no_kostumer");
                bookingHP.setText("0"+nama);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bookingHPMouseEntered

    private void bookingAlamatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingAlamatMouseEntered
        // TODO add your handling code here:
        try {
            ResultSet rs =null;
            String sql = "SELECT alamat_kostumer from kostumer where nama_kostumer ='"+bookingUsername.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("alamat_kostumer");
                bookingAlamat.setText(nama);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bookingAlamatMouseEntered

    private void asalBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asalBookingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asalBookingActionPerformed

    private void asalBookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asalBookingMouseEntered
        // TODO add your handling code here:
        asalBooking.removeAllItems();
         try {
            ResultSet rs =null;
            String sql = "SELECT * from rute where maskapai = '"+maskapaiBooking.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String nama = rs.getString("asal");
                asalBooking.addItem(nama);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_asalBookingMouseEntered

    private void ruteField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruteField_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ruteField_idActionPerformed

    private void ruteField_AsalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruteField_AsalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ruteField_AsalActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        kosongRute();
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tujuanBookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tujuanBookingMouseEntered
        // TODO add your handling code here:
        tujuanBooking.removeAllItems();
         try {
            ResultSet rs =null;
            String sql = "SELECT * from rute where maskapai = '"+maskapaiBooking.getSelectedItem()+"' and asal='"+asalBooking.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String nama = rs.getString("tujuan");
              tujuanBooking.addItem(nama);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tujuanBookingMouseEntered

    private void hargaBookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hargaBookingMouseEntered
        // TODO add your handling code here:
        try {
            ResultSet rs =null;
            String sql = "SELECT harga from rute where maskapai ='"+maskapaiBooking.getSelectedItem()+"' and asal = '"+asalBooking.getSelectedItem()+"' and tujuan = '"+tujuanBooking.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("harga");
                hargaBooking.setText(nama);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_hargaBookingMouseEntered

    private void tanggalTesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tanggalTesMouseEntered
        // TODO add your handling code here:
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(tanggalBooking.getDate()));
       tanggalTes.setText(tanggal);
    }//GEN-LAST:event_tanggalTesMouseEntered

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO transaksi VALUES ('"+idBooking.getText()+"','"+bookingUsername.getSelectedItem()+"','"+bookingNIK.getText()+"','"+bookingUmur.getText()+"','"+bookingHP.getText()+"','"+bookingAlamat.getText()+"','"+maskapaiBooking.getSelectedItem()+"','"+asalBooking.getSelectedItem()+"','"+tujuanBooking.getSelectedItem()+"','"+hargaBooking.getText()+"','"+tanggalTes.getText()+"')";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "PEMESANAN BERHASIL");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTransaksiMouseClicked
        // TODO add your handling code here:
     int baris = tabelTransaksi.rowAtPoint(evt.getPoint());
        String nama =tabelTransaksi.getValueAt(baris, 1).toString();
        
        String nim = tabelTransaksi.getValueAt(baris,2).toString();
        JOptionPane.showMessageDialog(rootPane, "cetak transaksi sedang dikerjakan");
    }//GEN-LAST:event_tabelTransaksiMouseClicked

    private void ruteCombo_maskapaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruteCombo_maskapaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ruteCombo_maskapaiActionPerformed

    private void bookingUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookingUsernameActionPerformed

    private void idBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idBookingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idBookingActionPerformed
    
     
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelRute;
    private javax.swing.JComboBox<String> asalBooking;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JTextArea bookingAlamat;
    private javax.swing.JTextField bookingHP;
    private javax.swing.JButton bookingMenu;
    private javax.swing.JTextField bookingNIK;
    private javax.swing.JPanel bookingPanel;
    private javax.swing.JTextField bookingUmur;
    private javax.swing.JComboBox<String> bookingUsername;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton button_batalUser;
    private javax.swing.JButton button_hapusUser;
    private javax.swing.JButton button_simpanUser;
    private javax.swing.JButton button_ubahUser;
    private javax.swing.JComboBox<String> fiel_gender;
    private javax.swing.JTextField field_alamatUser;
    private javax.swing.JTextField field_idUser;
    private javax.swing.JTextField field_namaUser;
    private javax.swing.JTextField field_nikUser;
    private javax.swing.JTextField field_noUser;
    private javax.swing.JTextField field_umurUser;
    private javax.swing.JTextField hargaBooking;
    private javax.swing.JButton homeMenu;
    private javax.swing.JPanel homePanel;
    private javax.swing.JTextField idBooking;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton kostumerMenu;
    private javax.swing.JButton logout;
    private javax.swing.JComboBox<String> maskapaiBooking;
    private javax.swing.JPanel panelKanan;
    private javax.swing.JPanel panelKiri;
    private javax.swing.JPanel panelRute;
    private javax.swing.JComboBox<String> ruteCombo_maskapai;
    private javax.swing.JTextField ruteField_Asal;
    private javax.swing.JTextField ruteField_Tujuan;
    private javax.swing.JTextField ruteField_harga;
    private javax.swing.JTextField ruteField_id;
    private javax.swing.JTextField ruteField_kursi;
    private javax.swing.JButton ruteMenu;
    private javax.swing.JTable tabelKostumer;
    public static javax.swing.JTable tabelTransaksi;
    private com.toedter.calendar.JDateChooser tanggalBooking;
    private javax.swing.JTextField tanggalTes;
    private javax.swing.JLabel teks_genderUser;
    private javax.swing.JLabel text_alamatUser;
    private javax.swing.JPanel text_errorNIKUser;
    private javax.swing.JLabel text_idUser;
    private javax.swing.JLabel text_namaUser;
    private javax.swing.JLabel text_nikUser;
    private javax.swing.JLabel text_noUser;
    private javax.swing.JLabel text_umurUser;
    private javax.swing.JButton transaksiMenu;
    private javax.swing.JPanel transaksiPanel;
    private javax.swing.JComboBox<String> tujuanBooking;
    // End of variables declaration//GEN-END:variables
}
  



