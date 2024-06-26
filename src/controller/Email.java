/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Email {
    // Method untuk mengirim email konfirmasi
    public void sendConfirmationEmail(String recipientEmail) {
        String senderEmail = "ssianturi345@gmail.com"; // Ganti dengan email Anda
        String senderPassword = "nbcwbwegvffbzhbd"; // Ganti dengan password email Anda
        String host = "smtp.gmail.com"; // Ganti dengan host SMTP Anda
        String subject = "Konfirmasi Email";
        String content = "Berhasil melakukan registrasi akun baru aplikasi Join X-Bar!";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587"); // Port SMTP, sesuaikan dengan provider Anda
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Konfirmasi email berhasil dikirim ke: " + recipientEmail,"REGISTRATION SUCCESS",JOptionPane.INFORMATION_MESSAGE);

        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengirim konfirmasi email: " + e.getMessage(), "FAILED", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Method untuk mengirim email konfirmasi
    public void sendRoleUpdateEmail(String recipientEmail) {
        String senderEmail = "ssianturi345@gmail.com"; // Ganti dengan email Anda
        String senderPassword = "nbcwbwegvffbzhbd"; // Ganti dengan password email Anda
        String host = "smtp.gmail.com"; // Ganti dengan host SMTP Anda
        String subject = "Perubahan Jadwal Seleksi X-Bar";
        String content = "Telah terjadi perubahan jadwal seleksi. Oleh karena itu, dimohon untuk mengecek jadwal seleksi masing-masing "
                + "di aplikasi Join X-Bar sekarang!";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587"); // Port SMTP, sesuaikan dengan provider Anda
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Pemberitahuan berhasil dikirim ke email para pendaftar.", "SUCCESS",JOptionPane.INFORMATION_MESSAGE);

        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengirim pemberitahuan email.", "FAILED", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}