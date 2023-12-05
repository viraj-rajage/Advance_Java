package Advance_Java.RMI.RMI_1;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Rmi_Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",1500);
            Client_1 stub =(Client_1)registry.lookup("Client_1"); 
            stub.hello(); 
        } catch (Exception e) {
            System.err.println("Client_Side-->"+e.toString());
        }
    }
}
