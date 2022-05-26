/** Imports **/
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

public class LibrarySystem
{
    private int copiesBorrowed; // number of distinct copies of books currently borrowed by the user (cannot be greater than 5)
    
    // Declaring 9 Book objects
    final Book b1;
    final Book b2;
    final Book b3;
    final Book b4;
    final Book b5;
    final Book b6;
    final Book b7;
    final Book b8;
    final Book b9;
    
    // Declaring list for storing Book objects
    final List<Book> books;
    
    // Declaring list for storing borrowed Books
    final List<Book> booksBorrowed;

    public LibrarySystem()
    {
        copiesBorrowed = 2; // We assume 2 copies are borrowed initially
        
        // Initializing Book objects with book name, author name, and whether borrowed or not
        // First two are true because we are assuming that the user has already borrowed two books
        b1 = new Book("Unfinished", "Priyanka Chopra Jonas", true);
        b2 = new Book("ASOCA: A Sutra", "Irwin Allan Sealy", true);
        b3 = new Book("Names of the Women", "Jeet Thayil", false);
        b4 = new Book("Whereabouts", "Jhumpa Lahiri", false);
        b5 = new Book("Sach Kahun Toh", "Neena Gupta", false);
        b6 = new Book("Home in the World", "Amartya Sen", false);
        b7 = new Book("Habba Khatoon", "Kajal Suri", false);
        b8 = new Book("The Great Big Lion", "Chryseis Knight", false);
        b9 = new Book("My Own Mazagon", "Captain Ramesh Babu", false);
        
        // Initializing new Array lists
        books = new ArrayList<>();
        booksBorrowed = new ArrayList<>();
        
        // Storing all book objects in books list
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        books.add(b7);
        books.add(b8);
        books.add(b9);
        
        // At the start we assume two books have been borrowed by the user
        booksBorrowed.add(b1);
        booksBorrowed.add(b2);
    }
    
