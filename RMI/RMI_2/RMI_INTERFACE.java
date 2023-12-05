import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI_INTERFACE extends Remote{
    public byte[] downlodFile (String Server_File_Path) throws RemoteException;
}
