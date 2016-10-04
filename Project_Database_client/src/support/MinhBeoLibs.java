package support;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import object.BookItem;


public class MinhBeoLibs
{

//=================================================(GET DATA)======================================================================        
    
    
    
//=================================================================================================================================    

    
    
//=================================================(SEARCH DATA)===================================================================        
    
//=================================================================================================================================    
    
    
    
//=================================================(TOOL)==========================================================================        
    public static String toolCheckString (String string)
    {
        String check = " ";
        int count = 0;
        for (int i = string.length() - 1 ; i >= 0 ; i--)
        {
            if (check.compareTo(String.valueOf(string.charAt(i))) != 0)
            {
                count = i;
                break;
            }
        }
        return string.substring(0, count + 1);
    }
    
    public static void toolResetPanel (
            JLabel labelItemName, JLabel labelItemType, JLabel labelItemAuthor,
            JLabel labelItemDate, JLabel labelItemPublishingCompany, JLabel labelItemView,
            JLabel labelItemPrice, JLabel labelItemQuantity)
    {
        labelItemName.setText("");
        labelItemType.setText("");
        labelItemAuthor.setText("");
        labelItemDate.setText("");
        labelItemPublishingCompany.setText("");
        labelItemView.setText("");
        labelItemPrice.setText("");
        labelItemQuantity.setText("");
    }
    
