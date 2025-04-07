package assignmentsJDBC;

import java.sql.*;
import java.util.Scanner;

public class Exp_4 {
    private Connection con;
    private Scanner scanner;

    public Exp_4() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Exp_4 obj = new Exp_4();
        try {
            obj.getConnection();
            obj.createTable();  
            obj.menu();         
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            obj.closeConnection();
        }
    }

    public void getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/college";
            String username = "root";
            String password = "Savale@004";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS students ("
                     + "rollNo VARCHAR(10) PRIMARY KEY, "
                     + "name VARCHAR(50), "
                     + "subject VARCHAR(50), "
                     + "marks INT)";
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println("Table 'students' is ready.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n Select an operation:");
            System.out.println("1. Insert Student");
            System.out.println("2. Read Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    insertStudent();
                    break;
                case 2:
                    readStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public void insertStudent() {
        Derived student = new Derived();
        student.getData(scanner);

        String query = "INSERT INTO students (rollNo, name, subject, marks) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, student.getRollNo());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getSubject());
            pstmt.setInt(4, student.getMarks());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student added successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readStudents() {
        String query = "SELECT * FROM students";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n2.Student Records:");
            while (rs.next()) {
                System.out.println(
                        "Roll No: " + rs.getString("rollNo") +
                        ", Name: " + rs.getString("name") +
                        ", Subject: " + rs.getString("subject") +
                        ", Marks: " + rs.getInt("marks")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent() {
        System.out.print("Enter Roll No of student to update: ");
        String rollNo = scanner.nextLine();

        System.out.print("Enter new Marks: ");
        int newMarks = scanner.nextInt();
        scanner.nextLine();

        String query = "UPDATE students SET marks = ? WHERE rollNo = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, newMarks);
            pstmt.setString(2, rollNo);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student record updated.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent() {
        System.out.print("Enter Roll No of student to delete: ");
        String rollNo = scanner.nextLine();

        String query = "DELETE FROM students WHERE rollNo = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, rollNo);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student record deleted.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}

class Base {
    private String rollNo;
    private String name;

    public void getData(Scanner scanner) {
        System.out.print("Enter Roll No: ");
        this.rollNo = scanner.nextLine();
        System.out.print("Enter Name: ");
        this.name = scanner.nextLine();
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }
}

class Derived extends Base {
    private String subject;
    private int marks;

    public void getData(Scanner scanner) {
        super.getData(scanner);
        System.out.print("Enter Subject: ");
        this.subject = scanner.nextLine();
        System.out.print("Enter Marks: ");
        this.marks = scanner.nextInt();
        scanner.nextLine();
    }

    public String getSubject() {
        return subject;
    }

    public int getMarks() {
        return marks;
    }
}
