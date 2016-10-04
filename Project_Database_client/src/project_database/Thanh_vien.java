/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_database;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowStateListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyen duy long
 */
public class Thanh_vien extends javax.swing.JPanel {

    /**
     * Creates new form Thanh_vien
     */
    Client client;
    InterFace inter;
    DefaultTableModel Tmodel= null;
    DefaultTableModel Usermodel = null;
    //Info_Change info_c;
    String s;
    String s1;
    public Thanh_vien(Client client,InterFace inter) {
        this.client= client;
        this.inter = inter;
        initComponents();
        nameView.setText(client.DocGia[1]);
        codeView.setText(client.DocGia[0]);
        sexView.setText(client.DocGia[2]);
        birthdayView.setText(client.DocGia[3]);
        emailView.setText(client.DocGia[4]);
        addressView.setText(client.DocGia[5]);
        phoneView.setText(client.DocGia[6]);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        nameView = new javax.swing.JLabel();
        codeView = new javax.swing.JLabel();
        sexView = new javax.swing.JLabel();
        birthdayView = new javax.swing.JLabel();
        emailView = new javax.swing.JLabel();
        addressView = new javax.swing.JLabel();
        phoneView = new javax.swing.JLabel();
        changeinfo_butt = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Độc giả "));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin độc giả", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        jPanel11.setLayout(new java.awt.GridLayout(0, 1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Họ tên người mượn :");
        jPanel11.add(jLabel14);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Mã người mượn :");
        jPanel11.add(jLabel15);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Giới tính :");
        jPanel11.add(jLabel16);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Ngày sinh :");
        jPanel11.add(jLabel17);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Email :");
        jPanel11.add(jLabel18);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Địa chỉ :");
        jPanel11.add(jLabel19);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Điện thoại :");
        jPanel11.add(jLabel20);

        jPanel13.setLayout(new java.awt.GridLayout(0, 1));
        jPanel13.add(nameView);
        jPanel13.add(codeView);
        jPanel13.add(sexView);
        jPanel13.add(birthdayView);
        jPanel13.add(emailView);
        jPanel13.add(addressView);
        jPanel13.add(phoneView);

        changeinfo_butt.setText("Thay đổi thông tin");
        changeinfo_butt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeinfo_buttActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(changeinfo_butt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                .addComponent(changeinfo_butt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void changeinfo_buttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeinfo_buttActionPerformed
        String tenDG,diaChi,ngaySinh,Code,Email,Phone,gioiTinh;
        tenDG = nameView.getText();
        diaChi = addressView.getText();
        ngaySinh = birthdayView.getText();
        Code = codeView.getText();
        Email = emailView.getText();
        Phone = phoneView.getText();
        gioiTinh = sexView.getText();
        Info_Change info_c;
        info_c = new Info_Change(client.DocGia[0],tenDG, diaChi, ngaySinh, gioiTinh, Email, Phone,client,this,inter);
        info_c.setVisible(true);
    }//GEN-LAST:event_changeinfo_buttActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel addressView;
    public static javax.swing.JLabel birthdayView;
    private javax.swing.JButton changeinfo_butt;
    public static javax.swing.JLabel codeView;
    public static javax.swing.JLabel emailView;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    public static javax.swing.JLabel nameView;
    public static javax.swing.JLabel phoneView;
    public static javax.swing.JLabel sexView;
    // End of variables declaration//GEN-END:variables
}
