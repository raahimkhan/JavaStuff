// imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator
{
    // class variables
    
    JFrame f; // frame for the GUI
    JLabel l; // label for user display
    JTextField tf; // this will just be an uneditable field where I will position the JLabel. Basically a rectangular block to display JLabel
    
    // buttons for the GUI (10 buttons 0-9, + - * and / button, clear, and equals button)
    JButton btn0;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    JButton btn6;
    JButton btn7;
    JButton btn8;
    JButton btn9;
    JButton btnplus;
    JButton btnminus;
    JButton btnmultiply;
    JButton btndivide;
    JButton btnclear;
    JButton btnequals;
    
    // string to store the numbers and the operator the user pressed which will eventually be passed to the JLabel for display inside the box
    public String userInputText;
    
    // variable to track whether equals button pressed or not
    boolean isAns;
    
    // constructor
    public calculator()
    {
        // initializing the frame of the GUI
        f = new JFrame();
        f.setTitle("Calculator App"); // title that will appear in the top bar of the GUI
        f.setSize(300, 490); /// width and height of the GUI
        f.getContentPane().setLayout(null); // this means we can use absolute positioning to place buttons and JLabel
        f.getContentPane().setBackground(Color.white); // GUI background color will be black
        f.setResizable(false); // user won't be able to increase or decrease the size of the GUI
        f.setLocationRelativeTo(null); // GUI will appear in center of screen
        f.setVisible(true); // frame will be visible on program launch
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // GUI should close / program should end if cross button (X) is pressed
        
        // JLabel text will initially be empty
        userInputText = "";
        
        // initially false
        isAns = false;
    }
    
    // function to validate and then repaint the frame after adding a new component
    public void updateFrame()
    {
        f.validate();
        f.repaint();
    }
    
    // function to initialize the JLabel of the GUI
    public void initializeJLabel()
    {
        // initalizing the JLabel of the GUI
        l = new JLabel();
        l.setText(userInputText);
        l.setBounds(20, -290, 400, 700); // positioning the label inside the JTextField
        l.setForeground(Color.black); // text will be of white color
        l.setFont(new Font("Serif", Font.BOLD, 15)); // format is Serif, text will be bold, and of size 20
        f.add(l); // adding label to frame
        this.updateFrame();
    }
    
    // function to initialize the JTextField of the GUI
    public void initializeJTextField()
    {
        tf = new JTextField();
        tf.setBounds(10, 40, 270, 40);
        tf.setEditable(false); // user won't be able to edit/write inside the TextField. They will just press buttons which will be updated inside JLabel and JLabel will be displayed inside this block
        tf.setBackground(Color.white); // black colored field
        f.add(tf); // adding text field to frame
        this.updateFrame();
    }
    
    // function to position and put JButton on the GUI frame
    // takes in the type of button to place (0, 1 ,2, =, +, etc)
    // takes in x and y coordinates for positioning on to the GUI and the width and height to assign to the JButton
    public void placeJButton(String btnType, int x, int y, int w, int h)
    {
        // switch will determine the button type
        // and then will set bounds, font, size of button and add it to frame of the GUI
        // finally the frame will be validated and repainted to display the newly added component
        // in default case, this will throw an error that illegal button type has been passed
        switch (btnType)
        {
            case "0":
                btn0.setBounds(x, y, w, h);
                btn0.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btn0);
                this.updateFrame();
                break;
            case "1":
                btn1.setBounds(x, y, w, h);
                btn1.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btn1);
                this.updateFrame();
                break;
            case "2":
                btn2.setBounds(x, y, w, h);
                btn2.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btn2);
                this.updateFrame();
                break;
            case "3":
                btn3.setBounds(x, y, w, h);
                btn3.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btn3);
                this.updateFrame();
                break;
            case "4":
                btn4.setBounds(x, y, w, h);
                btn4.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btn4);
                this.updateFrame();
                break;
            case "5":
                btn5.setBounds(x, y, w, h);
                btn5.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btn5);
                this.updateFrame();
                break;
            case "6":
                btn6.setBounds(x, y, w, h);
                btn6.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btn6);
                this.updateFrame();
                break;
            case "7":
                btn7.setBounds(x, y, w, h);
                btn7.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btn7);
                this.updateFrame();
                break;
            case "8":
                btn8.setBounds(x, y, w, h);
                btn8.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btn8);
                this.updateFrame();
                break;
            case "9":
                btn9.setBounds(x, y, w, h);
                btn9.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btn9);
                this.updateFrame();
                break;
            case "+":
                btnplus.setBounds(x, y, w, h);
                btnplus.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btnplus);
                this.updateFrame();
                break;
            case "-":
                btnminus.setBounds(x, y, w, h);
                btnminus.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btnminus);
                this.updateFrame();
                break;
            case "x":
                btnmultiply.setBounds(x, y, w, h);
                btnmultiply.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btnmultiply);
                this.updateFrame();
                break;
            case "/":
                btndivide.setBounds(x, y, w, h);
                btndivide.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btndivide);
                this.updateFrame();
                break;
            case "clear":
                btnclear.setBounds(x, y, w, h);
                btnclear.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btnclear);
                this.updateFrame();
                break;
            case "equals":
                btnequals.setBounds(x, y, w, h);
                btnequals.setFont(new Font("Serif", Font.BOLD, 20));
                f.add(btnequals);
                this.updateFrame();
                break;
            default:
                throw new IllegalArgumentException("Invalid button type passed");
        }
    }
    
    public void add()
    {
        // splitting the user input by space
        // first number will be at index 0
        // second number will be at index 2
        // then add the two numbers and update the JLabel
        String[] inputs = userInputText.split(" ");
        String firstNumber = inputs[0];
        String secondNumber = inputs[2];
        int ans = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
        userInputText = "";
        userInputText = userInputText + Integer.toString(ans);
        l.setText(userInputText);
        isAns = true; // set ans to true so that if user presses something else the display resets
    }
    
    public void subtract()
    {
        // splitting the user input by space
        // first number will be at index 0
        // second number will be at index 2
        // then subtract the two numbers and update the JLabel
        String[] inputs = userInputText.split(" ");
        String firstNumber = inputs[0];
        String secondNumber = inputs[2];
        int ans = Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
        userInputText = "";
        userInputText = userInputText + Integer.toString(ans);
        l.setText(userInputText);
        isAns = true; // set ans to true so that if user presses something else the display resets
    }
    
    public void multiply()
    {
        // splitting the user input by space
        // first number will be at index 0
        // second number will be at index 2
        // then multiply the two numbers and update the JLabel
        String[] inputs = userInputText.split(" ");
        String firstNumber = inputs[0];
        String secondNumber = inputs[2];
        int ans = Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
        userInputText = "";
        userInputText = userInputText + Integer.toString(ans);
        l.setText(userInputText);
        isAns = true; // set ans to true so that if user presses something else the display resets
    }
    
    public void divide()
    {
        // splitting the user input by space
        // first number will be at index 0
        // second number will be at index 2
        // then divide the two numbers and update the JLabel
        String[] inputs = userInputText.split(" ");
        String firstNumber = inputs[0];
        String secondNumber = inputs[2];
        // case for divide by 0
        if (secondNumber == "0")
        {
            userInputText = "";
            userInputText = "Infinity";
            l.setText(userInputText);
            isAns = true; // set ans to true so that if user presses something else the display resets
        }
        else
        {
            double ans = (double) Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
            // if ans is a whole number e.g. 2.0 or 14.0 then convert it to integer i.g. 2 or 14
            if (ans - Math.floor(ans) == 0)
            {
                userInputText = "";
                userInputText = userInputText + Double.toString(ans);
                userInputText = Integer.toString(Float.valueOf(userInputText).intValue());
                l.setText(userInputText);
                isAns = true; // set ans to true so that if user presses something else the display resets
            }
            // if it is not a whole number e.g. 1.5 then display it as it is on the JLabel
            else
            {
                userInputText = "";
                userInputText = userInputText + Double.toString(ans);
                l.setText(userInputText);
                isAns = true; // set ans to true so that if user presses something else the display resets
            }
        }
    }
    
    // function to add action listener to JButtons (0, 1 ,2, =, +, etc)
    // on pressing the certain button, the JLabel will be updated and displayed inside the box accordingly
    // takes in the type of button just as we did in "placeJButton" function above
    public void addActionListenerToJButton(String btnType)
    {
        // switch will determine the button type
        // and then will add action listeners and steps to be performed accordingly for that action listener
        // default case this will throw an error that illegal button type has been passed
        switch (btnType)
        {
            case "0":
                btn0.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + "0";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + "0";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "1":
                btn1.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + "1";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + "1";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "2":
                btn2.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + "2";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + "2";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "3":
                btn3.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + "3";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + "3";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "4":
                btn4.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + "4";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + "4";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "5":
                btn5.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + "5";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + "5";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "6":
                btn6.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + "6";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + "6";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "7":
                btn7.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + "7";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + "7";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "8":
                btn8.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + "8";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + "8";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "9":
                btn9.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + "9";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + "9";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "+":
                btnplus.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + " + ";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + " + ";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "-":
                btnminus.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + " - ";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + " - ";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "x":
                btnmultiply.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + " x ";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + " x ";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "/":
                btndivide.addActionListener(e ->
                {
                    // if equals button not pressed then keep updating jlabel
                    if (isAns == false)
                    {
                        userInputText = userInputText + " / ";
                        l.setText(userInputText);
                    }
                    // if equals button has been pressed then first reset the jlabel and then update it
                    else
                    {
                        userInputText = "";
                        userInputText = userInputText + " / ";
                        l.setText(userInputText);
                        isAns = false;
                    }
                });
                break;
            case "clear":
                // in this case we just reset the JLabel
                btnclear.addActionListener(e ->
                {
                    userInputText = "";
                    l.setText(userInputText);
                });
                break;
            case "equals":
                btnequals.addActionListener(e ->
                {   
                    // splitting by spaces, extracting the operator, and calling functions accordingly
                    // e.g. if userInputText is "2 + 5" it will be converted to [2, +, 5]
                    // if it is "- 2 + 5" it will be converted to [-, 2, +, 5] and so on
                    String[] inputs = userInputText.split(" ");
                    if (inputs.length == 3) // e.g. [2, +, 5] and similar cases then do simple calculation
                    {
                        String op = inputs[1];
                        if (op.equals("+"))
                        {
                            this.add();
                        }
                        else if (op.equals("-"))
                        {
                            this.subtract();
                        }
                        else if (op.equals("x"))
                        {
                            this.multiply();
                        }
                        else if (op.equals("/"))
                        {
                            this.divide();
                        }
                        else // case if index 1 of inputs is not a valid operator
                        {
                            userInputText = "";
                            userInputText = "Invalid arguments!";
                            l.setText(userInputText);
                            isAns = true;
                        }
                    }
                    // if user enters only a single number and presses equal button then nothing should happen
                    else if (inputs.length == 1)
                    {
                        userInputText = "";
                        userInputText = inputs[0];
                        l.setText(userInputText);
                        isAns = true;
                    }
                    // if user enters inputs such as - 2 + 5 or - 2 + + 5 or 2 + + 5 and so on
                    else if (inputs.length == 5) // e.g. [-, 2, +, 5] case and [2, +, , +, 5] case
                    {
                        // we will extract the two operators and the two numbers
                        String op1 = inputs[1];
                        String num1 = inputs[2];
                        String op2 = inputs[3];
                        String num2 = inputs[4];
                        if (num1.trim().isEmpty()) // if there is an empty space it means invalid arguments e.g. 2 + + 5 or - 2 + + 6 etc
                        {
                            userInputText = "";
                            userInputText = "Invalid arguments!";
                            l.setText(userInputText);
                            isAns = true;
                        }
                        else
                        {
                            // otherwise combine inputs such as "- 2 + 6" to "-2 + 6" etc so length becomes 3 and we can do normal calculation
                            userInputText = "";
                            userInputText = op1 + num1 + " " + op2 + " " + num2;
                            switch (op2)
                            {
                                case "+":
                                    this.add();
                                    break;
                                case "-":
                                    this.subtract();
                                    break;
                                case "x":
                                    this.multiply();
                                    break;
                                case "/":
                                    this.divide();
                                    break;
                                default:
                                    // again if op2 of inputs is not a valid operator
                                    userInputText = "";
                                    userInputText = "Invalid arguments!";
                                    l.setText(userInputText);
                                    isAns = true;
                            }
                        }
                        
                    }
                    else // any other inputs length is an invalid mathematical expression
                    {
                        userInputText = "";
                        userInputText = "Invalid arguments!";
                        l.setText(userInputText);
                        isAns = true;
                    }
                });
                break;
            default:
                // case for any other buttons (if exists)
                userInputText = "";
                userInputText = "Invalid arguments!";
                l.setText(userInputText);
                isAns = true;
        }
    }
    
    // function to initialize the JButtons of the GUI
    public void initializeJButtons()
    {
        // initializing the JButtons
        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btnplus = new JButton("+");
        btnminus = new JButton("-");
        btnmultiply = new JButton("x");
        btndivide = new JButton("/");
        btnclear = new JButton("C");
        btnequals = new JButton("=");
        
        // placing buttons onto the GUI frame
        this.placeJButton("0", 10, 410, 130, 40);
        this.placeJButton("1", 10, 350, 60, 40);
        this.placeJButton("2", 80, 350, 60, 40);
        this.placeJButton("3", 150, 350, 60, 40);
        this.placeJButton("4", 10, 290, 60, 40);
        this.placeJButton("5", 80, 290, 60, 40);
        this.placeJButton("6", 150, 290, 60, 40);
        this.placeJButton("7", 10, 230, 60, 40);
        this.placeJButton("8", 80, 230, 60, 40);
        this.placeJButton("9", 150, 230, 60, 40);
        this.placeJButton("+", 220, 290, 60, 40);
        this.placeJButton("-", 220, 170, 60, 40);
        this.placeJButton("x", 220, 230, 60, 40);
        this.placeJButton("/", 220, 110, 60, 40);
        this.placeJButton("clear", 80, 110, 60, 40);
        this.placeJButton("equals", 220, 350, 60, 100);
        
        // adding action listeners to buttons
        this.addActionListenerToJButton("0");
        this.addActionListenerToJButton("1");
        this.addActionListenerToJButton("2");
        this.addActionListenerToJButton("3");
        this.addActionListenerToJButton("4");
        this.addActionListenerToJButton("5");
        this.addActionListenerToJButton("6");
        this.addActionListenerToJButton("7");
        this.addActionListenerToJButton("8");
        this.addActionListenerToJButton("9");
        this.addActionListenerToJButton("+");
        this.addActionListenerToJButton("-");
        this.addActionListenerToJButton("x");
        this.addActionListenerToJButton("/");
        this.addActionListenerToJButton("clear");
        this.addActionListenerToJButton("equals");
    }
    
    public static void main(String[] args)
    {
        calculator calc = new calculator(); // making an instance of the calculator class
        calc.initializeJLabel(); // adding JLabel
        calc.initializeJTextField(); // adding JTextField
        calc.initializeJButtons(); // adding JButtons
    }
}
