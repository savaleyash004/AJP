package assignmentRMI1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
public class PrintC extends UnicastRemoteObject implements PrintI {
    public PrintC() throws RemoteException {
        super();
    }
    public void palindromeCheck() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("Choose input type :  1.String  2.Number");
        System.out.print("Enter choice : ");
        int choice = sc.nextInt();
        sc.nextLine(); 
        String input;
        if (choice == 1) {
            System.out.print("Enter a string : ");
            input = sc.nextLine();
        } else if (choice == 2) {
            System.out.print("Enter a number : ");
            input = sc.next();
        } else {
            System.out.println("Invalid choice!");
            return;
        }
        String revStr = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            revStr += input.charAt(i);
        }
        if (input.equals(revStr)) {
            System.out.println("It is a Palindrome");
        } else {
            System.out.println("It is not a Palindrome");
        }
    }
}

