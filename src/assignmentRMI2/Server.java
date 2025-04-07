package assignmentRMI2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Server {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(4000);
            PrintC obj = new PrintC();
            registry.bind("FIBONACCI", obj);
            System.out.println("Server started successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

