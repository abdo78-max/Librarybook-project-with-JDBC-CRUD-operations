/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Compu City
 */
public class Library {

    private int bookNumber;
    private String bookTitle;
    private String author;
    private String publisher;
    private String category;
    private int quantity;
    private  LocalDate datepublished;
    private String publishedCountry;

    public Library(String bookTitle, String author, String publisher, String category, int quantity, LocalDate datepublished, String publishedCountry) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.quantity = quantity;
        this.datepublished = datepublished;
        this.publishedCountry = publishedCountry;
    }

    public Library(int bookNumber, String bookTitle, String author, String publisher, int quantity, LocalDate datepublished, String category, String publishedCountry) {
        this.bookNumber = bookNumber;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.quantity = quantity;
        this.datepublished = datepublished;
        this.publishedCountry = publishedCountry;
    }

    public Library() {
    }


    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDatepublished() {
        return datepublished;
    }

    public void setDatepublished(LocalDate datepublished) {
        this.datepublished = datepublished;
    }

    public String getPublishedCountry() {
        return publishedCountry;
    }

    public void setPublishedCountry(String publishedCountry) {
        this.publishedCountry = publishedCountry;
    }

    @Override
    public String toString() {
        return "Library{" + "bookNumber=" + bookNumber + ", bookTitle=" + bookTitle + ", author=" + author + ", publisher=" + publisher + ", category=" + category + ", quantity=" + quantity + ", datepublished=" + datepublished + ", publishedCountry=" + publishedCountry + '}';
    }

}
