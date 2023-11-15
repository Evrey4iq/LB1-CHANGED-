package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Year: " + year;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void removeBookByISBN(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }
}

class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        library.addBook(new Book("The Great Gatsby", " F. Scott Fitzgerald", "9780333791035", 1925));
        library.addBook(new Book("Beloved", "Toni Morrison", "97803330305372", 1985));

        System.out.println("All books in the library:");
        library.displayBooks();

        System.out.println("\nEnter the title to search:");
        String searchTitle = scanner.nextLine();
        Book foundBook = library.searchBookByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nEnter the ISBN to remove a book:");
        String isbnToRemove = scanner.nextLine();
        library.removeBookByISBN(isbnToRemove);
        System.out.println("Book removed. Updated library:");
        library.displayBooks();
    }
}
