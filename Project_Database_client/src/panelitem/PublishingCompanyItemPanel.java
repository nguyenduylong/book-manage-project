package panelitem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import object.BookItem;
import static panelitem.AuthorItemPanel.list;
import static panelitem.AuthorItemPanel.listSearch;
import project_database.Client;
import project_database.Hoa_don_mua;
import project_database.Phieu_thue;
import support.MinhBeoLibs;
import support.MyCanvas;

public class PublishingCompanyItemPanel extends javax.swing.JPanel {
    static Client client;

    //CONNECT DB
        static int pos;
        String DBColumn = "NXB";
        String DBName = "Sach";
        String DBTheLoai = "TheLoai";
        String DBSachTheLoai = "Sach_TheLoai";
        
    //DATA
        static DefaultListModel<String> list = new DefaultListModel<>();
        ArrayList<String> type;
        ArrayList<String> typeChild;
        ArrayList<BookItem> books;
        ArrayList<BookItem> booksOne = new ArrayList<>();
        ArrayList<BookItem> booksTwo = new ArrayList<>();
        ArrayList<BookItem> booksThree = new ArrayList<>();
        int count = 15;
        int flag = 0;
        int change = 0;
        ImageIcon image[] = new ImageIcon[count];
        ImageIcon icon = new ImageIcon();
        
    //DIMEN
        static private Dimension dimension;
    
    //BORDER
        TitledBorder title;
        Border loweredbevel, blackline;
    
    //PARENT PANEL
        JPanel panelParent = new JPanel();
        //PARENT PANEL CHILD
            JPanel panelSearch = new JPanel();
            JPanel panelProduct = new JPanel();
            JPanel panelInfo = new JPanel();
            
    //PANEL SEARCH CHILD
        JLabel labelSearch = new JLabel();
        JTextField textSearch = new JTextField();
        JButton buttonSearch = new JButton();
        JScrollPane scrollListSearch = new JScrollPane();
        static JList listSearch = new JList();
    
    //PANEL PRODUCT CHILD
        JPanel panelBookStore = new JPanel();
        JPanel panelBookStoreOnline = new JPanel(new BorderLayout());
        MyCanvas canvas ;
        // Child panelBookStore
            JPanel panelBook[] = new JPanel[count];
            JPanel panelImage[] = new JPanel[count];
            JPanel panelName[] = new JPanel[count];
            JLabel labelName[] = new JLabel[count];
            JPanel panelButton  = new JPanel();
        // Child panelButton
            JButton buttonPre = new JButton();
            JButton buttonPost = new JButton();
            
    //PANEL INFO CHILD
        JPanel panelIcon;
        JLabel labelItemName = new JLabel();
        JLabel labelItemType = new JLabel();
        JLabel labelItemAuthor = new JLabel();
        JLabel labelItemDate = new JLabel();
        JLabel labelItemPublishingCompany = new JLabel();
        JLabel labelItemView = new JLabel();
        JLabel labelItemPrice = new JLabel();
        JLabel labelItemQuantity = new JLabel();
        //BUTTON DEAL
            JButton buttonChoose = new JButton();
            JButton buttonBorrow = new JButton();
            JButton buttonBuy = new JButton();
            
