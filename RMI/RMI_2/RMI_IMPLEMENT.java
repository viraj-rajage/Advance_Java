import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMI_IMPLEMENT extends UnicastRemoteObject implements RMI_INTERFACE{
   public RMI_IMPLEMENT() throws RemoteException{
    super();
   } 
   public byte[] downlodFile (String Server_File_Path) throws RemoteException{
    byte [] data = new byte[1500]; 
    try {
        FileInputStream fis = new FileInputStream(Server_File_Path); 
        fis.read(data,0,data.length);
        fis.close();
    } catch (FileNotFoundException e) {
        System.out.println(e);
    }
    catch(IOException e){

    } 
    return data;
   }
}
