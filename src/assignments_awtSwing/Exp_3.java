package assignments_awtSwing;

import javax.swing.*;
import java.awt.event.*;

public class Exp_3 implements ActionListener {

    JFrame frame;
    JLabel nameLabel, rollNoLabel, studentIdLabel, emailLabel, batchLabel, branchLabel, subjectLabel;
    JTextField nameField, rollNoField, studentIdField, emailField, batchField, branchField;
    JTextField[] subjectFields;
    JLabel[] subjectNameLabels;
    JButton submitButton, resetButton;

    int subjectCount = 5; // Number of subjects
    String[] subjectNames = {"Math", "Science", "English", "History", "Geography"};

    Exp_3() {
        frame = new JFrame("Student Info GUI");
        frame.setSize(600, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        addComponents();
        registerListeners();

        frame.setVisible(true);
    }

    public void initComponents() {
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 100, 30);
        nameField = new JTextField();
        nameField.setBounds(120, 20, 200, 30);

        rollNoLabel = new JLabel("Roll No:");
        rollNoLabel.setBounds(20, 60, 100, 30);
        rollNoField = new JTextField();
        rollNoField.setBounds(120, 60, 200, 30);

        studentIdLabel = new JLabel("Student ID:");
        studentIdLabel.setBounds(20, 100, 100, 30);
        studentIdField = new JTextField();
        studentIdField.setBounds(120, 100, 200, 30);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 140, 100, 30);
        emailField = new JTextField();
        emailField.setBounds(120, 140, 200, 30);

        batchLabel = new JLabel("Batch:");
        batchLabel.setBounds(20, 180, 100, 30);
        batchField = new JTextField();
        batchField.setBounds(120, 180, 200, 30);

        branchLabel = new JLabel("Branch:");
        branchLabel.setBounds(20, 220, 100, 30);
        branchField = new JTextField();
        branchField.setBounds(120, 220, 200, 30);

        subjectLabel = new JLabel("Enter Marks for Subjects:");
        subjectLabel.setBounds(20, 260, 200, 30);

        subjectFields = new JTextField[subjectCount];
        subjectNameLabels = new JLabel[subjectCount];
        for (int i = 0; i < subjectCount; i++) {
            subjectNameLabels[i] = new JLabel(subjectNames[i] + ":");
            subjectNameLabels[i].setBounds(20, 300 + (i * 40), 100, 30);
            subjectFields[i] = new JTextField();
            subjectFields[i].setBounds(120, 300 + (i * 40), 200, 30);
        }

        submitButton = new JButton("Submit");
        submitButton.setBounds(120, 540, 100, 30);

        resetButton = new JButton("Reset");
        resetButton.setBounds(230, 540, 100, 30);
    }

    public void addComponents() {
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(rollNoLabel);
        frame.add(rollNoField);
        frame.add(studentIdLabel);
        frame.add(studentIdField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(batchLabel);
        frame.add(batchField);
        frame.add(branchLabel);
        frame.add(branchField);
        frame.add(subjectLabel);

        for (int i = 0; i < subjectCount; i++) {
            frame.add(subjectNameLabels[i]);
            frame.add(subjectFields[i]);
        }

        frame.add(submitButton);
        frame.add(resetButton);
    }

    public void registerListeners() {
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                String name = nameField.getText().trim();
                String rollNo = rollNoField.getText().trim();
                String studentId = studentIdField.getText().trim();
                String email = emailField.getText().trim();
                String batch = batchField.getText().trim();
                String branch = branchField.getText().trim();

                if (name.isEmpty() || rollNo.isEmpty() || studentId.isEmpty() || email.isEmpty() || batch.isEmpty() || branch.isEmpty()) {
                    throw new IllegalArgumentException("All fields must be filled.");
                }

                StringBuilder marksDetails = new StringBuilder();
                int totalMarks = 0;
                for (int i = 0; i < subjectCount; i++) {
                    int marks = Integer.parseInt(subjectFields[i].getText().trim());
                    totalMarks += marks;
                    marksDetails.append(subjectNames[i]).append(": ").append(marks).append("\n");
                }

                int averageMarks = totalMarks / subjectCount;
                String result = averageMarks >= 40 ? "Pass" : "Fail";

                JOptionPane.showMessageDialog(frame,
                        "Name: " + name + "\n" +
                        "Roll No: " + rollNo + "\n" +
                        "Student ID: " + studentId + "\n" +
                        "Email: " + email + "\n" +
                        "Batch: " + batch + "\n" +
                        "Branch: " + branch + "\n" +
                        "Marks:\n" + marksDetails.toString() +
                        "Total Marks: " + totalMarks + "\n" +
                        "Average Marks: " + averageMarks + "\n" +
                        "Result: " + result,
                        "Student Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers for all subjects.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == resetButton) {
            nameField.setText("");
            rollNoField.setText("");
            studentIdField.setText("");
            emailField.setText("");
            batchField.setText("");
            branchField.setText("");

            for (JTextField field : subjectFields) {
                field.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new Exp_3();
    }
}