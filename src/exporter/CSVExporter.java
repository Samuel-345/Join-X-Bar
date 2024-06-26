/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exporter;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import model.Database;

public class CSVExporter implements Exporter {
    @Override
    public void export() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            String csvFile = fileToSave.getAbsolutePath();

            if (!csvFile.endsWith(".csv")) {
                csvFile += ".csv";
            }

            String sql = "SELECT * FROM member";

            try (Connection conn = Database.connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql);
                 FileWriter writer = new FileWriter(csvFile)) {

                writer.append("NIM,Nama,Kelas,Posisi\n");

                while (rs.next()) {
                    writer.append(rs.getString("nim")).append(",");
                    writer.append(rs.getString("nama")).append(",");
                    writer.append(rs.getString("kelas")).append(",");
                    writer.append(rs.getString("role")).append("\n");
                }
                JOptionPane.showMessageDialog(null, "Berhasil mengekspor ke file CSV!", "SUCCESS",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Gagal mengekspor ke file CSV!", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}