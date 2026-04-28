/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import CRUDOperations.BooksTableController;
import CRUDOperations.SearchBookController;
import java.util.ArrayList;
import model.Library;

/**
 *
 * @author Compu City
 */
public class LibraryServices {

    private LibraryDao libraryDao;

    public LibraryServices() {
        libraryDao = new LibraryDao();
    }

    public ArrayList<Library> viewBooks() {
        return libraryDao.viewBooks();
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private boolean isLibraryValid(Library library) {
        return library != null
                && !isBlank(library.getBookTitle())
                && !isBlank(library.getAuthor())
                && !isBlank(library.getCategory())
                && !isBlank(library.getPublisher())
                && library.getDatepublished() != null
                && !isBlank(library.getPublishedCountry())
                && library.getQuantity() > 0;
    }

    public int addBooks(Library library) {
        if (isLibraryValid(library)) {
            return libraryDao.addBooks(library);
        }
        return 0;
    }

    public Library searchBookWithId(Library library) {
        return libraryDao.searchBookWithId(library);

    }

    public ArrayList<Library> searchBookByTitleContaining(Library library) {
        return libraryDao.searchBookByTitleContaining(library);

    }

    public int updateBook(Library library) {
        return libraryDao.updateBook(library);
    }

    public int deleteBook(Library library) {
        return libraryDao.deleteBook(library);

    }

}
