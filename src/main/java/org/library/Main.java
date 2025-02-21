package org.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome,Sir.");
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();
        BookDAO bookDAO = new BookDAO();
        boolean flag = true;
        while (flag) {
            System.out.println("Add Book-->1: Search Book-->2: Show All Books-->3: Exit-->4");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter book's name: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book's author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book's genre: ");
                    String genre = scanner.nextLine();
                    if (bookService.addBook(title, author, genre)) {
                        System.out.println("Book succesfully added...");
                    } else {
                        System.out.println("Unfournately book cant added...");
                    }
                    break;
                case 2:
                    System.out.print("Book title (can be left blank): ");
                    String searchTitle = scanner.nextLine().trim();
                    System.out.println("Author name (can be left blank): ");
                    String searchAuthor = scanner.nextLine().trim();
                    System.out.println("Genre (can be left blank): ");
                    String searchGenre = scanner.nextLine().trim();
                    bookDAO.searchBook(searchTitle,searchAuthor,searchGenre);



                    break;
                case 3:
                    bookDAO.showBooks();
                    break;


            }
        }
    }
}