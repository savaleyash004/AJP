package assignmentRMI1;

import java.rmi.Naming;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int ch = 1;
            PrintI iobj = (PrintI)Naming.lookup("rmi://localhost:5000/PALINDROME");
            do {
                iobj.palindromeCheck();
                System.out.println("Press:  0.To EXIT   1.To Continue");
                ch = sc.nextInt();
                sc.nextLine(); 
            } while (ch != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

