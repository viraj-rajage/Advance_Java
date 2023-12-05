package Advance_Java.RMI.RMI_1;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class Rmi_Server extends Rmi_Imp {
    public static void main(String[] args) {
        try {
            Rmi_Imp imp = new Rmi_Imp(){};
            Client_1 stub =(Client_1)UnicastRemoteObject.exportObject(imp, 0);
            Registry registry = LocateRegistry.createRegistry(1500); 
            Naming.rebind("rmi://localhost:1500"+"/hello", imp);
            registry.bind("Client_1", stub); 
            System.err.println("Server Side...");
             
        } catch (MalformedURLException |AlreadyBoundException |RemoteException e) {
            System.err.println("Client_Side..."+e.toString());
        }
    }
}
