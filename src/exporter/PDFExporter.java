/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exporter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Database;

public class PDFExporter implements Exporter {
    @Override
    public void export() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            String pdfFile = fileToSave.getAbsolutePath();

            if (!pdfFile.endsWith(".pdf")) {
                pdfFile += ".pdf";
            }

            String sql = "SELECT * FROM member";

            try (Connection conn = Database.connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
                document.open();

                PdfPTable table = new PdfPTable(4); // 4 kolom dalam tabel
                // Menambahkan header tabel
                table.addCell("NIM");
                table.addCell("Nama");
                table.addCell("Kelas");
                table.addCell("Posisi");

                // Menambahkan data dari ResultSet ke tabel
                while (rs.next()) {
                    table.addCell(rs.getString("nim"));
                    table.addCell(rs.getString("nama"));
                    table.addCell(rs.getString("kelas"));
                    table.addCell(rs.getString("role"));
                }

                document.add(table);
                JOptionPane.showMessageDialog(null, "Berhasil mengekspor ke file PDF!", "SUCCESS",
                        JOptionPane.INFORMATION_MESSAGE);

                document.close();
            } catch (DocumentException | FileNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Gagal mengekspor ke file PDF!", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }    
    }

}