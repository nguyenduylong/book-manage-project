package project_database;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import panelitem.AuthorItemPanel;
import panelitem.PublishingCompanyItemPanel;
import panelitem.TypeItemPanel;

public class InterFace extends javax.swing.JFrame implements ActionListener{
    Popup_Item Itempop= new Popup_Item();
    private JPopupMenu menu_bookinfo,menu_bookmanage,menu_user,menu_setting;
    private JPanel child_panel;
    static Client client;
    static Dimension dimen;
   
    public InterFace(Client client) {
        initComponents();
        setResizable(false);
        dimen = Panel_main.getSize();
        this.client = client;
        jLabel3.setText("Xin chào "+client.DocGia[1]);
        setIcon();
        addItem();
        addEvent();
    }
    private void addEvent()
    {
        Itempop.item_booktype.addActionListener(this);
        Itempop.item_bookOut.addActionListener(this);
        Itempop.item_bookIn.addActionListener(this);
        Itempop.item_author.addActionListener(this);
        Itempop.item_NXB.addActionListener(this);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        But_home = new javax.swing.JButton();
        But_bookinfo = new javax.swing.JButton();
        But_bookManager = new javax.swing.JButton();
        But_user = new javax.swing.JButton();
        But_statistical = new javax.swing.JButton();
        But_setting = new javax.swing.JButton();
        But_logout = new javax.swing.JButton();
        Panel_main = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("icon\\wallpaperx2.jpg");
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        panel_LOAD = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel(){
            ImageIcon icon = new ImageIcon("icon\\wallpaper1.jpg");
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        LOADING = new javax.swing.JLabel(){
            ImageIcon icon = new ImageIcon("icon\\wallpaper1.jpg");
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel3 = new javax.swing.JPanel();
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat time = new SimpleDateFormat("dd/MM/yyyy");
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 8));

        But_home.setText("Giới thiệu");
        But_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_homeActionPerformed(evt);
            }
        });
        jPanel1.add(But_home);

        But_bookinfo.setText("Thông tin sách");
        But_bookinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_bookinfoActionPerformed(evt);
            }
        });
        jPanel1.add(But_bookinfo);

        But_bookManager.setText("Mượn trả");
        But_bookManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_bookManagerActionPerformed(evt);
            }
        });
        jPanel1.add(But_bookManager);

        But_user.setText("Người dùng");
        But_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_userActionPerformed(evt);
            }
        });
        jPanel1.add(But_user);

        But_statistical.setText("Thống kê");
        But_statistical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_statisticalActionPerformed(evt);
            }
        });
        jPanel1.add(But_statistical);

        But_setting.setText("Điều chỉnh");
        But_setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_settingActionPerformed(evt);
            }
        });
        jPanel1.add(But_setting);

        But_logout.setText("Thoát");
        But_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_logoutActionPerformed(evt);
            }
        });
        jPanel1.add(But_logout);

        Panel_main.setLayout(new java.awt.BorderLayout());

        panel_LOAD.setLayout(new java.awt.GridLayout(1, 2));

        jLabel4.setFont(new java.awt.Font("Tunga", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("LOADING ");
        panel_LOAD.add(jLabel4);

        LOADING.setFont(new java.awt.Font("Tunga", 3, 36)); // NOI18N
        LOADING.setForeground(new java.awt.Color(0, 204, 204));
        LOADING.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LOADING.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        panel_LOAD.add(LOADING);

        Panel_main.add(panel_LOAD, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        jLabel2.setText("             Hôm nay: "+time.format(today.getTime()));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel3.add(jLabel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE, Short.MAX_VALUE)
            .addComponent(Panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, 32620, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void But_bookinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_bookinfoActionPerformed
        showPopupMenu(evt,menu_bookinfo);
    }//GEN-LAST:event_But_bookinfoActionPerformed

    private void But_bookManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_bookManagerActionPerformed
        showPopupMenu(evt, menu_bookmanage);
    }//GEN-LAST:event_But_bookManagerActionPerformed

    private void But_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_userActionPerformed
        showPanel(new Thanh_vien(client,this));
    }//GEN-LAST:event_But_userActionPerformed

    private void But_settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_settingActionPerformed
        showPopupMenu(evt, menu_setting);
    }//GEN-LAST:event_But_settingActionPerformed

    private void But_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_homeActionPerformed
        Panel_main.removeAll();
        Panel_main.add(panel_LOAD);
        Panel_main.validate();
        panel_LOAD.setVisible(true);
        client.SEND("GioiThieu");
        LOADING.setText("");
        Thread load = new Thread(){

            @Override
            public void run() {
                while(client.status==false)
                {
                    try {
                        sleep(300);
                        LOADING.setText(LOADING.getText()+".");
                        if(LOADING.getText().compareTo("......")==0)
                            LOADING.setText("");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(InterFace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                panel_LOAD.setVisible(false);
                showPanel(new Gioi_thieu(client));
            }
        };
        load.start();
    }//GEN-LAST:event_But_homeActionPerformed

    private void But_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_logoutActionPerformed
        new Login().setVisible(true);
        client.SachMuon.clear();
        this.dispose();
    }//GEN-LAST:event_But_logoutActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        client.SEND("GioiThieu");
        LOADING.setText("");
        Thread load = new Thread(){

            @Override
            public void run() {
                while(client.status==false)
                {
                    try {
                        sleep(300);
                        LOADING.setText(LOADING.getText()+".");
                        if(LOADING.getText().compareTo("......")==0)
                            LOADING.setText("");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(InterFace.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                panel_LOAD.setVisible(false);
                showPanel(new Gioi_thieu(client));
            }
        };
        load.start();
    }//GEN-LAST:event_formWindowOpened

    private void But_statisticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_statisticalActionPerformed
        showPanel(new Thong_ke(client));
    }//GEN-LAST:event_But_statisticalActionPerformed

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
            java.util.logging.Logger.getLogger(InterFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterFace(client).setVisible(true);
            }
        });
    }
    
    private void showPanel(JPanel panel)
    {
        child_panel = panel;
        Panel_main.removeAll();
        Panel_main.add(child_panel);
        Panel_main.validate();
    }
    private void showPopupMenu(ActionEvent e,JPopupMenu menu)
    {
        Component b = (Component) e.getSource();
        
        // Get the location of the point 'on the screen'
        Point p=b.getLocationOnScreen();
        // Show the JPopupMenu via program
        
        // Parameter desc
        // ----------------
        // this - represents current frame
        // 0,0 is the co ordinate where the popup
        // is shown
        menu.show(this,0,0);
        
        // Now set the location of the JPopupMenu
        // This location is relative to the screen
        menu.setLocation(p.x,p.y+b.getHeight());
    }
    private void setIcon()
    {
        
        But_home.setIcon(new ImageIcon("icon/home-icon.png"));
        But_user.setIcon(new ImageIcon("icon/user-group-icon.png"));
        But_bookinfo.setIcon(new ImageIcon("icon/research-icon.png"));
        But_bookManager.setIcon(new ImageIcon("icon/label-icon.png"));
        But_statistical.setIcon(new ImageIcon("icon/presentation-icon.png"));
        But_setting.setIcon(new ImageIcon("icon/settings-icon.png"));
        But_logout.setIcon(new ImageIcon("icon/logout-icon.png"));
    }
    private void addItem()
    {
        menu_bookinfo= new JPopupMenu();
        menu_bookinfo.add(Itempop.item_booktype);
        menu_bookinfo.add(Itempop.item_author);
        menu_bookinfo.add(Itempop.item_NXB);
        ////////////////////////////////
        menu_bookmanage = new JPopupMenu();
        menu_bookmanage.add(Itempop.item_bookOut);
        menu_bookmanage.add(Itempop.item_bookIn);
        /////////////////////////////////
        menu_setting = new JPopupMenu();
        menu_setting.add(Itempop.item_option);
        menu_setting.add(Itempop.item_rule);
        menu_setting.add(Itempop.item_help);    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton But_bookManager;
    private javax.swing.JButton But_bookinfo;
    private javax.swing.JButton But_home;
    private javax.swing.JButton But_logout;
    private javax.swing.JButton But_setting;
    private javax.swing.JButton But_statistical;
    private javax.swing.JButton But_user;
    private javax.swing.JLabel LOADING;
    private javax.swing.JPanel Panel_main;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panel_LOAD;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj==Itempop.item_booktype)
        {
            client.status = false;
            client.SEND("TheLoaiSach");
            while(client.status==false) System.out.println("waiting ...");
            System.out.println(client.TacGia.size());
            showPanel(new TypeItemPanel(dimen, client));
        }
        if(obj==Itempop.item_bookOut)
        {
            showPanel(new Muon_sach(client));
        }
        if(obj==Itempop.item_bookIn)
        {
            showPanel(new Tra_sach(client));
        }
        if(obj == Itempop.item_author)
        {
            client.status = false;
            client.SEND("TacGia");
            while(client.status==false) System.out.println("waiting ...");
            showPanel(new AuthorItemPanel(dimen,client));
        }
        if(obj == Itempop.item_NXB)
        {
            client.status = false;
            client.SEND("NXB");
            while(client.status==false) System.out.println("waiting ...");
            showPanel(new PublishingCompanyItemPanel(dimen, client));
        }
    }
}
