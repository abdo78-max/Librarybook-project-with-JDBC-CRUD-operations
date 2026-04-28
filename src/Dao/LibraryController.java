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
public class LibraryController implements BookInterface{

    LibraryServices libraryServices;

    public LibraryController() {
        libraryServices = new LibraryServices();
    }

    @Override
    public ArrayList<Library> viewBooks() {
        return libraryServices.viewBooks();
    }

    @Override
    public int addBooks(Library library) {
        return libraryServices.addBooks(library);
    }

    @Override
    public Library searchBookWithId(Library library) {
        return libraryServices.searchBookWithId(library);

    }

    @Override
    public ArrayList<Library> searchBookByTitleContaining(Library library) {
        return libraryServices.searchBookByTitleContaining(library);

    }

    @Override
    public int updateBook(Library library) {
        return libraryServices.updateBook(library);
    }

    @Override
    public int deleteBook(Library library) {
        return libraryServices.deleteBook(library);

    }

}