    public static void main(final String[] args)
    {
        LibrarySystem library = new LibrarySystem(); // initializing an object of LibrarySystem
        
        // Initializing frame for the GUI
        JFrame frame = new JFrame ("Library System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // panel for welcome screen
        JPanel panel = new JPanel();
        
        // Components for displaying Welcome on the first screen
        JTextArea welcomeScreen = new JTextArea (5, 5);
        welcomeScreen.setEnabled(false);
        welcomeScreen.setText("Welcome to the Library System!");
        Font font1 = new Font("Verdana", Font.BOLD, 16);
        welcomeScreen.setFont(font1);
        
        panel.setPreferredSize (new Dimension (648, 445));
        panel.setLayout (null);
        
        panel.add(welcomeScreen);
        
        welcomeScreen.setBounds (185, 185, 295, 30);
        
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        try {
            TimeUnit.SECONDS.sleep(2); // Wait for 2 seconds and then show the menu screen
        } catch (Exception ex) {
            
        }
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // panel for menu screen
        
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize (new Dimension (648, 445));
        panel2.setLayout (null);
        
        JTextArea menu = new JTextArea (1, 1);
        menu.setEditable(false);
        menu.append("\n" + "                  Menu");
        JButton catalogue = new JButton ("Show catalogue");
        JButton availableAuthors = new JButton ("List all available authors in the library");
        JButton BooksBorrowed = new JButton ("Show books borrowed");
        JButton borrowBook = new JButton ("Borrow a new book");
        JButton cancel = new JButton ("Cancel");
        
        panel2.add(menu);
        panel2.add(catalogue);
        panel2.add(availableAuthors);
        panel2.add(BooksBorrowed);
        panel2.add(borrowBook);
        panel2.add(cancel);
        
        menu.setBounds (245, 35, 180, 40);
        catalogue.setBounds (245, 90, 180, 40);
        availableAuthors.setBounds (245, 150, 250, 40);
        BooksBorrowed.setBounds (245, 210, 180, 40);
        borrowBook.setBounds (245, 270, 180, 40);
        cancel.setBounds (245, 330, 180, 40);
        
        // Removing welcome screen and making menu screen the visible panel inside the jframe
        frame.remove(panel);
        frame.setContentPane(panel2);
        frame.validate();
        frame.repaint();
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // panel for catalogue screen
        
        JPanel panel3 = new JPanel();
        panel3.setPreferredSize (new Dimension (648, 445));
        panel3.setLayout (null);
        
        JTextArea catalogueScreen = new JTextArea (5, 5);
        catalogueScreen.setEnabled (false);
        catalogueScreen.setEditable(false);
        catalogueScreen.append("          Catalogue");
        panel3.add(catalogueScreen);
        catalogueScreen.setBounds (245, 65, 160, 30);
        
        JButton backbutton1 = new JButton ("Back");
        panel3.add(backbutton1);
        backbutton1.setBounds (30, 365, 125, 35);
        
        // we loop over the books list and for each book object we create a JTextArea and add book name to it
        // we then add that jtextarea to panel3
        int counter = 0;
        for (final Book b : library.books) {
            JTextArea currentBook = new JTextArea (5, 5);
            currentBook.setEnabled (false);
            currentBook.append("     " + b.getBookName());
            panel3.add(currentBook);
            if (counter == 0)
                currentBook.setBounds (65, 135, 160, 30);
            else if (counter == 1)
                currentBook.setBounds (65, 190, 160, 30);
            else if (counter == 2)
                currentBook.setBounds (65, 255, 160, 30);
            else if (counter == 3)
                currentBook.setBounds (250, 135, 160, 30);
            else if (counter == 4)
                currentBook.setBounds (250, 255, 160, 30);
            else if (counter == 5)
                currentBook.setBounds (250, 190, 160, 30);
            else if (counter == 6)
                currentBook.setBounds (440, 135, 165, 30);
            else if (counter == 7)
                currentBook.setBounds (435, 255, 185, 30);
            else if (counter == 8)
                currentBook.setBounds (440, 190, 170, 30);
            else
                break;
            counter = counter + 1;
        }
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // panel for listing all available authors in the library
        
        JPanel panel4 = new JPanel();
        panel4.setPreferredSize (new Dimension (648, 445));
        panel4.setLayout (null);
        
        JTextArea authorScreen = new JTextArea (5, 5);
        authorScreen.setEnabled (false);
        authorScreen.setEditable(false);
        authorScreen.append("      Available Authors");
        panel4.add(authorScreen);
        authorScreen.setBounds (245, 65, 160, 30);
        
        JButton backbutton2 = new JButton ("Back");
        panel4.add(backbutton2);
        backbutton2.setBounds (30, 365, 125, 35);
        
        // we loop over the books list and for each book object we create a JTextArea and add author name to it
        // we then add that jtextarea to panel4
        counter = 0;
        for (final Book b : library.books) {
            JTextArea currentAuthor = new JTextArea (5, 5);
            currentAuthor.setEnabled (false);
            currentAuthor.append("     " + b.getAuthorName());
            panel4.add(currentAuthor);
            if (counter == 0)
                currentAuthor.setBounds (65, 135, 160, 30);
            else if (counter == 1)
                currentAuthor.setBounds (65, 190, 160, 30);
            else if (counter == 2)
                currentAuthor.setBounds (65, 255, 160, 30);
            else if (counter == 3)
                currentAuthor.setBounds (250, 135, 160, 30);
            else if (counter == 4)
                currentAuthor.setBounds (250, 255, 160, 30);
            else if (counter == 5)
                currentAuthor.setBounds (250, 190, 160, 30);
            else if (counter == 6)
                currentAuthor.setBounds (440, 135, 165, 30);
            else if (counter == 7)
                currentAuthor.setBounds (435, 255, 185, 30);
            else if (counter == 8)
                currentAuthor.setBounds (440, 190, 170, 30);
            else
                break;
            counter = counter + 1;
        }
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // panel for listing books borrowed by the user
        // it should be noted that since this is not hard coded so every time the user clicks on books borrowed button
        // a for loop will run over the borrowedBooks list and print contents on the GUI accordingly
        
        JPanel panel5 = new JPanel();
        panel5.setPreferredSize (new Dimension (648, 445));
        panel5.setLayout (null);
        
        JTextArea borrowedScreen = new JTextArea (5, 5);
        borrowedScreen.setEnabled (false);
        borrowedScreen.setEditable(false);
        borrowedScreen.append("      Books Borrowed");
        panel5.add(borrowedScreen);
        borrowedScreen.setBounds (245, 65, 160, 30);
        
        JButton backbutton3 = new JButton ("Back");
        panel5.add(backbutton3);
        backbutton3.setBounds (30, 365, 125, 35);
            
        //////////////////////////////////////////////////////////////////////////////////////
        
        // panel for listing borrow a new book screen
        
        JPanel panel6 = new JPanel();
        panel6.setPreferredSize (new Dimension (648, 445));
        panel6.setLayout (null);
        
        JTextArea borrowBookScreen = new JTextArea (5, 5);
        borrowBookScreen.setEnabled (false);
        borrowBookScreen.setEditable(false);
        borrowBookScreen.append("      Books A New Book");
        panel6.add(borrowBookScreen);
        borrowBookScreen.setBounds (245, 65, 160, 30);
        
        JButton backbutton4 = new JButton ("Back");
        panel6.add(backbutton4);
        backbutton4.setBounds (30, 365, 125, 35);
        
        counter = 0;
        for (final Book b : library.books) {
            // first the for loop will loop over the books list and display all books available in the form of JButton
            JButton currentBook = new JButton (b.getBookName());
            panel6.add(currentBook);
            if (counter == 0)
                currentBook.setBounds (65, 135, 160, 30);
            else if (counter == 1)
                currentBook.setBounds (65, 190, 160, 30);
            else if (counter == 2)
                currentBook.setBounds (65, 255, 160, 30);
            else if (counter == 3)
                currentBook.setBounds (250, 135, 160, 30);
            else if (counter == 4)
                currentBook.setBounds (250, 255, 160, 30);
            else if (counter == 5)
                currentBook.setBounds (250, 190, 160, 30);
            else if (counter == 6)
                currentBook.setBounds (440, 135, 165, 30);
            else if (counter == 7)
                currentBook.setBounds (435, 255, 185, 30);
            else if (counter == 8)
                currentBook.setBounds (440, 190, 170, 30);
            else
                break;
            counter = counter + 1;
            
            // next we side by side add action listener to each jbutton
            currentBook.addActionListener(e ->
            {
                // if total books borrowed are 5, we simply display the error message
                if (library.copiesBorrowed == 5) {
                    showMessageDialog(null, "You have borrowed 5 books! You cannot borrow any more books.");
                }
                else {
                    String bookName = currentBook.getText(); // get book name which is a string from current JButton
                    int count = 0;
                    // there are total 9 books so loop will run from 0 to 8
                    while (count <= 8) {
                        String currBook = library.books.get(count).getBookName(); // book name at index "count" of the books list
                        String currAuthor = library.books.get(count).getAuthorName(); // suthor name at index "count" of the books list
                        // if both books name match then we do further operations
                        if (currBook == bookName) {
                            // if not borrowed then mark book as borrowed and add it to borrowed books list and increment counter for number of books borrowed
                            // finally display success message
                            if (library.books.get(count).getBorrowed() == false) {
                                library.books.set(count, new Book(currBook, currAuthor,true));
                                library.booksBorrowed.add(new Book(currBook, currAuthor,true));
                                library.copiesBorrowed = library.copiesBorrowed + 1;
                                showMessageDialog(null, "Book borrowed and added to borrowed books list");
                            }
                            // if already borrowed display error message
                            else {
                                showMessageDialog(null, "This book is already borrowed!");
                            }
                        }
                        count = count + 1;
                    }
                }
            });
        }
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // Display the catalogue screen if show catalogue button is pressed
        catalogue.addActionListener(e ->
        {
            // Now make panel3 the currently visible panel inside the frame
            frame.remove(panel2);
            frame.setContentPane(panel3);
            frame.validate();
            frame.repaint();
        });
        
        // Display the menu screen again if back button on catalogue screen is pressed
        backbutton1.addActionListener(e ->
        {
            // Now make panel2 the currently visible panel inside the frame
            frame.remove(panel3);
            frame.setContentPane(panel2);
            frame.validate();
            frame.repaint();
        });
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // Display the authors present in library screen if "List all available authors in the library" button is pressed
        availableAuthors.addActionListener(e ->
        {
            // Now make panel4 the currently visible panel inside the frame
            frame.remove(panel2);
            frame.setContentPane(panel4);
            frame.validate();
            frame.repaint();
        });
        
        // Display the menu screen again if back button on available authors in library screen is pressed
        backbutton2.addActionListener(e ->
        {
            // Now make panel2 the currently visible panel inside the frame
            frame.remove(panel4);
            frame.setContentPane(panel2);
            frame.validate();
            frame.repaint();
        });
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // Display the books borrowed screen if show books borrowed button is pressed
        BooksBorrowed.addActionListener(e ->
        {
            // every time books borrowed button is pressed, this loop will run over borrowed books list and print all book names
            // maximum books printed can be 5 and hence counter can be from 0 to 4 only
            int counter2 = 0;
            for (final Book b : library.booksBorrowed) {
                JTextArea currentBorrow = new JTextArea (5, 5);
                currentBorrow.setEnabled (false);
                currentBorrow.append("     " + b.getBookName());
                panel5.add(currentBorrow);
                if (counter2 == 0)
                    currentBorrow.setBounds (65, 135, 160, 30);
                else if (counter2 == 1)
                    currentBorrow.setBounds (65, 190, 160, 30);
                else if (counter2 == 2)
                    currentBorrow.setBounds (65, 255, 160, 30);
                else if (counter2 == 3)
                    currentBorrow.setBounds (250, 135, 160, 30);
                else if (counter2 == 4)
                    currentBorrow.setBounds (250, 255, 160, 30);
                else
                    break;
                counter2 = counter2 + 1;
            }
            // Now make panel5 the currently visible panel inside the frame
            frame.remove(panel2);
            frame.setContentPane(panel5);
            frame.validate();
            frame.repaint();
        });
        
        // Display the menu screen again if back button on show books borrowed screen is pressed
        backbutton3.addActionListener(e ->
        {
            // Now make panel2 the currently visible panel inside the frame
            frame.remove(panel5);
            frame.setContentPane(panel2);
            frame.validate();
            frame.repaint();
        });
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // Display the borrow a new book screen
        borrowBook.addActionListener(e ->
        {
            // Now make panel6 the currently visible panel inside the frame
            frame.remove(panel2);
            frame.setContentPane(panel6);
            frame.validate();
            frame.repaint();
        });
        
        // Display the menu screen again if back button on display a borrow new book screen is pressed
        backbutton4.addActionListener(e ->
        {
            // Now make panel2 the currently visible panel inside the frame
            frame.remove(panel6);
            frame.setContentPane(panel2);
            frame.validate();
            frame.repaint();
        });
        
        //////////////////////////////////////////////////////////////////////////////////////
        
        // Exit the GUI if "Cancel" button is pressed
        
        cancel.addActionListener(e ->
        {
            System.exit(0);
        });
        
        //////////////////////////////////////////////////////////////////////////////////////
    }
}
