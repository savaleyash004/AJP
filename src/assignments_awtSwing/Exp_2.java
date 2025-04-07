package assignments_awtSwing;

import java.awt.*;
import java.awt.event.*;

public class Exp_2 extends WindowAdapter implements MouseListener {
    Frame mainFrame;
    TextArea textArea;
    Label labelMessage;
    Label labelStatus;

    Exp_2() {
        mainFrame = new Frame();
        mainFrame.setVisible(true);
        mainFrame.setLayout(null);
        mainFrame.setSize(500, 500);
        mainFrame.setTitle("Experiment 2");
        mainFrame.addWindowListener(this);

        initializeComponents();
        addComponents();
    }

    public void initializeComponents() {
        textArea = new TextArea();
        labelMessage = new Label("");
        labelStatus = new Label("");

        textArea.setBounds(50, 100, 200, 200);
        labelMessage.setBounds(25, 25, 100, 50);
        labelStatus.setBounds(50, 50, 250, 80);

        textArea.addMouseListener(this);
    }

    public void addComponents() {
        mainFrame.add(textArea);
        mainFrame.add(labelMessage);
        mainFrame.add(labelStatus);
    }

    // Handle window closing
    @Override
    public void windowClosing(WindowEvent e) {
        mainFrame.dispose();
    }

    public void mouseClicked(MouseEvent e) {
        labelStatus.setText("Mouse Clicked, color --> gray");
        textArea.setBackground(Color.gray);
        labelStatus.setForeground(Color.gray);
    }

    public void mouseEntered(MouseEvent e) {
        labelStatus.setText("Mouse Entered, Color --> green");
        textArea.setBackground(Color.green);
        labelStatus.setForeground(Color.green);
    }

    public void mouseExited(MouseEvent e) {
        labelStatus.setText("Mouse Exited, Color --> cyan");
        textArea.setBackground(Color.cyan);
        labelStatus.setForeground(Color.cyan);
    }

    public void mouseReleased(MouseEvent e) {
        labelStatus.setText("Mouse Released, Color --> red");
        textArea.setBackground(Color.red);
        labelStatus.setForeground(Color.red);
    }

    public void mousePressed(MouseEvent e) {
        labelStatus.setText("Mouse Pressed, Color --> orange");
        textArea.setBackground(Color.orange);
        labelStatus.setForeground(Color.orange);
    }

    public static void main(String[] args) {
        new Exp_2();
    }
}
