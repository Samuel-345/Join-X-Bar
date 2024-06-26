/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Database;
import model.Member;
import view.Edit;
import view.Info;
import view.Jadwal;
import view.Tabel;

/**
 *
 * @author Lenovo
 */
public class Admin extends JFrame{
    
    public void refreshTable(DefaultTableModel dtm) {
            // Refresh tabel
            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }

            try (Connection conn = Database.connect()) {
                String sql = "SELECT nim, nama, kelas, role FROM member";
                try (PreparedStatement stmt = conn.prepareStatement(sql);
                     ResultSet rs = stmt.executeQuery()) {

                    // Isi tabel
                    while (rs.next()) {
                        String nim = rs.getString("nim");
                        String nama = rs.getString("nama");
                        String kelas = rs.getString("kelas");
                        String roles = rs.getString("role");
                        dtm.addRow(new Object[]{nim, nama, kelas, roles});
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
                JOptionPane.showMessageDialog(this, "Gagal mengambil data", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
    }
        
        public void searchTable(DefaultTableModel dtm, String filter) {
            // Refresh tabel
            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }

            Database db = new Database();
            try {
                String querySql = "SELECT * FROM member";
                if (filter != null && !filter.trim().isEmpty()) {
                    querySql += " WHERE role LIKE ?";
                }
                PreparedStatement pst = db.connect().prepareStatement(querySql);
                if (filter != null && !filter.trim().isEmpty()) {
                    pst.setString(1, "%" + filter + "%");
                }
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    String nim = rs.getString("nim");
                    String nama = rs.getString("nama");
                    String kelas = rs.getString("kelas");
                    String posisi = rs.getString("role");

                    dtm.addRow(new Object[]{nim, nama, kelas, posisi});
                }

            } catch (SQLException ex) {
                Logger.getLogger(Tabel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void loadJadwal(String role, JTextField field1, JTextField field2, JTextField field3) {
            String sql = "SELECT role, ruangan, waktu FROM jadwal WHERE role = ? ";

                try (Connection conn = Database.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, role);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {            
                        // Mengembalikan objek Member dengan data yang diambil
                        field1.setText(rs.getString("role"));
                        field2.setText(rs.getString("ruangan"));
                        field3.setText(rs.getString("waktu"));
                    } else {
                        JOptionPane.showMessageDialog(this, "Jadwal tidak ditemukan!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
        }
        
        public static void updateJadwal(String roleBaru, String role, String ruangan, String waktu ) throws SQLException {
                // Simpan ke database
                try (Connection conn = Database.connect()) {
                String sql = "UPDATE jadwal SET role = ?, ruangan = ?, waktu = ? WHERE role = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, roleBaru);
                    pstmt.setString(2, ruangan);
                    pstmt.setString(3, waktu);
                    pstmt.setString(4, role);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Jadwal berhasil diubah!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal mengubah jadwal!", "ERROR", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        
        public void clearForm(JTextField field1, JTextField field2, JTextField field3){
            field1.setText("");
            field2.setText("");
            field3.setText("");
        }
        
}