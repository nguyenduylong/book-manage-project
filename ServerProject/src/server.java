

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server {
    public static ArrayList<Socket> ConnectionArray = new ArrayList<Socket>();
    public static void main(String[] args) {
        final int PORT = 7777;
        try {
            ServerSocket SERVER = new ServerSocket(PORT);
            System.out.println("waiting for client connect!!");
            
            while(true)
            {
                Socket SOCK = SERVER.accept();
                ConnectionArray.add(SOCK);
                System.out.println("Client connected from "+SOCK.getLocalAddress().getHostAddress());
                Server_return SReturn = new Server_return(SOCK);
                Thread x = new Thread(SReturn);
                x.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