    public PublishingCompanyItemPanel(Dimension dimension,Client client) {
        this.dimension = dimension;
        this.client = client;
        int width = dimension.width;
        int height = dimension.height;
        list.clear();
        initComponents();labelSearch.setText("Nhập Tên NXB");
                        
        
//PANEL SIZE
        //panelParent
            int leftPanelParent = 0, upPanelParent = 0, widthPanelParent = width, heightPanelParent = height;
        //panelParentChild
            int leftPanelSearch = width / 60, leftPanelProduct = width / 60 * 16, leftPanelInfo = width / 60 * 45;
            int upPanelParentChild = height / 20;
            int widthPanelSearch = width / 60 * 14, widthPanelProduct = width / 60 * 28, widthPanelInfo = width / 60 * 14;
            int heightPanelParentChild = height / 20 * 18;
        //panelSearchChild
            int leftLabelSearch = width / 60, upLabelSearch = height / 20, widthLabelSearch = width / 60 * 4, heightLabelSearch = height / 20;
            int leftTextSearch = width / 60 * 6, upTextSearch = height / 20, widthTextSearch = width / 60 * 7, heightTextSearch = height / 20;
            int leftButtonSearch = width / 60 * 6, upButtonSearch = (height * 9) / (20 * 4), widthButtonSearch = width / 60 * 7, heightButtonSearch = height / 20;
            int leftListSearch = width / 60, upListSearch = height * 4 / 20, widthListSearch = width / 60 * 12, heightListSearch = height / 20 * 13;
        //panelProductChild
            int leftPanelBookStore = width / 60, upPanelBookStore = height / 20, widthPanelBookStore = width / 60 * 26, heightPanelBookStore = height / 20 * 29 / 2;
            int leftPanelButton = width / 60, upPanelButton = height / 20 * 31 / 2, widthPanelButton = width / 60 * 26, heightPanelButton = height / 20 * 3 / 2;
            int leftPanelImage = width / 60 / 2, upPanelImage = 0, widthPanelImage = width / 60 * 21 / 5, heightPanelImage = height / 20 * 4;
            int leftPanelName = width / 60 / 2, upPanelName = height / 20 * 4, widthPanelName = width / 60 * 21 / 5, heightPanelName = height / 20 * 5 / 6;
            int leftLabelName = 0, upLabelName = 0, widthLabelName = width / 60 * 21 / 5, heightLabelName = height / 20 * 5 / 6;
            int leftButtonPre = width / 60 * 7, upButtonPre = height / 20 / 2, widthButtonPre= width / 60 * 5, heightButtonPre = height / 20;
            int leftButtonPost = width / 60 * 14, upButtonPost = height / 20 / 2, widthButtonPost = width / 60 * 5, heightButtonPost = height / 20;
        //panelInfoChild
            int leftPanelIcon = width / 60 * 2, upPanelIcon = height / 20, widthPanelIcon = width / 60 * 10, heightPanelIcon = height / 20 * 8;
            int leftLabelItemName = width / 60 * 2, upLabelItemName = height / 20 * 10, widthLabelItemName = width / 60 * 10, heightLabelItemName = height / 20 * 3 / 4;
            int leftLabelItemType = width / 60 * 2, upLabelItemType = height / 20 * 43 / 4, widthLabelItemType = width / 60 * 10, heightLabelItemType = height / 20 * 3 / 4;
            int leftLabelItemAuthor = width / 60 * 2, upLabelItemAuthor = height / 20 * 46 / 4, widthLabelItemAuthor = width / 60 * 10, heightLabelItemAuthor = height / 20 * 3 / 4;
            int leftLabelItemDate = width / 60 * 2, upLabelItemDate = height / 20 * 49 / 4, widthLabelItemDate = width / 60 * 10, heightLabelItemDate = height / 20 * 3 / 4;
            int leftLabelItemPublishingCompany = width / 60 * 2, upLabelItemPublishingCompany = height / 20 * 52 / 4, widthLabelItemPublishingCompany = width / 60 * 10, heightLabelItemPublishingCompany = height / 20 * 3 / 4;
            int leftLabelItemView = width / 60 * 2, upLabelItemView = height / 20 * 55 / 4, widthLabelItemView = width / 60 * 10, heightLabelItemView = height / 20 * 3 / 4;
            int leftLabelItemPrice = width / 60 * 2, upLabelItemPrice = height / 20 * 58 / 4, widthLabelItemPrice = width / 60 * 10, heightLabelItemPrice = height / 20 * 3 / 4;
            int leftLabelItemQuantity = width / 60 * 2, upLabelItemQuantity = height / 20 * 61 / 4, widthLabelItemQuantity = width / 60 * 10, heightLabelItemQuantity = height / 20 * 3 / 4;
        //buttonDeal
            int leftButtonChoose = width / 60 * 5, upButtonChoose = height / 20 * 16, widthButtonChoose = width / 60 * 4, heightButtonChoose = height / 20;
            int leftButtonBuy = width / 60 * 3, upButtonBuy = height / 20 * 16, widthButtonBuy = width / 60 * 3, heightButtonBuy = height / 20;
            int leftButtonBorrow = width / 60 * 8, upButtonBorrow = height / 20 * 16, widthButtonBorrow = width / 60 * 3, heightButtonBorrow = height / 20;
            canvas = new MyCanvas(heightPanelBookStore, widthPanelBookStore);
            panelBookStoreOnline.add(canvas);
//===================================================================================================================================                            
            
      
            
            
//ADD PARENT PANEL
        //panelParent
            panelParent.setBounds(leftPanelParent, upPanelParent, widthPanelParent, heightPanelParent);
            title = BorderFactory.createTitledBorder(loweredbevel, "Tìm Kiếm");
            title.setTitlePosition(TitledBorder.ABOVE_TOP);
            panelParent.setBorder(title);
            panelParent.setLayout(null);
            //panelSearch
                panelSearch.setBounds(leftPanelSearch, upPanelParentChild, widthPanelSearch, heightPanelParentChild);
                title = BorderFactory.createTitledBorder(loweredbevel, "Tìm Kiếm");
                title.setTitleJustification(TitledBorder.CENTER);
                panelSearch.setBorder(title);
                panelSearch.setLayout(null);
            //panelProduct
                panelProduct.setBounds(leftPanelProduct, upPanelParentChild, widthPanelProduct, heightPanelParentChild);
                title = BorderFactory.createTitledBorder(loweredbevel, "Sách");
                title.setTitleJustification(TitledBorder.CENTER);
                panelProduct.setBorder(title);
                panelProduct.setLayout(null);
            //panelInfo
                panelInfo.setBounds(leftPanelInfo, upPanelParentChild, widthPanelInfo, heightPanelParentChild);
                title = BorderFactory.createTitledBorder(loweredbevel, "Thông tin");
                title.setTitleJustification(TitledBorder.CENTER);
                panelInfo.setBorder(title);
                panelInfo.setLayout(null);
        //Add panelParent
            add(panelParent);
            //Add panelParent Child
                panelParent.add(panelSearch);
                panelParent.add(panelProduct);
                panelParent.add(panelInfo);
//===================================================================================================================================                                
                

                
                
//(PANEL SEARCH)

                MinhBeoLibs.createPanelSearchChild(labelSearch, textSearch, buttonSearch, scrollListSearch, panelSearch, listSearch, leftLabelSearch, upLabelSearch, widthLabelSearch, heightLabelSearch, leftTextSearch, upTextSearch, widthTextSearch, heightTextSearch, leftButtonSearch, upButtonSearch, widthButtonSearch, heightButtonSearch, leftListSearch, upListSearch, widthListSearch, heightListSearch);
        for(int i=0;i<client.TacGia.size();i++)
            list.addElement(client.TacGia.get(i));
        listSearch.setModel(list);
        //BUTTON SEARCH
        buttonSearch.addActionListener((ActionEvent e) -> {
            list = new DefaultListModel<>();
            KQ_TimKiem(textSearch.getText().trim());
        });
        //ACTION ENTER
            textSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                list = new DefaultListModel<>();
                KQ_TimKiem(textSearch.getText().trim());
            }
        });
        
        
        

