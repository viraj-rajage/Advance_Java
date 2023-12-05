import java.io.*;
import java.net.*;
import java.net.ServerSocket;
public class Server_3 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1500); 
        Socket s = ss.accept();  
        DataInputStream din = new DataInputStream(s.getInputStream()); 
        DataOutputStream dout = new DataOutputStream(s.getOutputStream()); 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String msg="",masg1=""; 
        while(!msg.equals("Exit")){
            msg=din.readUTF(); 
            System.out.println("Client-->"+msg);
            masg1 = br.readLine();
            dout.writeUTF(masg1);
        }
        dout.flush(); 
        din.close(); 
        ss.close();
    }
}