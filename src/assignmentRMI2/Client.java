package assignmentRMI2;

import java.rmi.Naming;
import java.rmi.RemoteException;   
import java.net.MalformedURLException; 
import java.rmi.NotBoundException;
public class Client {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
            PrintI iobj = (PrintI)Naming.lookup("rmi://localhost:4000/FIBONACCI");
            iobj.generateFibonacci();
    }
}

