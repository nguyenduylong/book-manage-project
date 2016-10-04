
package project_database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Client implements Runnable{
    public boolean  status = false;
    BufferedWriter os = null;
    Socket SOCK ;
    Scanner INPUT;
    PrintWriter OUT ;
    String hitDeTai[][] = new String[2][2];
    String s[][] = new String[10][32];
    int login;
    int timkiem;
    String thongbao;
    String PM;
    static public String DocGia[] = new String[7];
    static public ArrayList<String> TimSach = new ArrayList<String>();
    static public ArrayList<String> SachMuon = new ArrayList<String>();
    static public ArrayList<String> RB = new ArrayList<String>();
    static public ArrayList<String> TacGia = new ArrayList<String>();
    
    public Client(Socket Sock)
    {
        this.SOCK = Sock;
    }

    @Override
    public void run() {
        BufferedReader is = null;
        String MESSAGE;
        try {
            INPUT = new Scanner(SOCK.getInputStream());
            OUT = new PrintWriter(SOCK.getOutputStream());
            OUT.flush();
            is = new BufferedReader(new InputStreamReader(SOCK.getInputStream()));
            FileOutputStream fos = null;
            String REP_fromServer;
            while(true)
            {
                REP_fromServer = is.readLine();
                if(REP_fromServer==null) REP_fromServer = "1";
                switch(REP_fromServer)
                {
                    case "GioiThieu":
                    {
                        status = false;
                        
                        for(int i =0;i<2;i++)
                        {
                            for(int j=0;j<2;j++)
                                hitDeTai[i][j]=is.readLine();
                        }
                        for(int i=0;i<27;i++)
                        {
                            for(int j=0;j<10;j++)
                            {
                                s[j][i] = is.readLine();
                            }
                            if(s[0][i].compareTo("")!=0)
                            {
                                fos = new FileOutputStream(s[0][i]);
                                int c;
                                while((c=is.read())!=65535)
                                {
                                    fos.write(c);
                                }
                                fos.close();
                            }
                        }
                        for(int i =27;i<32;i++)
                        {
                            for(int j=0;j<10;j++)
                            {
                                s[j][i]= is.readLine();
                            }
                            if(s[0][i].compareTo("")!=0)
                            {
                                fos = new FileOutputStream(s[0][i]);
                                int c;
                                while((c=is.read())!=65535)
                                    fos.write(c);
                                fos.close();
                            }
                        }
                        status = true;
                        break;
                    }
                    case "Login":
                    {
                        login=0;
                        status = false;
                        login = is.read();
                        if(login==1)
                        {
                            for (int i = 0; i < 7; i++) {
                                DocGia[i] = is.readLine();
                            }
                            int count = is.read();
                            for (int i = 0; i < count; i++) {
                                SachMuon.add(is.readLine());
                            }
                        }
                        status = true;
                        break;
                    }
                    case "MuonSach_search":
                    {
                        TimSach.clear();
                        status =false;
                        timkiem = is.read();
                        if(timkiem!=0)
                        {
                            for (int i = 0; i < timkiem; i++) {
                                TimSach.add(is.readLine());
                            }
                        }
                        status = true;
                        break;
                    }
                    case "MuonSach_search2":
                    {
                        TimSach.clear();
                        status =false;
                        timkiem = is.read();
                        if(timkiem!=0)
                        {
                            for (int i = 0; i < timkiem; i++) {
                                TimSach.add(is.readLine());
                            }
                            for(int i = 0 ;i<timkiem/8;i++)
                            {
                                fos = new FileOutputStream(TimSach.get(i*8));
                                int c;
                                while((c=is.read())!=65535)
                                    fos.write(c);
                                fos.close();
                            }
                        }
                        status = true;
                        break;
                    }
                    case "loadImage":
                    {
                        status = false;
                        fos = new FileOutputStream(is.readLine());
                        int c;
                        while((c=is.read())!=65535)
                        fos.write(c);
                        fos.close();
                        status = true;
                        break;
                    }
                    case "ThueSach":
                    {
                        status = false;
                        thongbao = is.readLine();
                        if(thongbao.compareTo("Bạn đã gửi yêu cầu thành công !")==0)
                            PM = is.readLine();
                        status = true;
                        break;
                    }
                    case "ThongKe":
                    {
                        int size;
                        status = false;
                        RB.clear();
                        size = is.read();
                        for(int i =0; i<size;i++)
                            RB.add(is.readLine());
                        status = true;
                        break;
                    }
                    case "Signup":
                    {
                        status = false;
                        thongbao = is.readLine();
                        status =true;
                        break;
                    }
                    case "TacGia":
                    {
                        TacGia.clear();
                        status = false; 
                        int cou_tg = is.read();
                        for (int i = 0; i < cou_tg; i++) {
                            TacGia.add(is.readLine());
                        }
                        status = true;
                        break;
                    }
                    case "NXB":
                    {
                        TacGia.clear();
                        status = false;
                        int cou_NXB = is.read();
                        for(int i = 0;i<cou_NXB;i++)
                            TacGia.add(is.readLine());
                        status = true;
                        break;
                    }
                    case "TheLoaiSach":
                    {
                        TacGia.clear();
                        status = false;
                        int cou_TLS = is.read();
                        for(int i=0;i<cou_TLS;i++)
                            TacGia.add(is.readLine());
                        status = true;
                        break;
                    }
                    default: break;
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối với server!!");
        }
    }
    public void SEND(String s)
    {
        try {
            os = new BufferedWriter(new OutputStreamWriter(SOCK.getOutputStream()));
            os.write(s);
            os.newLine();
            os.flush();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối với server!!");
        }
    }
}
