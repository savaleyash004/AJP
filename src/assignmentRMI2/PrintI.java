package assignmentRMI2;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface PrintI extends Remote {
    void generateFibonacci() throws RemoteException;
}

