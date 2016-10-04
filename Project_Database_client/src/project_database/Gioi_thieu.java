package project_database;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
public final class Gioi_thieu extends javax.swing.JPanel implements ActionListener,MouseListener{
    ImageIcon icon[] = new ImageIcon[27];
    ImageIcon icon_[] = new ImageIcon[5];
    Client client;
    public JLabel[] L_but = new JLabel[27];
    JLabel book[] = new JLabel[27];
    JPanel panel[] = new JPanel[27];
    showbook SB = null;
    public Gioi_thieu(Client client) {
        this.client = client;
        for(int i =0 ;i<5;i++)
            icon_[i] = new ImageIcon();
        initComponents();
        for(int i =0 ;i<27;i++)
        {
            icon[i] = new ImageIcon();
        }
        setlayout();
    }
    public void setlayout()
    {
        while(client.status==false) System.out.println("LOADING!!!!");
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)),client.hitDeTai[1][0],javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255)));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)),client.hitDeTai[1][1],javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255)));
                        
        int x= 200,y= 140,a= 90,b= 90;
        for (int i = 0; i < 9; i++) {
            String str=client.s[1][i];
            if(str.compareTo("")!=0)
                str = str.substring(0, 15);
            book[i] = new JLabel(str);
            book[i].setFont(new java.awt.Font("Tahoma", 1, 12));
            book[i].setForeground(Color.yellow);
            book[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
            int j = i;
            L_but[i] = new JLabel(){
                public void paintComponent(Graphics g)
                {
                    Dimension d = getSize();
                    g.drawImage(icon[j].getImage(),0,0,d.width,d.height,null);
                    setOpaque(false);        
                    super.paintComponent(g);
                }
            };
            jPanel6.add(L_but[i]);
            jPanel7.add(book[i]);
            icon[i] = new ImageIcon(client.s[0][i]);
            if(str.trim().compareTo("")==0)
                L_but[i].setEnabled(false);
            else {
                L_but[i].setEnabled(true);
                L_but[i].addMouseListener(this);
            }
        }
        for (int i = 9; i < 18; i++) {
            String str=client.s[1][i];
            if(str.compareTo("")!=0)
                str = str.substring(0, 15);
            int j = i;
            L_but[i] = new JLabel(){
                public void paintComponent(Graphics g)
                {
                    Dimension d = getSize();
                    g.drawImage(icon[j].getImage(),0,0,d.width,d.height,null);
                    setOpaque(false);        
                    super.paintComponent(g);
                }
            };
            book[i] = new JLabel(str);
            book[i].setFont(new java.awt.Font("Tahoma", 1, 12));
            book[i].setForeground(Color.yellow);
            book[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
            jPanel8.add(L_but[i]);
            jPanel9.add(book[i]);
            icon[i] = new ImageIcon(client.s[0][i]);
            if(str.trim().compareTo("")==0)
                L_but[i].setEnabled(false);
            else {
                L_but[i].setEnabled(true);
                L_but[i].addMouseListener(this);
            }
        }
        for (int i = 18; i < 27; i++) {
            String str=client.s[1][i];
            if(str.compareTo("")!=0)
                str = str.substring(0, 15);
            book[i] = new JLabel(str);
            book[i].setFont(new java.awt.Font("Tahoma", 1, 12));
            book[i].setForeground(Color.yellow);
            book[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
            int j = i;
            L_but[i] = new JLabel(){
                public void paintComponent(Graphics g)
                {
                    Dimension d = getSize();
                    g.drawImage(icon[j].getImage(),0,0,d.width,d.height,null);
                    setOpaque(false);        
                    super.paintComponent(g);
                }
            };
            jPanel10.add(L_but[i]);
            jPanel11.add(book[i]);
            icon[i] = new ImageIcon(client.s[0][i]);
            if(str.trim().compareTo("")==0)
                L_but[i].setEnabled(false);
            else {
                L_but[i].setEnabled(true);
                L_but[i].addMouseListener(this);
            }
        }
        
        ButSelect1.setIcon(new ImageIcon("icon\\go_next.png"));
        ButSelect2.setIcon(new ImageIcon("icon\\go_next.png"));
        ButSelect3.setIcon(new ImageIcon("icon\\go_next.png"));
        ButSelect4.setIcon(new ImageIcon("icon\\go_next.png"));
        ButSelect5.setIcon(new ImageIcon("icon\\go_next.png"));
        for(int i = 0 ;i<5;i++)
            icon_[i] = new ImageIcon(client.s[0][i+27]);
        text1.setText(client.s[1][27].trim());
        text2.setText(client.s[2][27].trim());
        text3.setText(client.s[1][28].trim());
        text4.setText(client.s[2][28].trim());
        text5.setText(client.s[1][29].trim());
        text6.setText(client.s[2][29].trim());
        text7.setText(client.s[1][30].trim());
        text8.setText(client.s[2][30].trim());
        text9.setText(client.s[1][31].trim());
        text10.setText(client.s[2][31].trim());
        ButSelect1.addActionListener(this);
        ButSelect2.addActionListener(this);
        ButSelect3.addActionListener(this);
        ButSelect4.addActionListener(this);
        ButSelect5.addActionListener(this);
        repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("icon\\wallpaper1.jpg");
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel5 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("icon\\wallpaper1.jpg");
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel6 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("icon\\wallpaper1.jpg");
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel7 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("icon\\wallpaper_line.jpg");
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel4 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("icon\\wallpaper1.jpg");
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel8 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("icon\\wallpaper1.jpg");
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel9 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("icon\\wallpaper_line.jpg");
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel3 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("icon\\wallpaper1.jpg");
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel10 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("icon\\wallpaper1.jpg");
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel11 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("icon\\wallpaper_line.jpg");
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        label_top1 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon_[0].getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        ButSelect1 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        text1 = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        label_top2 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon_[1].getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        ButSelect2 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        text3 = new javax.swing.JLabel();
        text4 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        ButSelect3 = new javax.swing.JButton();
        label_top3 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon_[2].getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel20 = new javax.swing.JPanel();
        text5 = new javax.swing.JLabel();
        text6 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        label_top4 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon_[3].getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        ButSelect4 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        text7 = new javax.swing.JLabel();
        text8 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        label_top5 = new javax.swing.JLabel(){
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon_[4].getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        ButSelect5 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        text9 = new javax.swing.JLabel();
        text10 = new javax.swing.JLabel();

        setBorder(new javax.swing.border.MatteBorder(null));
        setPreferredSize(new java.awt.Dimension(700, 573));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)), "Sách mới cập nhật", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel5);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel8.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel10.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(377, 570));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("SÁCH ĐƯỢC XEM NHIỀU NHẤT");

        jPanel12.setPreferredSize(new java.awt.Dimension(370, 510));
        jPanel12.setLayout(new java.awt.GridLayout(0, 1));

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel18.setLayout(new java.awt.GridLayout(0, 1));
        jPanel18.add(text1);
        jPanel18.add(text2);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(label_top1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButSelect1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(label_top1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButSelect1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel17);

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ButSelect2.setMaximumSize(new java.awt.Dimension(71, 23));
        ButSelect2.setMinimumSize(new java.awt.Dimension(71, 23));

        jPanel19.setLayout(new java.awt.GridLayout(0, 1));
        jPanel19.add(text3);
        jPanel19.add(text4);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(label_top2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButSelect2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(ButSelect2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label_top2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel16);

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel20.setLayout(new java.awt.GridLayout(0, 1));
        jPanel20.add(text5);
        jPanel20.add(text6);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(label_top3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButSelect3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButSelect3, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
            .addComponent(label_top3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel15);

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel21.setLayout(new java.awt.GridLayout(0, 1));
        jPanel21.add(text7);
        jPanel21.add(text8);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(label_top4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButSelect4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_top4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButSelect4, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel14);

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel22.setLayout(new java.awt.GridLayout(0, 1));
        jPanel22.add(text9);
        jPanel22.add(text10);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(label_top5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButSelect5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_top5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButSelect5, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel13);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButSelect1;
    private javax.swing.JButton ButSelect2;
    private javax.swing.JButton ButSelect3;
    private javax.swing.JButton ButSelect4;
    private javax.swing.JButton ButSelect5;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel label_top1;
    private javax.swing.JLabel label_top2;
    private javax.swing.JLabel label_top3;
    private javax.swing.JLabel label_top4;
    private javax.swing.JLabel label_top5;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text10;
    private javax.swing.JLabel text2;
    private javax.swing.JLabel text3;
    private javax.swing.JLabel text4;
    private javax.swing.JLabel text5;
    private javax.swing.JLabel text6;
    private javax.swing.JLabel text7;
    private javax.swing.JLabel text8;
    private javax.swing.JLabel text9;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == ButSelect1&&text1.getText().compareTo("")!=0)
        {
            if(SB!=null)
                SB.dispose();
            SB=new showbook(client,27,client.s[3][27]);
            SB.setVisible(true);
            SB.requestFocus();
            SB.addWindowFocusListener(new WindowFocusListener() {

                @Override
                public void windowGainedFocus(WindowEvent e) {
                }

                @Override
                public void windowLostFocus(WindowEvent e) {
                    SB.dispose();
                }
            });
        }
        if(obj == ButSelect2&&text3.getText().compareTo("")!=0)
        {
            if(SB!=null)
                SB.dispose();
            SB=new showbook(client,28,client.s[3][28]);
            SB.setVisible(true);
            SB.requestFocus();
            SB.addWindowFocusListener(new WindowFocusListener() {

                @Override
                public void windowGainedFocus(WindowEvent e) {
                }

                @Override
                public void windowLostFocus(WindowEvent e) {
                    SB.dispose();
                }
            });
        }
        if(obj == ButSelect3&&text5.getText().compareTo("")!=0)
        {
            if(SB!=null)
                SB.dispose();
            SB=new showbook(client,29,client.s[3][29]);
            SB.setVisible(true);
            SB.requestFocus();
            SB.addWindowFocusListener(new WindowFocusListener() {

                @Override
                public void windowGainedFocus(WindowEvent e) {
                }

                @Override
                public void windowLostFocus(WindowEvent e) {
                    SB.dispose();
                }
            });
        }
        if(obj == ButSelect4&&text7.getText().compareTo("")!=0)
        {
            if(SB!=null)
                SB.dispose();
            SB=new showbook(client,30,client.s[3][30]);
            SB.setVisible(true);
            SB.requestFocus();
            SB.addWindowFocusListener(new WindowFocusListener() {

                @Override
                public void windowGainedFocus(WindowEvent e) {
                }

                @Override
                public void windowLostFocus(WindowEvent e) {
                    SB.dispose();
                }
            });
        }    
        if(obj == ButSelect5&&text9.getText().compareTo("")!=0)
        {
            if(SB!=null)
                SB.dispose();
            SB=new showbook(client,31,client.s[3][31]);
            SB.setVisible(true);
            SB.requestFocus();
            SB.addWindowFocusListener(new WindowFocusListener() {

                @Override
                public void windowGainedFocus(WindowEvent e) {
                }

                @Override
                public void windowLostFocus(WindowEvent e) {
                    SB.dispose();
                }
            });
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object ob = e.getSource();
        for(int i=0;i<27;i++)
        {
            if(ob == L_but[i])
            {
                L_but[i].setEnabled(false);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object ob = e.getSource();
        for(int i =0;i<27;i++)
        {
            if(ob == L_but[i])
            {
                L_but[i].setEnabled(true);
                if(SB!=null)
                    SB.dispose();
                SB = new showbook(client, i,client.s[3][i]);
                SB.setVisible(true);
                SB.addWindowFocusListener(new WindowFocusListener() {

                    @Override
                    public void windowGainedFocus(WindowEvent e) {
                    }

                    @Override
                    public void windowLostFocus(WindowEvent e) {
                        SB.dispose();
                    }
                });
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
