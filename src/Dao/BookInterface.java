/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.util.ArrayList;
import model.Library;

/**
 *
 * @author Compu City
 */
public interface BookInterface {

    public ArrayList<Library> viewBooks();

    public int addBooks(Library library);

    public Library searchBookWithId(Library library);

    public ArrayList<Library> searchBookByTitleContaining(Library library);

    public int updateBook(Library library);

    public int deleteBook(Library library);
}
