package project_database;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nguyen duy long
 */
public class Hoa_don extends javax.swing.JFrame {
    static private Tra_sach ts;
    static private String SPM;
    static private String ten_sach;
    static private String ma_sach;
    static private String ngay_muon;
    static private String ngay_tra;
    static private String gia_tien;
    static private String maDG;
    static Client client;
    static int pos;
    DateFormat dateFormat ;
    int tongsotien;
    int sotienphat;
    int tienhoadon;

    public Hoa_don(String madocgia,String tensach,String masach,String ngaymuon,String ngaytra,String giatien,String SPM,int pos,Client client,Tra_sach ts) {
        initComponents();
        this.ts = ts;
        this.SPM = SPM;
        this.pos = pos;
        this.client = client;
        this.ten_sach = tensach;
        this.ma_sach = masach;
        this.gia_tien = giatien;
        this.ngay_muon = ngaymuon;
        this.ngay_tra = ngaytra;
        this.maDG = madocgia;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	homnay.setText(dateFormat.format(date));
        setTitle("Trả sách");
        setResizable(false);
        Docgia.setText(madocgia);
        sachten.setText(tensach);
        sachma.setText(masach);
        muonngay.setText(ngaymuon);
        trangay.setText(ngaytra);
        tiensach.setText(giatien);
        Date d1,d2;
        try {
            d1 = dateFormat.parse(ngaymuon);
            d2 = dateFormat.parse(ngaytra);
            if((d2.getTime()-date.getTime())>0)
            {
                int day = (int) ((date.getTime()- d1.getTime())/(60*60*1000*24));
                tongsotien = (day *5) - Integer.parseInt(giatien);
                
            }
            else
            {
                int dunghan = (int) ((d2.getTime()- d1.getTime())/(60*60*1000*24) );
                int quahan = (int)((date.getTime()-d2.getTime())/(60*60*1000*24));
                tongsotien = (dunghan*5+quahan*10) - Integer.parseInt(giatien);
               
            }
            tongtien.setText(""+tongsotien);
                        
        } catch (ParseException ex) {
            Logger.getLogger(Hoa_don.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        trasachButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        tien_phat = new javax.swing.JTextField();
        sachma = new javax.swing.JLabel();
        sachten = new javax.swing.JLabel();
        muonngay = new javax.swing.JLabel();
        trangay = new javax.swing.JLabel();
        tiensach = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Docgia = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tongtien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        homnay = new javax.swing.JLabel();

        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        trasachButton.setText("Trả sách");
        trasachButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trasachButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã sách:");

        jLabel2.setText("Tên sách:");

        jLabel3.setText("Ngày mượn:");

        jLabel4.setText("Ngày trả:");

        jLabel5.setText("Giá tiền:");

        jCheckBox1.setText("Phạt tiền");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        tien_phat.setEnabled(false);

        jLabel11.setText("Số tiền phạt:");

        jLabel6.setText("Mã độc giả");

        jLabel7.setText("Tổng tiền thuê(chưa tính phạt):");

        jLabel9.setText("Ngày hôm nay:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(trasachButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tien_phat, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sachma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sachten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(muonngay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(trangay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Docgia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(homnay)
                                    .addComponent(tiensach, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel9});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {homnay, tiensach});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(Docgia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sachma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sachten)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(muonngay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trangay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tiensach)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(homnay))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tien_phat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(tongtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trasachButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Docgia, homnay, jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel9, muonngay, sachma, sachten, tiensach, trangay});

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected())
        {
            tien_phat.setEnabled(true);
            tien_phat.requestFocus();
        }
        else{
            tien_phat.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void trasachButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trasachButtonActionPerformed
        String mathedocgia = null;
        client.SEND("TraSach");
        String c;
        client.SEND(dateFormat.format(new Date()));
        mathedocgia = "TDG"+Docgia.getText().substring(2).trim();
        client.SEND(mathedocgia);
        if(tien_phat.isEnabled()) c = "1";
        else c="0";
        client.SEND(c);
        if(tien_phat.isEnabled())
        {
            sotienphat = Integer.parseInt(tien_phat.getText().toString());
            client.SEND(tien_phat.getText());
        }
        else{
            sotienphat = 0;
        }
        int tienthue = Integer.parseInt(tongtien.getText().toString());
        int thanhtoan = tienthue + sotienphat;
        tienhoadon = thanhtoan + Integer.parseInt(tiensach.getText().toString());
        if(thanhtoan >0)
        {
            JOptionPane.showMessageDialog(null, "Tổng tiền là :"+ thanhtoan);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Trả lại khách :" + (0-thanhtoan));
        }
        String query1 ="delete from \"PhieuThue\" where \"SoPhieuMuon\" ='"+SPM+"'";
        String query2 ="update \"Sach\" set \"SoLuong\" = \"SoLuong\"+1 where \"MaSach\" = '"+ma_sach+"'";
        client.SEND(query1);
        client.SEND(query2);
        client.SEND(String.valueOf(tienhoadon));
        for(int i =0; i<7;i++)
        {
            client.SachMuon.remove(pos*7);
        }
        ts.listmodel.remove(pos);
        this.dispose();                     
    }//GEN-LAST:event_trasachButtonActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        this.dispose();
    }//GEN-LAST:event_formWindowLostFocus
    
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
            java.util.logging.Logger.getLogger(Hoa_don.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hoa_don.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hoa_don.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hoa_don.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hoa_don(maDG,ten_sach,ma_sach,ngay_muon, ngay_tra,gia_tien,SPM,pos,client,ts).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Docgia;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel homnay;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel muonngay;
    private javax.swing.JLabel sachma;
    private javax.swing.JLabel sachten;
    private javax.swing.JTextField tien_phat;
    private javax.swing.JLabel tiensach;
    private javax.swing.JLabel tongtien;
    private javax.swing.JLabel trangay;
    private javax.swing.JButton trasachButton;
    // End of variables declaration//GEN-END:variables
}
