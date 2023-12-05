import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client_1 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1111); 
            Socket  s = ss.accept(); 
            DataInputStream din  = new DataInputStream(s.getInputStream()); 
            String str1= (String)din.readUTF(); 
            System.out.println("Message:"+str1);
            din.close(); 
            ss.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}