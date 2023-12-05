import java.io.DataOutputStream;
import java.net.Socket;

public class Client_2 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",1000);
            DataOutputStream dout= new DataOutputStream(s.getOutputStream()); 
            dout.writeUTF("This Is Client"); 
            dout.flush(); 
            dout.close(); 
            s.close(); 
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
