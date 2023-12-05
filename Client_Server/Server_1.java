import java.io.DataOutputStream;
import java.net.Socket;
public class Server_1 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",1111);
            DataOutputStream dout= new DataOutputStream(s.getOutputStream()); 
            dout.writeUTF("This Is Server"); 
            dout.flush(); 
            dout.close(); 
            s.close(); 
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
