import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
public class Client_3 {
    public static void main(String[] args)  throws UnknownHostException,IOException{
        Socket s = new Socket("localhost",1500);
        DataInputStream din = new DataInputStream(s.getInputStream()); 
        DataOutputStream dout = new DataOutputStream(s.getOutputStream()); 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String msg="",msg1=""; 
        while(!msg.equals("Exit")){
            msg = br.readLine();
            dout.writeUTF(msg); 
            dout.flush(); 
            msg1=din.readUTF(); 
            System.out.println("Server-->"+msg1);
        } 
        dout.close();
        s.close();
    }
} 
