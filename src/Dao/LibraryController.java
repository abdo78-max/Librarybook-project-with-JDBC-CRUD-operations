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
public class LibraryController {

    LibraryServices libraryServices;

    public LibraryController() {
        libraryServices = new LibraryServices();
    }

    public ArrayList<Library> viewBooks() {
        return libraryServices.viewBooks();
    }

    public int addBooks(Library library) {
        return libraryServices.addBooks(library);
    }

    public Library searchBookWithId(Library library) {
        return libraryServices.searchBookWithId(library);

    }

    public ArrayList<Library> searchBookByTitleContaining(Library library) {
        return libraryServices.searchBookByTitleContaining(library);

    }

    public int updateBook(Library library) {
        return libraryServices.updateBook(library);
    }

    public int deleteBook(Library library) {
        return libraryServices.deleteBook(library);

    }

}
