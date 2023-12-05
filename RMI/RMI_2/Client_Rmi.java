import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client_Rmi {
    public static void main(String[] args) throws NotBoundException,IOException{
        System.out.println("This Is Rmi Application");
        Registry registry = LocateRegistry.getRegistry("localhost",1500);
        RMI_INTERFACE i =(RMI_INTERFACE)registry.lookup("rmi://localhost/fileService"); 
        System.out.println("BoundTo"+i);
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter The File Path To Downlod:-");
        String Server_File_Path = sc.nextLine(); 
        byte[] data = i.downlodFile(Server_File_Path); 
        System.out.println("Enter The File Path To Save:-");
        String Client_File_Path = sc.nextLine(); 
        FileOutputStream sos = new FileOutputStream(Client_File_Path); 
        sos.write(data,0,data.length);
        sos.flush();
        sos.close();
        System.out.println("File Downlod Sucessfully"); 
        sc.close();
    } 
    
}