//(PANEL PRODUCT)
        for (int i = 0 ; i < count ; i++)
        {
            panelBook[i] = new JPanel();
            panelName[i] = new JPanel();
            labelName[i] = new JLabel();
        }
        MinhBeoLibs.createPanelProductChild(panelBookStoreOnline, panelBookStore, panelButton, panelProduct, panelBook, panelImage, panelName, labelName, buttonPre, buttonPost, leftPanelBookStore, upPanelBookStore, widthPanelBookStore, heightPanelBookStore, leftPanelButton, upPanelButton, widthPanelButton, heightPanelButton, leftPanelImage, upPanelImage, widthPanelImage, heightPanelImage, leftPanelName, upPanelName, widthPanelName, heightPanelName, leftLabelName, upLabelName, widthLabelName, heightLabelName, leftButtonPre, upButtonPre, widthButtonPre, heightButtonPre, leftButtonPost, upButtonPost, widthButtonPost, heightButtonPost, count, image);
//===================================================================================================================================
        
        
        
        
        
//(PANEL INFO)
        icon = new ImageIcon("");
        panelIcon = new JPanel(){
            @Override
            public void paintComponent(Graphics g)
            {
                Dimension d = getSize();
                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        MinhBeoLibs.createPanelInfoChild(panelInfo, panelIcon, labelItemName, labelItemType, labelItemAuthor, labelItemDate, labelItemPublishingCompany, labelItemView, labelItemPrice, labelItemQuantity, leftPanelIcon, upPanelIcon, widthPanelIcon, heightPanelIcon, leftLabelItemName, upLabelItemName, widthLabelItemName, heightLabelItemName, leftLabelItemType, upLabelItemType, widthLabelItemType, heightLabelItemType, leftLabelItemAuthor, upLabelItemAuthor, widthLabelItemAuthor, heightLabelItemAuthor, leftLabelItemDate, upLabelItemDate, widthLabelItemDate, heightLabelItemDate, leftLabelItemPublishingCompany, upLabelItemPublishingCompany, widthLabelItemPublishingCompany, heightLabelItemPublishingCompany, leftLabelItemView, upLabelItemView, widthLabelItemView, heightLabelItemView, leftLabelItemPrice, upLabelItemPrice, widthLabelItemPrice, heightLabelItemPrice, leftLabelItemQuantity, upLabelItemQuantity, widthLabelItemQuantity, heightLabelItemQuantity, buttonChoose, buttonBuy, buttonBorrow, leftButtonChoose, upButtonChoose, widthButtonChoose, heightButtonChoose, leftButtonBuy, upButtonBuy, widthButtonBuy, heightButtonBuy, leftButtonBorrow, upButtonBorrow, widthButtonBorrow, heightButtonBorrow);
//===================================================================================================================================
  
        
        
        
        
//(RELATION OF PANEL)
        //list click item
        listSearch.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String tacgia = list.getElementAt(listSearch.getSelectedIndex()).trim();
                client.status = false;
                ///////////////////////////////////////////
                panelBookStore.setVisible(false);
                panelBookStoreOnline.setVisible(true);
                ///////////////////////////////////////////
                Thread x = new Thread(){

                    @Override
                    public void run() {
                        client.SEND("MuonSach_search2");
                client.SEND("select * from \"Sach\" where \"NXB\" = '"+tacgia+"'");
                while(client.status==false) System.out.println("waiting ...");
                for (int i = 0; i < count; i++){
                    if(i*8<client.TimSach.size()){
                        image[i] = new ImageIcon(client.TimSach.get(i*8));
                        labelName[i].setText(client.TimSach.get(i*8+1));
                    }
                else{
                        image[i] = new ImageIcon();
                        labelName[i].setText("");
                    }
                }
                flag = 0;
                if(flag==0)
                    buttonPre.setEnabled(false);
                if(flag==client.TimSach.size()/8 / count)
                    buttonPost.setEnabled(false);
                else buttonPost.setEnabled(true);
                buttonBorrow.setEnabled(false);
                buttonBuy.setEnabled(false);
                labelItemName.setText("");
                labelItemType.setText("");
                labelItemAuthor.setText("");
                labelItemDate.setText("");
                labelItemPublishingCompany.setText("");
                labelItemView.setText("");
                labelItemPrice.setText("");
                labelItemQuantity.setText("");
                icon = new ImageIcon ("");
                panelBookStore.setVisible(true);
                panelBookStoreOnline.setVisible(false);
                repaint();
                if (flag == client.TimSach.size()/8 / count)
                    change = client.TimSach.size()/8;
                else change = count;
                    }
                };
                x.start();
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
        });
        
        
        //add panel click listener
        for(int i = 0 ; i < count ; i++)
        {
            int j = i;
            panelImage[i].addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    for (int i = 0 ; i < change ; i++)
                    {
                        pos = (flag*count+j)*8;
                        icon = new ImageIcon(client.TimSach.get((flag*count+j)*8));
                        panelIcon = new JPanel()
                        {
                            @Override
                            public void paintComponent(Graphics g)
                            {
                                Dimension d = getSize();
                                g.drawImage(icon.getImage(),0,0,d.width,d.height,null);
                                setOpaque(false);
                                super.paintComponent(g);
                            }
                        };
                        repaint();
                        labelItemName.setText("Tên sách: " +client.TimSach.get((flag*count+j)*8+1));
                        labelItemType.setText("Thể loại: " +client.TimSach.get((flag*count+j)*8+5));
                        labelItemAuthor.setText("Tác giả : " +client.TimSach.get((flag*count+j)*8+3));
                        labelItemDate.setText("Mã sách : "+ client.TimSach.get((flag*count+j)*8+2));
                        labelItemPublishingCompany.setText("Ngày phát hành : " +client.TimSach.get((flag*count+j)*8+4));
                        labelItemView.setText(client.TimSach.get((flag*count+j)*8+1));
                        labelItemView.setVisible(false);
                        labelItemPrice.setText("Giá thành : " +client.TimSach.get((flag*count+j)*8+6));
                        labelItemQuantity.setText("Số lượng : " +client.TimSach.get((flag*count+j)*8+7));
                        buttonBuy.setEnabled(true);
                        buttonBorrow.setEnabled(true);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e)
                {
                }

                @Override
                public void mouseReleased(MouseEvent e) 
                {
                }

                @Override
                public void mouseEntered(MouseEvent e) 
                {
                }

                @Override
                public void mouseExited(MouseEvent e) 
                {
                }
            });
        }
        

        
    //(BUTTON PANEL)        
        //button Post
        buttonPost.addActionListener((ActionEvent e) -> {
            flag++;
            for (int i = 0 ; i < count ; i++)
            {
                if(count * flag + i < client.TimSach.size()/8)
                {
                    image[i] = new ImageIcon (client.TimSach.get((count * flag + i)*8));
                    labelName[i].setText(client.TimSach.get((count * flag + i)*8+1));
                }
                else
                {
                    image[i] = new ImageIcon ();
                    labelName[i].setText("");
                }
            }
            repaint();
            if (flag == client.TimSach.size()/8 / count)
            {
                buttonPost.setEnabled(false);
            }
            else
                buttonPost.setEnabled(true);
            if (flag == 0)
            {
                buttonPre.setEnabled(false);
            }
            else
                buttonPre.setEnabled(true);
        });
        
        
        //button Pre
        buttonPre.addActionListener((ActionEvent e) -> {
            flag--;
            for (int i = 0 ; i < count ; i++)
            {
                if(count * flag + i < client.TimSach.size()/8)
                {
                    image[i] = new ImageIcon (client.TimSach.get((count * flag + i)*8));
                    labelName[i].setText(client.TimSach.get((count * flag + i)*8+1));
                }
                else
                {
                    image[i] = new ImageIcon ();
                    labelName[i].setText("");
                }
            }
            repaint();
            if (flag == client.TimSach.size()/8 / count)
            {
                buttonPost.setEnabled(false);
            }
            else
                buttonPost.setEnabled(true);
            if (flag == 0)
            {
                buttonPre.setEnabled(false);
            }
            else
                buttonPre.setEnabled(true);
        });
        buttonBorrow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int sachcon =  Integer.parseInt(labelItemQuantity.getText().substring(11));
                if(sachcon==0)
                    JOptionPane.showMessageDialog(null,"Xin lỗi, đã hết sách !!");
                else
                {
                    new Phieu_thue(client.DocGia[0], labelItemName.getText().substring(10),
                            labelItemDate.getText().substring(10),labelItemPrice.getText().substring(12) ,
                          client.TimSach.get(pos)  , client, null, -1).setVisible(true);
                }
            }
        });
        buttonBuy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int sachcon =  Integer.parseInt(labelItemQuantity.getText().substring(11));
                if(sachcon==0)
                    JOptionPane.showMessageDialog(null,"Xin lỗi, đã hết sách !!");
                else
                {
                    new Hoa_don_mua(client.DocGia[0], labelItemDate.getText().substring(10),
                            labelItemPrice.getText().substring(12), labelItemName.getText().substring(10),
                            client.DocGia[1] , client, null, -1).setVisible(true);
                }
            }
        });
    //(BUTTON PANEL)=================================================================================================================
//(RELATION OF PANEL)================================================================================================================  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public static void KQ_TimKiem(String str)
    {
        list.clear();
        for(int i =0 ;i<client.TacGia.size();i++)
        {
            if(client.TacGia.get(i).startsWith(str)==true)
            {
                list.addElement(client.TacGia.get(i));
            }
        }
        listSearch.setModel(list);
    }
}
