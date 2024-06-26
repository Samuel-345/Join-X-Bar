/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Member;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Database;
import static model.Database.connect;
import view.Edit;
import static view.Edit.nim;
import view.Form;
import view.Home;
import view.Home2;
import view.Info;
import view.Tabel;

/**
 *
 * @author Lenovo
 */
public class Pendaftaran extends JFrame {
    
        public void insertMember(Member member) throws SQLException {
            String sql="INSERT INTO member (nim, nama, kelas, role) VALUES (?,?,?,?)";
            try{ Connection conn = Database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, member.getNim());
                pstmt.setString(2, member.getNama());
                pstmt.setString(3, member.getKelas());
                pstmt.setString(4, String.join(", ", member.getRole()));
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                            //masuk ke halaman info
                            Info info = new Info(member.getRole(), member.getNim(), member.getNama(),member.getKelas());
                            info.setVisible(true);
                            info.pack();
                            info.setLocationRelativeTo(null);
                            info.setDefaultCloseOperation(Form.EXIT_ON_CLOSE);

            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Gagal menyimpan data!", "ERROR", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        
        public static void updateMember(String nim, Member member) throws SQLException {
                // Simpan ke database
                try (Connection conn = Database.connect()) {
                String sql = "UPDATE member SET nim = ?, nama = ?, kelas = ?, role = ? WHERE nim = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, member.getNim());
                    pstmt.setString(2, member.getNama());
                    pstmt.setString(3, member.getKelas());
                    pstmt.setString(4, String.join(", ", member.getRole()));
                    pstmt.setString(5, nim);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                    //masuk ke halaman info
                    Info info = new Info(member.getRole(), member.getNim(), member.getNama(),member.getKelas());
                    info.setVisible(true);
                    info.pack();
                    info.setLocationRelativeTo(null);
                    info.setDefaultCloseOperation(Edit.EXIT_ON_CLOSE); 
                   
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal menyimpan data!", "ERROR", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        
        public void loadMemberData(String nim, JTextField field1, JTextField field2, JTextField field3) {
            String sql = "SELECT nim, nama, kelas FROM member WHERE nim = ? ";

                try (Connection conn = Database.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, nim);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {            
                        // Mengembalikan objek Member dengan data yang diambil
                        field1.setText(rs.getString("nim"));
                        field2.setText(rs.getString("nama"));
                        field3.setText(rs.getString("kelas"));
                    } else {
                        JOptionPane.showMessageDialog(this, "Member tidak ditemukan!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
        }
        
        public void clearForm(JTextField field1, JTextField field2, JTextField field3, 
                JComboBox<String> field4){
            field1.setText("");
            field2.setText("");
            field3.setText("");
            field4.setSelectedIndex(-1);
        }
        
        public void ruangan(JLabel label1, JLabel label2, JLabel label3) {
            String sql = "SELECT role, ruangan, waktu FROM jadwal WHERE role = ? ";

                try (Connection conn = Database.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, label1.getText());
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {            
                        // Mengembalikan objek Member dengan data yang diambil
                        label1.setText(rs.getString("role"));
                        label2.setText(rs.getString("ruangan"));
                        label3.setText(rs.getString("waktu"));
                    } else {
                        JOptionPane.showMessageDialog(this, "Member tidak ditemukan!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
        }
    
}