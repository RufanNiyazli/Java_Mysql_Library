package org.library;

public class BookService {
    private BookDAO bookDAO = new BookDAO();

    public boolean addBook(String title, String author, String genre) {
        return bookDAO.addBook(title, author, genre);
    }
}
