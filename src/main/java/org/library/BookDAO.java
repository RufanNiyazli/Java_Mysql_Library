package org.library;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
    public boolean addBook(String title, String author, String genre) {
        String Sql = "INSERT INTO books (title, author, genre) VALUES (?,  ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(Sql);
        ) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, genre);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showBooks() {
        String sql = "SELECT * FROM books;";
        try (Connection conn = new DatabaseConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                System.out.println(id + " " + title + " " + author + " " + genre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
