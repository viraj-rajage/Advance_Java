import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server_Rmi {
    public static void main(String[] args) throws RemoteException{
        Registry registry = LocateRegistry.createRegistry(1500); 
        RMI_IMPLEMENT im = new RMI_IMPLEMENT(); 
        registry.rebind("rmi://localhost/fileService", im); 
        System.out.println("Hello RMI Application User");
    }
}
