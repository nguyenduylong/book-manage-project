package project_database;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    static public Client client;
    public static void Connect_server()
    {
        final int PORT = 7777;
        InetAddress HOST = null;
        try {
            HOST = InetAddress.getByName("192.168.0.6");
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối tới server!!!");
        }
        try {
            Socket SOCK = new Socket(HOST, PORT);
            System.out.println("You connected !");
            client = new Client(SOCK);
            PrintWriter OUT = new PrintWriter(SOCK.getOutputStream());
            Thread x = new Thread(client);
            x.start();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối tới server!!!");
        }
    }
    public Login() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        passtext = new javax.swing.JPasswordField();
        But_login = new javax.swing.JButton();
        SignUpAcc = new javax.swing.JLabel();
        forgotPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel3.setIcon(new ImageIcon("icon\\loginIcon.jpg"));
        jLabel3.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Đăng nhập", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 2, 14))); // NOI18N

        jPanel2.setLayout(new java.awt.GridLayout(2, 2));

        jLabel1.setText("Tên đăng nhập:");
        jPanel2.add(jLabel1);

        jLabel2.setText("Mật khẩu:");
        jPanel2.add(jLabel2);

        usertext.setText("girlhadong");
        usertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertextActionPerformed(evt);
            }
        });
        jPanel2.add(usertext);

        passtext.setText("123456");
        passtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtextActionPerformed(evt);
            }
        });
        jPanel2.add(passtext);

        But_login.setText("Đăng nhập");
        But_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_loginActionPerformed(evt);
            }
        });

        SignUpAcc.setForeground(new java.awt.Color(0, 51, 204));
        SignUpAcc.setText("Đăng ký mới");
        SignUpAcc.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                SignUpAccMouseMoved(evt);
            }
        });
        SignUpAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignUpAccMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignUpAccMouseExited(evt);
            }
        });

        forgotPass.setForeground(new java.awt.Color(0, 51, 204));
        forgotPass.setText("Quên mật khẩu?");
        forgotPass.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                forgotPassMouseMoved(evt);
            }
        });
        forgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotPassMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(But_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(forgotPass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(SignUpAcc)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(But_login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forgotPass, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SignUpAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void But_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_loginActionPerformed
        String user = usertext.getText();
        String pass = passtext.getText();
        if(user.compareTo("")==0||pass.compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Nhập không hợp lệ");
        else
        {
            client.SEND("Login");
            client.SEND(user);
            client.SEND(pass);  
            while(client.status==false)
            {
                But_login.setEnabled(false);
            }
            But_login.setEnabled(true);
            client.status = false;
            if(client.login==0)
                JOptionPane.showMessageDialog(null, "Thông tin đăng nhập bị sai!!!");
            else
            {
                new InterFace(client).setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_But_loginActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Connect_server();
    }//GEN-LAST:event_formWindowOpened

    private void SignUpAccMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpAccMouseMoved
        Font font = SignUpAcc.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
        SignUpAcc.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_SignUpAccMouseMoved

    private void forgotPassMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPassMouseMoved
        Font font = forgotPass.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
        forgotPass.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_forgotPassMouseMoved

    private void SignUpAccMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpAccMouseExited
        SignUpAcc.setFont(null);
    }//GEN-LAST:event_SignUpAccMouseExited

    private void forgotPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPassMouseExited
        forgotPass.setFont(null);
    }//GEN-LAST:event_forgotPassMouseExited

    private void SignUpAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpAccMouseClicked
        new SignUp(client).setVisible(true);
    }//GEN-LAST:event_SignUpAccMouseClicked

    private void usertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertextActionPerformed
        But_loginActionPerformed(evt);
    }//GEN-LAST:event_usertextActionPerformed

    private void passtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtextActionPerformed
        But_loginActionPerformed(evt);
    }//GEN-LAST:event_passtextActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton But_login;
    private javax.swing.JLabel SignUpAcc;
    private javax.swing.JLabel forgotPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField passtext;
    private javax.swing.JTextField usertext;
    // End of variables declaration//GEN-END:variables
}
