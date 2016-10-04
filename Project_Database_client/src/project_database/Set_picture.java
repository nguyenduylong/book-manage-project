/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_database;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class Set_picture {
    public void setPicture(JButton label ,String filename ){
          try {
            BufferedImage image = ImageIO.read(new File(filename));
            int x =label.getSize().width;
            int y =label.getSize().height;
            int ix =image.getWidth();
            int iy =image.getHeight();

            int dx=0;
            int dy=0;
            if(x /y > ix /iy){
                dy=y;
                dx=dy*ix /iy;
            }else{
                dx=x;
                dy=dx*iy/ix;
            }

            ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, BufferedImage.SCALE_SMOOTH));
            label.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(Gioi_thieu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setPicture2(JLabel label ,String filename ){
          try {
            BufferedImage image = ImageIO.read(new File(filename));
            int x =label.getSize().width;
            int y =label.getSize().height;
            int ix =image.getWidth();
            int iy =image.getHeight();

            int dx=0;
            int dy=0;
            if(x /y > ix /iy){
                dy=y;
                dx=dy*ix /iy;
            }else{
                dx=x;
                dy=dx*iy/ix;
            }

            ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, BufferedImage.SCALE_SMOOTH));
            label.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(Gioi_thieu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
