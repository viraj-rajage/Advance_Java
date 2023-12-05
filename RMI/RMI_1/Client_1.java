package Advance_Java.RMI.RMI_1;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Client_1 extends Remote {
    void hello() throws RemoteException;
}
