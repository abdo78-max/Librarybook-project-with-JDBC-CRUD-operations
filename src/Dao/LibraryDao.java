/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Library;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Compu City
 */
public class LibraryDao implements BookInterface {

    private Connection connection = null;
    private PreparedStatement preparedStatment = null;
    private ResultSet resultSet = null;
    private String sql;
    private int result;

    @Override
    public ArrayList<Library> viewBooks() {
        ArrayList<Library> library = new ArrayList<>();
        connection = (Connection) DatabaseConnection.connect();
        sql = "select * from librarybook.library";
        try {
            preparedStatment = connection.prepareStatement(sql);
            resultSet = preparedStatment.executeQuery();
            while (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("Author");
                String publisher = resultSet.getString("publisher");
                String category = resultSet.getString("category");
                int quantity = resultSet.getInt("quantity");
                LocalDate datepublished = resultSet.getDate("datepublished").toLocalDate();
                String publishedCountry = resultSet.getString("publishedcountry");
                library.add(new Library(bookId, title, author, publisher, quantity, datepublished, category, publishedCountry));
            }
            return library;
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatment != null) {
                    preparedStatment.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LibraryDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public int addBooks(Library library) {
        connection = (Connection) DatabaseConnection.connect();
        sql = " INSERT INTO librarybook.library(title,Author,publisher,category,quantity,datepublished,publishedcountry)values(?,?,?,?,?,?,?)";
        try {
            preparedStatment = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatment.setString(1, library.getBookTitle());
            preparedStatment.setString(2, library.getAuthor());
            preparedStatment.setString(3, library.getPublisher());
            preparedStatment.setString(4, library.getCategory());
            preparedStatment.setInt(5, library.getQuantity());
            preparedStatment.setDate(6, java.sql.Date.valueOf(library.getDatepublished()));
            preparedStatment.setString(7, library.getPublishedCountry());
            result = preparedStatment.executeUpdate();
            resultSet = preparedStatment.getGeneratedKeys();
            if (resultSet.next()) {
                library.setBookNumber(resultSet.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatment != null) {
                    preparedStatment.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LibraryDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public Library searchBookWithId(Library library) {
        connection = (Connection) DatabaseConnection.connect();
        sql = "SELECT * FROM librarybook.library where book_id = ?";
        try {
            preparedStatment = connection.prepareStatement(sql);
            preparedStatment.setInt(1, library.getBookNumber());
            resultSet = preparedStatment.executeQuery();
            if (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("Author");
                String publisher = resultSet.getString("publisher");
                String category = resultSet.getString("category");
                int quantity = resultSet.getInt("quantity");
                LocalDate datepublished = resultSet.getDate("datepublished").toLocalDate();
                String publishedCountry = resultSet.getString("publishedcountry");
                return new Library(bookId, title, author, publisher, quantity, datepublished, category, publishedCountry);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatment != null) {
                    preparedStatment.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LibraryDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;

    }

    @Override
    public ArrayList<Library> searchBookByTitleContaining(Library library) {
        ArrayList<Library> list = new ArrayList<>();
        connection = (Connection) DatabaseConnection.connect();
        sql = "SELECT * FROM librarybook.library where title like ?";
        try {
            preparedStatment = connection.prepareStatement(sql);
            preparedStatment.setString(1, "%" + library.getBookTitle() + "%");
            resultSet = preparedStatment.executeQuery();
            while (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("Author");
                String publisher = resultSet.getString("publisher");
                String category = resultSet.getString("category");
                int quantity = resultSet.getInt("quantity");
                LocalDate datepublished = resultSet.getDate("datepublished").toLocalDate();
                String publishedCountry = resultSet.getString("publishedcountry");
                list.add(new Library(bookId, title, author, publisher, quantity, datepublished, category, publishedCountry));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatment != null) {
                    preparedStatment.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LibraryDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public int updateBook(Library library) {
        connection = (Connection) DatabaseConnection.connect();
        sql = "UPDATE librarybook.library set title = ?, author = ?, publisher = ?, category = ?, quantity = ?,datepublished =?, publishedcountry=? WHERE book_id = ?";
        try {
            preparedStatment = connection.prepareStatement(sql);
            preparedStatment.setString(1, library.getBookTitle());
            preparedStatment.setString(2, library.getAuthor());
            preparedStatment.setString(3, library.getPublisher());
            preparedStatment.setString(4, library.getCategory());
            preparedStatment.setInt(5, library.getQuantity());
            preparedStatment.setDate(6, java.sql.Date.valueOf(library.getDatepublished()));
            preparedStatment.setString(7, library.getPublishedCountry());
            preparedStatment.setInt(8, library.getBookNumber());
            result = preparedStatment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatment != null) {
                    preparedStatment.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LibraryDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public int deleteBook(Library library) {
        connection = (Connection) DatabaseConnection.connect();
        sql = "delete from librarybook.library where book_id=?";
        try {
            preparedStatment = connection.prepareStatement(sql);
            preparedStatment.setInt(1, library.getBookNumber());
            result = preparedStatment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
