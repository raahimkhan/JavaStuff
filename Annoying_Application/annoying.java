import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
 
public class annoying {
 
    public static void main(String args[]) {
        
        // Create frame for the GUI
        JFrame f = new JFrame("An Annoying Application");
        
        // Creating the PRESS ME! button
        JButton b = new JButton("PRESS ME!");
        
        // Setting x-y coordinates and width-height of the button
        b.setBounds(5,40,80,20);
        
        // Creating a key-listener that will listen for keyboard key presses
        KeyListener listener = new KeyListener() {
            // over-riding the functions or providing a specific implementation of the built-in functions
            @Override
            public void keyPressed(KeyEvent event) {
                int code = event.getKeyCode();
            }
            @Override
            public void keyReleased(KeyEvent event) {
                // this is our main function
                // if the secret key pressed is "f" or "F" on the keyboard, the GUI should close and program should exit
                int code = event.getKeyCode();
                if (code == 70)
                {
                    System.exit(0);
                }
            }
            @Override
            public void keyTyped(KeyEvent event) {
                int code = event.getKeyCode();
            }
        };
        
        // adding a mouse event listener to the frame
        // GUI will appear else where on the screen randomly if mouse moves inside the GUI
        f.addMouseListener( new MouseAdapter() {
            public void mouseEntered( MouseEvent e ) {
                Random rand = new Random();
                // changing location of the JFrame randomly on screen
                f.setLocation(rand.nextInt(500), rand.nextInt(500));
             }
        });
        
        // creating an invisible text field that will listen for keyboard presses
        // this is basically my solution that listens for keyboard input
        JTextField textField = new JTextField();
        textField.addKeyListener(listener);
        
        // adding button and text field to the frame
        f.add(textField);
        f.add(b);
        
        // setting the frame size
        f.setSize(95,85);
        f.setLayout(null);
        
        // hiding the title bar
        f.setUndecorated(true);
        
        f.setVisible(true);
    }
}