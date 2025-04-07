package assignmentRMI1;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface PrintI extends Remote {
    void palindromeCheck() throws RemoteException;
}

