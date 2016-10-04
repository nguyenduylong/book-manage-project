/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_database;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

/**
 *
 * @author Admin
 */
public class Popup_Item {
    JMenuItem item_booktype= new JMenuItem("Thể loại sách", new ImageIcon("icon/books-icon.png"));
    JMenuItem item_author = new JMenuItem("Tác giả", new ImageIcon("icon/author-icon.png"));
    JMenuItem item_NXB = new JMenuItem("Nhà xuất bản",new ImageIcon("icon/NXB-icon.png"));
    JMenuItem item_language = new JMenuItem("Ngôn ngữ", new ImageIcon("icon/japan-icon.png"));
    JMenuItem item_bookOut = new JMenuItem("Mượn sách", new ImageIcon("icon/upload-icon.png"));
    JMenuItem item_bookIn = new JMenuItem("Trả sách", new ImageIcon("icon/download-icon.png"));
    JMenuItem item_emp = new JMenuItem("Thành viên",new ImageIcon("icon/User-Files-icon.png"));
    JMenuItem item_member=new JMenuItem("Quản trị viên", new ImageIcon("icon/Office-Customer-Male-Light-icon.png"));
    JMenuItem item_option = new JMenuItem("Cài đặt",new ImageIcon("icon/options-icon.png"));
    JMenuItem item_rule = new JMenuItem("Quy định", new ImageIcon("icon/Rules-of-Fight-Club-icon.png"));
    JMenuItem item_help = new JMenuItem("Hỗ trợ", new ImageIcon("icon/help-icon.png"));
}