    public static void toolSetPanel (
            JLabel labelItemName, JLabel labelItemType, JLabel labelItemAuthor,
            JLabel labelItemDate, JLabel labelItemPublishingCompany, JLabel labelItemView,
            JLabel labelItemPrice, JLabel labelItemQuantity,
            ArrayList<BookItem> books, int flag, int count, int j)
    {
        labelItemName.setText("Tên sách: " + books.get(flag * count + j).getmName());
        labelItemType.setText("Thể loại: " + books.get(flag * count + j).getmType());
        labelItemAuthor.setText("Tác giả : " + books.get(flag * count + j).getmAuthor());
        labelItemDate.setText("Ngày phát hành : " + books.get(flag * count + j).getmDate());
        labelItemPublishingCompany.setText("Nhà xuất bản : " + books.get(flag * count + j).getmPublishingCompany());
        labelItemView.setText("Lượt xem : " + books.get(flag * count + j).getmView());
        labelItemPrice.setText("Giá thành : " + books.get(flag * count + j).getmPrice());
        labelItemQuantity.setText("Số lượng : " + books.get(flag * count + j).getmQuantity());
    }
//=================================================================================================================================
    
    
    
//=================================================(CREATE PANEL)==================================================================    
    
//CREATE PANEL SEARCH CHILD
    public static void createPanelSearchChild (
            JLabel labelSearch, JTextField textSearch, JButton buttonSearch,
            JScrollPane scrollListSearch, JPanel panelSearch, JList listSearch,
            int leftLabelSearch  ,int upLabelSearch  ,int widthLabelSearch  ,int heightLabelSearch,
            int leftTextSearch   ,int upTextSearch   ,int widthTextSearch   ,int heightTextSearch,
            int leftButtonSearch ,int upButtonSearch ,int widthButtonSearch ,int heightButtonSearch,
            int leftListSearch   ,int upListSearch   ,int widthListSearch   ,int heightListSearch)
    {
        labelSearch.setBounds(leftLabelSearch, upLabelSearch, widthLabelSearch, heightLabelSearch);
        textSearch.setBounds(leftTextSearch, upTextSearch, widthTextSearch, heightTextSearch);
        buttonSearch.setBounds(leftButtonSearch, upButtonSearch, widthButtonSearch, heightButtonSearch);
        buttonSearch.setText("Tìm Kiếm");
        scrollListSearch.setViewportView(listSearch);
        scrollListSearch.setBounds(leftListSearch, upListSearch, widthListSearch, heightListSearch);
        //Add panelSearchChild
            panelSearch.add(labelSearch);
            panelSearch.add(textSearch);
            panelSearch.add(buttonSearch);
            panelSearch.add(scrollListSearch);
    }
    
//CREATE PANEL PRODUCT CHILD
    public static void createPanelProductChild (
            JPanel panelBookStoreOnline, JPanel panelBookStore, JPanel panelButton, JPanel panelProduct, JPanel panelBook[],
            JPanel panelImage[], JPanel panelName[], JLabel labelName[], JButton buttonPre, JButton buttonPost,
            int leftPanelBookStore ,int upPanelBookStore ,int widthPanelBookStore ,int heightPanelBookStore,
            int leftPanelButton    ,int upPanelButton    ,int widthPanelButton    ,int heightPanelButton,
            int leftPanelImage     ,int upPanelImage     ,int widthPanelImage     ,int heightPanelImage,
            int leftPanelName      ,int upPanelName      ,int widthPanelName      ,int heightPanelName,
            int leftLabelName      ,int upLabelName      ,int widthLabelName      ,int heightLabelName,
            int leftButtonPre      ,int upButtonPre      ,int widthButtonPre      ,int heightButtonPre,
            int leftButtonPost     ,int upButtonPost     ,int widthButtonPost     ,int heightButtonPost,
            int count, ImageIcon image[])
    {
        panelBookStoreOnline.setBounds(leftPanelBookStore, upPanelBookStore, widthPanelBookStore, heightPanelBookStore);
        
        panelBookStoreOnline.setVisible(false);
        panelBookStore.setVisible(true);
        //asdsadaddsadsadsadsadsadsdsadsadsdsads
        panelBookStore.setBounds(leftPanelBookStore, upPanelBookStore, widthPanelBookStore, heightPanelBookStore);
        panelBookStore.setLayout(new java.awt.GridLayout(3, count / 3));
        panelButton.setBounds(leftPanelButton, upPanelButton, widthPanelButton, heightPanelButton);
        panelButton.setLayout(null);
    //panelProduct add item
        panelProduct.add(panelBookStore);
        panelProduct.add(panelBookStoreOnline);
        panelProduct.add(panelButton);
        //panelBookStore child item
            for (int i = 0 ; i < count ; i++)
            {
                panelBook[i].setLayout(null);
                //panelBookStore add item
                    panelBookStore.add(panelBook[i]);
            }
            //panelBook child item
                for (int i = 0 ; i < count ; i++)
                {
                    int j = i;
                    image[i] = new ImageIcon("");
                    panelImage[i] = new JPanel()
                    {
                        @Override
                        public void paintComponent(Graphics g)
                        {
                            Dimension d = getSize();
                            g.drawImage(image[j].getImage(),0,0,d.width,d.height,null);
                            setOpaque(false);
                            super.paintComponent(g);
                        }
                    };
                    panelImage[i].setBounds(leftPanelImage, upPanelImage, widthPanelImage, heightPanelImage);
                    panelName[i].setBounds(leftPanelName, upPanelName, widthPanelName, heightPanelName);
                    panelName[i].setLayout(null);
                    labelName[i].setBounds(leftLabelName, upLabelName , widthLabelName, heightLabelName);
                    //panelName add item
                        panelName[i].add(labelName[i]);
                    //panelBook add item
                        panelBook[i].add(panelImage[i]);
                        panelBook[i].add(panelName[i]);
                }     
        //panelButton child item
            buttonPre.setBounds(leftButtonPre, upButtonPre, widthButtonPre, heightButtonPre);
            buttonPre.setText("Trang trước");
            buttonPost.setBounds(leftButtonPost, upButtonPost, widthButtonPost, heightButtonPost);
            buttonPost.setText("Trang sau");
            //Add panelButtonChild
                panelButton.add(buttonPre);
                panelButton.add(buttonPost);
                buttonPre.setEnabled(false);
                buttonPost.setEnabled(false);
    }
    
//CREATE PANEL INFO CHILD
    public static void createPanelInfoChild (
            JPanel panelInfo, JPanel panelIcon, JLabel labelItemName, JLabel labelItemType,
            JLabel labelItemAuthor, JLabel labelItemDate, JLabel labelItemPublishingCompany,
            JLabel labelItemView, JLabel labelItemPrice, JLabel labelItemQuantity,
            int leftPanelIcon  ,int upPanelIcon  ,int widthPanelIcon  ,int heightPanelIcon,
            int leftLabelItemName   ,int upLabelItemName   ,int widthLabelItemName   ,int heightLabelItemName,
            int leftLabelItemType ,int upLabelItemType ,int widthLabelItemType ,int heightLabelItemType,
            int leftLabelItemAuthor   ,int upLabelItemAuthor   ,int widthLabelItemAuthor   ,int heightLabelItemAuthor,
            int leftLabelItemDate   ,int upLabelItemDate   ,int widthLabelItemDate   ,int heightLabelItemDate,
            int leftLabelItemPublishingCompany   ,int upLabelItemPublishingCompany   ,int widthLabelItemPublishingCompany   ,int heightLabelItemPublishingCompany,
            int leftLabelItemView   ,int upLabelItemView   ,int widthLabelItemView   ,int heightLabelItemView,
            int leftLabelItemPrice   ,int upLabelItemPrice   ,int widthLabelItemPrice   ,int heightLabelItemPrice,
            int leftLabelItemQuantity   ,int upLabelItemQuantity   ,int widthLabelItemQuantity   ,int heightLabelItemQuantity,
    
            JButton buttonChoose, JButton buttonBuy, JButton buttonBorrow,
            int leftButtonChoose, int upButtonChoose, int widthButtonChoose, int heightButtonChoose,
            int leftButtonBuy   , int upButtonBuy   , int widthButtonBuy   , int heightButtonBuy   ,
            int leftButtonBorrow, int upButtonBorrow, int widthButtonBorrow, int heightButtonBorrow)
    {
        panelIcon.setBounds(leftPanelIcon, upPanelIcon, widthPanelIcon, heightPanelIcon);
        panelIcon.setBackground(Color.BLACK);
        labelItemName.setBounds(leftLabelItemName, upLabelItemName, widthLabelItemName, heightLabelItemName);
        labelItemType.setBounds(leftLabelItemType, upLabelItemType, widthLabelItemType, heightLabelItemType);
        labelItemAuthor.setBounds(leftLabelItemAuthor, upLabelItemAuthor, widthLabelItemAuthor, heightLabelItemAuthor);
        labelItemDate.setBounds(leftLabelItemDate, upLabelItemDate, widthLabelItemDate, heightLabelItemDate);
        labelItemPublishingCompany.setBounds(leftLabelItemPublishingCompany, upLabelItemPublishingCompany, widthLabelItemPublishingCompany, heightLabelItemPublishingCompany);
        labelItemPrice.setBounds(leftLabelItemView, upLabelItemView, widthLabelItemView, heightLabelItemView);
        labelItemQuantity.setBounds(leftLabelItemPrice, upLabelItemPrice, widthLabelItemPrice, heightLabelItemPrice);
        //labelItemQuantity.setBounds(leftLabelItemQuantity, upLabelItemQuantity, widthLabelItemQuantity, heightLabelItemQuantity);
        //Add panelInfoChild
            panelInfo.add(panelIcon);
            panelInfo.add(labelItemName);
            panelInfo.add(labelItemType);
            panelInfo.add(labelItemAuthor);
            panelInfo.add(labelItemDate);
            panelInfo.add(labelItemPublishingCompany);
            panelInfo.add(labelItemView);
            panelInfo.add(labelItemPrice);
            panelInfo.add(labelItemQuantity);
            
        //Add panelInfoChild Button
        buttonChoose.setBounds(leftButtonChoose, upButtonChoose, widthButtonChoose, heightButtonChoose);
        buttonChoose.setText("Chọn");
        buttonChoose.setEnabled(false);
        buttonBuy.setBounds(leftButtonBuy, upButtonBuy, widthButtonBuy, heightButtonBuy);
        buttonBuy.setText("Mua");
        buttonBuy.setEnabled(false);
        buttonBorrow.setBounds(leftButtonBorrow, upButtonBorrow, widthButtonBorrow, heightButtonBorrow);
        buttonBorrow.setText("Mượn");
        buttonBorrow.setEnabled(false);
        //Add buttonChose
//            panelInfo.add(buttonChoose);
            panelInfo.add(buttonBuy);
            panelInfo.add(buttonBorrow);
    }
//=================================================================================================================================    
}
