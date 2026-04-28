/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.util.ArrayList;
import model.Library;

/**
 *
 * @author Compu City
 */
public class LibraryServices implements BookInterface{

    private LibraryDao libraryDao;

    public LibraryServices() {
        libraryDao = new LibraryDao();
    }

    @Override
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

    @Override
    public int addBooks(Library library) {
        if (isLibraryValid(library)) {
            return libraryDao.addBooks(library);
        }
        return 0;
    }

    @Override
    public Library searchBookWithId(Library library) {
        return libraryDao.searchBookWithId(library);

    }

    @Override
    public ArrayList<Library> searchBookByTitleContaining(Library library) {
        return libraryDao.searchBookByTitleContaining(library);

    }

    @Override
    public int updateBook(Library library) {
        return libraryDao.updateBook(library);
    }

    @Override
    public int deleteBook(Library library) {
        return libraryDao.deleteBook(library);

    }

}
