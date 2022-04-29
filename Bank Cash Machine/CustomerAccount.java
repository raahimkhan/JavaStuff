/**
 * Imports
 */
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * CustomerAccount class
 *
 * @author (your name)
 * @version 1
 */
public class CustomerAccount
{
    // Variable representing the amount of money in the customer's bank account
    private int balance;

    /**
     * Constructor for objects of class CustomerAccount
     */
    public CustomerAccount()
    {
        // Initialising balance variable
        balance = 1000;
    }

    /**
     * A method that allows additional money to be added into an account
     * @param  Takes amount to be deposited
     * @return Does not return anything. Deposits balance and adds it to original amount.
     */
    public void deposit(int amount)
    {
        this.balance = this.balance + amount;
    }
    
    /**
     * A method that allows money to be taken out of an account
     * @param  Takes amount to be withdrawn
     * @return Does not return anything. Withdraws balance and deducts it from original amount.
     */
    public void withdraw(int amount)
    {
        this.balance = this.balance - amount;
    }
    
    /**
     * A method that allows a user to check how much money is in their account
     * @param  No parameters are required
     * @return    Returns the available balance
     */
    public int checkBalance()
    {
        return this.balance;
    }
    
    /**
     * Main method to run the program
     */
    public static void main(String[] args)
    {   
        // Initialising object of CustomerAccount class
        CustomerAccount account = new CustomerAccount();
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // Initializing frame for the GUI
        JFrame frame = new JFrame ("Bank Cash Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // Panel for menu screen
        JPanel panel = new JPanel();
        // GUI components for menu screen
        JTextArea menu = new JTextArea (1, 1);
        menu.setEditable(false);
        menu.append("\n" + "                  Menu");
        JButton showbalance = new JButton ("Show balance");
        JButton withdraw = new JButton ("Withdraw");
        JButton deposit = new JButton ("Deposit");
        JButton cancel = new JButton ("Cancel");
        // GUI screen size (This will be same throughout for all the panels)
        panel.setPreferredSize (new Dimension (652, 445));
        panel.setLayout (null);
        // Adding GUI components to panel for menu screen
        panel.add(menu);
        panel.add(showbalance);
        panel.add(withdraw);
        panel.add(deposit);
        panel.add(cancel);
        // Setting GUI components bounds for menu screen
        menu.setBounds (245, 35, 180, 40);
        showbalance.setBounds (245, 90, 180, 40);
        withdraw.setBounds (245, 150, 180, 40);
        deposit.setBounds (245, 210, 180, 40);
        cancel.setBounds (245, 270, 180, 40);
        
        // Initially, menu panel will be visible
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // Panel for show balance screen
        JPanel panel2 = new JPanel();
        // GUI components for show balance screen
        JTextArea balancearea = new JTextArea (1, 1);
        balancearea.setEditable(false);
        balancearea.append("\n" + "                                 Available balance is: " + account.checkBalance() + " rupees");
        JButton backbutton1 = new JButton ("Return to menu");
        // GUI screen size (This will be same throughout for all the panels)
        panel2.setPreferredSize (new Dimension (652, 445));
        panel2.setLayout (null);
        // Adding GUI components to panel for show balance screen
        panel2.add(balancearea);
        panel2.add(backbutton1);
        // Setting GUI components bounds for show balance screen
        balancearea.setBounds (105, 125, 465, 45);
        backbutton1.setBounds (240, 200, 180, 40);
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // Panel for withdraw screen
        JPanel panel3 = new JPanel();
        // GUI components for withdraw screen
        JTextArea withdrawtextarea = new JTextArea (1, 1);
        withdrawtextarea.setEditable(false);
        withdrawtextarea.append("\n" + "       Enter amount to withdraw ");
        JTextArea withdrawamountarea = new JTextArea (1, 1);
        JButton withdrawbutton = new JButton ("Withdraw");
        JButton backbutton2 = new JButton ("Return to menu");
        // GUI screen size (This will be same throughout for all the panels)
        panel3.setPreferredSize (new Dimension (652, 445));
        panel3.setLayout (null);
        // Adding GUI components to panel for withdraw screen
        panel3.add(withdrawtextarea);
        panel3.add(withdrawamountarea);
        panel3.add(withdrawbutton);
        panel3.add(backbutton2);
        // Setting GUI components bounds for withdraw screen
        withdrawtextarea.setBounds (105, 125, 220, 45);
        withdrawamountarea.setBounds (350, 125, 120, 45);
        withdrawbutton.setBounds (205, 200, 180, 40);
        backbutton2.setBounds (205, 270, 180, 40);
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // Panel for deposit screen
        JPanel panel4 = new JPanel();
        // GUI components for deposit screen
        JTextArea deposittextarea = new JTextArea (1, 1);
        deposittextarea.setEditable(false);
        deposittextarea.append("\n" + "       Enter amount to deposit ");
        JTextArea depositamountarea = new JTextArea (1, 1);
        JButton depositbutton = new JButton ("Deposit");
        JButton backbutton3 = new JButton ("Return to menu");
        // GUI screen size (This will be same throughout for all the panels)
        panel4.setPreferredSize (new Dimension (652, 445));
        panel4.setLayout (null);
        // Adding GUI components to panel for deposit screen
        panel4.add(deposittextarea);
        panel4.add(depositamountarea);
        panel4.add(depositbutton);
        panel4.add(backbutton3);
        // Setting GUI components bounds for deposit screen
        deposittextarea.setBounds (105, 125, 220, 45);
        depositamountarea.setBounds (350, 125, 120, 45);
        depositbutton.setBounds (205, 200, 180, 40);
        backbutton3.setBounds (205, 270, 180, 40);
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // This all code below tells what happens on each button press
        
        // Show current balance on screen if "Show balance" button is pressed
        showbalance.addActionListener(e ->
        {
            // Now make panel2 the currently visible panel inside the frame
            frame.remove(panel);
            frame.setContentPane(panel2);
            frame.validate();
            frame.repaint();
        });
        // Go back to menu screen if "Return to menu" button is pressed (which is on show balance screen)
        backbutton1.addActionListener(e ->
        {
            // Now make panel the currently visible panel inside the frame
            frame.remove(panel2);
            frame.setContentPane(panel);
            frame.validate();
            frame.repaint();
        });
        
        // This will execute if "Withdraw" button is pressed
        withdraw.addActionListener(e ->
        {
            // Now make panel3 the currently visible panel inside the frame
            frame.remove(panel);
            frame.setContentPane(panel3);
            frame.validate();
            frame.repaint();
        });
        // Withdraw amount if the amount entered by user is valid and within the currently available balance
        withdrawbutton.addActionListener(e ->
        {
            String withdrawcontent = withdrawamountarea.getText(); // getting text from text field when user clicks withdraw button
            withdrawcontent = withdrawcontent.trim(); // removing leading and trailing whitespaces from the textfield input
            // checking if text field is empty
            if (withdrawcontent.equals(""))
            {
                showMessageDialog(null, "No amount entered! Please enter an amount to withdraw.");
                withdrawamountarea.setText("");
            }
            // checking if text field contains any alphabet(s)
            else if (withdrawcontent.matches(".*[a-zA-Z]+.*") == true)
            {
                showMessageDialog(null, "Alphabet(s) detected! Please enter a valid integer amount to withdraw.");
                withdrawamountarea.setText("");
            }
            // checking if text field contains spaces in between the input i.e. "1 2" or "12 3"
            else if (withdrawcontent.contains(" "))
            {
                showMessageDialog(null, "Space(s) detected! Please enter a valid integer amount to withdraw.");
                withdrawamountarea.setText("");
            }
            // checking if text field content was negative or not
            else if (Integer.parseInt(withdrawcontent) <= 0)
            {
                showMessageDialog(null, "Withdraw amount cannot be 0 or negative! Please enter a valid amount to withdraw.");
                withdrawamountarea.setText("");
            }
            // checking if text field content contains amount greater than current balance
            else if (Integer.parseInt(withdrawcontent) > account.checkBalance())
            {
                showMessageDialog(null, "Withdraw amount exceeds current balance! Please enter a valid amount to withdraw.");
                withdrawamountarea.setText("");
            }
            // Now all error checks have passed so withdraw the balance and deduct from original current amount of the user
            else
            {
                account.withdraw(Integer.parseInt(withdrawcontent));
                showMessageDialog(null, Integer.parseInt(withdrawcontent) + " rupees successfully withdrawn! Current balance: " + account.checkBalance() + " rupees.");
                // updating the text field that shows current balance in the show balance screen
                balancearea.setText("");
                balancearea.append("\n" + "                                 Available balance is: " + account.checkBalance() + " rupees");
                withdrawamountarea.setText("");
            }
        });
        // Go back to menu screen if "Return to menu" button is pressed (which is on withdraw screen)
        backbutton2.addActionListener(e ->
        {
            // Now make panel the currently visible panel inside the frame
            frame.remove(panel3);
            frame.setContentPane(panel);
            frame.validate();
            frame.repaint();
        });
        
        // This will execute if "Deposit" button is pressed
        deposit.addActionListener(e ->
        {
            // Now make panel4 the currently visible panel inside the frame
            frame.remove(panel);
            frame.setContentPane(panel4);
            frame.validate();
            frame.repaint();
        });
        // Deposit amount if the amount entered by user is valid
        depositbutton.addActionListener(e ->
        {
            String depositcontent = depositamountarea.getText(); // getting text from text field when user clicks deposit button
            depositcontent = depositcontent.trim(); // removing leading and trailing whitespaces from the textfield input
            // checking if text field is empty
            if (depositcontent.equals(""))
            {
                showMessageDialog(null, "No amount entered! Please enter an amount to deposit.");
                depositamountarea.setText("");
            }
            // checking if text field contains any alphabet(s)
            else if (depositcontent.matches(".*[a-zA-Z]+.*") == true)
            {
                showMessageDialog(null, "Alphabet(s) detected! Please enter a valid integer amount to deposit.");
                depositamountarea.setText("");
            }
            // checking if text field contains spaces in between the input i.e. "1 2" or "12 3"
            else if (depositcontent.contains(" "))
            {
                showMessageDialog(null, "Space(s) detected! Please enter a valid integer amount to deposit.");
                depositamountarea.setText("");
            }
            // checking if text field content was negative or not
            else if (Integer.parseInt(depositcontent) <= 0)
            {
                showMessageDialog(null, "Deposit amount cannot be 0 or negative! Please enter a valid amount to deposit.");
                depositamountarea.setText("");
            }
            // Now all error checks have passed so deposit the amount and add it to original current amount of the user
            else
            {
                account.deposit(Integer.parseInt(depositcontent));
                showMessageDialog(null, Integer.parseInt(depositcontent) + " rupees successfully deposited! Current balance: " + account.checkBalance() + " rupees.");
                // updating the text field that shows current balance in the show balance screen
                balancearea.setText("");
                balancearea.append("\n" + "                                 Available balance is: " + account.checkBalance() + " rupees");
                depositamountarea.setText("");
            }
        });
        // Go back to menu screen if "Return to menu" button is pressed (which is on deposit screen)
        backbutton3.addActionListener(e ->
        {
            // Now make panel the currently visible panel inside the frame
            frame.remove(panel4);
            frame.setContentPane(panel);
            frame.validate();
            frame.repaint();
        });
        
        // Exit the GUI if "Cancel" button is pressed
        cancel.addActionListener(e ->
        {
            System.exit(0);
        });
    }
}
