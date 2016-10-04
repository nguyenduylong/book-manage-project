import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server_return implements Runnable{
    static Connection con = Connect.ConnectDB();
    static PreparedStatement pst;
    static Statement st =null;
    static ResultSet rs;
    FileInputStream fis;    
    Socket SOCK;
    private Scanner INPUT;
    private PrintWriter OUT;
    String MESS;
    String DocGia[] = new String[7];
    String user_pass[] = new String[2];
    String s[][] = new String[10][27];
    String top5Sach[][] = new String[10][5];
    String hitDetai[][] = new String[2][2];
    String query;
    ArrayList<String> SachMuon = new ArrayList<String>();
    static ArrayList<String> RB = new ArrayList<String>();
    static ArrayList<String> TacGia = new ArrayList<String>();
    public Server_return(Socket SOCK)
    {
        this.SOCK = SOCK;
    }
    @Override
    public void run() {
        try {
            int count;
            INPUT = new Scanner(SOCK.getInputStream());
            OUT = new PrintWriter(SOCK.getOutputStream());
            while(true)
            {
                if(!INPUT.hasNext())
                    return ;
                
                MESS = INPUT.nextLine();
                System.out.println("Client said: "+MESS);
                BufferedWriter os = new BufferedWriter(new OutputStreamWriter(SOCK.getOutputStream()));
                switch(MESS)
                {
                    case "GioiThieu":
                    {
                        os.write("GioiThieu");
                        os.newLine();
                        os.flush();
                        loadDataGioiThieu();
                        for(int i=0;i<2;i++)
                        {
                            for(int j =0;j<2;j++)
                            {
                                os.write(hitDetai[i][j]);
                                os.newLine();
                                os.flush();        
                            }
                        }
                        for(int i =0; i<27;i++)
                        {
                            for(int j=0;j<10;j++)
                            {
                                os.write(s[j][i]);
                                os.newLine();
                                os.flush();
                            }
                            if(s[0][i].compareTo("")!=0)
                            {
                                sendImage(s[0][i], os);
                            }
                        }
                        for(int i = 0; i <5; i++)
                        {
                            for(int j =0; j<10;j++)
                            {
                                os.write(top5Sach[j][i]);
                                os.newLine();
                                os.flush();
                            }
                            if(s[0][i].compareTo("")!=0)
                            {
                                fis =new FileInputStream(top5Sach[0][i]);
                                int c,b=-1;
                                while((c=fis.read())!=-1)
                                    os.write(c);
                                fis.close();
                                os.flush();
                                os.write(b);
                                os.flush();
                            }
                        }
                        break;
                    }
                    case "Login":
                    {
                        user_pass[0] = INPUT.nextLine();
                        user_pass[1] = INPUT.nextLine();
                        int i = Login();
                        os.write("Login");
                        os.newLine();
                        os.flush();
                        os.write(i);
                        os.flush();
                        if(i==1)
                        {
                            int size;
                            for (int j = 0; j < 7; j++) {
                                os.write(DocGia[j]);
                                os.newLine();
                                os.flush();
                            }
                            SachdaMuon();
                            if(SachMuon!=null) size = SachMuon.size();
                            else size = 0;
                            System.out.println(size);
                            os.write(SachMuon.size());
                            os.flush();
                            for (int j = 0; j < SachMuon.size(); j++) {
                                os.write(SachMuon.get(j));
                                os.newLine();
                                os.flush();
                            }
                        }
                        break;
                    }
                    case "MuonSach_search":
                    {
                        query = INPUT.nextLine();
                        MuonSach_search(query);
                        os.write("MuonSach_search");
                        os.newLine();
                        os.flush();
                        os.write(SachMuon.size());
                        os.flush();
                        if(SachMuon.size()!=0)
                        {
                            for (int i = 0; i < SachMuon.size(); i++) {
                                os.write(SachMuon.get(i));
                                os.newLine();
                                os.flush();
                            }
                        }
                        break;
                    }
                    case "MuonSach_search2":
                    {
                        query = INPUT.nextLine();
                        MuonSach_search(query);
                        os.write("MuonSach_search2");
                        os.newLine();
                        os.flush();
                        os.write(SachMuon.size());
                        os.flush();
                        if(SachMuon.size()!=0)
                        {
                            for (int i = 0; i < SachMuon.size(); i++) {
                                os.write(SachMuon.get(i));
                                os.newLine();
                                os.flush();
                            }
                            for(int i =0;i<SachMuon.size()/8;i++)
                                sendImage(SachMuon.get(i*8),os);
                        }
                        break;
                    }
                    case "loadImage":
                    {
                        String s;
                        s = INPUT.nextLine();
                        os.write("loadImage");
                        os.newLine();
                        os.flush();
                        os.write(s);
                        os.newLine();
                        os.flush();
                        sendImage(s, os);
                        break;
                    }
                    case "Signup":
                    {
                        String name,sex,id,pass,Email,bd,phone,Add;
                        name = INPUT.nextLine(); sex =INPUT.nextLine(); id =INPUT.nextLine();
                        pass = INPUT.nextLine(); Email = INPUT.nextLine(); bd = INPUT.nextLine();
                        phone =INPUT.nextLine(); Add= INPUT.nextLine();
                        SignUp(name,sex,id,pass,Email,bd,phone,Add,os);
                        break;
                    }
                    case "MuaSach":
                    {
                        String maDocGia, giaTien, date, maSach;
                        maDocGia = INPUT.nextLine();
                        giaTien = INPUT.nextLine();
                        System.out.println(giaTien);
                        maSach = INPUT.nextLine();
                        date = INPUT.nextLine();
                        String query1 = INPUT.nextLine();
                        String query = "insert into \"HoaDon\"(\"SoHoaDon\",\"MaDocGia\",\"SoTien\",\"NgayLap\",\"MaSach\")"
        + "values ('"+KiemTra("HoaDon")+"','"+maDocGia+"','"+giaTien+"','"+date+"','"+maSach+"')";
                        try {
                            st = con.createStatement();
                            st.execute(query);
                        } catch (SQLException ex) {
                            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            st = con.createStatement();
                            st.execute(query1);
                        } catch (SQLException ex) {
                            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                    case "ThueSach":
                    {
                        String MDG,MS,datemuon,datetra,Tien,kiemtra;
                        MDG = INPUT.nextLine();
                        MS = INPUT.nextLine();
                        datemuon = INPUT.nextLine();
                        datetra = INPUT.nextLine();
                        kiemtra = KiemTra("PhieuThue");
                        String query0 = "insert into \"PhieuThue\" "
                            + "values ('"+kiemtra+"','"+MDG+"','"+MS+"','"+datemuon+"','"+datetra+"')";
                        System.out.println(query0);
                        String query01 = "update \"Sach\" set \"SoLuong\" = \"SoLuong\"-1 ,\"LuotXem\" = \"LuotXem\"+1 where \"MaSach\" = '"+MS+"'";
                        Statement st1 = null;
                        try {
                            st = con.createStatement();
                            st.execute(query0);
                            st1 = con.createStatement();
                            st1.execute(query01);
                            os.write("ThueSach");os.newLine();os.flush();
                            os.write("Bạn đã gửi yêu cầu thành công !");os.newLine();os.flush();
                            os.write(kiemtra);os.newLine();os.flush();
                        } catch (SQLException ex) {
                            os.write("ThueSach");os.newLine();os.flush();
                            os.write("*! Error !*");os.newLine();os.flush();
                            }
                        break;
                    }
                    case "TraSach":
                    {
                        String c;
                        String TDG,date,tienphat;
                        int sotienphat;
                        int tienhoadon;
                        date = INPUT.nextLine();
                        System.out.println(date);
                        TDG = INPUT.nextLine();
                        System.out.println(TDG);
                        c = INPUT.nextLine();
                        System.out.println(c);
                        if(c.compareTo("1")==0)
                        {
                        TDG = INPUT.nextLine();
                        tienphat= INPUT.nextLine();
                        sotienphat = Integer.parseInt(tienphat);
                        String query_ts ="insert into \"PhieuPhat\"(\"SoPhieuPhat\",\"TheDocGia\","
                        + "\"NgayLapPhieuPhat\",\"TienPhat\") values('"+KiemTra("PhieuPhat")+"','"+TDG+"','"+date+"','"+sotienphat+"')";            
                        System.out.println(query_ts);    
                        try {
                            st = con.createStatement();
                            st.execute(query_ts);
                        } catch (SQLException ex) {
                            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                        String query_d = INPUT.nextLine();
                        String query_a = INPUT.nextLine();
                        System.out.println(query_d);
                        System.out.println(query_a);
                        tienhoadon = Integer.parseInt(INPUT.nextLine());
                    try {
                        st = con.createStatement();
                        st.execute(query_d);
                    } catch (SQLException ex) {
                        Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        st = con.createStatement();
                        st.execute(query_a);
                    } catch (SQLException ex) {
                        Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        String query_hd = "insert into \"HoaDon\"(\"SoHoaDon\",\"MaDocGia\",\"SoTien\",\"NgayLap\")"
                    + "values ('"+KiemTra("HoaDon")+"','DG"+TDG.substring(3)+"','"+tienhoadon+"','"+date+"')";
                        try {
                        st = con.createStatement();
                        st.execute(query_hd);
                    } catch (SQLException ex) {
                        Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        break;
                    }
                    case "ThongKe":
                    {
                        ThongKe(INPUT.nextLine(),os);
                        break;
                    }
                    case "TacGia":
                    {
                        int cou_tg = loadTacGia();
                        os.write("TacGia");os.newLine();os.flush();
                        os.write(cou_tg);os.flush();
                        for (int i = 0; i < cou_tg; i++) {
                            os.write(TacGia.get(i));os.newLine();os.flush();
                        }
                        break;
                    }
                    case "NXB":
                    {
                        int cou_NXB = loadNXB();
                        os.write("NXB");os.newLine();os.flush();
                        os.write(cou_NXB);os.flush();
                        for(int i=0;i<cou_NXB;i++)
                        {
                            os.write(TacGia.get(i));os.newLine();os.flush();
                        }
                        break;
                    }
                    case "TheLoaiSach":
                    {
                        int cou_TLS= loadTLS();
                        os.write("TheLoaiSach");os.newLine();os.flush();
                        os.write(cou_TLS);os.flush();
                        for(int i=0;i<cou_TLS;i++)
                        {
                            os.write(TacGia.get(i));os.newLine();os.flush();
                        }
                        break;
                    }
                    case "ChangeINFO":
                    {
                        String q1,q2;
                        q1 = INPUT.nextLine();
                        q2 = INPUT.nextLine();
                        Statement st2 = null;
                        System.out.println(q1);System.out.println(q2);
                    try {
                        st = con.createStatement();
                        st.execute(q1);
                        st2= con.createStatement();
                        st2.execute(q2);
                        os.write("Signup");os.newLine();os.flush();
                        os.write("OK");os.newLine();os.flush();
                    } catch (SQLException ex) {
                        os.write("Signup");os.newLine();os.flush();
                        os.write("Thông tin thay đổi bị lỗi !!!");os.newLine();os.flush();
            
                    }
                        break;
                    }
                    default: break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void MuonSach_search(String query)
    {
        PreparedStatement pst1 = null;
        ResultSet rs1 = null;
        SachMuon.clear();
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next())
            {
                int i=0;
                String TenTheLoai="";
                pst1 = con.prepareStatement("select \"TenTheLoai\" from \"TheLoai\" natural join \"Sach\" natural join \"Sach_TheLoai\" where \"MaSach\" = '"+
                    rs.getString("MaSach")+"'");
                rs1 = pst1.executeQuery();
                while(rs1.next())
                {
                    if(i==0)
                    {
                        TenTheLoai += rs1.getString("TenTheLoai").trim(); i++;
                    }
                    else
                        TenTheLoai += ","+rs1.getString("TenTheLoai").trim();
                }
                if(rs.getString("FileImage")!=null)
                    SachMuon.add(rs.getString("FileImage"));
                else SachMuon.add("");
                SachMuon.add(rs.getString("TenSach").trim());
                SachMuon.add(rs.getString("MaSach").trim());
                SachMuon.add(rs.getString("TenTacGia").trim());
                SachMuon.add(rs.getString("NXB").trim());
                SachMuon.add(TenTheLoai.trim());
                SachMuon.add(rs.getString("GiaTien").trim());
                SachMuon.add(rs.getString("SoLuong").trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadDataGioiThieu()
    {
        try {
            int i=0;
            pst = con.prepareStatement("select \"MaTheLoai\",\"TenTheLoai\" from \"Sach\" natural join \"TheLoai\" natural join \"Sach_TheLoai\" group by (\"MaTheLoai\") order by sum(\"LuotXem\") DESC");
            rs = pst.executeQuery();
            while(rs.next()&&i<2)
            {
                hitDetai[0][i] = rs.getString("MaTheLoai").trim();
                hitDetai[1][i] = rs.getString("TenTheLoai").trim();
                i++;
            }
            for(int j=2;j>i;j--)
            {
                hitDetai[0][j-1]=hitDetai[1][j-1]="";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int count = 0;
            pst = con.prepareStatement("select * from \"Sach\" order by \"NgayPhatHanh\" DESC");
            rs = pst.executeQuery();
            while (rs.next()&&count<9)
            {
                s[0][count] = rs.getString("FileImage");
                if(s[0][count]==null) s[0][count] ="";
                s[1][count] = rs.getString("TenSach");
                s[2][count] = "Tổng số lượt xem: "+rs.getString("LuotXem").trim();
                s[3][count] = rs.getString("MaSach").trim();
                s[4][count] = rs.getString("TenTacGia").trim();
                s[5][count] = rs.getString("NgayPhatHanh").trim();
                s[6][count] = rs.getString("NXB").trim();
                s[7][count] = rs.getString("GiaTien").trim()+".000 đồng";
                s[8][count] = rs.getString("SoLuong").trim()+" quyển";
                count++;
            }
            for(int j=9;j>count;j--)
            {
                s[1][j-1]= "";
                for (int i = 1; i < 10; i++) {
                    s[i][j-1] = "";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int j=1;j<=2;j++)
        {
            try {
                int count=9*j;
                pst = con.prepareStatement("select * from \"Sach\" natural join \"TheLoai\" natural join \"Sach_TheLoai\" where \"MaTheLoai\" = '"+
                        hitDetai[0][j-1]+"'");
                rs = pst.executeQuery();
                while(rs.next()&&count<9*(j+1))
                {
                    s[0][count] = rs.getString("FileImage");
                    if(s[0][count]==null) s[0][count]="";
                    s[1][count] = rs.getString("TenSach");
                    s[2][count] = "Tổng số lượt xem: "+rs.getString("LuotXem").trim();
                    s[3][count] = rs.getString("MaSach").trim();
                    s[4][count] = rs.getString("TenTacGia").trim();
                    s[5][count] = rs.getString("NgayPhatHanh").trim();
                    s[6][count] = rs.getString("NXB").trim();
                    s[7][count] = rs.getString("GiaTien").trim()+".000 đồng";
                    s[8][count] = rs.getString("SoLuong").trim()+" quyển";
                    count++;
                }
                for(int k=9*(j+1);k>count;k--)
                {
                    s[0][k-1]="";
                    for (int i = 1; i < 10; i++) {
                        s[i][k-1]="";
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            pst = con.prepareStatement("select * from \"Sach\"order by \"LuotXem\" DESC");
            rs = pst.executeQuery();
            int i=0;
            while(rs.next()&&i<5)
            {
                top5Sach[0][i] = rs.getString("FileImage");
                if(top5Sach[0][i]==null) top5Sach[0][i]="1";
                top5Sach[1][i] = rs.getString("TenSach");
                top5Sach[2][i] = "Tổng số lượt xem: "+rs.getString("LuotXem").trim();
                top5Sach[3][i] = rs.getString("MaSach").trim();
                top5Sach[4][i] = rs.getString("TenTacGia").trim();
                top5Sach[5][i] = rs.getString("NgayPhatHanh").trim();
                top5Sach[6][i] = rs.getString("NXB").trim();
                top5Sach[7][i] = rs.getString("GiaTien").trim()+".000 đồng";
                top5Sach[8][i] = rs.getString("SoLuong").trim()+" quyển";
                i++;
            }
            for(int j = 5; j> i; j--)
            {
                top5Sach[0][j-1]="";
                for (int k = 1; k < 10; k++) {
                    top5Sach[k][j-1]="";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i =0 ;i<27;i++)
            if(s[3][i].compareTo("")!=0)
                s[9][i] = loadSachInfo_GioiThieu(s[3][i]);
        for(int i =0; i<5;i++)
            if(top5Sach[3][i].compareTo("")!=0)
                top5Sach[9][i] = loadSachInfo_GioiThieu(top5Sach[3][i]);
    }
    private String loadSachInfo_GioiThieu(String Ma_sach)
    {
        String info = "";
        try {
            int i=0;
            pst = con.prepareStatement("select \"TenTheLoai\" from \"TheLoai\" natural join \"Sach\" natural join \"Sach_TheLoai\" where \"MaSach\" = '"+
                    Ma_sach+"'");
            rs = pst.executeQuery();
            while(rs.next())
            {
                if(i==0){
                    info = info+ rs.getString("TenTheLoai").trim();i++;
                }
                else
                    info = info +", "+ rs.getString("TenTheLoai").trim();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;
    }
    public int Login()
    {
        try {
            pst = con.prepareStatement("select * from \"Account\" natural join \"DocGia\" where \"UserName\" = '"+user_pass[0]+"' "
                    +"and \"Password\" = '"+user_pass[1]+"'");
            rs = pst.executeQuery();
            if(rs.next())
            {
                DocGia[0] = rs.getString("MaDocGia").trim();
                DocGia[1] = rs.getString("HoTen").trim();
                DocGia[2] = rs.getString("GioiTinh").trim();
                DocGia[3] = rs.getString("NgaySinh").trim();
                DocGia[4] = rs.getString("Email").trim();
                DocGia[5] = rs.getString("DiaChi").trim();
                DocGia[6] = rs.getString("DienThoai").trim();
                return 1;
            }
            else return 0;
                    } catch (SQLException ex) {
            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public void SachdaMuon()
    {
        try {
            pst = con.prepareStatement("select \"SoPhieuMuon\",\"GiaTien\",\"FileImage\",\"MaSach\",\"TenSach\",\"NgayMuon\",\"NgayTra\" from \"Sach\" natural join \"PhieuThue\" natural join \"DocGia\" natural join \"TheDocGia\"  \n" +
"where \"MaDocGia\" = '"+DocGia[0]+"'");
            rs = pst.executeQuery();
            while(rs.next())
            {
                SachMuon.add(rs.getString("TenSach").trim());
                SachMuon.add(rs.getString("NgayMuon").trim());
                SachMuon.add(rs.getString("NgayTra").trim());
                SachMuon.add(rs.getString("MaSach").trim());
                SachMuon.add(rs.getString("FileImage").trim());
                SachMuon.add(rs.getString("GiaTien").trim());
                SachMuon.add(rs.getString("SoPhieuMuon").trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sendImage(String s,BufferedWriter os)
    {
        try {
            fis = new FileInputStream(s);
            int c;
            int b= -1;
            while((c=fis.read())!=-1)
            os.write(c);
            fis.close();
            //os.flush();
            os.write(b);
            os.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String KiemTra(String str)
    {
        Connection con = Connect.ConnectDB();
        PreparedStatement pst = null;
        ResultSet rset = null;
        int i=0;
        int i1=0;
        String s;
        switch (str)
        {
            case "DocGia":
            {
                try {
            pst = con.prepareStatement("select cast(substring(\"MaDocGia\",3) as int) from \"DocGia\" order by cast(substring(\"MaDocGia\",3) as int) ASC");
            rset = pst.executeQuery();
            while(rset.next())
            {
                s = rset.getString("substring");
                i = Integer.parseInt(s);
                if(i==i1+1)
                {
                    i1 = i;
                }
                else
                    return "DG"+(i1+1);
            }
            return "DG"+(i1+1);
        } catch (SQLException ex) {
            Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
            case "PhieuPhat":
            {
                try {
                    pst = con.prepareStatement("select cast(substring(\"SoPhieuPhat\",3) as int) from \"PhieuPhat\" order by cast(substring(\"SoPhieuPhat\",3) as int) ASC");
                    rset = pst.executeQuery();
                    while(rset.next())
                    {
                        s = rset.getString("substring");
                        i = Integer.parseInt(s);
                        if(i==i1+1)
                        {
                            i1 = i;
                        }
                        else
                            return "PP"+(i1+1);
                    }
                    return "PP"+(i1+1);
                    } catch (SQLException ex) {
                        Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            case "HoaDon":
            {
                try {
                    pst = con.prepareStatement("select cast(substring(\"SoHoaDon\",3) as int) from \"HoaDon\" order by cast(substring(\"SoHoaDon\",3) as int) ASC");
                    rset = pst.executeQuery();
                    while(rset.next())
                    {
                        s = rset.getString("substring");
                        i = Integer.parseInt(s);
                        if(i==i1+1)
                        {
                            i1 = i;
                        }
                        else
                            return "HD"+(i1+1);
                    }
                    return "HD"+(i1+1);
                    } catch (SQLException ex) {
                        Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            case "PhieuThue":
                {
                try {
                    pst = con.prepareStatement("select cast(substring(\"SoPhieuMuon\",3) as int) from \"PhieuThue\" order by cast(substring(\"SoPhieuMuon\",3) as int) ASC");
                    rset = pst.executeQuery();
                    while(rset.next())
                    {
                        s = rset.getString("substring");
                        i = Integer.parseInt(s);
                        if(i==i1+1)
                        {
                            i1 = i;
                        }
                        else
                            return "PM"+(i1+1);
                    }
                    return "PM"+(i1+1);
                    } catch (SQLException ex) {
                        Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
        return null;
    }
    public static void ThongKe(String str,BufferedWriter os) throws IOException
    {
        switch(str)
        {
            case "RB1":
            {
                RB.clear();
                try {
                    pst = con.prepareStatement("select * from \"Sach\" natural join \"Sach_TheLoai\" natural join \"TheLoai\"");
                    rs = pst.executeQuery();
                    while(rs.next())
                    {
                        RB.add(rs.getString("TenSach"));
                        RB.add(rs.getString("MaSach"));
                        RB.add(rs.getString("TenTacGia"));
                        RB.add(rs.getString("NXB"));
                        RB.add(rs.getString("TenTheLoai"));
                        RB.add(rs.getString("GiaTien")+".000 đồng");
                        RB.add(rs.getString("SoLuong"));
                    }
                    os.write("ThongKe");os.newLine();os.flush();
                    os.write(RB.size());os.flush();
                    for(int i =0 ; i< RB.size();i++)
                    {
                        os.write(RB.get(i));os.newLine();os.flush();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "RB2":
            {
                RB.clear();
            try {
                pst = con.prepareStatement("select * from \"TheLoai\"");
                rs = pst.executeQuery();
                while(rs.next())
                {
                    RB.add(rs.getString("MaTheLoai"));
                    RB.add(rs.getString("TenTheLoai"));
                }
                os.write("ThongKe");os.newLine();os.flush();
                os.write(RB.size());os.flush();
                for(int i =0 ; i< RB.size();i++)
                    {
                        os.write(RB.get(i));os.newLine();os.flush();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case "RB3":
            {
                RB.clear();
            try {
                pst = con.prepareStatement("select * from \"DocGia\"");
                rs = pst.executeQuery();
                while(rs.next())
                {
                    RB.add(rs.getString("MaDocGia"));
                    RB.add(rs.getString("HoTen"));
                    RB.add(rs.getString("NgaySinh"));
                    RB.add(rs.getString("DiaChi"));
                    RB.add(rs.getString("DienThoai"));
                    RB.add(rs.getString("Email"));
                    RB.add(rs.getString("GioiTinh"));
                }
                os.write("ThongKe");os.newLine();os.flush();
                os.write(RB.size());os.flush();
                for(int i =0 ; i< RB.size();i++)
                    {
                        os.write(RB.get(i));os.newLine();os.flush();
                    }
            } catch (SQLException ex) {
                Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                break;
            }
            case "RB5":
            {
                RB.clear();
            try {
                pst = con.prepareStatement("select * from \"Sach\" natural join \"Sach_TheLoai\" natural join \"TheLoai\" where \"SoLuong\"<10");
                rs = pst.executeQuery();
                while(rs.next())
                {
                    RB.add(rs.getString("TenSach"));
                    RB.add(rs.getString("MaSach"));
                    RB.add(rs.getString("TenTacGia"));
                    RB.add(rs.getString("NXB"));
                    RB.add(rs.getString("TenTheLoai"));
                    RB.add(rs.getString("GiaTien")+".000");
                    RB.add(rs.getString("SoLuong"));
                }    os.write("ThongKe");os.newLine();os.flush();
                os.write(RB.size());os.flush();
                for(int i =0 ; i< RB.size();i++)
                    {
                        os.write(RB.get(i));os.newLine();os.flush();
                    }
                
            } catch (SQLException ex) {
                Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case "RB9":
            {
                RB.clear();
                try {
                pst = con.prepareStatement("select * from \"Sach\" natural join \"Sach_TheLoai\" natural join \"TheLoai\" order by \"LuotXem\" DESC");
                rs = pst.executeQuery();
                while(rs.next())
                {
                    RB.add(rs.getString("TenSach"));
                    RB.add(rs.getString("MaSach"));
                    RB.add(rs.getString("TenTacGia"));
                    RB.add(rs.getString("NXB"));
                    RB.add(rs.getString("TenTheLoai"));
                    RB.add(rs.getString("GiaTien")+".000");
                    RB.add(rs.getString("LuotXem"));
                }   os.write("ThongKe");os.newLine();os.flush();
                    os.write(RB.size());os.flush();
                    for(int i =0 ; i< RB.size();i++)
                    {
                        os.write(RB.get(i));os.newLine();os.flush();
                    }
            } catch (SQLException ex) {
                Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case "RB4":
                {
                RB.clear();
                try {
                pst = con.prepareStatement("select \"MaSach\",count(\"MaSach\") from \"PhieuThue\" group by \"MaSach\"");
                rs = pst.executeQuery();
                while(rs.next())
                {
                    PreparedStatement pst1 = con.prepareStatement("select * from \"Sach\" natural join \"Sach_TheLoai\" natural join \"TheLoai\" where \"MaSach\" = '"+rs.getString("MaSach")+"'");
                    ResultSet rs = pst1.executeQuery();
                    if(rs.next()){
                    RB.add(rs.getString("TenSach"));
                    RB.add(rs.getString("MaSach"));
                    RB.add(rs.getString("TenTacGia"));
                    RB.add(rs.getString("NXB"));
                    RB.add(rs.getString("TenTheLoai"));
                    RB.add(rs.getString("GiaTien")+".000");
                        RB.add(rs.getString("SoLuong"));}
                }os.write("ThongKe");os.newLine();os.flush();
                    os.write(RB.size());os.flush();
                
                    for(int i =0 ; i< RB.size();i++)
                    {
                        os.write(RB.get(i));os.newLine();os.flush();
                    }
                
            } catch (SQLException ex) {
                Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case "RB6":
                {
                RB.clear();
                try {
                pst = con.prepareStatement("select \"TheDocGia\" , count(\"MaSach\") from \"PhieuThue\"group by \"TheDocGia\" order by count(\"MaSach\") DESC");
                rs = pst.executeQuery();
                while(rs.next())
                {
                    RB.add(rs.getString("TheDocGia"));
                    RB.add(rs.getString(2));
                }
                    os.write("ThongKe");os.newLine();os.flush();
                os.write(RB.size());os.flush();
                for(int i =0 ; i< RB.size();i++)
                    {
                        os.write(RB.get(i));os.newLine();os.flush();
                    }
            } catch (SQLException ex) {
                Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case "RB7":
                {
                RB.clear();
                try {
                pst = con.prepareStatement("select \"MaDocGia\", \"HoTen\" , SUM(\"SoTien\") from \"HoaDon\" natural join \"DocGia\" group by \"MaDocGia\",\"HoTen\" order by SUM(\"SoTien\") DESC");
                rs = pst.executeQuery();
                while(rs.next())
                {
                    RB.add(rs.getString("MaDocGia"));
                    RB.add(rs.getString("HoTen"));
                    RB.add(rs.getString(3)+".000 đồng");
                }   os.write("ThongKe");os.newLine();os.flush();
                os.write(RB.size());os.flush();
                for(int i =0 ; i< RB.size();i++)
                    {
                        os.write(RB.get(i));os.newLine();os.flush();
                    }
            } catch (SQLException ex) {
                Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case "RB8":
            {
                RB.clear();
                try {
                pst = con.prepareStatement("select distinct(\"NXB\") from \"Sach\"");
                rs = pst.executeQuery();
                while(rs.next())
                {
                    RB.add(rs.getString(1));
                }    os.write("ThongKe");os.newLine();os.flush();
                os.write(RB.size());os.flush();
                for(int i =0 ; i< RB.size();i++)
                    {
                        os.write(RB.get(i));os.newLine();os.flush();
                    }
                
            } catch (SQLException ex) {
                Logger.getLogger(Server_return.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            default: break;
        }
    }
    public static boolean KiemTra_ID(String s)
    {
        try {
            pst = con.prepareStatement("select \"UserName\" from \"Account\"");
            rs = pst.executeQuery();
            while(rs.next())
            {
                if(rs.getString("UserName").compareTo(s)==0)
                    return false;
            }
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public static void SignUp(String name,String sex,String id,String pass,String Email,String bd,String phone,String Add,BufferedWriter os) throws IOException
    {
        SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
        Statement st1 = null;
        Statement st2 = null;
        String mdg = KiemTra("DocGia");
        String insert = "insert into \"Account\" values ('"+id+"','"+pass+"','"+mdg+"')";
        String ins = "insert into \"DocGia\" values('"+mdg+"','"+name+"','"+bd+"','"+Add+"','"+phone+
                "','"+Email+"','"+sex+"')";
        String ins2 = "insert into \"TheDocGia\" values('"+mdg+"','T"+mdg+"','"+today.format(new Date())+"')";
        System.out.println(insert);
        System.out.println(ins);
        System.out.println(ins2);
        if(KiemTra_ID(id)==true)
        {
            try {
                st = con.createStatement();
                st.execute(ins);
                st1= con.createStatement();
                st1.execute(insert);
                st2 = con.createStatement();
                st2.execute(ins2);
                os.write("Signup");os.newLine();os.flush();
                os.write("OK");os.newLine();os.flush();
            } catch (SQLException ex) {
                os.write("Signup");os.newLine();os.flush();
                os.write("Tạo tài khoản lỗi, bạn hãy sửa lại tên đăng nhập !!");os.newLine();os.flush();
            }
        }
        else
        {
            os.write("Signup");os.newLine();os.flush();
            os.write("Tạo tài khoản lỗi, bạn hãy sửa lại tên đăng nhập !!");os.newLine();os.flush();
        }
        
    }
    public static int loadTacGia()
    {
        TacGia.clear();
        try {
            pst = con.prepareStatement("select distinct \"TenTacGia\" from \"Sach\" order by \"TenTacGia\" ASC");
            rs = pst.executeQuery();
            while(rs.next())
            {
                TacGia.add(rs.getString("TenTacGia"));
            }
            return TacGia.size();
        } catch (SQLException ex) {
            return 0;
        }
    }
    public static int loadNXB()
    {
        TacGia.clear();
        try {
            pst = con.prepareStatement("select distinct \"NXB\" from \"Sach\" order by \"NXB\" ASC");
            rs = pst.executeQuery();
            while(rs.next())
            {
                TacGia.add(rs.getString("NXB"));
            }
            return TacGia.size();
        } catch (SQLException ex) {
            return 0;
        }
    }
    public static int loadTLS()
    {
        TacGia.clear();
        try {
            pst = con.prepareStatement("select * from \"TheLoai\" order by \"TenTheLoai\" ASC");
            rs = pst.executeQuery();
            while(rs.next())
            {
                TacGia.add(rs.getString("TenTheLoai"));
            }
            return TacGia.size();
        } catch (SQLException ex) {
            return 0;
        }
    }
}
