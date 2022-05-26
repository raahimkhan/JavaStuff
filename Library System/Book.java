/**
 * Book class to store name of book, name of author of book, and whether the book is currently borrowed by the user or not.
 * Book object will be stored inside a list.
**/

public class Book
{
    private boolean borrowed; // whether the book is borrowed or not
    private String bookName; // name of the book
    private String authorName; // name of the author of the book

    // constructor
    public Book(final String bookName, final String authorName, final boolean borrowed)
    {
        this.borrowed = borrowed;
        this.bookName = bookName;
        this.authorName = authorName;
    }
    
    // Below three functions are to get the name of book, its author, and whether the book is currently borrowed or not
    
    public String getBookName() 
    {
        return this.bookName;
    }
    
    public String getAuthorName() 
    {
        return this.authorName;
    }
    
    public boolean getBorrowed() 
    {
        return this.borrowed;
    }
    
    public void setBorrowed(final boolean b) 
    {
        this.borrowed = b;
    }
}