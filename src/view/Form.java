/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.Database;
import controller.Pendaftaran;
import model.Member;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author Lenovo
 */
public class Form extends javax.swing.JFrame implements Runnable  {
    
    public static String nim;
    public static String nama;
    public static String kelas;
    public static String role;
    private Pendaftaran pendaftaran;
    
    Thread T;
    boolean directionRight = true;
    int x, y;
    int xx, xy;

    /**
     * Creates new form Form
     */
    public Form() {
        initComponents();
        setLocationRelativeTo(null);
        pendaftaran = new Pendaftaran();
        
        x = labelFooter2.getX();
        y = labelFooter2.getY();
        T = new Thread(this);
        T.start();
    }
    
    @Override
    public void run(){
        while (true) {
            if (directionRight) {
                x++;
                if (x >= jPanel5.getWidth() - labelFooter2.getWidth()) {
                    directionRight = false;
                }
            } else {
                x--;
                if (x <= 0) {
                    directionRight = true;
                }
            }
            labelFooter2.setLocation(x, y);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Home2.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        labelFooter = new javax.swing.JLabel();
        labelFooter1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        labelLogin1 = new javax.swing.JLabel();
        buttonHome = new javax.swing.JButton();
        buttonDaftar1 = new javax.swing.JButton();
        buttonLogout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        buttonClose = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelRegister = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelNIM = new javax.swing.JLabel();
        fieldNIM = new javax.swing.JTextField();
        labelNama = new javax.swing.JLabel();
        fieldNama = new javax.swing.JTextField();
        labelKelas = new javax.swing.JLabel();
        fieldKelas = new javax.swing.JTextField();
        labelConfirmPassword = new javax.swing.JLabel();
        labelConfirmPassword1 = new javax.swing.JLabel();
        roleComboBox = new javax.swing.JComboBox<>();
        buttonDaftar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        labelFooter2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelFooter.setBackground(new java.awt.Color(51, 204, 255));
        labelFooter.setFont(new java.awt.Font("Bernard MT Condensed", 0, 12)); // NOI18N
        labelFooter.setForeground(new java.awt.Color(255, 255, 255));
        labelFooter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFooter.setText("Copyright © by Samuel Marvelius Sianturi");
        labelFooter.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelFooter1.setBackground(new java.awt.Color(51, 204, 255));
        labelFooter1.setFont(new java.awt.Font("Bernard MT Condensed", 0, 12)); // NOI18N
        labelFooter1.setForeground(new java.awt.Color(255, 255, 255));
        labelFooter1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFooter1.setText("Copyright © by Samuel Marvelius Sianturi");
        labelFooter1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelFooter)
                .addGap(161, 161, 161))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(labelFooter1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelFooter))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(labelFooter1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_xbar.jpeg"))); // NOI18N

        labelLogin1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        labelLogin1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogin1.setText("JOIN X-BAR");

        buttonHome.setBackground(new java.awt.Color(0, 0, 0));
        buttonHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonHome.setForeground(new java.awt.Color(255, 255, 255));
        buttonHome.setText("HOME");
        buttonHome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHomeActionPerformed(evt);
            }
        });

        buttonDaftar1.setBackground(new java.awt.Color(0, 0, 0));
        buttonDaftar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonDaftar1.setForeground(new java.awt.Color(255, 255, 255));
        buttonDaftar1.setText("DAFTAR");
        buttonDaftar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonDaftar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDaftar1ActionPerformed(evt);
            }
        });

        buttonLogout.setBackground(new java.awt.Color(255, 51, 51));
        buttonLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonLogout.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogout.setText("LOGOUT");
        buttonLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDaftar1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelLogin1)
                .addGap(18, 18, 18)
                .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDaftar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 469));

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setBackground(new java.awt.Color(51, 204, 255));
        jLabel10.setFont(new java.awt.Font("Bernard MT Condensed", 1, 20)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-form-24.png"))); // NOI18N
        jLabel10.setText("FORM   DAFTAR");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        buttonClose.setBackground(new java.awt.Color(255, 51, 51));
        buttonClose.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        buttonClose.setText("X");
        buttonClose.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        minimize.setBackground(new java.awt.Color(204, 204, 204));
        minimize.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        minimize.setText("-");
        minimize.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(minimize, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonClose)
                .addComponent(minimize))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 0, 376, -1));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRegister.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        labelRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRegister.setText("PENDAFTARAN");
        jPanel2.add(labelRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 26, 370, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-drum-65.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-piano-65.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 60, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-mic-65.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-guitar-65.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 10, 60, 60));

        labelNIM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelNIM.setText("NIM :");
        jPanel2.add(labelNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 70, -1, -1));

        fieldNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNIMActionPerformed(evt);
            }
        });
        fieldNIM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNIMKeyTyped(evt);
            }
        });
        jPanel2.add(fieldNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 86, 194, 28));

        labelNama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelNama.setText("Nama Lengkap:");
        jPanel2.add(labelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 132, -1, -1));

        fieldNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNamaKeyTyped(evt);
            }
        });
        jPanel2.add(fieldNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 148, 194, 28));

        labelKelas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelKelas.setText("Kelas :");
        jPanel2.add(labelKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 194, -1, -1));

        fieldKelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldKelasKeyTyped(evt);
            }
        });
        jPanel2.add(fieldKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 210, 194, 28));

        labelConfirmPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelConfirmPassword.setText("Ingin mendaftar sebagai :");
        jPanel2.add(labelConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 256, -1, -1));

        labelConfirmPassword1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        labelConfirmPassword1.setText("(Pilih salah satu)");
        jPanel2.add(labelConfirmPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 272, 135, 25));

        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vokalis", "Piano", "Drumer", "Gitaris", "Bassis" }));
        jPanel2.add(roleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 297, 194, 28));

        buttonDaftar.setBackground(new java.awt.Color(51, 255, 51));
        buttonDaftar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonDaftar.setText("Daftar");
        buttonDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDaftarActionPerformed(evt);
            }
        });
        jPanel2.add(buttonDaftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 109, 35));

        jPanel5.setBackground(new java.awt.Color(51, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelFooter2.setBackground(new java.awt.Color(51, 204, 255));
        labelFooter2.setFont(new java.awt.Font("Bernard MT Condensed", 2, 10)); // NOI18N
        labelFooter2.setForeground(new java.awt.Color(255, 255, 255));
        labelFooter2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFooter2.setText("Copyright © by Samuel Marvelius Sianturi");
        labelFooter2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(labelFooter2)
                .addGap(104, 104, 104))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelFooter2))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 420, 380, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/form_bg.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 420));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 32, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDaftarActionPerformed

    if (fieldNIM.getText().equals("") || fieldNama.getText().equals("") || fieldKelas.getText().equals("") ) {
            JOptionPane.showMessageDialog(this, "Semua harus diisi!", "WARNING", JOptionPane.ERROR_MESSAGE);
            return;
        }
    else {
        String nim = fieldNIM.getText();
        String nama = fieldNama.getText();
        String kelas = fieldKelas.getText();
        String role = roleComboBox.getSelectedItem().toString();
        Member member = new Member(nim, nama, kelas, role);
        
        try {
            // melakukan pendaftaran member
            pendaftaran.insertMember(member);
            pendaftaran.clearForm(fieldNIM, fieldNama, fieldKelas, roleComboBox);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_buttonDaftarActionPerformed

    private void fieldNIMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNIMKeyTyped
        // TODO add your handling code here:
        // Mendapatkan karakter yang diketik
        char c = evt.getKeyChar();

        // Memeriksa apakah panjang teks melebihi 20 atau karakter bukan huruf/angka
        if (fieldNIM.getText().length() >= 20 || !Character.isDigit(c)) {
            evt.consume(); // Membatalkan aksi jika tidak sesuai kriteria
        }
    }//GEN-LAST:event_fieldNIMKeyTyped

    private void fieldNamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaKeyTyped
        // TODO add your handling code here:
        // Mendapatkan karakter yang diketik
    char c = evt.getKeyChar();

    // Memeriksa apakah panjang teks melebihi 20 atau karakter bukan huruf/angka
    if (fieldNama.getText().length() >= 100 || !Character.isLetter(c)) {
        evt.consume(); // Membatalkan aksi jika tidak sesuai kriteria
    }
    }//GEN-LAST:event_fieldNamaKeyTyped

    private void fieldKelasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldKelasKeyTyped
        // TODO add your handling code here:
        // Mendapatkan karakter yang diketik
    char c = evt.getKeyChar();

    // Memeriksa apakah panjang teks melebihi 20 atau karakter bukan huruf/angka
    if (fieldKelas.getText().length() >= 20 || !Character.isLetterOrDigit(c)) {
        evt.consume(); // Membatalkan aksi jika tidak sesuai kriteria
    }
    }//GEN-LAST:event_fieldKelasKeyTyped

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        // TODO add your handling code here:

        // menuju ke home
        Home hm = new Home();
        hm.setVisible(true);
        hm.pack();
        hm.setLocationRelativeTo(null);
        hm.setDefaultCloseOperation(Form.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void buttonDaftar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDaftar1ActionPerformed
        // TODO add your handling code here:
        // menuju ke halaman form
        Form form = new Form();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_buttonDaftar1ActionPerformed

    private void buttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogoutActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"Berhasil Logout!","LOGOUT SUCCES",JOptionPane.INFORMATION_MESSAGE);
        // menuju ke halaman login
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_buttonLogoutActionPerformed

    private void fieldNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNIMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNIMActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        // TODO add your handling code here:
        System.exit(0); // close window
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        // TODO add your handling code here:
        this.setState(1); // minimize window
    }//GEN-LAST:event_minimizeActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_formMouseDragged
     
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
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonDaftar;
    private javax.swing.JButton buttonDaftar1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton buttonHome;
    private javax.swing.JButton buttonLogout;
    private javax.swing.JTextField fieldKelas;
    private javax.swing.JTextField fieldNIM;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labelConfirmPassword;
    private javax.swing.JLabel labelConfirmPassword1;
    private javax.swing.JLabel labelFooter;
    private javax.swing.JLabel labelFooter1;
    private javax.swing.JLabel labelFooter2;
    private javax.swing.JLabel labelKelas;
    private javax.swing.JLabel labelLogin1;
    private javax.swing.JLabel labelNIM;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelRegister;
    private javax.swing.JButton minimize;
    private javax.swing.JComboBox<String> roleComboBox;
    // End of variables declaration//GEN-END:variables

}