package assignmentRMI2;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
public class PrintC extends UnicastRemoteObject implements PrintI {
    public PrintC() throws RemoteException {
        super();
    }
    public void generateFibonacci() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms for Fibonacci series : ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Invalid input! Please enter a positive number.");
            return;
        }
        System.out.println("Fibonacci Series :");
        long a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }
}
