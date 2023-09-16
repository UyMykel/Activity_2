/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication28;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Define a class for a book
class Book {
    String authorName;
    String bookTitle;
    String ISBN;

    public Book(String authorName, String bookTitle, String ISBN) {
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Author: " + authorName + ", Title: " + bookTitle + ", ISBN: " + ISBN;
    }
}

// Define a Library class to manage books
class Library {
    Map<String, Book> booksByISBN;
    Map<String, Book> booksByTitle;
    Map<String, Book> booksByAuthor;

    public Library() {
        booksByISBN = new HashMap<>();
        booksByTitle = new HashMap<>();
        booksByAuthor = new HashMap<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        booksByISBN.put(book.ISBN, book);
        booksByTitle.put(book.bookTitle, book);
        booksByAuthor.put(book.authorName, book);
    }

    // Find a book by ISBN
    public Book findBookByISBN(String ISBN) {
        return booksByISBN.get(ISBN);
    }

    // Find books by title
    public Book findBooksByTitle(String title) {
        return booksByTitle.get(title);
    }

    // Find books by author
    public Book findBooksByAuthor(String authorName) {
        return booksByAuthor.get(authorName);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Find a Book by ISBN");
            System.out.println("3. Find Books by Title");
            System.out.println("4. Find Books by Author");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    System.out.print("Enter author's name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(author, title, isbn));
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter ISBN to find a book: ");
                    String searchISBN = scanner.nextLine();
                    Book foundBook = library.findBookByISBN(searchISBN);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter title to find books: ");
                    String searchTitle = scanner.nextLine();
                    Book foundTitle = library.findBooksByTitle(searchTitle);
                    if (foundTitle != null) {
                        System.out.println("Book found: " + foundTitle);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter author's name to find books: ");
                    String searchAuthor = scanner.nextLine();
                    Book foundAuthor = library.findBooksByAuthor(searchAuthor);
                    if (foundAuthor != null) {
                        System.out.println("Book found: " + foundAuthor);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting Library Management System.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}