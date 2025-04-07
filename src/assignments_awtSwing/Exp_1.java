package assignments_awtSwing;

import java.awt.*;
import java.awt.event.*;

public class Exp_1 extends WindowAdapter implements KeyListener {
    Frame mainFrame;
    TextArea textArea;
    Label labelHeader;
    Label labelStatus;

    // Constructor
    Exp_1() {
        mainFrame = new Frame();
        mainFrame.setVisible(true);
        mainFrame.setSize(600, 400); // Increased size for better layout
        mainFrame.setTitle("First Java Application");
        mainFrame.setLayout(null);

        // Add window listener
        mainFrame.addWindowListener(this);

        // Initialize and add components
        initializeComponents();
        addComponents();
    }

    // Initialize components
    public void initializeComponents() {
        textArea = new TextArea();
        labelHeader = new Label("AWT Window");
        labelStatus = new Label("");
    }

    // Add components to the frame
    public void addComponents() {
        mainFrame.add(textArea);
        mainFrame.add(labelHeader);
        mainFrame.add(labelStatus);

        textArea.setBounds(50, 80, 400, 200); // Larger TextArea
        labelHeader.setBounds(50, 30, 200, 30); // Header Label repositioned
        labelStatus.setBounds(50, 300, 400, 30); // Status Label repositioned

        textArea.addKeyListener(this); // Add KeyListener to TextArea
    }

    // Handle window closing
    @Override
    public void windowClosing(WindowEvent e) {
        mainFrame.dispose();
    }

    // Handle key typed event
    @Override
    public void keyTyped(KeyEvent e) {
        labelStatus.setText("Key Typed: " + e.getKeyChar());
    }

    // Handle key pressed event
    @Override
    public void keyPressed(KeyEvent e) {
        labelStatus.setText("Key Pressed: " + e.getKeyChar());
    }

//     Handle key released event
    @Override
    public void keyReleased(KeyEvent e) {
        labelStatus.setText("Key Released: " + e.getKeyChar());
    }

    // Main method
    public static void main(String[] args) {
        new Exp_1();
    }
}
