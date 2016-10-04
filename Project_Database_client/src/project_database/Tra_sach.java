package project_database;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Tra_sach extends javax.swing.JPanel {
    ImageIcon icon = new ImageIcon();
    DefaultListModel<String> listmodel = new DefaultListModel<>();
    Client client;
    Hoa_don hd ;
    String giatien;
    String SPM;
    int pos;
    public Tra_sach(Client client) {
        initComponents();
        this.client = client;
        jLabel1.setSize(200,100);
        new Set_picture().setPicture2(jLabel1, "user//user_face.png");
        getInfo();
    }
    private void getInfo()
    {
        L_Name.setText(client.DocGia[1]);
        L_address.setText(client.DocGia[5]);
        L_birthday.setText(client.DocGia[3]);
        L_code.setText(client.DocGia[0]);
        L_email.setText(client.DocGia[4]);
        L_phoneNum.setText(client.DocGia[6]);
        L_sex.setText(client.DocGia[2]);
        listmodel.removeAllElements();
        for(int i=0;i<client.SachMuon.size();i+=7)
        {
            listmodel.addElement(client.SachMuon.get(i));
        }
        list_book.setModel(listmodel);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_book = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ten_sach = new javax.swing.JLabel();
        ma_sach = new javax.swing.JLabel();
        ngay_muon = new javax.swing.JLabel();
        ngay_tra = new javax.swing.JLabel();
        gia_sach = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null); //chieu nay cx bi nhung ko phai do final
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        L_Name = new javax.swing.JLabel();
        L_code = new javax.swing.JLabel();
        L_sex = new javax.swing.JLabel();
        L_birthday = new javax.swing.JLabel();
        L_email = new javax.swing.JLabel();
        L_address = new javax.swing.JLabel();
        L_phoneNum = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trả sách", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 592));

        list_book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_bookMouseClicked(evt);
            }
        });
        list_book.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                list_bookKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(list_book);

        jLabel3.setText("Tên sách:");
        jLabel3.setMaximumSize(new java.awt.Dimension(54, 14));
        jLabel3.setMinimumSize(new java.awt.Dimension(54, 14));
        jLabel3.setPreferredSize(new java.awt.Dimension(54, 14));

        jLabel7.setText(" Mã sách :");

        jLabel8.setText(" Ngày mượn :");

        jLabel9.setText(" Ngày trả :");

        jLabel14.setText("Giá sách :");

        jButton1.setText("Trả sách");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ma_sach)
                            .addComponent(ngay_muon)
                            .addComponent(ngay_tra)
                            .addComponent(gia_sach)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ten_sach, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel14, jLabel3, jLabel7, jLabel8, jLabel9});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gia_sach, ma_sach, ngay_muon, ngay_tra, ten_sach});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ten_sach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(ma_sach))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(ngay_muon))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(ngay_tra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(gia_sach)
                    .addComponent(jLabel14))
                .addGap(45, 45, 45)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gia_sach, jLabel14, jLabel3, jLabel7, jLabel8, jLabel9, ma_sach, ngay_muon, ngay_tra, ten_sach});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Người mượn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        jPanel7.setLayout(new java.awt.GridLayout(0, 1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Họ tên người mượn :");
        jPanel7.add(jLabel6);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Mã người mượn (CMND) :");
        jPanel7.add(jLabel5);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Giới tính :");
        jPanel7.add(jLabel12);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Ngày sinh :");
        jPanel7.add(jLabel4);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Email :");
        jPanel7.add(jLabel13);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Địa chỉ :");
        jPanel7.add(jLabel11);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Điện thoại :");
        jPanel7.add(jLabel10);

        jPanel8.setLayout(new java.awt.GridLayout(0, 1));

        L_Name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel8.add(L_Name);

        L_code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel8.add(L_code);

        L_sex.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel8.add(L_sex);

        L_birthday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel8.add(L_birthday);

        L_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel8.add(L_email);

        L_address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel8.add(L_address);

        L_phoneNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel8.add(L_phoneNum);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(253, 253, 253))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.getAccessibleContext().setAccessibleName("Sách đã mượn");
    }// </editor-fold>//GEN-END:initComponents

    private void list_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_bookMouseClicked
        client.status = false;
        pos = list_book.getSelectedIndex();
        client.SEND("loadImage");
        client.SEND(client.SachMuon.get(list_book.getSelectedIndex()*7+4));
        while(client.status == false) System.out.println("LOADING...");
        icon = new ImageIcon(client.SachMuon.get(list_book.getSelectedIndex()*7+4));repaint();
        ten_sach.setText(client.SachMuon.get(list_book.getSelectedIndex()*7));
        ma_sach.setText(client.SachMuon.get(list_book.getSelectedIndex()*7+3));
        ngay_muon.setText(client.SachMuon.get(list_book.getSelectedIndex()*7+1));
        ngay_tra.setText(client.SachMuon.get(list_book.getSelectedIndex()*7+2));
        giatien = client.SachMuon.get(list_book.getSelectedIndex()*7+5);
        gia_sach.setText(client.SachMuon.get(list_book.getSelectedIndex()*7+5)+".000 đồng");
        SPM = client.SachMuon.get(list_book.getSelectedIndex()*7+6);
    }//GEN-LAST:event_list_bookMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(ten_sach.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Chưa chọn sách !");
        }
        else{
            hd = new Hoa_don(L_code.getText(),ten_sach.getText(),ma_sach.getText(),
                    ngay_muon.getText(),ngay_tra.getText(),giatien,SPM,pos,client,this);
            hd.setVisible(true);
            
            ten_sach.setText("");
            ma_sach.setText("");
            ngay_muon.setText("");
            ngay_tra.setText("");
            gia_sach.setText("");
        }           
    }//GEN-LAST:event_jButton1ActionPerformed

    private void list_bookKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_list_bookKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
        {
            pos = list_book.getSelectedIndex();
            client.status = false;
            client.SEND("loadImage");
            client.SEND(client.SachMuon.get(list_book.getSelectedIndex()*7+4));
            while(client.status == false) System.out.println("LOADING...");
            icon = new ImageIcon(client.SachMuon.get(list_book.getSelectedIndex()*7+4));repaint();
            ten_sach.setText(client.SachMuon.get(list_book.getSelectedIndex()*7));
            ma_sach.setText(client.SachMuon.get(list_book.getSelectedIndex()*7+3));
            ngay_muon.setText(client.SachMuon.get(list_book.getSelectedIndex()*7+1));
            ngay_tra.setText(client.SachMuon.get(list_book.getSelectedIndex()*7+2));
            gia_sach.setText(client.SachMuon.get(list_book.getSelectedIndex()*7+5)+".000 đồng");
            giatien = client.SachMuon.get(list_book.getSelectedIndex()*7+5);
            SPM = client.SachMuon.get(list_book.getSelectedIndex()*7+6);
        }
    }//GEN-LAST:event_list_bookKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L_Name;
    private javax.swing.JLabel L_address;
    private javax.swing.JLabel L_birthday;
    private javax.swing.JLabel L_code;
    private javax.swing.JLabel L_email;
    private javax.swing.JLabel L_phoneNum;
    private javax.swing.JLabel L_sex;
    private javax.swing.JLabel gia_sach;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JList list_book;
    private javax.swing.JLabel ma_sach;
    private javax.swing.JLabel ngay_muon;
    private javax.swing.JLabel ngay_tra;
    private javax.swing.JLabel ten_sach;
    // End of variables declaration//GEN-END:variables
}
