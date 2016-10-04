package project_database;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Muon_sach extends javax.swing.JPanel implements MouseListener{
    static ImageIcon icon = new ImageIcon();
    DefaultTableModel Tmodel= null;
    Phieu_thue Pt;
    Hoa_don_mua hdm;
    Client client;
    String filename;
    public Muon_sach(Client client) {
        this.client = client;
        initComponents();
        But_borrow.setVisible(false);But_buy.setVisible(false);
        jLabel1.setSize(200,100);
        new Set_picture().setPicture2(jLabel1,"user\\user_face.png");
        Table_book.addMouseListener(this);
        getInfo();
    }
    @SuppressWarnings("unchecked")
    private void getInfo()
    {
        L_Name.setText(client.DocGia[1]);
        L_address.setText(client.DocGia[5]);
        L_birthday.setText(client.DocGia[3]);
        L_code.setText(client.DocGia[0]);
        L_email.setText(client.DocGia[4]);
        L_phoneNum.setText(client.DocGia[6]);
        L_sex.setText(client.DocGia[2]);
        Tmodel = (DefaultTableModel) table_SachDaMuon.getModel();
        while(table_SachDaMuon.getRowCount()!=0) Tmodel.removeRow(0);
        for (int i = 0; i < client.SachMuon.size(); i+=7) {
            Tmodel.addRow(new Object[]{client.SachMuon.get(i),client.SachMuon.get(i+1),client.SachMuon.get(i+2)});
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        T_bookcode = new javax.swing.JTextField();
        T_bookname = new javax.swing.JTextField();
        T_booktype = new javax.swing.JTextField();
        T_bookauthor = new javax.swing.JTextField();
        B_search = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        T_NXB = new javax.swing.JTextField();
        L_ThongBao = new javax.swing.JLabel();
        PanelBook = new javax.swing.JPanel();
        But_borrow = new javax.swing.JButton();
        But_buy = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        book_image = new javax.swing.JLabel(){
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_book = new javax.swing.JTable();
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
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_SachDaMuon = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Mượn sách"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mượn sách", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Tên Sách:");

        jLabel7.setText("Mã Sách:");

        jLabel8.setText("Thể loại sách:");

        jLabel9.setText("Tác Giả:");

        T_bookcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_bookcodeActionPerformed(evt);
            }
        });

        T_bookname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_booknameActionPerformed(evt);
            }
        });

        T_booktype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_booktypeActionPerformed(evt);
            }
        });

        T_bookauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_bookauthorActionPerformed(evt);
            }
        });

        B_search.setText("Tìm kiếm");
        B_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_searchActionPerformed(evt);
            }
        });

        jLabel15.setText("Nhà Xuất Bản:");

        T_NXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_NXBActionPerformed(evt);
            }
        });

        L_ThongBao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        L_ThongBao.setForeground(new java.awt.Color(255, 0, 51));
        L_ThongBao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(L_ThongBao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B_search, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(T_bookcode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(T_booktype, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(T_bookauthor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(T_NXB)
                            .addComponent(T_bookname))
                        .addContainerGap())))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(T_bookname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(T_bookcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(T_booktype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(T_bookauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(T_NXB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(L_ThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        PanelBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        But_borrow.setText("Thuê");
        But_borrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_borrowActionPerformed(evt);
            }
        });

        But_buy.setText("Mua");
        But_buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_buyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(book_image, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(book_image, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelBookLayout = new javax.swing.GroupLayout(PanelBook);
        PanelBook.setLayout(PanelBookLayout);
        PanelBookLayout.setHorizontalGroup(
            PanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBookLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(PanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelBookLayout.createSequentialGroup()
                        .addComponent(But_buy, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(But_borrow, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        PanelBookLayout.setVerticalGroup(
            PanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBookLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(PanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(But_buy, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(But_borrow, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(0, 51, 51));
        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        Table_book.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sách", "Mã sách", "Tác giả", "NXB", "Thể loại", "Giá tiền", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_book.setMaximumSize(new java.awt.Dimension(1000, 0));
        Table_book.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Table_bookKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(Table_book);
        if (Table_book.getColumnModel().getColumnCount() > 0) {
            Table_book.getColumnModel().getColumn(0).setMaxWidth(800);
        }

        jPanel10.add(jScrollPane2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Người mượn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        jPanel7.setLayout(new java.awt.GridLayout(0, 1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Họ tên người mượn :");
        jPanel7.add(jLabel6);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Mã người mượn (CMND) :");
        jPanel7.add(jLabel5);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Giới tính :");
        jPanel7.add(jLabel12);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Ngày sinh :");
        jPanel7.add(jLabel4);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Email :");
        jPanel7.add(jLabel13);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Địa chỉ :");
        jPanel7.add(jLabel11);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Điện thoại :");
        jPanel7.add(jLabel10);

        jPanel8.setLayout(new java.awt.GridLayout(0, 1));
        jPanel8.add(L_Name);
        jPanel8.add(L_code);
        jPanel8.add(L_sex);
        jPanel8.add(L_birthday);
        jPanel8.add(L_email);
        jPanel8.add(L_address);
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
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
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

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(493, 89));

        table_SachDaMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sách", "Ngày mượn", "Ngày trả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_SachDaMuon);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void B_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_searchActionPerformed
        client.status = false;
        book_image.setIcon(null);
        But_borrow.setVisible(false);But_buy.setVisible(false);
        Tmodel = (DefaultTableModel) Table_book.getModel();
        while(Table_book.getRowCount()!=0)Tmodel.removeRow(0); 
        String s1 = T_bookname.getText();
        String s2 = T_bookcode.getText();
        String s3 = T_booktype.getText();
        String s4 = T_bookauthor.getText();
        String s5 = T_NXB.getText();
        String query = "select * from \"Sach\" natural join \"Sach_TheLoai\" natural join \"TheLoai\" where ";
        String query1 = "select * from \"Sach\" where ";
        int kt =0;
        if(Check(s1)==0&&Check(s2)==0&&Check(s3)==0&&Check(s4)==0&&Check(s5)==0)
        {
            L_ThongBao.setText("! Xin hãy nhập thông tin tìm kiếm !");
        }
        else
        {
            if(Check(s1)!=0)
            {
                query += "\"TenSach\" like '"+s1+"%'";
                query1 += "\"TenSach\" like '"+s1+"%'";
                kt++;
            }
            if(Check(s2)!=0)
                if(kt==0){
                    query += "\"MaSach\" = '"+s2+"'";
                    query1 += "\"MaSach\" = '"+s2+"'";
                    kt++;
                }
                else{
                    query1 += "and \"MaSach\" = '"+s2+"'";
                    query += "and \"MaSach\" = '"+s2+"'";
                }
            if(Check(s3)!=0)
                if(kt==0)
                {
                    query += "\"TenTheLoai\" = '"+s3+"' ";
                    kt++;
                }
                else
                    query += "and \"TenTheLoai\" = '"+s3+"' ";
            if(Check(s4)!=0)
                if(kt==0)
                {
                    query += "\"TenTacGia\" = '"+s4+"' ";
                    query1 += "\"TenTacGia\" = '"+s4+"' ";
                    kt++;
                }
                else{
                    query += "and \"TenTacGia\" = '"+s4+"' ";
                    query1 += "and \"TenTacGia\" = '"+s4+"' ";
                }
            if(Check(s5)!=0)
                if(kt==0)
                {
                    query +="\"NXB\" = '"+s5+"' ";
                    query1 +="\"NXB\" = '"+s5+"' ";
                    kt++;
                }
                else{
                    query1 +="and \"NXB\" = '"+s5+"' ";
                    query +="and \"NXB\" = '"+s5+"' ";
                }
            client.SEND("MuonSach_search");
            if(Check(s3)==0)
                client.SEND(query1);
            else
                client.SEND(query);
            while(client.status == false) System.out.println("LOADING");
            if(client.timkiem == 0)
            {
                L_ThongBao.setText("! Không tìm thấy kết quả nào !");
                But_borrow.setVisible(false);But_buy.setVisible(false);
            }
            else
            {
                for (int i = 0; i < client.timkiem; i+=8) 
                {
                    Tmodel.addRow(new Object[]{client.TimSach.get(i+1).trim(),client.TimSach.get(i+2).trim(),client.TimSach.get(i+3).trim(),
                    client.TimSach.get(i+4).trim(),client.TimSach.get(i+5).trim(),client.TimSach.get(i+6).trim(),client.TimSach.get(i+7).trim()});
                    L_ThongBao.setText("");
                    Table_book.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_B_searchActionPerformed

    private void T_booknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_booknameActionPerformed
        B_searchActionPerformed(evt);
    }//GEN-LAST:event_T_booknameActionPerformed

    private void T_bookcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_bookcodeActionPerformed
        B_searchActionPerformed(evt);
    }//GEN-LAST:event_T_bookcodeActionPerformed

    private void T_booktypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_booktypeActionPerformed
        B_searchActionPerformed(evt);
    }//GEN-LAST:event_T_booktypeActionPerformed

    private void T_bookauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_bookauthorActionPerformed
        B_searchActionPerformed(evt);
    }//GEN-LAST:event_T_bookauthorActionPerformed

    private void T_NXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_NXBActionPerformed
        B_searchActionPerformed(evt);
    }//GEN-LAST:event_T_NXBActionPerformed

    private void Table_bookKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table_bookKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
        {
            Tmodel = (DefaultTableModel) Table_book.getModel();
            String s = client.TimSach.get(Table_book.getSelectedRow()*8);
            if(s.compareTo("")==0){
                book_image.setSize(270, 220);
                book_image.setIcon(null); 
            }
            else
            {
                client.status = false;
                client.SEND("loadImage");
                client.SEND(s);
                while(client.status == false) System.out.println("LOADING...");
                book_image.setSize(270, 220);
                new Set_picture().setPicture2(book_image, s);
                filename =s;
            }
            But_buy.setVisible(true);But_borrow.setVisible(true);
            Table_book.setRowHeight(0, 0);
        }
    }//GEN-LAST:event_Table_bookKeyPressed

    private void But_buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_buyActionPerformed
        if(hdm!=null) hdm.dispose();
        Tmodel = (DefaultTableModel) Table_book.getModel();
            int sachcon = Integer.parseInt((String) Tmodel.getValueAt(Table_book.getSelectedRow(), 6));
            if(sachcon ==0)
            {
                JOptionPane.showMessageDialog(null, "Xin lỗi , sách đã hết !");
            }
            else
            {
                String masach = (String) Tmodel.getValueAt(Table_book.getSelectedRow(), 1);
                String giatien = (String) Tmodel.getValueAt(Table_book.getSelectedRow(),5 );
                String tensach = (String) Tmodel.getValueAt(Table_book.getSelectedRow(), 0);
                hdm = new Hoa_don_mua(L_code.getText(), masach, giatien, tensach, L_Name.getText(),client,this,Table_book.getSelectedRow());
                hdm.setVisible(true);
            }
    }//GEN-LAST:event_But_buyActionPerformed

    private void But_borrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_borrowActionPerformed
        Tmodel = (DefaultTableModel) Table_book.getModel();
        int sachcon = Integer.parseInt((String) Tmodel.getValueAt(Table_book.getSelectedRow(), 6));
        if(sachcon ==0)
        {
            JOptionPane.showMessageDialog(null, "Xin lỗi , sách đã hết !");
        }
        else
        {
            String masach = (String) Tmodel.getValueAt(Table_book.getSelectedRow(), 1);
            String giatien = (String) Tmodel.getValueAt(Table_book.getSelectedRow(),5 );
            String tensach = (String) Tmodel.getValueAt(Table_book.getSelectedRow(), 0);
            if(Pt!=null) Pt.dispose();
            Pt = new Phieu_thue(L_code.getText(), tensach, masach, giatien,filename, client,this,Table_book.getSelectedRow());
            Pt.setVisible(true);
        }
    }//GEN-LAST:event_But_borrowActionPerformed
    
    private int Check(String s)
    {
        return s.compareTo("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_search;
    private javax.swing.JButton But_borrow;
    private javax.swing.JButton But_buy;
    private javax.swing.JLabel L_Name;
    private javax.swing.JLabel L_ThongBao;
    private javax.swing.JLabel L_address;
    private javax.swing.JLabel L_birthday;
    private javax.swing.JLabel L_code;
    private javax.swing.JLabel L_email;
    private javax.swing.JLabel L_phoneNum;
    private javax.swing.JLabel L_sex;
    private javax.swing.JPanel PanelBook;
    private javax.swing.JTextField T_NXB;
    private javax.swing.JTextField T_bookauthor;
    private javax.swing.JTextField T_bookcode;
    private javax.swing.JTextField T_bookname;
    private javax.swing.JTextField T_booktype;
    public static javax.swing.JTable Table_book;
    private javax.swing.JLabel book_image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable table_SachDaMuon;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if(obj == Table_book)
        {
            Tmodel = (DefaultTableModel) Table_book.getModel();
            String s = client.TimSach.get(Table_book.getSelectedRow()*8);
            if(s.compareTo("")==0){
                icon = new ImageIcon(); repaint();
            }
            else
            {
                client.status = false;
                client.SEND("loadImage");
                client.SEND(s);
                while(client.status == false) System.out.println("LOADING...");
                icon = new ImageIcon(s); repaint();
                filename =s ;
            }
            But_buy.setVisible(true);But_borrow.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
