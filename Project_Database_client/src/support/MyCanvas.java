/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Admin
 */
public class MyCanvas extends Canvas{
    Image img;
    Toolkit t = Toolkit.getDefaultToolkit();
    static private int h,w;
    public MyCanvas(int h,int w)
    {
        this.h=h;
        this.w=w;
    }
    public void paint(Graphics g)
    {
        img = t.getImage("icon//load1.gif");
        g.drawImage(img,w/3 , h/2-h/5, w/3, (int) (h/2.5),this);
    }
}
